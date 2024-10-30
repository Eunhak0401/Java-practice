package 객체지향;

public class MemberApp {
    public static void main(String[] args) {
        Member m = new Member("20172829", "지현정", 20172829);
        m.Draw();

        System.out.println(m.toString());
    }
}
