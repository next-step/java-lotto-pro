package step3;

import java.util.*;

public class LottoMachine {
    private static final int DEFAULT_TICKET_PRICE = 1000;
    private static final int DEFAULT_MIN_NUMBER = 1;
    private static final int DEFAULT_MAX_NUMBER = 45;
    private static final int DEFAULT_SCORE = 0;
    private static final int DEFAULT_LOTTO_COUNT = 6;
    private static final int TWO_POINT_POSITION = 100;

    private LottoGenerator lottoGenerator;
    private final int lottoPrice;

    public LottoMachine() {
        this.lottoGenerator = new LottoGenerator();
        this.lottoPrice = DEFAULT_TICKET_PRICE;
    }

    public int getBoughtLottoCount(int money) {
        if (money < this.lottoPrice) {
            throw new RuntimeException(lottoPrice - money + "만큼 부족합니다.");
        }

        return money / lottoPrice;
    }

    public List<List<Integer>> generateLotto(int count) {
        List<List<Integer>> lottos = new ArrayList<>();
        for (int lottoCount = 0 ; lottoCount < count ; lottoCount++) {
            List<Integer> lotto = lottoGenerator.generate(DEFAULT_LOTTO_COUNT, DEFAULT_MIN_NUMBER, DEFAULT_MAX_NUMBER);
            Collections.sort(lotto);
            lottos.add(lotto);
        }

        return lottos;
    }

    public List<LottoResult> getResultComparedToLuckyNumbers(String luckyNumberText, List<List<Integer>> lottos) {
        List<Integer> luckyNumbers = new ArrayList<>();

        for (String number : luckyNumberText.split(",")) {
            luckyNumbers.add(Integer.parseInt(number.trim()));
        }

        checkLuckyNumbers(luckyNumbers);
        return calculateLuckyResult(luckyNumbers, lottos);
    }

    private List<LottoResult> calculateLuckyResult(List<Integer> luckyNumbers, List<List<Integer>> lottos) {
        Map<Integer, Integer> lottoResult = new HashMap<>();
        for (List<Integer> lotto : lottos) {
            int matchedCount = 0;
            matchedCount = getMatchedCount(luckyNumbers, lotto, matchedCount);

            int count = lottoResult.getOrDefault(matchedCount, DEFAULT_SCORE);
            lottoResult.put(matchedCount, ++count);
        }

        return generateLottoResults(lottoResult);
    }

    private List<LottoResult> generateLottoResults(Map<Integer, Integer> lottoResult) {
        List<LottoResult> lottoResults = new ArrayList<>();
        for (KoreaLottoScoreType scoreType : KoreaLottoScoreType.values()) {
            int score = scoreType.getScore();
            int scoreMatchedCount = lottoResult.getOrDefault(score, DEFAULT_SCORE);
            int money = scoreType.getMoney();
            lottoResults.add(new LottoResult(score, scoreMatchedCount, money));
        }

        return lottoResults;
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
        if (number < DEFAULT_MIN_NUMBER || number > DEFAULT_MAX_NUMBER) {
            throw new RuntimeException("초과된 숫자가 있습니다.");
        }
    }

    private boolean isDuplicated(List<Integer> luckyNumbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(luckyNumbers);

        return uniqueNumbers.size() != luckyNumbers.size();
    }

    public double showRate(int money, List<LottoResult> lottoResults) {
        double totalMoney = 0.00;
        for (LottoResult lottoResult : lottoResults) {
            totalMoney += lottoResult.getTotalMoney();
        }

        return Math.floor((totalMoney / money * TWO_POINT_POSITION)) / TWO_POINT_POSITION;
    }
}
