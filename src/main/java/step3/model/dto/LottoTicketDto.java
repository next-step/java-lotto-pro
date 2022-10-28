package step3.model.dto;

import step3.model.LottoNumber;

import java.util.List;
import java.util.stream.Collectors;

public class LottoTicketDto {


    private final List<List<Integer>> lottosNumber;

    public LottoTicketDto(List<List<LottoNumber>> lottosNumber) {
        this.lottosNumber = lottosNumber.stream()
                .map(lottoNumbers -> lottoNumbers.stream().map(LottoNumber::value).collect(Collectors.toList()))
                .collect(Collectors.toList());
    }


    public List<List<Integer>> getLottosNumber() {
        return lottosNumber;
    }
}
