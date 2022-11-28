package lotto.model.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import lotto.model.constants.ErrorMessage;
import lotto.model.constants.LottoConstants;

public class Lotto {

    private static final int LOTTO_NUMBER_EXIST = 1;
    private static final int LOTTO_NUMBER_DO_NOT_EXIST = 0;
    private List<LottoNumber> lotto;

    public Lotto(List<Integer> numbers) {
        lotto = new ArrayList<>();
        for (int number : numbers) {
            lotto.add(LottoNumber.getLottoNumberByInt(number));
        }
    }

    public Lotto(String lottoNumbersInput) {
        String[] lottoNumbers = lottoNumbersInput.split(LottoConstants.WIN_LOTTO_DELIMITER);
        checkLottoNumberCount(lottoNumbers.length);
        lotto = new ArrayList<>();
        for (String lottoNumber : lottoNumbers) {
            lotto.add(LottoNumber.getLottoNumberByString(lottoNumber));
        }
    }

    public static Lotto generateOneAutoLotto() {
        List<Integer> lottoNumbers = new ArrayList<>();
        Collections.shuffle(LottoConstants.LOTTO_NUMBER_POOL);
        for (int i = 0; i < LottoConstants.LOTTO_NUMBER_COUNT; i++) {
            lottoNumbers.add(LottoConstants.LOTTO_NUMBER_POOL.get(i));
        }
        Lotto lotto = new Lotto(lottoNumbers);
        lotto.sortNumbers();
        return lotto;
    }

    protected static void checkLottoNumberCount(int count) {
        if (count != LottoConstants.LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_COUNT_NOT_MATCH);
        }
    }

    public void addLottoNumber(LottoNumber lottoNumber) {
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

    protected void checkLottoNumberAddable() {
        if (this.lotto.size() >= LottoConstants.LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_COUNT_MAX);
        }
    }

    private void validateLotto(LottoNumber lottoNumber) {
        checkLottoNumberExist(lottoNumber);
        checkLottoNumberAddable();
    }

    public int contains(LottoNumber lottoNumber) {
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

    public boolean lottoNumberExist(LottoNumber lottoNumber) {
        return lotto.contains(lottoNumber);
    }

    public void sortNumbers() {
        Collections.sort(this.lotto);
    }

    public List<LottoNumber> getLotto() {
        return Collections.unmodifiableList(new ArrayList<>(lotto));
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
