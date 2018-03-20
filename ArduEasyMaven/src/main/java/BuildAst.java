import Nodes.*;

public class BuildAst extends ArduEasyBaseVisitor<Node>
{

    @Override
    public Node visitR(ArduEasyParser.RContext ctx)
    {
        return new RootNode()
        {{
            Home = visitSetup(ctx.setup());
        }};
    }
}