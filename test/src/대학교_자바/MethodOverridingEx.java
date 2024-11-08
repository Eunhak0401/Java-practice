package 대학교_자바;

public class MethodOverridingEx {
    static void paint(Shape p) {
        p.draw(); // p가 가리키는 객체 내에 오버라이딩된 draw() 호출 (동적 바인딩)
    }

    public static void main(String[] args) {
        Line line = new Line();
        paint(line);
        paint(new Shape());
        paint(new Line());
        paint(new Rect());
        paint(new Circle()); // Circle 객체도 추가
    }

    static class Shape { // 슈퍼 클래스
        public Shape next;

        public Shape() {
            next = null;
        }

        public void draw() {
            System.out.println("Shape");
        }
    }

    static class Line extends Shape {
        public void draw() { // 메소드 오버라이딩
            System.out.println("Line");
        }
    }

    static class Rect extends Shape {
        public void draw() { // 메소드 오버라이딩
            System.out.println("Rect");
        }
    }

    static class Circle extends Shape {
        public void draw() { // 메소드 오버라이딩
            System.out.println("Circle");
        }
    }
}