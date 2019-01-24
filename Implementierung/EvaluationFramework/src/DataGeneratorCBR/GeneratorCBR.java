package DataGeneratorCBR;

import java.util.concurrent.ThreadLocalRandom;

import DataGeneratorRandomString.GeneratorRandomString;

public class GeneratorCBR {

	private static String CBRCode;
	private static ContextClass cc;
	private static BusinessCaseClass bcc;

	public static String generateCBRCode(int parameters, int paramValues, int businessCases) {

		CBRCode = "";
		CBRCode += generateContextClass();
		CBRCode += generateBusinessCaseClass();
		CBRCode += generateParameters(parameters);
		CBRCode += generateParameterValues(paramValues);
		CBRCode += generateParameterValuesHierarchies();
		CBRCode += generateContexts(paramValues);
		CBRCode += generateDetermineParameterValues();
		CBRCode += generateBusinessCases(businessCases);
		CBRCode += generateStaticCode();

		return CBRCode;

	}

	public static String generateContextClass() {
		String contextClass = "";
		cc = new ContextClass();

		contextClass += "% Generic Components\n";

		// set length of name
		int randomNumber = ThreadLocalRandom.current().nextInt(4, 8);

		// set name
		cc.setName("ccName_" + GeneratorRandomString.getRandomString(randomNumber) + "Ctx");

		contextClass += "contextClass(\"" + cc.getName() + "\"). \n";

		return contextClass;
	}

	public static String generateBusinessCaseClass() {

		bcc = new BusinessCaseClass();

		// set length of name
		int randomNumber = ThreadLocalRandom.current().nextInt(4, 8);

		// set name
		bcc.setName("bccName_" + GeneratorRandomString.getRandomString(randomNumber) + "Case");

		String businessCaseClass = "businessCaseClass(\"" + bcc.getName() + "\"). \n\n";

		return businessCaseClass;

	}

	public static String generateParameters(int count) {

		int paramCount = count;
		String generatedParameters = "";

		generatedParameters += "% Parameters\n";

		for (int i = 0; i < paramCount; i++) {

			// to prevent to have all parameters at the same length, a random Number
			// generator is used.
			int randomNumber = ThreadLocalRandom.current().nextInt(4, 8);

			// new parameter is generated and added
			Parameter p = new Parameter();
			p.setName("Param_" + cc.getParameters().size() + "_" + GeneratorRandomString.getRandomString(randomNumber));
			cc.addParameters(p);
		}

		for (int i = 0; i < cc.getParameters().size(); i++) {
			generatedParameters += "hasParameter(\"" + cc.getName() + "\"" + ",\"" + cc.getParameters().get(i).getName()
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

		generatedParameterValues += "% Parameter Values\n";

		for (int i = 0; i < cc.getParameters().size(); i++) {
			for (int m = 0; m < pv; m++) {
				ParameterValue pp = new ParameterValue();

				// set name length
				int randomNumber = ThreadLocalRandom.current().nextInt(4, 8);

				// set name
				pp.setName("ParamValue_" + i + "_" + cc.getParameters().get(i).getParameterValues().size() + "_"
						+ GeneratorRandomString.getRandomString(randomNumber));

				cc.getParameters().get(i).addParameterValues(pp);

			}

		}

		for (int i = 0; i < cc.getParameters().size(); i++) {
			for (int t = 0; t < cc.getParameters().get(i).getParameterValues().size(); t++) {

				generatedParameterValues += "paramValues(\"" + cc.getParameters().get(i).getName() + "\",\""
						+ cc.getParameters().get(i).getParameterValues().get(t).getName() + "\").";

			}

			generatedParameterValues += "\n";

		}

		generatedParameterValues += "\n";
		return generatedParameterValues;

	}

	private static String generateParameterValuesHierarchies() {

		String generatedParameterValuesHierarchies = "";

		// random choice if hierarchy tree is wide or deep
		// random number 0 = wide hierarchy tree is wide
		// random number 1 = wide hierarchy tree is deep

		int randomNumber = ThreadLocalRandom.current().nextInt(0, 2);

		if (randomNumber == 0) {

			generatedParameterValuesHierarchies += "% Parameter Hierachies\n";

			for (int i = 0; i < cc.getParameters().size(); i++) {

				int x = cc.getParameters().get(i).getParameterValues().size() / 2;

				for (int t = 1; t < x; t++) {

					generatedParameterValuesHierarchies += "covers(\""
							+ cc.getParameters().get(i).getParameterValues().get(0).getName() + "\",\""
							+ cc.getParameters().get(i).getParameterValues().get(t).getName() + "\").";

				}

				for (int u = x + 1; u < cc.getParameters().get(i).getParameterValues().size(); u++) {

					generatedParameterValuesHierarchies += "covers(\""
							+ cc.getParameters().get(i).getParameterValues().get(x).getName() + "\",\""
							+ cc.getParameters().get(i).getParameterValues().get(u).getName() + "\").";

				}
				generatedParameterValuesHierarchies += "\n";
			}

		}

		if (randomNumber == 1) {

			for (int i = 0; i < cc.getParameters().size(); i++) {

				for (int u = 0; u < cc.getParameters().get(i).getParameterValues().size() - 1; u++) {
					generatedParameterValuesHierarchies += "covers(\""
							+ cc.getParameters().get(i).getParameterValues().get(u).getName() + "\",\""
							+ cc.getParameters().get(i).getParameterValues().get(u + 1).getName() + "\").";
				}

				generatedParameterValuesHierarchies += "\n";

			}
		}

		generatedParameterValuesHierarchies += "\n";

		return generatedParameterValuesHierarchies;
	}

	private static String generateContexts(int contexts) {
		String generatedContexts = "";
		generatedContexts += "% Contexts\n";

		for (int i = 0; i < contexts; i++) {

			Context c = new Context();
			c.setCtx("ctx" + i);

			generatedContexts += "context(\"" + c.getCtx() + "\").\n";

			// to prevent to have all context names at the same length, a random Number
			// generator is used.
			int randomNumber = ThreadLocalRandom.current().nextInt(4, 8);

			// new context name is generated and added
			c.setName("ctxName_" + GeneratorRandomString.getRandomString(randomNumber));
			generatedContexts += "hasName(\"" + c.getCtx() + "\",\"" + c.getName() + "\").\n";

			// new module is generated
			Module m = new Module();
			m.setName("module" + i);

			c.setModule(m);

			generatedContexts += "hasModule(\"" + c.getCtx() + "\",\"" + c.getModule().getName() + "\"). ";

			// context class is set
			c.setContextClass(cc.getName());

			generatedContexts += "hasContextClass(\"" + c.getCtx() + "\",\"" + c.getContextClass() + "\").\n";

			// match parameter values

			for (int p = 0; p < cc.getParameters().size(); p++) {

				generatedContexts += "hasParamValues(\"" + c.getCtx() + "\",\"" + cc.getParameters().get(p).getName()
						+ "\",\"" + cc.getParameters().get(p).getParameterValues().get(i).getName() + "\").\n";

			}

			cc.addContexts(c);
			generatedContexts += "\n";
		}

		generatedContexts += "\n";
		return generatedContexts;
	}

	private static String generateDetermineParameterValues() {
		String genratedDetermineParameterValues = "";

		genratedDetermineParameterValues += "% Determine Parameter Values\n";

		for (int i = 0; i < cc.getParameters().size(); i++) {

			// to prevent to have all determined parameter values names at the same length,
			// a random Number
			// generator is used.
			int randomNumber = ThreadLocalRandom.current().nextInt(4, 8);

			cc.getParameters().get(i).setDescProp("descProp_" + GeneratorRandomString.getRandomString(randomNumber));

			genratedDetermineParameterValues += "detParamValue(BC,\"" + cc.getParameters().get(i).getName()
					+ "\",Val) :- businessCase(BC), hasDescProp(BC,\"" + cc.getParameters().get(i).getDescProp()
					+ "\",Val).\n";

		}

		genratedDetermineParameterValues += "\n";

		return genratedDetermineParameterValues;
	}

	private static String generateBusinessCases(int businessCases) {
		String generatedBusinessCases = "";

		generatedBusinessCases += "% Business Cases\n";

		generatedBusinessCases += "hasBusinessCaseClass(BC,\"" + bcc.getName() + "\") :- businessCase(BC).\n";

		int x = cc.getParameters().size();

		for (int i = 1; i <= businessCases; i++) {

			String bcName = "";
			bcName = "bc" + i;

			BusinessCase bc = new BusinessCase();
			bc.setName(bcName);

			for (int t = 0; t < x; t++) {
				String descProp = "";
				String paramValue = "";

				descProp = cc.getParameters().get(t).getDescProp();

				// to get one random paramValue from the chosen Parameter
				int help = cc.getParameters().get(t).getParameterValues().size();
				int randomNumber = ThreadLocalRandom.current().nextInt(0, help);
				paramValue = cc.getParameters().get(t).getParameterValues().get(randomNumber).getName();

				bc.addDescProp(descProp);
				bc.addParameterValues(paramValue);

				generatedBusinessCases += "businessCase(\"" + bc.getName() + "\")." + "hasDescProp(\"" + bc.getName()
						+ "\",\"" + bc.getDescProp().get(t) + "\",\"" + bc.getParameterValues().get(t) + "\").";

				generatedBusinessCases += "\n";

			}

			bcc.addBusinessCase(bc);

			generatedBusinessCases += "\n";
		}

		generatedBusinessCases += "\n";
		return generatedBusinessCases;
	}

	private static String generateStaticCode() {

		String staticCode = "";

		// transitive and transitive-reflexive covers
		staticCode += "% transitive and transitive-reflexive covers\n";
		staticCode += "tCovers(Pval,Cval) :- tCovers(Pval,X), covers(X,Cval).\r\n"
				+ "tCovers(Pval,Cval) :- covers(Pval,Cval).\r\n"
				+ "trCovers(Pval,Cval) :- tCovers(Pval,Cval). trCovers(Pval,Pval):- paramValue(_,Pval).\r\n\n";

		// Context Hierarchy
		staticCode += "% Context Hierarchy\n";
		staticCode += "paramCover(P,C,Param):- hasParamValue(C,Param,Pval), hasParamValue(P,Param,Pval2), trCovers(Pval2,Pval).\r\n"
				+ "notParamCover(C,P,Param):- context(C), hasContextClass(C,CtxCl), hasParameter(CtxCl,Param), context(P), not paramCover(C,P,Param).\r\n"
				+ "ctxInherits(C,P) :- paramCover(P,C,_), not notParamCover(P,C,_).\r\n\n";

		// DETERMINE RELEVANT CONTEXTS AND THE MOST SPECIFIC RELEVANT CONTEXT

		staticCode += "% DETERMINE RELEVANT CONTEXTS AND THE MOST SPECIFIC RELEVANT CONTEXT\n";
		staticCode += "bcParamCover(BC,Ctx,Param) :- hasParamValue(Ctx,Param,PVal), detParamValue(BC,Param,PVal2), trCovers(PVal,PVal2).\r\n"
				+ "notBcParamCover(BC,Ctx,Param) :- businessCase(BC), context(Ctx), hasContextClass(Ctx,CtxCl), hasParameter(CtxCl,Param), not bcParamCover(BC,Ctx,Param).\r\n"
				+ "detRelevantCtxs(BC,Ctx) :- bcParamCover(BC,Ctx,X), not notBcParamCover(BC,Ctx,Y).\r\n" + "\r\n"
				+ "hasRelevantDescendant(BC,Ctx) :- detRelevantCtxs(BC,Ctx), detRelevantCtxs(BC,Ctx2), ctxInherits(Ctx2,Ctx), not w_ctxIdent(Ctx,Ctx2), Ctx!=Ctx2.\r\n"
				+ "detMostSpecificCtx(BC,Ctx) :- detRelevantCtxs(BC,Ctx), not hasRelevantDescendant(BC,Ctx).\r\n"
				+ "\r\n" + "@output(\"detMostSpecificCtx\"). @post(\"detMostSpecificCtx\",\"orderby(1,2)\").\r\n"
				+ "@output(\"detRelevantCtxs\"). @post(\"detRelevantCtxs\",\"orderby(1,2)\").";
		// WARNINGS
		staticCode += "% WARNINGS\n";
		staticCode += "w_incompleteCtxSpec(C) :- parameter(P), context(C), not hasParamValue(C,P,_).\r\n"
				+ "@output(\"w_incompleteCtxSpec\").\n\n";

		staticCode += "ctxDiffParamValue(Ctx1,Ctx2) :- context(Ctx1), context(Ctx2), hasParamValue(Ctx1,P,PVal1), hasParamValue(Ctx2,P,PVal2), PVal1!=PVal2.\r\n"
				+ "w_ctxIdent(Ctx1,Ctx2) :- context(Ctx1), context(Ctx2), not ctxDiffParamValue(Ctx1,Ctx2),Ctx1!=Ctx2.\r\n"
				+ "@output(\"w_ctxIdent\").\n\n";

		return staticCode;
	}

}