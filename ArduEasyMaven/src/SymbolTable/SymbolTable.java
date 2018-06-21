package SymbolTable;

import java.util.HashMap;
import java.util.Map;

import AST.Nodes.Node;
import ErrorHandler.*;
import ErrorHandler.Errors.SemanticError;
import SymbolTable.Variables.*;

public class SymbolTable
{
    public Map<String, Variable> Variables = new HashMap<String, Variable>();
    public SymbolTable CurrentOpenScope = this;
    public SymbolTable ParrentScope = this;
    public static HashMap<String, FunctionVariable> FunctionList = new HashMap<String, FunctionVariable>();
    public int lastScopeLine;

    public void Insert(Node node, String key, Variable var)
    {
        if (LookUp(key))
        {   // Identifier all ready used
            CustomErrorHandler.AddError(new SemanticError(node,"Scope Error: Tried to declare an existing variable: " + key +
                    "\nIt is not possible to declare a variable more then one time, either reassign the variable a new value" +
                    " or define a new variable."));
            return;
        }
        // Insert variable to the current open scope
        CurrentOpenScope.Variables.put(key,var);
    }

    public void Delete(Node node, String key)
    {
        if (CurrentOpenScope != this)
        {   // If current open scope is not the global scope.
            if(CurrentOpenScope.Variables.remove(key) == null)
            {   // The variable does not exist.
                CustomErrorHandler.FireInstantError(new SemanticError(node,"Compile Error: Tried to remove invalid key: " + key));
            }
        }

        if(Variables.remove(key) == null)
        {   // If variable was not removed.
            CustomErrorHandler.FireInstantError(new SemanticError(node,"Compile Error: Tried to remove invalid key: " + key));
        }
    }

    public Boolean LookUp(String key)
    {
        if (CurrentOpenScope != this) // Ensures the lookup happens in the current open scope.
            return CurrentOpenScope.Variables.containsKey(key);

        return Variables.containsKey(key);
    }

    public void Update(Node node, String key, Object value)
    {
        if (key.startsWith("house"))
        {   // Split identifier on "."
            String[] temp = key.split("\\.");
            if (temp.length > 2)
            {   // If the variable is a room variable.
                GetScope(temp[1]).Update(node,temp[2],value);
                return;
            }
        }
        else if(!LookUp(key))
        {   // The variable does not exist.
            CustomErrorHandler.AddError(new SemanticError(node,"Scope Error: Tried to edit the value of a non-existing variable: " + key));
            return;
        }
        // The variable is in the current open scope.
        CurrentOpenScope.Variables.get(key).SetValue(value);
    }


    public Variable GetTypeofVariable(Node node, String key)
    {
        if(!LookUp(key))
        {   // The variable does not exist.
            CustomErrorHandler.FireInstantError(new SemanticError(node,"Compile Error: Tried to get type of non-existing variable: " + key));
            return null;
        }
        // Return the variable.
        return CurrentOpenScope.Variables.get(key);
    }

    public SymbolTable GetScope(String scopeName)
    {
        Variable variable =  Variables.get(scopeName); // Look for the scope in the global scope.
        SymbolTable result = null;

        if (variable != null)
        {   // The scope was found.
            result = (SymbolTable) variable.Value();
        }

        if (result == null)
        {   // The scope was not found in the global scope.
            for (String scope : Variables.keySet())
            {   // Look for the scope in the all the nested scopes
                if (Variables.get(scope) instanceof ScopeVariable)
                {
                    result = (SymbolTable) Variables.get(scope).Value();
                    result = result.GetScope(scopeName);

                    if (result != null) // Return if the scope was found.
                        return result;
                }
            }
        }

        return result;
    }

    public SymbolTable GetCurrentScope(String scopeName)
    {
        Variable variable =  CurrentOpenScope.Variables.get(scopeName);
        SymbolTable result = null;

        if (variable != null)
        {
            result = (SymbolTable) variable.Value();
        }


        if (result == null)
        {
            for (String scope : Variables.keySet())
            {
                if (Variables.get(scope) instanceof ScopeVariable)
                {
                    result = (SymbolTable) Variables.get(scope).Value();
                    result = result.GetScope(scopeName);

                    if (result != null)
                    {
                        return result;
                    }
                }
            }
        }

        CurrentOpenScope = result;
        return result;
    }

    public void CreateScope(final Node node)
    {
        final HashMap<String, Variable> temp = new HashMap<String, Variable>();
        final SymbolTable tempCurrentScope = CurrentOpenScope;
        temp.putAll(CurrentOpenScope.Variables); // Insert all variables from the current open scope.

        ScopeVariable var = new ScopeVariable()
        {{
            Identifier = String.valueOf(node.LineNumber);
            Type = "scope";
            Value = new SymbolTable()
            {{
                Variables = temp;
                ParrentScope = tempCurrentScope;
            }};
        }};

        if (LookUp(var.Identifier))
        {   // The scope all ready exist.
            CustomErrorHandler.FireInstantError(new SemanticError(node,"Compile Error: Tried to add existing scope: " + var.Identifier));
            return;
        }

        CurrentOpenScope.Variables.put(var.Identifier, var); // New scope gets nested inside it's parent scope.
        CurrentOpenScope = var.Value; // New scope is now current open scope.
    }

    // Find scope and set current open scope
    public void OpenScope(String scope)
    {
        OpenScope(GetScope(scope));
    }

    // Set current open scope.
    public void OpenScope(SymbolTable scope)
    {
        CurrentOpenScope = scope;
    }

    // Set current open scope back to parent.
    public void CloseScope()
    {
        CurrentOpenScope = CurrentOpenScope.ParrentScope;
    }
}
