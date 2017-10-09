package ImplementstrStr028;

/**
 * Created by Administrator on 2017/10/9.
 * 判断一个字符串是否是另一个字符串的子串。
 * 这个题目最经典的算法应该是KMP算法，KMP算法是最优的线性算法，
 * 复杂度已经达到这个问题的下限。
 * 但是KMP算法比较复杂，很难在面试的短时间里面完整正确的实现。
 * 所以一般在面试中并不要求实现KMP算法。
 */
public class Iss {
    //方法1，brute force的算法，假设原串的长度是n，匹配串的长度是m。
    //思路很简单，就是对原串的每一个长度为m的字串都判断是否跟匹配串一致。
    //总共有n-m+1个子串，所以算法时间复杂度为O((n-m+1)*m)=O(n*m)，空间复杂度是O(1)。
    /*public int strStr(String haystack,String needle){
        if(haystack==null||needle==null||needle.length()==0)
            return 0;
        if(needle.length()>haystack.length())
            return -1;
        for(int i=0;i<=haystack.length()-needle.length();i++){
            boolean flag=true;
            for(int j=0;j<needle.length();j++){
                if(haystack.charAt(i+j)!=needle.charAt(j)){
                    flag=false;
                    break;
                }
            }
            if(flag)
                return i;
        }
        return -1;
    }*/

    /*public int strStr(String source, String target) {
        if (source == null || target == null) {
            return -1;
        }

        for (int i = 0; i < source.length() - target.length() + 1; i++) {
            int j = 0;
            for (j = 0; j < target.length(); j++) {
                if (source.charAt(i + j) != target.charAt(j)) {
                    break;
                }
            }
            // finished loop, target found
            if (j == target.length()) {
                return i;
            }
        }
        return -1;
    }*/
    //kmp算法
    public int strStr(String haystack, String needle) {

        if (haystack == null || needle == null) {
            return -1;
        }

        if (needle.length() > haystack.length()) {
            return -1;
        }

        if ("".equals(haystack)) {
            if ("".equals(needle)) {
                return 0;
            } else {
                return -1;
            }
        } else {
            if ("".equals(needle)) {
                return 0;
            }
        }
        return kmpIndex(haystack, needle);
    }

    private int kmpIndex(String haystack, String needle) {
        int i = 0;
        int j = 0;
        int[] next = next(needle);
        while (i < haystack.length() && j < needle.length()) {
            if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
                ++i;
                ++j;
            } else {
                j = next[j];
            }
        }
        if (j == needle.length()) {
            return i - j;
        } else {
            return -1;
        }
    }

    private int[] next(String needle) {
        int[] next = new int[needle.length()];
        next[0] = -1;
        int i = 0;
        int j = -1;
        int k = needle.length() - 1;
        while (i < k) {
            if (j == -1 || needle.charAt(i) == needle.charAt(j)) {
                ++i;
                ++j;
                if (needle.charAt(i) != needle.charAt(j)) {
                    next[i] = j;
                } else {
                    next[i] = next[j];
                }
            } else {
                j = next[j];
            }
        }
        return next;
    }
    public static void main(String[] args){
        String source=null;
        String target="";
        int r=new Iss().strStr(source,target);
        System.out.print(r);
    }
}
