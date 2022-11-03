package lotto.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ConsoleLottoInput implements LottoUserInput {
    private static final int LOTTO_NUMBER_COUNT = 6;
    private final Scanner scanner;

    public ConsoleLottoInput() {
        scanner = new Scanner(System.in);
    }

    @Override
    public String getInput() {
        return scanner.nextLine();
    }

    @Override
    public Integer getPositiveInteger() {
        return getPositiveIntegerInner(getInput());
    }

    @Override
    public List<Integer> getLottoNumbers() {
        String[] userInputNumberStringArray = getInput().split(",");
        List<Integer> winningLottoNumbers = mapToPositiveIntegers(userInputNumberStringArray);
        validateIsSixNumbers(winningLottoNumbers);
        return winningLottoNumbers;
    }

    private List<Integer> mapToPositiveIntegers(String[] userInputNumberStringArray) {
        return Arrays.stream(userInputNumberStringArray)
                .map(this::getPositiveIntegerInner)
                .collect(Collectors.toList());
    }

    private void validateIsSixNumbers(List<Integer> winningLottoNumbers) {
        if(winningLottoNumbers.size() != LOTTO_NUMBER_COUNT){
            throw new IllegalArgumentException("당첨 번호는 6개여야 합니다");
        }
    }

    private Integer getPositiveIntegerInner(String input) {
        Integer number = tryParseInteger(input);
        validatePositive(number);
        return number;
    }

    private void validatePositive(Integer number) {
        if (number <= 0) {
            throw new IllegalArgumentException("0보다 큰 정수를 입력해 주세요");
        }
    }

    private Integer tryParseInteger(String numberString) {
        try {
            return Integer.parseInt(numberString);
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자를 입력해 주세요");
        }
    }
}
