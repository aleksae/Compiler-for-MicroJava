package rs.ac.bg.etf.pp1;

import java.util.Collection;

import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.CounterVisitor.FormParamCounter;
import rs.ac.bg.etf.pp1.CounterVisitor.VarCounter;
import rs.ac.bg.etf.pp1.ast.Addop;
import rs.ac.bg.etf.pp1.ast.AddopMinus;
import rs.ac.bg.etf.pp1.ast.AddopPlus;
import rs.ac.bg.etf.pp1.ast.BoolConst;
import rs.ac.bg.etf.pp1.ast.CharConst;
import rs.ac.bg.etf.pp1.ast.ConstDeclaration;
import rs.ac.bg.etf.pp1.ast.ConstName;
import rs.ac.bg.etf.pp1.ast.DesignatorIdentBrackets;
import rs.ac.bg.etf.pp1.ast.DesignatorStatementAssign;
import rs.ac.bg.etf.pp1.ast.DesignatorStatementDec;
import rs.ac.bg.etf.pp1.ast.DesignatorStatementInc;
import rs.ac.bg.etf.pp1.ast.DesignatorStatementParen;
import rs.ac.bg.etf.pp1.ast.DesignatorStmntOne;
import rs.ac.bg.etf.pp1.ast.Expression;
import rs.ac.bg.etf.pp1.ast.ExpressionRepetable;
import rs.ac.bg.etf.pp1.ast.ExpressionWithMinus;
import rs.ac.bg.etf.pp1.ast.FactorBool;
import rs.ac.bg.etf.pp1.ast.FactorChar;
import rs.ac.bg.etf.pp1.ast.FactorDesignator;
import rs.ac.bg.etf.pp1.ast.FactorDesignatorBrace;
import rs.ac.bg.etf.pp1.ast.FactorNew;
import rs.ac.bg.etf.pp1.ast.FactorNewFac;
import rs.ac.bg.etf.pp1.ast.FactorNum;
import rs.ac.bg.etf.pp1.ast.FactorRange;
import rs.ac.bg.etf.pp1.ast.MethodDecl;
import rs.ac.bg.etf.pp1.ast.MethodDeclaration;
import rs.ac.bg.etf.pp1.ast.MethodName;
import rs.ac.bg.etf.pp1.ast.MulopMul;
import rs.ac.bg.etf.pp1.ast.MulopPerc;
import rs.ac.bg.etf.pp1.ast.MulopSlash;
import rs.ac.bg.etf.pp1.ast.NumConst;
import rs.ac.bg.etf.pp1.ast.PrintStatement;
import rs.ac.bg.etf.pp1.ast.ReadStatement;
import rs.ac.bg.etf.pp1.ast.RepetableTerminal;
import rs.ac.bg.etf.pp1.ast.SyntaxNode;
import rs.ac.bg.etf.pp1.ast.Term;
import rs.ac.bg.etf.pp1.ast.VisitorAdaptor;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;

public class CodeGenerator extends VisitorAdaptor {
	private int mainPc;
	
	public int getMainPc(){
		return mainPc;
	}

	Obj cnt;
	CodeGenerator(){
		Tab.chrObj.setAdr(Code.pc);
	    Code.put(Code.enter);
	    Code.put(1);
	    Code.put(1);
	    Code.put(Code.load_n);
	    Code.put(Code.exit);
	    Code.put(Code.return_);

	    Tab.ordObj.setAdr(Code.pc);
	    Code.put(Code.enter);
	    Code.put(1);
	    Code.put(1);
	    Code.put(Code.load_n);
	    Code.put(Code.exit);
	    Code.put(Code.return_);

	    Tab.lenObj.setAdr(Code.pc);
	    Code.put(Code.enter);
	    Code.put(1);
	    Code.put(1);
	    Code.put(Code.load_n);
	    Code.put(Code.arraylength);
	    Code.put(Code.exit);
	    Code.put(Code.return_);
	    cnt = Tab.find("mojPomocniBrojacAleksa");
	    
	}
	
	
	Logger log = Logger.getLogger(getClass());
	public void report_info(String message, SyntaxNode info) {
		StringBuilder msg = new StringBuilder(message); 
		int line = (info == null) ? 0: info.getLine();
		if (line != 0)
			msg.append (" na liniji ").append(line);
		log.info(msg.toString());
	}
	
	boolean printHasBrackets=false;
	boolean hasFuncCall=false;
	
	public void visit(PrintStatement ps) {
		/*expr deo ce staviti na stack drugo*/
	
		if(ps.getExpr().obj.getType().equals(Tab.intType)){
			report_info("aaeee6",ps);
			Code.loadConst(5);
			Code.put(Code.print);
		}else if(ps.getExpr().obj.getType().getKind()==3 ) {
			report_info("aaeee7",ps);
			if(!printHasBrackets) {
				report_info("aaeee8",ps);
				boolean isIntArr = ps.getExpr().obj.getType().getElemType().getKind()==1;
				report_info("usao",ps);
				int placeToJmp = 0;
				int toPatch=0;
				
				Code.load(cnt);
				Code.loadConst(0);
				Code.store(cnt);
				Code.put(Code.pop);
				placeToJmp = Code.pc;
				Code.put(Code.dup);
				
				Code.put(Code.dup);
				Code.put(Code.arraylength);
				
				Code.load(cnt);
				Code.put(Code.dup_x1);
				Code.putFalseJump(1, 0);
				toPatch = Code.pc-2;
				if(isIntArr) Code.put(Code.aload); else Code.put(Code.baload);
				if(isIntArr) {
					Code.put(Code.const_5);
					Code.put(Code.print);
				}else {
					Code.put(Code.const_1);
					Code.put(Code.bprint);
				}
				Code.load(cnt);
				Code.put(Code.const_1);
				Code.put(Code.add);
				Code.store(cnt);
				Code.putJump(placeToJmp);
				Code.fixup(toPatch);
				
				
				
				
				printHasBrackets=false;
				return;
			}else {
				if(ps.getExpr().obj.getType().getElemType().getKind()==1) {
					//Code.put(Code.aload);
					Code.loadConst(5);
					Code.put(Code.print);
				}else {
					//Code.put(Code.baload);
					Code.loadConst(1);
					Code.put(Code.bprint);
				}
				
				
			
			}
			
		}else if(hasFuncCall) {
			//Code.put(Code.pop);
			report_info("aaeee4",ps);
			Code.loadConst(5);
			Code.put(Code.print);
			hasFuncCall=false;
		}
		else if(ps.getExpr().obj.getType().equals(MJParserTest.boolType)){
			report_info("aaeee3",ps);
			Code.loadConst(5);
			Code.put(Code.print);
		}
		else if(printHasBrackets){
			report_info("aaeee1",ps);
			
		}else {
			report_info("aaeee2",ps);
			Code.loadConst(1);
			Code.put(Code.bprint);
		}
	}
	int oldVar=0,oldFp=0;
	
	public void visit(FactorDesignatorBrace f) {
		Obj functionObj = f.getDesignator().obj;
		int offset = functionObj.getAdr() - Code.pc;
		Code.put(Code.call);
		Code.put2(offset);
		if(f.getDesignator().obj.getType() != Tab.noType){
			//Code.put(Code.pop);
		}
		hasFuncCall = true;
	}
	

	public void visit(MethodName mn) {
		if("main".equalsIgnoreCase(mn.getName())){
			mainPc = Code.pc;
		}
		mn.obj.setAdr(Code.pc);
		// Collect arguments and local variables
		SyntaxNode methodNode = mn.getParent();
	
		VarCounter varCnt = new VarCounter();
		methodNode.traverseTopDown(varCnt);
		
		
		FormParamCounter fpCnt = new FormParamCounter();
		methodNode.traverseTopDown(fpCnt);
		
		report_info(varCnt.getCount()-oldVar+"", mn);
		report_info(fpCnt.getCount()-oldFp+"", mn);
		
		// Generate the entry
		Code.put(Code.enter);
		Code.put(fpCnt.getCount()-oldVar);
		Code.put(fpCnt.getCount() + varCnt.getCount()-oldVar-oldFp);
		oldVar += varCnt.getCount()-oldVar;
		oldFp +=fpCnt.getCount() + varCnt.getCount()-oldVar-oldFp;
	}
	
	public void visit(MethodDeclaration methodDecl){
		Code.put(Code.exit);
		Code.put(Code.return_);
	}
	
	public void visit(ConstDeclaration cn) {
		if(cn.getConstElem() instanceof BoolConst) {
			
		}else if(cn.getConstElem() instanceof NumConst) {
			NumConst nc = (NumConst) cn.getConstElem();
			report_info(nc.getN1().toString(), cn);
			cn.getConstName().obj.setAdr(nc.getN1());
			
		}else {
			CharConst cc = (CharConst)cn.getConstElem();
			report_info(cc.getC1().toString(), cn);
			cn.getConstName().obj.setAdr((int)cc.getC1().charAt(1));
		}
		Code.load(cn.getConstName().obj);
		
	}
	
	public void visit(DesignatorStmntOne des) {
		printHasBrackets = false;
		if(des.getDesignatorStatementPartOne() instanceof DesignatorStatementAssign) {
			/*if(des.getDesignator().obj.getType().getKind()==3) {
				des.getDesignator().obj.setAdr();
			}*/
			if(des.getDesignator() instanceof DesignatorIdentBrackets) {
				/*Code.put(Code.dup_x1);
				Code.put(Code.pop);
				Code.put(Code.astore);*/
				if(des.getDesignator().obj.getType().getElemType().equals(Tab.intType)) Code.put(Code.astore);
				else Code.put(Code.bastore);
			
			}else {
				Code.store(des.getDesignator().obj);
			}
		}else if(des.getDesignatorStatementPartOne() instanceof DesignatorStatementParen) {
			Obj functionObj = des.getDesignator().obj;
			int offset = functionObj.getAdr() - Code.pc;
			Code.put(Code.call);
			Code.put2(offset);
			if(des.getDesignator().obj.getType() != Tab.noType){
				//Code.put(Code.pop);
			}
		}else if(hasFuncCall) {
			//Code.put(Code.pop);
			hasFuncCall=false;
		}else if(des.getDesignatorStatementPartOne() instanceof DesignatorStatementInc) {
			Code.load(des.getDesignator().obj);
			Code.put(Code.const_1);
			Code.put(Code.add);
			Code.store(des.getDesignator().obj);
			//Code.put(Code.pop);
		}else if(des.getDesignatorStatementPartOne() instanceof DesignatorStatementDec) {
			Code.load(des.getDesignator().obj);
			Code.put(Code.const_1);
			Code.put(Code.sub);
			Code.store(des.getDesignator().obj);
			//Code.put(Code.pop);
			
		}
		
		
	}
	
	
	public void visit(FactorNum fn) {
		
		Code.loadConst(fn.getValN());
		report_info("Put za "+fn.getValN(), fn);
	}
	
	public void visit(FactorChar fn) {
		fn.obj.setAdr((int)fn.getValC().charAt(1));
		Code.load(fn.obj);
		report_info("Put za "+fn.getValC(), fn);
	}
	
	public void visit(FactorBool fn) {
		Integer val = fn.getValB().equals("true")?1:0;
    	fn.obj.setAdr(val);
		Code.load(fn.obj);
		report_info("Put za "+fn.getValB(), fn);
	}
	
	public void visit(ExpressionRepetable e) {
		if(e.getAddop() instanceof AddopPlus) Code.put(Code.add);
		else if(e.getAddop() instanceof AddopMinus) Code.put(Code.sub);
	}
	
	public void visit(RepetableTerminal r) {
		if(r.getMulop() instanceof MulopPerc) Code.put(Code.rem);
		else if(r.getMulop() instanceof MulopMul) Code.put(Code.mul);
		else if(r.getMulop() instanceof MulopSlash) Code.put(Code.div);
	}
	
	public void visit(ExpressionWithMinus e) {
		
	}
	
	public void visit(Term t) {
		if(t.getParent() instanceof ExpressionWithMinus) {
			Code.put(Code.neg);
		}
		
	}
	
	public void visit(FactorDesignator e) {
		if(e.getDesignator() instanceof DesignatorIdentBrackets) {
			if(e.getDesignator().obj.getType().getElemType().equals(Tab.intType)) Code.put(Code.aload);
			else Code.put(Code.baload);
			
			return;
		}
		Code.load(e.obj);
		report_info("loaded "+e.obj.getName(), e);
	}
	
	public void visit(FactorRange f) {
		//Code.load(f.getExpr().obj);//velicina niza
		
		boolean isIntArr = f.getExpr().obj.getType().getKind()==1;
		
		Code.put(Code.newarray);//adresa niza, tj. niz efektivno
		int placeToJmp = 0;
		int toPatch=0;
		Code.load(cnt);
		Code.loadConst(0);
		Code.store(cnt);
		//Code.put(Code.pop);
		placeToJmp = Code.pc;
		Code.put(Code.dup);
		
		Code.put(Code.dup);
		Code.put(Code.arraylength);
		Code.load(cnt);
		Code.put(Code.dup_x1);
		Code.putFalseJump(1, 0);
		toPatch = Code.pc-2;
		Code.load(cnt);
		
		if(isIntArr) Code.put(Code.astore); else Code.put(Code.bastore);
		Code.load(cnt);
		Code.put(Code.const_1);
		Code.put(Code.add);
		Code.store(cnt);
		Code.putJump(placeToJmp);
		Code.fixup(toPatch);
		Code.put(Code.pop);
	}
	public void visit(FactorNewFac f) {
		/*if(f.getType().struct.equals(Tab.charType)) {
			Code.put(Code.const_1);
		}else {
			Code.loadConst(0);
		}*/
		Code.put(Code.newarray);
		int isWArr = 1;
        if (f.getType().struct.equals(Tab.charType)) {
            isWArr = 0;
        }

        Code.loadConst(isWArr);
	}
	
	public void visit(DesignatorIdentBrackets des) {
		/*if(des.getParent() instanceof FactorDesignator) {
			Code.put(Code.dup_x1);
			Code.put(Code.pop);
			Code.put(Code.astore);
		}*/
		printHasBrackets  =true;
			Code.load(des.getDesignator().obj);
			//report_info("ojjjj"+des.getDesignator().obj.getName(), des);
			
			Code.put(Code.dup_x1);
			Code.put(Code.pop);
		

		
	}
	
	public void visit(ReadStatement r) {
		report_info("reeeeeeead "+r.getDesignator().obj.getName(),r);
		
		if(r.getDesignator().obj.getType().getKind()==3) {
			if(r.getDesignator().obj.getType().getElemType().getKind()==1) {
				Code.put(Code.read);
			}else {
				Code.put(Code.bread);
			}
		}else if(r.getDesignator().obj.getType().getKind()==1) {
			Code.put(Code.read);
		}else {
			Code.put(Code.bread);
		}
		/*Code.put(Code.dup_x1);
		Code.put(Code.pop);*/
		
		Code.store(r.getDesignator().obj);
		Code.put(Code.pop);
		//Code.put(Code.pop);
	}
}
