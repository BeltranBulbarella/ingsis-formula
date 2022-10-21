package edu.austral.ingsis.math.operators;

import edu.austral.ingsis.math.Function;

import java.util.List;
import java.util.Map;

public class Parenthesis implements Function {

    private Function f1;

    public Parenthesis(Function f1) {
        this.f1 = f1;
    }

    public String toString(){
        return "(" + f1.toString() + ")";
    }

    @Override
    public Double calculate(Map<String, Double> variables) {
        return f1.calculate(variables);
    }

    @Override
    public List<String> listVariables(List<String> variables) {
        return List.of();
    }

}
