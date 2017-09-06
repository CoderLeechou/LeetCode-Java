package SwapNodesInPairs024;

/**
 * Created by Administrator on 2017/9/6.
 */
class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val=x;
    }
}
public class Snip{
    //每次跳两个节点，后一个接到前面，前一个接到后一个的后面，
    //最后现在的后一个（也就是原来的前一个）接到下个结点。
    //0->1->2->3->4
    //0->2->3->4 1->3->4
    //0->2->1->3->4
    //顺序不能乱
    ListNode dummy=new ListNode(0);
    dummy.next=head;
    head=dummy;
    while(head.next!=null&&head.next.next!=null){
        ListNode n1=head.next;
        ListNode n2=head.next.next;
        head.next=n2;
        n1.next=n2.next;
        n2.next=n1;
        head=n1;
    }
    return dummy.next;
}
