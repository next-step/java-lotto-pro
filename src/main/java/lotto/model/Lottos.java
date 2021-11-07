package lotto.model;

import java.util.*;

public class Lottos {

    private final List<Lotto> lottoGroup;

    public Lottos(Lotto[] lottoArray) {
        lottoGroup = Arrays.asList(lottoArray);
    }

    public int size() {
        return lottoGroup.size();
    }

    public List<Lotto> getLottoGroup() {
        return Collections.unmodifiableList(lottoGroup);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < lottoGroup.size(); i++) {
            stringBuilder.append(lottoGroup.get(i).toString() + "\n");
        }
        return stringBuilder.toString();
    }
}
