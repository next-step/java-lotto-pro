package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {

  private static final Scanner SCANNER = new Scanner(System.in);

  public static String inputMoneyPurchaseLotto() {
    System.out.println("구입금액을 입력해 주세요.");
    String inputMoney = SCANNER.nextLine();
    return inputMoney;
  }

  public static String inputPurchaseLottoCount() {
    System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
    return SCANNER.nextLine();
  }

  public static List<String> inputManualPurchaseLotto() {
    int count = Integer.parseInt(InputView.inputPurchaseLottoCount());

    if (count == 0) {
      return new ArrayList();
    }

    InputView.inputPurchaseLottoNumberMent();
    return Stream.generate(InputView::inputManualLottoNumber)
        .limit(count)
        .collect(Collectors.toList());
  }

  public static void inputPurchaseLottoNumberMent() {
    System.out.println("수동으로 구매할 번호를 입력해 주세요.");
  }

  public static String inputWinningLottoNumber() {
    System.out.println();
    System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    String winningNumber = SCANNER.nextLine();
    return winningNumber;
  }

  public static String inputBonusLottoNumber() {
    System.out.println();
    System.out.println("보너스 볼을 입력해 주세요.");
    return SCANNER.nextLine();
  }

  public static String inputManualLottoNumber() {
    return SCANNER.nextLine();
  }


}
