package lotto_auto.view;

import lotto_auto.model.*;

import java.util.stream.Collectors;

public class Output {
    public static final String MONEY_INPUT_NOTICE = "구입금액을 입력해 주세요.";
    public static final String WINNING_LOTTO_INPUT_NOTICE = "지난 주 당첨 번호를 입력해 주세요.";
    public static final String PROFIT_RATE_NOTICE_FORMAT = "총 수익률은 %s입니다.";
    public static final String NEGATIVE_PROFIT_RATE_NOTICE = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    public static final String BONUS_INPUT_NOTICE = "보너스 볼을 입력해 주세요.";

    public static final String FIGURES_FORMAT = "%d개 일치 (%d원)- %d개\n";
    public static final String SECOND_FIGURES_FORMAT = "%d개 일치, 보너스 볼 일치(%d) - %d개\n";

    public static final String MANUAL_LOTTO_COUNT_INPUT_NOTICE = "\n수동으로 구매할 로또 수를 입력해 주세요.";
    public static final String MANUAL_LOTTO_INPUT_NOTICE = "\n수동으로 구매할 번호를 입력해 주세요.";
    public static final String PURCHASED_LOTTO_COUNT_FORMAT = "수동으로 %d장, 자동으로 %d개를 구매했습니다.\n";

    public static void showMoneyInputNotice() {
        System.out.println(MONEY_INPUT_NOTICE);
    }

    public static void showProfitRate(ProfitRate profitRate) {
        String format = (profitRate.isNegativeProfitRate()) ?
                PROFIT_RATE_NOTICE_FORMAT + " " + NEGATIVE_PROFIT_RATE_NOTICE : PROFIT_RATE_NOTICE_FORMAT;
        System.out.format(format, profitRate.printRate());
    }

    public static void showPurchaseManualLottoNotice() {
        System.out.println(MANUAL_LOTTO_INPUT_NOTICE);
    }

    public void showPurchasedLottoCountNotice(PurchaseInfo info) {
        System.out.format(PURCHASED_LOTTO_COUNT_FORMAT, info.getManualLottoCount(), info.getAutoLottoCount());
    }

    public static void showPurchasedLottos(Lottos purchasedLottos) {
        String result = purchasedLottos.getLottoList()
                .stream()
                .map(lotto -> printLotto(lotto))
                .collect(Collectors.joining("\n"));

        System.out.println(result);
    }

    public static void showWinningLottoNotice() {
        System.out.println(WINNING_LOTTO_INPUT_NOTICE);
    }

    public static void showFigures(Figures figures) {
        StringBuilder result = new StringBuilder();
        String figuresTitle = "당첨 통계\n---------\n";
        result.append(figuresTitle);

        for (LottoRank rank : LottoRank.valuesTheLowestOrder()) {
            result.append(String.format(getFiguresFormat(rank), rank.matchedCount(), rank.winnings(), figures.getCountBy(rank)));
        }

        System.out.println(result);
    }

    public static void showBonusBallInputNotice() {
        System.out.println(BONUS_INPUT_NOTICE);
    }

    public static void showManualLottoCountNotice() {
        System.out.println(MANUAL_LOTTO_COUNT_INPUT_NOTICE);
    }

    public static void showError(Throwable e) {
        System.out.println(e.getMessage());
    }

    private static String printLotto(Lotto lotto) {
        char fisrtCharactor = '[';
        char lastCharactor = ']';
        String printDelimiter = ", ";

        return fisrtCharactor + lotto.getLottoNumbers().getLottoNumberSet().stream()
                .map(lottoNumber -> Integer.toString(lottoNumber.getNumber()))
                .collect(Collectors.joining(printDelimiter)) +lastCharactor;
    }

    private static String getFiguresFormat(LottoRank rank) {
        if (rank == LottoRank.SECOND) {
            return SECOND_FIGURES_FORMAT;
        }
        return FIGURES_FORMAT;
    }

}
