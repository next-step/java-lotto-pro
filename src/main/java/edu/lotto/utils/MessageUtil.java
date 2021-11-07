package edu.lotto.utils;

import java.util.logging.Logger;

/**
 * Message를 출력하는 Util
 * @since 2021.11.07
 * @author Inmook,Jeong
 */
public class MessageUtil {

	private static Logger logger = Logger.getLogger(MessageUtil.class.getName());


	private MessageUtil() {}

	/**
	 * 메시지 표준출력
	 * @param message
	 */
	public static void printMessage(String message) {
		System.out.println(message);
	}

	/**
	 * 메시지 표준출력
	 * @param message
	 * @param ratio
	 */
	public static void printMessage(String message, String ratio) {
		System.out.printf(message, ratio);
	}

	/**
	 * Info Level의 로그 출력
	 * @param message
	 */
	public static void printInfoLog(String message) {
		logger.info(message);
	}

	/**
	 * Error Level의 로그 출력
	 * @param message
	 */
	public static void printErrorLog(String message) {
		logger.severe(message);
	}

	public static void printSeparatorLine() {
		System.out.println("---------");
	}

}
