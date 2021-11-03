package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

	public static int getMoney() {
		System.out.println("구입금액을 입력해 주세요.");
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}

	public static List<Integer> getLottoNumbers() {
		System.out.println("지난 주 당첨 번호를 입력해 주세요.");
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		String[] str = line.split(",");
		List<Integer> numbers = new ArrayList<>();
		for (String s : str) {
			numbers.add(Integer.parseInt(s));
		}
		return numbers;
	}

}
