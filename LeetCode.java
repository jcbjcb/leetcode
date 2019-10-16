
/**
 * Created by jcb on 2019-10-16 16:40
 */
public class LeetCode {

    /**
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     *
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     *
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     *
     * 示例：
     *
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/add-two-numbers
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int i = 0;
        if(l1.val+l2.val>=10){
            i = 1;
        }

        ListNode listNode =new ListNode((l1.val+l2.val)%10);
        ListNode l1next = l1.next;
        ListNode l2next = l2.next;
        ListNode curr = listNode;
        while (true){
            ListNode next ;
            if(l1next == null && l2next == null) {
                break;
            }else if(l1next == null && l2next != null){
                next = new ListNode(l2next.val);
            }else if(l2next == null && l1next !=null){
                next = new ListNode(l1next.val);
            }else{
                next = new ListNode((l1next.val+l2next.val)%10 + i);
                if(l1next.val+l2next.val>=10){
                    i = 1;
                }
            }
            if(l1next != null) {
                l1next = l1next.next;
            }
            if( l2next != null) {
                l2next = l2next.next;
            }
            if(next!=null){
                curr.next = next;
                curr = next;
            }
        }
        if(i>0){
            curr.next = new ListNode(i);
        }
        return listNode;
    }

    static class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);


        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);

        addTwoNumbers(l1,l2);
    }
}
