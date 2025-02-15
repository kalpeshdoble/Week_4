package org.example;

import org.example.Junit.ListManager;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class ListManagerTest {
    ListManager listManager = new ListManager();

    @Test
    void testAddElement() {
        List<Integer> list = new ArrayList<>();
        listManager.addElement(list, 10);
        assertTrue(list.contains(10));
        assertEquals(1, listManager.getSize(list));
    }

    @Test
    void testRemoveElement() {
        List<Integer> list = new ArrayList<>();
        listManager.addElement(list, 20);
        assertTrue(listManager.removeElement(list, 20));
        assertFalse(list.contains(20));
        assertEquals(0, listManager.getSize(list));
    }

    @Test
    void testRemoveNonExistingElement() {
        List<Integer> list = new ArrayList<>();
        listManager.addElement(list, 30);
        assertFalse(listManager.removeElement(list, 40)); // Element 40 does not exist
        assertEquals(1, listManager.getSize(list));
    }

    @Test
    void testGetSize() {
        List<Integer> list = new ArrayList<>();
        assertEquals(0, listManager.getSize(list));
        listManager.addElement(list, 50);
        listManager.addElement(list, 60);
        assertEquals(2, listManager.getSize(list));
    }
}
