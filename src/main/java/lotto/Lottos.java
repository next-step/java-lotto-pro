package lotto;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Lottos implements Iterable<Lotto> {

	private final List<Lotto> lottos;

	public Lottos(int money) {
		int count = money / LottoConstants.PRICE;
		if (count == 0) {
			throw new IllegalArgumentException("Money is scarce.");
		}
		this.lottos = IntStream.range(0, count)
			.mapToObj(i -> LottoGenerator.generate())
			.collect(Collectors.toList());
	}

	public Lottos(int money, Lotto... lottos) {
		int count = money / LottoConstants.PRICE - lottos.length;
		if (count < 0) {
			throw new IllegalArgumentException("Money is scarce.");
		}
		this.lottos = Stream.concat(IntStream.range(0, count)
			.mapToObj(i -> LottoGenerator.generate()), Arrays.stream(lottos)).collect(Collectors.toList());
	}

	public int size() {
		return lottos.size();
	}

	@Override
	public Iterator<Lotto> iterator() {
		return lottos.iterator();
	}

	@Override
	public String toString() {
		StringJoiner joiner = new StringJoiner("\n");

		for (Lotto lotto : lottos) {
			joiner.add(lotto.toString());
		}

		return joiner.toString();
	}
}
