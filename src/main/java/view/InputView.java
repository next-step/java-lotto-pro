package view;

import java.util.Scanner;

import model.Lottos;

public class InputView {
	private static final String MESSAGE_REQUEST_INPUT_OF_PURCHASE_PRICE = "구입금액을 입력해 주세요.";
	private static final String MESSAGE_REQUEST_EXCEPTION_INPUT_OF_PURCHASE_PRICE = "잘못된 형식의 구매금액입니다.";
	private static final String MESSAGE_REQUEST_INPUT_OF_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
	private static final String MESSAGE_REQUEST_EXCEPTION_INPUT_OF_WINNING_NUMBERS = "잘못된 형식의 당첨 번호입니다.";
	private static final String MESSAGE_REQUEST_INPUT_OF_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";
	private static final String MESSAGE_REQUEST_EXCEPTION_INPUT_OF_BONUS_NUMBER = "잘못된 형식의 보너스 볼입니다.";

	public void showRequestInputOfPurchasePrice() {
		System.out.println(MESSAGE_REQUEST_INPUT_OF_PURCHASE_PRICE);
	}

	public void showRequestInputExceptionOfPurchasedPrice() {
		System.out.println(MESSAGE_REQUEST_EXCEPTION_INPUT_OF_PURCHASE_PRICE);
	}

	public void showRequestInputOfWinningNumbers() {
		System.out.println(MESSAGE_REQUEST_INPUT_OF_WINNING_NUMBERS);
	}

	public void showRequestInputExceptionOfWinningNumbers() {
		System.out.println(MESSAGE_REQUEST_EXCEPTION_INPUT_OF_WINNING_NUMBERS);
	}

	public void showRequestInputOfBonusNumber() {
		System.out.println(MESSAGE_REQUEST_INPUT_OF_BONUS_NUMBER);
	}

	public void showRequestInputExceptionOfBonusNumber() {
		System.out.println(MESSAGE_REQUEST_EXCEPTION_INPUT_OF_BONUS_NUMBER);
	}

	public void showResponseInputOfPurchaseLottos(Lottos lottos) {
		System.out.println(lottos.toString());
	}

	public String pollInput() {
		return new Scanner(System.in).nextLine();
	}
}
