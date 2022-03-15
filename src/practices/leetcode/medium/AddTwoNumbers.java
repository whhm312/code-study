package practices.leetcode.medium;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node1 = l1; ListNode node2 = l2;
        ListNode sumNode = new ListNode(0);
        ListNode current = sumNode;
        
        int x = 0; int y = 0; int sum = 0; int tenDigit = 0;
        
        while(node1 != null || node2 != null) { 
            x = getValue(node1);
            y = getValue(node2);
            
            sum = tenDigit + x + y;
            current.next = new ListNode(sum % 10);
            
            tenDigit = sum / 10;
            current = current.next;

            node1 = getNode(node1);
            node2 = getNode(node2);
        }

        if(tenDigit > 0) {
            current.next = new ListNode(tenDigit);
        }
        
        return sumNode.next;
    }
    
    private ListNode getNode(ListNode listNode) {
        if(listNode == null) {
            return null;
        }

        return listNode.next;
    }

    private int getValue(ListNode listNode) {
        if(listNode == null) {
            return 0;
        }

        return listNode.val;
    }
}
