package lotto.view;

import lotto.model.LottoNumber;
import lotto.util.ConstantString;
import lotto.model.Price;

import java.util.ArrayList;
import java.util.List;

public class InputHandler {

    public static int price(String priceText) {
        try {
            int lottoCount = Price.numberPurchases(Integer.parseInt(priceText));
            return lottoCount;
        } catch (NumberFormatException e) {
            throw new NumberFormatException(ErrorMessage.NUMBER_FORMAT_ERROR);
        }
    }

    public static List<Integer> splitTextToInts(String numbersText) {
        try {
            String[] splitedNumbers = numbersText.split(ConstantString.SEPARATOR);
            return mapToInts(splitedNumbers);
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.SPLITED_ERROR);
        }
    }

    private static List<Integer> mapToInts(String[] splitedNumbers) {
        List<Integer> result = new ArrayList<>();
        for (String textNumber : splitedNumbers) {
            int lottoNumber = checkLottoNumber(textNumber);
            result.add(lottoNumber);
        }
        return result;
    }

    public static int checkLottoNumber(String textNumber) {
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
