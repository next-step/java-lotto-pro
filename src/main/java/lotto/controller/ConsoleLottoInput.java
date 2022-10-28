package lotto.controller;

import java.util.Scanner;

public class ConsoleLottoInput implements LottoUserInput {
    private final Scanner scanner;

    public ConsoleLottoInput() {
        scanner = new Scanner(System.in);
    }

    @Override
    public String getInput() {
        return scanner.nextLine();
    }
}
