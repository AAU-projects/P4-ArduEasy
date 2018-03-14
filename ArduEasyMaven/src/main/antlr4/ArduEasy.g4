grammar ArduEasy;

r					: setup functions EOF
					;

setup               : SETUP LBRACK definitions RBRACK
					;

functions           : function functions
                    | function
                    |
                    ;

function            : WHEN LPAREN logicalExpressions RPAREN LBRACK statements RBRACK
                    | FUNCTION returnType identifier LPAREN parameters RPAREN LBRACK statements RETURN identifier RBRACK
                    | FUNCTION VOIDDEC identifier LPAREN parameters RPAREN LBRACK statements RBRACK
                    ;

definitions         : definition definitions
 					|
 					;

definition          : identifier ASSIGNMENTOPERATOR pin AS ioStatus
                 	| declaration
                 	| assignment
                 	;

declaration         : typeSpecifier identifier ASSIGNMENTOPERATOR expressions
					;

parameters          : parameter COMMA parameters
                 	| parameter
                 	|
                 	;

parameter           : typeSpecifier identifier
					;

identifier          : IDENTIFIER
					;

statements          : statement statements
                 	|
                 	;

statement           : declaration
                 	| assignment
                 	| IF LPAREN logicalExpressions RPAREN LBRACK statements RBRACK
 					| IF LPAREN logicalExpressions RPAREN LBRACK statements RBRACK ifElse
                 	| IF LPAREN logicalExpressions RPAREN LBRACK statements RBRACK ELSE LPAREN logicalExpressions RPAREN LBRACK statements RBRACK
                 	| SWITCH LPAREN value RPAREN LBRACK cases RBRACK
                 	| WHILE LPAREN logicalExpressions RPAREN LBRACK statements RBRACK
 					| FOR LPAREN declaration SEMICOLON logicalExpressions SEMICOLON expressions RPAREN LBRACK statements RBRACK
 					| FOR LPAREN assignment SEMICOLON logicalExpressions SEMICOLON expressions RPAREN LBRACK statements RBRACK
 					| PERFORM INT TIMES LBRACK statements RBRACK
 					| PERFORM UNTIL logicalExpressions LBRACK statements RBRACK
 					;

ifElse              : IF ELSE LPAREN logicalExpressions RPAREN LBRACK statements RBRACK
                 	| IF ELSE LPAREN logicalExpressions RPAREN LBRACK statements RBRACK ifElse
                 	| IF ELSE LPAREN logicalExpressions RPAREN LBRACK statements RBRACK ELSE LPAREN logicalExpressions RPAREN LBRACK statements RBRACK
                 	;

cases               : case_r cases
					| case_r DEFAULT COLON LBRACK statements RBRACK
					;

case_r              : CASE value  COLON LBRACK statements RBRACK
					;

logicalExpressions  : logicalExpressions logicalOperator logicalExpressions
                 	| logicalExpression
                 	;

logicalExpression   : expressions comparisonOperator expressions
                 	| identifier
                 	| NEGATEOPERATOR identifier
                 	;

expressions         : addSubExpression
 					| expression
 					;

expression          : identifier
 					| value
 					;

addSubExpression    : multiDivExpression
                 	| addSubExpression ADDITIVEOPERATOR multiDivExpression
                 	| addSubExpression SUBTRACTIVEOPERATOR multiDivExpression
                 	;

multiDivExpression  : multiDivExpression MULTIPLICATIVEOPERATOR expression
                 	| multiDivExpression DIVISIONALOPERATOR expression
                 	| expression
                 	;

assignment          : identifier ASSIGNMENTOPERATOR expressions
					;

value               : INT
	                | FLOAT
	                | PERCENTAGE
	                | STRING
	                | BOOL
	                ;

typeSpecifier       : INTDEC
	                | FLOATDEC
	                | PERCENTAGEDEC
	                | CHARDEC
	                | STRINGDEC
	                | TIMEDEC
	                | DAYDEC
	                | MONTHDEC
	                | STRUCTDEC
	                | BOOLDEC
	                ;

logicalOperator 	: ANDOPERATOR
					| OROPERATOR
 					;

comparisonOperator	: EQUALSOPERATOR
					| BELOWOPERATOR
					| ABOVEOPERATOR
					| EQUALSORBELOWOPERATOR
					| EQUALSORABOVEOPERATOR
					| ISNOTOPERATOR
					;

returnType          : VOIDDEC
 					| typeSpecifier
 					;

pin                 : PIN INT
                 	| PIN A INT
                 	;

ioStatus            : INPUT
 					| OUTPUT
 					| INPUTPULLUP
 					;

ADDITIVEOPERATOR 		: '+' ;
SUBTRACTIVEOPERATOR 	: '-' ;
MULTIPLICATIVEOPERATOR 	: '*' ;
DIVISIONALOPERATOR 		: '/' ;
MODULOOPERATOR			: '%' ;

ASSIGNMENTOPERATOR 		: '=' ;

EQUALSOPERATOR 			: '==' | 'is' ;
NEGATEOPERATOR 			: '!'  | 'not' ;
BELOWOPERATOR 			: '<'  | 'is below' ;
ABOVEOPERATOR 			: '>'  | 'is above' ;
EQUALSORBELOWOPERATOR 	: '<=' | 'is below or equal' ;
EQUALSORABOVEOPERATOR	: '>=' | 'is above or equal' ;
ISNOTOPERATOR	 		: '!=' | 'is not' ;

ANDOPERATOR				: '&&' | 'and' ;
OROPERATOR 				: '||' | 'or' ;

LPAREN					: '(' ;
RPAREN					: ')' ;
LBRACK					: '{' ;
RBRACK					: '}' ;

COLON					: ':' ;
SEMICOLON				: ';' ;
COMMA 					: ',' ;

INT 					: [0]|[1-9]+[0-9]* ;
FLOAT 					: [+-]?([0-9]*[.])?[0-9]+ ;
PERCENTAGE 				: [1-9]+[0-9]*[%] ;
STRING 					: '"'.*?'"' ;
TIME 					: [0-2][0-9][:][0-5][0-9] ;
DAY						: 'MONDAY' | 'TUESDAY' | 'WEDNESDAY' | 'THURSDAY' | 'FRIDAY' | 'SATURDAY' | 'SUNDAY' ;
MONTH 					: 'JANUARY' | 'FEBRUARY' | 'MARCH' | 'APRIL' | 'MAY' | 'JUNE' | 'JULY' | 'AUGUST' | 'SEPTEMBER' | 'OCTOBER' | 'NOVEMBER' | 'DECEMBER' ;
STRUCT 					: 'changethispleasestruct' ;
BOOL 					: 'true'|'false'|'on'|'off'|'open'|'close'|'enable'|'disable' ;

VOIDDEC					: 'void' ;
INTDEC					: 'int' ;
FLOATDEC				: 'float' ;
STRINGDEC				: 'string' ;
CHARDEC 				: 'char' ;
PERCENTAGEDEC			: 'percentage' ;
STRUCTDEC				: 'struct' ;
ARRAYDEC				: 'array' ;
TIMEDEC					: 'time' ;
DAYDEC					: 'day' ;
MONTHDEC 				: 'month' ;
BOOLDEC 				: 'bool' ;

SETUP 					: 'setup' ;
WHEN 					: 'when' ;
FOR 					: 'for' ;
WHILE 					: 'while' ;
FUNCTION 				: 'function' ;
PERFORM 				: 'perform' ;
TIMES 					: 'times' ;
UNTIL 					: 'until' ;
IF 						: 'if' ;
ELSE 					: 'else' ;
SWITCH 					: 'switch' ;
CASE					: 'case' ;
DEFAULT 				: 'default' ;
RETURN 					: 'return' ;
AS 						: 'as' ;
A 						: 'A' ;
PIN 					: 'PIN' ;
INPUT 					: 'input' ;
OUTPUT 					: 'output' ;
INPUTPULLUP 			: 'inputpullup' ;

IDENTIFIER  			: [a-zA-Z_][a-zA-Z_0-9]* ;
IGNORE                  : [ \t\r\n]+ -> channel(HIDDEN) ;