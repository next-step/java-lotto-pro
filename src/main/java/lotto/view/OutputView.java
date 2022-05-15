package lotto.view;

import java.util.List;
import java.util.stream.Collectors;

import lotto.dto.LottoNumber;

public class OutputView {
	public static void printPurchaseCount(int count) {
		System.out.printf("%d개를 구매했습니다.", count);
	}

	public static void printLottoTickets(List<LottoNumber> lottoTickets) {
		for(LottoNumber number: lottoTickets) {
			printLotto(number);
		}
	}

	private static void printLotto(LottoNumber lottoNumber) {
		List<Integer> numbers = lottoNumber.getNumbers();
		String printNumbers = numbers.stream()
								.map(number -> number.toString())
								.collect(Collectors.joining(","));

		System.out.printf("[%s]", printNumbers);
	}
}
