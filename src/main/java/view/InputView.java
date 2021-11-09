package view;

import static view.InputMessage.*;

import java.util.Scanner;

public class InputView {

	private static final Scanner sc = new Scanner(System.in);

	private InputView() {
	}

	public static String printPurchaseAmountMessageAndInput() {
		System.out.println(PURCHASE_AMOUNT_MESSAGE);
		return sc.nextLine();
	}

	public static String reInputIfInvalidPurchaseAmount() {
		System.out.println(ERROR_PURCHASE_AMOUNT_MESSAGE);
		return sc.nextLine();
	}

	public static String printManualPurchaseCountMessageAndInput() {
		nextLine();
		System.out.println(MANUAL_PURCHASE_COUNT_MESSAGE);
		return sc.nextLine();
	}

	public static String reInputIfInvalidManualPurchaseCount() {
		System.out.println(ERROR_MANUAL_PURCHASE_COUNT_MESSAGE);
		return sc.nextLine();
	}

	public static void printManualLottoNumberMessageAndInput() {
		nextLine();
		System.out.println(MANUAL_LOTTO_NUMBER_MESSAGE);
	}

	public static String reInputIfInvalidLottoNumber() {
		System.out.println(ERROR_LOTTO_NUMBER_MESSAGE);
		return sc.nextLine();
	}

	public static String printLastWeekWinningNumberMessageAndInput() {
		nextLine();
		System.out.println(LAST_WEEK_WINNING_NUMBER_MESSAGE);
		return sc.nextLine();
	}

	public static String printBonusBallMessageAndInput() {
		System.out.println(BONUS_BALL_MESSAGE);
		return sc.nextLine();
	}

	public static String reInputIfInvalidBonusBall() {
		System.out.println(ERROR_BONUS_BALL_MESSAGE);
		return sc.nextLine();
	}

	private static void nextLine() {
		System.out.println();
	}

	public static String input() {
		return sc.nextLine();
	}
}
