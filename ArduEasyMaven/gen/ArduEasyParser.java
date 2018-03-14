// Generated from C:/Workspaces/ArduEasyMaven/src/main/antlr4\ArduEasy.g4 by ANTLR 4.7
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ArduEasyParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ADDITIVEOPERATOR=1, SUBTRACTIVEOPERATOR=2, MULTIPLICATIVEOPERATOR=3, DIVISIONALOPERATOR=4, 
		MODULOOPERATOR=5, ASSIGNMENTOPERATOR=6, EQUALSOPERATOR=7, NEGATEOPERATOR=8, 
		BELOWOPERATOR=9, ABOVEOPERATOR=10, EQUALSORBELOWOPERATOR=11, EQUALSORABOVEOPERATOR=12, 
		ISNOTOPERATOR=13, ANDOPERATOR=14, OROPERATOR=15, LPAREN=16, RPAREN=17, 
		LBRACK=18, RBRACK=19, COLON=20, SEMICOLON=21, COMMA=22, INT=23, FLOAT=24, 
		PERCENTAGE=25, STRING=26, TIME=27, DAY=28, MONTH=29, STRUCT=30, BOOL=31, 
		VOIDDEC=32, INTDEC=33, FLOATDEC=34, STRINGDEC=35, CHARDEC=36, PERCENTAGEDEC=37, 
		STRUCTDEC=38, ARRAYDEC=39, TIMEDEC=40, DAYDEC=41, MONTHDEC=42, BOOLDEC=43, 
		SETUP=44, WHEN=45, FOR=46, WHILE=47, FUNCTION=48, PERFORM=49, TIMES=50, 
		UNTIL=51, IF=52, ELSE=53, SWITCH=54, CASE=55, DEFAULT=56, RETURN=57, AS=58, 
		A=59, PIN=60, INPUT=61, OUTPUT=62, INPUTPULLUP=63, IDENTIFIER=64, IGNORE=65;
	public static final int
		RULE_r = 0, RULE_setup = 1, RULE_functions = 2, RULE_function = 3, RULE_definitions = 4, 
		RULE_definition = 5, RULE_declaration = 6, RULE_parameters = 7, RULE_parameter = 8, 
		RULE_identifier = 9, RULE_statements = 10, RULE_statement = 11, RULE_ifElse = 12, 
		RULE_cases = 13, RULE_case_r = 14, RULE_logicalExpressions = 15, RULE_logicalExpression = 16, 
		RULE_expressions = 17, RULE_expression = 18, RULE_addSubExpression = 19, 
		RULE_multiDivExpression = 20, RULE_assignment = 21, RULE_value = 22, RULE_typeSpecifier = 23, 
		RULE_logicalOperator = 24, RULE_comparisonOperator = 25, RULE_returnType = 26, 
		RULE_pin = 27, RULE_ioStatus = 28;
	public static final String[] ruleNames = {
		"r", "setup", "functions", "function", "definitions", "definition", "declaration", 
		"parameters", "parameter", "identifier", "statements", "statement", "ifElse", 
		"cases", "case_r", "logicalExpressions", "logicalExpression", "expressions", 
		"expression", "addSubExpression", "multiDivExpression", "assignment", 
		"value", "typeSpecifier", "logicalOperator", "comparisonOperator", "returnType", 
		"pin", "ioStatus"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'+'", "'-'", "'*'", "'/'", "'%'", "'='", null, null, null, null, 
		null, null, null, null, null, "'('", "')'", "'{'", "'}'", "':'", "';'", 
		"','", null, null, null, null, null, null, null, "'changethispleasestruct'", 
		null, "'void'", "'int'", "'float'", "'string'", "'char'", "'percentage'", 
		"'struct'", "'array'", "'time'", "'day'", "'month'", "'bool'", "'setup'", 
		"'when'", "'for'", "'while'", "'function'", "'perform'", "'times'", "'until'", 
		"'if'", "'else'", "'switch'", "'case'", "'default'", "'return'", "'as'", 
		"'A'", "'PIN'", "'input'", "'output'", "'inputpullup'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "ADDITIVEOPERATOR", "SUBTRACTIVEOPERATOR", "MULTIPLICATIVEOPERATOR", 
		"DIVISIONALOPERATOR", "MODULOOPERATOR", "ASSIGNMENTOPERATOR", "EQUALSOPERATOR", 
		"NEGATEOPERATOR", "BELOWOPERATOR", "ABOVEOPERATOR", "EQUALSORBELOWOPERATOR", 
		"EQUALSORABOVEOPERATOR", "ISNOTOPERATOR", "ANDOPERATOR", "OROPERATOR", 
		"LPAREN", "RPAREN", "LBRACK", "RBRACK", "COLON", "SEMICOLON", "COMMA", 
		"INT", "FLOAT", "PERCENTAGE", "STRING", "TIME", "DAY", "MONTH", "STRUCT", 
		"BOOL", "VOIDDEC", "INTDEC", "FLOATDEC", "STRINGDEC", "CHARDEC", "PERCENTAGEDEC", 
		"STRUCTDEC", "ARRAYDEC", "TIMEDEC", "DAYDEC", "MONTHDEC", "BOOLDEC", "SETUP", 
		"WHEN", "FOR", "WHILE", "FUNCTION", "PERFORM", "TIMES", "UNTIL", "IF", 
		"ELSE", "SWITCH", "CASE", "DEFAULT", "RETURN", "AS", "A", "PIN", "INPUT", 
		"OUTPUT", "INPUTPULLUP", "IDENTIFIER", "IGNORE"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "ArduEasy.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ArduEasyParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class RContext extends ParserRuleContext {
		public SetupContext setup() {
			return getRuleContext(SetupContext.class,0);
		}
		public FunctionsContext functions() {
			return getRuleContext(FunctionsContext.class,0);
		}
		public TerminalNode EOF() { return getToken(ArduEasyParser.EOF, 0); }
		public RContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_r; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArduEasyListener ) ((ArduEasyListener)listener).enterR(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArduEasyListener ) ((ArduEasyListener)listener).exitR(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArduEasyVisitor ) return ((ArduEasyVisitor<? extends T>)visitor).visitR(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RContext r() throws RecognitionException {
		RContext _localctx = new RContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_r);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			setup();
			setState(59);
			functions();
			setState(60);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SetupContext extends ParserRuleContext {
		public TerminalNode SETUP() { return getToken(ArduEasyParser.SETUP, 0); }
		public TerminalNode LBRACK() { return getToken(ArduEasyParser.LBRACK, 0); }
		public DefinitionsContext definitions() {
			return getRuleContext(DefinitionsContext.class,0);
		}
		public TerminalNode RBRACK() { return getToken(ArduEasyParser.RBRACK, 0); }
		public SetupContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_setup; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArduEasyListener ) ((ArduEasyListener)listener).enterSetup(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArduEasyListener ) ((ArduEasyListener)listener).exitSetup(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArduEasyVisitor ) return ((ArduEasyVisitor<? extends T>)visitor).visitSetup(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SetupContext setup() throws RecognitionException {
		SetupContext _localctx = new SetupContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_setup);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			match(SETUP);
			setState(63);
			match(LBRACK);
			setState(64);
			definitions();
			setState(65);
			match(RBRACK);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionsContext extends ParserRuleContext {
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public FunctionsContext functions() {
			return getRuleContext(FunctionsContext.class,0);
		}
		public FunctionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArduEasyListener ) ((ArduEasyListener)listener).enterFunctions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArduEasyListener ) ((ArduEasyListener)listener).exitFunctions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArduEasyVisitor ) return ((ArduEasyVisitor<? extends T>)visitor).visitFunctions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionsContext functions() throws RecognitionException {
		FunctionsContext _localctx = new FunctionsContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_functions);
		try {
			setState(72);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(67);
				function();
				setState(68);
				functions();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(70);
				function();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionContext extends ParserRuleContext {
		public TerminalNode WHEN() { return getToken(ArduEasyParser.WHEN, 0); }
		public TerminalNode LPAREN() { return getToken(ArduEasyParser.LPAREN, 0); }
		public LogicalExpressionsContext logicalExpressions() {
			return getRuleContext(LogicalExpressionsContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ArduEasyParser.RPAREN, 0); }
		public TerminalNode LBRACK() { return getToken(ArduEasyParser.LBRACK, 0); }
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public TerminalNode RBRACK() { return getToken(ArduEasyParser.RBRACK, 0); }
		public TerminalNode FUNCTION() { return getToken(ArduEasyParser.FUNCTION, 0); }
		public ReturnTypeContext returnType() {
			return getRuleContext(ReturnTypeContext.class,0);
		}
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public TerminalNode RETURN() { return getToken(ArduEasyParser.RETURN, 0); }
		public TerminalNode VOIDDEC() { return getToken(ArduEasyParser.VOIDDEC, 0); }
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArduEasyListener ) ((ArduEasyListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArduEasyListener ) ((ArduEasyListener)listener).exitFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArduEasyVisitor ) return ((ArduEasyVisitor<? extends T>)visitor).visitFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_function);
		try {
			setState(104);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(74);
				match(WHEN);
				setState(75);
				match(LPAREN);
				setState(76);
				logicalExpressions(0);
				setState(77);
				match(RPAREN);
				setState(78);
				match(LBRACK);
				setState(79);
				statements();
				setState(80);
				match(RBRACK);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(82);
				match(FUNCTION);
				setState(83);
				returnType();
				setState(84);
				identifier();
				setState(85);
				match(LPAREN);
				setState(86);
				parameters();
				setState(87);
				match(RPAREN);
				setState(88);
				match(LBRACK);
				setState(89);
				statements();
				setState(90);
				match(RETURN);
				setState(91);
				identifier();
				setState(92);
				match(RBRACK);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(94);
				match(FUNCTION);
				setState(95);
				match(VOIDDEC);
				setState(96);
				identifier();
				setState(97);
				match(LPAREN);
				setState(98);
				parameters();
				setState(99);
				match(RPAREN);
				setState(100);
				match(LBRACK);
				setState(101);
				statements();
				setState(102);
				match(RBRACK);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DefinitionsContext extends ParserRuleContext {
		public DefinitionContext definition() {
			return getRuleContext(DefinitionContext.class,0);
		}
		public DefinitionsContext definitions() {
			return getRuleContext(DefinitionsContext.class,0);
		}
		public DefinitionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definitions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArduEasyListener ) ((ArduEasyListener)listener).enterDefinitions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArduEasyListener ) ((ArduEasyListener)listener).exitDefinitions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArduEasyVisitor ) return ((ArduEasyVisitor<? extends T>)visitor).visitDefinitions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefinitionsContext definitions() throws RecognitionException {
		DefinitionsContext _localctx = new DefinitionsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_definitions);
		try {
			setState(110);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INTDEC:
			case FLOATDEC:
			case STRINGDEC:
			case CHARDEC:
			case PERCENTAGEDEC:
			case STRUCTDEC:
			case TIMEDEC:
			case DAYDEC:
			case MONTHDEC:
			case BOOLDEC:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(106);
				definition();
				setState(107);
				definitions();
				}
				break;
			case RBRACK:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DefinitionContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode ASSIGNMENTOPERATOR() { return getToken(ArduEasyParser.ASSIGNMENTOPERATOR, 0); }
		public PinContext pin() {
			return getRuleContext(PinContext.class,0);
		}
		public TerminalNode AS() { return getToken(ArduEasyParser.AS, 0); }
		public IoStatusContext ioStatus() {
			return getRuleContext(IoStatusContext.class,0);
		}
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public DefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArduEasyListener ) ((ArduEasyListener)listener).enterDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArduEasyListener ) ((ArduEasyListener)listener).exitDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArduEasyVisitor ) return ((ArduEasyVisitor<? extends T>)visitor).visitDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefinitionContext definition() throws RecognitionException {
		DefinitionContext _localctx = new DefinitionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_definition);
		try {
			setState(120);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(112);
				identifier();
				setState(113);
				match(ASSIGNMENTOPERATOR);
				setState(114);
				pin();
				setState(115);
				match(AS);
				setState(116);
				ioStatus();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(118);
				declaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(119);
				assignment();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclarationContext extends ParserRuleContext {
		public TypeSpecifierContext typeSpecifier() {
			return getRuleContext(TypeSpecifierContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode ASSIGNMENTOPERATOR() { return getToken(ArduEasyParser.ASSIGNMENTOPERATOR, 0); }
		public ExpressionsContext expressions() {
			return getRuleContext(ExpressionsContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArduEasyListener ) ((ArduEasyListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArduEasyListener ) ((ArduEasyListener)listener).exitDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArduEasyVisitor ) return ((ArduEasyVisitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_declaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			typeSpecifier();
			setState(123);
			identifier();
			setState(124);
			match(ASSIGNMENTOPERATOR);
			setState(125);
			expressions();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParametersContext extends ParserRuleContext {
		public ParameterContext parameter() {
			return getRuleContext(ParameterContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(ArduEasyParser.COMMA, 0); }
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public ParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArduEasyListener ) ((ArduEasyListener)listener).enterParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArduEasyListener ) ((ArduEasyListener)listener).exitParameters(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArduEasyVisitor ) return ((ArduEasyVisitor<? extends T>)visitor).visitParameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParametersContext parameters() throws RecognitionException {
		ParametersContext _localctx = new ParametersContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_parameters);
		try {
			setState(133);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(127);
				parameter();
				setState(128);
				match(COMMA);
				setState(129);
				parameters();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(131);
				parameter();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParameterContext extends ParserRuleContext {
		public TypeSpecifierContext typeSpecifier() {
			return getRuleContext(TypeSpecifierContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArduEasyListener ) ((ArduEasyListener)listener).enterParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArduEasyListener ) ((ArduEasyListener)listener).exitParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArduEasyVisitor ) return ((ArduEasyVisitor<? extends T>)visitor).visitParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterContext parameter() throws RecognitionException {
		ParameterContext _localctx = new ParameterContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_parameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			typeSpecifier();
			setState(136);
			identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentifierContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(ArduEasyParser.IDENTIFIER, 0); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArduEasyListener ) ((ArduEasyListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArduEasyListener ) ((ArduEasyListener)listener).exitIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArduEasyVisitor ) return ((ArduEasyVisitor<? extends T>)visitor).visitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_identifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementsContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public StatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArduEasyListener ) ((ArduEasyListener)listener).enterStatements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArduEasyListener ) ((ArduEasyListener)listener).exitStatements(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArduEasyVisitor ) return ((ArduEasyVisitor<? extends T>)visitor).visitStatements(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementsContext statements() throws RecognitionException {
		StatementsContext _localctx = new StatementsContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_statements);
		try {
			setState(144);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INTDEC:
			case FLOATDEC:
			case STRINGDEC:
			case CHARDEC:
			case PERCENTAGEDEC:
			case STRUCTDEC:
			case TIMEDEC:
			case DAYDEC:
			case MONTHDEC:
			case BOOLDEC:
			case FOR:
			case WHILE:
			case PERFORM:
			case IF:
			case SWITCH:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(140);
				statement();
				setState(141);
				statements();
				}
				break;
			case RBRACK:
			case RETURN:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public TerminalNode IF() { return getToken(ArduEasyParser.IF, 0); }
		public List<TerminalNode> LPAREN() { return getTokens(ArduEasyParser.LPAREN); }
		public TerminalNode LPAREN(int i) {
			return getToken(ArduEasyParser.LPAREN, i);
		}
		public List<LogicalExpressionsContext> logicalExpressions() {
			return getRuleContexts(LogicalExpressionsContext.class);
		}
		public LogicalExpressionsContext logicalExpressions(int i) {
			return getRuleContext(LogicalExpressionsContext.class,i);
		}
		public List<TerminalNode> RPAREN() { return getTokens(ArduEasyParser.RPAREN); }
		public TerminalNode RPAREN(int i) {
			return getToken(ArduEasyParser.RPAREN, i);
		}
		public List<TerminalNode> LBRACK() { return getTokens(ArduEasyParser.LBRACK); }
		public TerminalNode LBRACK(int i) {
			return getToken(ArduEasyParser.LBRACK, i);
		}
		public List<StatementsContext> statements() {
			return getRuleContexts(StatementsContext.class);
		}
		public StatementsContext statements(int i) {
			return getRuleContext(StatementsContext.class,i);
		}
		public List<TerminalNode> RBRACK() { return getTokens(ArduEasyParser.RBRACK); }
		public TerminalNode RBRACK(int i) {
			return getToken(ArduEasyParser.RBRACK, i);
		}
		public IfElseContext ifElse() {
			return getRuleContext(IfElseContext.class,0);
		}
		public TerminalNode ELSE() { return getToken(ArduEasyParser.ELSE, 0); }
		public TerminalNode SWITCH() { return getToken(ArduEasyParser.SWITCH, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public CasesContext cases() {
			return getRuleContext(CasesContext.class,0);
		}
		public TerminalNode WHILE() { return getToken(ArduEasyParser.WHILE, 0); }
		public TerminalNode FOR() { return getToken(ArduEasyParser.FOR, 0); }
		public List<TerminalNode> SEMICOLON() { return getTokens(ArduEasyParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(ArduEasyParser.SEMICOLON, i);
		}
		public ExpressionsContext expressions() {
			return getRuleContext(ExpressionsContext.class,0);
		}
		public TerminalNode PERFORM() { return getToken(ArduEasyParser.PERFORM, 0); }
		public TerminalNode INT() { return getToken(ArduEasyParser.INT, 0); }
		public TerminalNode TIMES() { return getToken(ArduEasyParser.TIMES, 0); }
		public TerminalNode UNTIL() { return getToken(ArduEasyParser.UNTIL, 0); }
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArduEasyListener ) ((ArduEasyListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArduEasyListener ) ((ArduEasyListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArduEasyVisitor ) return ((ArduEasyVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_statement);
		try {
			setState(234);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(146);
				declaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(147);
				assignment();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(148);
				match(IF);
				setState(149);
				match(LPAREN);
				setState(150);
				logicalExpressions(0);
				setState(151);
				match(RPAREN);
				setState(152);
				match(LBRACK);
				setState(153);
				statements();
				setState(154);
				match(RBRACK);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(156);
				match(IF);
				setState(157);
				match(LPAREN);
				setState(158);
				logicalExpressions(0);
				setState(159);
				match(RPAREN);
				setState(160);
				match(LBRACK);
				setState(161);
				statements();
				setState(162);
				match(RBRACK);
				setState(163);
				ifElse();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(165);
				match(IF);
				setState(166);
				match(LPAREN);
				setState(167);
				logicalExpressions(0);
				setState(168);
				match(RPAREN);
				setState(169);
				match(LBRACK);
				setState(170);
				statements();
				setState(171);
				match(RBRACK);
				setState(172);
				match(ELSE);
				setState(173);
				match(LPAREN);
				setState(174);
				logicalExpressions(0);
				setState(175);
				match(RPAREN);
				setState(176);
				match(LBRACK);
				setState(177);
				statements();
				setState(178);
				match(RBRACK);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(180);
				match(SWITCH);
				setState(181);
				match(LPAREN);
				setState(182);
				value();
				setState(183);
				match(RPAREN);
				setState(184);
				match(LBRACK);
				setState(185);
				cases();
				setState(186);
				match(RBRACK);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(188);
				match(WHILE);
				setState(189);
				match(LPAREN);
				setState(190);
				logicalExpressions(0);
				setState(191);
				match(RPAREN);
				setState(192);
				match(LBRACK);
				setState(193);
				statements();
				setState(194);
				match(RBRACK);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(196);
				match(FOR);
				setState(197);
				match(LPAREN);
				setState(198);
				declaration();
				setState(199);
				match(SEMICOLON);
				setState(200);
				logicalExpressions(0);
				setState(201);
				match(SEMICOLON);
				setState(202);
				expressions();
				setState(203);
				match(RPAREN);
				setState(204);
				match(LBRACK);
				setState(205);
				statements();
				setState(206);
				match(RBRACK);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(208);
				match(FOR);
				setState(209);
				match(LPAREN);
				setState(210);
				assignment();
				setState(211);
				match(SEMICOLON);
				setState(212);
				logicalExpressions(0);
				setState(213);
				match(SEMICOLON);
				setState(214);
				expressions();
				setState(215);
				match(RPAREN);
				setState(216);
				match(LBRACK);
				setState(217);
				statements();
				setState(218);
				match(RBRACK);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(220);
				match(PERFORM);
				setState(221);
				match(INT);
				setState(222);
				match(TIMES);
				setState(223);
				match(LBRACK);
				setState(224);
				statements();
				setState(225);
				match(RBRACK);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(227);
				match(PERFORM);
				setState(228);
				match(UNTIL);
				setState(229);
				logicalExpressions(0);
				setState(230);
				match(LBRACK);
				setState(231);
				statements();
				setState(232);
				match(RBRACK);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfElseContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(ArduEasyParser.IF, 0); }
		public List<TerminalNode> ELSE() { return getTokens(ArduEasyParser.ELSE); }
		public TerminalNode ELSE(int i) {
			return getToken(ArduEasyParser.ELSE, i);
		}
		public List<TerminalNode> LPAREN() { return getTokens(ArduEasyParser.LPAREN); }
		public TerminalNode LPAREN(int i) {
			return getToken(ArduEasyParser.LPAREN, i);
		}
		public List<LogicalExpressionsContext> logicalExpressions() {
			return getRuleContexts(LogicalExpressionsContext.class);
		}
		public LogicalExpressionsContext logicalExpressions(int i) {
			return getRuleContext(LogicalExpressionsContext.class,i);
		}
		public List<TerminalNode> RPAREN() { return getTokens(ArduEasyParser.RPAREN); }
		public TerminalNode RPAREN(int i) {
			return getToken(ArduEasyParser.RPAREN, i);
		}
		public List<TerminalNode> LBRACK() { return getTokens(ArduEasyParser.LBRACK); }
		public TerminalNode LBRACK(int i) {
			return getToken(ArduEasyParser.LBRACK, i);
		}
		public List<StatementsContext> statements() {
			return getRuleContexts(StatementsContext.class);
		}
		public StatementsContext statements(int i) {
			return getRuleContext(StatementsContext.class,i);
		}
		public List<TerminalNode> RBRACK() { return getTokens(ArduEasyParser.RBRACK); }
		public TerminalNode RBRACK(int i) {
			return getToken(ArduEasyParser.RBRACK, i);
		}
		public IfElseContext ifElse() {
			return getRuleContext(IfElseContext.class,0);
		}
		public IfElseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifElse; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArduEasyListener ) ((ArduEasyListener)listener).enterIfElse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArduEasyListener ) ((ArduEasyListener)listener).exitIfElse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArduEasyVisitor ) return ((ArduEasyVisitor<? extends T>)visitor).visitIfElse(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfElseContext ifElse() throws RecognitionException {
		IfElseContext _localctx = new IfElseContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_ifElse);
		try {
			setState(271);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(236);
				match(IF);
				setState(237);
				match(ELSE);
				setState(238);
				match(LPAREN);
				setState(239);
				logicalExpressions(0);
				setState(240);
				match(RPAREN);
				setState(241);
				match(LBRACK);
				setState(242);
				statements();
				setState(243);
				match(RBRACK);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(245);
				match(IF);
				setState(246);
				match(ELSE);
				setState(247);
				match(LPAREN);
				setState(248);
				logicalExpressions(0);
				setState(249);
				match(RPAREN);
				setState(250);
				match(LBRACK);
				setState(251);
				statements();
				setState(252);
				match(RBRACK);
				setState(253);
				ifElse();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(255);
				match(IF);
				setState(256);
				match(ELSE);
				setState(257);
				match(LPAREN);
				setState(258);
				logicalExpressions(0);
				setState(259);
				match(RPAREN);
				setState(260);
				match(LBRACK);
				setState(261);
				statements();
				setState(262);
				match(RBRACK);
				setState(263);
				match(ELSE);
				setState(264);
				match(LPAREN);
				setState(265);
				logicalExpressions(0);
				setState(266);
				match(RPAREN);
				setState(267);
				match(LBRACK);
				setState(268);
				statements();
				setState(269);
				match(RBRACK);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CasesContext extends ParserRuleContext {
		public Case_rContext case_r() {
			return getRuleContext(Case_rContext.class,0);
		}
		public CasesContext cases() {
			return getRuleContext(CasesContext.class,0);
		}
		public TerminalNode DEFAULT() { return getToken(ArduEasyParser.DEFAULT, 0); }
		public TerminalNode COLON() { return getToken(ArduEasyParser.COLON, 0); }
		public TerminalNode LBRACK() { return getToken(ArduEasyParser.LBRACK, 0); }
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public TerminalNode RBRACK() { return getToken(ArduEasyParser.RBRACK, 0); }
		public CasesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cases; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArduEasyListener ) ((ArduEasyListener)listener).enterCases(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArduEasyListener ) ((ArduEasyListener)listener).exitCases(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArduEasyVisitor ) return ((ArduEasyVisitor<? extends T>)visitor).visitCases(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CasesContext cases() throws RecognitionException {
		CasesContext _localctx = new CasesContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_cases);
		try {
			setState(283);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(273);
				case_r();
				setState(274);
				cases();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(276);
				case_r();
				setState(277);
				match(DEFAULT);
				setState(278);
				match(COLON);
				setState(279);
				match(LBRACK);
				setState(280);
				statements();
				setState(281);
				match(RBRACK);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Case_rContext extends ParserRuleContext {
		public TerminalNode CASE() { return getToken(ArduEasyParser.CASE, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public TerminalNode COLON() { return getToken(ArduEasyParser.COLON, 0); }
		public TerminalNode LBRACK() { return getToken(ArduEasyParser.LBRACK, 0); }
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public TerminalNode RBRACK() { return getToken(ArduEasyParser.RBRACK, 0); }
		public Case_rContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_case_r; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArduEasyListener ) ((ArduEasyListener)listener).enterCase_r(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArduEasyListener ) ((ArduEasyListener)listener).exitCase_r(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArduEasyVisitor ) return ((ArduEasyVisitor<? extends T>)visitor).visitCase_r(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Case_rContext case_r() throws RecognitionException {
		Case_rContext _localctx = new Case_rContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_case_r);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(285);
			match(CASE);
			setState(286);
			value();
			setState(287);
			match(COLON);
			setState(288);
			match(LBRACK);
			setState(289);
			statements();
			setState(290);
			match(RBRACK);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LogicalExpressionsContext extends ParserRuleContext {
		public LogicalExpressionContext logicalExpression() {
			return getRuleContext(LogicalExpressionContext.class,0);
		}
		public List<LogicalExpressionsContext> logicalExpressions() {
			return getRuleContexts(LogicalExpressionsContext.class);
		}
		public LogicalExpressionsContext logicalExpressions(int i) {
			return getRuleContext(LogicalExpressionsContext.class,i);
		}
		public LogicalOperatorContext logicalOperator() {
			return getRuleContext(LogicalOperatorContext.class,0);
		}
		public LogicalExpressionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalExpressions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArduEasyListener ) ((ArduEasyListener)listener).enterLogicalExpressions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArduEasyListener ) ((ArduEasyListener)listener).exitLogicalExpressions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArduEasyVisitor ) return ((ArduEasyVisitor<? extends T>)visitor).visitLogicalExpressions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogicalExpressionsContext logicalExpressions() throws RecognitionException {
		return logicalExpressions(0);
	}

	private LogicalExpressionsContext logicalExpressions(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		LogicalExpressionsContext _localctx = new LogicalExpressionsContext(_ctx, _parentState);
		LogicalExpressionsContext _prevctx = _localctx;
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_logicalExpressions, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(293);
			logicalExpression();
			}
			_ctx.stop = _input.LT(-1);
			setState(301);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new LogicalExpressionsContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_logicalExpressions);
					setState(295);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(296);
					logicalOperator();
					setState(297);
					logicalExpressions(3);
					}
					} 
				}
				setState(303);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class LogicalExpressionContext extends ParserRuleContext {
		public List<ExpressionsContext> expressions() {
			return getRuleContexts(ExpressionsContext.class);
		}
		public ExpressionsContext expressions(int i) {
			return getRuleContext(ExpressionsContext.class,i);
		}
		public ComparisonOperatorContext comparisonOperator() {
			return getRuleContext(ComparisonOperatorContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode NEGATEOPERATOR() { return getToken(ArduEasyParser.NEGATEOPERATOR, 0); }
		public LogicalExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArduEasyListener ) ((ArduEasyListener)listener).enterLogicalExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArduEasyListener ) ((ArduEasyListener)listener).exitLogicalExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArduEasyVisitor ) return ((ArduEasyVisitor<? extends T>)visitor).visitLogicalExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogicalExpressionContext logicalExpression() throws RecognitionException {
		LogicalExpressionContext _localctx = new LogicalExpressionContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_logicalExpression);
		try {
			setState(311);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(304);
				expressions();
				setState(305);
				comparisonOperator();
				setState(306);
				expressions();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(308);
				identifier();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(309);
				match(NEGATEOPERATOR);
				setState(310);
				identifier();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionsContext extends ParserRuleContext {
		public AddSubExpressionContext addSubExpression() {
			return getRuleContext(AddSubExpressionContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArduEasyListener ) ((ArduEasyListener)listener).enterExpressions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArduEasyListener ) ((ArduEasyListener)listener).exitExpressions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArduEasyVisitor ) return ((ArduEasyVisitor<? extends T>)visitor).visitExpressions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionsContext expressions() throws RecognitionException {
		ExpressionsContext _localctx = new ExpressionsContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_expressions);
		try {
			setState(315);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(313);
				addSubExpression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(314);
				expression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArduEasyListener ) ((ArduEasyListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArduEasyListener ) ((ArduEasyListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArduEasyVisitor ) return ((ArduEasyVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_expression);
		try {
			setState(319);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(317);
				identifier();
				}
				break;
			case INT:
			case FLOAT:
			case PERCENTAGE:
			case STRING:
			case BOOL:
				enterOuterAlt(_localctx, 2);
				{
				setState(318);
				value();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AddSubExpressionContext extends ParserRuleContext {
		public MultiDivExpressionContext multiDivExpression() {
			return getRuleContext(MultiDivExpressionContext.class,0);
		}
		public AddSubExpressionContext addSubExpression() {
			return getRuleContext(AddSubExpressionContext.class,0);
		}
		public TerminalNode ADDITIVEOPERATOR() { return getToken(ArduEasyParser.ADDITIVEOPERATOR, 0); }
		public TerminalNode SUBTRACTIVEOPERATOR() { return getToken(ArduEasyParser.SUBTRACTIVEOPERATOR, 0); }
		public AddSubExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addSubExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArduEasyListener ) ((ArduEasyListener)listener).enterAddSubExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArduEasyListener ) ((ArduEasyListener)listener).exitAddSubExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArduEasyVisitor ) return ((ArduEasyVisitor<? extends T>)visitor).visitAddSubExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AddSubExpressionContext addSubExpression() throws RecognitionException {
		return addSubExpression(0);
	}

	private AddSubExpressionContext addSubExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AddSubExpressionContext _localctx = new AddSubExpressionContext(_ctx, _parentState);
		AddSubExpressionContext _prevctx = _localctx;
		int _startState = 38;
		enterRecursionRule(_localctx, 38, RULE_addSubExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(322);
			multiDivExpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(332);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(330);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
					case 1:
						{
						_localctx = new AddSubExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_addSubExpression);
						setState(324);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(325);
						match(ADDITIVEOPERATOR);
						setState(326);
						multiDivExpression(0);
						}
						break;
					case 2:
						{
						_localctx = new AddSubExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_addSubExpression);
						setState(327);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(328);
						match(SUBTRACTIVEOPERATOR);
						setState(329);
						multiDivExpression(0);
						}
						break;
					}
					} 
				}
				setState(334);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class MultiDivExpressionContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public MultiDivExpressionContext multiDivExpression() {
			return getRuleContext(MultiDivExpressionContext.class,0);
		}
		public TerminalNode MULTIPLICATIVEOPERATOR() { return getToken(ArduEasyParser.MULTIPLICATIVEOPERATOR, 0); }
		public TerminalNode DIVISIONALOPERATOR() { return getToken(ArduEasyParser.DIVISIONALOPERATOR, 0); }
		public MultiDivExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiDivExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArduEasyListener ) ((ArduEasyListener)listener).enterMultiDivExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArduEasyListener ) ((ArduEasyListener)listener).exitMultiDivExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArduEasyVisitor ) return ((ArduEasyVisitor<? extends T>)visitor).visitMultiDivExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultiDivExpressionContext multiDivExpression() throws RecognitionException {
		return multiDivExpression(0);
	}

	private MultiDivExpressionContext multiDivExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		MultiDivExpressionContext _localctx = new MultiDivExpressionContext(_ctx, _parentState);
		MultiDivExpressionContext _prevctx = _localctx;
		int _startState = 40;
		enterRecursionRule(_localctx, 40, RULE_multiDivExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(336);
			expression();
			}
			_ctx.stop = _input.LT(-1);
			setState(346);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(344);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
					case 1:
						{
						_localctx = new MultiDivExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_multiDivExpression);
						setState(338);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(339);
						match(MULTIPLICATIVEOPERATOR);
						setState(340);
						expression();
						}
						break;
					case 2:
						{
						_localctx = new MultiDivExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_multiDivExpression);
						setState(341);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(342);
						match(DIVISIONALOPERATOR);
						setState(343);
						expression();
						}
						break;
					}
					} 
				}
				setState(348);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class AssignmentContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode ASSIGNMENTOPERATOR() { return getToken(ArduEasyParser.ASSIGNMENTOPERATOR, 0); }
		public ExpressionsContext expressions() {
			return getRuleContext(ExpressionsContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArduEasyListener ) ((ArduEasyListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArduEasyListener ) ((ArduEasyListener)listener).exitAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArduEasyVisitor ) return ((ArduEasyVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(349);
			identifier();
			setState(350);
			match(ASSIGNMENTOPERATOR);
			setState(351);
			expressions();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ValueContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(ArduEasyParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(ArduEasyParser.FLOAT, 0); }
		public TerminalNode PERCENTAGE() { return getToken(ArduEasyParser.PERCENTAGE, 0); }
		public TerminalNode STRING() { return getToken(ArduEasyParser.STRING, 0); }
		public TerminalNode BOOL() { return getToken(ArduEasyParser.BOOL, 0); }
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArduEasyListener ) ((ArduEasyListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArduEasyListener ) ((ArduEasyListener)listener).exitValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArduEasyVisitor ) return ((ArduEasyVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(353);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << FLOAT) | (1L << PERCENTAGE) | (1L << STRING) | (1L << BOOL))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeSpecifierContext extends ParserRuleContext {
		public TerminalNode INTDEC() { return getToken(ArduEasyParser.INTDEC, 0); }
		public TerminalNode FLOATDEC() { return getToken(ArduEasyParser.FLOATDEC, 0); }
		public TerminalNode PERCENTAGEDEC() { return getToken(ArduEasyParser.PERCENTAGEDEC, 0); }
		public TerminalNode CHARDEC() { return getToken(ArduEasyParser.CHARDEC, 0); }
		public TerminalNode STRINGDEC() { return getToken(ArduEasyParser.STRINGDEC, 0); }
		public TerminalNode TIMEDEC() { return getToken(ArduEasyParser.TIMEDEC, 0); }
		public TerminalNode DAYDEC() { return getToken(ArduEasyParser.DAYDEC, 0); }
		public TerminalNode MONTHDEC() { return getToken(ArduEasyParser.MONTHDEC, 0); }
		public TerminalNode STRUCTDEC() { return getToken(ArduEasyParser.STRUCTDEC, 0); }
		public TerminalNode BOOLDEC() { return getToken(ArduEasyParser.BOOLDEC, 0); }
		public TypeSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeSpecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArduEasyListener ) ((ArduEasyListener)listener).enterTypeSpecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArduEasyListener ) ((ArduEasyListener)listener).exitTypeSpecifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArduEasyVisitor ) return ((ArduEasyVisitor<? extends T>)visitor).visitTypeSpecifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeSpecifierContext typeSpecifier() throws RecognitionException {
		TypeSpecifierContext _localctx = new TypeSpecifierContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_typeSpecifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(355);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INTDEC) | (1L << FLOATDEC) | (1L << STRINGDEC) | (1L << CHARDEC) | (1L << PERCENTAGEDEC) | (1L << STRUCTDEC) | (1L << TIMEDEC) | (1L << DAYDEC) | (1L << MONTHDEC) | (1L << BOOLDEC))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LogicalOperatorContext extends ParserRuleContext {
		public TerminalNode ANDOPERATOR() { return getToken(ArduEasyParser.ANDOPERATOR, 0); }
		public TerminalNode OROPERATOR() { return getToken(ArduEasyParser.OROPERATOR, 0); }
		public LogicalOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArduEasyListener ) ((ArduEasyListener)listener).enterLogicalOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArduEasyListener ) ((ArduEasyListener)listener).exitLogicalOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArduEasyVisitor ) return ((ArduEasyVisitor<? extends T>)visitor).visitLogicalOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogicalOperatorContext logicalOperator() throws RecognitionException {
		LogicalOperatorContext _localctx = new LogicalOperatorContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_logicalOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(357);
			_la = _input.LA(1);
			if ( !(_la==ANDOPERATOR || _la==OROPERATOR) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComparisonOperatorContext extends ParserRuleContext {
		public TerminalNode EQUALSOPERATOR() { return getToken(ArduEasyParser.EQUALSOPERATOR, 0); }
		public TerminalNode BELOWOPERATOR() { return getToken(ArduEasyParser.BELOWOPERATOR, 0); }
		public TerminalNode ABOVEOPERATOR() { return getToken(ArduEasyParser.ABOVEOPERATOR, 0); }
		public TerminalNode EQUALSORBELOWOPERATOR() { return getToken(ArduEasyParser.EQUALSORBELOWOPERATOR, 0); }
		public TerminalNode EQUALSORABOVEOPERATOR() { return getToken(ArduEasyParser.EQUALSORABOVEOPERATOR, 0); }
		public TerminalNode ISNOTOPERATOR() { return getToken(ArduEasyParser.ISNOTOPERATOR, 0); }
		public ComparisonOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparisonOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArduEasyListener ) ((ArduEasyListener)listener).enterComparisonOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArduEasyListener ) ((ArduEasyListener)listener).exitComparisonOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArduEasyVisitor ) return ((ArduEasyVisitor<? extends T>)visitor).visitComparisonOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComparisonOperatorContext comparisonOperator() throws RecognitionException {
		ComparisonOperatorContext _localctx = new ComparisonOperatorContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_comparisonOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(359);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQUALSOPERATOR) | (1L << BELOWOPERATOR) | (1L << ABOVEOPERATOR) | (1L << EQUALSORBELOWOPERATOR) | (1L << EQUALSORABOVEOPERATOR) | (1L << ISNOTOPERATOR))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReturnTypeContext extends ParserRuleContext {
		public TerminalNode VOIDDEC() { return getToken(ArduEasyParser.VOIDDEC, 0); }
		public TypeSpecifierContext typeSpecifier() {
			return getRuleContext(TypeSpecifierContext.class,0);
		}
		public ReturnTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArduEasyListener ) ((ArduEasyListener)listener).enterReturnType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArduEasyListener ) ((ArduEasyListener)listener).exitReturnType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArduEasyVisitor ) return ((ArduEasyVisitor<? extends T>)visitor).visitReturnType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnTypeContext returnType() throws RecognitionException {
		ReturnTypeContext _localctx = new ReturnTypeContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_returnType);
		try {
			setState(363);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VOIDDEC:
				enterOuterAlt(_localctx, 1);
				{
				setState(361);
				match(VOIDDEC);
				}
				break;
			case INTDEC:
			case FLOATDEC:
			case STRINGDEC:
			case CHARDEC:
			case PERCENTAGEDEC:
			case STRUCTDEC:
			case TIMEDEC:
			case DAYDEC:
			case MONTHDEC:
			case BOOLDEC:
				enterOuterAlt(_localctx, 2);
				{
				setState(362);
				typeSpecifier();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PinContext extends ParserRuleContext {
		public TerminalNode PIN() { return getToken(ArduEasyParser.PIN, 0); }
		public TerminalNode INT() { return getToken(ArduEasyParser.INT, 0); }
		public TerminalNode A() { return getToken(ArduEasyParser.A, 0); }
		public PinContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pin; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArduEasyListener ) ((ArduEasyListener)listener).enterPin(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArduEasyListener ) ((ArduEasyListener)listener).exitPin(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArduEasyVisitor ) return ((ArduEasyVisitor<? extends T>)visitor).visitPin(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PinContext pin() throws RecognitionException {
		PinContext _localctx = new PinContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_pin);
		try {
			setState(370);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(365);
				match(PIN);
				setState(366);
				match(INT);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(367);
				match(PIN);
				setState(368);
				match(A);
				setState(369);
				match(INT);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IoStatusContext extends ParserRuleContext {
		public TerminalNode INPUT() { return getToken(ArduEasyParser.INPUT, 0); }
		public TerminalNode OUTPUT() { return getToken(ArduEasyParser.OUTPUT, 0); }
		public TerminalNode INPUTPULLUP() { return getToken(ArduEasyParser.INPUTPULLUP, 0); }
		public IoStatusContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ioStatus; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArduEasyListener ) ((ArduEasyListener)listener).enterIoStatus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArduEasyListener ) ((ArduEasyListener)listener).exitIoStatus(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArduEasyVisitor ) return ((ArduEasyVisitor<? extends T>)visitor).visitIoStatus(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IoStatusContext ioStatus() throws RecognitionException {
		IoStatusContext _localctx = new IoStatusContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_ioStatus);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(372);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INPUT) | (1L << OUTPUT) | (1L << INPUTPULLUP))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 15:
			return logicalExpressions_sempred((LogicalExpressionsContext)_localctx, predIndex);
		case 19:
			return addSubExpression_sempred((AddSubExpressionContext)_localctx, predIndex);
		case 20:
			return multiDivExpression_sempred((MultiDivExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean logicalExpressions_sempred(LogicalExpressionsContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean addSubExpression_sempred(AddSubExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 2);
		case 2:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean multiDivExpression_sempred(MultiDivExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 3);
		case 4:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3C\u0179\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\3\2\3\2\3\2\3\2\3\3"+
		"\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\5\4K\n\4\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5k\n\5\3\6\3\6\3\6\3\6\5\6q\n\6\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\5\7{\n\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\5\t\u0088\n\t\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\f\5\f\u0093\n"+
		"\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\5\r\u00ed\n\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u0112\n\16"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u011e\n\17\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\7\21"+
		"\u012e\n\21\f\21\16\21\u0131\13\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\5\22\u013a\n\22\3\23\3\23\5\23\u013e\n\23\3\24\3\24\5\24\u0142\n\24\3"+
		"\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\7\25\u014d\n\25\f\25\16\25"+
		"\u0150\13\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\7\26\u015b\n"+
		"\26\f\26\16\26\u015e\13\26\3\27\3\27\3\27\3\27\3\30\3\30\3\31\3\31\3\32"+
		"\3\32\3\33\3\33\3\34\3\34\5\34\u016e\n\34\3\35\3\35\3\35\3\35\3\35\5\35"+
		"\u0175\n\35\3\36\3\36\3\36\2\5 (*\37\2\4\6\b\n\f\16\20\22\24\26\30\32"+
		"\34\36 \"$&(*,.\60\62\64\668:\2\7\4\2\31\34!!\4\2#(*-\3\2\20\21\4\2\t"+
		"\t\13\17\3\2?A\2\u017d\2<\3\2\2\2\4@\3\2\2\2\6J\3\2\2\2\bj\3\2\2\2\np"+
		"\3\2\2\2\fz\3\2\2\2\16|\3\2\2\2\20\u0087\3\2\2\2\22\u0089\3\2\2\2\24\u008c"+
		"\3\2\2\2\26\u0092\3\2\2\2\30\u00ec\3\2\2\2\32\u0111\3\2\2\2\34\u011d\3"+
		"\2\2\2\36\u011f\3\2\2\2 \u0126\3\2\2\2\"\u0139\3\2\2\2$\u013d\3\2\2\2"+
		"&\u0141\3\2\2\2(\u0143\3\2\2\2*\u0151\3\2\2\2,\u015f\3\2\2\2.\u0163\3"+
		"\2\2\2\60\u0165\3\2\2\2\62\u0167\3\2\2\2\64\u0169\3\2\2\2\66\u016d\3\2"+
		"\2\28\u0174\3\2\2\2:\u0176\3\2\2\2<=\5\4\3\2=>\5\6\4\2>?\7\2\2\3?\3\3"+
		"\2\2\2@A\7.\2\2AB\7\24\2\2BC\5\n\6\2CD\7\25\2\2D\5\3\2\2\2EF\5\b\5\2F"+
		"G\5\6\4\2GK\3\2\2\2HK\5\b\5\2IK\3\2\2\2JE\3\2\2\2JH\3\2\2\2JI\3\2\2\2"+
		"K\7\3\2\2\2LM\7/\2\2MN\7\22\2\2NO\5 \21\2OP\7\23\2\2PQ\7\24\2\2QR\5\26"+
		"\f\2RS\7\25\2\2Sk\3\2\2\2TU\7\62\2\2UV\5\66\34\2VW\5\24\13\2WX\7\22\2"+
		"\2XY\5\20\t\2YZ\7\23\2\2Z[\7\24\2\2[\\\5\26\f\2\\]\7;\2\2]^\5\24\13\2"+
		"^_\7\25\2\2_k\3\2\2\2`a\7\62\2\2ab\7\"\2\2bc\5\24\13\2cd\7\22\2\2de\5"+
		"\20\t\2ef\7\23\2\2fg\7\24\2\2gh\5\26\f\2hi\7\25\2\2ik\3\2\2\2jL\3\2\2"+
		"\2jT\3\2\2\2j`\3\2\2\2k\t\3\2\2\2lm\5\f\7\2mn\5\n\6\2nq\3\2\2\2oq\3\2"+
		"\2\2pl\3\2\2\2po\3\2\2\2q\13\3\2\2\2rs\5\24\13\2st\7\b\2\2tu\58\35\2u"+
		"v\7<\2\2vw\5:\36\2w{\3\2\2\2x{\5\16\b\2y{\5,\27\2zr\3\2\2\2zx\3\2\2\2"+
		"zy\3\2\2\2{\r\3\2\2\2|}\5\60\31\2}~\5\24\13\2~\177\7\b\2\2\177\u0080\5"+
		"$\23\2\u0080\17\3\2\2\2\u0081\u0082\5\22\n\2\u0082\u0083\7\30\2\2\u0083"+
		"\u0084\5\20\t\2\u0084\u0088\3\2\2\2\u0085\u0088\5\22\n\2\u0086\u0088\3"+
		"\2\2\2\u0087\u0081\3\2\2\2\u0087\u0085\3\2\2\2\u0087\u0086\3\2\2\2\u0088"+
		"\21\3\2\2\2\u0089\u008a\5\60\31\2\u008a\u008b\5\24\13\2\u008b\23\3\2\2"+
		"\2\u008c\u008d\7B\2\2\u008d\25\3\2\2\2\u008e\u008f\5\30\r\2\u008f\u0090"+
		"\5\26\f\2\u0090\u0093\3\2\2\2\u0091\u0093\3\2\2\2\u0092\u008e\3\2\2\2"+
		"\u0092\u0091\3\2\2\2\u0093\27\3\2\2\2\u0094\u00ed\5\16\b\2\u0095\u00ed"+
		"\5,\27\2\u0096\u0097\7\66\2\2\u0097\u0098\7\22\2\2\u0098\u0099\5 \21\2"+
		"\u0099\u009a\7\23\2\2\u009a\u009b\7\24\2\2\u009b\u009c\5\26\f\2\u009c"+
		"\u009d\7\25\2\2\u009d\u00ed\3\2\2\2\u009e\u009f\7\66\2\2\u009f\u00a0\7"+
		"\22\2\2\u00a0\u00a1\5 \21\2\u00a1\u00a2\7\23\2\2\u00a2\u00a3\7\24\2\2"+
		"\u00a3\u00a4\5\26\f\2\u00a4\u00a5\7\25\2\2\u00a5\u00a6\5\32\16\2\u00a6"+
		"\u00ed\3\2\2\2\u00a7\u00a8\7\66\2\2\u00a8\u00a9\7\22\2\2\u00a9\u00aa\5"+
		" \21\2\u00aa\u00ab\7\23\2\2\u00ab\u00ac\7\24\2\2\u00ac\u00ad\5\26\f\2"+
		"\u00ad\u00ae\7\25\2\2\u00ae\u00af\7\67\2\2\u00af\u00b0\7\22\2\2\u00b0"+
		"\u00b1\5 \21\2\u00b1\u00b2\7\23\2\2\u00b2\u00b3\7\24\2\2\u00b3\u00b4\5"+
		"\26\f\2\u00b4\u00b5\7\25\2\2\u00b5\u00ed\3\2\2\2\u00b6\u00b7\78\2\2\u00b7"+
		"\u00b8\7\22\2\2\u00b8\u00b9\5.\30\2\u00b9\u00ba\7\23\2\2\u00ba\u00bb\7"+
		"\24\2\2\u00bb\u00bc\5\34\17\2\u00bc\u00bd\7\25\2\2\u00bd\u00ed\3\2\2\2"+
		"\u00be\u00bf\7\61\2\2\u00bf\u00c0\7\22\2\2\u00c0\u00c1\5 \21\2\u00c1\u00c2"+
		"\7\23\2\2\u00c2\u00c3\7\24\2\2\u00c3\u00c4\5\26\f\2\u00c4\u00c5\7\25\2"+
		"\2\u00c5\u00ed\3\2\2\2\u00c6\u00c7\7\60\2\2\u00c7\u00c8\7\22\2\2\u00c8"+
		"\u00c9\5\16\b\2\u00c9\u00ca\7\27\2\2\u00ca\u00cb\5 \21\2\u00cb\u00cc\7"+
		"\27\2\2\u00cc\u00cd\5$\23\2\u00cd\u00ce\7\23\2\2\u00ce\u00cf\7\24\2\2"+
		"\u00cf\u00d0\5\26\f\2\u00d0\u00d1\7\25\2\2\u00d1\u00ed\3\2\2\2\u00d2\u00d3"+
		"\7\60\2\2\u00d3\u00d4\7\22\2\2\u00d4\u00d5\5,\27\2\u00d5\u00d6\7\27\2"+
		"\2\u00d6\u00d7\5 \21\2\u00d7\u00d8\7\27\2\2\u00d8\u00d9\5$\23\2\u00d9"+
		"\u00da\7\23\2\2\u00da\u00db\7\24\2\2\u00db\u00dc\5\26\f\2\u00dc\u00dd"+
		"\7\25\2\2\u00dd\u00ed\3\2\2\2\u00de\u00df\7\63\2\2\u00df\u00e0\7\31\2"+
		"\2\u00e0\u00e1\7\64\2\2\u00e1\u00e2\7\24\2\2\u00e2\u00e3\5\26\f\2\u00e3"+
		"\u00e4\7\25\2\2\u00e4\u00ed\3\2\2\2\u00e5\u00e6\7\63\2\2\u00e6\u00e7\7"+
		"\65\2\2\u00e7\u00e8\5 \21\2\u00e8\u00e9\7\24\2\2\u00e9\u00ea\5\26\f\2"+
		"\u00ea\u00eb\7\25\2\2\u00eb\u00ed\3\2\2\2\u00ec\u0094\3\2\2\2\u00ec\u0095"+
		"\3\2\2\2\u00ec\u0096\3\2\2\2\u00ec\u009e\3\2\2\2\u00ec\u00a7\3\2\2\2\u00ec"+
		"\u00b6\3\2\2\2\u00ec\u00be\3\2\2\2\u00ec\u00c6\3\2\2\2\u00ec\u00d2\3\2"+
		"\2\2\u00ec\u00de\3\2\2\2\u00ec\u00e5\3\2\2\2\u00ed\31\3\2\2\2\u00ee\u00ef"+
		"\7\66\2\2\u00ef\u00f0\7\67\2\2\u00f0\u00f1\7\22\2\2\u00f1\u00f2\5 \21"+
		"\2\u00f2\u00f3\7\23\2\2\u00f3\u00f4\7\24\2\2\u00f4\u00f5\5\26\f\2\u00f5"+
		"\u00f6\7\25\2\2\u00f6\u0112\3\2\2\2\u00f7\u00f8\7\66\2\2\u00f8\u00f9\7"+
		"\67\2\2\u00f9\u00fa\7\22\2\2\u00fa\u00fb\5 \21\2\u00fb\u00fc\7\23\2\2"+
		"\u00fc\u00fd\7\24\2\2\u00fd\u00fe\5\26\f\2\u00fe\u00ff\7\25\2\2\u00ff"+
		"\u0100\5\32\16\2\u0100\u0112\3\2\2\2\u0101\u0102\7\66\2\2\u0102\u0103"+
		"\7\67\2\2\u0103\u0104\7\22\2\2\u0104\u0105\5 \21\2\u0105\u0106\7\23\2"+
		"\2\u0106\u0107\7\24\2\2\u0107\u0108\5\26\f\2\u0108\u0109\7\25\2\2\u0109"+
		"\u010a\7\67\2\2\u010a\u010b\7\22\2\2\u010b\u010c\5 \21\2\u010c\u010d\7"+
		"\23\2\2\u010d\u010e\7\24\2\2\u010e\u010f\5\26\f\2\u010f\u0110\7\25\2\2"+
		"\u0110\u0112\3\2\2\2\u0111\u00ee\3\2\2\2\u0111\u00f7\3\2\2\2\u0111\u0101"+
		"\3\2\2\2\u0112\33\3\2\2\2\u0113\u0114\5\36\20\2\u0114\u0115\5\34\17\2"+
		"\u0115\u011e\3\2\2\2\u0116\u0117\5\36\20\2\u0117\u0118\7:\2\2\u0118\u0119"+
		"\7\26\2\2\u0119\u011a\7\24\2\2\u011a\u011b\5\26\f\2\u011b\u011c\7\25\2"+
		"\2\u011c\u011e\3\2\2\2\u011d\u0113\3\2\2\2\u011d\u0116\3\2\2\2\u011e\35"+
		"\3\2\2\2\u011f\u0120\79\2\2\u0120\u0121\5.\30\2\u0121\u0122\7\26\2\2\u0122"+
		"\u0123\7\24\2\2\u0123\u0124\5\26\f\2\u0124\u0125\7\25\2\2\u0125\37\3\2"+
		"\2\2\u0126\u0127\b\21\1\2\u0127\u0128\5\"\22\2\u0128\u012f\3\2\2\2\u0129"+
		"\u012a\f\4\2\2\u012a\u012b\5\62\32\2\u012b\u012c\5 \21\5\u012c\u012e\3"+
		"\2\2\2\u012d\u0129\3\2\2\2\u012e\u0131\3\2\2\2\u012f\u012d\3\2\2\2\u012f"+
		"\u0130\3\2\2\2\u0130!\3\2\2\2\u0131\u012f\3\2\2\2\u0132\u0133\5$\23\2"+
		"\u0133\u0134\5\64\33\2\u0134\u0135\5$\23\2\u0135\u013a\3\2\2\2\u0136\u013a"+
		"\5\24\13\2\u0137\u0138\7\n\2\2\u0138\u013a\5\24\13\2\u0139\u0132\3\2\2"+
		"\2\u0139\u0136\3\2\2\2\u0139\u0137\3\2\2\2\u013a#\3\2\2\2\u013b\u013e"+
		"\5(\25\2\u013c\u013e\5&\24\2\u013d\u013b\3\2\2\2\u013d\u013c\3\2\2\2\u013e"+
		"%\3\2\2\2\u013f\u0142\5\24\13\2\u0140\u0142\5.\30\2\u0141\u013f\3\2\2"+
		"\2\u0141\u0140\3\2\2\2\u0142\'\3\2\2\2\u0143\u0144\b\25\1\2\u0144\u0145"+
		"\5*\26\2\u0145\u014e\3\2\2\2\u0146\u0147\f\4\2\2\u0147\u0148\7\3\2\2\u0148"+
		"\u014d\5*\26\2\u0149\u014a\f\3\2\2\u014a\u014b\7\4\2\2\u014b\u014d\5*"+
		"\26\2\u014c\u0146\3\2\2\2\u014c\u0149\3\2\2\2\u014d\u0150\3\2\2\2\u014e"+
		"\u014c\3\2\2\2\u014e\u014f\3\2\2\2\u014f)\3\2\2\2\u0150\u014e\3\2\2\2"+
		"\u0151\u0152\b\26\1\2\u0152\u0153\5&\24\2\u0153\u015c\3\2\2\2\u0154\u0155"+
		"\f\5\2\2\u0155\u0156\7\5\2\2\u0156\u015b\5&\24\2\u0157\u0158\f\4\2\2\u0158"+
		"\u0159\7\6\2\2\u0159\u015b\5&\24\2\u015a\u0154\3\2\2\2\u015a\u0157\3\2"+
		"\2\2\u015b\u015e\3\2\2\2\u015c\u015a\3\2\2\2\u015c\u015d\3\2\2\2\u015d"+
		"+\3\2\2\2\u015e\u015c\3\2\2\2\u015f\u0160\5\24\13\2\u0160\u0161\7\b\2"+
		"\2\u0161\u0162\5$\23\2\u0162-\3\2\2\2\u0163\u0164\t\2\2\2\u0164/\3\2\2"+
		"\2\u0165\u0166\t\3\2\2\u0166\61\3\2\2\2\u0167\u0168\t\4\2\2\u0168\63\3"+
		"\2\2\2\u0169\u016a\t\5\2\2\u016a\65\3\2\2\2\u016b\u016e\7\"\2\2\u016c"+
		"\u016e\5\60\31\2\u016d\u016b\3\2\2\2\u016d\u016c\3\2\2\2\u016e\67\3\2"+
		"\2\2\u016f\u0170\7>\2\2\u0170\u0175\7\31\2\2\u0171\u0172\7>\2\2\u0172"+
		"\u0173\7=\2\2\u0173\u0175\7\31\2\2\u0174\u016f\3\2\2\2\u0174\u0171\3\2"+
		"\2\2\u01759\3\2\2\2\u0176\u0177\t\6\2\2\u0177;\3\2\2\2\25Jjpz\u0087\u0092"+
		"\u00ec\u0111\u011d\u012f\u0139\u013d\u0141\u014c\u014e\u015a\u015c\u016d"+
		"\u0174";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}