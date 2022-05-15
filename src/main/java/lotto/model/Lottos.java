package lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {

    private final List<Lotto> lottos = new ArrayList<>();

    public Lottos(int quantity) {
        for (int i = 0; i < quantity; i++) {
            lottos.add(new Lotto());
        }
    }

    public int getQuantity() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public List<Result> getResults(Lotto winner, LottoNumber bonusNumber) {
        return lottos.stream().map(lotto -> lotto.getResult(winner, bonusNumber)).collect(Collectors.toList());
    }

}
