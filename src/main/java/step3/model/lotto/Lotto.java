package step3.model.lotto;


import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import step3.model.value.ErrMsg;
import step3.model.value.Rule;

public class Lotto{
    private List<LottoNumber> lotto;
    public Lotto(List<Integer> lotto) {
        verifyLotto(lotto);
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
    private void verifyLotto(List<Integer> lottoNumbers) {
        if(lottoNumbers.size() != Rule.LOTTO_NUMBER_LENGTH){
            throw new IllegalArgumentException(ErrMsg.WRONG_LENGTH);
        }
        if(lottoNumbers.size() != new HashSet<>(lottoNumbers).size()){
            throw new IllegalArgumentException(ErrMsg.DUPLICATED_INPUT);
        }
    }

    @Override
    public String toString() {
        return this.lotto.toString();
    }
}