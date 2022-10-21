package edu.austral.ingsis.math;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Variable implements Function{

    private final String name;

    public Variable(String name) {
        this.name = name;
    }

    @Override
    public Double calculate(Map<String, Double> variables) {
        return null;
    }

    @Override
    public List<String> listVariables() {
        return List.of(name);
    }

    @Override
    public String toString(){
        return this.name;
    }
}
