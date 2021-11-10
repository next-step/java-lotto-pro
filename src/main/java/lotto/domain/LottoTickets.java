package lotto.domain;

import lotto.dto.LottoTicketsDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTickets {
    private final List<LottoTicket> lottoTickets;

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public static LottoTickets generateRandomLottoTickets(int amount) {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            lottoTickets.add(LottoTicket.generateRandomLottoTicket());
        }
        return new LottoTickets(lottoTickets);
    }

    public int count() {
        return lottoTickets.size();
    }

    public GameResult getGameResult(LottoTicket winningNumber) {
        GameResult gameResult = new GameResult();
        for (LottoTicket lottoTicket : lottoTickets) {
            Prize prize = lottoTicket.getPrize(winningNumber);
            gameResult.add(prize);
        }
        return gameResult;
    }

    public LottoTicketsDTO toDTO() {
        return new LottoTicketsDTO(lottoTickets.stream()
                .map(LottoTicket::toDTO)
                .collect(Collectors.toList()));
    }
}
