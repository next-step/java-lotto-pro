package lotto.domain;

import lotto.util.LottoNumberGenerator;

import java.util.List;

public class Lotto {

    private static final int COLLECT_ADD_NUMBER = 1;
    private static final int NOT_COLLECT_ADD_NUMBER = 0;

    private final List<Integer> lottoNumbers;

    public Lotto() {
        lottoNumbers = LottoNumberGenerator.generateLottoNumbers();
    }

    public Lotto(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public int countCollectNumber(Lotto winningNumbers) {
        int collectCount = 0;
        for (int winningNumber : winningNumbers.lottoNumbers) {
            collectCount += containNumbers(winningNumber);
        }
        return collectCount;
    }

    private int containNumbers(int winningNumber){
        if(lottoNumbers.contains(winningNumber)){
            return COLLECT_ADD_NUMBER;
        }
        return NOT_COLLECT_ADD_NUMBER;
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
