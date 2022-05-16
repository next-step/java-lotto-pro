package lotto.view;

import static lotto.domain.LottoNumbers.NUMBERS_DELIMITER;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import lotto.controller.dto.LottoNumbersDTO;
import lotto.controller.dto.LottoTicketsDTO;
import lotto.controller.dto.MoneyDTO;
import lotto.controller.dto.WinningLottoDTO;

public class InputView {

    private static final String INPUT_MONEY = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_LOTTO = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";
    private static final String INPUT_MANUAL_LOTTO_QUANTITY = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String INPUT_MANUAL_LOTTO_NUMBERS = "수동으로 구매할 번호를 입력해 주세요.";

    private static final Scanner scanner = new Scanner(System.in);

    public static MoneyDTO inputMoney() {
        System.out.println(INPUT_MONEY);
        String inputMoney = readLine();
        return new MoneyDTO(Integer.parseInt(inputMoney));
    }

    public static List<Integer> inputWinningLottoNumbers() {
        System.out.println(INPUT_WINNING_LOTTO);
        String inputLottoNumbers = readLine();
        String[] strings = splitLottoNumbers(inputLottoNumbers);
        return Arrays.stream(strings).
                map(String::trim).
                map(Integer::parseInt).
                collect(Collectors.toList());
    }

    public static int inputBonusBallNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
        String inputBonusNumbers = readLine();
        return Integer.parseInt(inputBonusNumbers);
    }

    public static int inputManualLottoQuantity() {
        System.out.println(INPUT_MANUAL_LOTTO_QUANTITY);
        String manualLottoQuantity = readLine();
        return Integer.parseInt(manualLottoQuantity);
    }

    public static LottoTicketsDTO inputManualLottoTickets(int manualLottoTicketQuantity) {
        List<LottoNumbersDTO> lottoNumbersDTOS = new ArrayList<>();
        System.out.println(INPUT_MANUAL_LOTTO_NUMBERS);
        for (int i = 0; i < manualLottoTicketQuantity; i++) {
            String inputLottoNumbers = readLine();
            String[] strings = splitLottoNumbers(inputLottoNumbers);
            lottoNumbersDTOS.add(
                    new LottoNumbersDTO(
                    Arrays.stream(strings).
                            map(String::trim).
                            map(Integer::parseInt).
                            collect(Collectors.toList())
            ));
        }
        return new LottoTicketsDTO(lottoNumbersDTOS);
    }

    public static WinningLottoDTO inputLottoInformation() {
        List<Integer> numbers = inputWinningLottoNumbers();
        int bonusBallNumber = inputBonusBallNumber();
        return new WinningLottoDTO(numbers, bonusBallNumber);
    }

    private static String[] splitLottoNumbers(String inputLottoNumbers) {
        return inputLottoNumbers.split(NUMBERS_DELIMITER);
    }

    private static String readLine() {
        return scanner.nextLine();
    }

}
