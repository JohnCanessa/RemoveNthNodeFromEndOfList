import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


/**
 * 
 */
public class RemoveNthNodeFromEndOfList {


    /**
     * Definition for singly-linked list.
     */
    static class ListNode {
        int val;
        ListNode next;
        
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        public String toString() {

            // **** initialization ****
            ListNode node       = this;
            StringBuilder sb    = new StringBuilder();

            // **** traverse the linked list generating the string ****
            while (node != null) {
                sb.append(node.val);
                if (node.next != null)
                    sb.append("->");
                node = node.next;
            }

            // **** ****
            return sb.toString();
        }
    }


    /**
     * Remove the nth node from the end of the list and return its head.
     * 
     * Runtime: 0 ms, faster than 100.00% of Java online submissions.
     * Memory Usage: 36.9 MB, less than 83.55% of Java online submissions.
     * 
     * 208 / 208 test cases passed.
     * Status: Accepted
     * Runtime: 0 ms
     * Memory Usage: 36.9 MB
     * 
     * Execution: O(n) - Space: O(1)
     */
    static public ListNode removeNthFromEnd(ListNode head, int n) {
        
        // **** initialization ****
        ListNode p  = null;
        ListNode q  = null;
        int len     = 0;

        // **** get length of linked list - O(n) ****
        for (len = 0, p = head; p != null; p = p.next, len++);

        // ???? ????
        System.out.println("<<< len: " + len);

        // **** remove first element from the linked list (if needed) ****
        if (len == n) return head.next;

        // **** get to the nth element in the linked list - O(n) ****
        int i = 1;
        for (q = head, p = head.next; i < len - n; i++) {
            p = p.next;
            q = q.next;
        }
        
        // ???? ????
        System.out.println("<<< q.val: " + q.val + " p.val: " + p.val);

        // **** remove nth element `p` from the linked list ****
        q.next = p.next;

        // **** return the head of the updated linked list ****
        return head;
    }


    /**
     * Test scaffold.
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        // **** open a buffered reader ****
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // **** read int[] arr with node values ****
        int[] arr = Arrays.stream(br.readLine().trim().split(","))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        // **** read `n` ****
        int n = Integer.parseInt(br.readLine().trim());

        // **** close buffered reader ****
        br.close();
        
        // ???? ????
        System.out.println("main <<< arr: " + Arrays.toString(arr));
        System.out.println("main <<< n: " + n);

        // **** populate linked list ****
        int len         = arr.length;
        ListNode head   = new ListNode(arr[len - 1]);
        for (int i = len - 2; i >= 0; i--)
            head = new ListNode(arr[i], head);

        // ???? ????
        System.out.println("main <<< head: " + head.toString());

        // **** call function of interest ****
        head = removeNthFromEnd(head, n);
        
        // **** display output ****
        System.out.print("main <<< output: " + ((head != null) ? head.toString() : ""));
    }

}