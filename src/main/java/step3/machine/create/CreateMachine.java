package step3.machine.create;

import step3.lotto.LottoPapers;

public interface CreateMachine<T> extends Machine{
	LottoPapers createLotto(T t);
}