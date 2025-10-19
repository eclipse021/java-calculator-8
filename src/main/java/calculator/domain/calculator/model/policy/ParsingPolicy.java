package calculator.domain.calculator.model.policy;

import calculator.domain.calculator.model.Delimiter;

public record ParsingPolicy(Delimiter delimiter, int startIndex) {}
