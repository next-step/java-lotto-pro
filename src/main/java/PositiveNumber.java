import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PositiveNumber {
    private static final Pattern POSITIVE_NUMBER_PATTERN = Pattern.compile("^\\d+");
    private static final String NOT_PERMITTED_PATTERN_EXCEPTION_STATEMENT = "허용되는 패턴이 아닙니다.(음수, 문자열)";

    private final int positiveNumber;

    private PositiveNumber(int positiveNumber) {
        validate(String.valueOf(positiveNumber));
        this.positiveNumber = positiveNumber;
    }

    private PositiveNumber(String positiveNumber) {
        validate(positiveNumber);
        this.positiveNumber = Integer.valueOf(positiveNumber);
    }

    public static PositiveNumber from(String positiveNumber) {
        return new PositiveNumber(positiveNumber);
    }

    private void validate(String number) {
        Matcher matcher = POSITIVE_NUMBER_PATTERN.matcher(number);
        if (!matcher.find()) {
            throw new RuntimeException(NOT_PERMITTED_PATTERN_EXCEPTION_STATEMENT);
        }
    }

    public PositiveNumber add(PositiveNumber positiveNumber) {
        return new PositiveNumber(this.positiveNumber + positiveNumber.positiveNumber);
    }

    public int positiveNumber() {
        return positiveNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof PositiveNumber))
            return false;
        PositiveNumber that = (PositiveNumber) o;
        return positiveNumber == that.positiveNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(positiveNumber);
    }
}
