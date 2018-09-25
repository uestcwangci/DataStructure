package javastructure.unit3.queue.example;

import javastructure.unit3.queue.LinkQueue;
import javastructure.unit3.stack.SqStack;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Example3_7 {
    private SqStack S = new SqStack(10);//停车场只允许停10辆车
    private LinkQueue Q = new LinkQueue();//便道停车无上限
    private static final int LEAVE = 359;
    private static final int ARRIVE = 344;

    class CarInfo {
        public int state;
        public int id;
        public long arriveTime;
        public long leaveTime;
    }

    public static void main(String[] args) throws Exception {
        Example3_7 ex = new Example3_7();
        for (int i = 0; i < 15; i++) {
            ex.parkingManag(i, "arrive");
        }
        System.out.println("请输入车牌号：");
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();
        System.out.println("arrive or leave ?");
        String state = sc.next();
        ex.parkingManag(id, state);
    }

    private void parkingManag(int id, String state) throws Exception {
        if ("arrive".equals(state)) {
            CarInfo car = new CarInfo();
            car.id = id;
            if (S.length() < 10) {//停车场未满
                S.push(car);
                car.arriveTime = System.currentTimeMillis();
                car.state = ARRIVE;
                System.out.println(car.id + "号车停在停车场第" + (S.length() - 1) + "个位置");
            } else {
                Q.offer(car);
                System.out.println(car.id + "号车停在便道第" + (Q.length() - 1) + "个位置");
            }


        } else if ("leave".equals(state)) {//离开只能是从停车场离开
            CarInfo car = new CarInfo();
            SqStack S2 = new SqStack(10);//用于存放避让离开的车而暂时定义的栈
            int location = S.length() - 1;

            while ((car = (CarInfo) S.pop()) != null && car.id != id) {
                S2.push(car);
                location--;
            }
            if (car != null) {
                car.leaveTime = System.currentTimeMillis();
                car.state = LEAVE;
                long stayTime = car.leaveTime - car.arriveTime;
                DecimalFormat df = new DecimalFormat("0.0");
                System.out.println(location + "停车位上的" + car.id + "号车已开走,费用为："
                        + df.format((stayTime/1000.0/60.0) * 20.0));
                while (!S2.isEmpty()) {
                    S.push((CarInfo)S2.pop());
                }
                if (!Q.isEmpty()) {
                    car = (CarInfo) Q.poll();
                    car.arriveTime = System.currentTimeMillis();
                    car.state = ARRIVE;
                    S.push(car);
                }
            }


        }
    }



}
