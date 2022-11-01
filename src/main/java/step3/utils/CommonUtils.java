package step3.utils;

import java.util.List;

import static step3.constant.Message.Error.ERROR_IS_NUMBERIC;
import static step3.constant.Message.Error.NOT_VALID_NULL;

public class CommonUtils {
    public static void commonCheckEmpty(String target) {
        if (target == null || target.isEmpty()) {
            throw new IllegalArgumentException(NOT_VALID_NULL);
        }
    }

    public static int commonStringToNumber(String target) {
        int afterNumber;
        try {
            afterNumber = Integer.parseInt(target);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_IS_NUMBERIC);
        }
        return afterNumber;
    }

    public static boolean isListContainsString(List<String> list, String target) {
        return list.contains(target);
    }
}
