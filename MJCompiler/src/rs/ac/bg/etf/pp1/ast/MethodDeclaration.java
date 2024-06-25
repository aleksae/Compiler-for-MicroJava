// generated with ast extension for cup
// version 0.8
// 24/5/2024 14:24:15


package rs.ac.bg.etf.pp1.ast;

public class MethodDeclaration extends MethodDecl {

    private MethodDecl MethodDecl;
    private MethodName MethodName;
    private FormParams FormParams;
    private MethodVarDecl MethodVarDecl;
    private RepeatStatement RepeatStatement;

    public MethodDeclaration (MethodDecl MethodDecl, MethodName MethodName, FormParams FormParams, MethodVarDecl MethodVarDecl, RepeatStatement RepeatStatement) {
        this.MethodDecl=MethodDecl;
        if(MethodDecl!=null) MethodDecl.setParent(this);
        this.MethodName=MethodName;
        if(MethodName!=null) MethodName.setParent(this);
        this.FormParams=FormParams;
        if(FormParams!=null) FormParams.setParent(this);
        this.MethodVarDecl=MethodVarDecl;
        if(MethodVarDecl!=null) MethodVarDecl.setParent(this);
        this.RepeatStatement=RepeatStatement;
        if(RepeatStatement!=null) RepeatStatement.setParent(this);
    }

    public MethodDecl getMethodDecl() {
        return MethodDecl;
    }

    public void setMethodDecl(MethodDecl MethodDecl) {
        this.MethodDecl=MethodDecl;
    }

    public MethodName getMethodName() {
        return MethodName;
    }

    public void setMethodName(MethodName MethodName) {
        this.MethodName=MethodName;
    }

    public FormParams getFormParams() {
        return FormParams;
    }

    public void setFormParams(FormParams FormParams) {
        this.FormParams=FormParams;
    }

    public MethodVarDecl getMethodVarDecl() {
        return MethodVarDecl;
    }

    public void setMethodVarDecl(MethodVarDecl MethodVarDecl) {
        this.MethodVarDecl=MethodVarDecl;
    }

    public RepeatStatement getRepeatStatement() {
        return RepeatStatement;
    }

    public void setRepeatStatement(RepeatStatement RepeatStatement) {
        this.RepeatStatement=RepeatStatement;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(MethodDecl!=null) MethodDecl.accept(visitor);
        if(MethodName!=null) MethodName.accept(visitor);
        if(FormParams!=null) FormParams.accept(visitor);
        if(MethodVarDecl!=null) MethodVarDecl.accept(visitor);
        if(RepeatStatement!=null) RepeatStatement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MethodDecl!=null) MethodDecl.traverseTopDown(visitor);
        if(MethodName!=null) MethodName.traverseTopDown(visitor);
        if(FormParams!=null) FormParams.traverseTopDown(visitor);
        if(MethodVarDecl!=null) MethodVarDecl.traverseTopDown(visitor);
        if(RepeatStatement!=null) RepeatStatement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MethodDecl!=null) MethodDecl.traverseBottomUp(visitor);
        if(MethodName!=null) MethodName.traverseBottomUp(visitor);
        if(FormParams!=null) FormParams.traverseBottomUp(visitor);
        if(MethodVarDecl!=null) MethodVarDecl.traverseBottomUp(visitor);
        if(RepeatStatement!=null) RepeatStatement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MethodDeclaration(\n");

        if(MethodDecl!=null)
            buffer.append(MethodDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MethodName!=null)
            buffer.append(MethodName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FormParams!=null)
            buffer.append(FormParams.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MethodVarDecl!=null)
            buffer.append(MethodVarDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(RepeatStatement!=null)
            buffer.append(RepeatStatement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MethodDeclaration]");
        return buffer.toString();
    }
}
