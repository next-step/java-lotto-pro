package step3.view;

import java.util.Scanner;

import step3.PattenUtils;

public class RequestView implements InputView {

	private static final String COMMA = "([\\w\\d].+)+([^\\w,]).+";
	private static final String LAST_COMMA = "([0-9],){1,}";
	private static final String ONLY_NUMBER = "((?:^|,)([0-9]+))+";
	private static final String NUMBER_SIZE_SIX = "((?:^|,)([0-9]{1,2})){6}";

	public int insertMoney() {
		int insertMoney = 0;
		try {
			System.out.println("구입금액을 입력해 주세요.");
			insertMoney = Integer.parseInt(input());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			insertMoney();
		}
		return insertMoney;
	}

	public String insertLottoNumber() {
		String insertLottoNumber = "";
		try {
			System.out.println("지난 주 당첨 번호를 입력해 주세요.");
			insertLottoNumber = input();
			validationInputWinningNumber(insertLottoNumber);
		} catch (IllegalArgumentException ex) {
			System.out.println(ex.getMessage());
			insertLottoNumber();
		}
		return insertLottoNumber;
	}

	private static void validationInputWinningNumber(String input) {
		if (PattenUtils.match(LAST_COMMA, input)) {
			throw new IllegalArgumentException("[ERROR] ,를 마지막에 입력하면 안됩니다.");
		}

		if (PattenUtils.match(COMMA, input)) {
			throw new IllegalArgumentException("[ERROR] 숫자는 ,구분해서 입력해야합니다.");
		}

		if (!PattenUtils.match(ONLY_NUMBER,input)) {
			throw new IllegalArgumentException("[ERROR] 정수만을 입력해야합니다.");
		}

		if (!PattenUtils.match(NUMBER_SIZE_SIX,input)) {
			throw new IllegalArgumentException("[ERROR] 숫자는 6개를 입력해야합니다.");
		}
	}

	private static String input() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}
}
