package lotto.common;
/***
 *  피드백 내용 : static 메소드가 있는 클래스는 사용 역할에 맞게 인스턴스 생성을 제한할 것
 */

/**
 * packageName : lotto.common
 * fileName : MathUtil
 * author : haedoang
 * date : 2021-11-05
 * description : 공통 계산식 함수 클래스
 */
public class MathUtil {
    private MathUtil() {} //인스턴스 생성 방지
    public static double calculateYield(double earning, double investment) {
        return Math.floor(earning / investment * 100.0) / 100.0;
    }
}
