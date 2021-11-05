package view;

import java.io.PrintStream;

import model.LottoPaper;
import model.LottoPapers;

public final class LottoPapersView {

	private static final String PURCHASE_COUNT_MESSAGE_FORMAT = "%d개를 구매했습니다.";
	private static final String LOTTO_MESSAGE_PATTERN = "[%s]";
	private final PrintStream printer;

	private LottoPapersView(PrintStream printer) {
		this.printer = printer;
	}

	public static LottoPapersView from(PrintStream printer) {
		return new LottoPapersView(printer);
	}

	public void view(LottoPapers lottoPapers) {
		printer.printf(PURCHASE_COUNT_MESSAGE_FORMAT, lottoPapers.size());
		printer.println();
		for (LottoPaper lotto : lottoPapers.collection()) {
			printer.printf(LOTTO_MESSAGE_PATTERN, lotto);
			printer.println();
		}
		printer.println();
	}
}
