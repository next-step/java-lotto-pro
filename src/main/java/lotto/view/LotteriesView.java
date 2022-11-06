package lotto.view;

import lotto.dto.LotteriesDto;

import java.util.List;

public class LotteriesView {

    public void lotteriesResult(LotteriesDto lotteriesDto) {
        List<List<Integer>> lotteries = lotteriesDto.getLotteries();
        int buyLottoCount = lotteries.size();
        System.out.println("수동으로 " + lotteriesDto.getDirectBuyCount() + "장, " +
                "자동으로 "+ lotteriesDto.getAutoBuyCount() + "개를 구매했습니다.");
        String result = "";
        for (int i = 0; i < buyLottoCount; i++) {
            result +=  (lottoNumbersResult(lotteries.get(i)) + "\n");
        }
        System.out.println(result);
    }

    private String lottoNumbersResult(List<Integer> lottoNumbers) {
        String result = "[";
        for (int i = 0; i < lottoNumbers.size(); i++) {
            result += (lottoNumbers.get(i) + ", ");
        }
        return result.substring(0,result.length()-2) + "]";
    }
}
