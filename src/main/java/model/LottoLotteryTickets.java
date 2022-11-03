package model;

import enums.Match;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static model.Result.RESULT_ADD_VALUE;
import static model.Result.RESULT_DEFAULT_VALUE;

public class LottoLotteryTickets {

    List<LottoNumbers> lottoLotteryTickets = new ArrayList<>();

    public LottoLotteryTickets(int lottoQuantity, LottoNumberGenerator lottoNumberGenerator) {
        for (int i = 0; i < lottoQuantity; i++) {
            LottoNumbers lottoNumbers = new LottoNumbers(lottoNumberGenerator);

            lottoLotteryTickets.add(lottoNumbers);
        }
    }

    public LottoLotteryTickets(List<LottoNumbers> lottoLotteryTickets) {
        this.lottoLotteryTickets = new ArrayList<>(lottoLotteryTickets);
    }

    public int size() {
        return this.lottoLotteryTickets.size();
    }

    public Result matchResult(WinningLottoNumbers winningLottoNumbers) {
        Map<Match, Integer> lottoResults = new HashMap<>();

        for (LottoNumbers lottoNumbers : lottoLotteryTickets) {
            int matchCount = winningLottoNumbers.matchExceptBonusBall(lottoNumbers);
            boolean isMatchBonusBall = lottoNumbers.containLottoNumber(winningLottoNumbers.getBonusBall());
            Match match = Match.findMatch(matchCount, isMatchBonusBall);
            int matchAccumlatingCount = lottoResults.getOrDefault(match, RESULT_DEFAULT_VALUE) + RESULT_ADD_VALUE;
            lottoResults.put(match, matchAccumlatingCount);
        }

        return new Result(lottoResults);
    }

    public static LottoLotteryTickets createLottoLotteryTickets(LottoLotteryTickets manualLottoLotteryTickets, int autoLottoCount) {
        List<LottoNumbers> lottoLotteryTickets = new ArrayList<>(manualLottoLotteryTickets.lottoLotteryTickets);
        for(int i = 0; i < autoLottoCount; i++) {
            lottoLotteryTickets.add(new LottoNumbers(new LottoNumberGenerator()));
        }

        return new LottoLotteryTickets(lottoLotteryTickets);
    }

    @Override
    public String toString() {
        return lottoLotteryTickets.stream()
                .map(LottoNumbers::toString)
                .collect(Collectors.joining("\n"));
    }
}
