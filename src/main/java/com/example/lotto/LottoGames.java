package com.example.lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class LottoGames {
	private final List<LottoGame> values;

	private LottoGames(List<LottoGame> lottoGames) {
		this.values = lottoGames;
	}

	static LottoGames manual(List<List<Integer>> numbersList) {
		return new LottoGames(numbersList.stream()
			.map(LottoGame::manual)
			.collect(Collectors.toList()));
	}

	static LottoGames auto(long count, NumbersGenerator numbersGenerator) {
		return new LottoGames(LongStream.range(0, count)
			.boxed()
			.map(l -> LottoGame.auto(numbersGenerator))
			.collect(Collectors.toList()));
	}

	static LottoGames merge(LottoGames first, LottoGames second) {
		return new LottoGames(
			Stream.concat(first.values.stream(), second.values.stream()).collect(Collectors.toList()));
	}

	public List<LottoGame> getValues() {
		return values;
	}

	public int size() {
		return values.size();
	}

	@Override
	public String toString() {
		return values.stream().map(LottoGame::toString).collect(Collectors.joining("\n"));
	}
}
