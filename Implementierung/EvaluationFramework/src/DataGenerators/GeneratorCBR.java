package DataGenerators;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import Exceptions.NegativeNumberException;

public class GeneratorCBR {

	private static String CBRCode;

	public static String generateCBRCode(int parameters) throws NegativeNumberException{
		
		if(parameters < 0) throw new NegativeNumberException("Negative numbers not allowed!");
	
		CBRCode = "";
		CBRCode += generateContextClass();
		CBRCode += generateParameters(parameters);
		CBRCode += generateTransitiveAndTransitiveReflexiveCovers();
		CBRCode += generateContextHierachy();

		return CBRCode;
		
	}

	private static String generateContextClass() {

		// this part is static
		String contextClass = "contextClass(\"aimCtx\"). \nbusinessCaseClass(\"semNOTAMCase\"). \n\n";

		return contextClass;

	}

	private static String generateParameters(int count) {

		List<String> parameters = new ArrayList<String>();
		int paramCount = count;
		String generatedParameters = "";

		for (int i = 0; i < paramCount; i++) {

			// to prevent to have all parameters at the same length, a random Number
			// generator is used.
			int randomNumber = ThreadLocalRandom.current().nextInt(4, 8);
			parameters.add(GeneratorRandomString.getRandomString(randomNumber));
		}

		for (int i = 0; i < parameters.size(); i++) {
			generatedParameters += "hasParameter(\"aimCtx,\"" + parameters.get(i) + "\"). ";
		}

		generatedParameters += "\n";

		for (int i = 0; i < parameters.size(); i++) {
			generatedParameters += "parameter(\"" + parameters.get(i) + "\").\n";
		}

		generatedParameters += "\n";

		return generatedParameters;

	}

	private static String generateTransitiveAndTransitiveReflexiveCovers() {

		// this part is static

		String generatedCovers = "";

		generatedCovers += "tCovers(Pval,Cval) :- tCovers(Pval,X), covers(X,Cval).\r\n"
				+ "tCovers(Pval,Cval) :- covers(Pval,Cval).\r\n"
				+ "trCovers(Pval,Cval) :- tCovers(Pval,Cval). trCovers(Pval,Pval):- paramValue(_,Pval).\n\n";

		return generatedCovers;

	}

	private static String generateContextHierachy() {

		// this part is static

		String generatedContextHierachy = "";

		generatedContextHierachy += "paramCover(P,C,Param):- hasParamValue(C,Param,Pval), hasParamValue(P,Param,Pval2), trCovers(Pval2,Pval).\r\n"
				+ "notParamCover(C,P,Param):- context(C), hasContextClass(C,CtxCl), hasParameter(CtxCl,Param), context(P), not paramCover(C,P,Param).\r\n"
				+ "ctxInherits(C,P) :- paramCover(P,C,_), not notParamCover(P,C,_).\n\n";

		return generatedContextHierachy;

	}
}
