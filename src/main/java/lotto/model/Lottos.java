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

    public Lottos(List<Lotto> lottos) {
        this.lottos.addAll(lottos);
    }

    public Lottos add(Lottos lottos) {
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.addAll(this.lottos);
        lottoList.addAll(lottos.lottos);
        return new Lottos(lottoList);
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
