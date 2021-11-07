package lotto.domain;

import lotto.common.exceptions.CustomEmptyException;
import lotto.common.utils.StringUtil;

import java.util.Objects;
/**
 * 피드백 내용 : 1) LottoNumber 생성자로 String을 받는 것을 추가하자
 * => 일급컬렉션에서 형변환을 해서 생성하기 떄문에 예외가 발생할 수 있고, 소스가 가독성이 좋아질 것같음
 * 2) 로또 번호 정렬하기
 * => Comparable interface 사용
 * 3) 정적 팩토리 메소드 사용 => 호출 시마다 객체생성을 줄일 수 있다. 가독성 좋아진다.
 * 참고 : https://johngrib.github.io/wiki/pattern/static-factory-method/
 */

/**
 * packageName : lotto.domain
 * fileName : LottoNumber
 * author : haedoang
 * date : 2021/11/04
 * description :
 */
public class LottoNumber implements Comparable<LottoNumber> {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;

    private final int number;

    public LottoNumber(int number) {
        this.number = this.validate(number);
    }

    public LottoNumber(String strNumber) {
        if (StringUtil.isStringEmpty(strNumber)) throw new CustomEmptyException();
        this.number = this.validate(StringUtil.parseNumber(strNumber.trim()));
    }

    public static LottoNumber valueOf(int number) {
        return new LottoNumber(number);
    }

    private int validate(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) throw new IllegalArgumentException("1부터 45 사이의 숫자만 가능합니다.");
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    public String printNumber() {
        return String.valueOf(this.number);
    }

    @Override
    public int compareTo(LottoNumber comp1) {
        return this.number > comp1.number ? 1 : -1;
    }


}
