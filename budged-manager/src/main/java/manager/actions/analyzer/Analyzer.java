package manager.actions.analyzer;

import java.util.List;

public interface Analyzer<T> {

    List<T> sortAll(List<T> elements);

    List<T> sortAllByType(List<T> elements);

    List<T> sortAllForSpecificType(List<T> elements);
}