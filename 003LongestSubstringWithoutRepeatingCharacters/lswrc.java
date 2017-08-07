package LongestSubstringWithoutRepeatingCharacters003;

import java.util.HashMap;

/**
 * Created by Administrator on 2017/8/7.
 */
public class lswrc {
    /*public int lengthOfLongestSubstring(String s){
        if(s==null)return 0;
        HashMap<Character,Integer>map=new HashMap<Character,Integer>();
        int start=0;
        int maxLen=0;
        int len=0;
        for(int i=0;i<s.length();i++){
            if(!map.containsKey(s.charAt(i))){
                len++;
                if(len>maxLen)maxLen=len;
                map.put(s.charAt(i),i);
            }else{
                int index=map.get(s.charAt(i));
                for(int j=start;j<=index;j++){
                    map.remove(s.charAt(j));
                }
                map.put(s.charAt(i),i);
                start=index+1;
                len=i-index;
            }
        }
        return maxLen;
    }*/
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }
    public static void main(String[] args){
        String t="abcabcabc";
        int a=new lswrc().lengthOfLongestSubstring(t);
        System.out.print(a);
    }
}

