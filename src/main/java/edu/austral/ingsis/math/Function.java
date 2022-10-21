package edu.austral.ingsis.math;

import java.util.List;
import java.util.Map;

public interface Function {

    public String toString();

    public Double calculate(Map<String,Double> variables);

    public List<String> listVariables();
}
