package step3.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import step3.view.exception.CommaSeparatedNumbersException;
import step3.view.exception.EnterNumberIsOnlyIntegerException;
import step3.view.exception.EnterNumberIsRangeSixException;
import step3.view.exception.LastCommaException;
import step3.view.exception.ViewException;

public class RequestView implements InputView {

	private static final Pattern COMMA = Pattern.compile("([\\w\\d].+)+([^\\w,]).+");
	private static final Pattern LAST_COMMA = Pattern.compile("/,\\s*$/");
	private static final Pattern ONLY_NUMBER = Pattern.compile("((?:^|,)([0-9]+))+");
	private static final Pattern NUMBER_SIZE_SIX = Pattern.compile("((?:^|,)([0-9]{1,2})){6}");

	private static final String ENTER_MONEY = "구입금액을 입력해 주세요.";
	public static final String ENTER_MANUAL_COUNT = "수동으로 구매할 번호를 입력해 주세요.";
	public static final String ENTER_MANUAL_LOTTO_NUMBERS = "수동으로 구매할 로또 수를 입력해 주세요.";
	private static final String ENTER_BONUS_BALL = "보너스 볼을 입력해 주세요";
	private static final String ENTER_LAST_WEEK_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";

	public int insertMoney() {
		int insertMoney = 0;
		try {
			System.out.println(ENTER_MONEY);
			return Integer.parseInt(input());
		} catch (IllegalArgumentException e) {
			insertMoney();
		}
		return insertMoney;
	}

	@Override
	public int insertManualCount() {
		int manualCount = 0;
		try {
			System.out.println(ENTER_MANUAL_LOTTO_NUMBERS);
			return Integer.parseInt(input());
		} catch (IllegalArgumentException e) {
			insertMoney();
		}
		return manualCount;
	}

	public List<String> insertManualLottoNumbers(int manualCount) {
		List list = Collections.emptyList();
		try {
			System.out.println(ENTER_MANUAL_COUNT);
			list = inputManuals(manualCount);
			return list;
		} catch (ViewException e) {
			System.out.println(e.getMessage());
			insertManualLottoNumbers(manualCount);
		}
		return list;
	}

	private List<String> inputManuals(int manualCount) {
		List<String> list = new ArrayList<>();
		for (int i = 0; i < manualCount; i++) {
			list.add(input());
		}
		return list;
	}

	public int insertBonusBall() {
		int insertBonusBall = 0;
		try {
			System.out.println(ENTER_BONUS_BALL);
			return Integer.parseInt(input());
		} catch (ViewException e) {
			System.out.println(e.getMessage());
			insertBonusBall();
		}
		return insertBonusBall;
	}

	public String insertLottoNumber() {
		String insertLottoNumber = "";
		try {
			System.out.println(ENTER_LAST_WEEK_WINNING_NUMBERS);
			insertLottoNumber = input();
			validationInputWinningNumber(insertLottoNumber);
			return insertLottoNumber;
		} catch (ViewException ex) {
			System.out.println(ex.getMessage());
			insertLottoNumber();
		}
		return insertLottoNumber;
	}

	private static void validationInputWinningNumber(String input) {
		if (isMatch(LAST_COMMA, input)) {
			throw new LastCommaException();
		}

		if (isMatch(COMMA, input)) {
			throw new CommaSeparatedNumbersException();
		}

		if (!isMatch(ONLY_NUMBER, input)) {
			throw new EnterNumberIsOnlyIntegerException();
		}

		if (!isMatch(NUMBER_SIZE_SIX, input)) {
			throw new EnterNumberIsRangeSixException();
		}
	}

	private static boolean isMatch(Pattern pattern, String input) {
		return pattern.matcher(input).find();
	}

	private String input() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}
}
