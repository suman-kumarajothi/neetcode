package problem.solving.neetcode150.problems.linkedlist.mergetwosortedlinkedlists;

import java.util.ArrayList;
import java.util.List;

public class MergeTwoSortedLinkedLists
{
    public static void main(String[] args)
    {
        int[] list1 = new int[]{1, 2, 4};
        int[] list2 = new int[]{1, 3, 5};
        ListNode list1Head = createList(list1);
        ListNode list2Head = createList(list2);
        ListNode mergedList = new MergeTwoSortedLinkedLists().mergeTwoLists(list1Head, list2Head);
        System.out.println(printList(mergedList, new ArrayList<>()));
    }

    private static ListNode createList(int[] input)
    {
        ListNode head = null;
        ListNode curr = head;
        for (int i = 0; i < input.length; i++)
        {
            if (i == 0)
            {
                head = new ListNode(input[i]);
                curr = head;
            } else
            {
                curr.next = new ListNode(input[i]);
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

    public ListNode mergeTwoLists(ListNode list1, ListNode list2)
    {
        if (list1 == null) return list2;
        else if (list2 == null) return list1;
        else
        {
            ListNode mergedList = new ListNode(- 101);
            ListNode mergedListRef = mergedList;
            while (list1 != null && list2 != null)
            {
                int val = list1.val;
                if (list1.val > list2.val)
                {
                    val = list2.val;
                    list2 = list2.next;
                } else
                {
                    list1 = list1.next;
                }

                if (mergedListRef.val == - 101)
                {
                    mergedListRef.val = val;
                } else
                {
                    mergedListRef.next = new ListNode(val);
                    mergedListRef = mergedListRef.next;
                }

                if (list1 == null) mergedListRef.next = list2;
                else if (list2 == null) mergedListRef.next = list1;
            }
            return mergedList;
        }
    }

    public static class ListNode
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
    }
}
