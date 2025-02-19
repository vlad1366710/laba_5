package ReverseQueueTransfer;

import java.util.Queue;
import java.util.Stack;

/**
 * Утилиты для работы с очередями.
 */
public class ReverseQueueTransfer {
    /**
     * Переносит элементы из одной очереди в другую в обратном порядке.
     *
     * @param l1 Исходная очередь.
     * @param l2 Целевая очередь.
     */
    public static void transferReverseOrder(Queue<Integer> l1, Queue<Integer> l2) {
        Stack<Integer> tempStack = new Stack<>();

        while (!l1.isEmpty()) {
            tempStack.push(l1.poll());
        }

        while (!tempStack.empty()) {
            l2.offer(tempStack.pop());
        }
    }
}