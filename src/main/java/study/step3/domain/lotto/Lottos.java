package study.step3.domain.lotto;

import study.step3.domain.lottonumber.LottoNumbers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(final List<Lotto> lottos) {
        this.lottos = new ArrayList<>(lottos);
    }

    public int size() {
        return this.lottos.size();
    }

    public String report() {
        StringBuilder output = new StringBuilder();
        for (Lotto lotto : lottos) {
            output.append("[").append(lotto.reportLottoNumbers()).append("]").append("\n");
        }
        return output.toString();
    }

    public List<Long> matchAll(LottoNumbers winningNumbers) {
        return this.lottos.stream()
                .map(lotto -> lotto.match(winningNumbers))
                .collect(Collectors.toList());
    }
}
