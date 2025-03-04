// generated with ast extension for cup
// version 0.8
// 27/5/2024 16:25:46


package rs.ac.bg.etf.pp1.ast;

public interface Visitor { 

    public void visit(DesignatorSuffix DesignatorSuffix);
    public void visit(RepetableActParse RepetableActParse);
    public void visit(RepeatStatement RepeatStatement);
    public void visit(DesignatorIdent DesignatorIdent);
    public void visit(Mulop Mulop);
    public void visit(MethodDecl MethodDecl);
    public void visit(DesignatorInner DesignatorInner);
    public void visit(RepeatConstDecl RepeatConstDecl);
    public void visit(FormParamsRepeat FormParamsRepeat);
    public void visit(Relop Relop);
    public void visit(Namespace Namespace);
    public void visit(CondTermRepeater CondTermRepeater);
    public void visit(DesignatorFinal DesignatorFinal);
    public void visit(VarName VarName);
    public void visit(DesignatorJul DesignatorJul);
    public void visit(ExprRepetable ExprRepetable);
    public void visit(Addop Addop);
    public void visit(DesignatorRepeatable DesignatorRepeatable);
    public void visit(DesignatorStatementPartOne DesignatorStatementPartOne);
    public void visit(Factor Factor);
    public void visit(Designator Designator);
    public void visit(DesignatorStatementPart DesignatorStatementPart);
    public void visit(OptionalCondFactFor OptionalCondFactFor);
    public void visit(FormParams FormParams);
    public void visit(DesignatorStatementList DesignatorStatementList);
    public void visit(RepetableTerm RepetableTerm);
    public void visit(Label Label);
    public void visit(VarDeclRepeat VarDeclRepeat);
    public void visit(MethodVarDecl MethodVarDecl);
    public void visit(StatementRepeat StatementRepeat);
    public void visit(Expr Expr);
    public void visit(DesignatorStatementPartTwo DesignatorStatementPartTwo);
    public void visit(CondFactRepeater CondFactRepeater);
    public void visit(FactorNew FactorNew);
    public void visit(TypeOrVoid TypeOrVoid);
    public void visit(DesignatorStatement DesignatorStatement);
    public void visit(DesignatorComma DesignatorComma);
    public void visit(ConstElem ConstElem);
    public void visit(Statement Statement);
    public void visit(VarDecl VarDecl);
    public void visit(OptionalDesignatorStatementFor OptionalDesignatorStatementFor);
    public void visit(Type Type);
    public void visit(DeclNamespace DeclNamespace);
    public void visit(ConstDecl ConstDecl);
    public void visit(CondFact CondFact);
    public void visit(CondFactDual CondFactDual);
    public void visit(CondFactSingle CondFactSingle);
    public void visit(NoCondFactRep NoCondFactRep);
    public void visit(CondFactRepFull CondFactRepFull);
    public void visit(CondTerm CondTerm);
    public void visit(NoCondTermRep NoCondTermRep);
    public void visit(CondTermRepFull CondTermRepFull);
    public void visit(Condition Condition);
    public void visit(RelopDerived4 RelopDerived4);
    public void visit(RelopDerived3 RelopDerived3);
    public void visit(RelopDerived2 RelopDerived2);
    public void visit(RelopDerived1 RelopDerived1);
    public void visit(RelopNotEq RelopNotEq);
    public void visit(RelopEq RelopEq);
    public void visit(LabelDerived1 LabelDerived1);
    public void visit(NoRepeatStmnt NoRepeatStmnt);
    public void visit(RepeatStmnt RepeatStmnt);
    public void visit(OptionalCondFactForDerived1 OptionalCondFactForDerived1);
    public void visit(OptCondFactFor OptCondFactFor);
    public void visit(DesignatorStatementListDerived2 DesignatorStatementListDerived2);
    public void visit(DesignatorStatementListDerived1 DesignatorStatementListDerived1);
    public void visit(OptionalDesignatorStatementForDerived2 OptionalDesignatorStatementForDerived2);
    public void visit(OptionalDesignatorStatementForDerived1 OptionalDesignatorStatementForDerived1);
    public void visit(StatementRepeatDerived2 StatementRepeatDerived2);
    public void visit(StatementRepeatDerived1 StatementRepeatDerived1);
    public void visit(ForDect ForDect);
    public void visit(ErrorStmtStatementSemicolon ErrorStmtStatementSemicolon);
    public void visit(StatementFor StatementFor);
    public void visit(StatementCurlyStatement StatementCurlyStatement);
    public void visit(EmptyStatement EmptyStatement);
    public void visit(PrintWithNumConstStatement PrintWithNumConstStatement);
    public void visit(PrintStatement PrintStatement);
    public void visit(ReadStatement ReadStatement);
    public void visit(ReturnStatement ReturnStatement);
    public void visit(ReturnEmptyStatement ReturnEmptyStatement);
    public void visit(ContStatement ContStatement);
    public void visit(BreakStatement BreakStatement);
    public void visit(StatementIfElse StatementIfElse);
    public void visit(StatementIfNoElse StatementIfNoElse);
    public void visit(StatementDesign StatementDesign);
    public void visit(NoDesignatorComma NoDesignatorComma);
    public void visit(DesignatorCommaOnly DesignatorCommaOnly);
    public void visit(DesignatorCommaIncl DesignatorCommaIncl);
    public void visit(DesJulWithIf DesJulWithIf);
    public void visit(DesJulNoIf DesJulNoIf);
    public void visit(DesignatorStatementDepack DesignatorStatementDepack);
    public void visit(DesignatorStatementDec DesignatorStatementDec);
    public void visit(DesignatorStatementInc DesignatorStatementInc);
    public void visit(DesignatorStatementParen DesignatorStatementParen);
    public void visit(DesignatorStatementEmptyParen DesignatorStatementEmptyParen);
    public void visit(DesignatorStatementAssign DesignatorStatementAssign);
    public void visit(DesJul DesJul);
    public void visit(DesignatorStmntTwo DesignatorStmntTwo);
    public void visit(DesignatorStmntOne DesignatorStmntOne);
    public void visit(NoDesignatorRepetable NoDesignatorRepetable);
    public void visit(DesignatorIdentBrackets DesignatorIdentBrackets);
    public void visit(DesignatorIdentDot DesignatorIdentDot);
    public void visit(DesignatorRegular DesignatorRegular);
    public void visit(DesignatorReach DesignatorReach);
    public void visit(RepetableActParseEmpty RepetableActParseEmpty);
    public void visit(RepetableActParseFull RepetableActParseFull);
    public void visit(ActParse ActParse);
    public void visit(FactorArrNoE FactorArrNoE);
    public void visit(FactorNewDerived1 FactorNewDerived1);
    public void visit(FactorArrHasE FactorArrHasE);
    public void visit(FactorRange FactorRange);
    public void visit(LRParFactor LRParFactor);
    public void visit(FactorNewFac FactorNewFac);
    public void visit(FactorBool FactorBool);
    public void visit(FactorChar FactorChar);
    public void visit(FactorNum FactorNum);
    public void visit(FactorDesignatorBrace FactorDesignatorBrace);
    public void visit(FactorDesignatorEmptyBrace FactorDesignatorEmptyBrace);
    public void visit(FactorDesignator FactorDesignator);
    public void visit(NoRepTerm NoRepTerm);
    public void visit(RepetableTerminal RepetableTerminal);
    public void visit(Term Term);
    public void visit(MulopSlash MulopSlash);
    public void visit(MulopMul MulopMul);
    public void visit(MulopPerc MulopPerc);
    public void visit(AddopMinus AddopMinus);
    public void visit(AddopPlus AddopPlus);
    public void visit(NoExpressionRepetable NoExpressionRepetable);
    public void visit(ExpressionRepetable ExpressionRepetable);
    public void visit(Expression Expression);
    public void visit(ExpressionWithMinus ExpressionWithMinus);
    public void visit(TypeNoColon TypeNoColon);
    public void visit(TypeWithColon TypeWithColon);
    public void visit(NumConst NumConst);
    public void visit(CharConst CharConst);
    public void visit(BoolConst BoolConst);
    public void visit(NoMethodVarDecl NoMethodVarDecl);
    public void visit(MethodVarDeclaration MethodVarDeclaration);
    public void visit(VariableName VariableName);
    public void visit(NoVarDeclRepeat NoVarDeclRepeat);
    public void visit(VarDeclarationRepeat VarDeclarationRepeat);
    public void visit(VarDeclRepeatArr VarDeclRepeatArr);
    public void visit(VariableDeclaration VariableDeclaration);
    public void visit(ErrorStmtVarDeclSemicolon ErrorStmtVarDeclSemicolon);
    public void visit(ErrorStmtVarDeclComma ErrorStmtVarDeclComma);
    public void visit(VariableDeclarationArray VariableDeclarationArray);
    public void visit(NoRepeatConstDecl NoRepeatConstDecl);
    public void visit(RepeatingConstDecl RepeatingConstDecl);
    public void visit(ConstName ConstName);
    public void visit(ConstDeclaration ConstDeclaration);
    public void visit(NoDecl NoDecl);
    public void visit(DeclVariable DeclVariable);
    public void visit(DecleareConst DecleareConst);
    public void visit(TypeVoid TypeVoid);
    public void visit(TypeHasType TypeHasType);
    public void visit(NoRepeatFormParam NoRepeatFormParam);
    public void visit(FormParamRepeat FormParamRepeat);
    public void visit(FormParamRepeatArr FormParamRepeatArr);
    public void visit(FormName FormName);
    public void visit(NoFormParams NoFormParams);
    public void visit(FormParamReg FormParamReg);
    public void visit(FormParamArray FormParamArray);
    public void visit(MethodName MethodName);
    public void visit(NoMethodDecl NoMethodDecl);
    public void visit(MethodDeclaration MethodDeclaration);
    public void visit(NoNamespace NoNamespace);
    public void visit(HasNamespace HasNamespace);
    public void visit(ProgName ProgName);
    public void visit(Program Program);

}
