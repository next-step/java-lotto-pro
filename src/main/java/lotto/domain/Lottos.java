package lotto.domain;

/***
 *  피드백 내용 : 1) 중복된 코드 줄이기
 *              2) 디미터의 법칙의 사용  : 1. 객체 자신의 메서드, 2. 메서드의 파라미터로 넘어온 객체들의 메서드,
 *                                      3. 메서드 내부 생성,초기화된 메서드, 4. 인서튼스 변수로 가지고 있는 객체가 소유한 메서드 사용
 *                                      => PurchasePrice 객체에 값을 전달하는것으로 구현
 *
 *
 */

import lotto.common.exceptions.CustomEmptyException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * packageName : lotto.domain
 * fileName : Lottos
 * author : haedoang
 * date : 2021-11-05
 * description : 로또 리스트 클래스
 */
public class Lottos {
    private final List<Lotto> lottoList;

    public Lottos(List<Lotto> lottoList) {
        this.lottoList = new ArrayList<>(validate(lottoList));
    }

    public Lottos(List<Lotto> lottoList, PurchasePrice price) {
        List<Lotto> validateLottoList = validate(lottoList);
        if (!price.isMatchCount(validateLottoList.size())) throw new IllegalArgumentException("구매 수량이 일치하지 않습니다.");
        this.lottoList = new ArrayList<>(validateLottoList);
    }

    private List<Lotto> validate(List<Lotto> lottoList) {
        if (!Optional.ofNullable(lottoList).isPresent() || lottoList.isEmpty()) throw new CustomEmptyException();
        return lottoList;
    }

    public Ranks getResults(WinningLotto winning) {
        return new Ranks(lottoList.stream().map(lotto -> lotto.getRank(winning)).collect(Collectors.toList()));
    }

    public List<String> getPrintBallList() {
        return this.lottoList.stream().map(Lotto::printBalls).collect(Collectors.toList());
    }
}
