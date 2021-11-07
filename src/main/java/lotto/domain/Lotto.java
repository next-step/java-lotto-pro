package lotto.domain;


import lotto.common.exceptions.CustomEmptyException;
import lotto.common.utils.StringUtil;
import lotto.ui.ResultView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.common.Constants.NUMBER_SEPARATOR;
/**
 * 피드백 내용 : 1) LottoNumber String 생성자 등록으로 코드를 간결하게 수정하자.(LottoNumber 내에 내용 작성함)
 * 2) 문자열에서 lottoNumberList를 먼저 생성하고 검증하도록 수정하자.
 * 3) LottoNumber에 대한 검증은 LottoNumber 생성자에게 맡기자. => isLottoNumber 제거
 * 4) 중복 숫자 검증 오류 있음
 * 5) 로또 정렬해서 출력할것
 */

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
        this.lottoNumberList = new ArrayList<>(validate(lottoNumberList));
    }

    public Lotto(String input) {
        if (StringUtil.isStringEmpty(input)) throw new CustomEmptyException();
        List<LottoNumber> inputLottoList = Arrays.stream(input.split(NUMBER_SEPARATOR)).map(LottoNumber::valueOf).collect(Collectors.toList());
        this.lottoNumberList = new ArrayList<>(validate(inputLottoList));
    }

    public static Lotto valueOf(String input) {
        return new Lotto(input);
    }

    private List<LottoNumber> validate(List<LottoNumber> lottoNumberList) {
        if (lottoNumberList == null) throw new NullPointerException("null값이 올 수 없습니다.");
        if (lottoNumberList.size() != BALL_CNT) throw new IllegalArgumentException("볼 개수가 일치하지 않습니다.");
        if (isDuplicate(lottoNumberList)) throw new IllegalArgumentException("중복된 볼은 올 수 없습니다.");
        return lottoNumberList;
    }

    private boolean isDuplicate(List<LottoNumber> lottoNumberList) {
        return lottoNumberList.stream().distinct().count() != Lotto.BALL_CNT;
    }

    public boolean has(LottoNumber number) {
        return this.lottoNumberList.contains(number);
    }

    private int match(WinningLotto winning) {
        return (int) this.lottoNumberList.stream().filter(winning::has).count();
    }

    public Rank getRank(WinningLotto winning) {
        return Rank.valueOf(this.match(winning), this.lottoNumberList.stream().anyMatch(winning::isBonus));
    }

    public void print() {
        ResultView.print(StringUtil.wrap(lottoNumberList.stream().sorted().map(LottoNumber::printNumber).collect(Collectors.joining(NUMBER_SEPARATOR))));
    }
}
