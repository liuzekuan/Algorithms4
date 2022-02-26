package ex1_3;

/**
 * 由一个缺少左括号的表达式打印出补全右括号的中序表达式
 * 如输入：1+2)*3-4)*5-6)))
 * 得到
 * ((1+2)*((3-4)*(5-6)))
 *
 * @author liuzk
 * @version 1.0
 * @create 2022-02-19 22:43
 */

public class Ex9_OrdinalExpression {
    public static void main(String[] args) {
        System.out.println(getOrdinalExperssion("1+2)*3-4)*5-6)))"));
    }

    /**
     * 输入：1+2)*3-4)*5-6)))+1+2)
     * 得到
     * ((1+2)*((3-4)*(5-6)))
     * 思路
     * 1.建立两个栈，符号栈和数字栈
     * 2.遇到数字入数字栈，遇到符号入符号栈
     * 3.遇到左括号取出数字栈顶两个数和一个符号栈顶的数拼接右括号入栈
     */
    public static String getOrdinalExperssion(String str) {
        Stack<String> numStack = new Stack<>();
        Stack<Character> chStack = new Stack<>();
        for (char c : str.toCharArray()) {
            if ('0' <= c && c <= '9') {
                numStack.push(""+c);
            } else if (c==')') {
                String a=numStack.pop();
                String b=numStack.pop();
                String temp="("+b+chStack.pop()+a+c;
                numStack.push(temp);
            } else {
                chStack.push(c);
            }
        }
        return numStack.pop();
    }




}
