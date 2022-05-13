package camp.nextstep.edu.step3;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class LottoPaper {
    private final List<Lotto> userLottoList;

    public LottoPaper(Lotto... lottoArray) {
        validation(lottoArray);
        this.userLottoList = Arrays.asList(lottoArray);
    }

    public Total checkAll(final Lotto answerLotto) {
        return new Total(userLottoList.stream()
                .map((lotto) -> lotto.checkTo(answerLotto))
                .toArray(Hit[]::new));
    }

    private void validation(Lotto[] lottoArray) {
        if (Objects.isNull(lottoArray) || lottoArray.length < 1 ) {
            throw new IllegalArgumentException("invalid input");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoPaper that = (LottoPaper) o;
        return Objects.equals(userLottoList, that.userLottoList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userLottoList);
    }
}
