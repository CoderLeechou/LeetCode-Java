package MergedKSortedList023;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by Administrator on 2017/9/5.
 */
class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val=val;
    }
}
public class Mksl {
    //方法1，先分成两个子任务，然后递归求子任务，最后回溯回来。
    // 分治加递归，类似shell排序
    /*public ListNode mergeKLists(ArrayList<ListNode> lists){
        if(lists==null||lists.size()==0)
            return null;
        return helper(lists,0,lists.size()-1);
    }
    private ListNode helper(ArrayList<ListNode> lists,int l,int r){
        if(l<r){
            int m=(l+r)/2;
            return mergeTwoLists(helper(lists,l,m),helper(lists,m+1,r));
        }
        return lists.get(l);
    }
    private ListNode mergeTwoLists(ListNode l1,ListNode l2){
        ListNode dummy=new ListNode(0);
        ListNode cur=dummy;
        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                cur.next=l1;
                l1=l1.next;
            }else{
                cur.next=l2;
                l2=l2.next;
            }
            cur=cur.next;
        }
        if(l1!=null){
            cur.next=l1;
        }else{
            cur.next=l2;
        }
        return dummy.next;
    }*/
    //方法2，使用堆。
    //维护一个大小为k的堆，每次取堆顶的最小元素放到结果中，
    //然后读取该元素的下一个元素放入堆中，重新维护好。
    /*public ListNode mergeKLists(ListNode[] lists){
        PriorityQueue<ListNode> heap=new PriorityQueue<ListNode>(10, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        });
        for(int i=0;i<lists.length;i++){
            ListNode node=lists[i];
            if(node!=null)
                heap.offer(node);
        }
        ListNode head=null;
        ListNode pre=head;
        while(heap.size()>0){
            ListNode cur=heap.poll();
            if(head==null){
                head=cur;
                pre=head;
            }else{
                pre.next=cur;
            }
            pre=cur;
            if(cur.next!=null)
                heap.offer(cur.next);
        }
        return head;
    }*/
    //方法三，两两合并。类似归并排序。有例子不通过
    public ListNode mergeKLists(ListNode[] lists){
        if(lists==null||lists.length==0)
            return null;
        while(lists.length>1){
            List<ListNode> newlists=new ArrayList<ListNode>();
            for(int i=0;i<lists.length-1;i+=2){
                ListNode mergedlist=mergeTwoList(lists[i],lists[i+1]);
                newlists.add(mergedlist);
            }
            if(lists.length%2==1){
                newlists.add(lists[lists.length-1]);
            }
            lists[0]=newlists.get(0);
        }
        return lists[0];
    }
    private ListNode mergeTwoList(ListNode l1,ListNode l2){
        ListNode dummy=new ListNode(0);
        ListNode cur=dummy;
        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                cur.next=l1;
                l1=l1.next;
            }else{
                cur.next=l2;
                l2=l2.next;
            }
            cur=cur.next;
        }
        if(l1!=null){
            cur.next=l1;
        }else{
            cur.next=l2;
        }
        return dummy.next;
    }
}
