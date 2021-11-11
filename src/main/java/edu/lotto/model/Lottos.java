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

	private int perchaseAmount;
	private List<Lotto> lottos;

	private Lottos() {}

	public Lottos(int perchaseAmount, int perchaseCount, List<String> manualLottoNumbers) {
		this.perchaseAmount = perchaseAmount;
		this.lottos = new ArrayList<Lotto>();

		int automaticCount = perchaseCount-manualLottoNumbers.size();
		addManualLottos(manualLottoNumbers);
		addAutomaticLottos(automaticCount);
		printLottos(perchaseCount, automaticCount);
	}

	/**
	 * 수동으로 입력한 Lotto 번호 발급
	 * @param manualLottoNumbers
	 */
	public void addManualLottos(List<String> manualLottoNumbers) {
		for(String manualLottoNumber : manualLottoNumbers) {
			Lotto lotto = new Lotto();
			this.lottos.add(new Lotto(manualLottoNumber));
		}
	}

	/**
	 * 자동으로 구매한 갯수만큼 로또 번호 발급
	 * @param automaticCount
	 */
	public void addAutomaticLottos(int automaticCount) {
		for(int i=0; i<automaticCount; i++) {
			this.lottos.add(new Lotto());
		}
	}

	/**
	 * 발급된 로또 번호 출력
	 * @param perchaseCount
	 * @param automaticCount
	 */
	private void printLottos(int perchaseCount, int automaticCount) {
		System.out.println();
		MessageUtil.printMessage(MessageConstants.LOTTO_PERCHASE_MANUAL_MESSAGE, (perchaseCount-automaticCount), automaticCount);
		for(Lotto lotto : lottos) {
			lotto.printLottoNumber();
		}
	}

	/**
	 * 로또 결과 출력
	 * @param winningNumbers
	 * @param bonusBall
	 */
	public void printResult(List<Integer> winningNumbers, int bonusBall) {
		System.out.println();
		MessageUtil.printMessage(MessageConstants.LOTTO_STATISTICS_MESSAGE);
		MessageUtil.printSeparatorLine();
		Rank[] ranks = Rank.values();
		for(int i=ranks.length-2; i>=0; i--) {
			Rank rank = ranks[i];
			boolean isSecond = (rank.name() == Rank.SECOND.name());
			long count = this.lottos.stream()
									.filter(lotto -> lotto.getRank(winningNumbers, bonusBall) == rank)
									.count();
			MessageUtil.printRank((long)rank.getCountOfMatch(), (long)rank.getWinningMoney(), count, isSecond);
		}
		printLottoProfitRatio(winningNumbers, bonusBall);
	}

	/**
	 * 로또 당침금 수익률 출력
	 */
	private void printLottoProfitRatio(List<Integer> winningNumbers, int bonusBall) {
		long profit = 0;
		for(Lotto lotto : lottos) {
			profit += lotto.getRank(winningNumbers, bonusBall).getWinningMoney();
		}
		String profitRatio = new DecimalFormat("#.##").format((float) profit / (float) this.perchaseAmount);
		MessageUtil.printMessage(MessageConstants.LOTTO_PROFIT_RATIO_MESSAGE, profitRatio);
	}
}
