package lotto.model;

public class LottoCount {
    private final int maxLottoCount;
    private int countOfManualLotto;
    private static final int ZERO_SIZE = 0;

    public LottoCount(final int maxLottoCount) {
        this.maxLottoCount = maxLottoCount;
    }

    public void purchaseManualLottoTicket(final String countOfManualLotto) {
        this.countOfManualLotto = invalidInputCheck(countOfManualLotto);
        invalidCountCheck();
    }

    public int purchaseAutoLottoTicket() {
        return maxLottoCount - countOfManualLotto;
    }

    private int invalidInputCheck(String countOfManualLotto) {
        try {
            return Integer.parseInt(countOfManualLotto);
        } catch (Exception e) {
            throw new IllegalArgumentException("유효하지 않은 값입니다.");
        }
    }

    private void invalidCountCheck() {
        if (countOfManualLotto < ZERO_SIZE) {
            throw new IllegalArgumentException("구입 장수는 0이상의 정수 입니다.");
        }

        if (countOfManualLotto > maxLottoCount) {
            throw new IllegalArgumentException("구입 가능한 최대 장수를 초과하였습니다.");
        }
    }
}
