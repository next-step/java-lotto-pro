package lotto.common;

/**
 * packageName : lotto.common
 * fileName : MathUtil
 * author : haedoang
 * date : 2021-11-05
 * description : 공통 계산식 함수 클래스
 */
public class MathUtil {

    public static double calculateYield(double earning, double investment) {
        return Math.floor(earning / investment * 100.0) / 100.0;
    }
}
