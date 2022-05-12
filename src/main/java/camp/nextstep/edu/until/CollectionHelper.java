package camp.nextstep.edu.until;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollectionHelper {

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
        if (Arrays.stream(source).anyMatch(value -> !TypeCheckHelper.isPossibleStringToInteger(value))) {
            throw new IllegalArgumentException("숫자로 변환할 수 없습니다.");
        }
    }
}
