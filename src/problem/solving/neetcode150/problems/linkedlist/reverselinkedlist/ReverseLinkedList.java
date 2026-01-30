package problem.solving.neetcode150.problems.linkedlist.reverselinkedlist;

import java.util.ArrayList;
import java.util.List;

public class ReverseLinkedList
{
    public static void main(String[] args)
    {
        int[] input = new int[]{0,1,2,3};
        ListNode head = createList(input);
        ListNode reversedNode = new ReverseLinkedList().reverseList(head);
        System.out.println(printList(reversedNode, new ArrayList<>()));
    }

    private static ListNode createList(int[] input)
    {
        ListNode head = null;
        ListNode curr = head;
        for(int i = 0; i < input.length; i++)
        {   if(i == 0)
            {
                head = new ListNode(input[i]);
                curr = head;
            }
            else
            {
                curr.next = new ListNode(input[i]);
                curr = curr.next;
            }
        }
        return head;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode reversedNode = new ListNode();
        reverse(head, reversedNode);
        return reversedNode;
    }

    public ListNode reverse(ListNode node, ListNode reverseNode)
    {
        if (node.next == null)
        {
            reverseNode.val = node.val;
            return reverseNode;
        }
        ListNode reverse = reverse(node.next, reverseNode);
        reverse.next = new ListNode(node.val);
        return reverse.next;
    }

    private static List printList(ListNode node, List list)
    {
        if(node != null)
        {
            list.add(node.val);
        }
        else
        {
            return list;
        }
        list = printList(node.next, list);
        return list;
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
