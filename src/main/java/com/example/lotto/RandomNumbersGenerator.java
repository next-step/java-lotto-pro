package com.example.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomNumbersGenerator implements NumbersGenerator {

	@Override
	public List<Integer> generate(int from, int to, int size) {
		List<Integer> candidates = new ArrayList<>();
		for (int number = from; number <= to; number++) {
			candidates.add(number);
		}

		Collections.shuffle(candidates);
		return candidates.subList(0, size);
	}
}
