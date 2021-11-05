package lottogame;

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
