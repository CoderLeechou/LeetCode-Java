package LongestCommonPrefix014;

/**
 * Created by Administrator on 2017/8/22.
 */
public class lcp {
    //方法1，从第一个字符开始，对每个字符串比较，然后到第二个字符
    /*public String longestCommonPrefix(String[] strs){
        if (strs==null||strs.length==0)
            return "";
        int index=0;
        StringBuffer res=new StringBuffer();
        while(index<strs[0].length()){
            for(int i=0;i<strs.length;i++){
                if(index>strs[i].length()-1||strs[i].charAt(index)!=strs[0].charAt(index))
                    return res.toString();
            }
            res.append(strs[0].charAt(index));
            index++;
        }
        return res.toString();
    }*/
    //方法2，从第一个字符串开始，依次与下一个字符串比较
    public String longestCommonPrefix(String[] strs){
        if(strs==null||strs.length==0)
            return "";
        String prefix=strs[0];
        for(int i=1;i<strs.length;i++){
            int j=0;
            while(j<strs[i].length()&&j<prefix.length()&&strs[i].charAt(j)==prefix.charAt(j)){
                j++;
            }
            if(j==0){
                return "";
            }
            prefix=prefix.substring(0,j);
        }
        return prefix;
    }
    public static void main(String[] args){
        String[] strs={"abd","abc","ab"};
        String str=new lcp().longestCommonPrefix(strs);
        System.out.print(str);
    }
}
