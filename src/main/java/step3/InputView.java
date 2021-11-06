package step3;

import java.util.Scanner;

public class InputView {

	private static final String COMMA = "([\\w\\d].+)+([^\\w,]).+";
	private static final String LAST_NOT_COMMA = ",$";
	private static final String ONLY_NUMBER = "((?:^|,)([0-9]+))+";
	private static final String NUMBER_SIZE_SIX = "((?:^|,)([0-9]{1,2})){6}";


	public static int insertMoney() {
		try {
			return Integer.parseInt(input());
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("숫자를 입력해야합니다.");
		}
	}

	public static String insertWinningNumber() {
		try{
			String input = input();
			validationInputWinningNumber(input);
			return input;
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
		throw new IllegalArgumentException("[ERROR] 잘못된 값을 입력했습니다.");
	}

	private static void validationInputWinningNumber(String input) {
		if (PattenUtils.findString(LAST_NOT_COMMA, input)) {
			throw new IllegalArgumentException("[ERROR] ,를 마지막에 입력하면 안됩니다.");
		}

		if (PattenUtils.findString(COMMA, input)) {
			throw new IllegalArgumentException("[ERROR] 숫자는 ,구분해서 입력해야합니다.");
		}

		if (!PattenUtils.findString(ONLY_NUMBER,input)) {
			throw new IllegalArgumentException("[ERROR] 정수만을 입력해야합니다.");
		}

		if (!PattenUtils.findString(NUMBER_SIZE_SIX,input)) {
			throw new IllegalArgumentException("[ERROR] 숫자는 6개를 입력해야합니다.");
		}
	}

	private static String input() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}
}
