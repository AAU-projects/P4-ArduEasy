public class TestListener extends ArduEasyBaseListener
{
    @Override
    public void enterR(ArduEasyParser.RContext ctx)
    {
        super.enterR(ctx);
    }

    @Override
    public void exitR(ArduEasyParser.RContext ctx)
    {
        super.exitR(ctx);
    }

    @Override
    public void enterSetup(ArduEasyParser.SetupContext ctx)
    {
        System.out.print("setup()\n{\n");
        super.enterSetup(ctx);
    }

    @Override
    public void exitSetup(ArduEasyParser.SetupContext ctx)
    {
        System.out.print("\n}");
        super.exitSetup(ctx);
    }

    @Override
    public void enterDefinitions(ArduEasyParser.DefinitionsContext ctx)
    {
        super.enterDefinitions(ctx);
    }

    @Override
    public void exitDefinitions(ArduEasyParser.DefinitionsContext ctx)
    {
        super.exitDefinitions(ctx);
    }

    @Override
    public void enterDefinition(ArduEasyParser.DefinitionContext ctx)
    {
        super.enterDefinition(ctx);
    }

    @Override
    public void enterPindeclaration(ArduEasyParser.PindeclarationContext ctx)
    {
        String pindec = String.format("pinMode(%s, %s)\n", ctx.pin().INT(), ctx.ioStatus().getText());
        System.out.print(pindec);
        super.enterPindeclaration(ctx);
    }

    @Override
    public void exitDefinition(ArduEasyParser.DefinitionContext ctx)
    {
        super.exitDefinition(ctx);
    }
}
