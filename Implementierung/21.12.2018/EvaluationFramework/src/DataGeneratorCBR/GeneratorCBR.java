package DataGeneratorCBR;

import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import DataGeneratorRandomString.GeneratorRandomString;
import Exceptions.NegativeNumberException;

public class GeneratorCBR {

	private static String CBRCode;
	private static ContextClass cc;
	private static BusinessCaseClass bcc;

	public static String generateCBRCode(int parameters, int parameterValues) {

		CBRCode = "";
		CBRCode += generateContextClass();
		CBRCode += generateBusinessCaseClass();
		CBRCode += generateParameters(parameters);
		CBRCode += generateParameterValues(parameterValues);

		CBRCode += generateParameterValuesAndHierachys();
		CBRCode += generateDetermineParemeterValues();
		CBRCode += generateDetermineRelevantContextsAndMostSpecificRelevantContext();
		CBRCode += generateBusinessCases();

		CBRCode += generateStaticCode();

		return CBRCode;

	}

	public static String generateContextClass() {

		cc = new ContextClass();

		// set length of name
		int randomNumber = ThreadLocalRandom.current().nextInt(4, 8);

		// set name
		cc.setName(GeneratorRandomString.getRandomString(randomNumber));

		String contextClass = "contextClass(\"" + cc.getName() + "\"). \n";

		return contextClass;
	}

	public static String generateBusinessCaseClass() {

		bcc = new BusinessCaseClass();

		// set length of name
		int randomNumber = ThreadLocalRandom.current().nextInt(4, 8);

		// set name
		bcc.setName(GeneratorRandomString.getRandomString(randomNumber));

		String businessCaseClass = "businessCaseClass(\"" + bcc.getName() + "\"). \n\n";

		return businessCaseClass;

	}

	public static String generateParameters(int count) {

		int paramCount = count;
		String generatedParameters = "";

		for (int i = 0; i < paramCount; i++) {

			// to prevent to have all parameters at the same length, a random Number
			// generator is used.
			int randomNumber = ThreadLocalRandom.current().nextInt(4, 8);

			// new parameter is generated and added
			Parameter p = new Parameter();
			p.setName(GeneratorRandomString.getRandomString(randomNumber));
			cc.addParameters(p);
		}

		for (int i = 0; i < cc.getParameters().size(); i++) {
			generatedParameters += "hasParameter(\"" + cc.getName() + ",\"" + cc.getParameters().get(i).getName()
					+ "\"). ";
		}

		generatedParameters += "\n";

		for (int i = 0; i < cc.getParameters().size(); i++) {
			generatedParameters += "parameter(\"" + cc.getParameters().get(i).getName() + "\").\n";
		}

		generatedParameters += "\n";

		return generatedParameters;

	}

	private static String generateParameterValues(int pv) {

		String generatedParameterValues = "";

		for (int i = 0; i < cc.getParameters().size(); i++) {
			for (int m = 0; m <= pv; m++) {
				ParameterValue pp = new ParameterValue();

				// set name length
				int randomNumber = ThreadLocalRandom.current().nextInt(4, 8);

				// set name
				pp.setName(GeneratorRandomString.getRandomString(randomNumber));

				cc.getParameters().get(i).addParameterValues(pp);

			}

		}

		for (int i = 0; i < cc.getParameters().size(); i++) {
			for (int t = 0; t < cc.getParameters().get(i).getParameterValues().size(); t++) {

				generatedParameterValues += "paramValues(\"" + cc.getParameters().get(i).getName() + "\", \""
						+ cc.getParameters().get(i).getParameterValues().get(t).getName() + "\").";

			}

			generatedParameterValues += "\n";

		}

		generatedParameterValues += "\n";
		return generatedParameterValues;

	}

	private static String generateStaticCode() {

		String staticCode = "";

		// transitive and transitive-reflexive covers
		staticCode = "tCovers(Pval,Cval) :- tCovers(Pval,X), covers(X,Cval).\r\n"
				+ "tCovers(Pval,Cval) :- covers(Pval,Cval).\r\n"
				+ "trCovers(Pval,Cval) :- tCovers(Pval,Cval). trCovers(Pval,Pval):- paramValue(_,Pval).\r\n\n";

		// Context Hierarchy
		staticCode += "paramCover(P,C,Param):- hasParamValue(C,Param,Pval), hasParamValue(P,Param,Pval2), trCovers(Pval2,Pval).\r\n"
				+ "notParamCover(C,P,Param):- context(C), hasContextClass(C,CtxCl), hasParameter(CtxCl,Param), context(P), not paramCover(C,P,Param).\r\n"
				+ "ctxInherits(C,P) :- paramCover(P,C,_), not notParamCover(P,C,_).\r\n\n";

		// DETERMINE RELEVANT CONTEXTS AND THE MOST SPECIFIC RELEVANT CONTEXT

		staticCode += "bcParamCover(BC,Ctx,Param) :- hasParamValue(Ctx,Param,PVal), detParamValue(BC,Param,PVal2), trCovers(PVal,PVal2).\r\n"
				+ "notBcParamCover(BC,Ctx,Param) :- businessCase(BC), context(Ctx), hasContextClass(Ctx,CtxCl), hasParameter(CtxCl,Param), not bcParamCover(BC,Ctx,Param).\r\n"
				+ "detRelevantCtxs(BC,Ctx) :- bcParamCover(BC,Ctx,X), not notBcParamCover(BC,Ctx,Y)\n\n";

		staticCode += "hasRelevantDescendant(BC,Ctx) :- detRelevantCtxs(BC,Ctx), detRelevantCtxs(BC,Ctx2), ctxInherits(Ctx2,Ctx), not w_ctxIdent(Ctx,Ctx2), Ctx!=Ctx2.\r\n"
				+ "detMostSpecificCtx(BC,Ctx) :- detRelevantCtxs(BC,Ctx), not hasRelevantDescendant(BC,Ctx).\n\n";

		staticCode += "@output(\"detMostSpecificCtx\"). @post(\"detMostSpecificCtx\",\"orderby(1,2)\").\r\n"
				+ "@output(\"detRelevantCtxs\"). @post(\"detRelevantCtxs\",\"orderby(1,2)\").\n\n";

		// WARNINGS

		staticCode += "w_incompleteCtxSpec(C) :- parameter(P), context(C), not hasParamValue(C,P,_).\r\n"
				+ "@output(\"w_incompleteCtxSpec\").\n\n";

		staticCode += "ctxDiffParamValue(Ctx1,Ctx2) :- context(Ctx1), context(Ctx2), hasParamValue(Ctx1,P,PVal1), hasParamValue(Ctx2,P,PVal2), PVal1!=PVal2.\r\n"
				+ "w_ctxIdent(Ctx1,Ctx2) :- context(Ctx1), context(Ctx2), not ctxDiffParamValue(Ctx1,Ctx2),Ctx1!=Ctx2.\r\n"
				+ "@output(\"w_ctxIdent\").\n\n";

		return staticCode;
	}

	private static String generateParameterValuesAndHierachys() {
		return "";
	}

	private static String generateDetermineParemeterValues() {
		return "";
	}

	private static String generateDetermineRelevantContextsAndMostSpecificRelevantContext() {
		return "";
	}

	private static String generateBusinessCases() {
		return "";
	}
}
