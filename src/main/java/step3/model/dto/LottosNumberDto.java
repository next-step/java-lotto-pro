package step3.model.dto;

import step3.model.Lottos;

import java.util.List;

public class LottosNumberDto {


    private final List<List<Integer>> lottosNumber;

    public LottosNumberDto(Lottos lottosNumber){
        this.lottosNumber = lottosNumber.getNumbersOfLottos();
    }


    public List<List<Integer>> getLottosNumber() {
        return lottosNumber;
    }
}
