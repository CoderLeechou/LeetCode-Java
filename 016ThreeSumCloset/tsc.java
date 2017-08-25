package ThreeSumCloset016;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/8/25.
 */
public class tsc {
    //方法1
    /*public int threeSumCloset(int[] nums,int target){
        int minDiff=Integer.MIN_VALUE;
        int result=0;
        int sum,diff;
        if(nums==null||nums.length<=2)
            return Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            int j=i+1;
            int k=nums.length-1;
            while(j<k){
                sum=nums[i]+nums[j]+nums[k];
                diff=Math.abs(target-sum);
                if(diff==0)
                    return sum;
                if(diff<minDiff){
                    minDiff=diff;
                    result=sum;
                }
                if(sum>target){
                    k--;
                }else{
                    j++;
                }
            }
        }
        return result;
    }*/
    //方法2,3转2
    public int threeSumCloset(int[] nums,int target){
        if(nums==null||nums.length<=2)
            return Integer.MAX_VALUE;
        Arrays.sort(nums);
        int closet=nums[0]+nums[1]+nums[2];
        for(int i=0;i<nums.length-2;i++){
            int cur=twoSum(nums,target-nums[i],i+1);
            if(Math.abs(cur)<Math.abs(closet))
                closet=cur;
        }
        return target+closet;
    }
    private int twoSum(int[] nums,int target,int start){
        int closet=nums[start]+nums[start+1]-target;
        int l=start;
        int r=nums.length-1;
        while(l<r){
            if(nums[l]+nums[r]==target)
                return 0;
            int diff=nums[l]+nums[r]-target;
            if(Math.abs(diff)<Math.abs(closet))
                closet=diff;
            if(nums[l]+nums[r]>target){
                r--;
            }else{
                l++;
            }
        }
        return closet;
    }
    public static void main(String[] args){
        int[] nums={1,2,3,4,5};
        int tar=6;
        int res=new tsc().threeSumCloset(nums,tar);
        System.out.print(res);
    }
}
