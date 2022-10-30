package step3.model;

import step3.model.dto.LottoResultDto;
import step3.model.dto.LottosNumberDto;
import step3.model.dto.RankDto;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoMachine {

    private final int purchasePrice;
    private final Lottos lottos;
    private static final int LOTTO_PRICE = 1000;
    private static final String INVALID_PRICE_UNIT_MESSAGE = "금액은 1000원 단위로 입력해야합니다";
    private static final String INVALID_MINIMUN_PRICE_MESSAGE = "금액은 최소 1000원이상 입력해야합니다";

    public LottoMachine(int purchasePrice) {
        validatePurchasePrice(purchasePrice);
        this.purchasePrice = purchasePrice;
        int size = purchasePrice / LOTTO_PRICE;
        this.lottos = new Lottos(LottoFactory.createLottos(size), LOTTO_PRICE);
    }

    private void validatePurchasePrice(int purchasePrice) {
        if (purchasePrice < LOTTO_PRICE) throw new IllegalArgumentException(INVALID_MINIMUN_PRICE_MESSAGE);
        if (purchasePrice % LOTTO_PRICE != 0) throw new IllegalArgumentException(INVALID_PRICE_UNIT_MESSAGE);
    }

    public LottoResultDto getLottoResult(List<LottoNumber> winningNumbers) {
        Map<Rank, Integer> rankOfLottos = lottos.getRankOfLottos(winningNumbers);
        List<RankDto> rankDtos = getRanks(rankOfLottos);
        double getPriceRatio = getPriceRatio(rankOfLottos, purchasePrice);
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

    private double getPriceRatio(Map<Rank, Integer> rankOfLottos, int purchasePrice) {
        int sumOfRankPrice = Arrays.stream(Rank.values())
                .mapToInt(rank -> rank.getWinningPrice() * rankOfLottos.getOrDefault(rank, 0))
                .sum();
        return sumOfRankPrice / (double) purchasePrice;
    }
}
