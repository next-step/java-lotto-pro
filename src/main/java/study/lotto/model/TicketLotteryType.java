package study.lotto.model;

import study.lotto.model.exception.TicketLotteryTypeNotFoundException;
import study.utils.StringUtils;

public enum TicketLotteryType {

    AUTO, MANUAL;

    private static final String NOT_FOUND_ERROR_MESSAGE = "해당 타입의 로또복권 타입을 찾지 못하였습니다.";

    private TicketLotteryType() {
    }

    public boolean isAutoTicket() {
        return this == AUTO;
    }

    public boolean isManualTicket() {
        return this == MANUAL;
    }

    public static TicketLotteryType findByType(final String type) {
        if (StringUtils.isEmpty(type)) {
            throw new TicketLotteryTypeNotFoundException(NOT_FOUND_ERROR_MESSAGE);
        }

        try {
            return TicketLotteryType.valueOf(type.toUpperCase());
        } catch (final IllegalArgumentException exception) {
            throw new TicketLotteryTypeNotFoundException(NOT_FOUND_ERROR_MESSAGE);
        }
    }
}
