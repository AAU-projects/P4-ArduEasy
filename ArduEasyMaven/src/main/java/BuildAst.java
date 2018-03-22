import Nodes.*;

import java.util.ArrayList;
import java.util.List;

public class BuildAst extends ArduEasyBaseVisitor<Node>
{

    @Override
    public Node visitR(final ArduEasyParser.RContext ctx)
    {
        return new RootNode()
        {{
            Home = visitSetup(ctx.setup());
        }};
    }

    @Override
    public SetupNode visitSetup(final ArduEasyParser.SetupContext ctx)
    {
        return new SetupNode()
        {{
            Childs = new ArrayList<DefinitionNode>(visitSetupDefs(ctx.definition()));
        }};
    }

    private List<DefinitionNode> visitSetupDefs(List<ArduEasyParser.DefinitionContext> context)
    {
        List<DefinitionNode> nodeList = new ArrayList<DefinitionNode>();

        for (ArduEasyParser.DefinitionContext def: context)
        {
            if (def != null)
            {
                nodeList.add(visitDefinition(def));
            }
        }

        return nodeList;
    }

    @Override
    public DefinitionNode visitDefinition(ArduEasyParser.DefinitionContext ctx)
    {
        if (ctx.pindeclaration() != null)
        {
            return visitPindeclaration(ctx.pindeclaration());
        }
        else if (ctx.declaration() != null)
        {

        }
        else if (ctx.assignment() != null)
        {

        }
        else if (ctx.roomdeclaration() != null)
        {

        }

        return null;
    }

    @Override
    public PinDeclarationNode visitPindeclaration(ArduEasyParser.PindeclarationContext ctx)
    {
        return null;
    }

    @Override
    public Node visitDeclaration(ArduEasyParser.DeclarationContext ctx)
    {
        return null;
    }

    @Override
    public Node visitAssignment(ArduEasyParser.AssignmentContext ctx)
    {
        return null;
    }

    @Override
    public Node visitRoomdeclaration(ArduEasyParser.RoomdeclarationContext ctx)
    {
        return null;
    }
}