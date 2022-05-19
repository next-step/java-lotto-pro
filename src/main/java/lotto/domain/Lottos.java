package lotto.domain;

import static lotto.constants.LottoConstants.SPLIT_SYMBOL;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.constants.LottoConstants;
import lotto.domain.validator.LottoNumbersValidatorGroup;

public class Lottos {

    private final List<Lotto> lottos;
    private static final LottoNumbersValidatorGroup validatorGroup = LottoNumbersValidatorGroup.getInstance();

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Lottos(List<String> lottos, Price price) {
        lottos.forEach(validatorGroup::validate);
        price.spend(LottoConstants.LOTTO_PRICE * lottos.size());

        this.lottos = lottos.stream()
            .map(Lottos::splitLottoNumbers)
            .collect(Collectors.toList());
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public LottoScore calculateLottoScore(WinningNumbers winningNumbers) {
        LottoScore lottoScore = new LottoScore();

        lottos.forEach(lotto -> {
            int countOfMatch = lotto.getWinningOfNumbersCount(winningNumbers);
            Rank rank = Rank.valueOf(countOfMatch, winningNumbers.isContainsBonusNumber(lotto));
            lottoScore.addScore(rank);
        });

        return lottoScore;
    }

    public static Lottos merge(Lottos manual, Lottos auto) {
        List<Lotto> lottos = new ArrayList<>();
        lottos.addAll(manual.getLottos());
        lottos.addAll(auto.getLottos());
        return new Lottos(lottos);
    }

    public int size() {
        return this.lottos.size();
    }

    private static Lotto splitLottoNumbers(String lottoNumbers) {
        List<LottoNo> numbers = Stream.of(lottoNumbers.split(SPLIT_SYMBOL))
            .map(LottoNo::new)
            .collect(Collectors.toList());

        return new Lotto(numbers);
    }
}
