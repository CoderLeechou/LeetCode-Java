package MergedTwoSortedList021;

/**
 * Created by Administrator on 2017/8/31.
 */
class ListNode{
    int val;
    ListNode next=null;
    ListNode(int val){
        this.val=val;
    }
}
public class Mtsl {
    //方法1，递归
    /*public ListNode mergeTwoLists(ListNode l1,ListNode l2){
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        if(l1.val<=l2.val){
            l1.next=mergeTwoLists(l1.next,l2);
            return l1;
        }else{
            l2.next=mergeTwoLists(l1,l2.next);
            return l2;
        }
    }*/
    //方法2，非递归
    public ListNode mergeTwoList(ListNode l1,ListNode l2){
        ListNode helper=new ListNode(0);
        ListNode current=helper;
        //使用while，就不需做空链表判断
        while(l1!=null&&l2!=null){
            if(l1.val<=l2.val){
                current.next=l1;
                l1=l1.next;
            }else{
                current.next=l2;
                l2=l2.next;
            }
            current=current.next;
        }
        if(l1!=null){
            current.next=l1;
        }else{
            current.next=l2;
        }
        return helper.next;
    }
}

