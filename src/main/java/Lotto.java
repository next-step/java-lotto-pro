import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lotto {

	public final static int PRICE_KRW = 1000;
	public final static int NUM_OF_LOTTO_NUMBERS = 6;

	private final static List<LottoNumber> CANDIDATE_LOTTO_NUMBERS =
		Stream.iterate(LottoNumber.MIN_INCLUSIVE_NUMBER, num -> num + 1)
			.limit(LottoNumber.MAX_INCLUSIVE_NUMBER)
			.map(LottoNumber::from)
			.collect(Collectors.toList());

	protected final List<LottoNumber> lottoNumbers;

	protected Lotto(List<LottoNumber> lottoNumbers) {
		validate(lottoNumbers);
		this.lottoNumbers = lottoNumbers;
	}

	private void validate(List<LottoNumber> lottoNumbers) {
		if (lottoNumbers.size() != NUM_OF_LOTTO_NUMBERS) {
			throw new LottoFormatException();
		}
		if (lottoNumbers.size() != lottoNumbers.stream().distinct().count()) {
			throw new LottoFormatException();
		}
	}

	public boolean hasBonus(LottoNumber bonus) {
		return this.lottoNumbers.contains(bonus);
	}

	public static Lotto from(String s) {
		return new Lotto(LottoParser.parse(s));
	}

	public static Lotto of() {
		return new Lotto(generate());
	}

	private static List<LottoNumber> generate() {
		Collections.shuffle(CANDIDATE_LOTTO_NUMBERS);
		final List<LottoNumber> numbers = new ArrayList<>(CANDIDATE_LOTTO_NUMBERS.subList(0, NUM_OF_LOTTO_NUMBERS));
		Collections.sort(numbers);
		return numbers;
	}

	@Override
	public String toString() {
		return this.lottoNumbers.toString();
	}
}
