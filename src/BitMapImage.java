/**
 * Enhanced BitMapImage interface with extra methods.
 *
 * @author Vedant Rakhonde
 */
public interface BitMapImage extends BitMapImageKernel {

    /**
     * Clears the bitmap by setting all pixels to black (0).
     *
     * @ensures all pixels x=0...width-1, y=0...height-1 in the bitmap are set
     *          to black (0)
     */
    void clearCanvas();

    /**
     * Sets the pixels in row y to the specified colors. The colors should be
     * integers in the range 0-255, where 0 is black and 255 is white.
     *
     * @param y
     *            the y-coordinate of the row to set
     * @param colors
     *            the colors to set the pixels in row y to (0-255)
     * @ensures for all x=0...width-1, the pixel at (x, y) is set to colors[x]
     */
    void setRow(int y, int[] colors);

    /**
     * Sets the pixels in column x to the specified colors. The colors should be
     * integers in the range 0-255, where 0 is black and 255 is white.
     *
     * @param x
     *            the x-coordinate of the column to set
     * @param colors
     *            the colors to set the pixels in column x to (0-255)
     * @ensures for all y=0...height-1, the pixel at (x, y) is set to colors[y]
     */
    void setColumn(int x, int[] colors);

    /**
     * Sets the size of the bitmap to the specified width and height. All pixels
     * are initialized to black (0).
     *
     * @param width
     *            the new width of the bitmap
     * @param height
     *            the new height of the bitmap
     * @ensures the bitmap is resized to the specified width and height, and all
     *          pixels are initialized to black (0)
     */
    void setSize(int width, int height);
}
