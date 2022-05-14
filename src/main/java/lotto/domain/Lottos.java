package lotto.domain;

import lotto.utils.RandomLottoNumbersGenerator;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    List<Lotto> lottoList = new ArrayList<>();

    public void addRandomLotto(){
        lottoList.add(new Lotto(RandomLottoNumbersGenerator.generate()));
    }

    public int size() {
        return lottoList.size();
    }
}
