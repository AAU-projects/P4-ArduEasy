package SymbolTable.Variables;

public class PinVariable extends Variable{

    public String Value;
    public String IOStatus;

    @Override
    public Object Value() {
        return Value;
    }

    @Override
    public void SetValue(Object value) {

    }
}
