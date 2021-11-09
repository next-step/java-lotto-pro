package lotto.view;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.util.LottoGenerator;

public class InputView {
	private static Scanner scanner = new Scanner(System.in);

	public static Lottos purchaseLottos() {
		System.out.println("구입금액을 입력해 주세요.");
		int money = Integer.parseInt(scanner.nextLine());
		Lottos lottos = LottoGenerator.purchaseLottos(money);
		System.out.printf("%d개를 구매했습니다.%n", lottos.size());
		System.out.println(lottos);
		System.out.println();
		return lottos;
	}

	public static Lotto getWinLotto() {
		System.out.println("지난 주 당첨 번호를 입력해 주세요.");
		String numbers = scanner.nextLine();
		String[] splittedByComma = numbers.split(",");
		Lotto winLotto = new Lotto(Arrays.stream(splittedByComma)
			.map(String::trim)
			.map(Integer::parseInt)
			.collect(Collectors.toList()));
		return winLotto;
	}
}
