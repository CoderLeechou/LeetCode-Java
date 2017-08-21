package RomantoInteger013;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/8/21.
 */
public class rti {
    //方法1，我觉得最棒的
    /*public int romanInt(String s){
        int ans=0;
        int[] aArray={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] rArray={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        for(int i=0;i<rArray.length;i++){
            while(s.indexOf(rArray[i])==0){
                ans+=aArray[i];
                s=s.substring(rArray[i].length());
            }
        }
        return ans;
    }*/
    //方法2，使用Map
    /*public int romanInt(String s){
        if (s==null||s.length()==0)
            return 0;
        Map<Character,Integer> m=new HashMap<Character,Integer>();
        m.put('I',1);
        m.put('V',5);
        m.put('X',10);
        m.put('L',50);
        m.put('C',100);
        m.put('D',500);
        m.put('M',1000);
        int len=s.length();
        int res=m.get(s.charAt(len-1));
        for(int i=len-2;i>=0;i--){
            if(m.get(s.charAt(i+1))<=m.get(s.charAt(i))){
                res+=m.get(s.charAt(i));
            }else {
                res-=m.get(s.charAt(i));
            }
        }
        return res;
    }*/
    //方法3,switch
    public int romanInt(String s){
        int ans;
        char[] sc=s.toCharArray();
        ans=toInt(sc[0]);
        for(int i=1;i<s.length();i++){
            ans+=toInt(sc[i]);
            if(toInt(sc[i-1])<toInt(sc[i])){
                ans-=toInt(sc[i-1])*2;
            }
        }
        return ans;
    }
    int toInt(char s){
        switch (s){
            case 'I':return 1;
            case 'V':return 5;
            case 'X':return 10;
            case 'L':return 50;
            case 'C':return 100;
            case 'D':return 500;
            case 'M':return 1000;
        }
        return 0;
    }


    public static void main(String[] args){
        String s="MCMXLI";
        int r=new rti().romanInt(s);
        System.out.print(r);
    }
}
