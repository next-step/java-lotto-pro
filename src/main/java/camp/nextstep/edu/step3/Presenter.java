package camp.nextstep.edu.step3;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Presenter {

    public LottoMoney askPurchaseAmount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        return new LottoMoney(scanner.nextInt());
    }

    public void printLottoList(final LottoPaper paper) {
        System.out.printf("%d개를 구매했습니다.%n", paper.numberOfPurchases());
        System.out.println(paper);
    }

    public List<LottoNumber> askLastWeekWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        List<LottoNumber> numbers = userLottoNumbers(new Scanner(System.in));
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

    private List<LottoNumber> userLottoNumbers(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().replace(" ", "").split(","))
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
}
