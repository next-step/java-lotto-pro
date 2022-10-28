package step3.model.dto;

import step3.model.LottoNumber;

import java.util.List;
import java.util.stream.Collectors;

public class LottosNumberDto {


    private final List<List<Integer>> lottosNumber;

    public LottosNumberDto(List<List<LottoNumber>> lottosNumber) {
        this.lottosNumber = lottosNumber.stream()
                .map(lottoNumbers -> lottoNumbers.stream().map(lottoNumber -> lottoNumber.value()).collect(Collectors.toList()))
                .collect(Collectors.toList());
    }


    public List<List<Integer>> getLottosNumber() {
        return lottosNumber;
    }
}
