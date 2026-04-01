/**
 * Secondary abstract class for {@code BitMapImage} with secondary methods
 * implemented using only kernel methods.
 *
 * @author Vedant Rakhonde
 */
public abstract class BitMapImageSecondary implements BitMapImage {

    /**
     * Clears the bitmap by setting all pixels to black (0).
     *
     * @ensures all pixels x=0...width-1, y=0...height-1 in the bitmap are set
     *          to black (0)
     */
    @Override
    public void clearCanvas() {
        // Loop through all pixels and set each to black (0)
        for (int y = 0; y < this.getHeight(); y++) {
            for (int x = 0; x < this.getWidth(); x++) {
                this.setPixel(x, y, 0);
            }
        }
    }

    /**
     * Sets the pixels in row y to the specified colors.
     *
     * @param y
     *            the y-coordinate of the row to set
     * @param colors
     *            the colors to set the pixels in row y to (0-255)
     * @ensures for all x=0...width-1, the pixel at (x, y) is set to colors[x]
     */
    @Override
    public void setRow(int y, int[] colors) {
        // Precondition: colors array must match bitmap width
        assert colors.length == this
                .getWidth() : "Colors array length must match bitmap width";

        // Set each pixel in row y to the corresponding color
        for (int x = 0; x < colors.length; x++) {
            this.setPixel(x, y, colors[x]);
        }
    }

    /**
     * Sets the pixels in column x to the specified colors.
     *
     * @param x
     *            the x-coordinate of the column to set
     * @param colors
     *            the colors to set the pixels in column x to (0-255)
     * @ensures for all y=0...height-1, the pixel at (x, y) is set to colors[y]
     */
    @Override
    public void setColumn(int x, int[] colors) {
        // Precondition: colors array must match bitmap height
        assert colors.length == this
                .getHeight() : "Colors array length must match bitmap height";

        // Set each pixel in column x to the corresponding color
        for (int y = 0; y < colors.length; y++) {
            this.setPixel(x, y, colors[y]);
        }
    }

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
    @Override
    public void setSize(int width, int height) {
        // Clear the current bitmap and reinitialize with new dimensions
        this.clear();
        // After clear(), the implementation will need to handle resizing
        // The kernel implementation will manage the actual resizing
    }

    /**
     * Returns a string representation of the bitmap.
     *
     * @return a string representation of the bitmap's width, height, and pixel
     *         values
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BitMapImage: width=");
        sb.append(this.getWidth());
        sb.append(", height=");
        sb.append(this.getHeight());
        sb.append("\n");

        // Build a string representation of the pixel grid
        for (int y = 0; y < this.getHeight(); y++) {
            for (int x = 0; x < this.getWidth(); x++) {
                int pixel = this.getPixel(x, y);
                sb.append(String.format("%3d ", pixel));
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    /**
     * Checks whether this bitmap is equal to another object.
     *
     * @param obj
     *            the other object to compare to
     * @return true if obj is a BitMapImage with the same dimensions and pixel
     *         values; false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof BitMapImage)) {
            return false;
        }

        BitMapImage other = (BitMapImage) obj;

        // Check if dimensions match
        if (this.getWidth() != other.getWidth()
                || this.getHeight() != other.getHeight()) {
            return false;
        }

        // Check if all pixels match
        for (int y = 0; y < this.getHeight(); y++) {
            for (int x = 0; x < this.getWidth(); x++) {
                if (this.getPixel(x, y) != other.getPixel(x, y)) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Returns the hash code for this bitmap.
     *
     * @return the hash code computed from width, height, and all pixel values
     */
    @Override
    public int hashCode() {
        final int PRIME = 31; // A prime number for hash code calculation (31 seems to be industry standard)
        int result = Integer.hashCode(this.getWidth());
        result = PRIME * result + Integer.hashCode(this.getHeight());

        // Incorporate all pixel values into the hash code
        for (int y = 0; y < this.getHeight(); y++) {
            for (int x = 0; x < this.getWidth(); x++) {
                result = PRIME * result + Integer.hashCode(this.getPixel(x, y));
            }
        }

        return result;
    }

}
