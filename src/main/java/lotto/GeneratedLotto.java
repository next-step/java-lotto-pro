package lotto;

import static common.Constants.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GeneratedLotto {
	private final List<LottoNumber> ALL_NUMBERS =
		IntStream.range(START_NUMBER, END_NUMBER)
			.mapToObj(LottoNumber::new).
			collect(Collectors.toList());

	private Lotto generatedLotto;

	public Lotto getGeneratedLotto() {
		return generatedLotto;
	}

	public GeneratedLotto() {
		this.generatedLotto = new Lotto(generated());
	}

	private List<LottoNumber> generated() {
		Collections.shuffle(ALL_NUMBERS);
		return ALL_NUMBERS.subList(0, LOTTO_VOLUME);
	}

}
