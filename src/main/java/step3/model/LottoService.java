package step3.model;

import step3.model.dto.LottoStatusDto;
import step3.model.dto.LottosNumberDto;
import step3.model.dto.RankDto;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoService {

    private final int purchasePrice;
    private final Lottos lottos;

    public LottoService(int purchasePrice){
        this.purchasePrice = purchasePrice;
        int size = purchasePrice / Lotto.PRICE;
        this.lottos = new Lottos(LottoFactory.createLottos(size));
    }

    public LottoStatusDto getRankStatus(List<Integer> winningNumbers){
        Map<Rank,Integer> rankIntegerMap = lottos.getRankStatsOfLottos(winningNumbers);
        List<RankDto> rankDtos = Arrays.stream(Rank.values())
                .map(rank -> new RankDto(rank, rankIntegerMap.getOrDefault(rank, 0)))
                .collect(Collectors.toList());
        return new LottoStatusDto(rankDtos,purchasePrice);
    }


    public LottosNumberDto getLottoTicketState() {
        return new LottosNumberDto(lottos);
    }

}
