package 대학교_자바;

public class for_each_1004_1 {
    public static void main(String[] args) {
        int[] n = {1, 2, 3, 4, 5};
        String[] names = {"사과", "배", "바나나", "체리", "딸기", "포도"};
        String[] Week = {"월", "화", "수", "목", "금", "토", "일"};

        int sum = 0;
        for(int k : n){
            System.out.print(k + "");
            sum += k;
        }
        System.out.println(" 합은 " + sum);

        for (String s : names)
            System.out.print(s + " ");
        System.out.println();

        for (String w: Week)
            System.out.print(w + "요일 ");
        System.out.println();
    }
}
