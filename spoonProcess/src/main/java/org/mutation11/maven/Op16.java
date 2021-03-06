package org.mutation11.maven;

import spoon.processing.AbstractProcessor;
import spoon.reflect.code.UnaryOperatorKind;
import spoon.reflect.code.CtUnaryOperator;
import spoon.reflect.declaration.CtElement;

public class Op16 extends AbstractProcessor<CtElement> {
	@Override
	public boolean isToBeProcessed(CtElement candidate) {
		if (candidate instanceof CtUnaryOperator) {
			CtUnaryOperator op = (CtUnaryOperator)candidate;
			return op.getKind().equals(UnaryOperatorKind.POSTINC) || op.getKind().equals(UnaryOperatorKind.PREINC); 
		} else return false;
	}

	@Override
	public void process(CtElement candidate) {
		if (!(candidate instanceof CtUnaryOperator)) {
			return;
		}
		CtUnaryOperator op = (CtUnaryOperator)candidate;
		if (op.getKind().equals(UnaryOperatorKind.POSTINC)){
			op.setKind(UnaryOperatorKind.POSTDEC);
		} else if (op.getKind().equals(UnaryOperatorKind.PREINC)){
			op.setKind(UnaryOperatorKind.PREDEC);
		}
		
	}
}
