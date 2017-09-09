package RemoveDuplicatesFromSortedArray026;

/**
 * Created by Administrator on 2017/9/9.
 */
public class Rdfsa {
    public int removeDuplicates(int[] nums){
        if(nums==null||nums.length==0)
            return 0;
        int size=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=nums[size]){
                nums[++size]=nums[i];
            }
        }
        return size+1;
    }
    public static void main(String[] args){
        int[] nums={1,2,2,3,3,3};
        int len=new Rdfsa().removeDuplicates(nums);
        System.out.println(len);
        for(int i=0;i<len;i++){
            System.out.print(nums[i]);
        }
    }
}
