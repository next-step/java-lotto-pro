package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoNumbers {
	private static final String ERROR_DUPLICATE_LOTTO_NUMBER = "[ERROR] 로또 번호는 중복 될 수 없습니다.";
	private static final String ERROR_LOTTO_NUMBER_LENGTH = "[ERROR] 로또 번호는 6자리 숫자를 가져야 합니다.";
	private static final String DELIMITER = ", ";
	public static final int MATCHED_NUMBER = 1;
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
		validateLottoNumberLength(lottoNumbers);
		this.lottoNumbers = new ArrayList<>(lottoNumbers);
	}

	public List<LottoNumber> getLottoNumbers() {
		return Collections.unmodifiableList(lottoNumbers);
	}

	private static List<LottoNumber> validateStringLottoNumbers(String lottoNumbers) {
		String[] stringNumberArray = lottoNumbers.split(DELIMITER);
		validateDuplicate(stringNumberArray);
		return Arrays.stream(stringNumberArray)
			.map(LottoNumber::new)
			.collect(Collectors.toList());
	}

	private static void validateDuplicate(String[] stringNumberArray) {
		Set<String> duplicateCheck = new HashSet<>();
		Collections.addAll(duplicateCheck, stringNumberArray);
		if (duplicateCheck.size() < MAX_RANGE_VALUE) {
			throw new IllegalArgumentException(ERROR_DUPLICATE_LOTTO_NUMBER);
		}
	}

	private void validateLottoNumberLength(List<LottoNumber> lottoNumbers) {
		if (lottoNumbers.size() != MAX_RANGE_VALUE) {
			throw new IllegalArgumentException(ERROR_LOTTO_NUMBER_LENGTH);
		}
	}

	public Stream<LottoNumber> stream() {
		return lottoNumbers.stream();
	}
}

