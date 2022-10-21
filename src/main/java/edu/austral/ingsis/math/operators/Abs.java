package edu.austral.ingsis.math.operators;

import edu.austral.ingsis.math.Function;

import java.util.List;
import java.util.Map;

public class Abs implements Function {

    private Function f1;

    public Abs(Function f1) {
        this.f1 = f1;
    }

    @Override
    public Double calculate(Map<String, Double> variables) {
        return Math.abs(f1.calculate(variables));
    }

    @Override
    public List<String> listVariables() {
        return null;
    }

    public String toString(){
        return "|" + f1.toString() + "|";
    }

}
