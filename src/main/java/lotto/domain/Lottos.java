package lotto.domain;

import lotto.utils.RandomLottoNumbersGenerator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Lottos implements Iterable<Lotto>{
    List<Lotto> lottoList = new ArrayList<>();

    public Lottos(){
    }

    public Lottos(List<Lotto> lottoList){
        this.lottoList = lottoList;
    }

    public void addRandomLotto(){
        lottoList.add(new Lotto(RandomLottoNumbersGenerator.generate()));
    }

    public int size() {
        return lottoList.size();
    }

    @Override
    public Iterator<Lotto> iterator() {
        return lottoList.iterator();
    }
}
