package lotto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import lotto.model.LottoNumber;
import lotto.model.LottoNumbers;

public class Lotto {
	private static final String LOTTO_INPUT_LIST_REGEX = ",";
	private static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		String money = inputMessage("구입금액을 입력해 주세요.");
		
		LottoMachine lottoMachine = new LottoMachine(money);
		buyAutoLotto(lottoMachine.buyAutoLottos());

		String lastLottoNumbers = inputMessage("\n지난 주 당첨 번호를 입력해 주세요.");
		List<LottoNumber> lottoNumbers = lastWinLottoNumbers(lastLottoNumbers);
		
		printWinStatistics(lottoMachine.winList(new LottoNumbers(lottoNumbers)));
		System.out.println(profitRateStringFormat(lottoMachine.profitRate()));
	}
	
	private static String inputMessage(String message) {
		System.out.println(message);
		return scan.nextLine();
	}
	
	private static void buyAutoLotto(List<LottoNumbers> lottos) {
		System.out.println(lottoNumbersTitleStringFormat(lottos));
		for (int i=0; i<lottos.size(); ++i) {
			System.out.println(lottoNumbersStringFormat(lottos.get(i)));
		}
	}
	
	private static List<LottoNumber> lastWinLottoNumbers(String lastLottoNumbers) {
		List<LottoNumber> lottoNumbers = new ArrayList<>();
		for (String lottoNumber: lastLottoNumbers.split(LOTTO_INPUT_LIST_REGEX)) {
			lottoNumbers.add(new LottoNumber(lottoNumber));
		}
		return lottoNumbers;
	}
	
	private static void printWinStatistics(int[] winList) {
		System.out.println("\n당첨 통계\n---------");
		for (int i=3; i<=6; ++i) {
			System.out.println(winLottoCountStringFormat(i, winList[i]));
		}
	}
	
	private static String lottoNumbersTitleStringFormat(List<LottoNumbers> lottos) {
		return String.format("%d%s", lottos.size(), "개를 구매했습니다.");
	}
	
	private static String lottoNumbersStringFormat(LottoNumbers lottoNumbers) {
		StringBuffer lottoNumbersMessage = new StringBuffer();
		lottoNumbersMessage.append("[");
		for (int i = 0; i < lottoNumbers.getLottoNumbers().size(); ++i) {
			lottoNumbersMessage.append(lottoNumbers.getLottoNumbers().get(i).getLottoNumber());
			if (i != lottoNumbers.getLottoNumbers().size()-1) {
				lottoNumbersMessage.append(", ");
			}
		}
		lottoNumbersMessage.append("]");
		return lottoNumbersMessage.toString();
	}
	
	private static String winLottoCountStringFormat(int index, int count) {
		return String.format("%d개 일치 (%d원)- %d개", index, LottoUtil.WIN_MONEYS[index], count);
	}
	
	private static String profitRateStringFormat(double profitRate) {
		return String.format("총 수익률은 %.02f입니다.", profitRate);
	}
}
