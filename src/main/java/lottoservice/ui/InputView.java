package lottoservice.ui;

import java.util.Scanner;

/**
 * 사용자로부터 데이터를 입력받기 위한 클래스
 */

public class InputView {

	private InputView(){
	}

	/* Scanner 객체를 클래스 변수로 생성하여 재사용 */
	private static Scanner scanner = getScanner();

	public static String readLine() {
		return scanner.nextLine();
	}

	private static Scanner getScanner() {
		return new Scanner(System.in);
	}
}
