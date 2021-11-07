package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoNumber;
import lotto.util.ConstantString;
import lotto.model.Price;

public class InputHandler {

    public static int price(String priceText) {
        try {
            int lottoCount = Price.getCount(Integer.parseInt(priceText));
            return lottoCount;
        } catch (NumberFormatException e) {
            throw new NumberFormatException(ErrorMessage.NUMBER_FORMAT_ERROR);
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
        int[] result = new int[Lotto.SIZE];
        for (int i = 0; i < Lotto.SIZE; i++) {
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
