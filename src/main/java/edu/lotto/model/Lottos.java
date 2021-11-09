package edu.lotto.model;

import edu.lotto.constants.MessageConstants;
import edu.lotto.constants.PatternConstants;
import edu.lotto.constants.Rank;
import edu.lotto.utils.MessageUtil;
import edu.lotto.utils.NumberUtil;

import java.text.DecimalFormat;
import java.util.*;
import java.util.logging.Logger;

/**
 * Lottos - Lotto의 일급컬렉션
 * @since 2021.11.04
 * @author Inmook,Jeong
 */
public class Lottos {

	private static Logger logger = Logger.getLogger(Lottos.class.getName());

	private long perchaseAmount;
	private List<Lotto> lottos;

	public Lottos(int perchaseAmount) {
		this.perchaseAmount = perchaseAmount;
		this.lottos = getLottos(perchaseAmount);
	}

	/**
	 * 구매 갯수만큼 Lotto 번호 발급 
	 * @param perchaseAmount
	 * @return
	 */
	private List<Lotto> getLottos(int perchaseAmount) {
		List<Lotto> lottos = new ArrayList<Lotto>();
		int lottoCount = getLottoCount(perchaseAmount);
		MessageUtil.printMessage(lottoCount + MessageConstants.LOTTO_PERCHASE_MESSAGE);
		for(int i=0; i<lottoCount; i++) {
			lottos.add(new Lotto());
		}
		return lottos;
	}

	/**
	 * 지난주 정답이 로또 리스트의 로또 번호와 일치하는 숫자가 몇개인지 설정
	 * @param winningNumbers
	 */
	public void setWinningNumberMatchesCount(List<Integer> winningNumbers, int bonusNumber) {
		for(Lotto lotto : this.lottos) {
			lotto.setRank(winningNumbers, bonusNumber);
		}
	}

	/**
	 * 등수 별 로또 당첨 게임 출력
	 */
	public void printLottoMatchesCountStatistics() {
		MessageUtil.printMessage("\n"+MessageConstants.LOTTO_STATISTICS_MESSAGE);
		MessageUtil.printSeparatorLine();
		Rank[] ranks = Rank.values();
		for(int i=ranks.length-2; i>=0; i--) {
			Rank rank = ranks[i];
			boolean isSecond = (rank.name() == Rank.SECOND.name());
			long count = this.lottos.stream()
									.filter(lotto -> lotto.getRank() == rank)
									.count();
			MessageUtil.printRank((long)rank.getCountOfMatch(), (long)rank.getWinningMoney(), count, isSecond);
		}
		printLottoProfitRatio();
	}

	/**
	 * 로또 당침금 수익률 출력
	 */
	private void printLottoProfitRatio() {
		long profit = 0;
		for(Lotto lotto : lottos) {
			profit += lotto.getRank().getWinningMoney();
		}
		String profitRatio = new DecimalFormat("#.##").format((float) profit / (float) this.perchaseAmount);
		MessageUtil.printMessage(MessageConstants.LOTTO_PROFIT_RATIO_MESSAGE, profitRatio);
	}

	/**
	 * 구매 금액을 통해 구매된 로또 갯수 가져오기
	 * @param perchaseAmount
	 * @return
	 */
	public static int getLottoCount(int perchaseAmount) {
		return (perchaseAmount / 1000);
	}

	/**
	 * 1에서 45 사이의 숫자 가져오기
	 * @return
	 */
	public static int getNumberBetweenOneAndFortyFive() {
		return (int) ((Math.random() * 45) + 1);
	}

	/**
	 * 사용자가 입력한 지난주 정답이 숫자 형태의 문자열인지 확인
	 * @param winningNumbers
	 * @return
	 */
	public static boolean checkInputWinningNumbersValidation(String winningNumbers) {
		boolean isValidWinningNumbers = true;
		String[] winningNumberArray = winningNumbers.split(PatternConstants.DEFAULT_SEPARATOR_PATTERN);
		int currentWinningNumberIndex = 0;
		while(isValidWinningNumbers && currentWinningNumberIndex < winningNumberArray.length) {
			String winningNumber = winningNumberArray[currentWinningNumberIndex];
			isValidWinningNumbers = ((winningNumberArray.length == 6) && NumberUtil.isNumber(winningNumber) && NumberUtil.isNumberBetweenOneAndFortyFive(Integer.parseInt(winningNumber)));
			currentWinningNumberIndex++;
		}
		return isValidWinningNumbers;
	}
}
