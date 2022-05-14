package lotto_auto.model;

import lotto_auto.exception.IllegalLottoException;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> lottoNumbers;

    public static final int validSize = 6;
    public static final int minNumber = 1;
    public static final int maxNumber = 45;
    private static final String lottoDelimiter = ", ";
    public static final int price = 1000;

    public static final String NOT_NUMBER = "[ERROR] 로또의 번호에 숫자 이외의 값이 존재합니다.";
    public static final String NOT_MATCHED_NUMBER_SIZE = "[ERROR] 로또 번호는 6개의 숫자가 필요합니다.";
    public static final String EXIST_DUPLICATE_VALUE = "[ERROR] 로또 번호는 중복 숫자가 존재할 수 없습니다.";
    public static final String NOT_RANGE_NUMBER = "[ERROR] 로또 번호는 1~45의 숫자입니다.";

    public Lotto(List<Integer> numbers) throws IllegalLottoException {
        checkValidLottoNumber(numbers);

        this.lottoNumbers = numbers;
    }

     public Lotto(String stringNumber) throws IllegalLottoException {
        try {
            List<Integer> tmpLotto = Arrays.stream(stringNumber.split(lottoDelimiter))
                    .mapToInt(Integer::parseInt)
                    .boxed()
                    .collect(Collectors.toList());

            checkValidLottoNumber(tmpLotto);

            this.lottoNumbers = tmpLotto;
        } catch (NumberFormatException err) {
            throw IllegalLottoException.NOT_NUMBER_ERROR;
        }
    }

    private void checkValidLottoNumber(List<Integer> numbers) throws IllegalLottoException {
        checkNumberSize(numbers);
        checkNumberRange(numbers);
        checkDuplicateNumber(numbers);
    }

    private void checkNumberSize(List<Integer> numbers) throws IllegalLottoException {
        if (!(numbers.size() == validSize)) {
            throw IllegalLottoException.NOT_MATCHED_NUMBER_SIZE_ERROR;
        }
    }

    private void checkNumberRange(List<Integer> numbers) throws IllegalLottoException {
        if (!numbers.stream().allMatch(n ->  n >= minNumber && n <= maxNumber)) {
            throw IllegalLottoException.NOT_RANGE_NUMBER_ERROR;
        }
    }

    private void checkDuplicateNumber(List<Integer> numbers) throws IllegalLottoException {
        Set<Integer> set = new HashSet<>();
        boolean isUnique = numbers.stream().allMatch(set::add);

        if (!isUnique) {
            throw IllegalLottoException.EXIST_DUPLICATE_VALUE_ERROR;
        }
    }

    public List<Integer> getLottoNumbers() {
        return this.lottoNumbers;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        char printFirstChar = '[';
        char printLastChar = ']';

        for (int number : lottoNumbers) {
            result.append(number).append(lottoDelimiter);
        }

        return printFirstChar + result.substring(0, result.length() -2) + printLastChar;
    }
}
