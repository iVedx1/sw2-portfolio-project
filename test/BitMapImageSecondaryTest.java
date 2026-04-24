import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Tests for secondary methods in {@code BitMapImageSecondary}.
 *
 * @author Vedant Rakhonde
 */
public class BitMapImageSecondaryTest {

    /**
     * Verifies that clearCanvas paints every pixel black.
     */
    @Test
    public void testClearCanvas() {
        BitMapImage1 image = new BitMapImage1(3, 2);
        image.setPixel(0, 0, 20);
        image.setPixel(1, 0, 40);
        image.setPixel(2, 1, 200);

        image.clearCanvas();

        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                assertEquals(0, image.getPixel(x, y));
            }
        }
    }

    /**
     * Verifies that setRow updates exactly one row.
     */
    @Test
    public void testSetRow() {
        BitMapImage1 image = new BitMapImage1(4, 3);

        int[] row = { 10, 20, 30, 40 };
        image.setRow(1, row);

        assertEquals(10, image.getPixel(0, 1));
        assertEquals(20, image.getPixel(1, 1));
        assertEquals(30, image.getPixel(2, 1));
        assertEquals(40, image.getPixel(3, 1));

        assertEquals(0, image.getPixel(0, 0));
        assertEquals(0, image.getPixel(3, 2));
    }

    /**
     * Verifies that setColumn updates exactly one column.
     */
    @Test
    public void testSetColumn() {
        BitMapImage1 image = new BitMapImage1(3, 4);

        int[] column = { 5, 15, 25, 35 };
        image.setColumn(2, column);

        assertEquals(5, image.getPixel(2, 0));
        assertEquals(15, image.getPixel(2, 1));
        assertEquals(25, image.getPixel(2, 2));
        assertEquals(35, image.getPixel(2, 3));

        assertEquals(0, image.getPixel(0, 0));
        assertEquals(0, image.getPixel(1, 3));
    }

    /**
     * Verifies that setSize changes dimensions and reinitializes all pixels.
     */
    @Test
    public void testSetSize() {
        BitMapImage1 image = new BitMapImage1(2, 2);
        image.setPixel(1, 1, 255);

        image.setSize(3, 1);

        assertEquals(3, image.getWidth());
        assertEquals(1, image.getHeight());
        assertEquals(0, image.getPixel(0, 0));
        assertEquals(0, image.getPixel(1, 0));
        assertEquals(0, image.getPixel(2, 0));
    }

    /**
     * Verifies equality for same dimensions and same pixel values.
     */
    @Test
    public void testEqualsTrueForMatchingImages() {
        BitMapImage1 first = new BitMapImage1(2, 2);
        BitMapImage1 second = new BitMapImage1(2, 2);

        first.setPixel(0, 1, 90);
        second.setPixel(0, 1, 90);

        assertTrue(first.equals(second));
        assertTrue(second.equals(first));
    }

    /**
     * Verifies inequality for differing dimensions or pixels.
     */
    @Test
    public void testEqualsFalseForDifferentImages() {
        BitMapImage1 first = new BitMapImage1(2, 2);
        BitMapImage1 second = new BitMapImage1(2, 2);
        BitMapImage1 third = new BitMapImage1(3, 2);

        second.setPixel(1, 1, 33);

        assertFalse(first.equals(second));
        assertFalse(first.equals(third));
        assertFalse(first.equals("not an image"));
    }

    /**
     * Verifies hashCode behavior for equal and unequal images.
     */
    @Test
    public void testHashCodeConsistency() {
        BitMapImage1 first = new BitMapImage1(2, 2);
        BitMapImage1 second = new BitMapImage1(2, 2);

        first.setPixel(0, 0, 11);
        second.setPixel(0, 0, 11);

        assertEquals(first.hashCode(), second.hashCode());

        second.setPixel(1, 1, 19);
    }

    /**
     * Verifies that toString contains dimensions and representative pixel data.
     */
    @Test
    public void testToStringContainsState() {
        BitMapImage1 image = new BitMapImage1(2, 1);
        image.setPixel(0, 0, 7);
        image.setPixel(1, 0, 9);

        String description = image.toString();

        assertTrue(description.contains("width=2"));
        assertTrue(description.contains("height=1"));
        assertTrue(description.contains("  7"));
        assertTrue(description.contains("  9"));
    }
}
