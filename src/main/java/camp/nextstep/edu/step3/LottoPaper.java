package camp.nextstep.edu.step3;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class LottoPaper {
    private final List<Lotto> purchaseList;

    public LottoPaper(Lotto[] lottoArray) {
        validation(lottoArray);
        this.purchaseList = Arrays.asList(lottoArray);
    }

    public LottoResult checkAll(final Lotto answerLotto) {
        if (Objects.isNull(answerLotto)) {
            throw new IllegalArgumentException("invalid check all input");
        }

        return new LottoResult(purchaseList.stream()
                .map((lotto) -> lotto.checkTo(answerLotto))
                .toArray(Hit[]::new));
    }

    public int numberOfPurchases() {
        return this.purchaseList.size();
    }

    private void validation(Lotto[] lottoArray) {
        if (Objects.isNull(lottoArray) || lottoArray.length < 1) {
            throw new IllegalArgumentException("invalid construct input");
        }
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
