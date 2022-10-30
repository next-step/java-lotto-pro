package step3.model.machine;

import static java.util.stream.Collectors.toList;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import step3.model.lotto.Ticket;
import step3.model.value.Rule;

public class ShuffleTicketGenerator implements TicketGenerator {

    @Override
    public List<Integer> generateTicket(int count) {
        List<Integer> numbers = IntStream.rangeClosed(Rule.MIN_NUM, Rule.MAX_NUM)
                .boxed()
                .collect(toList());
        Collections.shuffle(numbers);
        List<Integer> ticket = numbers.subList(0, count);
        return ticket;
    }
}

