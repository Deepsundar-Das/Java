import java.awt.image.BufferedImage;
import java.io.File;
// import java.io.IO;
import java.io.IOException;
import javax.imageio.ImageIO;

class Image {

    public static void main(String[] arr) {
        File image = new File("/home/zen/Downloads/photo.jpeg");
        BufferedImage im = null;

        try {
            im = ImageIO.read(image);
            File output = new File("my_image.jpeg");
            ImageIO.write(im, "JPEG", output);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            im.flush();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
