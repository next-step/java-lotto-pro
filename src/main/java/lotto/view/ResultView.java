package lotto.view;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.text.html.Option;

import lotto.domain.Buyer;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;
import lotto.domain.Rank;
import lotto.domain.WinningRecord;

public class ResultView {

	public static final int STANDARD_RATE = 1;
	public static final String PRINT_PURCHASE_QUANTITY = "수동으로 %d장, 자동으로 %d개를 구매했습니다.%n";
	public static final String PRINT_RETURN_RATE = "총 수익률은 %.2f 입니다.";
	public static final String PRINT_MONEY_LOSS = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
	public static final String PRINT_LOTTO_RECORD = "%d개 일치 (%s원)- %d개%n";
	public static final String PRINT_LOTTO_BONUS_RECORD = "%d개 일치, 보너스 볼 일치(%s원) - %d개%n";
	public static final String PRINT_LOTTO_NUMBER = "[%s]%n";
	public static final String WINNING_STAT_INFO = "당첨 통계";
	public static final String DASH = "---------";
	public static final String DELIMITER = ", ";
	public static final String PRINT_MANUAL_LOTTOS = "수동으로 구매할 번호를 입력해 주세요.";
	public static final String PRINT_ERROR_COMMON = "잘못 입력하였습니다.";

	public static void printLottoPurchaseQuantity(Buyer buyer) {
		System.out.printf(PRINT_PURCHASE_QUANTITY, buyer.getManualNumber(), buyer.getRemainingNumber());
	}

	public static void printLottos(Lottos lottos) {
		lottos.getLottos().forEach(ResultView::printLotto);
	}

	private static void printLotto(Lotto lotto) {
		System.out.printf(PRINT_LOTTO_NUMBER,
			lotto.getLottoNumbers().stream()
				.map(lottoNumber -> String.valueOf(lottoNumber.getLottoNumber()))
				.collect(Collectors.joining(DELIMITER))
		);
	}

	public static void printWinningRecord(WinningRecord winningRecord) {
		Arrays.stream(Rank.values())
			.filter(rank -> Rank.FAILED != rank)
			.sorted(Comparator.reverseOrder())
			.forEach(rank ->
				System.out.printf(
					getRecordContent(rank),
					rank.getMatchCount(), rank.getPrizeMoney(), winningRecord.getPlaceCount(rank)
				)
			);
	}

	private static String getRecordContent(Rank rank) {
		if(Rank.SECOND == rank){
			return PRINT_LOTTO_BONUS_RECORD;
		}
		return PRINT_LOTTO_RECORD;
	}

	public static void printReturnRate(double rate) {
		System.out.printf(PRINT_RETURN_RATE, rate);
		if (STANDARD_RATE > rate) {
			System.out.println(PRINT_MONEY_LOSS);
		}
	}

	public static void printWinningStat(WinningRecord winningRecord, double rate) {
		System.out.println(WINNING_STAT_INFO);
		System.out.println(DASH);
		printWinningRecord(winningRecord);
		printReturnRate(rate);
	}

	public static void printManualLottosInfo() {
		System.out.println(PRINT_MANUAL_LOTTOS);
	}

	public static void printErrorMsg(String message) {
		System.out.println(Optional.ofNullable(message)
			.orElse(PRINT_ERROR_COMMON));
	}
}
