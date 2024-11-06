package 대학교_자바;

class Point_2 {
    private int x, y; // 핚 점을 구성하는 x, y 좌표
    public Point_2() {
        this.x = this.y = 0;
    }
    public Point_2(int x, int y) {
        this.x = x; this.y = y;
    }
    public void showPoint() { // 점의 좌표 출력
        System.out.println("(" + x + "," + y + ")");
    }
}

class ColorPoint_1 extends Point_2 {
    private String color; // 점의 색
    public ColorPoint_1(int x, int y, String color) {
        super(x, y); // Point의 생성자 Point(x, y) 호출
        this.color = color;
    }
    public void showColorPoint() { // 컬러 점의 좌표 출력
        System.out.print(color);
        showPoint(); // Point 클래스의 showPoint() 호출
    }
}

public class SuperEx {
    public static void main(String[] args) {
        ColorPoint_1 cp = new ColorPoint_1(5, 6, "blue");
        cp.showColorPoint();
    }
}
