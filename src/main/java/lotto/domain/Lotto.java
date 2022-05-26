package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import util.StringUtil;
import util.ValidationUtil;

public class Lotto {

    private static final String ERROR_MESSAGE_NUMBER_LIST_NULL_OR_EMPTY = "[ERROR] 로또 숫자 가 비었거나 null 입니다.";
    private static final String ERROR_MESSAGE_NUMBER_LIST_SIZE_WRONG = "[ERROR] 로또 숫자의 수가 잘못되었습니다.";
    private static final String ERROR_MESSAGE_NUMBER_LIST_DUPLICATION = "[ERROR] 로또 숫자에 중복된 숫자가 존재합니다.";
    private static final String ERROR_MESSAGE_STRING_NULL_OR_EMPTY = "[ERROR] 입력 문자열이 비었거나 null 입니다.";
    private static final String ERROR_MESSAGE_STRING_NOT_NUMBER = "[ERROR] 입력값에 숫자가 아닌 값이 존재합니다.";

    public static final int LOTTO_SIZE = 6;

    private final List<LottoNumber> numberList;

    public Lotto(final List<LottoNumber> list) {
        validateList(list);
        numberList = list;
    }

    public Lotto(final String numbersString) {
        validateString(numbersString);

        List<Integer> numbers = StringUtil.splitNumbersString(numbersString, ",");
        List<LottoNumber> list = numbers.stream().map(LottoNumber::new).collect(Collectors.toList());
        validateList(list);

        numberList = list;
    }

    public LottoNumber get(int index) {
        return numberList.get(index);
    }

    private void validateList(List<LottoNumber> list) {
        ValidationUtil.validatePredicate((x) -> x == null || x.isEmpty(), list,
                ERROR_MESSAGE_NUMBER_LIST_NULL_OR_EMPTY);
        ValidationUtil.validatePredicate((x) -> x.size() != LOTTO_SIZE, list, ERROR_MESSAGE_NUMBER_LIST_SIZE_WRONG);
        ValidationUtil.validatePredicate((x) -> new HashSet<>(x).size() < x.size(), list,
                ERROR_MESSAGE_NUMBER_LIST_DUPLICATION);
    }

    private void validateString(String numbersString) {
        ValidationUtil.validatePredicate((x) -> x == null || x.isEmpty(), numbersString, ERROR_MESSAGE_STRING_NULL_OR_EMPTY);
        validateNumbersStringNotNumber(numbersString);
    }

    private void validateNumbersStringNotNumber(String numbersString) {
        try {
            StringUtil.splitNumbersString(numbersString, ",");
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE_STRING_NOT_NUMBER);
        }
    }

    public int size() {
        return numberList.size();
    }

    public boolean hasNumber(LottoNumber lottoNumber) {
        return numberList.contains(lottoNumber);
    }
}
