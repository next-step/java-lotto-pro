package lotto.view;

import lotto.util.Console;
import lotto.util.ConstantString;
import lotto.model.Price;

import java.util.ArrayList;
import java.util.List;

public class InputHandler {

    public static List<Integer> splitTextToInts(String numbersText) {
        String[] splitedNumbers = numbersText.split(ConstantString.SEPARATOR);
        return mapToInts(splitedNumbers);
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
}
