import Nodes.*;
import jdk.nashorn.internal.ir.Assignment;

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
            return visitDeclaration(ctx.declaration());
        }
        else if (ctx.assignment() != null)
        {
            return visitAssignment(ctx.assignment());
        }
        else if (ctx.roomdeclaration() != null)
        {
            return visitRoomdeclaration(ctx.roomdeclaration());
        }

        return null;
    }

    @Override
    public PinDeclarationNode visitPindeclaration(ArduEasyParser.PindeclarationContext ctx)
    {
        return null;
    }

    @Override
    public DeclarationNode visitDeclaration(ArduEasyParser.DeclarationContext ctx)
    {
        return null;
    }

    @Override
    public AssignmentNode visitAssignment(ArduEasyParser.AssignmentContext ctx)
    {
        return null;
    }

    @Override
    public RoomDeclaration visitRoomdeclaration(ArduEasyParser.RoomdeclarationContext ctx)
    {
        return null;
    }

    @Override
    public IdentifierNode visitIdentifier(ArduEasyParser.IdentifierContext ctx)
    {
        return null;
    }

    @Override
    public Node visitStatement(final ArduEasyParser.StatementContext ctx) {

        return null;
    }

    private Node visitIf(final ArduEasyParser.StatementContext ctx)
    {
        return new IfNode() {

        };
    }

    private Node visitWhile(final ArduEasyParser.StatementContext ctx)
    {
        return new WhileNode() {

        };
    }

    private Node visitFor(final ArduEasyParser.StatementContext ctx)
    {
        return new ForNode() {

        };
    }

    private Node visitSwitch(final ArduEasyParser.StatementContext ctx)
    {
        return new SwitchNode() {

        };
    }

    private Node visitPerform(final ArduEasyParser.StatementContext ctx)
    {
        return new PerformNode() {

        };
    }
}