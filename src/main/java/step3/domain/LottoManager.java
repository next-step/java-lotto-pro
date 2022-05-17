package step3.domain;

import static java.util.Collections.shuffle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import step3.enums.LottoReward;

public class LottoManager {

    private List<LottoTicket> lottoTickets = new ArrayList<>();
    private final int MATCH_COUNT_BASE = 0;
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
        return tickets;
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

    public HashMap<LottoReward, Integer> checkWin(LottoTicket winLotto, LottoElement bonusNumber) {
        LinkedHashMap<LottoReward, Integer> statistics = new LinkedHashMap<>();
        initStatistics(statistics);
        for (LottoTicket lottoTicket : lottoTickets) {
            int matchNumber = lottoTicket.getMatchCountWith(winLotto.getLottoNumbers());
            int matchBonus = lottoTicket.getMatchCountWith(Arrays.asList(bonusNumber));
            LottoReward lottoReward = LottoReward.valueOf(matchNumber + matchBonus, matchBonus == 1);
            statistics.replace(lottoReward, statistics.get(lottoReward) + 1);
        }
        return statistics;
    }

    private void initStatistics(LinkedHashMap<LottoReward, Integer> statistics) {
        for (LottoReward lottoReward : LottoReward.values()) {
            statistics.put(lottoReward, MATCH_COUNT_BASE);
        }
    }


    public List<List<LottoElement>> getLottoNumbers() {
        return lottoTickets.stream().map(LottoTicket::getLottoNumbers).collect(Collectors.toList());
    }
}
