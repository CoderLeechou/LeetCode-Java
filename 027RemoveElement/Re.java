package RemoveElement027;

/**
 * Created by Administrator on 2017/10/8.
 * 一个指针从前往后走，如果遇到要删除的元素，
 * 就从后面调一个不需要删除的元素替换它，直到结束。复杂度是O(n)，
 * 因为每个元素最多被访问一次。
 */
public class Re {
    public int removeElement(int[] nums,int val){
        if(nums==null)
            return 0;
        int len=nums.length-1;
        for(int i=0;i<=len;i++){
            if(nums[i]==val){
                //这里交换元素后，自减重新判断是否相等
                nums[i--]=nums[len--];
            }
        }
        return len+1;
    }
    public static void main(String[] args){
        int[] nums={3,2,2,3};
        int val=3;
        int ret=new Re().removeElement(nums,val);
        System.out.print(ret);
    }
}
