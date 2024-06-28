// generated with ast extension for cup
// version 0.8
// 27/5/2024 16:25:46


package rs.ac.bg.etf.pp1.ast;

public class ExpressionWithMinus extends Expr {

    private Term Term;
    private ExprRepetable ExprRepetable;

    public ExpressionWithMinus (Term Term, ExprRepetable ExprRepetable) {
        this.Term=Term;
        if(Term!=null) Term.setParent(this);
        this.ExprRepetable=ExprRepetable;
        if(ExprRepetable!=null) ExprRepetable.setParent(this);
    }

    public Term getTerm() {
        return Term;
    }

    public void setTerm(Term Term) {
        this.Term=Term;
    }

    public ExprRepetable getExprRepetable() {
        return ExprRepetable;
    }

    public void setExprRepetable(ExprRepetable ExprRepetable) {
        this.ExprRepetable=ExprRepetable;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Term!=null) Term.accept(visitor);
        if(ExprRepetable!=null) ExprRepetable.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Term!=null) Term.traverseTopDown(visitor);
        if(ExprRepetable!=null) ExprRepetable.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Term!=null) Term.traverseBottomUp(visitor);
        if(ExprRepetable!=null) ExprRepetable.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ExpressionWithMinus(\n");

        if(Term!=null)
            buffer.append(Term.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ExprRepetable!=null)
            buffer.append(ExprRepetable.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ExpressionWithMinus]");
        return buffer.toString();
    }
}
