package SymbolTable.Variables;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FunctionVariable extends Variable {

    public List<String[]> Parameters = new ArrayList<String[]>();

    @Override
    public Object Value() {
        return Parameters;
    }

    @Override
    public void SetValue(Object value) {
        Parameters = (List<String[]>) value;
        

    }
}
