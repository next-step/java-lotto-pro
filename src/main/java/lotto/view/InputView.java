package lotto.view;

import java.util.Optional;
import java.util.Scanner;
import lotto.util.IntUtil;

public class InputView {
    private static String STRING_INIT_VALUE = "";
    private static int INTEGER_INIT_VALUE = 0;
    
    private static Scanner scanner = new Scanner(System.in);

    public static String getStringInput() {
        String input = scanner.nextLine();
        Optional<String> optionalInput = Optional.ofNullable(input);
        
        return optionalInput.orElse(STRING_INIT_VALUE);
    }
    
    public static Integer getIntegerInput() {
        Integer input = IntUtil.parseInt(scanner.nextLine());
        Optional<Integer> optionalInput = Optional.ofNullable(input);
        
        return optionalInput.orElse(INTEGER_INIT_VALUE);
    }
}
