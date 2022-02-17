
/**
 * @author liuzk
 * @version 1.0
 * @create 2022-02-16 23:42
 */
public class Ex4_EffectiveBrackets {
    public static void main(String[] args) {
        System.out.println(effectiveBrackets("(((}}}"));

    }
    //耗时高
    public static boolean effectiveBrackets(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            if (a == '[' || a == '{' || a == '(') {
                stack.push(a);
            } else {
                if (!stack.isEmpty()) {
                    String temp = stack.pop() + "" +a;
                    if (!("()".equals(temp) || "[]".equals(temp)
                            ||"{}".equals(temp))){
                       return false;
                    }
                }else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char a : s.toCharArray()) {
            if (a == '[' || a == '{' || a == '(') {
                stack.push(a);
            } else {
                if (!stack.isEmpty()) {
                    char temp = stack.pop();
                    if ((temp == '[' && a != ']')||(temp == '{' && a != '}')||
                    (temp == '(' && a != ')')){
                        return false;
                    }
                }else{
                    //说明右括号过多
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
