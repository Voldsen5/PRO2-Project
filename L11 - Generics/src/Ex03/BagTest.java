package Ex03;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BagTest {
    private Bag<String> bag;

    @BeforeEach
    public void setUp() {
        bag = new ArrayBag<>();
    }

    @Test
    public void testAdd() {
        // act
        boolean isAdded = bag.add("Lis");
        // assert
        assertTrue(isAdded);
        assertTrue(bag.contains("Lis"));
        assertEquals(1, bag.getCurrentSize());
    }

    @Test
    public void testAddWhenFull() {
        // arrange
        for (int i = 0; i < 10; i++) {
            bag.add("item" + i);
        }
        // act
        boolean isAdded = bag.add("Per");
        // assert
        assertFalse(isAdded);
        assertFalse(bag.contains("Per"));
        assertEquals(10, bag.getCurrentSize());
    }

    @Test
    public void testRemoveRandom() {
        // arrange
        bag.add("Jan");
        bag.add("Per");
        bag.add("Hans");
        // act
        String removed = bag.remove();
        // assert
        assertTrue(List.of("Jan", "Per", "Hans").contains(removed));
        assertEquals(2, bag.getCurrentSize());
    }

    @Test
    public void testRemoveRandomWhenEmpty() {
        // act
        String removed = bag.remove();
        // assert
        assertNull(removed);
    }

    @Test
    public void testRemoveEntryWhenAdded() {
        // arrange
        bag.add("Jan");
        bag.add("Per");
        bag.add("Hans");
        // act
        boolean isPerRemoved = bag.remove("Per");
        // assert
        assertTrue(isPerRemoved);
        assertFalse(bag.contains("Per"));
        assertEquals(2, bag.getCurrentSize());
    }

    @Test
    public void testRemoveEntryWhenNotAdded() {
        // arrange
        bag.add("Jan");
        bag.add("Per");
        bag.add("Hans");
        // act
        boolean isJensRemoved = bag.remove("Jens");
        // assert
        assertFalse(isJensRemoved);
        assertEquals(3, bag.getCurrentSize());
    }

    @Test
    public void testClear() {
        // arrange
        bag.add("Jan");
        bag.add("Per");
        bag.add("Hans");
        // act
        bag.clear();
        // assert
        assertTrue(bag.isEmpty());
    }

    @Test
    public void testGetFrequencyOf() {
        // arrange
        bag.add("Jan");
        bag.add("Per");
        bag.add("Hans");
        bag.add("Per");
        // act
        int freqJens = bag.getFrequencyOf("Jens");
        int freqJan = bag.getFrequencyOf("Jan");
        int freqPer = bag.getFrequencyOf("Per");
        // assert
        assertEquals(0, bag.getFrequencyOf("Jens"));
        assertEquals(1, bag.getFrequencyOf("Hans"));
        assertEquals(2, bag.getFrequencyOf("Per"));
    }

    @Test
    public void testContains() {
        // arrange
        bag.add("Jan");
        bag.add("Per");
        // act
        boolean isJensFound = bag.contains("Jens");
        boolean isJanFound = bag.contains("Jan");
        // assert
        assertFalse(isJensFound);
        assertTrue(isJanFound);
    }

    @Test
    public void testToArray() {
        // arrange
        bag.add("Jan");
        bag.add("Per");
        // act
        Object[] items = bag.toArray();
        assertTrue(Arrays.asList(items).contains("Jan"));
        assertTrue(Arrays.asList(items).contains("Per"));
    }
}
