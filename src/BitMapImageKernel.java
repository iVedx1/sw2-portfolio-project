import components.standard.Standard;

/**
 * Kernel interface for {@code BitMapImage} with primary methods.
 *
 * @author Vedant Rakhonde
 */
public interface BitMapImageKernel extends Standard<BitMapImage1> {

    /**
     * Sets the pixel at (x, y) to the specified color. The color should be an
     * integer in the range 0-255, where 0 is black and 255 is white.
     *
     * @param x
     *            x-coordinate of the pixel
     * @param y
     *            y-coordinate of the pixel
     * @param color
     *            the color to set the pixel to (0-255)
     * @return the original color of the pixel at (x, y) before it was changed
     * @ensures the pixel at (x, y) is set to the specified color and returns
     *          the original color
     */
    int setPixel(int x, int y, int color);

    /**
     * Returns the color of the pixel at (x, y) as an integer in the range
     * 0-255.
     *
     * @param x
     *            x-coordinate of the pixel
     * @param y
     *            y-coordinate of the pixel
     * @return the color of the pixel at (x, y) (0-255)
     * @ensures returns the color of the pixel at (x, y) as an integer in the
     *          range 0-255
     */
    int getPixel(int x, int y);

    /**
     * Returns the width of the bitmap.
     *
     * @return the width of the bitmap
     * @ensures returns the width of the bitmap
     */
    int getWidth();

    /**
     * Returns the height of the bitmap.
     *
     * @return the height of the bitmap
     * @ensures returns the height of the bitmap
     */
    int getHeight();

}
