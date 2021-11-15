package study.lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbers {

    private static final int MISS = 0;
    private static final int MINIMUM_MATCH_COUNT = 3;
    private static final int SECOND_RANK_OPPORTUNITY_COUNT = 5;

    private static final int MIN_LOTTO_COUNT = 0;
    private static final int MAX_LOTTO_COUNT = 6;

    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers() {
        List<LottoNumber> totalLottoNumber = generateTotalLottoNumber();
        Collections.shuffle(totalLottoNumber);
        List<LottoNumber> lottoNumbers = totalLottoNumber.subList(MIN_LOTTO_COUNT, MAX_LOTTO_COUNT);
        Collections.sort(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public LottoNumbers(String readLastLottoNumbers) {
        String[] split = readLastLottoNumbers.split(",");
        lottoNumbers = new ArrayList<>();
        for(String s : split) {
            lottoNumbers.add(new LottoNumber(Integer.parseInt(s)));
        }
    }

    private List<LottoNumber> generateTotalLottoNumber() {
        return IntStream.range(LottoNumber.MIN_LOTTO_NUMBER, LottoNumber.MAX_LOTTO_NUMBER + 1)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public Rank match(LottoNumbers thisWeekLottoNumbers, LottoNumber bonusBall) {

        Match match = new Match();
        for(LottoNumber lottoNumber : thisWeekLottoNumbers.getLottoNumbers()){
            matchAndIncreaseCount(lottoNumber, match);
        }

        checkBonusBall(match, bonusBall);
        checkMatchCount(match);
        return Rank.valueOf(match.getCount(), match.getMatchBonus());
    }

    private void matchAndIncreaseCount(LottoNumber lottoNumber, Match match) {
        if(isContain(lottoNumber)) {
            match.increaseCount();
        }
    }

    private boolean isContain(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    private void checkBonusBall(Match match, LottoNumber bonusBall) {
        if(match.getCount() == SECOND_RANK_OPPORTUNITY_COUNT) {
            match.setMatchBonus(isContain(bonusBall));
        }
    }

    private void checkMatchCount(Match match) {
        if(match.getCount() < MINIMUM_MATCH_COUNT) {
            match.setCount(MISS);
        }
    }

    public List<LottoNumber> getLottoNumbers() {
        return this.lottoNumbers;
    }
}
