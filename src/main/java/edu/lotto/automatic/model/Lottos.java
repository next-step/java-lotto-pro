package edu.lotto.automatic.model;

import edu.lotto.automatic.utils.NumberUtil;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

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
}
