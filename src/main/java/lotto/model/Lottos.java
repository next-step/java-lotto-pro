package lotto.model;

import lotto.NumberUtils;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> data;

    private Lottos(List<Lotto> data) {
        this.data = data;
    }

    public static Lottos generateAuto(int count) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            List<Integer> list = NumberUtils.generateRandomNumbers(6, 1, 45);
            Lotto lotto = Lotto.generate(list);
            lottos.add(lotto);
        }

        return new Lottos(lottos);
    }

    public void print() {
        for (Lotto lotto : data) {
            System.out.println(lotto.toString());
        }
    }

    public int size() {
        return data.size();
    }
}
