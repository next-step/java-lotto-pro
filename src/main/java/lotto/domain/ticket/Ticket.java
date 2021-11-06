package lotto.domain.ticket;

import lotto.domain.number.MatchedCount;

import java.util.List;
import java.util.Objects;

public class Ticket {
    private static final String NULL_EXCEPTION_STATEMENT = "입력값이 null입니다.";

    private final LottoNumbers lottoNumbers;

    private Ticket(LottoNumbers lottoNumbers) {
        validate(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private Ticket(List<Integer> lottoNumbers) {
        this.lottoNumbers = LottoNumbers.from(lottoNumbers);
    }

    public static Ticket from(LottoNumbers lottoNumbers) {
        return new Ticket(lottoNumbers);
    }

    public static Ticket from(List<Integer> lottoNumbers) {
        if (Objects.isNull(lottoNumbers)) {
            throw new IllegalArgumentException(NULL_EXCEPTION_STATEMENT);
        }
        return new Ticket(lottoNumbers);
    }

    private void validate(LottoNumbers lottoNumbers) {
        if (Objects.isNull(lottoNumbers)) {
            throw new IllegalArgumentException(NULL_EXCEPTION_STATEMENT);
        }
    }

    public MatchedCount countEqualLottoNumber(LottoNumbers winningNumbers) {
        return MatchedCount.from(
            Math.toIntExact(lottoNumbers
                .lottoNumbers()
                .stream()
                .filter(winningNumbers::contains)
                .count()
            )
        );
    }

    public LottoNumbers lottoNumbers() {
        return lottoNumbers;
    }
}
