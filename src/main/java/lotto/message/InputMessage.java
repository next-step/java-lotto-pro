package lotto.message;

import lotto.domain.LottoTicket;

public class InputMessage {
    public static final String INVALID_MINIMUM_MONEY = String.format("최소 %d원 이상이어야 구매할 수 있습니다.", LottoTicket.PRICE);
    public static final String INVALID_LOTTO_NUMBER = "로또 번호는 1~45 사이의 숫자여야 합니다.";
    public static final String INVALID_LOTTO_DIGITS = String.format("로또 번호는 %d자리입니다.", LottoTicket.LOTTO_SIZE);
    public static final String INVALID_LOTTO_UNIQUE = "로또 번호는 중복될 수 없습니다.";
    public static final String INVALID_LOTTO_TICKET = "로또 번호 6자리는 null일 수 없습니다.";
    public static final String INVALID_BONUS_NUMBER = "보너스 번호를 null일 수 없습니다.";
    public static final String INPUT_MONEY = "구매금액을 입력해 주세요.";
    public static final String INPUT_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
    public static final String INPUT_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";
}
