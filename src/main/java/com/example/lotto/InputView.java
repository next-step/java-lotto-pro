package com.example.lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class InputView {
	public static long inputPurchaseAmount() {
		return Long.parseLong(Console.readLine());
	}

	public static long inputManualLottoPurchaseCount() {
		return Long.parseLong(Console.readLine());
	}

	private static List<Integer> inputManualLottoNumbers() {
		return Arrays.stream(Console.readLine().split(", "))
			.map(Integer::valueOf)
			.collect(Collectors.toList());
	}

	public static List<List<Integer>> inputManualLottoNumbersList(long count) {
		return LongStream.range(0, count)
			.boxed()
			.map(l -> inputManualLottoNumbers()).collect(Collectors.toList());
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
