package lotto.view;

import lotto.exception.InputDataErrorCode;
import lotto.exception.InputDataException;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String ONLY_NUMBER_REGULAR_EXPRESSION = "^[0-9]*$";

    private InputView() {
    }

    public static int printInputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String inputMoney = scanner.nextLine();
        validInputMoney(inputMoney);
        return Integer.parseInt(inputMoney);
    }

    public static List<Integer> printInputWinningLotto() {
        System.out.println("지난 주 당첨 번호를 입력해주세요.");
        return inputLottoNumbers();
    }

    private static List<Integer> inputLottoNumbers() {
        String inputLottosText = scanner.nextLine();
        validInputLotto(inputLottosText);
        String[] inputLottos = inputLottosText.split(",");
        return Arrays.stream(inputLottos)
                .map(number -> Integer.parseInt(number.trim()))
                .collect(Collectors.toList());
    }

    private static void validInputLotto(String inputLottosText) {
        if(isInputDataEmpty(inputLottosText)){
            throw new InputDataException(InputDataErrorCode.INPUT_NO_LOTTO);
        }
    }

    public static int printInputBonusNumber(){
        System.out.println("보너스 볼을 입력해주세요");
        return Integer.parseInt(scanner.nextLine());
    }

    public static int printInputManualLottoCount(){
        System.out.println("수동으로 구매할 로또 수를 입력해주세요.");
        String lottoCount = scanner.nextLine();
        if(isInputDataEmpty(lottoCount)){
            throw new InputDataException(InputDataErrorCode.INPUT_NO_LOTTO_COUNT);
        }
        return Integer.parseInt(lottoCount);
    }

    public static List<Integer> inputManualLotto(){
        return inputLottoNumbers();
    }

    public static void printInputManualLotto(){
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
    }

    private static void validInputMoney(String inputMoney) {
        if (isInputDataEmpty(inputMoney)) {
            throw new InputDataException(InputDataErrorCode.GIVE_NO_MONEY);
        }

        if (!isOnlyNumber(inputMoney)) {
            throw new InputDataException(InputDataErrorCode.WRONG_INPUT_NUMBER);
        }
    }

    private static boolean isInputDataEmpty(String inputData) {
        return inputData == null || inputData.isEmpty();
    }

    private static boolean isOnlyNumber(String inputMoney) {
        return Pattern.matches(ONLY_NUMBER_REGULAR_EXPRESSION, inputMoney);
    }

}
