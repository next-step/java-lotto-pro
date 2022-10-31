package step3.model.lotto;


import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import step3.model.machine.Result;

public class Lotto{
    private List<LottoNumber> lotto;
    public Lotto(List<Integer> lotto) {
        this.lotto =createLotto(lotto);
    }

    private List<LottoNumber> createLotto(List<Integer> lotto) {
        return Collections.unmodifiableList(lotto.stream().map(LottoNumber::new).collect(Collectors.toList()));
    }

    public boolean isMatched(LottoNumber lottoNumber) {
        return lotto.contains(lottoNumber);
    }
    public int getMatchCount(Lotto winningLotto){
        return (int) lotto.stream().filter(winningLotto::isMatched).count();
    }
    public boolean isAllMatch(Lotto inputLotto){
        return this.lotto.stream().allMatch(inputLotto::isMatched);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Lotto)) {
            return false;
        }
        Lotto that = (Lotto) o;
        Collections.sort(this.lotto);
        Collections.sort(that.lotto);
        return this.lotto.equals(that.lotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotto);
    }

    @Override
    public String toString() {
        return this.lotto.toString();
    }
}