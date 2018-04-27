package SymbolTable.Variables;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayVariable extends Variable
{
    public List<String> Value;

    @Override
    public List<String> Value()
    {
        return Value;
    }

    @Override
    public void SetValue(Object value)
    {
        Type = (String) value;
    }
}
