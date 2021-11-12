package lotto.console;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lotto.domain.LottoNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoShop;
import lotto.domain.Lottos;
import lotto.domain.Money;

public class InputView {
	private static final String ENTER_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
	private static final String ENTER_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
	private static final String ENTER_BONUS_BALL_NUMBER = "보너스 볼을 입력해 주세요.";
	private static final String ENTER_MANUAL_LOTTO_PURCHASE_QUANTITY = "수동으로 구매할 로또 수를 입력해 주세요.";
	private static final String ERROR_PURCHASE_AMOUNT_TYPE = "[ERROR] 구매금액은 숫자만 입력가능합니다.";
	private static final String ERROR_PURCHASE_AMOUNT = "[ERROR] 구매금액은 최소 1000원 이상입니다.";
	private static final String ERROR_LOTTO_NUMBER_FORMAT = "[ERROR] 로또 번호는 (, )를 구분자로 6자리의 숫자만 입력 가능합니다. \n[예시] 1, 2, 3, 4, 5, 6";
	private static final String ERROR_DUPLICATE_BONUS_NUMBER = "[ERROR] 당첨 번호랑 보너스 번호는 중복 될 수 없습니다.";
	private static final String ERROR_PURCHASE_QUANTITY_BOUNDARY = "[ERROR] 구매금액보다 많이 구매할 수 없습니다.";
	private static final String ERROR_PURCHASE_QUANTITY_VALUE = "[ERROR] 숫자만 입력 가능합니다.";
	private static final String DELIMITER = ", ";

	private static final Scanner scanner = new Scanner(System.in);
	public static final String ENTER_MANUAL_LOTTO_NUMBER = "수동으로 구매할 번호를 입력해 주세요.";

	public static Money enterPurchaseAmount() {
		OutputView.printMessage(ENTER_PURCHASE_AMOUNT);
		return new Money(validatePurchaseAmount(scanner.nextLine()));
	}

	private static int validatePurchaseAmount(String purchaseAmount) {
		try {
			return validatePurchaseAmount(stringValueToIntValue(purchaseAmount));
		} catch (IllegalArgumentException exception) {
			OutputView.printMessage(exception.getMessage());
			return 0;
		}
	}

	private static int stringValueToIntValue(String purchaseAmount) {
		try {
			return Integer.parseInt(purchaseAmount);
		} catch (NumberFormatException exception) {
			throw new IllegalArgumentException(ERROR_PURCHASE_AMOUNT_TYPE);
		}
	}

	private static int validatePurchaseAmount(int purchaseAmount) {
		if (LottoShop.LOTTO_PRICE.isLess(purchaseAmount)) {
			throw new IllegalArgumentException(ERROR_PURCHASE_AMOUNT);
		}
		return purchaseAmount;
	}

	public static String enterWinningNumbers() {
		OutputView.printMessage(ENTER_WINNING_NUMBERS);
		return validateStringLottoNumbersLength(scanner.nextLine());
	}

	private static String validateStringLottoNumbersLength(String lottoNumbers) {
		try {
			String[] stringNumberArray = lottoNumbers.split(DELIMITER);
			validateStringLottoNumbersLength(stringNumberArray);
			validateStringArrayToInt(stringNumberArray);
			return lottoNumbers;
		} catch (IllegalArgumentException exception) {
			OutputView.printMessage(exception.getMessage());
			return "";
		}
	}

	private static void validateStringLottoNumbersLength(String[] stringNumberArray) {
		if (stringNumberArray.length != Lotto.MAX_RANGE_VALUE) {
			throw new IllegalArgumentException(ERROR_LOTTO_NUMBER_FORMAT);
		}
	}

	private static void validateStringArrayToInt(String[] stringNumberArray) {
		Arrays.stream(stringNumberArray).forEach(LottoNumber::new);
	}

	public static int enterBonusBallNumber(String winningNumbers) {
		OutputView.printMessage(ENTER_BONUS_BALL_NUMBER);
		String bonusNumber = scanner.nextLine();
		try {
			validateStringBonusBallNumber(bonusNumber);
			return validateDuplicateNumbers(bonusNumber, winningNumbers);
		} catch (IllegalArgumentException exception) {
			OutputView.printMessage(exception.getMessage());
			return -1;
		}
	}

	private static int validateDuplicateNumbers(String bonusNumber, String winningNumbers) {
		for (String winningNumber : winningNumbers.split(DELIMITER)) {
			ifSameNumberException(winningNumber, bonusNumber);
		}
		return Integer.parseInt(bonusNumber);
	}

	private static void ifSameNumberException(String winningNumber, String bonusNumber) {
		if (winningNumber.equals(bonusNumber)) {
			throw new IllegalArgumentException(ERROR_DUPLICATE_BONUS_NUMBER);
		}
	}

	private static void validateStringBonusBallNumber(String bonusBallNumber) {
		new LottoNumber(bonusBallNumber);
	}

	public static Money enterManualLottoPurchaseQuantity(Money purchaseAmount) {
		OutputView.printMessage(ENTER_MANUAL_LOTTO_PURCHASE_QUANTITY);
		try {
			int inputQuantity = validatePurchaseQuantityValue(scanner.nextLine());
			return validatePurchaseQuantityBoundary(purchaseAmount, inputQuantity);
		} catch (IllegalArgumentException exception) {
			OutputView.printMessage(exception.getMessage());
		}
		return new Money(0);
	}

	private static Money validatePurchaseQuantityBoundary(Money purchaseAmount, int inputQuantity) {
		Money inputPurchaseAmount = LottoShop.LOTTO_PRICE.getPurchaseAmount(inputQuantity);
		if (purchaseAmount.isGreater(inputPurchaseAmount)) {
			throw new IllegalArgumentException(ERROR_PURCHASE_QUANTITY_BOUNDARY);
		}
		return inputPurchaseAmount;
	}

	private static int validatePurchaseQuantityValue(String quantity) {
		try {
			return Integer.parseInt(quantity);
		} catch (NumberFormatException exception) {
			throw new IllegalArgumentException(ERROR_PURCHASE_QUANTITY_VALUE);
		}
	}

	public static Lotto enterManualLottoNumbersBody() {

		Repeater.init();
		Lotto manualLottoNumber = null;
		while (Repeater.isContinue()) {
			manualLottoNumber = validateStringManualLottoNumbersLength(scanner.nextLine());
			Repeater.set(manualLottoNumber);
		}
		return manualLottoNumber;
	}

	private static Lotto validateStringManualLottoNumbersLength(String lottoNumbers) {
		try {
			String[] stringNumberArray = lottoNumbers.split(DELIMITER);
			validateStringLottoNumbersLength(stringNumberArray);
			validateStringArrayToInt(stringNumberArray);
			return new Lotto(lottoNumbers);
		} catch (IllegalArgumentException exception) {
			OutputView.printMessage(exception.getMessage());
			return null;
		}
	}

	public static void enterManualLottoNumbersHeader() {
		OutputView.printMessage(ENTER_MANUAL_LOTTO_NUMBER);
	}
}
