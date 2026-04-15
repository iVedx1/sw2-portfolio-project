import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber1L;

/**
 * {@code BitMapImage} represented as a 2D array of {@code NaturalNumber}.
 *
 * Convention: {@code grid[y][x]} stores the color of pixel {@code (x, y)}. The
 * bitmap dimensions are tracked by {@code width} and {@code height}, and valid
 * colors use the standard 8-bit grayscale range.
 *
 * Correspondence: {@code width} is the number of columns in the grid,
 * {@code height} is the number of rows in the grid, and the value stored in
 * {@code grid[y][x]} is the color of pixel {@code (x, y)}.
 *
 * @author Vedant Rakhonde
 */
public class BitMapImage1 extends BitMapImageSecondary {

    /**
     * Maximum grayscale color value for one pixel.
     */
    private static final int MAX_COLOR = (1 << Byte.SIZE) - 1;
    // bit manipulation to compute 2^8 - 1, which is 255

    /**
     * 2D array of {@code NaturalNumber}s representing the bitmap.
     */
    private NaturalNumber[][] grid;

    /**
     * Width of the bitmap.
     */
    private int width;

    /**
     * Height of the bitmap.
     */
    private int height;

    /**
     * Creates a new empty {@code BitMapImage}.
     */
    public BitMapImage1() {
        this(0, 0);
    }

    /**
     * Creates a new {@code BitMapImage} with the given width and height. All
     * pixels are initialized to black (0).
     *
     * @param width
     * @param height
     */
    public BitMapImage1(int width, int height) {
        assert width >= 0 : "Violation of: width is nonnegative";
        assert height >= 0 : "Violation of: height is nonnegative";

        this.width = width;
        this.height = height;
        this.grid = new NaturalNumber[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                this.grid[i][j] = new NaturalNumber1L(0);
            }
        }
    }

    /**
     * Sets the pixel at (x, y) to the specified color. The color should be an
     * integer in the standard 8-bit grayscale range.
     *
     * @param x
     *            the x-coordinate of the pixel
     * @param y
     *            the y-coordinate of the pixel
     * @param color
     *            the color to set the pixel to
     * @return the original color of the pixel at (x, y) before it was changed
     */
    @Override
    public int setPixel(int x, int y, int color) {
        assert 0 <= x && x < this.width : "Violation of: x is in range";
        assert 0 <= y && y < this.height : "Violation of: y is in range";
        assert 0 <= color
                && color <= MAX_COLOR : "Violation of: color is in range";

        int originalColor = this.grid[y][x].toInt();
        this.grid[y][x].setFromInt(color);
        return originalColor;
    }

    /**
     * Returns the color of the pixel at (x, y) as an integer in the standard
     * 8-bit grayscale range.
     *
     * @param x
     *            the x-coordinate of the pixel
     * @param y
     *            the y-coordinate of the pixel
     * @return the color of the pixel at (x, y)
     */
    @Override
    public int getPixel(int x, int y) {
        assert 0 <= x && x < this.width : "Violation of: x is in range";
        assert 0 <= y && y < this.height : "Violation of: y is in range";

        return this.grid[y][x].toInt();
    }

    /**
     * Returns the width of the bitmap.
     *
     * @return the width of the bitmap
     */
    @Override
    public int getWidth() {
        return this.width;
    }

    /**
     * Returns the height of the bitmap.
     *
     * @return the height of the bitmap
     */
    @Override
    public int getHeight() {
        return this.height;
    }

    /**
     * Clears the bitmap to its initial empty state.
     *
     */
    @Override
    public void clear() {
        this.grid = new NaturalNumber[0][0];
        this.width = 0;
        this.height = 0;
    }

    /**
     * Replaces the state of this bitmap with that of {@code source}.
     *
     * @param source
     *            the bitmap to transfer from
     */
    @Override
    public void transferFrom(BitMapImage1 source) {
        assert source != null : "Violation of: source is not null";
        assert source != this : "Violation of: source is not this";

        this.grid = source.grid;
        this.width = source.width;
        this.height = source.height;
        source.clear();
    }

    /**
     * Creates a new empty bitmap of the same dynamic type.
     *
     * @return a new empty bitmap
     */
    @Override
    public BitMapImage1 newInstance() {
        return new BitMapImage1();
    }

    /**
     * Main method for testing the BitMapImage class.
     *
     * @param args
     */
    public static void main(String[] args) {
        final int five = 5;
        final int four = 4;
        final int three = 3;
        final int two = 2;

        final int oneTwentyEight = 128;
        final int white = Byte.toUnsignedInt((byte) -1);

        BitMapImage1 image = new BitMapImage1(five, three);

        image.setPixel(0, 0, white); // Set top-left pixel to white
        image.setPixel(four, two, oneTwentyEight); // Set bottom-right pixel to gray

        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                System.out.print(image.getPixel(x, y) + " ");
            }
            System.out.println();
        }

        image.clearCanvas();

        System.out.println("After clearing:");
        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                System.out.print(image.getPixel(x, y) + " ");
            }
            System.out.println();
        }
    }

}
