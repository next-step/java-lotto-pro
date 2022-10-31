package step3.model.value;

public class ErrMsg {
    private ErrMsg() {
        throw new AssertionError();
    }
    public static final String WRONG_RANGE = "1~45 사이의 숫자만 입력해주시기 바랍니다.";
    public static final String EMPTY_INPUT = "입력값이 비었습니다.";
    public static final String NOT_NUMBER = "숫자를 입력해주시기 바랍니다.";

    public static final String WRONG_LENGTH = "로또번호의 갯수가 맞지 않습니다.";

    public static final String DUPLICATED_INPUT = "중복된 숫자가 뽑혔습니다.";
}
