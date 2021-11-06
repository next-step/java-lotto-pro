package lottoservice.ui;

public class ConsoleResultView implements ResultView {

	private static String ERROR_PREFIX = "[ERROR] ";

	@Override
	public <T> void outputGuide(T data) {
		System.out.println(data);
	}

	@Override
	public <T> void outputResult(T data) {
		System.out.println(data);
	}

	@Override
	public <T> void outputError(T data) {
		System.out.println(ERROR_PREFIX + data);
	}
}
