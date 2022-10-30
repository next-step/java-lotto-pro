package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lottos {

    private static final String LOTTOS_NULL_OR_EMPTY_OR_ZERO_MESSAGE = "로또 목록은 Null, 빈 값, 0은 불가 합니다.";

    private static final int LOTTO_AMOUNT = 1000;

    private final List<Lotto> lottos;

    private Lottos(final List<Lotto> lottos) {
        validate(lottos);
        this.lottos = lottos;
    }

    public static Lottos from(final List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    private void validate(final List<Lotto> lottos) {
        validateNotNullOrEmpty(lottos);
    }

    private void validateNotNullOrEmpty(final List<Lotto> lottos) {
        if (Objects.isNull(lottos) || lottos.isEmpty() || lottos.size() == 0) {
            throw new IllegalArgumentException(LOTTOS_NULL_OR_EMPTY_OR_ZERO_MESSAGE);
        }
    }

    public Map<LottoRank, Integer> lottoRanksInfo(final WinningLotto winningLotto) {
        Map<LottoRank, Integer> rankInfo = generateRankInfo();

        for (LottoRank lottoRank: lottoRanks(winningLotto)) {
            rankInfo.put(lottoRank, lottoRanksCount(rankInfo, lottoRank));
        }

        return rankInfo;
    }

    private List<LottoRank> lottoRanks(final WinningLotto winningLotto) {
        List<LottoRank> lottoRanks = new ArrayList<>();
        for (Lotto lotto: lottos) {
            int countMatch = lotto.matchLottoNumber(winningLotto.getWinningLotto());
            lottoRanks.add(LottoRank.valueOf(countMatch, lotto.matchBounsNumber(winningLotto.getBonusBall())));
        }
        return lottoRanks.stream()
            .filter(lottoRank -> !LottoRank.isNone(lottoRank))
            .collect(Collectors.toList());
    }

    private int lottoRanksCount(final Map<LottoRank, Integer> rankInfo, final LottoRank lottoRank) {
        if (rankInfo.containsKey(lottoRank)) {
            return rankInfo.get(lottoRank) + LottoNumber.LOTTO_MIN_NUMBER;
        }
        return LottoNumber.LOTTO_MIN_NUMBER;
    }

    private Map<LottoRank, Integer> generateRankInfo() {
        Map<LottoRank, Integer> rankInfo = new HashMap<>();

        for (LottoRank lottoRank: LottoRank.reverse()) {
            rankInfo.put(lottoRank, 0);
        }

        return rankInfo;
    }

    public int size() {
        return this.lottos.size();
    }

    public int buyAmount() {
        return this.lottos.size() * LOTTO_AMOUNT;
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }
}
