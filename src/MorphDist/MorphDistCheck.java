/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MorphDist;

import java.util.TreeSet;

/**
 *
 * @author Sina
 */
public class MorphDistCheck {
    Analyzer analyzer;
    
    public MorphDistCheck(Analyzer a){
        this.analyzer = a;
    }
    
    public Calculations MorphDistCheck(String word1BW, String word2BW, String word1Orig, String word2Orig) {
//		Analyzer analyzerW1 = new Analyzer(word1BW);
//		Analyzer analyzerW2 = new Analyzer(word2BW);
		
        TreeSet<String> rawSolutionsW1 = new TreeSet<String>();
        TreeSet<String> rawSolutionsW2 = new TreeSet<String>();
        
        analyzer.analyze(word1BW);
        rawSolutionsW1 = analyzer.rawSolutions(word1Orig);
        analyzer.analyze(word2BW);
        rawSolutionsW2 = analyzer.rawSolutions(word2Orig);
		
		System.out.println("\n=== raw solutions for word1 ===");
        for(String rawSolW1 : rawSolutionsW1)
            System.out.println(rawSolW1);
		System.out.println("\n=== raw solutions for word2 ===");
		for(String rawSolW2 : rawSolutionsW2)
            System.out.println(rawSolW2);
		
		// all solutions of word1 and word2 compined...
        Solutions solutions = new Solutions();
        solutions.setSolutionsForWord1(rawSolutionsW1);
		solutions.setSolutionsForWord2(rawSolutionsW2);
		System.out.println("\n=== solutions for word1 and word2 compined ===");
        for(Solution sol : solutions.solutionsSet)
            System.out.println(sol._solution + " --- " + sol._inWord1 + " --- " + sol._inWord2);
		
		Calculations calculationsRes = new Calculations();
		calculationsRes.getCalcResults(solutions.solutionsSet);
		
		return calculationsRes;
	}
}