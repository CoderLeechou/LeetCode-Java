package GenerateParenthese022;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/31.
 * 使用卡特兰数公式。
 * 递归求解第一对括号里包含几对括号
 * "((()))","(()())","(())()","()(())","()()()"
 * 在每次递归函数中记录左括号和右括号的剩余数量，然后有两种选择，
 * 一个是放一个左括号，另一种是放一个右括号。当然有一些否定条件，
 * 比如剩余的右括号不能比左括号少，或者左括号右括号数量都要大于0。
 * 正常结束条件是左右括号数量都为0。
 */
public class Gp{
    public ArrayList<String> generateParenthesis(int n){
        ArrayList<String> res=new ArrayList<String>();
        if(n<=0)
            return res;
        helper(n,n,"",res);
        return res;
    }
    private void helper(int l,int r,String paren,ArrayList<String> res){
        if(r<l)
            return;
        if(l==0&&r==0){
            res.add(paren);
        }
        if(l>0)
            helper(l-1,r,paren+"(",res);
        if(r>0)
            helper(l,r-1,paren+")",res);
    }
    public static void main(String[] args){
        int n=3;
        ArrayList<String> res=new Gp().generateParenthesis(n);
        System.out.print(res);
    }
}
