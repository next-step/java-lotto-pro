package study.lotto.view;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import study.lotto.domain.Lotto;
import study.lotto.domain.LottoNumber;
import study.lotto.domain.Lottos;
import study.lotto.domain.draw.DrawResult;
import study.lotto.domain.lottomachine.LottoCount;
import study.lotto.domain.lottomachine.LottoPurchaseHistory;
import study.lotto.domain.lottomachine.Price;

public class LottoView {
    private final ConsoleUserInterface userInterface;

    public LottoView(ConsoleUserInterface userInterface) {
        this.userInterface = userInterface;
    }

    public Price getPurchasePrice() {
        return new Price(userInterface.getUserInput("구입금액을 입력해 주세요.\n"));
    }

    public Lottos getManualLottos() {
        LottoCount count = new LottoCount(userInterface.getUserInput("수동으로 구매할 로또 수를 입력해 주세요.\n"));
        return new Lottos(getManualLottos(count));
    }

    public void showPurchaseResult(LottoPurchaseHistory lottoPurchaseHistory) {
        userInterface.show(String.format("수동으로 %s장, 자동으로 %s개를 구매했습니다.\n",
                lottoPurchaseHistory.getManualCount(),
                lottoPurchaseHistory.getAutomaticLottoCount()));
        userInterface.show(lottoListString(lottoPurchaseHistory.getLottos()));
        userInterface.show("\n");
    }

    public Lotto getWinningLotto() {
        return Lotto.from(userInterface.getUserInput("지난 주 당첨 번호를 입력해 주세요.\n"));
    }

    public void showWinningStatictics(DrawResult drawResult, LottoPurchaseHistory lottoPurchaseHistory) {
        userInterface.show("당첨 통계\n");
        userInterface.show("---------\n");
        printDivisionResult(drawResult);

        BigDecimal earningRate = drawResult.earningsRate(lottoPurchaseHistory.getTotalCost());
        userInterface.show(
                String.format("총 수익률은 %s입니다.(기준이 1이기 때문에 결과적으로 %s 의미임)\n", earningRate,
                        getEarningResult(earningRate)));
    }

    public LottoNumber getBonusBall() {
        return new LottoNumber(userInterface.getUserInput("보너스 볼을 입력해 주세요.\n"));
    }

    private List<Lotto> getManualLottos(LottoCount count) {
        userInterface.show("수동으로 구매할 번호를 입력해 주세요.\n");
        return Stream.generate(this::getManualLotto)
                .limit(count.get())
                .collect(Collectors.toList());
    }

    private Lotto getManualLotto() {
        return Lotto.from(userInterface.getUserInput(""));
    }

    private String getEarningResult(BigDecimal earningRate) {
        if (BigDecimal.ONE.compareTo(earningRate) == 0) {
            return "본전이라는";
        }
        return BigDecimal.ONE.compareTo(earningRate) > 0 ? "손해라는" : "이익이라는";
    }

    private void printDivisionResult(DrawResult drawResult) {
        drawResult.getWinnings().stream()
                .map(divisionResult ->
                        String.format("%d개 일치%s(%s원)- %d개\n",
                                divisionResult.getDivision().getMatchCount(),
                                divisionResult.getDivision().getBonusMandatory() ? ", 보너스 볼 일치" : " ",
                                divisionResult.getDivision().getPrize(),
                                divisionResult.getCount()))
                .forEach(userInterface::show);
    }

    private String lottoListString(Lottos lottos) {
        return lottos.get().stream()
                .map(this::lottoString)
                .reduce("", (str1, str2) -> str1 + str2);
    }

    private String lottoString(Lotto purchasedLotto) {
        String purchasedLottoNumberString = String.join(", ",
                purchasedLotto.get()
                        .stream()
                        .map(LottoNumber::get)
                        .map(Objects::toString)
                        .collect(Collectors.toList()));
        return String.format("[%s]\n", purchasedLottoNumberString);
    }
}
