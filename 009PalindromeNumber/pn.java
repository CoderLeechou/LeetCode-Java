package PalindromeNumber009;

/**
 * Created by Administrator on 2017/8/14.
 */
public class pn {
    public boolean isPalindrome(int x){
        if(x<0)
            return false;
        int div=1;
        while(div<=x/10)
            div*=10;
        while(x>0){
            if(x/div!=x%10)
                return false;
            x=(x%div)/10;
            div/=100;
        }
        return true;
    }
    public static void main(String[] args){
        int x=12321;
        boolean r=new pn().isPalindrome(x);
        System.out.print(r);
    }
}

