package lottoservice.ui;

/**
 * 사용자에게 메세지를 출력하기 위한 클래스
 */
public class ResultView {

	public static void printGuideMessage(String message){
		System.out.println(message);
	}

	public static<T> void printResultMessage(T message) {
		System.out.println(message);
	}

	public static void pringNewLine() {
		System.out.println();
	}

	public static void printErrorMessage(String message){
		System.out.println("[ERROR] "+message);
	}
}
