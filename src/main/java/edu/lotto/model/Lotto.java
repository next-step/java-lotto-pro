package edu.lotto.model;

import edu.lotto.constants.Rank;
import edu.lotto.utils.MessageUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

/**
 * 로또 번호를 저장하는 Model
 * @since 2021.11.04
 * @author Inmook,Jeong
 */
public class Lotto {

	private static Logger logger = Logger.getLogger(Lotto.class.getName());

	private List<Integer> lottoNumbers;
	private Rank rank;

	public Lotto() {
		setLottoNumber();
		Collections.sort(this.lottoNumbers);
		MessageUtil.printMessage(lottoNumbers.toString());
	}

	/**
	 * 로또 번호 6자리 세팅하기
	 * @return
	 */
	private void setLottoNumber() {
		List<Integer> allLottoNumbers = getLottoNumberRange();
		Collections.shuffle(allLottoNumbers);
		this.lottoNumbers = allLottoNumbers.subList(0,6);
	}

	/**
	 * 1~45까지 담긴 로또 번호 리스트 가져오기
	 * @return
	 */
	private List<Integer> getLottoNumberRange() {
		List<Integer> allLottoNumbers = new ArrayList<Integer>();
		for(int i=1; i<=45; i++) {
			allLottoNumbers.add(i);
		}
		return allLottoNumbers;
	}

	/**
	 * 로또 당첨 순위 Setter
	 */
	public void setRank(List<Integer> winningNumbers, int bonusNumber) {
		Long matchesCount
				= this.lottoNumbers.stream()
									.filter(number -> winningNumbers.contains(number))
									.count();
		this.rank = Rank.valueOf(matchesCount.intValue(), isMatchBonusNumber(bonusNumber));
	}

	/**
	 * 로또 당첨 순위 Getter
	 * @return
	 */
	public Rank getRank() {
		return this.rank;
	}

	/**
	 * 보너스 번호가 Lotto 번호 안에 있는지 확인
	 * @param bonusNumber
	 * @return
	 */
	private boolean isMatchBonusNumber(int bonusNumber) {
		return this.lottoNumbers.contains(bonusNumber);
	}
}
