package view;

import java.io.PrintStream;

public final class GuidePrinter {

	private final PrintStream printer;
	private final String guide;

	private GuidePrinter(PrintStream printer, String guide) {
		validate(printer);
		validate(guide);
		this.printer = printer;
		this.guide = guide;
	}

	public static GuidePrinter of(PrintStream printer, String guide) {
		return new GuidePrinter(printer, guide);
	}

	public void print() {
		this.printer.println(guide);
	}

	private void validate(PrintStream printer) {
		if (printer == null) {
			throw new IllegalArgumentException("'printer' must not be null");
		}
	}

	private void validate(String sentence) {
		if (sentence == null || "".equals(sentence.trim())) {
			throw new IllegalArgumentException("'guide' must not be empty");
		}
	}
}
