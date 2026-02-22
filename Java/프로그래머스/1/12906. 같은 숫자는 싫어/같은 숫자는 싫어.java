import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        
        int length = arr.length;
        IntStack stack = new IntStack(length);
    
        int i = 0;
        stack.push(arr[i]);
    
        for (i = 1; i < length; i++) {
            if (arr[i] == stack.peek())
                continue;
            else
                stack.push(arr[i]);
        }
    
        answer = stack.returnStack();
        
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return answer;
    }
}    

class IntStack {
    private int capacity;
    private int pointer;
    private int[] stack;
   
    public class EmptyIntStackException extends RuntimeException {
        public EmptyIntStackException() {
        }
    }
        
    public class OverflowIntStackException extends RuntimeException {
        public OverflowIntStackException() {
        }
    }

    public IntStack(int maxlen) {
        pointer = 0;
        capacity = maxlen;
        try {
            stack = new int[capacity];
        } catch (OutOfMemoryError e) {
            capacity = 0;
        }
    }

    public int push (int x) {
        if (pointer >= capacity)
            throw new OverflowIntStackException();
        return stack[pointer++] = x;
    }
        
    public int peek () {
        if (pointer <= 0)
            throw new EmptyIntStackException();
        return stack[pointer - 1];
    }

    public int[] returnStack () {
        return Arrays.copyOf(stack, pointer);
    }
}