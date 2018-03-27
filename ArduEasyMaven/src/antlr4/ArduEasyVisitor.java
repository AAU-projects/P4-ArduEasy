// Generated from H:/Github/ArduEasy/ArduEasyMaven/src/antlr4\ArduEasy.g4 by ANTLR 4.7
package antlr4;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ArduEasyParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ArduEasyVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ArduEasyParser#r}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitR(ArduEasyParser.RContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArduEasyParser#setup}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetup(ArduEasyParser.SetupContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArduEasyParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(ArduEasyParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArduEasyParser#definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefinition(ArduEasyParser.DefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArduEasyParser#houseaccess}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHouseaccess(ArduEasyParser.HouseaccessContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArduEasyParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(ArduEasyParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArduEasyParser#roomdeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRoomdeclaration(ArduEasyParser.RoomdeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArduEasyParser#roomblock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRoomblock(ArduEasyParser.RoomblockContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArduEasyParser#arraydeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArraydeclaration(ArduEasyParser.ArraydeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArduEasyParser#identifierloop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierloop(ArduEasyParser.IdentifierloopContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArduEasyParser#pindeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPindeclaration(ArduEasyParser.PindeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArduEasyParser#parameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameters(ArduEasyParser.ParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArduEasyParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(ArduEasyParser.ParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArduEasyParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(ArduEasyParser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArduEasyParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(ArduEasyParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArduEasyParser#perform_r}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPerform_r(ArduEasyParser.Perform_rContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArduEasyParser#for_r}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor_r(ArduEasyParser.For_rContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArduEasyParser#while_r}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile_r(ArduEasyParser.While_rContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArduEasyParser#switch_r}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitch_r(ArduEasyParser.Switch_rContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArduEasyParser#if_r}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_r(ArduEasyParser.If_rContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArduEasyParser#else_r}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElse_r(ArduEasyParser.Else_rContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArduEasyParser#ifElse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfElse(ArduEasyParser.IfElseContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArduEasyParser#cases}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCases(ArduEasyParser.CasesContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArduEasyParser#case_r}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCase_r(ArduEasyParser.Case_rContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArduEasyParser#logicalExpressions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalExpressions(ArduEasyParser.LogicalExpressionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArduEasyParser#logicalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalExpression(ArduEasyParser.LogicalExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArduEasyParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(ArduEasyParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArduEasyParser#addSubExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSubExpression(ArduEasyParser.AddSubExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArduEasyParser#multiDivExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiDivExpression(ArduEasyParser.MultiDivExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArduEasyParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(ArduEasyParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArduEasyParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(ArduEasyParser.ValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArduEasyParser#typeSpecifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeSpecifier(ArduEasyParser.TypeSpecifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArduEasyParser#logicalOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalOperator(ArduEasyParser.LogicalOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArduEasyParser#comparisonOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonOperator(ArduEasyParser.ComparisonOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArduEasyParser#returnType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnType(ArduEasyParser.ReturnTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArduEasyParser#pin}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPin(ArduEasyParser.PinContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArduEasyParser#ioStatus}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIoStatus(ArduEasyParser.IoStatusContext ctx);
}