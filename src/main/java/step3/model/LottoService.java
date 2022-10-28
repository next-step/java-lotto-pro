package step3.model;

import step3.model.dto.LottoResultDto;
import step3.model.dto.LottosNumberDto;
import step3.model.dto.RankDto;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoService {

    private final int purchasePrice;
    private final Lottos lottos;
    private static final String DUPLICATE_NUMBER_MESSAGE = "보너스번호는 유일한 번호만 허용합니다";

    public LottoService(int purchasePrice) {
        this.purchasePrice = purchasePrice;
        int size = purchasePrice / Lotto.PRICE;
        this.lottos = new Lottos(LottoFactory.createLottos(size));
    }

    public LottoResultDto getLottoResult(List<LottoNumber> winningNumbers) {
        Map<Rank, Integer> rankOfLottos = lottos.getRankOfLottos(winningNumbers);
        List<RankDto> rankDtos = getRanks(rankOfLottos);
        return new LottoResultDto(rankDtos, purchasePrice);
    }

    public LottoResultDto getLottoResult(List<LottoNumber> winningNumbers, LottoNumber bonusNumber) {
        validateLottoNumbers(winningNumbers,bonusNumber);
        Map<Rank, Integer> rankOfLottos = lottos.getRankOfLottos(winningNumbers, bonusNumber);
        List<RankDto> rankDtos = getRanks(rankOfLottos);
        return new LottoResultDto(rankDtos, purchasePrice);
    }

    public LottosNumberDto getLottoNumber() {
        return new LottosNumberDto(lottos.getNumbersOfLottos());
    }

    private List<RankDto> getRanks(Map<Rank, Integer> rankOfLottos) {
        return Arrays.stream(Rank.values())
                .map(rank -> new RankDto(rank, rankOfLottos.getOrDefault(rank, 0)))
                .collect(Collectors.toList());
    }

    private void validateLottoNumbers(List<LottoNumber> winningNumbers, LottoNumber bonusNumber){
        if(winningNumbers.contains(bonusNumber)){
            throw new IllegalArgumentException(DUPLICATE_NUMBER_MESSAGE);
        }

    }
}
