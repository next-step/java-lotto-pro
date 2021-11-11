package lotto.view;

import lotto.model.LottoNumber;
import lotto.util.ConstantString;
import lotto.model.Price;

import java.util.ArrayList;
import java.util.List;

public class InputHandler {

    public static int price(String priceText) {
        try {
            int lottoCount = Price.numberPurchases(validStringToInt(priceText));
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
            int lottoNumber = validStringToInt(textNumber);
            result.add(lottoNumber);
        }
        return result;
    }

    public static int validStringToInt(String textNumber) {
        try {
            int number = Integer.parseInt(textNumber);
            return number;
        } catch (Exception e) {
            throw new NumberFormatException(ErrorMessage.NUMBER_FORMAT_ERROR);
        }
    }

    public static int buyManualLotto(String textManualCount, int lottoCount) {
        int manualCount = validStringToInt(textManualCount);
        if(lottoCount - manualCount < 0){
            throw new IllegalArgumentException(ErrorMessage.LACK_OF_MONEY);
        }
        return manualCount;
    }
}
