package lotto;

import static common.Constants.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import exception.BusinessException;
import exception.ErrorMessages;

public class Lotto {
	private final List<LottoNumber> ALL_NUMBERS =
		IntStream.range(START_NUMBER, END_NUMBER)
			.mapToObj(LottoNumber::new).
			collect(Collectors.toList());

	private List<LottoNumber> lotto;

	public Lotto() {
		this.lotto = generated();
	}

	public Lotto(String input) {
		String[] splitInputs = splitAfterValidate(input);
		this.lotto = new ArrayList<>();
		for (String split: splitInputs) {
			this.lotto.add(new LottoNumber(Integer.parseInt(split)));
		}
	}

	private List<LottoNumber> generated() {
		Collections.shuffle(ALL_NUMBERS);
		return ALL_NUMBERS.subList(0, LOTTO_VOLUME);
	}

	/**
	 * validate 목록
	 * 1. 숫자와 , 만 입력 가능
	 * 2. 6개를 입력 해야 한다.
	 * 3. 중복 숫자 허용하지 않는다.
	 *
	 * @param input
	 */
	private String[] splitAfterValidate(String input) {
		if (!NUMBER_COMMA_PATTERN.matcher(input).matches()) {
			throw new BusinessException(ErrorMessages.INPUT_NUMBER_COMMA_FORMAT_NOT_VALID);
		}
		String[] split = input.split(DELIMITER);
		isLottoVolume(split);
		isDuplicate(split);
		return split;
	}

	private void isLottoVolume(String[] splitInput) {
		if (splitInput.length != LOTTO_VOLUME) {
			throw new BusinessException(ErrorMessages.INPUT_NUMBER_LENGTH_NOT_VALID);
		}
	}

	private void isDuplicate(String[] splitInput) {
		Set<String> sets = new HashSet<>(Arrays.asList(splitInput));
		if (sets.size() != LOTTO_VOLUME) {
			throw new BusinessException(ErrorMessages.INPUT_NUMBER_DUPLICATE);
		}
	}

	public int size() {
		return lotto.size();
	}

	public int compareCount(Lotto compare) {
		compare.lotto.retainAll(lotto);
		return compare.size();
	}

	public boolean contains(LottoNumber lottoNumber) {
		return lotto.contains(lottoNumber);
	}

	@Override
	public String toString() {
		return lotto.toString();
	}
}
