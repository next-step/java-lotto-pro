package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class Lottos {
    private final List<Lotto> purchaseLottoNumbers;

    public Lottos(List<Lotto> purchaseLottoNumbers) {
        this.purchaseLottoNumbers = purchaseLottoNumbers;
    }

    public String printPurchaseLottoNumber() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Lotto lotto : purchaseLottoNumbers) {
            stringBuilder.append(lotto.toString()).append("\n");
        }
        return stringBuilder.toString();
    }

    public List<Rank> getRank(Lotto winningNumbers, LottoNumber bonus) {
        return purchaseLottoNumbers.stream()
                .map(lottoNumbers -> lottoNumbers.getRank(winningNumbers, bonus))
                .collect(Collectors.toList());
    }

    public void addLottoNumbers(List<Lotto> lottoNumbers) {
        purchaseLottoNumbers.addAll(lottoNumbers);
    }
}
