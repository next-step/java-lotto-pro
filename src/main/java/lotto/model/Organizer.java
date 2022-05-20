package lotto.model;

import java.util.*;
import java.util.stream.Collectors;

public class Organizer {
    private static final int COMPARE_TRUE = 1;
    private static final int COMPARE_FALSE = 0;
    private static final int INIT_RESULT_COUNT = 0;

    private final List<Integer> winnerNumbers;
    private final int bonusNumber;
    private Map<Rank, Integer> winningResults;
    private long totalWinningMoney;

    public Organizer(String number, int bonus) {
        winnerNumbers = checkWinningNumber(number);
        bonusNumber = checkBonusNumber(winnerNumbers, bonus);
    }

    public int userNumberSameCount(Lotto lotto) {
        int sameCount = 0;
        for (int number : lotto.seeNumbers()) {
            sameCount += compare(number);
        }
        return sameCount;
    }

    public boolean sameBonusNumber(Lotto lotto) {
        return lotto.seeNumbers().contains(this.bonusNumber);
    }

    public Map<Rank, Integer> winningResults(Lottos lottos) {
        initWinningResult();
        for (Lotto lotto : lottos.allGames()) {
            countWinning(userNumberSameCount(lotto), sameBonusNumber(lotto));
        }
        return winningResults;
    }

    public String winningRate(int buyAmount) {
        return String.format("%.2f", Math.floor((double) this.totalWinningMoney / buyAmount * 100) / 100);
    }

    private List<Integer> checkWinningNumber(String numbersText) {
        String[] numbers = numbersText.split(",");
        if (numbers.length != 6) {
            throw new IllegalArgumentException("당첨 번호는 6개 입력해야합니다.");
        }

        if (Arrays.stream(numbers).anyMatch(number -> number.matches("[^0-9]+"))) {
            throw new IllegalArgumentException("당첨 번호는 슷자만 입력가능합니다.");
        }

        if (Arrays.stream(numbers).distinct().count() != numbers.length) {
            throw new IllegalArgumentException("중복된 숫자는 입력 불가합니다.");
        }
        return Arrays.stream(numbers).map(String::trim).map(Integer::parseInt).collect(Collectors.toList());
    }

    private int checkBonusNumber(List<Integer> winnerNumbers, int bonusNumber) {
        if (winnerNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨번호와 달라야합니다.");
        }
        return bonusNumber;
    }

    private void initWinningResult() {
        this.winningResults = new LinkedHashMap<>();
        for (Rank rank : Rank.values()) {
            winningResults.put(rank, INIT_RESULT_COUNT);
        }
    }

    private void countWinning(int sameCount, boolean sameBonusNumber) {
        if (sameCount < Rank.FIFTH.sameCount()) {
            return;
        }
        Rank winningRank = Rank.matchCountOf(sameCount, sameBonusNumber);
        this.totalWinningMoney += winningRank.winningMoney();
        this.winningResults.put(winningRank, this.winningResults.get(winningRank) + 1);
    }

    private int compare(int number) {
        return this.winnerNumbers.contains(number) ? COMPARE_TRUE : COMPARE_FALSE;
    }
}
