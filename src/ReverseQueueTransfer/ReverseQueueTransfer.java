package ReverseQueueTransfer;

import java.util.Queue;
import java.util.Stack;

/**
 * ������� ��� ������ � ���������.
 */
public class ReverseQueueTransfer {
    /**
     * ��������� �������� �� ����� ������� � ������ � �������� �������.
     *
     * @param l1 �������� �������.
     * @param l2 ������� �������.
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