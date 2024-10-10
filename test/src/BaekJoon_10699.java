import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BaekJoon_10699 {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        String formattedNow = now.format(formatter);
        System.out.println(formattedNow);
    }
}
