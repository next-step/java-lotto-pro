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

	public Lottos() {
		this.lottos = new ArrayList<Lotto>();
	}

	/**
	 * 수동으로 입력한 Lotto 번호 등록
	 * @param manualLottoNumbers
	 */
	public void setManualLottos(List<String> manualLottoNumbers) {
		// TODO
	}

	private List<Lotto> stringListToLottoList(List<String> manualLottoNumbers) {
		List<Lotto> manualLottos = new ArrayList<Lotto>();
		return manualLottos;
	}

	/**
	 * 자동으로 발급된 로또 번호 추가
	 * @param perchaseAmount
	 * @param perchaseLottoCount
	 * @param manualCount
	 */
	public void setAutomaticLottos(int perchaseAmount, int perchaseLottoCount, int manualCount) {
		this.perchaseAmount = perchaseAmount;
		addLottos(perchaseAmount, perchaseLottoCount, manualCount);
	}

	/**
	 * 구매 갯수만큼 Lotto 번호 발급 
	 * @param perchaseAmount
	 * @return
	 */
	private void addLottos(int perchaseAmount, int perchaseLottoCount, int manualCount) {
		List<Lotto> automaticLottos = new ArrayList<Lotto>();
		int automaticLottoCount = getAutomaticLottoCount(perchaseLottoCount, manualCount);
		MessageUtil.printMessage(MessageConstants.LOTTO_PERCHASE_MANUAL_MESSAGE, manualCount, automaticLottoCount);
		for(int i=0; i<automaticLottoCount; i++) {
			lottos.add(new Lotto());
		}
	}

	/**
	 * 수동 구매 수를 제외하고 자동으로 발급할 로또 갯수 가져오기
	 * @param perchaseLottoCount
	 * @param manualCount
	 * @return
	 */
	private int getAutomaticLottoCount(int perchaseLottoCount, int manualCount) {
		return perchaseLottoCount-manualCount;
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
		MessageUtil.printMessage(MessageConstants.LOTTO_STATISTICS_MESSAGE);
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
	 * 1에서 45 사이의 숫자 가져오기
	 * @return
	 */
	public static int getNumberBetweenOneAndFortyFive() {
		return (int) ((Math.random() * 45) + 1);
	}
}
