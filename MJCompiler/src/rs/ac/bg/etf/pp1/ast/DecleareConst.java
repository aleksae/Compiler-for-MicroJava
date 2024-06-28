// generated with ast extension for cup
// version 0.8
// 27/5/2024 16:25:46


package rs.ac.bg.etf.pp1.ast;

public class DecleareConst extends DeclNamespace {

    private ConstDecl ConstDecl;
    private DeclNamespace DeclNamespace;

    public DecleareConst (ConstDecl ConstDecl, DeclNamespace DeclNamespace) {
        this.ConstDecl=ConstDecl;
        if(ConstDecl!=null) ConstDecl.setParent(this);
        this.DeclNamespace=DeclNamespace;
        if(DeclNamespace!=null) DeclNamespace.setParent(this);
    }

    public ConstDecl getConstDecl() {
        return ConstDecl;
    }

    public void setConstDecl(ConstDecl ConstDecl) {
        this.ConstDecl=ConstDecl;
    }

    public DeclNamespace getDeclNamespace() {
        return DeclNamespace;
    }

    public void setDeclNamespace(DeclNamespace DeclNamespace) {
        this.DeclNamespace=DeclNamespace;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConstDecl!=null) ConstDecl.accept(visitor);
        if(DeclNamespace!=null) DeclNamespace.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstDecl!=null) ConstDecl.traverseTopDown(visitor);
        if(DeclNamespace!=null) DeclNamespace.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstDecl!=null) ConstDecl.traverseBottomUp(visitor);
        if(DeclNamespace!=null) DeclNamespace.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DecleareConst(\n");

        if(ConstDecl!=null)
            buffer.append(ConstDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DeclNamespace!=null)
            buffer.append(DeclNamespace.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DecleareConst]");
        return buffer.toString();
    }
}
