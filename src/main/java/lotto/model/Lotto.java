package lotto.model;

import lotto.view.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private List<LottoNumber> lottoNumbers;

    public Lotto(int[] numbers) {
        valid(numbers.length);
        lottoNumbers = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            lottoNumbers.add(new LottoNumber(numbers[i]));
        }
    }

    private void valid(int length) {
        if (length > LottoNumber.SIZE) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_SIZE_UNMATCHED);
        }
    }

    public int size() {
        return lottoNumbers.size();
    }

    public boolean compare(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    public Rank matchNumber(Lotto winLotto) {
        int result = 0;
        for (int i = 0; i < size(); i++) {
            result += winLotto.compare(lottoNumbers.get(i)) ? 1 : 0;
        }
        return Rank.valueOf(result);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }


}
