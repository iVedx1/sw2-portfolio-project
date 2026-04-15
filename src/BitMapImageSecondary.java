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
     *            the colors to set the pixels in row y
     * @ensures for all x=0...width-1, the pixel at (x, y) is set to colors[x]
     */
    @Override
    public void setRow(int y, int[] colors) {
        assert colors != null : "Violation of: colors is not null";
        assert 0 <= y && y < this.getHeight() : "Violation of: y is in range";
        final boolean correctLength = colors.length == this.getWidth();
        assert correctLength : "Violation of: colors.length equals width";

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
     *            the colors to set the pixels in column x
     * @ensures for all y=0...height-1, the pixel at (x, y) is set to colors[y]
     */
    @Override
    public void setColumn(int x, int[] colors) {
        assert colors != null : "Violation of: colors is not null";
        assert 0 <= x && x < this.getWidth() : "Violation of: x is in range";
        final boolean correctLength = colors.length == this.getHeight();
        assert correctLength : "Violation of: colors.length equals height";

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
        assert width >= 0 : "Violation of: width is nonnegative";
        assert height >= 0 : "Violation of: height is nonnegative";

        this.transferFrom(new BitMapImage1(width, height));
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

        if (this.getWidth() != other.getWidth()
                || this.getHeight() != other.getHeight()) {
            return false;
        }

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
     * Returns a hash code for this bitmap.
     *
     * @return a hash code for this bitmap
     */
    @Override
    public int hashCode() {
        int hash = 1;
        hash = hash * this.getWidth();
        hash = hash * this.getHeight();
        for (int y = 0; y < this.getHeight(); y++) {
            for (int x = 0; x < this.getWidth(); x++) {
                hash = hash * this.getPixel(x, y);
            }
        }
        return hash;
    }

}
