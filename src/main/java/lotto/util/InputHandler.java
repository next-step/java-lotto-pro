package lotto.util;

import lotto.model.LottoNumber;
import lotto.view.ErrorMessage;

public class InputHandler {
    private static final int LOTTO_MAX_BUY_LENGTH = 6;

    public static int price(String priceText) {
        validRange(priceText.length());
        try {
            int lottoCount = PriceUtil.getCount(Integer.parseInt(priceText));
            return lottoCount;
        } catch (NumberFormatException e) {
            throw new NumberFormatException(ErrorMessage.NUMBER_FORMAT_ERROR);
        }
    }

    private static void validRange(int length) {
        if (length > LOTTO_MAX_BUY_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_MAX_BUY_ERROR);
        }
    }

    public static int[] splitTextToInts(String numbersText) {
        try {
            String[] splitedNumbers = numbersText.split(ConstantString.SEPARATOR);
            return mapToInts(splitedNumbers);
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.SPLITED_ERROR);
        }
    }

    private static int[] mapToInts(String[] splitedNumbers) {
        int[] result = new int[LottoNumber.SIZE];
        for (int i = 0; i < LottoNumber.SIZE; i++) {
            int lottoNumber = checkLottoNumber(splitedNumbers[i]);
            result[i] = lottoNumber;
        }
        return result;
    }

    private static int checkLottoNumber(String textNumber) {
        try {
            int number = Integer.parseInt(textNumber);
            if (LottoNumber.MAX_NUMBER < number || LottoNumber.MIN_NUMBER > number) {
                throw new IllegalArgumentException();
            }
            return number;
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }

    }
}
