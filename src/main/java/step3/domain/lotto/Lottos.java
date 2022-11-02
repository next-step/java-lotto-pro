package step3.domain.lotto;

import step3.domain.amount.Amount;
import step3.domain.generator.Random;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static step3.domain.lotto.Lotto.DEFAULT_LOTTO_PRICE;

public class Lottos {

    private final List<Lotto> lottos = new ArrayList<>();

    public Lottos(Amount amount) {
        createLottos(amount);
    }

    public List<Lotto> value() {
        return Collections.unmodifiableList(this.lottos);
    }

    private void createLottos(Amount amount) {
        for (int i = 0; i < amount.getLottoPurchasesCount(DEFAULT_LOTTO_PRICE); i++) {
            lottos.add(new Lotto(new LottoNumbers(new Random())));
        }
    }

    private static void appendLottoNumber(StringBuilder sb, LottoNumbers lottoNumbers) {
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
