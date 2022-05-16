package step3.domain;

import static java.util.Collections.shuffle;
import static step3.enums.LottoReward.numberToLottoReward;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import step3.enums.LottoReward;

public class LottoManager {

    private List<LottoTicket> lottoTickets = new ArrayList<>();
    private final int LOTTO_MIN = 1;
    private final int LOTTO_MAX = 46;
    private final int LOTTO_ELEMENTS_SIZE = 6;
    private List<Integer> LOTTO_VALID_ELEMENTS = IntStream.rangeClosed(LOTTO_MIN, LOTTO_MAX).boxed().collect(Collectors.toList());

    public LottoManager() {
    }

    public LottoManager(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }


    public int buyRandomTicket(int tickets) {
        for (int i = 0; i < tickets; i++) {
            lottoTickets.add(makeRandomLottoTicket());
        }
        return lottoTickets.size();
    }


    private LottoTicket makeRandomLottoTicket() {
        List<Integer> lottoElements = new ArrayList<>();
        shuffle(LOTTO_VALID_ELEMENTS);
        for (int i = 0; i < LOTTO_ELEMENTS_SIZE; i++) {
            lottoElements.add(LOTTO_VALID_ELEMENTS.get(i));
        }
        return new LottoTicket(lottoElements.stream().map(String::valueOf).collect(Collectors.toList()));
    }

    public LottoTicket makeManualLottoTicket(String manualLottoSource) {
        return new LottoTicket(manualLottoSource);
    }

    public HashMap<String, Integer> checkWin(LottoTicket winLotto) {
        LinkedHashMap<String, Integer> statistics = new LinkedHashMap<>();
        initStatistics(statistics);
        for (LottoTicket lottoTicket : lottoTickets) {
            String matchCount = numberToLottoReward.get(winLotto.getMatchCountWith(lottoTicket));
            statistics.replace(matchCount, statistics.get(matchCount) + 1);
        }
        return statistics;
    }

    private void initStatistics(LinkedHashMap<String, Integer> statistics) {
        for (LottoReward lottoReward : LottoReward.values()) {
            statistics.put(lottoReward.name(), 0);
        }
    }


    public List<List<String>> getLottoNumbers() {
        return lottoTickets.stream().map(LottoTicket::getLottoNumbers)
            .collect(Collectors.toList());
    }
}
