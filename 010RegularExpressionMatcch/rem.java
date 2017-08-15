package RegularExpressionMatching010;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/8/15.
 */
public class rem {
    //方法1，使用标记匹配算法，从后向前进行匹配
    public boolean isMatch(String s,String p){
        //标记数数组
        boolean[] match=new boolean[s.length()+1];
        Arrays.fill(match,false);
        match[s.length()]=true;
        //对模式串从后向前进行处理
        for(int i=p.length()-1;i>=0;i--){
            //如果当前是*
            if(p.charAt(i)=='*'){
                //匹配串从最后一个开始处理
                for(int j=s.length()-1;j>=0;j--){
                    match[j]=match[j]||match[j+1]&&(p.charAt(i-1)=='.'||s.charAt(j)==p.charAt(i-1));
                }
                i--;
            }
            //如果不是*
            else{
                for(int k=0;k<s.length();k++){
                    match[k]=match[k+1]&&(p.charAt(i)=='.'||p.charAt(i)==s.charAt(k));
                }
                match[s.length()]=false;
            }
        }
        return match[0];
    }
    //方法2，brute force暴力算法。先看字符串s和p的从i和j开始的子串是否匹配，
    //用递归的方法直到串的最后，最后回溯回来得到结果。
    /*public boolean isMatch(String s,String p){
        return helper(s,p,0,0);
    }
    private boolean helper(String s,String p,int i,int j){
        if(j==p.length())
            return i==s.length();
        if(j==p.length()-1||p.charAt(j+1)!='*'){
            if(i==s.length()||s.charAt(i)!=p.charAt(j)&&p.charAt(j)!='.')
                return false;
            else
                return helper(s,p,i+1,j+1);
        }
        while(i<s.length()&&(p.charAt(j)=='.'||s.charAt(i)==p.charAt(j))){
            if(helper(s,p,i,j+2))
                return true;
            i++;
        }
        return helper(s,p,i,j+2);
    }*/
    public static void main(String[] args){
        String s="ab";
        String p=".*";
        boolean r=new rem().isMatch(s,p);
        System.out.print(r);
    }
}
