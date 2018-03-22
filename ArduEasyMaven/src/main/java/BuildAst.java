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
            Childs = new ArrayList<DefinitionNode>(visitSetupDefs(ctx.definitions()));
        }};
    }

    private List<DefinitionNode> visitSetupDefs(ArduEasyParser.DefinitionsContext context)
    {
        System.out.println(context.definition());


        return new ArrayList<DefinitionNode>();
    }

}