package 대학교_자바;

public class Circle_1025_1 {
    int radius;
    public Circle_1025_1(int radius) {this.radius = radius; }
    public void set(int radius) {this.radius = radius; }

    public static void main(String[] args) {
        Circle_1025_1 ob1 = new Circle_1025_1(1);
        Circle_1025_1 ob2 = new Circle_1025_1(2);
        Circle_1025_1 s;

        s = ob2;
        ob1 = ob2;
        System.out.println("ob1.radius = " + ob1.radius);
        System.out.println("ob2.radius = " + ob2.radius);
    }

}
