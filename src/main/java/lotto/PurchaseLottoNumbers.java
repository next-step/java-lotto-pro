package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class PurchaseLottoNumbers {
    private final List<LottoNumbers> purchaseLottoNumbers;

    public PurchaseLottoNumbers(List<LottoNumbers> purchaseLottoNumbers) {
        this.purchaseLottoNumbers = purchaseLottoNumbers;
    }

    public String printPurchaseLottoNumber() {
        StringBuilder stringBuilder = new StringBuilder();
        for (LottoNumbers lottoNumbers : purchaseLottoNumbers) {
            stringBuilder.append(lottoNumbers.toString()).append("\n");
        }
        return stringBuilder.toString();
    }

    public List<Rank> getRank(LottoNumbers winningNumbers, LottoNumber bonus) {
        return purchaseLottoNumbers.stream()
                .map(lottoNumbers -> lottoNumbers.getRank(winningNumbers, bonus))
                .collect(Collectors.toList());
    }

    public void addLottoNumbers(List<LottoNumbers> lottoNumbers) {
        purchaseLottoNumbers.addAll(lottoNumbers);
    }
}
