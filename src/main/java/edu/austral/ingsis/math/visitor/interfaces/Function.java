package edu.austral.ingsis.math.visitor.interfaces;


public interface Function {
    <T> T accept(Visitor<T> visitor);
}
