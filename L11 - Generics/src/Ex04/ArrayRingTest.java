package Ex04;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayRingTest {

    private Ring<String> ring;

    @BeforeEach
    void setUp() {
        ring = new ArrayRing<>();
    }

    @Test
    void advance() {
        //arrange
        ring.add("Jens");
        ring.add("Anders");
        ring.add("Henrik");
        //act
        ring.advance();
        //assert
        assertEquals("Jens", ring.getCurrentItem());
    }

    @Test
    void getCurrentItemWhenEmpty() {
        //act & assert
        Exception exception = assertThrows(EmptyRingException.class, () -> ring.getCurrentItem());
        assertEquals("Ring is empty", exception.getMessage());
    }

    @Test
    void getCurrentItem() {
        //arrange
        ring.add("Jens");
        ring.add("Anders");
        ring.add("Henrik");
        //act
        String actual = ring.getCurrentItem();
        // assert
        assertEquals("Henrik", actual);
    }

    @Test
    void add() {
        //arrange
        ring.add("Jens");
        //assert
        assertEquals(1, ring.size());
    }

    @Test
    public void testRemoveEntryWhenAdded() {
        // arrange
        ring.add("Jan");
        ring.add("Per");
        ring.add("Hans");
        // act
        boolean isPerRemoved = ring.removeItem("Per");
        // assert
        assertTrue(isPerRemoved);
        assertEquals(2, ring.size());
    }

    @Test
    public void testRemoveEntryWhenNotAdded() {
        // arrange
        ring.add("Jan");
        ring.add("Per");
        ring.add("Hans");
        // act
        boolean isJensRemoved = ring.removeItem("Jens");
        // assert
        assertFalse(isJensRemoved);
        assertEquals(3, ring.size());
    }

    @Test
    void removeCurrentItem() {
        //arrange
        ring.add("Lars");
        //act
        String removed = ring.removeCurrentItem();
        //arrange
        assertEquals("Lars",removed);
        assertTrue(ring.isEmpty());
    }

    @Test
    void isEmptyNotEmpty() {
        //arrange
        ring.add("Henrik");
        //assert
        assertFalse(ring.isEmpty());
    }

    @Test
    void isEmpty() {
        //assert
        assertTrue(ring.isEmpty());
    }
}