package study.temp.lotto.auto;

import java.util.Iterator;
import java.util.Map;

public class Statics {

    private final int COUNT_BASE = 3;

    //private final Map<Rank, Count> resultMap = new HashMap<>();
    private final RankCountResult rankCountResult = new RankCountResult();

    private Money money;
    private LottoNumbersGroup lottoNumbersGroup;
    private LottoNumbers lastLottoNumbers;
    private LottoNumber bonusBall;
    private double profitRate;

    public Statics() {

    }

    public Statics(Money money) {
        this();
        this.money = money;
    }

    public Statics(Money money, LottoNumbersGroup group, LottoNumbers last) {
        this();
        this.money = money;
        this.lottoNumbersGroup = group;
        this.lastLottoNumbers = last;
        analyst();
    }

    public Statics(Money userInputMoney, LottoNumbersGroup lottoNumbersGroup, LottoNumbers lastLottoNumbers, LottoNumber bonusBall) {
        this(userInputMoney, lottoNumbersGroup, lastLottoNumbers);
        this.bonusBall = bonusBall;
        analyst();
    }

    public void analyst() {
        for(LottoNumbers lottoNumbers : lottoNumbersGroup.getLottoNumbersList()) {
            lottoNumbers.match(lastLottoNumbers, bonusBall);
            writeResult2(lottoNumbers);
        }
        calculateProfitRate();
    }

    private void writeResult2(LottoNumbers lottoNumbers) {
        if(lottoNumbers.getCountOfMatch() >= COUNT_BASE) {
            rankCountResult.renew(Ranking.valueOf(lottoNumbers.getCountOfMatch(), lottoNumbers.getMatchBonus()));
        }
    }

    private void calculateProfitRate() {
        int totalPrize = 0;

        Map<Ranking, Count> countOfRank = rankCountResult.getCountOfRank();
        Iterator<Ranking> iterator = countOfRank.keySet().iterator();
        while (iterator.hasNext()) {
            Ranking rank = iterator.next();
            Count count = countOfRank.get(rank);

            totalPrize += count.getCount() * rank.getWinningMoney();
        }

        profitRate = Math.floor((double) totalPrize/money.getMoney()*100)/100;
    }

    public String makeStaticsPrintFormat() {
        StringBuilder sb = new StringBuilder();
        Map<Ranking, Count> countOfRank = rankCountResult.getCountOfRank();
        for(Ranking rank : Ranking.values()) {
            sb.append(String.format("%s %d개\n", rank.makePrintFormat(), rankCountResult.getCount(rank)));
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
