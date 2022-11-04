package lotto.domain;

import lotto.dto.LottoDto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    private static final int DIGIT = 6;

    private List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        if(lottoNumbers.size() != Lotto.DIGIT) {
            throw new IllegalArgumentException("로또번호로 " + Lotto.DIGIT + "자리 입력해주세요.");
        }
        Set<LottoNumber> winningNumberSet = new HashSet<>(lottoNumbers);
        if(winningNumberSet.size() != Lotto.DIGIT) {
            throw new IllegalArgumentException("로또번호에 중복숫자는 없습니다.");
        }
        Collections.sort(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public static List<LottoNumber> getLottoDigitList(List<LottoNumber> lottoNumbers) {
        return lottoNumbers.subList(0,DIGIT);
    }

    public boolean isMatch(LottoNumber inputLottoNumber) {
        return lottoNumbers.stream().anyMatch((lottoNumber) -> lottoNumber.equals(inputLottoNumber));
    }

    public int getMatchNumber(Lotto lotto) {
        return (int) lottoNumbers.stream().filter((lottoNumber) -> lotto.isMatch(lottoNumber)).count();
    }

    public LottoDto getLottoDto() {
        return new LottoDto(lottoNumbers.stream()
                .map(lottoNumber -> lottoNumber.getLottoNumberDto().getLottoNumber())
                .collect(Collectors.toList()));
    }

    public boolean isEqualNumberList(List<Integer> numbers) {
        return numbers.stream().collect(Collectors.toSet()).size() == numbers.size()
                && numbers.stream().filter(number -> isMatch(LottoNumber.of(number.toString())))
                .count() == lottoNumbers.size();
    }
}
