class Number{
    static int num = 0;
    int num2 = 0;
}

class Name {
    static void print(){
        System.out.println("안녕하세요 저는 홍길동입니다!");
    }
    void print2(){
        System.out.println("안녕하세요 저는 이은학입나다!");
    }
}

public class static_ex {
    public static void main(String[] args) {
//        Number number1 = new Number();
//        Number number2 = new Number();
//
//        number1.num++;
//        number1.num2++;
//        System.out.println(number2.num);
//        System.out.println(number2.num2);

        Name.print();

        Name name = new Name();
        name.print2();

    }
}

