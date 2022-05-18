import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;

public class ConsoleInputView {
    public Long inputLong(Supplier<String> supplier) {
        System.out.println(supplier.get());

        return new Scanner(System.in).nextLong();
    }

    public int inputInt(Supplier<String> supplier) {
        System.out.println(supplier.get());

        return new Scanner(System.in).nextInt();
    }

    public String inputString(Supplier<String> supplier) {
        System.out.println(supplier.get());

        return new Scanner(System.in).nextLine();
    }

    public List<String> inputStringList(Supplier<String> supplier, int size) {
        System.out.println(supplier.get());

        Scanner scanner = new Scanner(System.in);

        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            stringList.add(scanner.nextLine());
        }

        return stringList;
    }
}
