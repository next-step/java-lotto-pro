package exception;

public class IllegalArgument extends IllegalArgumentException{
    public static final IllegalArgument NEGATIVE_OR_NOT_NUMBER = new IllegalArgument("[ERROR] 음수 이거나 숫자 이외의 값은 처리할 수 없습니다.");

    public IllegalArgument(final String errorMessage) {super(errorMessage);}
}
