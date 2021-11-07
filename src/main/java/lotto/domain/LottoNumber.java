package lotto.domain;

import lotto.common.exceptions.CustomEmptyException;
import lotto.common.utils.StringUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;
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
    private static Map<Integer, LottoNumber> lottoNumberMap = new HashMap<>();

    private final int number;

    static {
        IntStream.range(MIN_NUMBER, MAX_NUMBER + 1).forEach(i ->
            lottoNumberMap.put(i, new LottoNumber(i))
        );
    }
    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber valueOf(int number) {
        LottoNumber lottoNumber = lottoNumberMap.get(number);
        if(lottoNumber == null) throw new IllegalArgumentException("1부터 45 사이의 숫자만 가능합니다.");
        return lottoNumber;
    }

    public static LottoNumber valueOf(String strNumber) {
        if (StringUtil.isStringEmpty(strNumber)) throw new CustomEmptyException();
        return LottoNumber.valueOf(StringUtil.parseNumber(strNumber.trim()));
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
