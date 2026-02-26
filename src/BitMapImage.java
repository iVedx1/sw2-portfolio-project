import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber1L;

/**
 * {@code BitMap} represented as a 2D array of {@code NaturalNumber}.
 *
 * @author Vedant Rakhonde
 */
class BitMapImage {

    /**
     * 2D array of {@code NaturalNumber}s representing the bitmap. Invariant:
     * Each element of grid is a {@code NaturalNumber} that is a color 0-255.
     */
    private NaturalNumber[][] grid;

    /**
     * Creates a new {@code BitMapImage} with the given width and height. All
     * pixels are initialized to black (0).
     *
     * @param width
     * @param height
     */
    BitMapImage(int width, int height) {
        this.grid = new NaturalNumber[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                // Initialize all pixels to black (0)
                this.grid[i][j] = new NaturalNumber1L(0);
            }
        }
    }

    /**
     * Clears the bitmap by setting all pixels to black (0).
     */
    void clear() {
        for (int i = 0; i < this.grid.length; i++) {
            for (int j = 0; j < this.grid[i].length; j++) {
                // Set all pixels to black (0)
                this.grid[i][j].setFromInt(0);
            }
        }
    }

    /**
     * Sets the pixel at (x, y) to the specified color. The color should be an
     * integer in the range 0-255, where 0 is black and 255 is white.
     *
     * @param x
     *            the x-coordinate of the pixel
     * @param y
     *            the y-coordinate of the pixel
     * @param color
     *            the color to set the pixel to (0-255)
     * @return the original color of the pixel at (x, y) before it was changed
     */
    public int setPixel(int x, int y, int color) {
        // Save the original color of the pixel at (x, y)
        int originalColor = this.grid[y][x].toInt();
        // Set the pixel at (x, y) to the specified color
        this.grid[y][x].setFromInt(color);
        return originalColor;
    }

    /**
     * Returns the color of the pixel at (x, y) as an integer in the range
     * 0-255.
     *
     * @param x
     *            the x-coordinate of the pixel
     * @param y
     *            the y-coordinate of the pixel
     * @return the color of the pixel at (x, y) as an integer in the range 0-255
     */
    public int getPixel(int x, int y) {
        // Return the color of the pixel at (x, y)
        return this.grid[y][x].toInt();
    }

    /**
     * Returns the width of the bitmap.
     *
     * @return the width of the bitmap
     */
    public int getWidth() {
        // Return the width of the bitmap
        return this.grid[0].length;
    }

    /**
     * Returns the height of the bitmap.
     *
     * @return the height of the bitmap
     */
    public int getHeight() {
        // Return the height of the bitmap
        return this.grid.length;
    }

    /**
     * Main method for testing the BitMapImage class.
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create a new BitMapImage with width 5 and height 3
        final int five = 5;
        final int four = 4;
        final int three = 3;
        final int two = 2;

        final int oneTwentyEight = 128;
        final int twoFiftyFive = 255;

        BitMapImage image = new BitMapImage(five, three);

        // Set some pixels to different colors
        image.setPixel(0, 0, twoFiftyFive); // Set top-left pixel to white
        image.setPixel(four, two, oneTwentyEight); // Set bottom-right pixel to gray

        // Print the colors of the pixels
        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                System.out.print(image.getPixel(x, y) + " ");
            }
            System.out.println();
        }

        // Clear the bitmap
        image.clear();

        // Print the colors of the pixels after clearing
        System.out.println("After clearing:");
        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                System.out.print(image.getPixel(x, y) + " ");
            }
            System.out.println();
        }
    }

}
