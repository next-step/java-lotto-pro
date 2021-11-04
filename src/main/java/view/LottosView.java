package view;

import java.io.PrintStream;

import model.Lotto;
import model.Lottos;

public final class LottosView {

	private static final String PURCHASE_COUNT_MESSAGE_FORMAT = "%d개를 구매했습니다.";
	private static final String LOTTO_MESSAGE_PATTERN = "[%s]";
	private final PrintStream printer;

	private LottosView(PrintStream printer) {
		this.printer = printer;
	}

	public static LottosView from(PrintStream printer) {
		return new LottosView(printer);
	}

	public void view(Lottos lottos) {
		printer.printf(PURCHASE_COUNT_MESSAGE_FORMAT, lottos.size());
		printer.println();
		for (Lotto lotto : lottos.collection()) {
			printer.printf(LOTTO_MESSAGE_PATTERN, lotto);
			printer.println();
		}
		printer.println();
	}
}
