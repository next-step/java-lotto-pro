package edu.lotto.controller;

import edu.lotto.constants.MessageConstants;
import edu.lotto.constants.PatternConstants;
import edu.lotto.model.Lottos;
import edu.lotto.utils.MessageUtil;
import edu.lotto.utils.NumberUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 * 로또(자동)
 * @since 2021.11.03
 * @author Inmook,Jeong
 */
public class AutomaticLotto {

	private static Logger logger = Logger.getLogger(AutomaticLotto.class.getName());

	public static void main(String[] args) {
		int perchaseAmount = Integer.parseInt(getPerchaseAmount());
		Lottos lottos = new Lottos(perchaseAmount);
		List<Integer> winningNumbers = getLatestWinningNumbers();
		int secondWinningNumber =getSecondWinningNumber();
		MessageUtil.printInfoLog("2등 보너스 볼 : "+ secondWinningNumber);
		lottos.setWinningNumberMatchesCount(winningNumbers);
		lottos.printLottoMatchesCountStatistics();
	}

	/**
	 * 사용자가 입력한 구매 금액 가져오기
	 * @return
	 */
	public static String getPerchaseAmount() {
		MessageUtil.printMessage(MessageConstants.INPUT_PERCHASE_AMOUNT_MESSAGE);
		Scanner scan = new Scanner(System.in);
		String amount = scan.next();
		if (!Lottos.checkPerchaseAmountValidation(amount)) {
			amount = getPerchaseAmount();
		}
		return amount;
	}

	/**
	 * 사용자 입력을 통해 가져온 지난주 정답을 숫자 리스트 형태로 변환하여 가져오기
	 * @return 정답이 저장된 숫자 배열
	 */
	public static List<Integer> getLatestWinningNumbers() {
		List<Integer> winningNumbers = new ArrayList<Integer>();
		String[] winningNumbersString = getLatestWinningNumbersByUserInput().split(PatternConstants.DEFAULT_SEPARATOR_PATTERN);
		for(String winningNumberString : winningNumbersString) {
			winningNumbers.add(Integer.parseInt(winningNumberString));
		}
		return winningNumbers;
	}

	/**
	 * 사용자 입력을 통해 지난 주 정답 가져오기
	 * @return
	 */
	public static String getLatestWinningNumbersByUserInput() {
		MessageUtil.printMessage("\n"+MessageConstants.INPUT_LATEST_WINNING_NUMBERS_MESSAGE);
		Scanner scan = new Scanner(System.in);
		String winningNumbers = scan.next().trim();
		if (!Lottos.checkInputWinningNumbersValidation(winningNumbers)) {
			MessageUtil.printMessage(MessageConstants.LATEST_WINNING_NUMBERS_ERROR_MESSAGE);
			winningNumbers = getLatestWinningNumbersByUserInput();
		}
		return winningNumbers;
	}

	public static int getSecondWinningNumber() {
		int secondWinningNumber = 0;
		MessageUtil.printMessage(MessageConstants.INPUT_SECON_WINNING_NUMBER_MESSAGE);
		Scanner scan = new Scanner(System.in);
		secondWinningNumber = scan.nextInt();
		if(!NumberUtil.isNumber(String.valueOf(secondWinningNumber)) || !NumberUtil.isNumberBetweenOneAndFortyFive(secondWinningNumber)) {
			secondWinningNumber = getSecondWinningNumber();
		}
		return secondWinningNumber;
	}
}
