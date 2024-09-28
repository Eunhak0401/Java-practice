package 대학교_자바;

public class co_0927_1 {
    public static void main(String[] args) {
        int sum = 0;

        for (int i = 1; i < 31; i++) {
            if(i%3 != 0){
                sum+=i;
                continue;
            }
        }
        System.out.println("30까지의 3의 배수의 합은 " + sum + "입니다.");
    }
}
