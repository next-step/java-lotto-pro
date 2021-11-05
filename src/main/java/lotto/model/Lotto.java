package lotto.model;

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
        if (length > LottoNumber.SIZE){
            throw new IndexOutOfBoundsException("숫자 갯수가 "+LottoNumber.SIZE+"보다 큽니다.");
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
