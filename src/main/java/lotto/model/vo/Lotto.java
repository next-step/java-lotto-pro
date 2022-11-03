package lotto.model.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;
import lotto.model.constants.ErrorMessage;
import lotto.model.constants.LottoConstants;

public class Lotto {

    private List<LottoNumber> lotto;

    public void addLottoNumber(LottoNumber lottoNumber) {
        if (this.lotto == null) {
            this.lotto = new ArrayList<>();
        }
        validateLotto(lottoNumber);
        this.lotto.add(lottoNumber);
    }

    public void addLottoNumber(int number) {
        LottoNumber lottoNumber = new LottoNumber(number);
        if (this.lotto == null) {
            this.lotto = new ArrayList<>();
        }
        validateLotto(lottoNumber);
        this.lotto.add(lottoNumber);
    }

    protected void checkLottoNumberExist(LottoNumber lottoNumber) {
        if (lotto.contains(lottoNumber)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_EXIST);
        }
    }

    protected void validateLottoNumberCount() {
        if (this.lotto.size() >= LottoConstants.LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_COUNT_MAX);
        }
    }

    private void validateLotto(LottoNumber lottoNumber) {
        checkLottoNumberExist(lottoNumber);
        validateLottoNumberCount();
    }

    protected boolean checkLottoNumberCount() {
        return this.lotto.size() == LottoConstants.LOTTO_NUMBER_COUNT;
    }


    public void sortNumbers() {
        Collections.sort(this.lotto);
    }

    public void print() {
        System.out.println("[");
        StringJoiner sj = new StringJoiner(", ");
        for (LottoNumber lottoNumber : lotto) {
            sj.add(lottoNumber.getLottoNumber()+"");
        }
        System.out.println(sj);
        System.out.println("]");

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lotto lotto1 = (Lotto) o;
        Collections.sort(this.lotto);
        Collections.sort(lotto1.lotto);
        return Objects.equals(lotto, lotto1.lotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotto);
    }
}
