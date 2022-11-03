package step3.domain.lotto;

import java.util.Collections;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> value() {
        return Collections.unmodifiableList(this.lottos);
    }

    private void appendLottoNumber(StringBuilder sb, LottoNumbers lottoNumbers) {
        for (LottoNumber lottoNumber : lottoNumbers.value()) {
            sb.append(lottoNumber.getLottoNumber()).append(", ");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Lotto lotto : this.lottos) {
            sb.append("[");
            appendLottoNumber(sb, lotto.value());
            sb.append("]\n");
        }
        return sb.toString().replaceAll(", ]", "]");
    }
}
