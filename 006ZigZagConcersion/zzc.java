package ZigZagConversion006;

/**
 * Created by Administrator on 2017/8/10.
 */
public class zzc {
    public String convert(String s,int nRows){
        if(s==null||s.length()==0||nRows<=0)
            return "";
        if(nRows==1)
            return s;
        StringBuilder res=new StringBuilder();
        int size=2*nRows-2;
        for(int i=0;i<nRows;i++){
            for(int j=i;j<s.length();j+=size){
                res.append(s.charAt(j));
                if(i!=0&&i!=nRows-1){
                    int temp=j+size-2*i;
                    if(temp<s.length())
                        res.append(s.charAt(temp));
                }
            }
        }
        return res.toString();
    }
    public static void main(String[] args){
        String s="PAYPALISHIRING";
        String r=new zzc().convert(s,3);
        System.out.print(r);
    }
}
