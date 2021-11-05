package lotto;

import static common.Constants.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
	private final List<LottoNumber> ALL_NUMBERS =
		IntStream.range(START_NUMBER, END_NUMBER)
			.mapToObj(LottoNumber::new).
			collect(Collectors.toList());

	private List<LottoNumber> lotto;

	public Lotto() {
		this.lotto = generated();
	}

	private List<LottoNumber> generated() {
		Collections.shuffle(ALL_NUMBERS);
		return ALL_NUMBERS.subList(0, LOTTO_VOLUME);
	}

	public int size() {
		return lotto.size();
	}

	@Override
	public String toString() {
		return lotto.toString();
	}
}
