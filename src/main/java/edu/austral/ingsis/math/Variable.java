package edu.austral.ingsis.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Variable implements Function{

    private final String name;

    public Variable(String name) {
        this.name = name;
    }

    @Override
    public Double calculate(Map<String, Double> variables) {
        return variables.get(name);
    }

    @Override
    public List<String> listVariables(List<String> variables) {
        List<String> names = new ArrayList<>();
        names.add(name);
        return Stream.concat(variables.stream(), names.stream()).collect(Collectors.toList());
    }

    @Override
    public String toString(){
        return this.name;
    }
}
