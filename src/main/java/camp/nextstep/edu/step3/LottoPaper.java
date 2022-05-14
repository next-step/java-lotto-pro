package camp.nextstep.edu.step3;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoPaper {
    private final List<Lotto> purchaseList;

    public LottoPaper(List<Lotto> purchaseList) {
        if (purchaseList.isEmpty()) {
            throw new IllegalArgumentException("invalid construct input");
        }
        this.purchaseList = purchaseList;
    }

    public LottoResult checkAll(final Lotto answerLotto) {
        if (Objects.isNull(answerLotto)) {
            throw new IllegalArgumentException("invalid check all input");
        }

        return new LottoResult(purchaseList.stream()
                .map((lotto) -> lotto.checkTo(answerLotto))
                .collect(Collectors.toList()));
    }

    public int numberOfPurchases() {
        return this.purchaseList.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoPaper that = (LottoPaper) o;
        return Objects.equals(purchaseList, that.purchaseList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(purchaseList);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Lotto lotto : purchaseList) {
            stringBuilder.append(String.format("%s\n",lotto));
        }
        return stringBuilder.toString();
    }
}
