/**
 * Use case 2: render a simple striped flag pattern using row-level operations.
 *
 * @author Vedant Rakhonde
 */
public final class BitMapImageFlagRendererDemo {

    /**
     * Utility class constructor.
     */
    private BitMapImageFlagRendererDemo() {
    }

    /**
     * Creates a simple three-stripe flag and adds a vertical accent stripe.
     *
     * @param args
     *            command-line arguments (unused)
     */
    public static void main(String[] args) {
        final int width = 9;
        final int height = 6;

        final int dark = 40;
        final int mid = 128;
        final int light = 220;
        final int accent = 255;

        BitMapImage image = new BitMapImage1(width, height);

        int[] topStripe = repeat(width, dark);
        int[] middleStripe = repeat(width, mid);
        int[] bottomStripe = repeat(width, light);

        for (int y = 0; y < 2; y++) {
            image.setRow(y, topStripe);
        }
        for (int y = 2; y < 4; y++) {
            image.setRow(y, middleStripe);
        }
        for (int y = 4; y < 6; y++) {
            image.setRow(y, bottomStripe);
        }

        image.setColumn(1, repeat(height, accent));

        System.out.println("Rendered flag pattern:");
        System.out.println(image);
    }

    /**
     * Creates an array filled with the same value.
     *
     * @param length
     *            desired array length
     * @param value
     *            repeated value
     * @return an array of the requested length containing only value
     */
    private static int[] repeat(int length, int value) {
        int[] data = new int[length];
        for (int i = 0; i < data.length; i++) {
            data[i] = value;
        }
        return data;
    }
}
