/**
 * Use case 1: generate and transform a grayscale gradient image.
 *
 * @author Vedant Rakhonde
 */
public final class BitMapImageGradientDemo {

    /**
     * Utility class constructor.
     */
    private BitMapImageGradientDemo() {
    }

    /**
     * Builds a horizontal grayscale gradient and then applies a binary
     * threshold.
     *
     * @param args
     *            command-line arguments (unused)
     */
    public static void main(String[] args) {
        final int width = 8;
        final int height = 4;
        final int white = 255;
        final int threshold = 128;

        BitMapImage image = new BitMapImage1(width, height);

        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                int gray = (x * white) / (width - 1);
                image.setPixel(x, y, gray);
            }
        }

        System.out.println("Original gradient:");
        System.out.println(image);

        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                int pixel = image.getPixel(x, y);
                int binary = pixel >= threshold ? white : 0;
                image.setPixel(x, y, binary);
            }
        }

        System.out.println("Thresholded image:");
        System.out.println(image);
    }
}
