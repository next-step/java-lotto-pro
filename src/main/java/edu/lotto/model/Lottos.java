package edu.lotto.model;

import edu.lotto.constants.MessageConstants;
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
		int lottoCount = NumberUtil.getLottoCount(perchaseAmount);
		System.out.println(lottoCount + MessageConstants.LOTTO_PERCHASE_MESSAGE);
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

	public void printLottoMatchesCountStatistics() {
		System.out.println("\n"+MessageConstants.LOTTO_STATISTICS_MESSAGE);
		System.out.println("---------");
		System.out.println(MessageConstants.THREE_MATCHES_MESSAGE + getLottoMatchesCountByMatchNumber(3) +"개");
		System.out.println(MessageConstants.FOUR_MATCHES_MESSAGE + getLottoMatchesCountByMatchNumber(4) +"개");
		System.out.println(MessageConstants.FIVE_MATCHES_MESSAGE + getLottoMatchesCountByMatchNumber(5) +"개");
		System.out.println(MessageConstants.SIX_MATCHES_MESSAGE + getLottoMatchesCountByMatchNumber(6) +"개");
		printLottoProfitRatio();
	}

	private void printLottoProfitRatio() {
		long profit = (5000 * this.threeMatches)
				+ (50000 * this.fourMatches)
				+ (1500000 * this.fiveMatches)
				+ (2000000000 * this.sixMatches);
		String profitRatio = new DecimalFormat("#.##").format((float) profit / (float) this.perchaseAmount);
		System.out.println("총 수익률은 "+profitRatio+"입니다.");
	}

	public long getLottoMatchesCountByMatchNumber(long number) {
		long matchesCount = this.lottos.stream().filter(lotto -> lotto.getWinningNumberMatchesCount() == number).count();
		if(number == 3) this.threeMatches = matchesCount;
		if(number == 4) this.fourMatches = matchesCount;
		if(number == 5) this.fiveMatches = matchesCount;
		if(number == 6) this.sixMatches = matchesCount;
		return matchesCount;
	}
}
