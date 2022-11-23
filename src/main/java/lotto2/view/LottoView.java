package lotto2.view;

import lotto2.model.LottoNumber;
import lotto2.model.LottoPrizeEnum;
import lotto2.model.WinningRankCountDto;

import java.text.DecimalFormat;
import java.util.List;

public class LottoView {
    private static final DecimalFormat decimalFormat = new DecimalFormat("0.00");

    public void printDemandInputMoney() {
        System.out.print("구입금액을 입력해 주세요.\n");
    }

    public void printNumberOfBoughtLotto(int count) {
        System.out.printf("%d개를 구매했습니다.\n", count);
    }

    public void printListOfLotto(List<List<LottoNumber>> lottoBucket) {
        for (List<LottoNumber> lotto : lottoBucket) {
            printEachLotto(lotto);
        }
        System.out.println();
    }

    private void printEachLotto(List<LottoNumber> lotto) {
        System.out.print(lotto + "\n");
    }

    public void printDemandWinningNumbers() {
        System.out.print("지난 주 당첨 번호를 입력해 주세요.\n");
    }

    public void printDemandBonusNumber() {
        System.out.print("보너스 볼을 입력해 주세요.\n");
    }

    public void printResultTitle() {
        System.out.print("\n당첨 통계\n" +
                "---------\n");
    }

    public void printStatistics(List<WinningRankCountDto> winningRankCounts) {
        for (WinningRankCountDto eachWinningRankCount : winningRankCounts) {
            if (eachWinningRankCount.getLottoPrizeEnum() == LottoPrizeEnum.SECOND) {
                System.out.printf("%d개 일치, 보너스 볼 일치 (%d원)- %d개\n",
                        eachWinningRankCount.getLottoPrizeEnum().getNumberMatch(),
                        eachWinningRankCount.getLottoPrizeEnum().getPrize(),
                        eachWinningRankCount.getCount()
                );
                continue;
            }
            System.out.printf("%d개 일치 (%d원)- %d개\n",
                    eachWinningRankCount.getLottoPrizeEnum().getNumberMatch(),
                    eachWinningRankCount.getLottoPrizeEnum().getPrize(),
                    eachWinningRankCount.getCount()
            );
        }
    }

    public void printProfitRatio(double profitRatio) {
        System.out.printf("총 수익률은 %s입니다.\n", decimalFormat.format(profitRatio));
    }
}
