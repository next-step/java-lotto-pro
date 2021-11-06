package lottoservice.matcher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import lottoservice.exception.InvalidLottoFormatException;
import lottoservice.lottonumber.LottoNumber;
import lottoservice.lottonumber.LottoNumbersMaker;

/**
 * 로또 당첨번호 클래스
 */

public class LottoWinningNumbers {

	private static String ERROR_MESSAGE_INVALID_LOTTO_FORMAT = "로또는 6개의 중복없는 숫자여야 합니다.";


	private Set<LottoNumber> winningNumbers;

	private LottoWinningNumbers(){

	}
	public LottoWinningNumbers(List<LottoNumber> lottoNumbers) {
		validateNotDuplicate(lottoNumbers);
		winningNumbers = lottoNumbers.stream().collect(Collectors.toSet());
	}

	private void validateNotDuplicate(List<LottoNumber> lottoNumber) {
		if(!isCorrectSize(lottoNumber)){
			throw new InvalidLottoFormatException(ERROR_MESSAGE_INVALID_LOTTO_FORMAT);
		}
	}

	private boolean isCorrectSize(List<LottoNumber> lottoNumber){
		return lottoNumber.stream().distinct().count() == 6;
	}

	public Set<LottoNumber> getWinningNumbers() {
		return winningNumbers;
	}

	public int compareWithNumbers(List<LottoNumber> ticketLottoNumbers) {
		return (int)ticketLottoNumbers.stream()
			.filter(it-> hasMatchNumber(it))
			.count();
	}

	public boolean hasMatchNumber(LottoNumber number){
		return winningNumbers.contains(number);
	}
}
