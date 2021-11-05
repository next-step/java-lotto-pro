package com.example.lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class LottoGames {
	private final List<LottoGame> values;

	public LottoGames(long count, NumbersGenerator numbersGenerator) {
		this.values = LongStream.range(0, count)
			.boxed()
			.map(i -> LottoGame.of(numbersGenerator))
			.collect(Collectors.toList());
	}

	public List<LottoGame> getValues() {
		return values;
	}

	@Override
	public String toString() {
		return values.stream().map(LottoGame::toString).collect(Collectors.joining("\n"));
	}
}
