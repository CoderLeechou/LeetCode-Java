package ThreeSum015;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/23.
 */
public class ts {
    //方法1
    /*public List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> result=new LinkedList<>();
        if(nums!=null&&nums.length>2){
            //对数组排序，好处是遇到相同的数可以直接跳过
            Arrays.sort(nums);
            for(int i=0;i<nums.length-2;){
                int j=i+1;
                int k=nums.length-1;
                while(j<k){
                    if(nums[j]+nums[k]==-nums[i]){
                        List<Integer> list=new ArrayList<>(3);
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        result.add(list);
                        k--;
                        j++;
                        //从左向右找与第一个数不相同的数
                        while(j<k&&nums[j]==nums[j-1]){
                            j++;
                        }
                        //从右向左找与第一个数不相同的数
                        while(j<k&&nums[k]==nums[k+1]){
                            k--;
                        }
                    }
                    //和大于0
                    else if(nums[j]+nums[k]>-nums[i]){
                        k--;
                        //因为已经排过序，从右向左找与第一个数不同的数
                        while(j<k&&nums[k]==nums[k+1]){
                            k--;
                        }
                    }
                    //和小于0
                    else{
                        j++;
                        //因为已经排过序，从左向右找与第一个数不同的数
                        while(j<k&&nums[j]==nums[j-1]){
                            j++;
                        }
                    }
                }
                i++;
                //从左向右找与第一个数不同的数
                while(i<nums.length-2&&nums[i]==nums[i-1]){
                    i++;
                }
            }
        }
        return result;
    }*/
    //方法2
    public List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> results=new ArrayList<>();
        if(nums==null||nums.length<3){
            return results;
        }
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            int left=i+1;
            int right=nums.length-1;
            int target=-nums[i];
            twoSum(nums,left,right,target,results);
        }
        return results;
    }
    public void twoSum(int[] nums,int left,int right,int target,List<List<Integer>> results){
        while(left<right){
            if(nums[left]+nums[right]==target){
                ArrayList<Integer> triple=new ArrayList<>();
                triple.add(-target);
                triple.add(nums[left]);
                triple.add(nums[right]);
                results.add(triple);
                left++;
                right--;
                while(left<right&&nums[left]==nums[left-1]){
                    left++;
                }
                while(left<right&&nums[right]==nums[right+1]){
                    right--;
                }
            }
            else if(nums[left]+nums[right]<target){
                left++;
            }
            else{
                right--;
            }
        }
    }

    public static void main(String[] args){
        int[] nums={-1, 0, 1, 2, -1, -4};
        List<List<Integer>> res=new ts().threeSum(nums);
        System.out.print(res);
    }
}
