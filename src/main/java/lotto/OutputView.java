package lotto;

public class OutputView {
    private static final String LOTTO_COUNT_MESSAGE = "%d개를 구매했습니다.";
    private static final String LOTTO_WINNING_MESSAGE = "\n당첨 통계\n" + "---------\n";
    private static final String WINNING_COUNT_MESSAGE = "%d개 일치 (%d원) - %d개\n";
    private static final String TOTAL_REWARD_MESSAGE = "총 수익률은 %s입니다.";
    private static final StringBuffer STRING_BUFFER = new StringBuffer();

    public void printLottoCount(int count) {
        System.out.println(String.format(LOTTO_COUNT_MESSAGE, count));
    }

    public void printLottos(Lottos lottos) {
        lottos.getLottos().forEach(lotto -> System.out.println(lotto.getLotto()));
    }

    public static void printLottoResult(LottoResult lottoResult) {
        winning(lottoResult);
        totalRewardRatio(lottoResult);
        System.out.println(STRING_BUFFER);
    }

    private static void winning(final LottoResult lottoResult) {
        STRING_BUFFER.append(LOTTO_WINNING_MESSAGE)
                .append(String.format(WINNING_COUNT_MESSAGE, LottoRank.THREE_MATCHES.getMatchCount(), LottoRank.THREE_MATCHES.getMoney(), lottoResult.getResult(LottoRank.THREE_MATCHES)))
                .append(String.format(WINNING_COUNT_MESSAGE, LottoRank.FOUR_MATCHES.getMatchCount(), LottoRank.FOUR_MATCHES.getMoney(), lottoResult.getResult(LottoRank.FOUR_MATCHES)))
                .append(String.format(WINNING_COUNT_MESSAGE, LottoRank.FIVE_MATCHES.getMatchCount(), LottoRank.FIVE_MATCHES.getMoney(), lottoResult.getResult(LottoRank.FIVE_MATCHES)))
                .append(String.format(WINNING_COUNT_MESSAGE, LottoRank.SIX_MATCHES.getMatchCount(), LottoRank.SIX_MATCHES.getMoney(), lottoResult.getResult(LottoRank.SIX_MATCHES)));
    }

    public static void totalRewardRatio(final LottoResult lottoResult) {
        STRING_BUFFER.append(String.format(TOTAL_REWARD_MESSAGE, lottoResult.rewardRatio()));
    }
}
