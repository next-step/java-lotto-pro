package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTickets {
    public static final String SPLIT_DELIMITER = ",";
    public static final String JOIN_DELIMITER = "\n";
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

    public static LottoTicket fromString(String inputWinningNumber) {
        return new LottoTicket(Arrays.stream(inputWinningNumber
                        .split(SPLIT_DELIMITER))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList()));
    }

    public int count() {
        return lottoTickets.size();
    }

    public String toResultString() {
        List<String> resultStrings = lottoTickets.stream()
                .map(LottoTicket::toResultString)
                .collect(Collectors.toList());
        return String.join(JOIN_DELIMITER, resultStrings);
    }

    public GameResult getGameResult(LottoTicket winningNumber) {
        GameResult gameResult = new GameResult();
        for (LottoTicket lottoTicket : lottoTickets) {
            int sameNumberCount = lottoTicket.getSameNumberCount(winningNumber);
            gameResult.add(sameNumberCount);
        }
        return gameResult;
    }
}
