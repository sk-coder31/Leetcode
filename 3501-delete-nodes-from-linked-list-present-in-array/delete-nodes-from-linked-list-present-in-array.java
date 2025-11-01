class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> hs = new HashSet<>();
        for (int i : nums) {
            hs.add(i);
        }

        ListNode prev = null;
        ListNode temp = head;

        while (temp != null) {
            if (hs.contains(temp.val)) {
                if (temp == head) { 
                    head = head.next;
                    temp = head; 
                } else {
                    prev.next = temp.next; 
                    temp = temp.next;
                }
            } else {
                prev = temp; 
                temp = temp.next;
            }
        }

        return head;
    }
}