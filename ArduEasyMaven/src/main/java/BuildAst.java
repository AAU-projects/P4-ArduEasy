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
        return new ArrayList<DefinitionNode>();
    }

    @Override
    public Node visitStatement(final ArduEasyParser.StatementContext ctx) {

        ctx.if

        if (ctx.start.getText().contains("if"))
        {
            return visitIf(ctx.IF())
        }
        else if (ctx.start.getText().contains("while"))
        {
            child = visitWhile(ctx);
        }
        else if (ctx.start.getText().contains("for"))
        {
            child = visitFor(ctx);
        }
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