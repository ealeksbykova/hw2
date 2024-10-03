package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BinaryIntSearchTreeTest {

    private HomeWork tree;
    private HomeWork nullTree;

    @Test
    void add() {
        BinaryIntSearchTree tree = new BinaryIntSearchTree();

        tree.add(5);

        for (int i = 0; i < 10; i++) {
            tree.add(i);
        }
        tree.add(10);
    }

    @BeforeEach
    void setUp() {
        tree = getTree();
        nullTree = new HomeWork();
    }

    @Test
    @DisplayName("Удачный поиск наибольших значений в коллекции")
    void findMaxDigits_SuccessTest() {

        assertEquals(
            List.of(Integer.MAX_VALUE, Integer.MAX_VALUE - 1, 4325320, 324234),
            tree.findMaxDigits(4, Integer.MAX_VALUE)
        );
        assertEquals(
            List.of(-5, -910, -34456620, Integer.MIN_VALUE),
            tree.findMaxDigits(4, -3)
        );
        assertEquals(
            Collections.emptyList(),
            tree.findMaxDigits(0, 23000)
        );
    }

    @Test
    @DisplayName("Ошибка поиска наибольших значений в коллекции: не валидное количество запрашиваемых значений")
    void findMaxDigits_IndexOutOfBoundsException_FailTest() {

        assertThrows(IndexOutOfBoundsException.class, () -> tree.findMaxDigits(5, Integer.MIN_VALUE));
        assertThrows(IndexOutOfBoundsException.class, () -> tree.findMaxDigits(Integer.MAX_VALUE, 55));
    }

    @Test
    @DisplayName("Ошибка поиска наибольших значений в коллекции: поиск в пустом дереве")
    void findMaxDigits_FailTest() {

        assertNull(nullTree.findMaxDigits(4, -5));
    }

    private HomeWork getTree() {
        HomeWork tree = new HomeWork();

        tree.add(-5);
        tree.add(4650);
        tree.add(4);
        tree.add(-910);
        tree.add(4325320);
        tree.add(0);
        tree.add(Integer.MAX_VALUE);
        tree.add(Integer.MAX_VALUE - 1);
        tree.add(Integer.MIN_VALUE);
        tree.add(324234);
        tree.add(-34456620);

        return tree;
    }
}