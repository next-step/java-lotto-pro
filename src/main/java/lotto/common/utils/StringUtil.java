package lotto.common.utils;

import lotto.common.Constants;

/**
 * packageName : lotto.common
 * fileName : StringUtil
 * author : haedoang
 * date : 2021/11/06
 * description :
 */
public class StringUtil {

    private StringUtil() {
    }

    public static boolean isStringEmpty(String str) {
        return str.trim().isEmpty();
    }

    public static int parseNumber(String str) throws NumberFormatException {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException nfe) {
            throw new NumberFormatException("숫자로 변환 할 수 없습니다.");
        }
    }

    public static String wrap(String msg) {
        return new StringBuilder().append(Constants.CONTAINER_PREFIX).append(msg).append(Constants.CONTAINER_SUFFIX).toString();
    }
}
