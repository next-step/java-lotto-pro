package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

	private static final Scanner sc = new Scanner(System.in);

	public static int getMoney() {
		System.out.println("구입금액을 입력해 주세요.");
		String input = sc.nextLine();
		return Integer.parseInt(input);
	}

	public static List<Integer> getLottoNumbers() {
		System.out.println("지난 주 당첨 번호를 입력해 주세요.");
		String line = sc.nextLine();
		String[] str = line.split(",");
		List<Integer> numbers = new ArrayList<>();
		for (String s : str) {
			numbers.add(Integer.parseInt(s));
		}
		return numbers;
	}

	public static int getBonusNumber() {
		System.out.println("보너스 볼을 입력해 주세요.");
		String line = sc.nextLine();
		return Integer.parseInt(line);
	}

}
