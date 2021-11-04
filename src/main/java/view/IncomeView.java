package view;

import java.io.PrintStream;

import model.Income;

public final class IncomeView {

	private static final String INCOME_MESSAGE_FORMAT = "총 수익률은 %s입니다.";

	private final PrintStream printer;

	private IncomeView(PrintStream printer) {
		this.printer = printer;
	}

	public static IncomeView from(PrintStream printer) {
		return new IncomeView(printer);
	}

	public void view(Income income) {
		printer.printf(INCOME_MESSAGE_FORMAT, income.ratio());
		printer.println();
	}
}
