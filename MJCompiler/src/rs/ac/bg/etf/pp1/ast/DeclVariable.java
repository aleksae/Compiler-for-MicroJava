// generated with ast extension for cup
// version 0.8
// 27/5/2024 16:25:46


package rs.ac.bg.etf.pp1.ast;

public class DeclVariable extends DeclNamespace {

    private VarDecl VarDecl;
    private DeclNamespace DeclNamespace;

    public DeclVariable (VarDecl VarDecl, DeclNamespace DeclNamespace) {
        this.VarDecl=VarDecl;
        if(VarDecl!=null) VarDecl.setParent(this);
        this.DeclNamespace=DeclNamespace;
        if(DeclNamespace!=null) DeclNamespace.setParent(this);
    }

    public VarDecl getVarDecl() {
        return VarDecl;
    }

    public void setVarDecl(VarDecl VarDecl) {
        this.VarDecl=VarDecl;
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
        if(VarDecl!=null) VarDecl.accept(visitor);
        if(DeclNamespace!=null) DeclNamespace.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VarDecl!=null) VarDecl.traverseTopDown(visitor);
        if(DeclNamespace!=null) DeclNamespace.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VarDecl!=null) VarDecl.traverseBottomUp(visitor);
        if(DeclNamespace!=null) DeclNamespace.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DeclVariable(\n");

        if(VarDecl!=null)
            buffer.append(VarDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DeclNamespace!=null)
            buffer.append(DeclNamespace.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DeclVariable]");
        return buffer.toString();
    }
}
