package edu.lotto.automatic.utils;

import edu.lotto.automatic.constants.MessageConstants;
import edu.lotto.automatic.constants.PatternConstants;

import java.util.regex.Pattern;

/**
 * 숫자 검증 및 관련 Util
 * @since 2021.11.03
 * @author Inmook,Jeong
 */
public class NumberUtil {

	private static final int THOUSAND = 1000;

	/**
	 * 숫자 형식의 문자열인지 확인
	 * @param value
	 * @return
	 */
	public static boolean isNumber(String value) {
		return Pattern.matches(PatternConstants.NUMBER_PATTERN, value);
	}

	/**
	 * 1000 이상의 숫자인지 확인
	 * @param value
	 * @return
	 */
	public static boolean isMoreThanThousand(int value) {
		return (value >= THOUSAND);
	}

	/**
	 * 사용자가 입력한 구매 금액이 숫자이고, 1000 이상의 숫자인지 확인
	 * @param amount
	 * @return
	 */
	public static boolean checkPerchaseAmountValidation(String amount) {
		boolean validPerchaseAmount = true;
		if(!NumberUtil.isNumber(amount)) {
			validPerchaseAmount = false;
			System.out.println(MessageConstants.ONLY_INPUT_NUMBER_MESSAGE);
		}
		if(!NumberUtil.isMoreThanThousand(Integer.parseInt(amount))) {
			validPerchaseAmount = false;
			System.out.println(MessageConstants.LOTTO_PRICE_INFORMATION_MESSAGE);
		}
		return validPerchaseAmount;
	}

	/**
	 * 구매 금액을 통해 구매된 로또 갯수 가져오기
	 * @param perchaseAmount
	 * @return
	 */
	public static int getLottoCount(int perchaseAmount) {
		return (perchaseAmount / 1000);
	}

	/**
	 * 1에서 45 사이의 숫자 가져오기
	 * @return
	 */
	public static int getNumberBetweenOneAndFortyFive() {
		return (int) ((Math.random() * 45) + 1);
	}

	/**
	 * 사용자가 입력한 지난주 정답이 숫자 형태의 문자열인지 확인
	 * @param winningNumbers
	 * @return
	 */
	public static boolean checkInputWinningNumbersValidation(String winningNumbers) {
		boolean isValidWinningNumbers = true;
		String[] winningNumberArray = winningNumbers.split(PatternConstants.DEFAULT_SEPARATOR_PATTERN);
		int currentWinningNumberIndex = 0;
		while(isValidWinningNumbers && currentWinningNumberIndex < winningNumberArray.length) {
			String winningNumber = winningNumberArray[currentWinningNumberIndex];
			isValidWinningNumbers = ((winningNumberArray.length == 6) && isNumber(winningNumber) && isNumberBetweenOneAndFortyFive(Integer.parseInt(winningNumber)));
			currentWinningNumberIndex++;
		}
		return isValidWinningNumbers;
	}

	/**
	 * 숫자가 1~45 사이의 숫자인지 확인
	 * @param value
	 * @return
	 */
	public static boolean isNumberBetweenOneAndFortyFive(int value) {
		return ((value >= 1) && (value <= 45));
	}
}
