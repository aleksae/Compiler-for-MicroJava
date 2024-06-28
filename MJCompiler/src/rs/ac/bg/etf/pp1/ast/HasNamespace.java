// generated with ast extension for cup
// version 0.8
// 27/5/2024 16:25:46


package rs.ac.bg.etf.pp1.ast;

public class HasNamespace extends Namespace {

    private String I1;
    private DeclNamespace DeclNamespace;
    private MethodDecl MethodDecl;
    private Namespace Namespace;

    public HasNamespace (String I1, DeclNamespace DeclNamespace, MethodDecl MethodDecl, Namespace Namespace) {
        this.I1=I1;
        this.DeclNamespace=DeclNamespace;
        if(DeclNamespace!=null) DeclNamespace.setParent(this);
        this.MethodDecl=MethodDecl;
        if(MethodDecl!=null) MethodDecl.setParent(this);
        this.Namespace=Namespace;
        if(Namespace!=null) Namespace.setParent(this);
    }

    public String getI1() {
        return I1;
    }

    public void setI1(String I1) {
        this.I1=I1;
    }

    public DeclNamespace getDeclNamespace() {
        return DeclNamespace;
    }

    public void setDeclNamespace(DeclNamespace DeclNamespace) {
        this.DeclNamespace=DeclNamespace;
    }

    public MethodDecl getMethodDecl() {
        return MethodDecl;
    }

    public void setMethodDecl(MethodDecl MethodDecl) {
        this.MethodDecl=MethodDecl;
    }

    public Namespace getNamespace() {
        return Namespace;
    }

    public void setNamespace(Namespace Namespace) {
        this.Namespace=Namespace;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DeclNamespace!=null) DeclNamespace.accept(visitor);
        if(MethodDecl!=null) MethodDecl.accept(visitor);
        if(Namespace!=null) Namespace.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DeclNamespace!=null) DeclNamespace.traverseTopDown(visitor);
        if(MethodDecl!=null) MethodDecl.traverseTopDown(visitor);
        if(Namespace!=null) Namespace.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DeclNamespace!=null) DeclNamespace.traverseBottomUp(visitor);
        if(MethodDecl!=null) MethodDecl.traverseBottomUp(visitor);
        if(Namespace!=null) Namespace.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("HasNamespace(\n");

        buffer.append(" "+tab+I1);
        buffer.append("\n");

        if(DeclNamespace!=null)
            buffer.append(DeclNamespace.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MethodDecl!=null)
            buffer.append(MethodDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Namespace!=null)
            buffer.append(Namespace.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [HasNamespace]");
        return buffer.toString();
    }
}
