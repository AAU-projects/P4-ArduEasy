// Generated from C:/Workspaces/ArduEasy/ArduEasyMaven/src/main/antlr4\ArduEasy.g4 by ANTLR 4.7
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
		PERCENTAGE=25, STRING=26, TIME=27, DAY=28, MONTH=29, BOOL=30, VOIDDEC=31, 
		INTDEC=32, FLOATDEC=33, STRINGDEC=34, CHARDEC=35, PERCENTAGEDEC=36, STRUCTDEC=37, 
		ARRAYDEC=38, TIMEDEC=39, DAYDEC=40, MONTHDEC=41, BOOLDEC=42, SETUP=43, 
		WHEN=44, FOR=45, WHILE=46, FUNCTION=47, PERFORM=48, TIMES=49, UNTIL=50, 
		IF=51, ELSE=52, SWITCH=53, CASE=54, DEFAULT=55, RETURN=56, AS=57, A=58, 
		PIN=59, INPUT=60, OUTPUT=61, INPUTPULLUP=62, IDENTIFIER=63, IGNORE=64;
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
		"','", null, null, null, null, null, null, null, null, "'void'", "'int'", 
		"'float'", "'string'", "'char'", "'percent'", "'struct'", "'array'", "'time'", 
		"'day'", "'month'", "'bool'", "'setup'", "'when'", "'for'", "'while'", 
		"'function'", "'perform'", "'times'", "'until'", "'if'", "'else'", "'switch'", 
		"'case'", "'default'", "'return'", "'as'", "'A'", "'PIN'", "'input'", 
		"'output'", "'inputpullup'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "ADDITIVEOPERATOR", "SUBTRACTIVEOPERATOR", "MULTIPLICATIVEOPERATOR", 
		"DIVISIONALOPERATOR", "MODULOOPERATOR", "ASSIGNMENTOPERATOR", "EQUALSOPERATOR", 
		"NEGATEOPERATOR", "BELOWOPERATOR", "ABOVEOPERATOR", "EQUALSORBELOWOPERATOR", 
		"EQUALSORABOVEOPERATOR", "ISNOTOPERATOR", "ANDOPERATOR", "OROPERATOR", 
		"LPAREN", "RPAREN", "LBRACK", "RBRACK", "COLON", "SEMICOLON", "COMMA", 
		"INT", "FLOAT", "PERCENTAGE", "STRING", "TIME", "DAY", "MONTH", "BOOL", 
		"VOIDDEC", "INTDEC", "FLOATDEC", "STRINGDEC", "CHARDEC", "PERCENTAGEDEC", 
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
			setState(71);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case WHEN:
			case FUNCTION:
				enterOuterAlt(_localctx, 1);
				{
				setState(67);
				function();
				setState(68);
				functions();
				}
				break;
			case EOF:
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
			setState(103);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(73);
				match(WHEN);
				setState(74);
				match(LPAREN);
				setState(75);
				logicalExpressions(0);
				setState(76);
				match(RPAREN);
				setState(77);
				match(LBRACK);
				setState(78);
				statements();
				setState(79);
				match(RBRACK);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(81);
				match(FUNCTION);
				setState(82);
				returnType();
				setState(83);
				identifier();
				setState(84);
				match(LPAREN);
				setState(85);
				parameters();
				setState(86);
				match(RPAREN);
				setState(87);
				match(LBRACK);
				setState(88);
				statements();
				setState(89);
				match(RETURN);
				setState(90);
				identifier();
				setState(91);
				match(RBRACK);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(93);
				match(FUNCTION);
				setState(94);
				match(VOIDDEC);
				setState(95);
				identifier();
				setState(96);
				match(LPAREN);
				setState(97);
				parameters();
				setState(98);
				match(RPAREN);
				setState(99);
				match(LBRACK);
				setState(100);
				statements();
				setState(101);
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
			setState(109);
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
				setState(105);
				definition();
				setState(106);
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
			setState(119);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(111);
				identifier();
				setState(112);
				match(ASSIGNMENTOPERATOR);
				setState(113);
				pin();
				setState(114);
				match(AS);
				setState(115);
				ioStatus();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(117);
				declaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(118);
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
			setState(121);
			typeSpecifier();
			setState(122);
			identifier();
			setState(123);
			match(ASSIGNMENTOPERATOR);
			setState(124);
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
			setState(132);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(126);
				parameter();
				setState(127);
				match(COMMA);
				setState(128);
				parameters();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(130);
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
			setState(134);
			typeSpecifier();
			setState(135);
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
			setState(137);
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
			setState(143);
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
				setState(139);
				statement();
				setState(140);
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
		public List<AssignmentContext> assignment() {
			return getRuleContexts(AssignmentContext.class);
		}
		public AssignmentContext assignment(int i) {
			return getRuleContext(AssignmentContext.class,i);
		}
		public TerminalNode IF() { return getToken(ArduEasyParser.IF, 0); }
		public TerminalNode LPAREN() { return getToken(ArduEasyParser.LPAREN, 0); }
		public LogicalExpressionsContext logicalExpressions() {
			return getRuleContext(LogicalExpressionsContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ArduEasyParser.RPAREN, 0); }
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
		public TerminalNode PERFORM() { return getToken(ArduEasyParser.PERFORM, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
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
			setState(232);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(145);
				declaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(146);
				assignment();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(147);
				match(IF);
				setState(148);
				match(LPAREN);
				setState(149);
				logicalExpressions(0);
				setState(150);
				match(RPAREN);
				setState(151);
				match(LBRACK);
				setState(152);
				statements();
				setState(153);
				match(RBRACK);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(155);
				match(IF);
				setState(156);
				match(LPAREN);
				setState(157);
				logicalExpressions(0);
				setState(158);
				match(RPAREN);
				setState(159);
				match(LBRACK);
				setState(160);
				statements();
				setState(161);
				match(RBRACK);
				setState(162);
				ifElse();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(164);
				match(IF);
				setState(165);
				match(LPAREN);
				setState(166);
				logicalExpressions(0);
				setState(167);
				match(RPAREN);
				setState(168);
				match(LBRACK);
				setState(169);
				statements();
				setState(170);
				match(RBRACK);
				setState(171);
				match(ELSE);
				setState(172);
				match(LBRACK);
				setState(173);
				statements();
				setState(174);
				match(RBRACK);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(176);
				match(SWITCH);
				setState(177);
				match(LPAREN);
				setState(178);
				value();
				setState(179);
				match(RPAREN);
				setState(180);
				match(LBRACK);
				setState(181);
				cases();
				setState(182);
				match(RBRACK);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(184);
				match(WHILE);
				setState(185);
				match(LPAREN);
				setState(186);
				logicalExpressions(0);
				setState(187);
				match(RPAREN);
				setState(188);
				match(LBRACK);
				setState(189);
				statements();
				setState(190);
				match(RBRACK);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(192);
				match(FOR);
				setState(193);
				match(LPAREN);
				setState(194);
				declaration();
				setState(195);
				match(SEMICOLON);
				setState(196);
				logicalExpressions(0);
				setState(197);
				match(SEMICOLON);
				setState(198);
				assignment();
				setState(199);
				match(RPAREN);
				setState(200);
				match(LBRACK);
				setState(201);
				statements();
				setState(202);
				match(RBRACK);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(204);
				match(FOR);
				setState(205);
				match(LPAREN);
				setState(206);
				assignment();
				setState(207);
				match(SEMICOLON);
				setState(208);
				logicalExpressions(0);
				setState(209);
				match(SEMICOLON);
				setState(210);
				assignment();
				setState(211);
				match(RPAREN);
				setState(212);
				match(LBRACK);
				setState(213);
				statements();
				setState(214);
				match(RBRACK);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(216);
				match(PERFORM);
				setState(217);
				expression();
				setState(218);
				match(TIMES);
				setState(219);
				match(LBRACK);
				setState(220);
				statements();
				setState(221);
				match(RBRACK);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(223);
				match(PERFORM);
				setState(224);
				match(UNTIL);
				setState(225);
				match(LPAREN);
				setState(226);
				logicalExpressions(0);
				setState(227);
				match(RPAREN);
				setState(228);
				match(LBRACK);
				setState(229);
				statements();
				setState(230);
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
		public List<TerminalNode> ELSE() { return getTokens(ArduEasyParser.ELSE); }
		public TerminalNode ELSE(int i) {
			return getToken(ArduEasyParser.ELSE, i);
		}
		public TerminalNode IF() { return getToken(ArduEasyParser.IF, 0); }
		public TerminalNode LPAREN() { return getToken(ArduEasyParser.LPAREN, 0); }
		public LogicalExpressionsContext logicalExpressions() {
			return getRuleContext(LogicalExpressionsContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ArduEasyParser.RPAREN, 0); }
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
			setState(266);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(234);
				match(ELSE);
				setState(235);
				match(IF);
				setState(236);
				match(LPAREN);
				setState(237);
				logicalExpressions(0);
				setState(238);
				match(RPAREN);
				setState(239);
				match(LBRACK);
				setState(240);
				statements();
				setState(241);
				match(RBRACK);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(243);
				match(ELSE);
				setState(244);
				match(IF);
				setState(245);
				match(LPAREN);
				setState(246);
				logicalExpressions(0);
				setState(247);
				match(RPAREN);
				setState(248);
				match(LBRACK);
				setState(249);
				statements();
				setState(250);
				match(RBRACK);
				setState(251);
				ifElse();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(253);
				match(ELSE);
				setState(254);
				match(IF);
				setState(255);
				match(LPAREN);
				setState(256);
				logicalExpressions(0);
				setState(257);
				match(RPAREN);
				setState(258);
				match(LBRACK);
				setState(259);
				statements();
				setState(260);
				match(RBRACK);
				setState(261);
				match(ELSE);
				setState(262);
				match(LBRACK);
				setState(263);
				statements();
				setState(264);
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
			setState(278);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(268);
				case_r();
				setState(269);
				cases();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(271);
				case_r();
				setState(272);
				match(DEFAULT);
				setState(273);
				match(COLON);
				setState(274);
				match(LBRACK);
				setState(275);
				statements();
				setState(276);
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
			setState(280);
			match(CASE);
			setState(281);
			value();
			setState(282);
			match(COLON);
			setState(283);
			match(LBRACK);
			setState(284);
			statements();
			setState(285);
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
			setState(288);
			logicalExpression();
			}
			_ctx.stop = _input.LT(-1);
			setState(296);
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
					setState(290);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(291);
					logicalOperator();
					setState(292);
					logicalExpressions(3);
					}
					} 
				}
				setState(298);
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
		public TerminalNode BOOL() { return getToken(ArduEasyParser.BOOL, 0); }
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
			setState(309);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(299);
				expressions();
				setState(300);
				comparisonOperator();
				setState(301);
				expressions();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(303);
				identifier();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(304);
				match(NEGATEOPERATOR);
				setState(305);
				identifier();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(306);
				match(BOOL);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(307);
				match(NEGATEOPERATOR);
				setState(308);
				match(BOOL);
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
			enterOuterAlt(_localctx, 1);
			{
			setState(311);
			addSubExpression(0);
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
		public TerminalNode SUBTRACTIVEOPERATOR() { return getToken(ArduEasyParser.SUBTRACTIVEOPERATOR, 0); }
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
			setState(317);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(313);
				identifier();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(314);
				match(SUBTRACTIVEOPERATOR);
				setState(315);
				identifier();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(316);
				value();
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
			setState(320);
			multiDivExpression();
			}
			_ctx.stop = _input.LT(-1);
			setState(330);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(328);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
					case 1:
						{
						_localctx = new AddSubExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_addSubExpression);
						setState(322);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(323);
						match(ADDITIVEOPERATOR);
						setState(324);
						multiDivExpression();
						}
						break;
					case 2:
						{
						_localctx = new AddSubExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_addSubExpression);
						setState(325);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(326);
						match(SUBTRACTIVEOPERATOR);
						setState(327);
						multiDivExpression();
						}
						break;
					}
					} 
				}
				setState(332);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
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
		public TerminalNode MULTIPLICATIVEOPERATOR() { return getToken(ArduEasyParser.MULTIPLICATIVEOPERATOR, 0); }
		public MultiDivExpressionContext multiDivExpression() {
			return getRuleContext(MultiDivExpressionContext.class,0);
		}
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
		MultiDivExpressionContext _localctx = new MultiDivExpressionContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_multiDivExpression);
		try {
			setState(342);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(333);
				expression();
				setState(334);
				match(MULTIPLICATIVEOPERATOR);
				setState(335);
				multiDivExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(337);
				expression();
				setState(338);
				match(DIVISIONALOPERATOR);
				setState(339);
				multiDivExpression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(341);
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
			setState(344);
			identifier();
			setState(345);
			match(ASSIGNMENTOPERATOR);
			setState(346);
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
		public TerminalNode TIME() { return getToken(ArduEasyParser.TIME, 0); }
		public TerminalNode DAY() { return getToken(ArduEasyParser.DAY, 0); }
		public TerminalNode MONTH() { return getToken(ArduEasyParser.MONTH, 0); }
		public TerminalNode SUBTRACTIVEOPERATOR() { return getToken(ArduEasyParser.SUBTRACTIVEOPERATOR, 0); }
		public TerminalNode NEGATEOPERATOR() { return getToken(ArduEasyParser.NEGATEOPERATOR, 0); }
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
		try {
			setState(362);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(348);
				match(INT);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(349);
				match(FLOAT);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(350);
				match(PERCENTAGE);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(351);
				match(STRING);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(352);
				match(BOOL);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(353);
				match(TIME);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(354);
				match(DAY);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(355);
				match(MONTH);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(356);
				match(SUBTRACTIVEOPERATOR);
				setState(357);
				match(INT);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(358);
				match(SUBTRACTIVEOPERATOR);
				setState(359);
				match(FLOAT);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(360);
				match(NEGATEOPERATOR);
				setState(361);
				match(BOOL);
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
			setState(364);
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
			setState(366);
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
			setState(368);
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
			setState(372);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VOIDDEC:
				enterOuterAlt(_localctx, 1);
				{
				setState(370);
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
				setState(371);
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
			setState(379);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(374);
				match(PIN);
				setState(375);
				match(INT);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(376);
				match(PIN);
				setState(377);
				match(A);
				setState(378);
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
			setState(381);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3B\u0182\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\3\2\3\2\3\2\3\2\3\3"+
		"\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\5\4J\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\5\5j\n\5\3\6\3\6\3\6\3\6\5\6p\n\6\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\5\7z\n\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\5\t\u0087\n\t\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\f\5\f\u0092\n\f\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r"+
		"\u00eb\n\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u010d\n\16\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\5\17\u0119\n\17\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\7\21\u0129\n\21\f\21\16\21\u012c"+
		"\13\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u0138\n"+
		"\22\3\23\3\23\3\24\3\24\3\24\3\24\5\24\u0140\n\24\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\7\25\u014b\n\25\f\25\16\25\u014e\13\25\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u0159\n\26\3\27\3\27\3\27"+
		"\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\5\30\u016d\n\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\5\34\u0177"+
		"\n\34\3\35\3\35\3\35\3\35\3\35\5\35\u017e\n\35\3\36\3\36\3\36\2\4 (\37"+
		"\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:\2\6\4\2"+
		"\"\'),\3\2\20\21\4\2\t\t\13\17\3\2>@\2\u0191\2<\3\2\2\2\4@\3\2\2\2\6I"+
		"\3\2\2\2\bi\3\2\2\2\no\3\2\2\2\fy\3\2\2\2\16{\3\2\2\2\20\u0086\3\2\2\2"+
		"\22\u0088\3\2\2\2\24\u008b\3\2\2\2\26\u0091\3\2\2\2\30\u00ea\3\2\2\2\32"+
		"\u010c\3\2\2\2\34\u0118\3\2\2\2\36\u011a\3\2\2\2 \u0121\3\2\2\2\"\u0137"+
		"\3\2\2\2$\u0139\3\2\2\2&\u013f\3\2\2\2(\u0141\3\2\2\2*\u0158\3\2\2\2,"+
		"\u015a\3\2\2\2.\u016c\3\2\2\2\60\u016e\3\2\2\2\62\u0170\3\2\2\2\64\u0172"+
		"\3\2\2\2\66\u0176\3\2\2\28\u017d\3\2\2\2:\u017f\3\2\2\2<=\5\4\3\2=>\5"+
		"\6\4\2>?\7\2\2\3?\3\3\2\2\2@A\7-\2\2AB\7\24\2\2BC\5\n\6\2CD\7\25\2\2D"+
		"\5\3\2\2\2EF\5\b\5\2FG\5\6\4\2GJ\3\2\2\2HJ\3\2\2\2IE\3\2\2\2IH\3\2\2\2"+
		"J\7\3\2\2\2KL\7.\2\2LM\7\22\2\2MN\5 \21\2NO\7\23\2\2OP\7\24\2\2PQ\5\26"+
		"\f\2QR\7\25\2\2Rj\3\2\2\2ST\7\61\2\2TU\5\66\34\2UV\5\24\13\2VW\7\22\2"+
		"\2WX\5\20\t\2XY\7\23\2\2YZ\7\24\2\2Z[\5\26\f\2[\\\7:\2\2\\]\5\24\13\2"+
		"]^\7\25\2\2^j\3\2\2\2_`\7\61\2\2`a\7!\2\2ab\5\24\13\2bc\7\22\2\2cd\5\20"+
		"\t\2de\7\23\2\2ef\7\24\2\2fg\5\26\f\2gh\7\25\2\2hj\3\2\2\2iK\3\2\2\2i"+
		"S\3\2\2\2i_\3\2\2\2j\t\3\2\2\2kl\5\f\7\2lm\5\n\6\2mp\3\2\2\2np\3\2\2\2"+
		"ok\3\2\2\2on\3\2\2\2p\13\3\2\2\2qr\5\24\13\2rs\7\b\2\2st\58\35\2tu\7;"+
		"\2\2uv\5:\36\2vz\3\2\2\2wz\5\16\b\2xz\5,\27\2yq\3\2\2\2yw\3\2\2\2yx\3"+
		"\2\2\2z\r\3\2\2\2{|\5\60\31\2|}\5\24\13\2}~\7\b\2\2~\177\5$\23\2\177\17"+
		"\3\2\2\2\u0080\u0081\5\22\n\2\u0081\u0082\7\30\2\2\u0082\u0083\5\20\t"+
		"\2\u0083\u0087\3\2\2\2\u0084\u0087\5\22\n\2\u0085\u0087\3\2\2\2\u0086"+
		"\u0080\3\2\2\2\u0086\u0084\3\2\2\2\u0086\u0085\3\2\2\2\u0087\21\3\2\2"+
		"\2\u0088\u0089\5\60\31\2\u0089\u008a\5\24\13\2\u008a\23\3\2\2\2\u008b"+
		"\u008c\7A\2\2\u008c\25\3\2\2\2\u008d\u008e\5\30\r\2\u008e\u008f\5\26\f"+
		"\2\u008f\u0092\3\2\2\2\u0090\u0092\3\2\2\2\u0091\u008d\3\2\2\2\u0091\u0090"+
		"\3\2\2\2\u0092\27\3\2\2\2\u0093\u00eb\5\16\b\2\u0094\u00eb\5,\27\2\u0095"+
		"\u0096\7\65\2\2\u0096\u0097\7\22\2\2\u0097\u0098\5 \21\2\u0098\u0099\7"+
		"\23\2\2\u0099\u009a\7\24\2\2\u009a\u009b\5\26\f\2\u009b\u009c\7\25\2\2"+
		"\u009c\u00eb\3\2\2\2\u009d\u009e\7\65\2\2\u009e\u009f\7\22\2\2\u009f\u00a0"+
		"\5 \21\2\u00a0\u00a1\7\23\2\2\u00a1\u00a2\7\24\2\2\u00a2\u00a3\5\26\f"+
		"\2\u00a3\u00a4\7\25\2\2\u00a4\u00a5\5\32\16\2\u00a5\u00eb\3\2\2\2\u00a6"+
		"\u00a7\7\65\2\2\u00a7\u00a8\7\22\2\2\u00a8\u00a9\5 \21\2\u00a9\u00aa\7"+
		"\23\2\2\u00aa\u00ab\7\24\2\2\u00ab\u00ac\5\26\f\2\u00ac\u00ad\7\25\2\2"+
		"\u00ad\u00ae\7\66\2\2\u00ae\u00af\7\24\2\2\u00af\u00b0\5\26\f\2\u00b0"+
		"\u00b1\7\25\2\2\u00b1\u00eb\3\2\2\2\u00b2\u00b3\7\67\2\2\u00b3\u00b4\7"+
		"\22\2\2\u00b4\u00b5\5.\30\2\u00b5\u00b6\7\23\2\2\u00b6\u00b7\7\24\2\2"+
		"\u00b7\u00b8\5\34\17\2\u00b8\u00b9\7\25\2\2\u00b9\u00eb\3\2\2\2\u00ba"+
		"\u00bb\7\60\2\2\u00bb\u00bc\7\22\2\2\u00bc\u00bd\5 \21\2\u00bd\u00be\7"+
		"\23\2\2\u00be\u00bf\7\24\2\2\u00bf\u00c0\5\26\f\2\u00c0\u00c1\7\25\2\2"+
		"\u00c1\u00eb\3\2\2\2\u00c2\u00c3\7/\2\2\u00c3\u00c4\7\22\2\2\u00c4\u00c5"+
		"\5\16\b\2\u00c5\u00c6\7\27\2\2\u00c6\u00c7\5 \21\2\u00c7\u00c8\7\27\2"+
		"\2\u00c8\u00c9\5,\27\2\u00c9\u00ca\7\23\2\2\u00ca\u00cb\7\24\2\2\u00cb"+
		"\u00cc\5\26\f\2\u00cc\u00cd\7\25\2\2\u00cd\u00eb\3\2\2\2\u00ce\u00cf\7"+
		"/\2\2\u00cf\u00d0\7\22\2\2\u00d0\u00d1\5,\27\2\u00d1\u00d2\7\27\2\2\u00d2"+
		"\u00d3\5 \21\2\u00d3\u00d4\7\27\2\2\u00d4\u00d5\5,\27\2\u00d5\u00d6\7"+
		"\23\2\2\u00d6\u00d7\7\24\2\2\u00d7\u00d8\5\26\f\2\u00d8\u00d9\7\25\2\2"+
		"\u00d9\u00eb\3\2\2\2\u00da\u00db\7\62\2\2\u00db\u00dc\5&\24\2\u00dc\u00dd"+
		"\7\63\2\2\u00dd\u00de\7\24\2\2\u00de\u00df\5\26\f\2\u00df\u00e0\7\25\2"+
		"\2\u00e0\u00eb\3\2\2\2\u00e1\u00e2\7\62\2\2\u00e2\u00e3\7\64\2\2\u00e3"+
		"\u00e4\7\22\2\2\u00e4\u00e5\5 \21\2\u00e5\u00e6\7\23\2\2\u00e6\u00e7\7"+
		"\24\2\2\u00e7\u00e8\5\26\f\2\u00e8\u00e9\7\25\2\2\u00e9\u00eb\3\2\2\2"+
		"\u00ea\u0093\3\2\2\2\u00ea\u0094\3\2\2\2\u00ea\u0095\3\2\2\2\u00ea\u009d"+
		"\3\2\2\2\u00ea\u00a6\3\2\2\2\u00ea\u00b2\3\2\2\2\u00ea\u00ba\3\2\2\2\u00ea"+
		"\u00c2\3\2\2\2\u00ea\u00ce\3\2\2\2\u00ea\u00da\3\2\2\2\u00ea\u00e1\3\2"+
		"\2\2\u00eb\31\3\2\2\2\u00ec\u00ed\7\66\2\2\u00ed\u00ee\7\65\2\2\u00ee"+
		"\u00ef\7\22\2\2\u00ef\u00f0\5 \21\2\u00f0\u00f1\7\23\2\2\u00f1\u00f2\7"+
		"\24\2\2\u00f2\u00f3\5\26\f\2\u00f3\u00f4\7\25\2\2\u00f4\u010d\3\2\2\2"+
		"\u00f5\u00f6\7\66\2\2\u00f6\u00f7\7\65\2\2\u00f7\u00f8\7\22\2\2\u00f8"+
		"\u00f9\5 \21\2\u00f9\u00fa\7\23\2\2\u00fa\u00fb\7\24\2\2\u00fb\u00fc\5"+
		"\26\f\2\u00fc\u00fd\7\25\2\2\u00fd\u00fe\5\32\16\2\u00fe\u010d\3\2\2\2"+
		"\u00ff\u0100\7\66\2\2\u0100\u0101\7\65\2\2\u0101\u0102\7\22\2\2\u0102"+
		"\u0103\5 \21\2\u0103\u0104\7\23\2\2\u0104\u0105\7\24\2\2\u0105\u0106\5"+
		"\26\f\2\u0106\u0107\7\25\2\2\u0107\u0108\7\66\2\2\u0108\u0109\7\24\2\2"+
		"\u0109\u010a\5\26\f\2\u010a\u010b\7\25\2\2\u010b\u010d\3\2\2\2\u010c\u00ec"+
		"\3\2\2\2\u010c\u00f5\3\2\2\2\u010c\u00ff\3\2\2\2\u010d\33\3\2\2\2\u010e"+
		"\u010f\5\36\20\2\u010f\u0110\5\34\17\2\u0110\u0119\3\2\2\2\u0111\u0112"+
		"\5\36\20\2\u0112\u0113\79\2\2\u0113\u0114\7\26\2\2\u0114\u0115\7\24\2"+
		"\2\u0115\u0116\5\26\f\2\u0116\u0117\7\25\2\2\u0117\u0119\3\2\2\2\u0118"+
		"\u010e\3\2\2\2\u0118\u0111\3\2\2\2\u0119\35\3\2\2\2\u011a\u011b\78\2\2"+
		"\u011b\u011c\5.\30\2\u011c\u011d\7\26\2\2\u011d\u011e\7\24\2\2\u011e\u011f"+
		"\5\26\f\2\u011f\u0120\7\25\2\2\u0120\37\3\2\2\2\u0121\u0122\b\21\1\2\u0122"+
		"\u0123\5\"\22\2\u0123\u012a\3\2\2\2\u0124\u0125\f\4\2\2\u0125\u0126\5"+
		"\62\32\2\u0126\u0127\5 \21\5\u0127\u0129\3\2\2\2\u0128\u0124\3\2\2\2\u0129"+
		"\u012c\3\2\2\2\u012a\u0128\3\2\2\2\u012a\u012b\3\2\2\2\u012b!\3\2\2\2"+
		"\u012c\u012a\3\2\2\2\u012d\u012e\5$\23\2\u012e\u012f\5\64\33\2\u012f\u0130"+
		"\5$\23\2\u0130\u0138\3\2\2\2\u0131\u0138\5\24\13\2\u0132\u0133\7\n\2\2"+
		"\u0133\u0138\5\24\13\2\u0134\u0138\7 \2\2\u0135\u0136\7\n\2\2\u0136\u0138"+
		"\7 \2\2\u0137\u012d\3\2\2\2\u0137\u0131\3\2\2\2\u0137\u0132\3\2\2\2\u0137"+
		"\u0134\3\2\2\2\u0137\u0135\3\2\2\2\u0138#\3\2\2\2\u0139\u013a\5(\25\2"+
		"\u013a%\3\2\2\2\u013b\u0140\5\24\13\2\u013c\u013d\7\4\2\2\u013d\u0140"+
		"\5\24\13\2\u013e\u0140\5.\30\2\u013f\u013b\3\2\2\2\u013f\u013c\3\2\2\2"+
		"\u013f\u013e\3\2\2\2\u0140\'\3\2\2\2\u0141\u0142\b\25\1\2\u0142\u0143"+
		"\5*\26\2\u0143\u014c\3\2\2\2\u0144\u0145\f\4\2\2\u0145\u0146\7\3\2\2\u0146"+
		"\u014b\5*\26\2\u0147\u0148\f\3\2\2\u0148\u0149\7\4\2\2\u0149\u014b\5*"+
		"\26\2\u014a\u0144\3\2\2\2\u014a\u0147\3\2\2\2\u014b\u014e\3\2\2\2\u014c"+
		"\u014a\3\2\2\2\u014c\u014d\3\2\2\2\u014d)\3\2\2\2\u014e\u014c\3\2\2\2"+
		"\u014f\u0150\5&\24\2\u0150\u0151\7\5\2\2\u0151\u0152\5*\26\2\u0152\u0159"+
		"\3\2\2\2\u0153\u0154\5&\24\2\u0154\u0155\7\6\2\2\u0155\u0156\5*\26\2\u0156"+
		"\u0159\3\2\2\2\u0157\u0159\5&\24\2\u0158\u014f\3\2\2\2\u0158\u0153\3\2"+
		"\2\2\u0158\u0157\3\2\2\2\u0159+\3\2\2\2\u015a\u015b\5\24\13\2\u015b\u015c"+
		"\7\b\2\2\u015c\u015d\5$\23\2\u015d-\3\2\2\2\u015e\u016d\7\31\2\2\u015f"+
		"\u016d\7\32\2\2\u0160\u016d\7\33\2\2\u0161\u016d\7\34\2\2\u0162\u016d"+
		"\7 \2\2\u0163\u016d\7\35\2\2\u0164\u016d\7\36\2\2\u0165\u016d\7\37\2\2"+
		"\u0166\u0167\7\4\2\2\u0167\u016d\7\31\2\2\u0168\u0169\7\4\2\2\u0169\u016d"+
		"\7\32\2\2\u016a\u016b\7\n\2\2\u016b\u016d\7 \2\2\u016c\u015e\3\2\2\2\u016c"+
		"\u015f\3\2\2\2\u016c\u0160\3\2\2\2\u016c\u0161\3\2\2\2\u016c\u0162\3\2"+
		"\2\2\u016c\u0163\3\2\2\2\u016c\u0164\3\2\2\2\u016c\u0165\3\2\2\2\u016c"+
		"\u0166\3\2\2\2\u016c\u0168\3\2\2\2\u016c\u016a\3\2\2\2\u016d/\3\2\2\2"+
		"\u016e\u016f\t\2\2\2\u016f\61\3\2\2\2\u0170\u0171\t\3\2\2\u0171\63\3\2"+
		"\2\2\u0172\u0173\t\4\2\2\u0173\65\3\2\2\2\u0174\u0177\7!\2\2\u0175\u0177"+
		"\5\60\31\2\u0176\u0174\3\2\2\2\u0176\u0175\3\2\2\2\u0177\67\3\2\2\2\u0178"+
		"\u0179\7=\2\2\u0179\u017e\7\31\2\2\u017a\u017b\7=\2\2\u017b\u017c\7<\2"+
		"\2\u017c\u017e\7\31\2\2\u017d\u0178\3\2\2\2\u017d\u017a\3\2\2\2\u017e"+
		"9\3\2\2\2\u017f\u0180\t\5\2\2\u0180;\3\2\2\2\24Iioy\u0086\u0091\u00ea"+
		"\u010c\u0118\u012a\u0137\u013f\u014a\u014c\u0158\u016c\u0176\u017d";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}