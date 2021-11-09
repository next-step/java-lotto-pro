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
	private long winningNumberMatchesCount;
	private boolean matchBonusNumber;
	private Rank rank;
	private long winningMoney;

	public Lotto() {
		this.lottoNumbers = new ArrayList<>();
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
	 * 지난주 정답과 로또 번호가 몇개 일치하는지 확인
	 * @param winningNumbers
	 */
	public void setWinningNumberMatchesCount(List<Integer> winningNumbers) {
		this.winningNumberMatchesCount
				= this.lottoNumbers.stream()
						.filter(number -> winningNumbers.contains(number))
						.count();
	}

	/**
	 * WinningNumberMatchesCount 가져오기
	 * @return
	 */
	public long getWinningNumberMatchesCount() {
		return this.winningNumberMatchesCount;
	}

	/**
	 * 보너스볼 일치 여부 Setter
	 * @param bonusNumber
	 */
	public void setMatchBonusNumber(int bonusNumber) {
		this.matchBonusNumber = lottoNumbers.contains(bonusNumber);
	}

	/**
	 * 보너스볼 일치여부 Getter
	 * @return
	 */
	public boolean getMatchBonusNumber() {
		return this.matchBonusNumber;
	}

	/**
	 * 로또 당첨 순위 Setter
	 */
	public void setRank() {
		Long matchesCount = this.winningNumberMatchesCount;
		this.rank = Rank.valueOf(matchesCount.intValue(), this.getMatchBonusNumber());
	}

	/**
	 * 로또 당첨 순위 Getter
	 * @return
	 */
	public Rank getRank() {
		return this.rank;
	}

	/**
	 * 로또 당첨 금액 Setter
	 */
	public void setWinningMoney() {
		this.winningMoney = this.rank.getWinningMoney();
	}

	/**
	 * 로또 당첨 금액 Getter
	 * @return
	 */
	public long getWinningMoney() {
		return this.winningMoney;
	}
}
