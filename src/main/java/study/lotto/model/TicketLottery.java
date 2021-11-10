package study.lotto.model;

import java.util.List;
import java.util.Set;

public class TicketLottery {

    private final Lottery lottery;
    private final TicketLotteryType type;

    private TicketLottery(final Set<Integer> lottoNumbers, final TicketLotteryType type) {
        this.type = type;
        this.lottery = Lottery.valueOf(lottoNumbers);
    }

    private TicketLottery(final List<Integer> lottoNumbers, final String type) {
        this.type = TicketLotteryType.findByType(type);
        this.lottery = Lottery.valueOf(lottoNumbers);
    }

    public TicketLottery(final List<Integer> lottoNumbers, final TicketLotteryType type) {
        this.type = type;
        this.lottery = Lottery.valueOf(lottoNumbers);
    }

    public static TicketLottery valueOf(final Set<Integer> lottoNumbers, final TicketLotteryType type) {
        return new TicketLottery(lottoNumbers, type);
    }

    public static TicketLottery valueOf(final List<Integer> lottoNumbers, final String type) {
        return new TicketLottery(lottoNumbers, type);
    }

    public static TicketLottery valueOf(final List<Integer> lottoNumbers, final TicketLotteryType type) {
        return new TicketLottery(lottoNumbers, type);
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottery.contains(lottoNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TicketLottery that = (TicketLottery) o;

        if (lottery != null ? !lottery.equals(that.lottery) : that.lottery != null) return false;
        return type == that.type;
    }

    @Override
    public int hashCode() {
        int result = lottery != null ? lottery.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TicketLottery{" +
                "lottery=" + lottery +
                ", type=" + type +
                '}';
    }

    public Set<LottoNumber> getLottoNumbers() {
        return this.lottery.getLottoNumbers();
    }

    public TicketLotteryType getType() {
        return type;
    }

}
