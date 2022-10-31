package step3.model;

import step3.model.dto.LottoResultDto;
import step3.model.dto.LottosNumberDto;
import step3.model.dto.RankDto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoMachine {

    private final Lottos lottos;
    private final LottoMoney lottoMoney;

    public LottoMachine(LottoMoney lottoMoney, Lottos lottos) {
        this.lottoMoney = lottoMoney;
        this.lottos = lottos;
    }

    public LottoResultDto getLottoResult(Lotto lotto) {
        Map<Rank, Integer> rankOfLottos = lottos.getRankOfLottos(lotto);
        return getLottoResultDto(rankOfLottos);
    }

    public LottoResultDto getLottoResult(WinningLotto winningLotto) {
        Map<Rank, Integer> rankOfLottos = lottos.getRankOfLottos(winningLotto);
        return getLottoResultDto(rankOfLottos);
    }

    private LottoResultDto getLottoResultDto(Map<Rank, Integer> rankOfLottos) {
        List<RankDto> rankDtos = getRanks(rankOfLottos);
        double getPriceRatio = getPriceRatio(rankOfLottos);
        return new LottoResultDto(rankDtos, getPriceRatio);
    }

    public LottosNumberDto getLottoNumber() {
        return new LottosNumberDto(lottos);
    }

    private List<RankDto> getRanks(Map<Rank, Integer> rankOfLottos) {
        return Arrays.stream(Rank.values())
                .map(rank -> new RankDto(rank, rankOfLottos.getOrDefault(rank, 0)))
                .collect(Collectors.toList());
    }

    private double getPriceRatio(Map<Rank, Integer> rankOfLottos) {
        int sumOfRankPrice = Arrays.stream(Rank.values())
                .mapToInt(rank -> rank.getWinningPrice() * rankOfLottos.getOrDefault(rank, 0))
                .sum();
        return lottoMoney.getPriceRatio(sumOfRankPrice);
    }
}
