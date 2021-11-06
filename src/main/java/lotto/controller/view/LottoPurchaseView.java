package lotto.controller.view;

import java.util.Collection;
import java.util.StringJoiner;

import lotto.model.LottoNumbers;

public class LottoPurchaseView {
    private static final String NUMBER_OF_LOTTO_STATEMENT_FORMAT = "%d개를 구매했습니다.";

    public final String paymentId;
    public final String lottoId;
    public final String purchaseInfoAsString;

    public LottoPurchaseView(String paymentId, String lottoId, Collection<LottoNumbers> numbersCollection) {
        this.paymentId = paymentId;
        this.lottoId = lottoId;
        this.purchaseInfoAsString = getPurchaseInfoAsString(numbersCollection);
    }

    private String getPurchaseInfoAsString(Collection<LottoNumbers> numbersCollection) {
        StringJoiner stringJoiner = new StringJoiner(System.lineSeparator());
        stringJoiner.add(String.format(NUMBER_OF_LOTTO_STATEMENT_FORMAT, numbersCollection.size()));
        for (LottoNumbers lottoNumbers : numbersCollection) {
            stringJoiner.add(lottoNumbers.toString());
        }
        return stringJoiner.toString();
    }
}
