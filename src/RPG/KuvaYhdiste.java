package RPG;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Luo annetuista kuvista yhdisteen siten että päälimmäisestä kuvasta näkee puhtaan vihreän läpi (0x00FF00)
 * @author Lauri
 */
public class KuvaYhdiste {

    /**
     * Konstruktori ei tee mitään
     */
    public KuvaYhdiste() {
    }

    /**
     * Yhdistää huoneen kuvan ja huoneessa olevan vihollisen kuvan kuvaksi vihuYhdiste.png
     * @param background Huonenäkymää vastaava kuva
     * @param missa Huone, jossa olevasta vihollisesta halutaan kuva
     * @throws IOException
     */
    public void vihuYhdiste(BufferedImage background, Huone missa) throws IOException {
        BufferedImage layer = ImageIO.read(new File(missa.getVihollinen().getPolku()));
        yhdista(background, layer);
        ImageIO.write(background, "PNG", new File("vihuYhdiste.png"));
    }

    /**
     * Yhdistää huoneen kuvan ja huoneessa olevan arkun kuvan kuvaksi arkkuYhdiste.png
     * @param background Huonenäkymää vastaava kuva
     * @throws IOException
     */
    public void arkkuYhdiste(BufferedImage background) throws IOException {
        BufferedImage layer = ImageIO.read(new File("Kuvat\\Arkku.png"));
        yhdista(background, layer);
        ImageIO.write(background, "PNG", new File("arkkuYhdiste.png"));
    }

    private void yhdista(BufferedImage background, BufferedImage layer) {
        WritableRaster raster = background.getRaster();
        int width = layer.getWidth();
        int height = layer.getHeight();
        int shiftX = 360 - width / 2;
        int shiftY = 360 - height / 2;
        int lPixel, red, green, blue;
        for (int w = 0; w < width; w++) {
            for (int h = 0; h < height; h++) {
                lPixel = layer.getRGB(w, h);
                if ((lPixel & 0x00FFFFFF) != 0x00FF00) {
                    red = (int) ((lPixel & 0x00FF0000) >>> 16);
                    green = (int) ((lPixel & 0x0000FF00) >>> 8);
                    blue = (int) (lPixel & 0x000000FF);

                    raster.setPixel(w + shiftX, h + shiftY, new int[]{red, green, blue, 255});
                }
            }
        }
    }
}
