package SymbolTable.Variables;

public abstract class Variable
{
    public String Identifier;
    public String Type;
    public abstract Object Value();
    public abstract void SetValue(Object value);
    //public String Value;
    //public ArrayList<String> Values = new ArrayList<String>();
}
