import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lottos {

	private final List<Lotto> lottos;

	Lottos(List<Lotto> lottos) {
		this.lottos = lottos;
	}

	public int size() {
		return lottos.size();
	}

	public <R, A> R collect(Collector<? super Lotto, A, R> collector) {
		return lottos.stream().collect(collector);
	}

	@Override
	public String toString() {
		return lottos.stream().map(Lotto::toString).collect(Collectors.joining(System.lineSeparator()));
	}

	public static Lottos merge(Lottos a, Lottos b) {
		return new Lottos(Stream.of(a.lottos, b.lottos)
			.flatMap(Collection::stream)
			.collect(Collectors.toList()));
	}
}
