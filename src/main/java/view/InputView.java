package view;

import java.util.Scanner;

import model.LottoPurchaseCount;
import model.Lottos;

public class InputView {
	private static final String MESSAGE_REQUEST_INPUT_OF_PURCHASE_PRICE = "구입금액을 입력해 주세요.";
	private static final String MESSAGE_REQUEST_EXCEPTION_INPUT_OF_PURCHASE_PRICE = "잘못된 형식의 구매금액입니다.";
	private static final String MESSAGE_REQUEST_INPUT_OF_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
	private static final String MESSAGE_REQUEST_EXCEPTION_INPUT_OF_WINNING_NUMBERS = "잘못된 형식의 당첨 번호입니다.";
	private static final String MESSAGE_REQUEST_INPUT_OF_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";
	private static final String MESSAGE_REQUEST_EXCEPTION_INPUT_OF_BONUS_NUMBER = "잘못된 형식의 보너스 볼입니다.";
	private static final String MESSAGE_REQUEST_INPUT_OF_MANUAL_LOTTO_PURCHASE_COUNT = "수동으로 구매할 로또 수를 입력해 주세요.";
	private static final String MESSAGE_REQUEST_EXCEPTION_INPUT_OF_MANUAL_LOTTO_PURCHASE_COUNT = "잘못된 형식의 구매 로또 수량입니다.";
	private static final String MESSAGE_REQUEST_EXCEPTION_TOTAL_PURCHASE_COUNT_LESS_THAN_MANUAL = "수동 구매 로또의 수가 최대 로또 수보다 큽니다.";
	private static final String MESSAGE_FORMAT_INPUT_OF_PURCHASE_LOTTO_COUNT_TITLE = "수동으로 %d장, 자동으로 %d장 구매했습니다.%n";

	public static void showRequestInputOfPurchasePrice() {
		System.out.println(MESSAGE_REQUEST_INPUT_OF_PURCHASE_PRICE);
	}

	public static void showRequestInputOfManualLottoPurchaseCount() {
		System.out.println(MESSAGE_REQUEST_INPUT_OF_MANUAL_LOTTO_PURCHASE_COUNT);
	}

	public static void showRequestInputExceptionOfPurchasedPrice() {
		System.out.println(MESSAGE_REQUEST_EXCEPTION_INPUT_OF_PURCHASE_PRICE);
	}

	public static void showRequestInputOfWinningNumbers() {
		System.out.println(MESSAGE_REQUEST_INPUT_OF_WINNING_NUMBERS);
	}

	public static void showRequestInputExceptionOfWinningNumbers() {
		System.out.println(MESSAGE_REQUEST_EXCEPTION_INPUT_OF_WINNING_NUMBERS);
	}

	public static void showRequestInputOfBonusNumber() {
		System.out.println(MESSAGE_REQUEST_INPUT_OF_BONUS_NUMBER);
	}

	public static void showRequestInputExceptionOfBonusNumber() {
		System.out.println(MESSAGE_REQUEST_EXCEPTION_INPUT_OF_BONUS_NUMBER);
	}

	public static void showResponseInputOfPurchaseLottosTitle(LottoPurchaseCount manualPurchaseCount,
		LottoPurchaseCount autoPurchaseCount) {
		System.out.printf(MESSAGE_FORMAT_INPUT_OF_PURCHASE_LOTTO_COUNT_TITLE, manualPurchaseCount.get(), autoPurchaseCount.get());
	}

	public static void showResponseInputOfPurchaseLottos(Lottos lottos) {
		System.out.println(lottos.toString());
	}

	public static String pollInput() {
		return new Scanner(System.in).nextLine();
	}

	public static void showRequestInputExceptionOfManualLottoPurchaseCount() {
		System.out.println(MESSAGE_REQUEST_EXCEPTION_INPUT_OF_MANUAL_LOTTO_PURCHASE_COUNT);
	}

	public static void showRequestInputExceptionOfTotalPurchaseCountLessThanManual() {
		System.out.println(MESSAGE_REQUEST_EXCEPTION_TOTAL_PURCHASE_COUNT_LESS_THAN_MANUAL);
	}
}
