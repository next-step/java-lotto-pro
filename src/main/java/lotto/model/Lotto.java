package lotto.model;

import lotto.util.LottoNumber;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private List<LottoNumber> lottoNumbers;

    public Lotto(int[] numbers) {
        lottoNumbers = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            lottoNumbers.add(new LottoNumber(numbers[i]));
        }
    }

    public int size() {
        return lottoNumbers.size();
    }

    public boolean compare(LottoNumber lottoNumber){
        return lottoNumbers.contains(lottoNumber);
    }

    public int matchNumber(Lotto winLotto) {
        int result = 0;
        for (int i = 0; i < size(); i++) {
            result += winLotto.compare(lottoNumbers.get(i)) ? 1 : 0;
        }
        return result;
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }


}
