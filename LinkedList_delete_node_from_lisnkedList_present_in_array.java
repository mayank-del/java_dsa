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
class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> h=new HashSet<>();
        for(int it:nums){
            h.add(it);
        }
        while( head!=null && h.contains(head.val) ){
            head=head.next;
        }
        ListNode li=new ListNode(-1);
        li.next=head;
        ListNode pre=li;
        ListNode temp=head;
        while(temp!=null){
            if(h.contains(temp.val)){
                pre.next=temp.next;
            }else{
                pre=temp;
            }
            temp=temp.next;
        }

        //second approach

        /* 
         * while(temp!=null){
            if(!h.contains(temp.val)){
                ListNode node=new ListNode(temp.val);
                pre.next=node;
                pre=pre.next;
                //pre.next=temp.next;
            }
            temp=temp.next;
        }
         * 
         */

        return li.next;
    }
}