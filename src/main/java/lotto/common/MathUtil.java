package lotto.common;

/**
 * packageName : lotto.common
 * fileName : MathUtil
 * author : haedoang
 * date : 2021-11-05
 * description :
 */
public class MathUtil {

    public static double calculateYield(double earning, double investment) {
        return Math.floor(earning / investment * 100.0) / 100.0;
    }
}
