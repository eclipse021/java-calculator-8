package calculator.domain.calculator.model.dto;

public record Input(String raw) {

    public Input{
        if (raw == null) {
            raw = "";
        }
    }
}
