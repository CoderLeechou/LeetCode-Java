package MedianofTwoSortedArrays004;

/**
 * Created by Administrator on 2017/8/8.
 */
public class motsa {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len=nums1.length+nums2.length;
        if(len%2==1){
            return findKth(nums1,0,nums2,0,len/2+1);
        }
        return (findKth(nums1,0,nums2,0,len/2)+
                findKth(nums1,0,nums2,0,len/2+1))/2.0;
    }
    public static int findKth(int[] A,int A_start,int[] B,int B_start,int k){
        if(A_start>=A.length){
            return B[B_start+k-1];
        }
        if(B_start>=B.length){
            return A[A_start+k-1];
        }
        if(k==1){
            return Math.min(A[A_start],B[B_start]);
        }
        int A_key=A_start+k/2-1<A.length?A[A_start+k/2-1]:Integer.MAX_VALUE;
        int B_key=B_start+k/2-1<B.length?B[B_start+k/2-1]:Integer.MAX_VALUE;
        if (A_key<B_key){
            return findKth(A,A_start+k/2,B,B_start,k-k/2);//切记不能写为k/2,k/2!=k-k/2
        }
        else{
            return findKth(A,A_start,B,B_start+k/2,k-k/2);
        }
    }
    public static void main(String[] args){
        int[] A={1,5};
        int[] B={3,4};
        double c=new motsa().findMedianSortedArrays(A,B);
        System.out.print(c);

    }























}
