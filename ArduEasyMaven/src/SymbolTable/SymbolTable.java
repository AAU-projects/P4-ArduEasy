package SymbolTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import AST.Nodes.DefinitionNode;
import AST.Nodes.Node;
import ErrorHandler.*;
import ErrorHandler.Errors.SyntaxError;
import SymbolTable.Variables.*;

public class SymbolTable
{
    public Map<String, Variable> Variables = new HashMap<String, Variable>();


    public void Insert(DefinitionNode node, String key, Variable var)
    {
        if (LookUp(key))
        {
            ErrorHandler.FireInstantError(new SyntaxError(node,"Compile Error: Tried to add existing key: " + key));
            return;
        }

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

    public void Update(DefinitionNode node, String key, Object value)
    {
        if(!LookUp(key))
        {
            ErrorHandler.FireInstantError(new SyntaxError(node,"Compile Error: Tried to edit value of non-existing variable: " + key));
            return;
        }

        Variables.get(key).SetValue(value);
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

    public SymbolTable GetScope(String scopeName)
    {
        return (SymbolTable) Variables.get(scopeName).Value();
    }

    public void CreateScope(final Node node)
    {
        Variable var = new ScopeVariable()
        {{
            Identifier = "ScopeLine:"+node.LineNumber;
            Type = "scope";
            Value = new SymbolTable(){{Variables = new HashMap<String, Variable>(Variables);}};
        }};

        if (LookUp(var.Identifier))
        {
            ErrorHandler.FireInstantError(new SyntaxError(node,"Compile Error: Tried to add existing scope: " + var.Identifier));
            return;
        }

        Variables.put(var.Identifier, var);
    }
}
