import java.util.Scanner;
import java.util.function.Supplier;

public class ConsoleInputView {
    public Long inputLong(Supplier<String> supplier) {
        System.out.println(supplier.get());

        return new Scanner(System.in).nextLong();
    }

    public String inputString(Supplier<String> supplier) {
        System.out.println(supplier.get());

        return new Scanner(System.in).nextLine();
    }
}
