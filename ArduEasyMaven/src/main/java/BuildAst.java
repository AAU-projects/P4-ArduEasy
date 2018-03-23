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
    public PinDeclarationNode visitPindeclaration(final ArduEasyParser.PindeclarationContext ctx)
    {
        return new PinDeclarationNode()
        {{
            Identifier = visitIdentifier(ctx.identifier());
            Pin = visitPin(ctx.pin());
            IoStatus = visitIoStatus(ctx.ioStatus());
        }};
    }

    @Override
    public DeclarationNode visitDeclaration(final ArduEasyParser.DeclarationContext ctx)
    {
        return new DeclarationNode()
        {{
            Type = ctx.typeSpecifier().getText();
            Identifier = visitIdentifier(ctx.identifier());
            Value = visitLogicalExpressions(ctx.logicalExpressions());
        }};
    }



    @Override
    public AssignmentNode visitAssignment(final ArduEasyParser.AssignmentContext ctx)
    {
        return new AssignmentNode()
        {{
           Identifier = visitIdentifier(ctx.identifier());
           Value = visitLogicalExpressions(ctx.logicalExpressions());
        }};
    }

    @Override
    public RoomDeclaration visitRoomdeclaration(final ArduEasyParser.RoomdeclarationContext ctx)
    {
        return new RoomDeclaration()
        {{
            Identifier = visitIdentifier(ctx.identifier());
        }};
    }

    private List<RoomBlockNode> visitRoomBlockList(ArduEasyParser.RoomblockContext context)
    {
        List<RoomBlockNode> nodeList = new ArrayList<RoomBlockNode>();

        for (ArduEasyParser.PindeclarationContext ctx: context.pindeclaration())
        {
            if (ctx != null)
            {
                nodeList.add(visitPindeclaration(ctx));
            }
        }

        for (ArduEasyParser.ArraydeclarationContext ctx: context.arraydeclaration())
        {
            if (ctx != null)
            {
                nodeList.add(visitArraydeclaration(ctx));
            }
        }

        return nodeList;
    }

    @Override
    public ArrayDeclarationNode visitArraydeclaration(ArduEasyParser.ArraydeclarationContext ctx)
    {
        return new ArrayDeclarationNode()
        {{

        }};
    }

    @Override
    public IdentifierNode visitIdentifier(ArduEasyParser.IdentifierContext ctx)
    {
        return null;
    }

    @Override
    public PinNode visitPin(ArduEasyParser.PinContext ctx)
    {
        return null;
    }

    @Override
    public IoStatusNode visitIoStatus(ArduEasyParser.IoStatusContext ctx)
    {
        return null;
    }

    @Override
    public StatementsNode visitStatement(final ArduEasyParser.StatementContext ctx) {

        if (ctx.if_r() != null)
        {
            return visitIf_r(ctx.if_r());
        }
        else if (ctx.for_r() != null)
        {
            return visitFor_r(ctx.for_r());
        }
        else if (ctx.switch_r() != null)
        {
            return visitSwitch_r(ctx.switch_r());
        }
        else if (ctx.perform_r() != null)
        {
            return visitPerform_r(ctx.perform_r());
        }
        else if (ctx.while_r() != null)
        {
            return visitWhile_r(ctx.while_r());
        }
        else if (ctx.declaration() != null)
        {
            return visitDeclaration(ctx.declaration());
        }
        else if (ctx.assignment() != null)
        {
            return visitAssignment(ctx.assignment());
        }

        return null;
    }

    @Override
    public ForNode visitFor_r(final ArduEasyParser.For_rContext ctx) {
        return new ForNode()
        {{
            Predicate = visitLogicalExpressions(ctx.logicalExpressions());
            Increment = visitAssignment(ctx.assignment(1)); // takes the second assignment in the for loop
            body = new ArrayList<StatementsNode>(visitStatementList(ctx.statement()));

        }};
    }

    @Override
    public IfNode visitIf_r(final ArduEasyParser.If_rContext ctx) {
        return new IfNode()
        {{
            Predicate = visitLogicalExpressions(ctx.logicalExpressions());
            Body = new ArrayList<StatementsNode>(visitStatementList(ctx.statement()));
            Alternative = visitIfElse(ctx.ifElse());
            
        }};
    }

    private List<StatementsNode> visitStatementList(List<ArduEasyParser.StatementContext> context)
    {
        List<StatementsNode> nodeList = new ArrayList<StatementsNode>();

        for (ArduEasyParser.StatementContext statement: context)
        {
            if (statement != null)
            {
                nodeList.add(visitStatement(statement));
            }
        }

        return nodeList;
    }


    @Override
    public IfOrElseNode visitIfElse(ArduEasyParser.IfElseContext ctx) {
        return new IfOrElseNode(); //TODO
    }

    @Override
    public LogicalExprNode visitLogicalExpressions(ArduEasyParser.LogicalExpressionsContext ctx) {
        return new LogicalExprNode(); //TODO
    }


    @Override
    public SwitchNode visitSwitch_r(ArduEasyParser.Switch_rContext ctx) {
        return null;
    }

    @Override
    public PerformNode visitPerform_r(ArduEasyParser.Perform_rContext ctx) {
        return null;
    }

    @Override
    public WhileNode visitWhile_r(ArduEasyParser.While_rContext ctx) {
        return null;
    }
}