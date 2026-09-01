
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode SecondHalf = reverse(slow);
        ListNode FirstHalf = head;

        while (SecondHalf != null) {
            if (FirstHalf.val != SecondHalf.val) {
                return false;
            }

            FirstHalf = FirstHalf.next;
            SecondHalf = SecondHalf.next;
        }

        return true;
    }

     private ListNode reverse(ListNode head) {

        ListNode prev = null;
        ListNode current = head;

        while (current != null) {

            ListNode next = current.next;

            current.next = prev;

            prev = current;
            current = next;
        }

        return prev;
    }


        
    }
