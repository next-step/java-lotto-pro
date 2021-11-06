package lotto.model;

import lotto.util.GameRule;
import lotto.view.GameMessage;

import java.util.*;

public class LottoPaper {

    private final List<LottoNumber> lottoNumbers;

    public LottoPaper(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
        lottoPaPerCorrectCheck();
    }

    public List<LottoNumber> getLottoNumber() {
        return Collections.unmodifiableList(lottoNumbers);
    }

    public boolean isContainsLottoNumber(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    public int matchLottoPaper(LottoPaper winningLottoPaper) {
        return (int) this.lottoNumbers.stream()
                .filter(winningLottoPaper::isContainsLottoNumber)
                .count();
    }

    private void lottoPaPerCorrectCheck() {
        Set<LottoNumber> lottoNumberSet = new HashSet<>(lottoNumbers);
        if(lottoNumberSet.size() != lottoNumbers.size()){
            throw new IllegalArgumentException(GameMessage.invalidInputMsg(GameMessage.ERROR_LOTTO_NUMBER_DUPLICATION_INPUT));
        }
        if (lottoNumbers.size() != GameRule.LOTTO_END_INDEX){
            throw new IllegalArgumentException(GameMessage.invalidInputMsg(GameMessage.ERROR_LOTTO_NUMBER_INPUT));
        }
    }
}
