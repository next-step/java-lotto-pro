package camp.nextstep.edu.step3;

import java.util.*;
import java.util.stream.Collectors;

public class Presenter {

    public LottoMoney askPurchaseAmount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        return new LottoMoney(scanner.nextInt());
    }

    public void printLottoList(final LottoPaper paper) {
        System.out.println(paper);
    }

    public List<LottoNumber> askLastWeekWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        List<LottoNumber> numbers = userLottoNumbers(scanner.nextLine());
        System.out.println();
        return numbers;
    }

    public LottoNumber askLottoBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        LottoNumber bonusNumber = new LottoNumber(scanner.nextInt());
        System.out.println();
        return bonusNumber;
    }

    private List<LottoNumber> userLottoNumbers(final String input) {
        return Arrays.stream(input.split(","))
                .map((item) -> item.replace(" ",""))
                .mapToInt(Integer::parseInt)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public void printResult(final LottoResult result, final EarningsRate earningsRate) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.print(result);
        System.out.println(earningsRate);
    }

    public void printIssuedHistory(IssuedHistory issuedHistory) {
        System.out.println();
        System.out.println(issuedHistory);
    }

    public List<Lotto> askManualPurchase(final LottoGenerator generator) {
        final int manualCount = this.askManualPurchaseCount();
        if (manualCount <= 0) {
            return Collections.emptyList();
        }
        return makeManualLotto(generator, manualCount);
    }

    private List<Lotto> makeManualLotto(final LottoGenerator generator, final int manualCount) {
        System.out.println();
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        List<Lotto> answerLotto = new ArrayList<>();
        for (int i = 1; i <= manualCount; i++) {
            answerLotto.add(generator.manual(userLottoNumbers(scanner.next())));
        }
        return answerLotto;
    }

    private int  askManualPurchaseCount() {
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return scanner.nextInt();
    }

}
