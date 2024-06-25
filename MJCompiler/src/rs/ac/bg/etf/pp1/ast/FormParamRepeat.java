// generated with ast extension for cup
// version 0.8
// 24/5/2024 14:24:15


package rs.ac.bg.etf.pp1.ast;

public class FormParamRepeat extends FormParamsRepeat {

    private Type Type;
    private FormName FormName;
    private FormParamsRepeat FormParamsRepeat;

    public FormParamRepeat (Type Type, FormName FormName, FormParamsRepeat FormParamsRepeat) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.FormName=FormName;
        if(FormName!=null) FormName.setParent(this);
        this.FormParamsRepeat=FormParamsRepeat;
        if(FormParamsRepeat!=null) FormParamsRepeat.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public FormName getFormName() {
        return FormName;
    }

    public void setFormName(FormName FormName) {
        this.FormName=FormName;
    }

    public FormParamsRepeat getFormParamsRepeat() {
        return FormParamsRepeat;
    }

    public void setFormParamsRepeat(FormParamsRepeat FormParamsRepeat) {
        this.FormParamsRepeat=FormParamsRepeat;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(FormName!=null) FormName.accept(visitor);
        if(FormParamsRepeat!=null) FormParamsRepeat.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(FormName!=null) FormName.traverseTopDown(visitor);
        if(FormParamsRepeat!=null) FormParamsRepeat.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(FormName!=null) FormName.traverseBottomUp(visitor);
        if(FormParamsRepeat!=null) FormParamsRepeat.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FormParamRepeat(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FormName!=null)
            buffer.append(FormName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FormParamsRepeat!=null)
            buffer.append(FormParamsRepeat.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FormParamRepeat]");
        return buffer.toString();
    }
}
