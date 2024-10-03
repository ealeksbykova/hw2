package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class HomeWork extends BinaryIntSearchTree {

    /**
     * <h1>Задание 1.</h1>
     * Дан класс BinaryTree, который реализует бинарное дерево поиска.
     * Реализовать метод findMaxDigits, который возвращает массив
     * наибольших элементов в дереве, не превосходящих upperBound.
     * <br/>
     * Пример :
     * коллекция в дереве 1, 2, 3, 4, 5
     * count = 3, upperBound 4
     * ответ [4, 3, 2]

     *
     * @param count максимальное количество элементов в ответе
     * @param upperBound верхняя граница для поиска элементов
     * @return массив найденных максимальных значений не более чем upperBound и длиной не более count, отсортировано от большего к меньшему
     * Сигнатуру метода не меняем
     */
    public List<Integer> findMaxDigits(int count, int upperBound) {
        if (root == null) {
            return null;
        }

        Node node = root;
        List<Integer> biggestElements = new ArrayList<>();
        addElements(node, biggestElements, upperBound);

        biggestElements.sort(Collections.reverseOrder());

        if (count > biggestElements.size() || count < 0) {
            throw new IndexOutOfBoundsException("Elements count is too big or less then 0");
        }
        return biggestElements.subList(0, count);
    }

    private void addElements(Node node, List<Integer> biggestElements, int upperBound) {
        if (node != null) {
            if (node.value <= upperBound) {
                biggestElements.add(node.value);
            }

            addElements(node.left, biggestElements, upperBound);
            addElements(node.right, biggestElements, upperBound);
        }
    }
}
