package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {
    private final List<Lotto> lottoList;

    public Lottos() {
        this.lottoList = new ArrayList<>();
    }

    public void buyLottos(int count) {
        for(int i=0; i<count; i++) {
            lottoList.add(new Lotto(LottoNumberGenerator.generate()
                    .stream()
                    .map(LottoNumber::new)
                    .collect(Collectors.toList())));
        }
    }

    public int size() {
        return lottoList.size();
    }

    @Override
    public String toString() {
        return lottoList.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining("\n"));
    }

    public LottoResult getResult(WinningLotto winningLotto) {
        LottoResult result = new LottoResult();
        lottoList.forEach(lotto ->
                result.add(Rank.valueOf(winningLotto.getCorrectCount(lotto))));

        return result;
    }
}
