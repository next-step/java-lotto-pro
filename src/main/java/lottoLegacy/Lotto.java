package lottoLegacy;

import static lottoLegacy.common.Constants.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
	private List<LottoNumber> numbers;

	private final List<LottoNumber> allNumbers =
		IntStream.range(START_NUMBER, END_NUMBER).mapToObj(LottoNumber::new).collect(Collectors.toList());

	public Lotto() {
		this.numbers = generate();
	}

	private List<LottoNumber> generate() {
		Collections.shuffle(allNumbers);
		return allNumbers.subList(0, VOLUME);
	}

	public List<LottoNumber> getNumbers() {
		return numbers;
	}
}
