package lotto.view;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.PurchaseMoney;
import lotto.model.WinLotto;

public class InputView {
	private static Scanner scanner = new Scanner(System.in);

	public static PurchaseMoney getMoney() {
		System.out.println("구입금액을 입력해 주세요.");
		return repeatWhenException(() -> new PurchaseMoney(getInteger()), IllegalArgumentException.class);
	}

	private static <T> T repeatWhenException(Supplier<T> supplier,
		Class<? extends Throwable> exceptionClass) {
		while (true) {
			try {
				return supplier.get();
			} catch (Exception e) {
				checkException(exceptionClass, e);
				System.out.println(e.getMessage());
			}
		}
	}

	private static void checkException(Class<? extends Throwable> exceptionClass, Exception e) {
		if (!exceptionClass.isInstance(e)) {
			throw new RuntimeException(e);
		}
	}

	public static WinLotto getWinLotto() {
		final Lotto winLotto = getWinLottoWithoutBonusNumber();
		final BonusNumber bonusNumber = getBonusNumber();
		return new WinLotto(winLotto, bonusNumber);
	}

	public static int getNumberManualLotto() {
		System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
		return getInteger();
	}

	public static Lottos getManualLottos(int numberOfLottos) {
		System.out.println("수동으로 구매할 번호를 입력해 주세요.");
		return new Lottos(IntStream.range(0, numberOfLottos)
			.mapToObj(index -> getLotto())
			.collect(Collectors.toList()));
	}

	private static BonusNumber getBonusNumber() {
		System.out.println("보너스 볼을 입력해 주세요.");
		return repeatWhenException(() -> new BonusNumber(getInteger()), IllegalArgumentException.class);
	}

	private static int getInteger() {
		return repeatWhenException(() -> {
			String number = scanner.nextLine();
			return Integer.parseInt(number);
		}, NumberFormatException.class);
	}

	private static Lotto getWinLottoWithoutBonusNumber() {
		System.out.println("지난 주 당첨 번호를 입력해 주세요.");
		return getLotto();
	}

	private static Lotto getLotto() {
		return repeatWhenException(() -> {
			String numbers = scanner.nextLine();
			String[] splittedByComma = numbers.split(",");
			return new Lotto(Arrays.stream(splittedByComma)
				.map(String::trim)
				.map(Integer::parseInt)
				.collect(Collectors.toList()));
		}, IllegalArgumentException.class);
	}
}
