package lotto.domain;

import java.awt.print.PrinterIOException;
import java.util.ArrayList;
import java.util.List;

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
        if(lottoNumberList == null) throw new NullPointerException("null값이 올 수 없습니다.");
        if(lottoNumberList.size() != BALL_CNT) throw new IllegalArgumentException("볼 개수가 일치하지 않습니다.");
        if(isDuplicate(lottoNumberList)) throw new IllegalArgumentException("중복된 볼을 가질 수 없습니다.");
        this.lottoNumberList = new ArrayList<>(lottoNumberList);
    }

    private boolean isDuplicate(List<LottoNumber> lottoNumberList) {
        return lottoNumberList.stream().distinct().count() != Lotto.BALL_CNT;
    }

    public boolean has(LottoNumber number) {
        return this.lottoNumberList.contains(number);
    }

    public int match(Lotto winning) {
        return (int) winning.lottoNumberList.stream().filter(lottoNumber -> this.lottoNumberList.contains(lottoNumber)).count();
    }
}
