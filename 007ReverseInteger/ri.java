package ReverseInteger007;

/**
 * Created by Administrator on 2017/8/12.
 */
public class ri {
    //转换成long，用来判断溢出，然后在转换成int
    /*public int reverse(int x) {
        long temp=x;
        long reverse_n=0;
        while(temp!=0){
            reverse_n=reverse_n*10+temp%10;
            temp=temp/10;
        }
        if(reverse_n<Integer.MIN_VALUE||reverse_n>Integer.MAX_VALUE){
            reverse_n=0;
        }
        return (int)reverse_n;
    }*/
    public int reverseInteger(int n){
        int reverse_n=0;
        while(n!=0){
            int temp=reverse_n*10+n%10;
            n=n/10;
            if(temp/10!=reverse_n){
                reverse_n=0;
                break;
            }
            reverse_n=temp;
        }
        return reverse_n;
    }
    public static void main(String[] args){
        int n=1232113321;
        int r=new ri().reverseInteger(n);
        System.out.print(r);
    }
}
