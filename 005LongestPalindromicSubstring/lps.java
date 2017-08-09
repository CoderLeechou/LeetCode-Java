package LongestPalindromicSubstring005;

/**
 * Created by Administrator on 2017/8/9.
 */
public class lps {
    //方法1
    /*public String longestPalindrome(String s){
        if (s == null||s.length()==0){
            return "";
        }
        int length=s.length();
        int max=0;
        String result = "";
        for(int i=1;i<=2*length-1;i++){
            int count=1;
            while(i-count>=0&&i+count<=2*length&&getChar(s,i-count)==getChar(s,i+count)){
                count++;
            }
            count--;
            if(count>max){
                result=s.substring((i-count)/2,(i+count)/2);
                max=count;
            }
        }
        return result;
    }
    private char getChar(String s,int i){
        if(i%2==0)
            return '#';
        else
            return s.charAt(i/2);
    }*/
    //方法2
    /*public String longestPalindrome(String s){
        if(s==null||s.length()==0)
            return "";
        int max=0;
        String res="";
        for(int i=0;i<2*s.length()-1;i++){
            int left=i/2;
            int right=i/2;
            if(i%2==1)
                right++;
            String str=lengthOfPalindrome(s,left,right);
            if(max<str.length()){
                max=str.length();
                res=str;
            }
        }
        return res;
    }
    private String lengthOfPalindrome(String s,int left,int right){
        while(left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return s.substring(left+1,right);
    }*/
    //方法3，动态规划DP,有问题
    public String longestPalindrome(String s) {
        int n = s.length();
        int longestBegin = 0;
        int maxLen = 1;
        boolean[][] table = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            table[i][i] = true;
        }
        for (int i = 0; i < n-1; i++) {
            if (s.charAt(i) == s.charAt(i+1)) {
                table[i][i+1] = true;
                longestBegin = i;
                maxLen = 2;
            }
        }
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i < n-len+1; i++) {
                int j = i+len-1;
                if (s.charAt(i) == s.charAt(j) && table[i+1][j-1]) {
                    table[i][j] = true;
                    longestBegin = i;
                    maxLen = len;
                }
            }
        }
        return s.substring(longestBegin-1, maxLen);
    }
    public static void main(String[] args){
        String s="babad";
        String l=new lps().longestPalindrome(s);
        System.out.print(l);
    }

}
