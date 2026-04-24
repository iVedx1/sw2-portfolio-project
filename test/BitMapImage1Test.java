import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import org.junit.Test;

/**
 * Tests for kernel and Standard methods in {@code BitMapImage1}.
 *
 * @author Vedant Rakhonde
 */
public class BitMapImage1Test {

    /**
     * Verifies that the default constructor creates an empty image.
     */
    @Test
    public void testDefaultConstructor() {
        BitMapImage1 image = new BitMapImage1();

        assertEquals(0, image.getWidth());
        assertEquals(0, image.getHeight());
    }

    /**
     * Verifies that width and height are stored correctly.
     */
    @Test
    public void testSizedConstructor() {
        BitMapImage1 image = new BitMapImage1(4, 3);

        assertEquals(4, image.getWidth());
        assertEquals(3, image.getHeight());
    }

    /**
     * Verifies that all pixels start as black.
     */
    @Test
    public void testConstructorInitializesPixelsToZero() {
        BitMapImage1 image = new BitMapImage1(3, 2);

        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                assertEquals(0, image.getPixel(x, y));
            }
        }
    }

    /**
     * Verifies that setting one pixel returns its previous color.
     */
    @Test
    public void testSetPixelReturnsOriginalColor() {
        BitMapImage1 image = new BitMapImage1(2, 2);

        assertEquals(0, image.setPixel(1, 1, 120));
        assertEquals(120, image.setPixel(1, 1, 80));
        assertEquals(80, image.getPixel(1, 1));
    }

    /**
     * Verifies that setting one pixel does not affect another pixel.
     */
    @Test
    public void testSetPixelOnlyUpdatesTargetLocation() {
        BitMapImage1 image = new BitMapImage1(3, 3);

        image.setPixel(2, 0, 200);

        assertEquals(200, image.getPixel(2, 0));
        assertEquals(0, image.getPixel(0, 0));
        assertEquals(0, image.getPixel(2, 2));
    }

    /**
     * Verifies that clear resets the object to the initial empty state.
     */
    @Test
    public void testClearResetsState() {
        BitMapImage1 image = new BitMapImage1(2, 2);
        image.setPixel(0, 0, 255);

        image.clear();

        assertEquals(0, image.getWidth());
        assertEquals(0, image.getHeight());
    }

    /**
     * Verifies that transferFrom moves state and clears the source.
     */
    @Test
    public void testTransferFromMovesState() {
        BitMapImage1 source = new BitMapImage1(3, 2);
        source.setPixel(2, 1, 77);

        BitMapImage1 target = new BitMapImage1(1, 1);
        target.transferFrom(source);

        assertEquals(3, target.getWidth());
        assertEquals(2, target.getHeight());
        assertEquals(77, target.getPixel(2, 1));

        assertEquals(0, source.getWidth());
        assertEquals(0, source.getHeight());
    }

    /**
     * Verifies that newInstance creates a distinct empty object.
     */
    @Test
    public void testNewInstanceCreatesFreshEmptyObject() {
        BitMapImage1 image = new BitMapImage1(2, 2);
        image.setPixel(1, 1, 15);

        BitMapImage1 fresh = image.newInstance();

        assertNotSame(image, fresh);
        assertEquals(0, fresh.getWidth());
        assertEquals(0, fresh.getHeight());
    }
}
