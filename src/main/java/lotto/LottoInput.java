package lotto;

import static lotto.common.Constants.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import lotto.common.Messages;

public class LottoInput {
	private List<Integer> input;

	public LottoInput(String input) {
		validate(input);
		this.input = Arrays.stream(input.split(DELIMITER)).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
	}

	/**
	 * validate 목록
	 * 1. 숫자와 , 만 입력 가능
	 * 2. 6개를 입력 해야 한다.
	 * 3. 1~45까지의 숫자만 입력 가능
	 * 4. 중복 숫자 허용하지 않는다.
	 *
	 * @param input
	 */
	private void validate(String input) {
		if (!NUMBER_COMMA_PATTERN.matcher(input).matches()) {
			throw new IllegalArgumentException(Messages.INPUT_NUMBER_FORMAT_NOT_VALID.getValues());
		}
		validString(input.split(DELIMITER));
	}

	private void validString(String[] split) {
		isLottoVolume(split);
		for (String s : split) {
			isNumber(s);
		}
		isDuplicate(split);
	}

	private void isNumber(String number) {
		try {
			int i = Integer.parseInt(number);
			isPositiveNumber(i);
			isRangeValid(i);
		}catch (NumberFormatException e) {
			throw new IllegalArgumentException(Messages.INPUT_NUMBER_FORMAT_NOT_VALID.getValues());
		}
	}

	private void isPositiveNumber(int i) {
		if (i < 0) {
			throw new RuntimeException(Messages.INPUT_NUMBER_FORMAT_NOT_VALID.getValues());
		}
	}

	private void isLottoVolume(String[] splitInput) {
		if (splitInput.length != VOLUME) {
			throw new IllegalArgumentException(Messages.INPUT_NUMBER_LENGTH_NOT_VALID.getValues());
		}
	}

	private void isRangeValid(int input) {
		if (input < START_NUMBER || input > END_NUMBER) {
			throw new IllegalArgumentException(Messages.INPUT_NUMBER_RANGE_NOT_VALID.getValues());
		}
	}

	private void isDuplicate(String[] splitInput) {
		Set<String> sets = new HashSet<>(Arrays.asList(splitInput));
		if (sets.size() != VOLUME) {
			throw new IllegalArgumentException(Messages.INPUT_NUMBER_DUPLICATE.getValues());
		}
	}

	public List<Integer> getInput() {
		return input;
	}
}
