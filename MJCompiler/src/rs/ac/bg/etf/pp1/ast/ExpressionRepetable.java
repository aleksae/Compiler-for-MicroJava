// generated with ast extension for cup
// version 0.8
// 27/5/2024 16:25:46


package rs.ac.bg.etf.pp1.ast;

public class ExpressionRepetable extends ExprRepetable {

    private Addop Addop;
    private Term Term;
    private ExprRepetable ExprRepetable;

    public ExpressionRepetable (Addop Addop, Term Term, ExprRepetable ExprRepetable) {
        this.Addop=Addop;
        if(Addop!=null) Addop.setParent(this);
        this.Term=Term;
        if(Term!=null) Term.setParent(this);
        this.ExprRepetable=ExprRepetable;
        if(ExprRepetable!=null) ExprRepetable.setParent(this);
    }

    public Addop getAddop() {
        return Addop;
    }

    public void setAddop(Addop Addop) {
        this.Addop=Addop;
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
        if(Addop!=null) Addop.accept(visitor);
        if(Term!=null) Term.accept(visitor);
        if(ExprRepetable!=null) ExprRepetable.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Addop!=null) Addop.traverseTopDown(visitor);
        if(Term!=null) Term.traverseTopDown(visitor);
        if(ExprRepetable!=null) ExprRepetable.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Addop!=null) Addop.traverseBottomUp(visitor);
        if(Term!=null) Term.traverseBottomUp(visitor);
        if(ExprRepetable!=null) ExprRepetable.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ExpressionRepetable(\n");

        if(Addop!=null)
            buffer.append(Addop.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

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
        buffer.append(") [ExpressionRepetable]");
        return buffer.toString();
    }
}
