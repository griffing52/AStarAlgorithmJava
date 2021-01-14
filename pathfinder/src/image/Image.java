package pathfinder.src.image;

import java.awt.image.BufferedImage;
import java.awt.Color;
// import java.util.Arrays;

import javax.imageio.ImageIO;

import java.io.File;
import java.io.IOException;

public class Image {
    private BufferedImage buffImg;
    public int height, width;

    public Image(int[][] arr) throws IOException {
        buffImg = new BufferedImage(arr[0].length, arr.length, BufferedImage.TYPE_INT_RGB);
        height = arr.length;
        width = arr[0].length;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                buffImg.setRGB(i, j, intToColor(arr[j][i]));
            }
        }

        File file = new File("path.png");
        ImageIO.write(buffImg, "png", file);
        // Arrays.asList(arr)
        //     .stream()
        //     .forEach(x -> );
    }
    private int intToColor(int x) {
        Color color;
        if (x == 1) {
            color = new Color(0, 0, 0);
        } else if (x == 2) {
            color = new Color(255, 0, 0);
        } else if (x == 3) {
            color = new Color(0, 0, 255);
        } else if (x == 4) {
            color = new Color(0, 255, 0);
        } else {
            color = new Color(255, 255, 255);
        }
        return color.getRGB();
    }
}
