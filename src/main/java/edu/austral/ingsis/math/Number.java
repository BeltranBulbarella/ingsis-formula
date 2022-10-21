package edu.austral.ingsis.math;

import java.util.List;
import java.util.Map;

public class Number implements Function{

    private final Double value;

    public Number(Double value){
        this.value = value;
    }
    @Override
    public String toString(){
        if (value == Math.floor(value)) {
            return String.format("%d", value.intValue());
        } else {
            return String.format("%s", value);
        }
    }

    @Override
    public Double calculate(Map<String, Double> variables) {
        return value;
    }

    @Override
    public List<String> listVariables(List<String> variables) {
        return List.of();
    }
}
