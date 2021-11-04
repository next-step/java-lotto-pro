package edu.lotto.automatic.model;

import edu.lotto.automatic.utils.NumberUtil;

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

	private int perchaseAmount;
	private int threeMatches;
	private int fourMatches;
	private int fiveMatches;
	private int sixMatches;
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
		System.out.println(lottoCount+"개를 구매했습니다.");
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
}
