import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoFactory {

	private final static List<LottoNumber> CANDIDATE_LOTTO_NUMBERS =
		Stream.iterate(LottoNumber.MIN_INCLUSIVE_NUMBER, num -> num + 1)
			.limit(LottoNumber.MAX_INCLUSIVE_NUMBER)
			.map(LottoNumber::from)
			.collect(Collectors.toList());

	public static Lotto from(String s) {
		return new Lotto(LottoParser.parse(s));
	}

	public static Lotto of() {
		return new Lotto(generate());
	}

	private static List<LottoNumber> generate() {
		Collections.shuffle(CANDIDATE_LOTTO_NUMBERS);
		return new ArrayList<>(CANDIDATE_LOTTO_NUMBERS.subList(0, Lotto.NUM_OF_LOTTO_NUMBERS));
	}
}
