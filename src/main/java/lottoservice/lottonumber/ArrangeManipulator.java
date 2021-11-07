package lottoservice.lottonumber;

import java.util.List;

public interface ArrangeManipulator {

	<T> void shuffleElements(List<T> elements);
}
