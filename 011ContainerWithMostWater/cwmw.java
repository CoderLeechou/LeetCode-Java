package ContaineWithMostWater011;

/**
 * Created by Administrator on 2017/8/16.
 */
public class cwmw {
    //方法1，贪心算法
    /*public int maxArea(int[] height){
        if(height==null||height.length<2)
            return 0;
        int result=0;
        int left=0;
        int right=height.length-1;
        while(left<right){
            result=Math.max(result,Math.min(height[left],height[right])*(right-left));
            if (height[left]<height[right]){
                int k=left;
                while(k<right&&height[k]<=height[left]){
                    k++;
                }
                left=k;
            }
            else{
                int k=right;
                while(k>left&&height[k]<=height[right]){
                    k--;
                }
                right=k;
            }
        }
        return result;
    }*/
    //方法2,brute force进行夹逼优化，优化没有方法1好，效率比方法1低很多
    public int maxArea(int[] height) {
        if(height==null || height.length==0)
            return 0;
        int l = 0;
        int r = height.length-1;
        int maxArea = 0;
        while(l<r)
        {
            maxArea = Math.max(maxArea, Math.min(height[l],height[r])*(r-l));
            if(height[l]<height[r])
                l++;
            else
                r--;
        }
        return maxArea;
    }

    public static void main(String[] args){
        int[] height={1,2};
        int maxArea=new cwmw().maxArea(height);
        System.out.print(maxArea);
    }
}
