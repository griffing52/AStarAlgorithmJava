package pathfinder.lib;

import java.util.Arrays;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageToArray {
    private static BufferedImage buffImg;
    private static int[][] img;

    public static void main(String[] args) throws IOException {
        buffImg = ImageIO.read(ImageToArray.class.getResource("path.png"));
        byte[] pixels = ((DataBufferByte) buffImg.getRaster().getDataBuffer()).getData();
        System.out.println(pixels.length);
        Color color = new Color(pixels[3] & 0xFF, pixels[4] & 0xFF, pixels[5] & 0xFF);
        System.out.println(color.getRed() + ", " + color.getGreen() + ", " + color.getBlue());
    }

    // public ImageToArray(String path) throws IOException {
    //     buffImg = ImageIO.read(ImageToArray.class.getResource(path));
    //     byte[] pixels = ((DataBufferByte) buffImg.getRaster().getDataBuffer()).getData();
    //     System.out.println(pixels);
    // }
}
