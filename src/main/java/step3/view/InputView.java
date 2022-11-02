package step3.view;

import step3.model.*;
import step3.utils.CommonUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static step3.constant.Message.System.*;
public class InputView {
    private final static Scanner scanner = new Scanner(System.in);
    public static void inputPurchasePrice(LottoGenerator lottoGenerator) {
        System.out.println(TOTAL_LOTTO_PRICE_INPUT_MESSAGE);
        lottoGenerator.setPurchasePrice(scanner.nextLine());
    }

    public static void inputLastWeekLottoNumbers(LottoCalculator calculator) {
        System.out.println(LAST_LOTTO_NUMBERS_INPUT_MESSAGE);
        String[] lastWeekNumbers = new Lotto().validateLastWeekWinner(scanner.nextLine());
        calculator.setLastWeekWinner(inputLastWeekBonusNumber(lastWeekNumbers));
    }

    public static WinnerLotto inputLastWeekBonusNumber(String[] lastWeekLottos) {
        System.out.println(LAST_BONUS_NUMBER_INPUT_MESSAGE);
        return new WinnerLotto(makeLottoNumberList(lastWeekLottos), scanner.nextLine());
    }

    private static List<LottoNumber> makeLottoNumberList(String[] numbers){
        List<LottoNumber> list = new ArrayList<>();
        for (String str : numbers) {
            list.add(new LottoNumber(CommonUtils.commonStringToNumber(str)));
        }
        return list;
    }
}
