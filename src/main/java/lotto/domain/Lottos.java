package lotto.domain;

import java.util.ArrayList;
import java.util.List;
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
        if (lottoList == null) throw new NullPointerException("null값이 올 수 없습니다.");
        if (lottoList.isEmpty()) throw new IllegalArgumentException("빈 값이 올 수 없습니다.");
        this.lottoList = new ArrayList<>(lottoList);
    }

    public Lottos(List<Lotto> lottoList, PurchasePrice price) {
        if (lottoList == null) throw new NullPointerException("null값이 올 수 없습니다.");
        if (lottoList.isEmpty()) throw new IllegalArgumentException("빈 값이 올 수 없습니다.");
        if (!price.equals(new PurchasePrice(lottoList.size() * PurchasePrice.LOTTO_PRICE)))
            throw new IllegalArgumentException("구매수량이 일치하지 않습니다.");
        this.lottoList = new ArrayList<>(lottoList);
    }


    public Ranks getResults(Lotto winning) {
        return new Ranks(lottoList.stream().map(lotto -> lotto.getRank(winning)).collect(Collectors.toList()));
    }

    public void print() {
        this.lottoList.stream().forEach(System.out::println);
    }
}
