package calculator.domain.calculator.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Delimiter {

    private final Set<Character> separators;

    public Set<Character> getSeparators() {
        return separators;
    }

    public void addSeparator(char separator) {
        separators.add(separator);
    }

    public Delimiter(Set<Character> separators) {
        this.separators = separators;
    }

    public static Delimiter defaultSeparator(){
        return new Delimiter(new HashSet<>(Arrays.asList(',', ':')));
    }
}
