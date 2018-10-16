package javastructure.unit7.work;

public class Student {
    public int id;
    public String name;
    public double score;

    public Student(int id, String name, double score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return "学号:" + id + "\t姓名：" + name + "\t成绩：" + score;
    }
}
