package lotto.domain;

import lotto.constant.LottoMessage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;
    private static final int LOTTO_NUMBERS_SIZE = 6;
    private final List<LottoNumber> lottoNumbers = new ArrayList<>();
    private static final List<Integer> baseLottoNumbers = IntStream.rangeClosed(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX).boxed().collect(Collectors.toList());

    public Lotto(List<Integer> numbers) {
        validateLottoSize(numbers);
        for (int number : numbers) {
            LottoNumber lottoNumber = new LottoNumber(number);
            duplicateLottoNumbers(lottoNumber);
            lottoNumbers.add(lottoNumber);
        }
        Collections.sort(lottoNumbers);
    }

    public static Lotto createLotto() {
        Collections.shuffle(baseLottoNumbers);
        return new Lotto(baseLottoNumbers.subList(0,LOTTO_NUMBERS_SIZE));
    }

    private void validateLottoSize(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(LottoMessage.ERROR_LOTTO_SIZE);
        }
    }

    private void duplicateLottoNumbers(LottoNumber lottoNumber) {
        if (lottoNumbers.contains(lottoNumber)) {
            throw new IllegalArgumentException(LottoMessage.ERROR_LOTTO_DUPLICATE_NUMBER);
        }
    }

    public List<Integer> lottoNumbers() {
        return lottoNumberIntList(lottoNumbers);
    }

    private List<Integer> lottoNumberIntList(List<LottoNumber> lottoNumbers) {
        List<Integer> list = new ArrayList<>();
        for(LottoNumber lottoNumber : lottoNumbers) {
            list.add(lottoNumber.getLottoNumber());
        }
        return list;
    }

    private int countMatchNumber(Lotto winLotto) {
        return (int) lottoNumbers.stream()
                .filter(winLotto.lottoNumbers::contains)
                .count();
    }

    private boolean matchBonus(LottoNumber bonus) {
        return lottoNumbers.contains(bonus);
    }

    public void duplicateWinBonus(LottoNumber bonusNumber) {
        if (lottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(LottoMessage.ERROR_MESSAGE_DUPLICATE_BONUS_WIN);
        }
    }

    public Rank findRank(Lotto winLotto, LottoNumber bonus) {
        return Rank.valueOf(countMatchNumber(winLotto), matchBonus(bonus));
    }
}
