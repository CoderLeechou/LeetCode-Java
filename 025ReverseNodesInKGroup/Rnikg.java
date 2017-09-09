package ReverseNodesInKGroup025;

/**
 * Created by Administrator on 2017/9/8.
 */
class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val=x;
    }
}
public class Rnikg{
    public ListNode reverseKGroup(ListNode head,int k){
        if(head==null)
            return null;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        int count=0;
        ListNode pre=dummy;
        ListNode cur=head;
        while(cur!=null){
            count++;
            ListNode next=cur.next;
            if(count==k){
                pre=reverseNodes(pre,next);
                count=0;
            }
            cur=next;
        }
        return dummy.next;
    }
    public reverseNodes(ListNode pre,ListNode end){
        if(pre==null||pre.next==null){
            return pre;
        }
        ListNode head=pre.next;
        ListNode cur=pre.next.next;
        while(cur!=end){
            ListNode next=cur.next;
            cur.next=pre.next;
            pre.next=cur;
            cur=next;
        }
        head.next=end;
        return head;
    }
}
