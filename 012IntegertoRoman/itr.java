public class itr {
    //方法1
    /*public String intToRoman(int num) {
        String ans="";
        int[] aArray={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] rArray={"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        for(int i=0;i<aArray.length;i++){
            ans+=rArray[i];
            num-=aArray[i];
        }
        return ans;
    }*/
    //方法2
    public String intToRoman(int num){
        String[] M={"","M","MM","MMM"};
        String[] C={"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
        String[] X={"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
        String[] I={"","I","II","III","IV","V","VI","VII","VIII","IX"};
        return M[num/1000]+C[(num/100)%10]+X[(num/10)%10]+I[num%10];
    }
    public static void main(String[] args){
        int num=2134;
        String roman=new itr().intToRoman(num);
        System.out.print(roman);
    }
}
