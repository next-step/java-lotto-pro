package step3;

import static java.util.stream.Collectors.*;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

public class LottoNumbers {
	public static final int LOTTO_NUMBER_MAX = 6;
	private static Set<LottoNumber> lottoNumbers;

	public LottoNumbers(Set<LottoNumber> lottoNumbers) {
		this.lottoNumbers = Collections.unmodifiableSet(lottoNumbers);
	}

	public LottoNumbers(){
		lottoNumbers = new HashSet<>();
	}

	public static LottoNumbers createLottoNumber(Set<LottoNumber> inputLottoNumber) {
		lottoNumbers = new HashSet<>();
		validation();
		return new LottoNumbers(inputLottoNumber);
	}

	public static LottoNumbers createLottoNumber(LottoNumber ...inputLottoNumber) {
		lottoNumbers = new HashSet<>();
		return new LottoNumbers(from(inputLottoNumber));
	}

	private static void validation() {
		if (isOverFlow()) {
			throw new ArrayIndexOutOfBoundsException("로또 번호가 6개 이상 뽑혔습니다.");
		}
	}

	private static boolean isOverFlow() {
		return lottoNumbers.size() > LOTTO_NUMBER_MAX;
	}

	private static Set<LottoNumber> from(LottoNumber[] inputLottoNumber) {
		return Stream.of(inputLottoNumber).collect(toCollection(HashSet::new));
	}

	@Deprecated
	public LottoNumbers createLottoNumbers() {
		while (isNotMaxNumber()) {
			validation();
			lottoNumbers.add(new LottoNumber(RandomUtils.pick()));
		}
		return new LottoNumbers(this.lottoNumbers);
	}

	@Deprecated
	private boolean isNotMaxNumber() {
		return LOTTO_NUMBER_MAX != lottoNumbers.size();
	}

	public Integer match(LottoNumber lottoNumber) {
		int count = 0;
		Optional<LottoNumber> any = this.lottoNumbers.stream().filter(s -> s.equals(lottoNumber)).findAny();
		if (any.isPresent()) {
			count++;
		}
		return new Integer(count);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		LottoNumbers that = (LottoNumbers)o;
		return Objects.equals(lottoNumbers, that.lottoNumbers);
	}

	@Override
	public int hashCode() {
		return Objects.hash(lottoNumbers);
	}

	@Override
	public String toString() {
		return String.valueOf(lottoNumbers);
	}

}
