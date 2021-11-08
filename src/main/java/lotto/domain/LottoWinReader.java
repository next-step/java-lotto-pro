package lotto.domain;

import java.util.*;

import static java.util.stream.Collectors.toList;

public class LottoWinReader {

    private static final String NUMBER_OVERLAP_ERROR_MESSAGE = "기존의 로또 번호와 보너스번호가 중복됩니다.";
    private final Lotto winLotto;
    private LottoNumber bonusNumber;

    public LottoWinReader(List<Integer> numbers, int bonusNumber) {
        validateBonusNumber(numbers, bonusNumber);
        this.winLotto = new Lotto(numbers);
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    public static LottoWinReader make(String lottoNumbers, String bonusLottoNumber) {
        List<Integer> numbers = Arrays.stream(lottoNumbers.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .distinct()
                .collect(toList());

        return new LottoWinReader(numbers, Integer.parseInt(bonusLottoNumber));
    }

    private void validateBonusNumber(List<Integer> numbers, int bonusNumber) {
        if(numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(NUMBER_OVERLAP_ERROR_MESSAGE);
        }
    }

    public LottoStatistic distinguish(Lottos lottos) {
        Map<Winnings, Integer> statistic = new EnumMap<>(Winnings.class);
        for(Lotto lotto : lottos)
        {
            statistic.merge(lotto.acquireWinnings(winLotto, bonusNumber), 1, (oldValue, newValue) -> oldValue + 1);
        }
        return new LottoStatistic(statistic);
    }

}
