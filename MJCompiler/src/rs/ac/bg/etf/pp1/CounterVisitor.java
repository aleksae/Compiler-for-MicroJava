package rs.ac.bg.etf.pp1;

import rs.ac.bg.etf.pp1.ast.FormParamArray;
import rs.ac.bg.etf.pp1.ast.FormParamReg;
import rs.ac.bg.etf.pp1.ast.FormParamRepeat;
import rs.ac.bg.etf.pp1.ast.FormParamRepeatArr;
import rs.ac.bg.etf.pp1.ast.MethodVarDeclaration;
import rs.ac.bg.etf.pp1.ast.NoFormParams;
import rs.ac.bg.etf.pp1.ast.VarDecl;
import rs.ac.bg.etf.pp1.ast.VisitorAdaptor;

public class CounterVisitor extends VisitorAdaptor {


	protected int count=0;
	
	public int getCount(){
		return count;
	}
	
	
	public static class FormParamCounter extends CounterVisitor{
		
		public void visit(FormParamReg formParamDecl){
			count++;
		}
		public void visit(FormParamArray formParamDecl){
			count++;
		}
		public void resetCounter() {
			this.count=0;
		}
		/*public void visit(NoFormParams formParamDecl){
			count++;
		}*/
		
	}
	
	public static class VarCounter extends CounterVisitor{
		public void resetCounter() {
			this.count=0;
		}
		public void visit(MethodVarDeclaration varDecl){
			count++;
		}
	}
	
	
}

