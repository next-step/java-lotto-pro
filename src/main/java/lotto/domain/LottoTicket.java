package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoTicket {
    public static final int LOTTO_NUMBER_LENGTH = 6;

    private final List<LottoNumber> lottoNumbers;

    private LottoTicket(List<LottoNumber> lottoNumbers) {
        validate(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoTicket create(List<LottoNumber> lottoNumbers) {
        return new LottoTicket(lottoNumbers);
    }

    private void validate(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER_LENGTH) {
            throw new IllegalArgumentException("로또 번호 개수는 6개여야 합니다.");
        }
    }

    public int containCount(LottoTicket ticket) {
        return (int) lottoNumbers.stream()
                .filter(v -> ticket.lottoNumbers.contains(v))
                .count();
    }

    public boolean contain(LottoNumber number) {
        return lottoNumbers.contains(number);
    }

    @Override
    public String toString() {
        String result = lottoNumbers.stream()
                .map(v -> v.toString())
                .collect(Collectors.joining(", "));
        return "[" + result + "]";
    }
}
