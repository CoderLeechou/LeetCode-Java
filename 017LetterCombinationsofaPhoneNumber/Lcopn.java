package LetterCombinationsofPhoneNumber017;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by Administrator on 2017/8/26.
 */
public class Lcopn {
    //方法1，使用Map
    /*public List<String> letterCombinations(String digits){
        ArrayList<String> result=new ArrayList<String>();

        if(digits==null||digits.equals(""))
            return result;

        Map<Character,char[]> map=new HashMap<Character, char[]>();
        map.put('0',new char[]{});
        map.put('1',new char[]{});
        map.put('2',new char[]{'a','b','c'});
        map.put('3',new char[]{'d','e','f'});
        map.put('4',new char[]{'g','h','i'});
        map.put('5',new char[]{'j','k','l'});
        map.put('6',new char[]{'m','n','o'});
        map.put('7',new char[]{'p','q','r','s'});
        map.put('8',new char[]{'t','u','v'});
        map.put('9',new char[]{'w','x','y','z'});

        StringBuilder sb=new StringBuilder();
        helper(map,digits,sb,result);

        return result;
    }
    private void helper(Map<Character,char[]>map,String digits,
                        StringBuilder sb,ArrayList<String> result){
        if(sb.length()==digits.length()){
            result.add(sb.toString());
            return;
        }
        //sb.length()初始值为0，因为创建StringBuilder的对象值为""
        //foreach循环，与python的for循环类似
        for(char c:map.get(digits.charAt(sb.length()))){
            sb.append(c);
            //递归调用
            helper(map,digits,sb,result);
            sb.deleteCharAt(sb.length()-1);
        }
    }*/

    //方法2，利用字符串数组，核心还是递归
    /*ArrayList<String> ans=new ArrayList<>();
    //foreach循环加递归
    void dfs(int x,int l,String str,String digits,String phone[]){
        if(x==l){
            ans.add(str);
            return;
        }
        int d=digits.charAt(x)-'0';
        for(char c:phone[d].toCharArray()){
            dfs(x+1,l,str+c,digits,phone);
        }
    }
    public ArrayList<String> letterCombinations(String digits){
        String phone[]={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        if(digits.length()==0){
            return ans;
        }
        dfs(0,digits.length(),"",digits,phone);
        return ans;
    }*/

    //方法3,使用switch和两层循环
    public ArrayList<String> letterCombinations(String digits){
        ArrayList<String> res=new ArrayList<String>();
        if(digits==null||digits.length()==0)
            return res;
        //赋空值，size()=1
        res.add("");
        for(int i=0;i<digits.length();i++){
            String letters=getLetters(digits.charAt(i));
            ArrayList<String> newRes=new ArrayList<String>();
            for(int j=0;j<res.size();j++){
                for(int k=0;k<letters.length();k++){
                    newRes.add(res.get(j)+Character.toString(letters.charAt(k)));
                }
            }
            res=newRes;
        }
        return res;
    }
    private String getLetters(char digit){
        switch(digit){
            case '2':
                return "abc";
            case '3':
                return "def";
            case '4':
                return "ghi";
            case '5':
                return "jkl";
            case '6':
                return "mno";
            case '7':
                return "pqrs";
            case '8':
                return "tuv";
            case '9':
                return "wxyz";
            default:
                return "";
        }
    }

    public static void main(String[] args){
        String dig="23";
        List<String> res=new Lcopn().letterCombinations(dig);
        System.out.print(res);
    }
}

