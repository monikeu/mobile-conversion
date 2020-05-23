import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

public class Converter {
    public static void main(String[] args) throws IOException {
        Converter converter = new Converter();
        long start = System.currentTimeMillis();
        converter.convert(args[0]);
        long time = System.currentTimeMillis() - start;
        System.out.write(String.valueOf(time).getBytes());

    }

    void convert(String filename) {
        File inputFile = new File(filename);
        File outputFile = new File( filename.replace("png", "jpg"));
        try (InputStream is = new FileInputStream(inputFile)) {
            BufferedImage image = ImageIO.read(is);
            try (OutputStream os= new FileOutputStream(outputFile)) {
                ImageIO.write(image, "jpg", os);
            } catch (Exception exp) {
                exp.printStackTrace();
            }
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }
}
