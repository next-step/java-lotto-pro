package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber implements Comparable<LottoNumber> {

	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 45;
	public static final String ERROR_LOTTO_NUMBER = "로또 번호는 1 ~ 45 사이의 값을 입력하세요.";
	private static Map<Integer, LottoNumber> lottoNumbers = new HashMap<>();

	static {
		IntStream.rangeClosed(MIN_NUMBER, MAX_NUMBER)
			.forEach(value -> lottoNumbers.put(value, new LottoNumber(value)));
	}

	private final int lottoNumber;

	private LottoNumber(int lottoNumber) {
		this.lottoNumber = lottoNumber;
	}

	public static LottoNumber of(int number) {
		return Optional.ofNullable(lottoNumbers.get(number))
			.orElseThrow(() -> new IllegalArgumentException(ERROR_LOTTO_NUMBER));
	}

	public static List<LottoNumber> getLottoNumbers() {
		return new ArrayList<>(lottoNumbers.values());
	}

	public int getLottoNumber() {
		return lottoNumber;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		LottoNumber that = (LottoNumber)o;
		return lottoNumber == that.lottoNumber;
	}

	@Override
	public int hashCode() {
		return Objects.hash(lottoNumber);
	}

	@Override
	public int compareTo(LottoNumber o) {
		return this.lottoNumber - o.lottoNumber;
	}
}
