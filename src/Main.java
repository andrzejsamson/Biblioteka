import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args) {
        DateTimeFormatter dft = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dft.format(now));
        LocalDateTime newDate = now.plusMonths(1);
        System.out.println(dft.format(newDate));
    }
}
