package problem.solving.neetcode150.problems.stack.minstack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MinStack
{
    List<Integer> data;
    Stack<Integer> minStack;
    Integer minVal = null;

    public MinStack()
    {
        data = new ArrayList<>();
        minStack = new Stack<>();
    }

    public static void main(String[] args)
    {
        MinStack minStack = new MinStack();
        minStack.push(1);
        minStack.push(2);
        minStack.push(0);
        minStack.getMin(); // return 0
        minStack.pop();
        minStack.top();    // return 2
        minStack.getMin(); // return 1

        System.out.println(minStack);
    }

    public void push(int val)
    {
        data.add(val);
        if(minVal == null || val < minVal) minVal = val;
        minStack.add(minVal);
    }

    public void pop()
    {
        data.remove(data.size() - 1);
        minStack.pop();
        minVal = (!minStack.isEmpty()) ? minStack.peek() : null;
    }

    public int top()
    {
        return data.get(data.size() - 1);
    }

    public int getMin()
    {
       return minStack.peek();
    }

    @Override
    public String toString()
    {
        return "MinStack{" +
                "data=" + data +
                ", minStack=" + minStack +
                ", minVal=" + minVal +
                '}';
    }
}
