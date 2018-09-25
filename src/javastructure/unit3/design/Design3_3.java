package javastructure.unit3.design;


public class Design3_3 {
    public static void main(String[] args) throws Exception {
        DuSqStack duS = new DuSqStack(10);
        duS.push(1, 1);
        duS.push(2, 1);
        duS.push(3, 1);
        duS.push(4, 1);
        duS.push(-1,2);
        duS.push(-2,2);
        duS.push(-3,2);
        duS.push(-4,2);
        duS.display();
        duS.pop(1);
        duS.pop(1);
        duS.pop(2);
        duS.display();
        duS.push(99,1);
        duS.push(99,1);
        duS.push(99,1);
        duS.push(99,1);
        duS.push(99,1);
        duS.display();
        duS.pop(1);
        duS.pop(1);
        duS.pop(1);
        duS.pop(1);
        duS.pop(1);
        duS.pop(1);
        duS.pop(1);
        duS.pop(1);
        duS.pop(1);
        duS.display();
    }

    static class DuSqStack{
        private Object[] datas;
        //top指向下一个存储单元
        private int top1;
        private int top2;
        public DuSqStack(int maxSize) {
            this.datas = new Object[maxSize];
            this.top1 = 0;
            this.top2 = datas.length - 1;
        }

        public void clear() {
            this.top1 = 0;
            this.top2 = datas.length - 1;
        }

        public boolean isEmpty() {
            return top1 == 0 && top2 == datas.length - 1;
        }

        public int length() {
            return top1 + (datas.length - top2 - 1);
        }


        public void push(Object x, int i) throws Exception {
            if (top1 - top2 == 1) {//栈满
                throw new Exception("栈已满");
            }
            switch (i) {
                case 1:
                    datas[top1] = x;
                    top1++;
                    break;
                case 2:
                    datas[top2] = x;
                    top2--;
                    break;
                default:
                    throw new Exception("不存在此栈");
            }
        }

        public Object pop(int i) {
            if (!isEmpty()) {
                switch (i) {
                    case 1:
                        if (top1 != 0) {
                            return datas[top1--];
                        }
                        return null;
                    case 2:
                        if (top2 != datas.length - 1) {
                            return datas[top2++];
                        }
                        return null;
                    default:
                        return null;
                }
            }
            return null;
        }

        public void display() {
            System.out.println("栈1：");
            for (int i = 0; i < top1; i++) {
                System.out.print(datas[i] + " ");
            }
            System.out.println("\n栈2：");
            for (int i = datas.length - 1; i > top2; i--) {
                System.out.print(datas[i] + " ");
            }
            System.out.println();
        }
    }
}
