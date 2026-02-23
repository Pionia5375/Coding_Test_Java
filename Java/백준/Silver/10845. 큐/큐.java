import java.util.Scanner;

public class Main {

    static class IntQueue {
        private int[] que;
        private int capacity;
        private int front;
        private int rear;
        private int num;

        class EmptyIntQueueException extends RuntimeException {}
        class OverflowIntQueueException extends RuntimeException {}

        public IntQueue(int maxlen) {
            num = front = rear = 0;
            capacity = maxlen;
            try {
                que = new int[capacity];
            } catch (OutOfMemoryError e) {
                capacity = 0;
            }
        }

        public int enque(int x) {
            if (num >= capacity) throw new OverflowIntQueueException();
            que[rear++] = x;
            num++;
            if (rear == capacity) rear = 0;
            return x;
        }

        public int deque() {
            if (num <= 0) throw new EmptyIntQueueException();
            int x = que[front++];
            num--;
            if (front == capacity) front = 0;
            return x;
        }

        public int peekFront() {
            if (num <= 0) throw new EmptyIntQueueException();
            return que[front];
        }

        public int peekRear() {
            if (num <= 0) throw new EmptyIntQueueException();
            int index = (rear == 0) ? capacity - 1 : rear - 1;
            return que[index];
        }

        public int size() { return num; }
        public boolean isEmpty() { return num <= 0; }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int n = stdIn.nextInt();
        IntQueue queue = new IntQueue(n);

        for (int i = 0; i < n; i++) {
            String cmd = stdIn.next();
            switch (cmd) {
                case "push":
                    queue.enque(stdIn.nextInt());
                    break;
                case "pop":
                    try { System.out.println(queue.deque()); }
                    catch (IntQueue.EmptyIntQueueException e) { System.out.println(-1); }
                    break;
                case "front":
                    try { System.out.println(queue.peekFront()); }
                    catch (IntQueue.EmptyIntQueueException e) { System.out.println(-1); }
                    break;
                case "back":
                    try { System.out.println(queue.peekRear()); }
                    catch (IntQueue.EmptyIntQueueException e) { System.out.println(-1); }
                    break;
                case "size":
                    System.out.println(queue.size());
                    break;
                case "empty":
                    System.out.println(queue.isEmpty() ? 1 : 0);
                    break;
            }
        }
        stdIn.close();
    }
}