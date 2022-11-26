package lotto2.view;

import lotto2.controller.Round;
import lotto2.model.*;
import lotto2.model.generator.LottoGeneratorFromUserInput;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    public MoneyToBuy inputMoney() {
        System.out.print("구입금액을 입력해 주세요.\n");
        final Scanner scanner = new Scanner(System.in);
        final String input = scanner.nextLine();
        return new MoneyToBuy(input);
    }

    public ManualLottoCount inputManualCount(MoneyToBuy moneyToBuy) {
        System.out.print("\n수동으로 구매할 로또 수를 입력해 주세요.\n");
        final Scanner scanner = new Scanner(System.in);
        final String input = scanner.nextLine();
        return new ManualLottoCount(input, moneyToBuy);
    }

    public List<Lotto> inputManyManualLotto(ManualLottoCount lottoCount) {
        System.out.print("\n수동으로 구매할 번호를 입력해 주세요.\n");
        final List<Lotto> lottoBucket = new ArrayList<>();
        final Round round = new Round(lottoCount.count());
        while (round.hasNext()) {
            round.goNext();
            final Scanner scanner = new Scanner(System.in);
            final String input = scanner.nextLine();
            final LottoGeneratorFromUserInput lottoGenerator = new LottoGeneratorFromUserInput(input);
            lottoBucket.add(lottoGenerator.generate());
        }
        return lottoBucket;
    }

    public String inputWinningNumbers() {
        System.out.print("\n지난 주 당첨 번호를 입력해 주세요.\n");
        final Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public LottoNumber inputBonusNumber() {
        System.out.print("보너스 볼을 입력해 주세요.\n");
        final Scanner scanner = new Scanner(System.in);
        final String input = scanner.nextLine();
        return new LottoNumber(input);
    }
}
