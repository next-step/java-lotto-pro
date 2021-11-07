package edu.lotto.model;

import edu.lotto.constants.MessageConstants;
import edu.lotto.constants.PatternConstants;
import edu.lotto.utils.MessageUtil;
import edu.lotto.utils.NumberUtil;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Lottos - Lotto의 일급컬렉션
 * @since 2021.11.04
 * @author Inmook,Jeong
 */
public class Lottos {

	private static Logger logger = Logger.getLogger(Lottos.class.getName());

	private long perchaseAmount;
	// TODO Enum 구분 대상
	private long threeMatches;
	private long fourMatches;
	private long fiveMatches;
	private long sixMatches;
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
	public void setWinningNumberMatchesCount(List<Integer> winningNumbers) {
		for(Lotto lotto : this.lottos) {
			lotto.setWinningNumberMatchesCount(winningNumbers);
		}
	}

	/**
	 * 등수 별 로또 당첨 게임 출력
	 */
	public void printLottoMatchesCountStatistics() {
		MessageUtil.printMessage("\n"+MessageConstants.LOTTO_STATISTICS_MESSAGE);
		MessageUtil.printSeparatorLine();

		MessageUtil.printMessage(MessageConstants.THREE_MATCHES_MESSAGE + getLottoMatchesCountByMatchNumber(3) +"개");
		MessageUtil.printMessage(MessageConstants.FOUR_MATCHES_MESSAGE + getLottoMatchesCountByMatchNumber(4) +"개");
		MessageUtil.printMessage(MessageConstants.FIVE_MATCHES_MESSAGE + getLottoMatchesCountByMatchNumber(5) +"개");
		MessageUtil.printMessage(MessageConstants.SIX_MATCHES_MESSAGE + getLottoMatchesCountByMatchNumber(6) +"개");
		printLottoProfitRatio();
	}

	/**
	 * 로또 당침금 수익률 출력
	 */
	private void printLottoProfitRatio() {
		long profit = (5000 * this.threeMatches)
				+ (50000 * this.fourMatches)
				+ (1500000 * this.fiveMatches)
				+ (2000000000 * this.sixMatches);
		String profitRatio = new DecimalFormat("#.##").format((float) profit / (float) this.perchaseAmount);
		MessageUtil.printMessage(MessageConstants.LOTTO_PROFIT_RATIO_MESSAGE, profitRatio);
	}

	/**
	 * 일치 갯수 별 로또 당첨 게임 수 가져오기
	 * @param number
	 * @return
	 */
	public long getLottoMatchesCountByMatchNumber(long number) {
		long matchesCount = this.lottos.stream().filter(lotto -> lotto.getWinningNumberMatchesCount() == number).count();
		if(number == 3) this.threeMatches = matchesCount;
		if(number == 4) this.fourMatches = matchesCount;
		if(number == 5) this.fiveMatches = matchesCount;
		if(number == 6) this.sixMatches = matchesCount;
		return matchesCount;
	}

	/**
	 * 사용자가 입력한 구매 금액이 숫자이고, 1000 이상의 숫자인지 확인
	 * @param amount
	 * @return
	 */
	public static boolean checkPerchaseAmountValidation(String amount) {
		boolean validPerchaseAmount = true;
		if(!NumberUtil.isNumber(amount)) {
			validPerchaseAmount = false;
			MessageUtil.printMessage(MessageConstants.ONLY_INPUT_NUMBER_MESSAGE);
		}
		if(validPerchaseAmount && !NumberUtil.isMoreThanThousand(Integer.parseInt(amount))) {
			validPerchaseAmount = false;
			MessageUtil.printMessage(MessageConstants.LOTTO_PRICE_INFORMATION_MESSAGE);
		}
		return validPerchaseAmount;
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
