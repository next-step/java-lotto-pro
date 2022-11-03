package lotto.model.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;
import lotto.model.constants.ErrorMessage;
import lotto.model.constants.LottoConstants;

public class Lotto {

    private static final int LOTTO_NUMBER_EXIST = 1;
    private static final int LOTTO_NUMBER_DO_NOT_EXIST = 0;
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

    protected void checkLottoNumberCount() {
        if (this.lotto.size() != LottoConstants.LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_COUNT_NOT_MATCH);
        }
    }

    private int contains(LottoNumber lottoNumber) {
        if (lotto.contains(lottoNumber)) {
            return LOTTO_NUMBER_EXIST;
        }
        return LOTTO_NUMBER_DO_NOT_EXIST;
    }

    public int compare(Lotto userLotto) {
        int count = 0;
        for (LottoNumber lottoNumber : lotto) {
            count += userLotto.contains(lottoNumber);
        }
        return count;
    }

    public void sortNumbers() {
        Collections.sort(this.lotto);
    }

    public void print() {
        System.out.print(LottoConstants.LOTTO_PRINT_START);
        StringJoiner sj = new StringJoiner(LottoConstants.LOTTO_PRINT_DELIMITER);
        for (LottoNumber lottoNumber : lotto) {
            sj.add(lottoNumber.getLottoNumber()+"");
        }
        System.out.print(sj);
        System.out.println(LottoConstants.LOTTO_PRINT_END);
    }

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
