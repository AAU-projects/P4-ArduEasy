public class TestVisitor extends ArduEasyBaseVisitor
{
    @Override
    public Object visitR(ArduEasyParser.RContext ctx)
    {
        System.out.print("Visit start\n");
        return super.visitR(ctx);
    }

    @Override
    public Object visitSetup(ArduEasyParser.SetupContext ctx)
    {
        System.out.print("Visit setup\n");
        return super.visitSetup(ctx);
    }

    @Override
    public Object visitDeclaration(ArduEasyParser.DeclarationContext ctx)
    {
        System.out.print("Visit declaration\n");
        return super.visitDeclaration(ctx);
    }
}
