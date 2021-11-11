package edu.lotto.model;

import edu.lotto.constants.PatternConstants;
import edu.lotto.constants.Rank;
import edu.lotto.utils.MessageUtil;

import java.util.*;
import java.util.logging.Logger;

/**
 * 로또 번호를 저장하는 Model
 * @since 2021.11.04
 * @author Inmook,Jeong
 */
public class Lotto {

	private static Logger logger = Logger.getLogger(Lotto.class.getName());

	private List<LottoNumber> lottoNumbers;

	/**
	 * 로또 번호 자동발급
	 * @return
	 */
	public Lotto() {
		List<LottoNumber> allLottoNumbers = getLottoNumberRange();
		Collections.shuffle(allLottoNumbers);
		this.lottoNumbers = allLottoNumbers.subList(0,6);
		sortLottoNumber();
	}

	/**
	 * 수동으로 입력한 로또 발급
	 * @return
	 */
	public Lotto(String manualNumber) {
		this.lottoNumbers = changeStringToListLottoNumberType(manualNumber);
		sortLottoNumber();
	}

	/**
	 * 문자열로 전달된 로또 번호를 List<LottoNumber> 타입으로 변환
	 * @param lottoNumber
	 * @return
	 */
	private List<LottoNumber> changeStringToListLottoNumberType(String lottoNumber) {
		List<LottoNumber> lottoNumbers = new ArrayList<LottoNumber>();
		String[] lottoNumberArray = lottoNumber.replace(" ", "").split(PatternConstants.DEFAULT_SEPARATOR_PATTERN);
		for(String lottoNumberValue : lottoNumberArray) {
			lottoNumbers.add(new LottoNumber(Integer.parseInt(lottoNumberValue)));
		}
		return lottoNumbers;
	}

	/**
	 * 로또 번호 정렬
	 */
	private void sortLottoNumber() {
		Collections.sort(this.lottoNumbers, comparator);
	}

	/**
	 * 로또 번호 정렬을 위한 Comparator
	 */
	Comparator<LottoNumber> comparator = new Comparator<LottoNumber>() {
		@Override
		public int compare(LottoNumber l1, LottoNumber l2) {
			return l1.getLottoNumber() - l2.getLottoNumber();
		}
	};

	/**
	 * 로또 번호 출력
	 */
	public void printLottoNumber() {
		MessageUtil.printMessage(lottoNumbers.toString());
	}

	/**
	 * 1~45까지 담긴 로또 번호 리스트 가져오기
	 * @return
	 */
	private List<LottoNumber> getLottoNumberRange() {
		List<LottoNumber> allLottoNumbers = new ArrayList<LottoNumber>();
		for(int i=1; i<=45; i++) {
			allLottoNumbers.add(new LottoNumber(i));
		}
		return allLottoNumbers;
	}

	/**
	 * 로또 당첨 순위 가져오기
	 */
	public Rank getRank(List<LottoNumber> winningNumbers, int bonusNumber) {
		Long matchesCount
				= this.lottoNumbers.stream()
									.filter(lottoNumber ->  lottoNumber.containLottoNumber(winningNumbers))
									.count();
		return Rank.valueOf(matchesCount.intValue(), containBonusBall(bonusNumber));
	}

	/**
	 * 보너스 번호가 Lotto 번호 안에 있는지 확인
	 * @param bonusBall
	 * @return
	 */
	private boolean containBonusBall(int bonusBall) {
		long containCount = this.lottoNumbers.stream()
											.filter(lottoNumber -> lottoNumber.getLottoNumber() == bonusBall)
											.count();
		return (containCount != 0);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for(LottoNumber lottoNumber : this.lottoNumbers) {
			sb.append(lottoNumber.toString() + " ");
		}
		sb.append("]");
		return sb.toString().replace(" ]", "]");
	}
}
