package SymbolTable.Variables;

import SymbolTable.SymbolTable;

public class ScopeVariable extends Variable
{
    public SymbolTable Value;

    @Override
    public SymbolTable Value()
    {
        return Value;
    }

    @Override
    public void SetValue(Object value)
    {
        Value = (SymbolTable) value;
    }
}
