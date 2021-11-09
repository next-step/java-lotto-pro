package lotto.domain.exception;

public class LottosNotCollectableException extends IllegalArgumentException {
	private static final String LOTTOS_NULL_OR_EMPTY_ERROR = "로또 목록은 null 이나 0개 일 수 없습니다.";

	public LottosNotCollectableException() {
		super(LOTTOS_NULL_OR_EMPTY_ERROR);
	}
}
