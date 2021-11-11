package edu.lotto.controller;

import edu.lotto.constants.MessageConstants;
import edu.lotto.constants.PatternConstants;
import edu.lotto.model.Lotto;
import edu.lotto.model.LottoNumber;
import edu.lotto.model.Lottos;
import edu.lotto.utils.MessageUtil;
import edu.lotto.utils.NumberUtil;

import java.util.*;
import java.util.logging.Logger;

/**
 * 로또(자동)
 * @since 2021.11.03
 * @author Inmook,Jeong
 */
public class AutomaticLotto {

	private static Logger logger = Logger.getLogger(AutomaticLotto.class.getName());
	private static final String NEW_LINE = "\n";

	public static void main(String[] args) {
		int perchaseAmount = Integer.parseInt(getPerchaseAmount());
		int perchaseLottoCount = getLottoCount(perchaseAmount);
		int manualCount = getManualLottoCount(perchaseLottoCount);
		List<String> manualLottoNumbers = getManualLottoNumbers(manualCount);
		Lottos lottos = new Lottos(perchaseAmount, perchaseLottoCount, manualLottoNumbers);
		List<LottoNumber> winningNumbers = getLatestWinningNumbers();
		int bonusBall = getBonusBall(winningNumbers);
		lottos.printResult(winningNumbers, bonusBall);
	}

	/**
	 * 사용자가 입력한 구매 금액 가져오기
	 * @return
	 */
	public static String getPerchaseAmount() {
		MessageUtil.printMessage(NEW_LINE + MessageConstants.INPUT_PERCHASE_AMOUNT_MESSAGE);
		Scanner scan = new Scanner(System.in);
		String amount = scan.next();
		if (!checkPerchaseAmountValidation(amount)) {
			amount = getPerchaseAmount();
		}
		return amount;
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
	 * 사용자가 입력한 구매 금액이 숫자이고, 1000 이상의 숫자인지 확인
	 * @param amount
	 * @return
	 */
	public static boolean checkPerchaseAmountValidation(String amount) {
		if(!NumberUtil.isNumber(amount)) {
			MessageUtil.printMessage(MessageConstants.ONLY_INPUT_NUMBER_MESSAGE);
			return false;
		}
		if(!NumberUtil.isMoreThanThousand(Integer.parseInt(amount))) {
			MessageUtil.printMessage(MessageConstants.LOTTO_PRICE_INFORMATION_MESSAGE);
			return false;
		}
		return true;
	}

	/**
	 * 수동으로 구매할 로또 갯수 입력받기
	 * @param perchaseLottoCount
	 * @return
	 */
	public static int getManualLottoCount(int perchaseLottoCount) {
		int manualCount = 0;
		do {
			MessageUtil.printMessage(NEW_LINE + MessageConstants.INPUT_PERCHASE_MANUAL_COUNT_MESSAGE);
			manualCount = inputUserNumber();
		} while (!isValidManualCount(manualCount, perchaseLottoCount));
		return manualCount;
	}

	public static List<String> getManualLottoNumbers(int manualCount) {
		List<String> manualNumbers = new ArrayList<String>();
		MessageUtil.printMessage(NEW_LINE + MessageConstants.INPUT_PERCHASE_MANUAL_NUMBER_MESSAGE);
		do {
			manualNumbers.add(addManualLottoNumber());
		} while (manualNumbers.size() < manualCount);
		return manualNumbers;
	}

	public static String addManualLottoNumber() {
		String inputManualNumber = "";
		Scanner scan = new Scanner(System.in);
		inputManualNumber = scan.nextLine().replaceAll(" ", "");
		if(!checkInputWinningNumbersValidation(inputManualNumber)) {
			MessageUtil.printMessage(MessageConstants.INPUT_NUMBER_NOT_SIX_COUNT_OR_DUPLICATE_ERROR_MESSAGE);
			inputManualNumber = addManualLottoNumber();
		}
		return inputManualNumber;
	}

	/**
	 * 수동으로 구매할 로또 수 검증
	 * @param manualCount
	 * @param perchaseLottoCount
	 * @return
	 */
	private static boolean isValidManualCount(int manualCount, int perchaseLottoCount) {
		return (manualCount >= 0) && (manualCount <= perchaseLottoCount);
	}

	/**
	 * 사용자 입력을 통해 가져온 지난주 정답을 숫자 리스트 형태로 변환하여 가져오기
	 * @return 정답이 저장된 숫자 배열
	 */
	public static List<LottoNumber> getLatestWinningNumbers() {
		List<LottoNumber> winningNumbers = new ArrayList<LottoNumber>();
		String[] winningNumbersString = getLatestWinningNumbersByUserInput().split(PatternConstants.DEFAULT_SEPARATOR_PATTERN);
		for(String winningNumberString : winningNumbersString) {
			winningNumbers.add(new LottoNumber(Integer.parseInt(winningNumberString)));
		}
		return winningNumbers;
	}

	/**
	 * 사용자 입력을 통해 지난 주 정답 가져오기
	 * @return
	 */
	public static String getLatestWinningNumbersByUserInput() {
		MessageUtil.printMessage(NEW_LINE + MessageConstants.INPUT_LATEST_WINNING_NUMBERS_MESSAGE);
		Scanner scan = new Scanner(System.in);
		String winningNumbers = scan.nextLine().replaceAll(" ", "");
		if (!checkInputWinningNumbersValidation(winningNumbers)) {
			MessageUtil.printMessage(MessageConstants.LATEST_WINNING_NUMBERS_ERROR_MESSAGE);
			winningNumbers = getLatestWinningNumbersByUserInput();
		}
		return winningNumbers;
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
			isValidWinningNumbers = ((winningNumberArray.length == 6)
										&& hasNotDuplicateNumber(winningNumbers)
										&& NumberUtil.isNumber(winningNumber)
										&& NumberUtil.isNumberBetweenOneAndFortyFive(Integer.parseInt(winningNumber)));
			currentWinningNumberIndex++;
		}
		return isValidWinningNumbers;
	}

	/**
	 * 중복된 값이 있는지 확인
	 * @param value
	 * @return
	 */
	public static boolean hasNotDuplicateNumber(String value) {
		String[] values = value.split(PatternConstants.DEFAULT_SEPARATOR_PATTERN);
		List<String> valueList = Arrays.asList(values);
		if(valueList.size() != valueList.stream().distinct().count()) {
			return false;
		}
		return true;
	}

	/**
	 * 사용자 입력을 통해 2등 보너스볼 숫자 가져오기
	 * @return
	 */
	public static int getBonusBall(List<LottoNumber> winningNumbers) {
		int bonusBall = 0;
		do {
			MessageUtil.printMessage(MessageConstants.INPUT_SECON_WINNING_NUMBER_MESSAGE);
			bonusBall = inputUserNumber();
		} while (!isValidBonusNumber(bonusBall, winningNumbers));
		return bonusBall;
	}

	/**
	 * 2등 보너스 숫자 검증
	 * @param bonusNumber
	 * @param winningNumbers
	 * @return
	 */
	private static boolean isValidBonusNumber(int bonusNumber, List<LottoNumber> winningNumbers) {
		if(NumberUtil.isNumber(String.valueOf(bonusNumber))
			&& NumberUtil.isNumberBetweenOneAndFortyFive(bonusNumber)
			&& !(new LottoNumber(bonusNumber).containLottoNumber(winningNumbers))) {
			return true;
		}
		MessageUtil.printMessage(MessageConstants.INPUT_SECON_WINNING_NUMBER_ERROR_MESSAGE);
		return false;
	}

	/**
	 * 사용자가 숫자를 잘못 입력한 경우 예외 처리
	 * @return
	 */
	private static int inputUserNumber() {
		int number = 0;
		Scanner scan = new Scanner(System.in);
		try {
			number = scan.nextInt();
		} catch (Exception e) {
			MessageUtil.printMessage(MessageConstants.ONLY_INPUT_NUMBER_MESSAGE);
			number = inputUserNumber();
		}
		return number;
	}
}
