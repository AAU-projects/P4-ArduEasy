package Nodes;

public class PercentNode extends Node {
    public int Value;

    @Override
    public String toString() {
        return String.format("%d%s",Value,"%");
    }
}
