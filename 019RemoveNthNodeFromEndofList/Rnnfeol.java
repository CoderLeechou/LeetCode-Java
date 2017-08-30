package RemoveNthNodeFromEndofList019;


/**
 * Created by Administrator on 2017/8/30.
 */
class ListNode{
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class Rnnfeol {
    public ListNode removeNthFromEnd(ListNode head,int n){
        ListNode pa=head;
        ListNode pb=head;
        for(int i=0;i<n&&pa!=null;i++){
            pa=pa.next;
        }
        if(pa==null){
            head=head.next;
            return head;
        }
        while(pa.next!=null){
            pa=pa.next;
            pb=pb.next;
        }
        pb.next=pb.next.next;
        return head;
    }

}
