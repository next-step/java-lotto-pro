package step3;

import java.util.*;

public class LottoMachine {
    private static final int DEFAULT_MINIMUM_NUMBER = 1;
    private static final int DEFAULT_MAXIMUM_NUMBER = 45;
    private static final int DEFAULT_SCORE = 0;

    private final int lottoPrice;
    private int lottoCount;
    private List<List<Integer>> havingLottos;
    private Map<Integer, Integer> lottoResult;

    public LottoMachine(int lottoPrice) {
        this.lottoPrice = lottoPrice;
        this.havingLottos = new ArrayList<>();
    }

    public LottoMachine(int lottoPrice, int money) {
        this.lottoPrice = lottoPrice;
        this.havingLottos = new ArrayList<>();

        receiveMoney(money);
    }

    public int receiveMoney(int money) {
        if (money < this.lottoPrice) {
            throw new RuntimeException(lottoPrice - money + "만큼 부족합니다.");
        }

        this.lottoCount = money / lottoPrice + lottoCount;

        return this.lottoCount;
    }

    public List<Integer> addLotto(List<Integer> lottoNumbers) {
        Collections.sort(lottoNumbers);
        this.havingLottos.add(lottoNumbers);

        return lottoNumbers;
    }

    public void receiveLuckLotto(List<Integer> luckyNumbers) {
        checkLuckyNumbers(luckyNumbers);

        calculateLuckyResult(luckyNumbers);
    }

    private void calculateLuckyResult(List<Integer> luckyNumbers) {
        for (List<Integer> lotto : this.havingLottos) {
            int matchedCount = 0;
            matchedCount = getMatchedCount(luckyNumbers, lotto, matchedCount);

            this.lottoResult = new HashMap<>();
            int count = this.lottoResult.getOrDefault(matchedCount, DEFAULT_SCORE);
            this.lottoResult.put(matchedCount, ++count);
        }
    }

    private int getMatchedCount(List<Integer> luckyNumbers, List<Integer> lotto, int matchedCount) {
        for (int luckyNumber : luckyNumbers) {
            matchedCount = getMatchedCount(lotto, luckyNumber, matchedCount);
        }

        return matchedCount;
    }

    private int getMatchedCount(List<Integer> lotto, int luckyNumber, int matchedCount) {
        if (lotto.contains(luckyNumber)) {
            matchedCount++;
        }

        return matchedCount;
    }

    private void checkLuckyNumbers(List<Integer> luckyNumbers) {
        if (luckyNumbers == null) {
            throw new RuntimeException("행운의번호가 널입니다.");
        }

        if (isDuplicated(luckyNumbers)) {
            throw new RuntimeException("증복된 숫자가 있습니다.");
        }

        isExceedRange(luckyNumbers);
    }

    private void isExceedRange(List<Integer> luckyNumbers) {
        for (int number : luckyNumbers) {
            isNotBetween(number);
        }
    }

    private void isNotBetween(int number) {
        if (number < DEFAULT_MINIMUM_NUMBER || number > DEFAULT_MAXIMUM_NUMBER) {
            throw new RuntimeException("초과된 숫자가 있습니다.");
        }
    }

    private boolean isDuplicated(List<Integer> luckyNumbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(luckyNumbers);

        return uniqueNumbers.size() != luckyNumbers.size();
    }

    public int showCountByScore(int score) {
        return this.lottoResult.getOrDefault(score, DEFAULT_SCORE);
    }
}
