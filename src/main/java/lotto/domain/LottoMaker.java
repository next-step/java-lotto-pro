package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * packageName : lotto.domain
 * fileName : LottoMaker
 * author : haedoang
 * date : 2021-11-05
 * description : 랜덤 로또 번호 생성기 클래스
 */
public class LottoMaker {
    private final List<LottoNumber> numbers;

    public LottoMaker() {
        numbers = new ArrayList<>(this.init());
    }

    private List<LottoNumber> init() {
        return IntStream.range(LottoNumber.MIN_NUMBER, LottoNumber.MAX_NUMBER).mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public void shuffle() {
        Collections.shuffle(this.numbers);
    }

    public Lotto createLotto() {
        shuffle();
        return new Lotto(IntStream.range(0, Lotto.BALL_CNT).mapToObj(this.numbers::get)
                .collect(Collectors.toList()));
    }
}
