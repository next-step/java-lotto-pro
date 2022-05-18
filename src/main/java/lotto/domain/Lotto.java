package lotto.domain;

import lotto.enums.LottoRank;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.common.Messages.LOTTO_MINIMUM_PRICE;

public class Lotto {
    private static final int PRICE = 1_000;
    private static final LottoRandomNumbers LOTTO_RANDOM_NUMBERS = new LottoRandomNumbers();

    private final List<LottoNumbers> purchasedLotto;

    public Lotto(List<LottoNumbers> purchasedLotto) {
        this.purchasedLotto = purchasedLotto;
    }

    public static List<LottoNumbers> generateLottoGame(int gameCount) {
        return generateLottoGame(gameCount, new ArrayList<>());
    }

    public static List<LottoNumbers> generateLottoGame(int gameCount, List<LottoNumbers> passiveLottoNumbers) {
        List<LottoNumbers> purchasedLotto = new ArrayList<>(passiveLottoNumbers);
        int lottoGameCount = gameCount - purchasedLotto.size();

        for (int i = 0; i < lottoGameCount; i++) {
            LottoNumbers lottoNumbers = new LottoNumbers(LOTTO_RANDOM_NUMBERS.generate());
            purchasedLotto.add(lottoNumbers);
        }

        return purchasedLotto;
    }

    public static int gameCount(Money money) {
        validateMinimumPrice(money.currentMoney());
        return money.currentMoney() / PRICE;
    }

    public static void validateMinimumPrice(int money) {
        if (money < PRICE) {
            throw new IllegalArgumentException(LOTTO_MINIMUM_PRICE);
        }
    }

    public List<LottoRank> gamePlay(LottoNumbers lastWeekWinningNumber, BonusBall bonusBall) {
        return purchasedLotto.stream()
                .map(lottoNumbers -> LottoRank.find(
                        lottoNumbers.containsCount(lastWeekWinningNumber),
                        lottoNumbers.containsBonusBall(bonusBall)
                ))
                .collect(Collectors.toList());
    }
}
