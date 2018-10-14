public class testDemo {
    public static void main(String[] args) {
        char c = 'A';
        Object ob = new Object();
        ob = c;
        for (int i = 0; i < 5; i++) {
            System.out.println(c++);
        }
        System.out.println(ob);


    }
}
