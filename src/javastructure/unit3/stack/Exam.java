package javastructure.unit3.stack;

public class Exam {
    //ex1
    private static final int LEFT = 0;
    private static final int RIGHT = 1;
    private static final int OTHER = 2;
    //ex2
    private int step = 0;
    public static void main(String[] args) throws Exception {
        Exam ex = new Exam();
//        ex.exam3_1();
//        ex.exam3_2("1 123 234 345 456 789", "987 654 321 000");
//        ex.exam3_3("(1 + 2) * (5 - 2)/2^2 + 5%3");
        ex.exam3_4();

    }
    // ex1判定左右符号是否匹配
    private void exam3_1() throws Exception {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("请输入分隔符判定语句：");
//        if (isLegal(sc.nextLine())) {
//            System.out.println("语句合法");
//        } else {
//            System.out.println("语句不合法");
//        }
        String[] strArray = new String[]{"{( 1 + 2 ) * hello[3]} / 18 - 13",
                "/*************/",
                "( 1 + 2 ]",
                "(789 * 567",
                ""
        };
        for (int i = 0; i < strArray.length; i++) {
            try {
                if (isLegal(strArray[i])) {
                    System.out.println("合法");
                } else {
                    System.out.println("不合法");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static boolean isLegal(String str) throws Exception {
        if (!"".equals(str) && str != null) {
            SqStack s = new SqStack();
            int len = str.length();
            for (int i = 0; i < len; i++) {
                char c = str.charAt(i);
                String ss = String.valueOf(c);
                if (i != len - 1) {
                    // 是/*或者*/符号
                    if (("/".equals(ss) && '*' == (str.charAt(i + 1))) || ("*".equals(ss) && '/' == (str.charAt(i + 1)))) {
                        ss = ss + str.charAt(i + 1);
                        i++;
                    }
                }
                if (LEFT == verifyFlag(ss)) {
                    s.push(ss);
                } else if (RIGHT == verifyFlag(ss)) {
                    if (!match(((String) s.pop()), ss)) {
                        throw new Exception("语句不匹配");
                    }
                }
            }
            if (!s.isEmpty()) {
                throw new Exception("语句非法");
            }
            return true;
        } else {
            throw new Exception("语句为空!");
        }
    }

    private static boolean match(String str1, String str2) {
        if (("(".equals(str1) && ")".equals(str2)) ||
                ("[".equals(str1) && "]".equals(str2)) ||
                ("{".equals(str1) && "}".equals(str2)) ||
                ("/*".equals(str1) && "*/".equals(str2))) {
            return true;
        }
        return false;
    }

    private static int verifyFlag(String str) {
        if ("(".equals(str) || "[".equals(str) || "{".equals(str) || "/*".equals(str)) {
            return LEFT;
        } else if (")".equals(str) || "]".equals(str) || "}".equals(str) || "*/".equals(str)) {
            return RIGHT;
        }
        return OTHER;
    }
    // ex2大数和
    private void exam3_2(String str1, String str2) throws Exception {
        System.out.println(str1 + " + " + str2 + "\n= " + bigAdd(str1, str2));
    }

    private String bigAdd(String str1, String str2) throws Exception {
        LinkStack sum = new LinkStack();
        LinkStack sa = strToStack(str1);
        LinkStack sb = strToStack(str2);
        boolean isCarry = false;
        int partialSum = 0;
        while (!sa.isEmpty() && !sb.isEmpty()) {
            partialSum = (int) sa.pop() + (int) sb.pop();
            if (isCarry) {
                partialSum++;
                isCarry = false;
            }
            if (partialSum >= 10) {
                partialSum -= 10;
                isCarry = true;
            }
            sum.push(partialSum);
        }
        LinkStack lastStack = !sa.isEmpty() ? sa : sb; //临时链栈指向剩余堆栈
        while (!lastStack.isEmpty()) {
            if (isCarry) {
                partialSum = (int) lastStack.pop();
                partialSum++;
                if (partialSum >= 10) {
                    partialSum -= 10;
                    isCarry = true;
                    sum.push(partialSum);
                } else {
                    isCarry = false;
                    sum.push(partialSum);
                }
            } else {
                sum.push(lastStack.pop());
            }
        }
        if (isCarry){//最后一位还有进位
            sum.push(1);
        }
        StringBuilder strB = new StringBuilder();
        while (!sum.isEmpty()) {
            strB.append(sum.pop().toString());
        }

        return strB.toString();
    }

    private LinkStack strToStack(String str) throws Exception {
        LinkStack s = new LinkStack();
        if ("".equals(str) || str == null) {
            throw new Exception("数据为空");
        }
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (' ' == c) {
                continue;
            } else if (c >= '0' && c <= '9') {
                s.push(c - '0');
            } else {
                throw new Exception("数据非法");
            }
        }
        return s;
    }

    //ex3中缀表达式变后缀表达式并计算
    private void exam3_3(String expression) throws Exception {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("请输入中缀表达式：");
//        String postfix = convertToPostfix(sc.nextLine());
        System.out.println("中缀表达式为：" + expression);
        String postfix = convertToPostfix(expression);
        System.out.println("后缀表达式为：" + postfix);
        System.out.println("计算结果：" + numberCalculate(postfix));
    }

    private String convertToPostfix(String expression) throws Exception {
        StringBuilder postfix = new StringBuilder();
        LinkStack st = new LinkStack();
        if (expression.length() == 0) {
            throw new Exception("表达式为空");
        }
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (' ' != c) {
                if (isLeftParenthesis(c)) {//左括号
                    st.push(c);
                } else if (isRightParenthesis(c)) {//右括号
                    if (!st.isEmpty()) {
                        char temp = (char) st.pop();
                        while (!isLeftParenthesis(temp)) {//读到左括号为止
                            postfix.append(temp);
                            temp = (char) st.pop();
                        }
                    } else {
                        throw new Exception("括号格式错误");
                    }

                } else if (isOperator(c)) {//运算符号
                    if (!st.isEmpty()) {
                        Character temp = (Character) st.pop();
                        while (temp != null && priority(c) <= priority(temp)) {//弹出的操作符比输入的优先级高
                            postfix.append(temp);
                            temp = (Character) st.pop();
                        }
                        if (temp != null) {//若最后一次取出的优先级低的操作符，重新压栈
                            st.push(temp);
                        }
                        st.push(c);
                    } else {
                        st.push(c);
                    }
                } else {//数据
                    postfix.append(c);
                }

            } else {
                continue;
            }
        }
        while (!st.isEmpty()) {//最后弹出栈内所有符号
            postfix.append(st.pop().toString());
        }
        return postfix.toString();
    }

    private int priority(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
            case '%':
                return 2;
            case '^':
                return 3;
            default:
                return 0;
        }
    }

    private boolean isLeftParenthesis(char c) {
        return c == '(';
    }

    private boolean isRightParenthesis(char c) {
        return c == ')';
    }

    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '%' || c == '^';
    }

    private double numberCalculate(String postfix) throws Exception {
        LinkStack stack = new LinkStack();
        for (int i = 0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);
            if (isOperator(c)) {
                double d1 = Double.valueOf(stack.pop().toString());
                double d2 = Double.valueOf(stack.pop().toString());
                switch (c) {
                    case '+':
                        stack.push(d2 + d1);
                        break;
                    case '-':
                        stack.push(d2 - d1);
                        break;
                    case '*':
                        stack.push(d2 * d1);
                        break;
                    case '/':
                        stack.push(d2 / d1);
                        break;
                    case '%':
                        stack.push(d2 % d1);
                        break;
                    case '^':
                        stack.push(Math.pow(d2, d1));
                        break;
                }
            } else {
                stack.push(c);
            }

        }
        return Double.valueOf(stack.pop().toString());
    }

    //汉诺塔递归
    private void exam3_4() {
        int in[] = new int[]{2, 3, 6};
        for (int i = 0; i < in.length; i++) {
            System.out.println(in[i] + "层汉诺塔移动方式：");
            step = 0;
            hanoi(in[i], 'x', 'y', 'z');
        }

    }
    //把i层塔从x移动到z，辅助塔为y
    private void hanoi(int i, char x, char y, char z) {
        if (i < 1) {
            System.out.println("层数错误");
        } else if (i == 1) {
            move(x, 1, z);
        } else {
            hanoi(i - 1, x, z, y);
            move(x, i, z);
            hanoi(i - 1, y, x, z);
        }
    }

    private void move(char x, int i, char z) {
        step++;
        System.out.println("第" + step + "次移动:\t" + i + "号圆盘从" + x + "-->" + z);
    }


}


