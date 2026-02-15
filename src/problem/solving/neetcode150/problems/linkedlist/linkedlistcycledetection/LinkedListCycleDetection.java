package problem.solving.neetcode150.problems.linkedlist.linkedlistcycledetection;

import java.util.List;

public class LinkedListCycleDetection
{
    public static void main(String[] args)
    {
        int[] list = new int[]{1};
        int index = 0;
        ListNode head = createCircularList(list, index);
        System.out.println(new LinkedListCycleDetection().hasCycle(head));
    }

    public static boolean hasCycle(ListNode head)
    {
        ListNode fastPointer = head;
        ListNode slowPointer = head;
        boolean isFirstOccur = true;
        while ((fastPointer == head && slowPointer == head && isFirstOccur) || fastPointer != slowPointer)
        {
            if (isFirstOccur) isFirstOccur = false;
            if (fastPointer == null || slowPointer == null) return false;
            else
            {
                fastPointer = (fastPointer.next != null) ? fastPointer.next.next : null;
                slowPointer = slowPointer.next;
                System.out.println(fastPointer +"\n"+slowPointer);
            }
        }
        return fastPointer != null && slowPointer != null;
    }

    private static ListNode createCircularList(int[] input, int index)
    {
        ListNode head = null;
        ListNode curr = head;
        ListNode ref = null;
        for (int i = 0; i < input.length; i++)
        {
            if (i == 0)
            {
                head = new ListNode(input[i]);
                curr = head;

                if (i == index)
                {
                    ref = curr;
                    curr.next = ref;
                    curr = curr.next;
                }
            }
            else if (i == index)
            {
                curr.next = new ListNode(input[i]);
                ref = curr.next;
                curr = curr.next;
            } else
            {
                curr.next = new ListNode(input[i]);
                curr.next.next = ref;
                curr = curr.next;
            }
        }
        return head;
    }

    private static List printList(ListNode node, List list)
    {
        if (node != null)
        {
            list.add(node.val);
        } else
        {
            return list;
        }
        list = printList(node.next, list);
        return list;
    }

    private static class ListNode
    {
        int val;
        ListNode next;

        ListNode()
        {
        }

        ListNode(int val)
        {
            this.val = val;
        }

        @Override
        public String toString()
        {
            return "ListNode{" +
                    "val=" + val +
                    '}';
        }
    }
}
