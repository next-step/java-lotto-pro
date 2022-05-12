package camp.nextstep.edu.until;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class CollectionHelper {
    private final static Pattern POSITIVE_NUMBER_REGEX = Pattern.compile("^[1-9]\\d*$");

    private CollectionHelper() {}

    public static List<Integer> arrayStringToIntegerList(String[] source) {
        checkValidStringNumber(source);

        List<Integer> result = new ArrayList<>();

        for (String stringNumber : source) {
            result.add(Integer.parseInt(stringNumber));
        }

        return result;
    }

    private static void checkValidStringNumber(String[] source) {
        if (Arrays.stream(source).anyMatch(value -> !POSITIVE_NUMBER_REGEX.matcher(value).find())) {
            throw new IllegalArgumentException("숫자로 변환할 수 없습니다.");
        }
    }
}
