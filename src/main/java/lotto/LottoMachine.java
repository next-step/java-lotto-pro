package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lotto.model.LottoNumbers;

public class LottoMachine {
	private List<LottoNumbers> lottos;
	private model.Number money;
	private int[] winList;
	
	public LottoMachine(String money) {
		this.money = new model.Number(money);
	}
	
	public List<LottoNumbers> buyAutoLottos() {
		int times = money.getNumber()/LottoUtil.LOTTO_PRICE;
		
		lottos = new ArrayList<>();
		for (int i=0; i<times; ++i) {
			lottos.add(new LottoNumbers(LottoUtil.randomLottoNumbers()));
		}
		
		return lottos;
	}
	
	public int[] winList(LottoNumbers winLottoNumbers) {
		winList = new int[LottoUtil.LOTTO_NUMBERS_COUNT+1];
		Arrays.fill(winList, 0);
		
		for (LottoNumbers lottoNumbers: lottos) {
			int count = winLottoNumbers.countEqualsLottoNumber(lottoNumbers);
			++winList[count]; 
		}
		
		return winList;
	}
	
	public double profitRate() {
		if(winList == null) {
			return 0;
		}
		
		int sum = 0;
		for(int i=1; i<LottoUtil.LOTTO_NUMBERS_COUNT+1; ++i) {
			sum += winList[i]*LottoUtil.WIN_MONEYS[i];
		}
		
		return (double)sum/money.getNumber();
	}
}
