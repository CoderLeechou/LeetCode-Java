/**
 * You are given two linked lists representing two non-negative numbers.
 * The digits are stored in reverse order and each of their nodes contain
 * a single digit. Add the two numbers and return it as a linked list.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 *
 * 题目大意
 * 有两个单链表，代表两个非负数，每一个节点代表一个数位，数字是反向存储的，
 * 即第一个结点表示最低位，最后一个结点表示最高位。求两个数的相加和，并且以链表形式返回。
 *
 * 解题思路
 * 对两个链表都从第一个开始处理，进行相加，结果再除以10求商，作为下一位相加的进位，
 * 同时记录余数，作为本位的结果，一直处理，直到所有的结点都处理完。
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
    }
}
public class addtwonumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        //把相加后的结果存放于链表1，pre1是用于最后有进位时在其后new新结点
        ListNode ret=l1;
        ListNode pre1=new ListNode(0);
        pre1.next=l1;

        int flag=0;
        while(l1!=null&&l2!=null){
            l1.val=l1.val+l2.val+flag;
            flag=l1.val/10;
            l1.val=l1.val%10;
            pre1=l1;
            l1=l1.next;
            l2=l2.next;
        }
        //如果链表2有剩余，接到链表1的后面
        if(l2!=null){
            pre1.next=l2;
            l1=l2;
        }

        while(l1!=null){
            l1.val+=flag;
            flag=l1.val/10;
            l1.val=l1.val;
            pre1=l1;
            l1=l1.next;
        }

        if(flag>0){
            ListNode node=new ListNode(1);
            pre1.next=node;
        }
        return ret;
    }
    public static void main(String[] args){

    }
}
