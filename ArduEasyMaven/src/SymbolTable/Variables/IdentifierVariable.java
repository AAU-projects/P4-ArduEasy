package SymbolTable.Variables;

public class IdentifierVariable extends Variable
{
    public String Value;

    @Override
    public String Value()
    {
        return Value;
    }

    @Override
    public void SetValue(Object value)
    {
        Value = (String) value;
    }
}
