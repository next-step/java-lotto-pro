package lottoauto.domain;

import lottoauto.util.SixRandomNumberUtil;
import lottoauto.wrapper.Lotto;

import java.util.ArrayList;

public class LottoList {
    ArrayList<Lotto> lottoList = new ArrayList<>();
    int tryTimes;
    SixRandomNumberUtil sixRandomNumberUtil = new SixRandomNumberUtil();

    public LottoList(int tryTimes) {
        this.tryTimes = tryTimes;
        for(int i = 0 ; i < tryTimes ; i++) {
            Lotto lotto = new Lotto(sixRandomNumberUtil.makeRandomNumbers());
            lottoList.add(lotto);
        }
    }

    public int size() {
        return lottoList.size();
    }

    public Lotto get(int index) {
        return lottoList.get(index);
    }

}
