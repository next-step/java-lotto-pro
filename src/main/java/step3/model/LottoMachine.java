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
    private static final String DUPLICATE_NUMBER_MESSAGE = "고유한 번호만 허용합니다";

    public LottoMachine(LottoMoney lottoMoney, Lottos lottos) {
        this.lottoMoney = lottoMoney;
        this.lottos = lottos;
    }

    public LottoResultDto getLottoResult(List<LottoNumber> winningNumbers) {
        validateLottoNumbers(winningNumbers);
        Map<Rank, Integer> rankOfLottos = lottos.getRankOfLottos(winningNumbers);
        return getLottoResultDto(rankOfLottos);
    }

    public LottoResultDto getLottoResult(List<LottoNumber> winningNumbers, LottoNumber bonusNumber) {
        validateLottoNumbers(winningNumbers);
        validateBonusNumbers(winningNumbers, bonusNumber);
        Map<Rank, Integer> rankOfLottos = lottos.getRankOfLottos(winningNumbers, bonusNumber);
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

    private void validateLottoNumbers(List<LottoNumber> winningNumbers) {
        if (new HashSet(winningNumbers).size() != winningNumbers.size())
            throw new IllegalArgumentException(DUPLICATE_NUMBER_MESSAGE);
    }

    private void validateBonusNumbers(List<LottoNumber> winningNumbers, LottoNumber bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) throw new IllegalArgumentException(DUPLICATE_NUMBER_MESSAGE);
    }

    private double getPriceRatio(Map<Rank, Integer> rankOfLottos) {
        int sumOfRankPrice = Arrays.stream(Rank.values())
                .mapToInt(rank -> rank.getWinningPrice() * rankOfLottos.getOrDefault(rank, 0))
                .sum();
        return lottoMoney.getPriceRatio(sumOfRankPrice);
    }
}
