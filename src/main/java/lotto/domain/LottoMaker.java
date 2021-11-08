package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
/**
 * 피드백 내용 : Collectors.collectingAndThen => finisher로 변환한다
 * => https://www.baeldung.com/java-8-collectors ###학습할 것
 */

/**
 * packageName : lotto.domain
 * fileName : LottoMaker
 * author : haedoang
 * date : 2021-11-05
 * description : 랜덤 로또 번호 생성기 클래스
 */
public class LottoMaker {
    private static final List<LottoNumber> numbers;

    static {
        numbers = new ArrayList<>(init());
    }

    private LottoMaker() {
    } //인스턴스 생성 방지

    private static List<LottoNumber> init() {
        return IntStream.range(LottoNumber.MIN_NUMBER, LottoNumber.MAX_NUMBER).mapToObj(LottoNumber::valueOf)
                .collect(Collectors.toList());
    }

    private static void shuffle() {
        Collections.shuffle(numbers);
    }

    public static Lotto createLotto() {
        shuffle();
        return IntStream.range(0, Lotto.BALL_CNT).mapToObj(numbers::get)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Lotto::new));
    }
}
