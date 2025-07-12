class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dumm = new ListNode(0);
        ListNode temp = dumm;
        dumm.next = head;
        HashMap<Integer,ListNode>map = new HashMap<>();
        int prefix = 0;
        while(temp!=null){
            prefix+=temp.val;
            map.put(prefix,temp);
            temp = temp.next;
        }        
        temp = dumm;
        prefix = 0;
        while(temp!=null){
            prefix += temp.val;
            temp.next = map.get(prefix).next;
            temp = temp.next;
        }
        return dumm.next;
    }
}