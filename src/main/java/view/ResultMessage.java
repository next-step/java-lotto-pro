package view;

public class ResultMessage {
	public static final String PURCHASE_MESSAGE = "%s개를 구매했습니다.";
	public static final String WINNING_STATISTICS_MESSAGE = "당첨 통계";
	public static final String LINE = "---------";
	private static final String PRIZE_MONEY_AND_MATCH_COUNT = "(%s원)- %s개";
	public static final String THREE_MATCH_MESSAGE = "3개 일치 " + PRIZE_MONEY_AND_MATCH_COUNT;
	public static final String FOUR_MATCH_MESSAGE = "4개 일치 " + PRIZE_MONEY_AND_MATCH_COUNT;
	public static final String FIVE_MATCH_MESSAGE = "5개 일치 " + PRIZE_MONEY_AND_MATCH_COUNT;
	public static final String FIVE_AND_BONUS_MATCH_MESSAGE = "5개 일치, 보너스 볼 일치" + PRIZE_MONEY_AND_MATCH_COUNT;
	public static final String SIX_MATCH_MESSAGE = "6개 일치 " + PRIZE_MONEY_AND_MATCH_COUNT;
	public static final String EARNINGS_RATE_MESSAGE = "총 수익률은 %s입니다.";
	public static final String EARNINGS_RATE_LOSS_MESSAGE = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
}
