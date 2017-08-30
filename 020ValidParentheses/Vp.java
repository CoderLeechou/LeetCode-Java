package ValidParentheses020;

import java.util.Stack;

/**
 * Created by Administrator on 2017/8/30.
 */
public class Vp {
    //方法1。把括号左边({[压入堆栈，与下一个对比，相同则出栈
    /*public boolean isValidParentheses(String s){
        Stack<Character> stack=new Stack<Character>();
        for(Character c:s.toCharArray()){
            if("({[".contains(String.valueOf(c))){
                stack.push(c);
            }else{
                if(!stack.isEmpty()&&is_valid(stack.peek(),c)){
                    stack.pop();
                }else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private boolean is_valid(char c1,char c2){
        return (c1=='('&&c2==')')||(c1=='{'&&c2=='}')||(c1=='['&&c2==']');
    }*/

    //方法2
    public boolean isValidParentheses(String s){
        Stack<Character> stack=new Stack<Character>();
        for(char c:s.toCharArray()){
            if(c=='('||c=='{'||c=='['){
                stack.push(c);
            }
            if(c==')'){
                if(stack.isEmpty()||stack.pop()!='('){
                    return false;
                }
            }
            if(c==']'){
                if(stack.isEmpty()||stack.pop()!='['){
                    return false;
                }
            }
            if(c=='}'){
                if(stack.isEmpty()||stack.pop()!='{'){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args){
        String s="([)]";
        boolean res=new Vp().isValidParentheses(s);
        System.out.print(res);
    }
}
