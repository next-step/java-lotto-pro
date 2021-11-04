package edu.lotto.automatic.controller;

import edu.lotto.automatic.constants.MessageConstants;
import edu.lotto.automatic.utils.NumberUtil;

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
		logger.info("사용자가 입력한 구매 금액 : " + perchaseAmount);
		logger.info("구매한 로또 갯수 : " + NumberUtil.getLottoCount(perchaseAmount));
		logger.info("1~45 사이의 숫자 6개 : " + getSixRandomNumber().toString());
	}

	/**
	 * 사용자가 입력한 구매 금액 가져오기
	 *
	 * @return
	 */
	public static String getPerchaseAmount() {
		System.out.println(MessageConstants.INPUT_PERCHASE_AMOUNT_MESSAGE);
		Scanner scan = new Scanner(System.in);
		String amount = scan.next();
		if (!NumberUtil.checkPerchaseAmountValidation(amount)) {
			amount = getPerchaseAmount();
		}
		return amount;
	}

	/**
	 * 1~45 사이의 임의의 숫자 6개 가져오기
	 *
	 * @return
	 */
	public static List<Integer> getSixRandomNumber() {
		List<Integer> sixRandomNumbers = new ArrayList<Integer>();
		while (sixRandomNumbers.size() < 6) {
			sixRandomNumbers.add(NumberUtil.getNumberBetweenOneAndFortyFive());
		}
		return sixRandomNumbers;
	}

}
