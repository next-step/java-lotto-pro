package study.lotto.view;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import study.lotto.dto.PurchasePrice;
import study.lotto.dto.PurchasedLotto;
import study.lotto.dto.PurchasedLottos;
import study.lotto.dto.WinningLottoNumbers;
import study.lotto.dto.WinningStatistics;

public class LottoView {
    private final ConsoleUserInterface userInterface;

    public LottoView(ConsoleUserInterface userInterface) {
        this.userInterface = userInterface;
    }

    public PurchasePrice getPurchasePrice() {
        return new PurchasePrice(userInterface.getUserInput("구입금액을 입력해 주세요.\n"));
    }

    public void showPurchaseResult(PurchasedLottos purchasedLottos) {
        List<PurchasedLotto> lottoList = purchasedLottos.get();
        userInterface.show(String.format("%d개 구매했습니다.\n", lottoList.size()));
        userInterface.show(lottoListString(lottoList));
        userInterface.show("\n");
    }

    public WinningLottoNumbers getWinningLottoNumbers() {
        return new WinningLottoNumbers(userInterface.getUserInput("지난 주 당첨 번호를 입력해 주세요.\n"));
    }

    public void showWinningStatictics(WinningStatistics winningStatistics) {
        userInterface.show("당첨 통계\n");
        userInterface.show("---------\n");
        printDivisionResult(winningStatistics);
        userInterface.show(
                String.format("총 수익률은 %s입니다.(기준이 1이기 때문에 결과적으로 %s 의미임)\n", winningStatistics.getEarningsRate(),
                        getEarningResult(winningStatistics)));
    }

    private String getEarningResult(WinningStatistics winningStatistics) {
        if (BigDecimal.ONE.compareTo(winningStatistics.getEarningsRate()) == 0) {
            return "본전이라는";
        }
        return BigDecimal.ONE.compareTo(winningStatistics.getEarningsRate()) > 0 ? "손해라는" : "이익이라는";
    }

    private void printDivisionResult(WinningStatistics winningStatistics) {
        winningStatistics.getDivisionResultList().stream()
                .map(divisionResult ->
                        String.format("%d개 일치 (%s원)- %d개\n",
                                divisionResult.getMatchCount(),
                                divisionResult.getPrize(),
                                divisionResult.getWinningCount()))
                .forEach(userInterface::show);
    }

    private String lottoListString(List<PurchasedLotto> lottoList) {
        return lottoList.stream()
                .map(this::lottoString)
                .reduce("", (str1, str2) -> str1 + str2);
    }

    private String lottoString(PurchasedLotto purchasedLotto) {
        String purchasedLottoNumberString = String.join(", ",
                purchasedLotto.get()
                        .stream()
                        .map(Objects::toString)
                        .collect(Collectors.toList()));
        return String.format("[%s]\n", purchasedLottoNumberString);
    }
}
