package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoNumbers {
	private static final String ERROR_WINNING_NUMBER_TYPE = "[ERROR] 당첨 번호는 (, )를 구분자로 숫자만 입력 가능합니다. \n[예시] 1, 2, 3, 4, 5, 6";
	private static final String ERROR_DUPLICATE_LOTTO_NUMBER = "[ERROR] 로또 번호는 중복 될 수 없습니다.";
	private static final String DELIMITER = ", ";
	private static final int MATCHED_NUMBER_PLUS = 1;
	private static final int NON_MATCHED_NUMBER = 0;
	public static final int MIN_RANGE_VALUE = 0;
	public static final int MAX_RANGE_VALUE = 6;
	private final List<LottoNumber> lottoNumbers;

	public LottoNumbers(final int... lottoNumbers) {
		this(Arrays.stream(lottoNumbers)
			.mapToObj(LottoNumber::new)
			.collect(Collectors.toList()));
	}

	public LottoNumbers(final String lottoNumbers) {
		this(validateStringLottoNumbers(lottoNumbers));
	}

	public LottoNumbers(final List<LottoNumber> lottoNumbers) {
		this.lottoNumbers = new ArrayList<>(lottoNumbers);
	}

	// 삭제 예쩡
	public int ifMatchCount(int winningNumber) {
		if (lottoNumbers.contains(new LottoNumber(winningNumber))) {
			return MATCHED_NUMBER_PLUS;
		}
		return NON_MATCHED_NUMBER;
	}

	public int ifMatchCount(LottoNumber winningNumber) {
		if (lottoNumbers.contains(winningNumber)) {
			return MATCHED_NUMBER_PLUS;
		}
		return NON_MATCHED_NUMBER;
	}

	public List<String> getStringValues() {
		List<String> stringValues = new ArrayList<>();
		for (LottoNumber lottoNumber : lottoNumbers) {
			stringValues.add(String.valueOf(lottoNumber.getValue()));
		}
		return stringValues;
	}

	public List<LottoNumber> getLottoNumbers() {
		return Collections.unmodifiableList(lottoNumbers);
	}

	private static List<LottoNumber> validateStringLottoNumbers(String lottoNumbers) {
		String[] stringNumberArray = lottoNumbers.split(DELIMITER);
		validateLottoNumbersBoundary(stringNumberArray);
		validateDuplicate(stringNumberArray);
		return Arrays.stream(stringNumberArray)
			.map(LottoNumber::new)
			.collect(Collectors.toList());
	}

	private static void validateDuplicate(String[] stringNumberArray) {
		Set<String> duplicateCheck = new HashSet<>();
		for (String number : stringNumberArray) {
			duplicateCheck.add(number);
		}
		if (duplicateCheck.size() < MAX_RANGE_VALUE) {
			throw new IllegalArgumentException(ERROR_DUPLICATE_LOTTO_NUMBER);
		}
	}

	private static void validateLottoNumbersBoundary(String[] stringNumberArray) {
		if (stringNumberArray.length < MAX_RANGE_VALUE) {
			throw new IllegalArgumentException(ERROR_WINNING_NUMBER_TYPE);
		}
	}

}

