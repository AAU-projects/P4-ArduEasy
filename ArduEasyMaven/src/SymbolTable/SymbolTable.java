package SymbolTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import AST.Nodes.DefinitionNode;
import ErrorHandler.*;
import ErrorHandler.Errors.SyntaxError;

public class SymbolTable
{
    public Map<String, Variable> Variables = new HashMap<String, Variable>();
    public List<SymbolTable> SymbolTables = new ArrayList<SymbolTable>();
    public List<SymbolTable> ClosedSymbolTables = new ArrayList<SymbolTable>();


    public void Insert(DefinitionNode node, String key, Variable var)
    {
        if (LookUp(key))
        {
            ErrorHandler.FireInstantError(new SyntaxError(node,"Compile Error: Tried to add existing key: " + key));
            return;
        }

        if(SymbolTables.size() != 0)
            SymbolTables.get(SymbolTables.size() - 1).Variables.put(key, var);

        Variables.put(key, var);
    }

    public void Delete(DefinitionNode node, String key)
    {
        if(Variables.remove(key) == null)
        {
            ErrorHandler.FireInstantError(new SyntaxError(node,"Compile Error: Tried to remove invalid key: " + key));
        }
    }

    public Boolean LookUp(String key)
    {
        if(Variables.containsKey(key))
            return true;
        return false;
    }

    public void Update(DefinitionNode node, String key, ArrayList<String> values)
    {
        if(!LookUp(key))
        {
            ErrorHandler.FireInstantError(new SyntaxError(node,"Compile Error: Tried to edit value of non-existing variable: " + key));
            return;
        }

        Variables.get(key).Values = values;
    }

    public String GetTypeofVariable(DefinitionNode node, String key)
    {
        if(!LookUp(key))
        {
            ErrorHandler.FireInstantError(new SyntaxError(node,"Compile Error: Tried to get type of non-existing variable: " + key));
            return null;
        }

        return Variables.get(key).Type;
    }

    public void MoveUp()
    {
        for (Map.Entry<String, Variable> entry : Variables.entrySet())
        {
            if(!SymbolTables.get(SymbolTables.size() - 2).LookUp(entry.getKey()))
                SymbolTables.get(SymbolTables.size() - 2).Variables.put(entry.getKey(), entry.getValue());
        }
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
        ClosedSymbolTables.add(SymbolTables.get(SymbolTables.size() - 1));
        SymbolTables.remove(SymbolTables.size() - 1);

        Variables.clear();
        Variables.putAll(SymbolTables.get(SymbolTables.size() - 1).Variables);
    }
}
