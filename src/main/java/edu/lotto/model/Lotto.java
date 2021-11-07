package edu.lotto.model;

import edu.lotto.utils.NumberUtil;

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

	public Lotto() {
		this.lottoNumbers = setLottoNumber();
		System.out.println(lottoNumbers.toString());
	}

	/**
	 * 로또 번호 6자리 세팅하기
	 * @return
	 */
	private List<Integer> setLottoNumber() {
		List<Integer> lottoNumberList = new ArrayList<Integer>();
		while(lottoNumberList.size() < 6) {
			addNotDuplicatedNumber(lottoNumberList);
		}
		Collections.sort(lottoNumberList);
		return lottoNumberList;
	}

	/**
	 * 임의의 숫자를 가져와서 숫자 리스트에 중복된 값이 없는 경우 리스트에 추가
	 * @param lottoNumberList
	 */
	private void addNotDuplicatedNumber(List<Integer> lottoNumberList) {
		int randomNumber = NumberUtil.getNumberBetweenOneAndFortyFive();
		if(!lottoNumberList.contains(randomNumber)) {
			lottoNumberList.add(randomNumber);
		}
	}

	/**
	 * 지난주 정답과 로또 번호가 몇개 일치하는지 확인
	 * @param winningNumbers
	 */
	public void setWinningNumberMatchesCount(List<Integer> winningNumbers) {
		this.winningNumberMatchesCount = this.lottoNumbers.stream().filter(number -> winningNumbers.contains(number)).count();
	}

	/**
	 * WinningNumberMatchesCount 가져오기
	 * @return
	 */
	public long getWinningNumberMatchesCount() {
		return this.winningNumberMatchesCount;
	}
}
