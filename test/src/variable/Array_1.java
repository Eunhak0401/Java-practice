package variable;

public class Array_1 {
    public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5};
    int sum = 0;
    int i = 0;

    while (i < arr.length) {
            sum += arr[i];
            i += 1;
    }
        System.out.println(sum);
    }
}
