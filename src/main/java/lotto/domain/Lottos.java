package lotto.domain;

import java.util.Collections;
import java.util.List;

public class Lottos{
    List<Lotto> lottos;

    public Lottos(List<Lotto> lottoList){
        this.lottos = lottoList;
    }

    public static Lottos from(List<Lotto> inputLotto) {
        return new Lottos(inputLotto);
    }

    public int size() {
        return lottos.size();
    }

    public List<Lotto> getLottosAsUnmodifiableList(){
        return Collections.unmodifiableList(lottos);
    }

    public int price(){
        return size() * Money.LOTTO_PRICE;
    }
}
