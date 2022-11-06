package step3.model;

import step3.service.LottoScoreType;

public class LottoResult {
    private static final double TWO_POINT_POSITION = 100;

    protected int threeMatchedCount;
    protected int fourMatchedCount;
    protected int fiveMatchedCount;
    protected int fiveBonusMatchedCount;
    protected int sixMatchedCount;

    public LottoResult() {
    }

    public LottoResult(int threeMatchedCount, int fourMatchedCount, int fiveMatchedCount, int sixMatchedCount) {
        this.threeMatchedCount = threeMatchedCount;
        this.fourMatchedCount = fourMatchedCount;
        this.fiveMatchedCount = fiveMatchedCount;
        this.sixMatchedCount = sixMatchedCount;
    }

    public static LottoResult generateFromLottos(Lottos lottos, Lotto winningLotto) {
        LottoResult lottoResult = new LottoResult();
        lottos.stream().forEach(lotto -> {
            int matchedCount = winningLotto.getMatchedCount(lotto);
            boolean matchedBonus = winningLotto.isMatchedBonus(lotto);
            lottoResult.addByLottoScoreType(LottoScoreType.getByScore(matchedCount, matchedBonus));
        });

        return lottoResult;
    }

    public int getByLottoScoreType(LottoScoreType scoreType) {
        if (scoreType == null) {
            return 0;
        }

        if (LottoScoreType.THREE.equals(scoreType)) {
            return threeMatchedCount;
        }

        if (LottoScoreType.FOUR.equals(scoreType)) {
            return fourMatchedCount;
        }

        if (LottoScoreType.FIVE.equals(scoreType)) {
            return fiveMatchedCount;
        }

        if (LottoScoreType.FIVE_BONUS.equals(scoreType)) {
            return fiveBonusMatchedCount;
        }

        if (LottoScoreType.SIX.equals(scoreType)) {
            return sixMatchedCount;
        }

        return 0;
    }

    public void addByLottoScoreType(LottoScoreType scoreType) {
        if (scoreType == null) {
            return;
        }

        if (LottoScoreType.THREE.equals(scoreType)) {
            this.threeMatchedCount++;
        }

        if (LottoScoreType.FOUR.equals(scoreType)) {
            this.fourMatchedCount++;
        }

        if (LottoScoreType.FIVE.equals(scoreType)) {
            this.fiveMatchedCount++;
        }

        if (LottoScoreType.FIVE_BONUS.equals(scoreType)) {
            this.fiveBonusMatchedCount++;
        }

        if (LottoScoreType.SIX.equals(scoreType)) {
            this.sixMatchedCount++;
        }
    }

    public double getProfitRate(int money) {
        int totalBenefit = 0;
        for (LottoScoreType scoreType : LottoScoreType.values()) {
            totalBenefit += (getByLottoScoreType(scoreType) * scoreType.getMoney());
        }

        return Math.floor(((double) totalBenefit / money * TWO_POINT_POSITION)) / TWO_POINT_POSITION;
    }
}
