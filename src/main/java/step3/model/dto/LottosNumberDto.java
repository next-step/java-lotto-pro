package step3.model.dto;

import step3.model.LottoNumber;
import step3.model.Lottos;

import java.util.List;
import java.util.stream.Collectors;

public class LottosNumberDto {


    private final List<List<Integer>> lottosNumber;

    public LottosNumberDto(Lottos lottos) {
        this.lottosNumber = lottos.getNumbersOfLottos()
                .stream()
                .map(lottoNumbers -> lottoNumbers.stream().map(LottoNumber::value).collect(Collectors.toList()))
                .collect(Collectors.toList());
    }


    public List<List<Integer>> getLottosNumber() {
        return lottosNumber;
    }
}
