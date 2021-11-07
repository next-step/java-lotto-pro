package lottoservice.ui;

import java.util.Scanner;

public class ConsoleInputView implements InputView {

	/* Scanner 객체를 클래스 변수로 생성하여 재사용 */
	private Scanner scanner = getScanner();

	public ConsoleInputView() {
		scanner = getScanner();
	}

	private Scanner getScanner() {
		return new Scanner(System.in);
	}

	public String readInputLine() {
		return scanner.nextLine();
	}
}
