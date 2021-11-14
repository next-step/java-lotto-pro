package lotto.view;

import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.util.Console;
import lotto.util.ConstantString;
import lotto.model.Price;

import java.util.ArrayList;
import java.util.List;

public class InputHandler {

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

    public static List<Lotto> createManualLotto(List<String> manualLottoTexts) {
        List<Lotto> lottoGroup = new ArrayList<>();
        for (String manualLottoText : manualLottoTexts) {
            lottoGroup.add(new Lotto(InputHandler.splitTextToInts(manualLottoText)));
        }
        return lottoGroup;
    }
}
