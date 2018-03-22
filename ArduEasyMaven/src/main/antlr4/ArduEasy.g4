grammar ArduEasy;

r					: setup function* EOF
					;

setup               : SETUP LBRACK definition* RBRACK
					;

function            : WHEN LPAREN logicalExpressions RPAREN LBRACK statement* RBRACK
                    | FUNCTION returnType identifier LPAREN parameters RPAREN LBRACK statement* RETURN logicalExpressions RBRACK
                    | FUNCTION VOIDDEC identifier LPAREN parameters RPAREN LBRACK statement* RBRACK
                    ;

definition          : pindeclaration
                 	| declaration
                 	| assignment
                 	| roomdeclaration
                 	;

declaration         : typeSpecifier identifier ASSIGNMENTOPERATOR logicalExpressions
					;

roomdeclaration     : ROOMDEC identifier LBRACK roomblock RBRACK
                    ;

roomblock           : pindeclaration* arraydeclaration*
                    |
                    ;

arraydeclaration    : identifier LBRACK identifierloop RBRACK
                    ;

identifierloop      : identifier
                    | identifier COMMA identifierloop
                    ;

pindeclaration      : identifier ASSIGNMENTOPERATOR pin AS ioStatus
                    ;

parameters          : parameter COMMA parameters
                 	| parameter
                 	|
                 	;

parameter           : typeSpecifier identifier
					;

identifier          : IDENTIFIER
					;

statement           : declaration
                 	| assignment
                 	| if
                  	| switch
                  	| while
  					| for
  					| perform
  					;

perform             : PERFORM expression TIMES LBRACK statement* RBRACK
                    | PERFORM UNTIL LPAREN logicalExpressions RPAREN LBRACK statement* RBRACK
                    ;

for                 : FOR LPAREN (declaration | assignment) SEMICOLON logicalExpressions SEMICOLON assignment RPAREN LBRACK statement* RBRACK
                    ;

while               : WHILE LPAREN logicalExpressions RPAREN LBRACK statement* RBRACK
                    ;

switch              : SWITCH LPAREN expression RPAREN LBRACK cases RBRACK
                    ;

if                  : IF LPAREN logicalExpressions RPAREN LBRACK statement* RBRACK
                    | IF LPAREN logicalExpressions RPAREN LBRACK statement* RBRACK ifElse
                    | IF LPAREN logicalExpressions RPAREN LBRACK statement* RBRACK ELSE LBRACK statement* RBRACK
                    ;

ifElse              : ELSE IF LPAREN logicalExpressions RPAREN LBRACK statement* RBRACK
                 	| ELSE IF LPAREN logicalExpressions RPAREN LBRACK statement* RBRACK ifElse
                 	| ELSE IF LPAREN logicalExpressions RPAREN LBRACK statement* RBRACK ELSE LBRACK statement* RBRACK
                 	;

cases               : case_r cases
					| case_r DEFAULT COLON LBRACK statement* RBRACK
					|
					;

case_r              : CASE value  COLON LBRACK statement* RBRACK
					;

logicalExpressions  : logicalExpressions logicalOperator logicalExpressions
                 	| logicalExpression
                 	;

logicalExpression   : addSubExpression comparisonOperator addSubExpression
                    | addSubExpression
                 	| NEGATEOPERATOR identifier
                 	;

expression          : identifier
                    | SUBTRACTIVEOPERATOR identifier
 					| value
 					;

addSubExpression    : multiDivExpression
                 	| addSubExpression ADDITIVEOPERATOR multiDivExpression
                 	| addSubExpression SUBTRACTIVEOPERATOR multiDivExpression
                 	;

multiDivExpression  : expression MULTIPLICATIVEOPERATOR multiDivExpression
                    | expression DIVISIONALOPERATOR multiDivExpression
                    | expression
                 	;

assignment          : identifier ASSIGNMENTOPERATOR logicalExpressions
					;

value               : INT
	                | FLOAT
	                | PERCENTAGE
	                | STRING
	                | BOOL
	                | TIME
	                | DAY
	                | MONTH
	                | SUBTRACTIVEOPERATOR INT
	                | SUBTRACTIVEOPERATOR FLOAT
	                | NEGATEOPERATOR BOOL
	                ;

typeSpecifier       : INTDEC
	                | FLOATDEC
	                | PERCENTAGEDEC
	                | CHARDEC
	                | STRINGDEC
	                | TIMEDEC
	                | DAYDEC
	                | MONTHDEC
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
FLOAT 					: ([0-9]*[.])?[0-9]+ ;
PERCENTAGE 				: [1-9]+[0-9]*[%] ;
STRING 					: '"'.*?'"' ;
TIME 					: ([0-1][0-9]|[2][0-3])[:][0-5][0-9] ;
DAY						: 'MONDAY' | 'TUESDAY' | 'WEDNESDAY' | 'THURSDAY' | 'FRIDAY' | 'SATURDAY' | 'SUNDAY' ;
MONTH 					: 'JANUARY' | 'FEBRUARY' | 'MARCH' | 'APRIL' | 'MAY' | 'JUNE' | 'JULY' | 'AUGUST' | 'SEPTEMBER' | 'OCTOBER' | 'NOVEMBER' | 'DECEMBER' ;
BOOL 					: 'true'|'false' ;

VOIDDEC					: 'void' ;
INTDEC					: 'int' ;
FLOATDEC				: 'float' ;
STRINGDEC				: 'string' ;
CHARDEC 				: 'char' ;
PERCENTAGEDEC			: 'percent' ;
ARRAYDEC				: 'array' ;
TIMEDEC					: 'time' ;
DAYDEC					: 'day' ;
MONTHDEC 				: 'month' ;
BOOLDEC 				: 'bool' ;
ROOMDEC                 : 'room' ;

SETUP 					: 'house' ;
ROOM                    : 'room' ;
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