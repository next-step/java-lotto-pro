package lotto.service;

import lotto.model.Lotto;

import java.util.Arrays;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottoList;

    public Lottos(Lotto[] lottoArray) {
        lottoList = Arrays.asList(lottoArray);
    }

    public int size() {
        return lottoList.size();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < lottoList.size(); i++) {
            stringBuilder.append(lottoList.get(i).toString()+"\n");
        }
        return stringBuilder.toString();
    }
}
