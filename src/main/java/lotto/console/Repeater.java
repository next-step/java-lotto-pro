package lotto.console;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Money;

public class Repeater {
	private static boolean repeater;

	private Repeater() {
	}

	public static void init() {
		repeater = true;
	}

	public static boolean isContinue() {
		return repeater;
	}

	public static void set(Money setValue) {
		repeater = setValue.equals(new Money(0));
	}

	public static void set(String setValue) {
		repeater = setValue.equals("");
	}

	public static void set(int setValue) {
		repeater = setValue == -1;
	}

	public static void set(Lotto manualLottoNumber) {
		repeater = manualLottoNumber == null;
	}
}
