package lotto.domain.lotto;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;

public class LottoNumber implements Comparable<LottoNumber> {
	public static final int MIN_RANGE = 1;
	public static final int MAX_RANGE = 45;

	private static final Map<Integer, LottoNumber> lottoNumberCache = new HashMap<>();

	static {
		IntStream.rangeClosed(MIN_RANGE, MAX_RANGE)
			.forEach(i -> lottoNumberCache.put(i, new LottoNumber(i)));
	}

	private final int lottoNumber;

	private LottoNumber(final int lottoNumber) {
		this.lottoNumber = lottoNumber;
	}

	public static LottoNumber from(int lottoNumber) {
		validateLottoNumberRange(lottoNumber);
		return lottoNumberCache.get(lottoNumber);
	}

	private static void validateLottoNumberRange(final int lottoNumber) {
		if (lottoNumber < MIN_RANGE) {
			throw new IllegalArgumentException("로또 번호는 1 ~ 45 범위여야 합니다.");
		}
		if (lottoNumber > MAX_RANGE) {
			throw new IllegalArgumentException("로또 번호는 1 ~ 45 범위여야 합니다.");
		}
	}

	public int getInt() {
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
