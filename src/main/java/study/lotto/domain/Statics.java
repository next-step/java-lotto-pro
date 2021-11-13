package study.lotto.domain;

public class Statics {

    private final Money money;
    private final LottoNumbersGroup lottoNumbersGroup;

    private double profitRate;

    public Statics(Money money) {
        this.money = money;
        this.lottoNumbersGroup = new LottoNumbersGroup(null);
    }

    public Statics(Money money, LottoNumbersGroup group) {
        this.money = money;
        this.lottoNumbersGroup = group;
        analyst();
        calculateProfitRate();
    }

    public static Statics valueOf(Money userInputMoney, LottoNumbersGroup lottoNumbersGroup) {
        return new Statics(userInputMoney, lottoNumbersGroup);
    }

    public void analyst() {
        LottoNumbers lastLottoNumbers = lottoNumbersGroup.getLastLottoNumbers();
        for(LottoNumbers lottoNumbers : lottoNumbersGroup.getLottoNumbersList()) {
            lastLottoNumbers.match(lottoNumbers, lottoNumbersGroup.getBonusBall());
        }
    }

    public void calculateProfitRate() {
        int totalPrize = 0;
        for (Rank rank : Rank.values()) {
            totalPrize += rank.getCorrect() * rank.getWinningMoney();
        }
        profitRate = Math.floor((double) totalPrize/money.getMoney()*100)/100;
    }

    public String makeStaticPrintFormat() {
        StringBuilder sb = new StringBuilder();

        for(Rank rank : Rank.values()) {
            sb.append(rank.makePrintFormat());
        }

        return sb.toString();
    }

    public String makeProfitPrintFormat() {
        return String.format("총 수익률은 %.2f입니다.", profitRate);
    }

    public double getProfitRate() {
        return profitRate;
    }
}
