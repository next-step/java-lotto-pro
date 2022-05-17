package camp.nextstep.edu.step3;

import java.util.List;
import java.util.Objects;

public class LottoAnswer {
    private final Lotto answer;
    private final LottoNumber bonusNumber;

    public LottoAnswer(List<LottoNumber> answerNumbers, LottoNumber bonusNumber) {
        validation(answerNumbers, bonusNumber);
        this.answer = new Lotto(answerNumbers);
        this.bonusNumber = bonusNumber;
    }

    public Hit verify(final Lotto lotto) {
        return lotto.checkTo(answer, this.bonusNumber);
    }

    private void validation(List<LottoNumber> answerNumbers, LottoNumber bonusNumber) {
        if (Objects.isNull(answerNumbers) || Objects.isNull(bonusNumber) || answerNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨번호에 중복될수 없습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoAnswer that = (LottoAnswer) o;
        return Objects.equals(answer, that.answer) && Objects.equals(bonusNumber, that.bonusNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(answer, bonusNumber);
    }
}
