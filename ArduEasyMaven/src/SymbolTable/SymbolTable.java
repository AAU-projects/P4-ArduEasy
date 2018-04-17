package SymbolTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ErrorHandler.*;

public class SymbolTable
{
    public Map<String, Variable> Variables = new HashMap<String, Variable>();
    public List<SymbolTable> SymbolTables = new ArrayList<SymbolTable>();


    public void Insert(String key, Variable var)
    {
        if (LookUp(key))
        {
            System.out.println("Compile Error: Tried to add existing key: " + key);
            return;
        }

        if(SymbolTables.size() != 0)
            SymbolTables.get(SymbolTables.size() - 1).Insert(key, var);

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
            return;
        }

        Variables.get(key).Values = values;
    }

    public String GetTypeofVariable(String key)
    {
        if(!LookUp(key))
        {
            System.out.println("Compile Error: Tried to get type of non-existing variable: " + key);
            return null;
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


    public void CloseScope()
    {
        for (String s : Variables.keySet())
        {
            if(!SymbolTables.get(SymbolTables.size() - 2).Variables.containsKey(s))
                Delete(s);
        }

    }
}
