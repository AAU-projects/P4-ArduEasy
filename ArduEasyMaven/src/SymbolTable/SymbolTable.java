package SymbolTable;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import AST.Nodes.DefinitionNode;
import AST.Nodes.Node;
import ErrorHandler.*;
import ErrorHandler.Errors.SemanticError;
import ErrorHandler.Errors.SyntaxError;
import SymbolTable.Variables.*;

public class SymbolTable
{
    public Map<String, Variable> Variables = new HashMap<String, Variable>();
    public SymbolTable CurrentOpenScope = this;
    public SymbolTable ParrentScope = this;


    public void Insert(Node node, String key, Variable var)
    {
        if (LookUp(key))
        {
            ErrorHandler.FireInstantError(new SemanticError(node,"Compile Error: Tried to add existing key: " + key));
            return;
        }

        CurrentOpenScope.Variables.put(key,var);
    }

    public void Delete(Node node, String key)
    {
        if (CurrentOpenScope != this)
        {
            if(CurrentOpenScope.Variables.remove(key) == null)
            {
                ErrorHandler.FireInstantError(new SemanticError(node,"Compile Error: Tried to remove invalid key: " + key));
            }
        }

        if(Variables.remove(key) == null)
        {
            ErrorHandler.FireInstantError(new SemanticError(node,"Compile Error: Tried to remove invalid key: " + key));
        }
    }

    public Boolean LookUp(String key)
    {
        if (CurrentOpenScope != this)
            return CurrentOpenScope.Variables.containsKey(key);

        return Variables.containsKey(key);
    }

    public void Update(Node node, String key, Object value)
    {
        if (key.startsWith("house"))
        {
            String[] temp = key.split("\\.");
            if (temp.length > 2)
            {
                GetScope(temp[1]).Update(node,temp[2],value);
                return;
            }
        }else if(!LookUp(key))
        {
            ErrorHandler.FireInstantError(new SemanticError(node,"Compile Error: Tried to edit value of non-existing variable: " + key + " in scope"));
            return;
        }

        CurrentOpenScope.Variables.get(key).SetValue(value);
    }

    public String GetTypeofVariable(Node node, String key)
    {
        if(!LookUp(key))
        {
            ErrorHandler.FireInstantError(new SemanticError(node,"Compile Error: Tried to get type of non-existing variable: " + key + " in scope"));
            return null;
        }

        return CurrentOpenScope.Variables.get(key).Type;
    }

    public SymbolTable GetScope(String scopeName)
    {
        SymbolTable result = (SymbolTable) Variables.get(scopeName).Value();

        if (result == null)
        {
            for (String scope : Variables.keySet())
            {
                if (Variables.get(scope) instanceof ScopeVariable)
                {
                    result = (SymbolTable) Variables.get(scope).Value();
                    result = result.GetScope(scopeName);

                    if (result != null)
                        return result;
                }
            }
        }

        return result;
    }

    public void CreateScope(final Node node)
    {
        final Map<String, Variable> test = this.CurrentOpenScope.Variables;
        ScopeVariable var = new ScopeVariable()
        {{
            Identifier = String.valueOf(node.LineNumber);
            Type = "scope";
            Value = new SymbolTable()
            {{
                Variables = new HashMap<String, Variable>(test);
                ParrentScope = CurrentOpenScope;
            }};
        }};

        if (LookUp(var.Identifier))
        {
            ErrorHandler.FireInstantError(new SemanticError(node,"Compile Error: Tried to add existing scope: " + var.Identifier));
            return;
        }

        CurrentOpenScope.Variables.put(var.Identifier, var);
        CurrentOpenScope = var.Value;
    }

    public void OpenScope(String scope)
    {
        OpenScope(GetScope(scope));
    }

    public void OpenScope(SymbolTable scope)
    {
        CurrentOpenScope = scope;
    }

    public void CloseScope()
    {
        CurrentOpenScope = CurrentOpenScope.ParrentScope;
    }
}
