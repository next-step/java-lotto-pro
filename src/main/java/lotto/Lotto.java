package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private List<Integer> lottoNumbers =  new ArrayList<>();

    public Lotto() {
    }

    public Lotto(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    public int checkMatchCount(Lotto checkLotto) {
        int countMatch = 0;
        for (Integer lotto : checkLotto.getLottoNumbers()) {
            countMatch = lottoNumbers.contains(lotto) ? countMatch + 1 : countMatch;
        }
        return countMatch;
    }

    public void addLottoNumber(String lottoNumber){
        int number;
        try {
            number = Integer.parseInt(lottoNumber);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("당첨번호는 숫자입니다.");
        }
        if (number < 0 || number > 45) {
            throw new IllegalArgumentException("당첨번호은 1~45 사이 숫자입니다.");
        }
        lottoNumbers.add(number);
    }
}