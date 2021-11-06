package step3;

import java.util.Scanner;

public class InputView {

	private static final String COMMA = "([\\w\\d].+)+([^\\w,]).+";
	private static final String LAST_COMMA = "([0-9],){1,}";
	private static final String ONLY_NUMBER = "((?:^|,)([0-9]+))+";
	private static final String NUMBER_SIZE_SIX = "((?:^|,)([0-9]{1,2})){6}";

	private LottoMachineFacade lottoMachineFacade;

	public InputView(LottoMachineFacade lottoMachineFacade) {
		this.lottoMachineFacade = lottoMachineFacade;
	}

	public void insertMoney() {
		try {
			System.out.println("구입금액을 입력해 주세요.");
			lottoMachineFacade.pick(Integer.parseInt(input()));
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			insertMoney();
		}
	}

	public void insertLottoNumber() {
		try {
			System.out.println("지난 주 당첨 번호를 입력해 주세요.");
			String inputLottoNumber = input();
			validationInputWinningNumber(inputLottoNumber);
			lottoMachineFacade.result(inputLottoNumber);
		} catch (IllegalArgumentException ex) {
			System.out.println(ex.getMessage());
			insertLottoNumber();
		}
	}

	private static void validationInputWinningNumber(String input) {
		if (PattenUtils.findString(LAST_COMMA, input)) {
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
