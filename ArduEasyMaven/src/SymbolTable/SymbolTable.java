package SymbolTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SymbolTable
{
    public Map<String, Variable> Variables = new HashMap<String, Variable>();
    public List<SymbolTable> SymbolTables = new ArrayList<SymbolTable>()
    {
    };

    public void Insert(String key, Variable var)
    {
        if (LookUp(key))
        {
            System.out.println("Compile Error: Tried to add existing key: " + key);
        }

        Variables.put(key, var);
    }

    public void Delete(String key)
    {
        if(Variables.remove(key) == null)
        {
            System.out.println("Compile Error: Tried to remove invalid key: " + key);
        }
    }

    public Boolean LookUp(String key)
    {
        if(Variables.containsKey(key))
            return true;
        return false;
    }

    public void Update(String key, ArrayList<String> values)
    {
        if(!LookUp(key))
        {
            System.out.println("Compile Error: Tried to edit value of non-existing variable: " + key);
        }

        Variables.get(key).Values = values;
    }

    public String GetTypeofVariable(String key)
    {
        if(!LookUp(key))
        {
            System.out.println("Compile Error: Tried to get type of non-existing variable: " + key);
        }

        return Variables.get(key).Type;
    }

    public void CreateScope()
    {
        SymbolTable scope = new SymbolTable();

        if(SymbolTables.size() == 0)
        {
            SymbolTables.add(scope);
        }
        else
        {
            scope.Variables.putAll(SymbolTables.get(SymbolTables.size() - 1).Variables);
            SymbolTables.add(scope);
        }
    }
}
