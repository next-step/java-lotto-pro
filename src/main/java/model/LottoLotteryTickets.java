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
            LottoNumbers lottoNumber = new LottoNumbers(lottoNumberGenerator);

            lottoLotteryTickets.add(lottoNumber);
        }
    }

    public int size() {
        return this.lottoLotteryTickets.size();
    }

    public Result matchResult(LottoNumbers winningLottoNumbers) {
        Map<Match, Integer> lottoResults = new HashMap<>();

        for (LottoNumbers lottoNumbers : lottoLotteryTickets) {
            Match match = Match.findMatch(lottoNumbers.match(winningLottoNumbers));
            lottoResults.put(match, lottoResults.getOrDefault(match, RESULT_DEFAULT_VALUE) + RESULT_ADD_VALUE );
        }

        return new Result(lottoResults);
    }

    @Override
    public String toString() {
        return lottoLotteryTickets.stream()
                .map(LottoNumbers::toString)
                .collect(Collectors.joining("\n"));
    }
}
