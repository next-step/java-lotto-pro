package lotto.common.exceptions;

/**
 * packageName : lotto.common
 * fileName : CustomEmptyException
 * author : haedoang
 * date : 2021/11/06
 * description :
 */
public class CustomEmptyException extends IllegalArgumentException {
    private static final String message = "빈값이나 null은 허용되지 않습니다.";

    public CustomEmptyException() {
        super(message);
    }
}
