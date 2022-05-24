package lotto.interfaces.dto;

import lotto.domain.LottoNumber;
import lotto.domain.LottoRank;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoResponse {

    public static class PurchasedLottoResultDto {
        private final int lottoCount;
        private final List<LottoResponse.LottoDto> lottoDtos;

        public PurchasedLottoResultDto(final LottoTickets lottoTickets) {
            this.lottoCount = lottoTickets.getLottoTicketsCount().getLottoCount();
            this.lottoDtos = convertLottoDtos(lottoTickets.getValue());
        }

        public int getLottoCount() {
            return lottoCount;
        }

        public List<LottoResponse.LottoDto> getLottoDtos() {
            return lottoDtos;
        }

        private List<LottoResponse.LottoDto> convertLottoDtos(final List<LottoTicket> lottoTickets) {
            return lottoTickets.stream()
                    .map(lottoTicket -> lottoTicket.getLottoNumbers())
                    .map(lottoNumbers -> new LottoDto(lottoNumbers))
                    .collect(Collectors.toList());
        }
    }

    public static class LottoConfirmResult {
        private final Map<LottoRank, Integer> rankCount;
        private final double yield;

        public LottoConfirmResult(Map<LottoRank, Integer> rankCount, double yield) {
            this.rankCount = rankCount;
            this.yield = yield;
        }

        public Map<LottoRank, Integer> getRankCount() {
            return rankCount;
        }

        public double getYield() {
            return yield;
        }
    }

    public static class LottoDto {
        private final List<Integer> lottoNumbers;

        public LottoDto(final List<LottoNumber> lottoNumbers) {
            this.lottoNumbers = lottoNumbers.stream()
                    .map(LottoNumber::getLottoNumber)
                    .collect(Collectors.toList());
        }

        public List<Integer> getLottoNumbers() {
            return lottoNumbers;
        }

        @Override
        public String toString() {
            return lottoNumbers.toString();
        }
    }
}
