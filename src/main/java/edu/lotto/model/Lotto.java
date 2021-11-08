package edu.lotto.model;

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

	public Lotto() {
		this.lottoNumbers = new ArrayList<>();
		setLottoNumber(this.lottoNumbers);
		Collections.sort(this.lottoNumbers);
		MessageUtil.printMessage(lottoNumbers.toString());
	}

	/**
	 * 로또 번호 6자리 세팅하기
	 * @return
	 */
	private void setLottoNumber(List<Integer> lottoNumberList) {
		int randomNumber = Lottos.getNumberBetweenOneAndFortyFive();
		if(lottoNumberList.size() < 6 && !lottoNumberList.contains(randomNumber)) {
			lottoNumberList.add(randomNumber);
			setLottoNumber(lottoNumberList);
		}
	}

	/**
	 * 임의의 숫자를 가져와서 숫자 리스트에 중복된 값이 없는 경우 리스트에 추가
	 * @param lottoNumberList
	 */
	@Deprecated
	private void addNotDuplicatedNumber(List<Integer> lottoNumberList) {
		int randomNumber = Lottos.getNumberBetweenOneAndFortyFive();
		if(!lottoNumberList.contains(randomNumber)) {
			lottoNumberList.add(randomNumber);
		}
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
}
