package lotto2.view;

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

	public static List<Integer> getWinningLottoNumbers() {
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

	public static int getManualLottoCount() {
		System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
		String line = sc.nextLine();
		return Integer.parseInt(line);
	}

	public static List<List<Integer>> getManualLotto(int count) {
		System.out.println("수동으로 구매할 번호를 입력해 주세요.");
		List<List<Integer>> list = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			list.add(parseLottoNumber(sc.nextLine()));
		}
		return list;
	}

	private static List<Integer> parseLottoNumber(String line) {
		String[] str = line.split(",");
		List<Integer> numbers = new ArrayList<>();
		for (String s : str) {
			numbers.add(Integer.parseInt(s));
		}
		return numbers;
	}
}
