package edu.lotto.utils;

import edu.lotto.constants.MessageConstants;
import edu.lotto.constants.PatternConstants;

import java.util.regex.Pattern;

/**
 * 숫자 검증 및 관련 Util
 * @since 2021.11.03
 * @author Inmook,Jeong
 */
public class NumberUtil {

	private static final int THOUSAND = 1_000;

	// Instance화를 막기 위한 private 생성자 선언
	private NumberUtil() {}

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

}
