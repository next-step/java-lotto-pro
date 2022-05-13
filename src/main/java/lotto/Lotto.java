package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import lotto.model.LottoNumber;
import lotto.model.LottoNumbers;
import lotto.model.UserMoney;

public class Lotto {
	private static final String LOTTO_INPUT_LIST_REGEX = ",";
	private static Scanner scan = new Scanner(System.in);
	private LottoMachine lottoMachine;

	public Lotto() {
		lottoMachine = new LottoMachine();
	}

	public void printWinningData() {
		String lastLottoNumbers = inputMessage("\n지난 주 당첨 번호를 입력해 주세요.");
		List<LottoNumber> lottoNumbers = lastWinLottoNumbers(lastLottoNumbers);
		printWinStatistics(lottoMachine.winList(new LottoNumbers(lottoNumbers)));
	}

	public void printProfitRate(UserMoney userMoney) {
		System.out.println(profitRateStringFormat(lottoMachine.profitRate(userMoney)));
	}

	public String inputMessage(String message) {
		System.out.println(message);
		return scan.nextLine();
	}

	public void buyAutoLotto(UserMoney userMoney) {
		List<LottoNumbers> lottos = lottoMachine.buyAutoLottos(userMoney);
		System.out.println(lottoNumbersTitleStringFormat(lottos));
		for (int i = 0; i < lottos.size(); ++i) {
			System.out.println(lottoNumbersStringFormat(lottos.get(i)));
		}
	}

	private List<LottoNumber> lastWinLottoNumbers(String lastLottoNumbers) {
		List<LottoNumber> lottoNumbers = new ArrayList<>();
		for (String lottoNumber : lastLottoNumbers.split(LOTTO_INPUT_LIST_REGEX)) {
			lottoNumbers.add(new LottoNumber(lottoNumber));
		}
		return lottoNumbers;
	}

	private void printWinStatistics(int[] winList) {
		System.out.println("\n당첨 통계\n---------");
		for (int i = 3; i <= 6; ++i) {
			System.out.println(winLottoCountStringFormat(i, winList[i]));
		}
	}

	private String lottoNumbersTitleStringFormat(List<LottoNumbers> lottos) {
		return String.format("%d%s", lottos.size(), "개를 구매했습니다.");
	}

	private String lottoNumbersStringFormat(LottoNumbers lottoNumbers) {
		StringBuffer lottoNumbersMessage = new StringBuffer();
		lottoNumbersMessage.append("[");
		for (int i = 0; i < lottoNumbers.getLottoNumbers().size(); ++i) {
			String lottoNumberMessage = lottoNumbersStringFormatAddComma(i != lottoNumbers.getLottoNumbers().size() - 1,
					lottoNumbers.getLottoNumbers().get(i).getLottoNumber());
			lottoNumbersMessage.append(lottoNumberMessage);
		}
		lottoNumbersMessage.append("]");
		return lottoNumbersMessage.toString();
	}

	private String lottoNumbersStringFormatAddComma(boolean match, int value) {
		if (match) {
			return value + ", ";
		}
		return value + "";
	}

	private String winLottoCountStringFormat(int index, int count) {
		return String.format("%d개 일치 (%d원)- %d개", index, LottoUtil.WIN_MONEYS[index], count);
	}

	private String profitRateStringFormat(double profitRate) {
		return String.format("총 수익률은 %.02f입니다.", profitRate);
	}
}
