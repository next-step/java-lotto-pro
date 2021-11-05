package lotto.domain;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.common.Constants.NUMBER_SEPARATOR;

/**
 * packageName : lotto.domain
 * fileName : Lotto
 * author : haedoang
 * date : 2021-11-05
 * description :
 */
public class Lotto {
    public static final int BALL_CNT = 6;

    private final List<LottoNumber> lottoNumberList;

    public Lotto(List<LottoNumber> lottoNumberList) {
        if (lottoNumberList == null) throw new NullPointerException("null값이 올 수 없습니다.");
        if (lottoNumberList.size() != BALL_CNT) throw new IllegalArgumentException("볼 개수가 일치하지 않습니다.");
        if (isDuplicate(lottoNumberList)) throw new IllegalArgumentException("중복된 볼을 가질 수 없습니다.");
        this.lottoNumberList = new ArrayList<>(lottoNumberList);
    }

    /**
     *
     * @Throws java.lang.NumberFormatException이 발생할 수 있다.
     */
    public Lotto(String input) {
        if(input == null) throw new NullPointerException("null값이 올 수 없습니다.");
        if(input.isEmpty()) throw new IllegalArgumentException("빈 값은 허용되지 않습니다.");
        String[] numbers = input.split(NUMBER_SEPARATOR);
        if(numbers.length != Lotto.BALL_CNT) throw new IllegalArgumentException("숫자 개수가 올바르지 않습니다.");
        lottoNumberList = new ArrayList<>(Arrays.stream(numbers).map(number -> new LottoNumber(Integer.parseInt(number))).collect(Collectors.toList()));
    }


    private boolean isDuplicate(List<LottoNumber> lottoNumberList) {
        return lottoNumberList.stream().distinct().count() != Lotto.BALL_CNT;
    }

    public boolean has(LottoNumber number) {
        return this.lottoNumberList.contains(number);
    }

    private int match(Lotto winning) {
        return (int) winning.lottoNumberList.stream().filter(this.lottoNumberList::contains).count();
    }

    public Rank getRank(Lotto winning) {
        return new Rank(match(winning));
    }
}
