package lottoservice.ui;

/**
 * 사용자에게 메세지를 출력하기 위한 클래스
 */
public interface ResultView {

	<T> void outputGuide(T data);

	<T> void outputResult(T data);

	<T> void outputError(T data);
}
