package lotto.util;

import lotto.domain.Lotto;

public class InputValidator {
    private static final String ERROR_MESSAGE_INVALID_NUMBER = "[ERROR] 유효하지 않은 구매금액입니다.";
    private static final String ERROR_MESSAGE_INVALID_LOTTO_NUMBER = "[ERROR] 유효하지 않은 당첨 번호";
    private static final String REGEX_DIGIT = "\\d+";
    private static final int VALID_LOTTO_NUMBER_COUNT = 6;

    public static void validateNumberFormat(String input){
        if(!input.matches(REGEX_DIGIT)){
            throw new IllegalArgumentException(ERROR_MESSAGE_INVALID_NUMBER);
        }
    }

    public static void validateLottoNumber(int number){
        if(number < Lotto.MIN_LOTTO_NUMBER || number > Lotto.MAX_LOTTO_NUMBER){
            throw new IllegalArgumentException(ERROR_MESSAGE_INVALID_LOTTO_NUMBER);
        }
    }

    public static void validateLottoNumberCount(int lottoNumberCount){
        if(lottoNumberCount != VALID_LOTTO_NUMBER_COUNT){
            throw new IllegalArgumentException(ERROR_MESSAGE_INVALID_LOTTO_NUMBER);
        }
    }
}