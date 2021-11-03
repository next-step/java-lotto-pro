package com.example.lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
	public static int inputPurchaseAmount() {
		return Integer.parseInt(Console.readLine());
	}

	public static List<Integer> inputLastWeekWinningLottoNumbers() {
		return Arrays.stream(Console.readLine().split(", "))
			.map(Integer::valueOf)
			.collect(Collectors.toList());
	}
}
