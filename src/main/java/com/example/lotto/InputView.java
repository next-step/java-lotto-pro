package com.example.lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
	public static long inputPurchaseAmount() {
		return Long.parseLong(Console.readLine());
	}

	public static List<Integer> inputBaseWinningLottoNumbers() {
		return Arrays.stream(Console.readLine().split(", "))
			.map(Integer::valueOf)
			.collect(Collectors.toList());
	}

	public static int inputBonusWinningLottoNumber() {
		return Integer.parseInt(Console.readLine());
	}
}
