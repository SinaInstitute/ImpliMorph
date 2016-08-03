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
public class Calculations {
    public int inWord1Count;
	public int inWord2Count;
	public int inWord1ANDinWord2Count;
	public int inWord1ORinWord2Count;
	public float Directionless;
	public float W2IndepOfW1;
	public float W1IndepOfW2;

	public Calculations() {
		inWord1Count = 0;
		inWord2Count = 0;
		inWord1ANDinWord2Count = 0;
		inWord1ORinWord2Count = 0;
		Directionless = 0;
		W2IndepOfW1 = 0;
		W1IndepOfW2 = 0;
	}

	private void getInWord1Count(TreeSet<Solution> solutionsSet) {
		for(Solution sol : solutionsSet)
			if(sol._inWord1)
				inWord1Count++;
	}

	private void getInWord2Count(TreeSet<Solution> solutionsSet) {
		for(Solution sol : solutionsSet)
			if(sol._inWord2)
				inWord2Count++;
	}

	private void getWord1ANDinWord2Count(TreeSet<Solution> solutionsSet) {
		for(Solution sol : solutionsSet)
			if(sol._inWord1 && sol._inWord2)
				inWord1ANDinWord2Count++;
	}

	private void getWord1ORinWord2Count(TreeSet<Solution> solutionsSet) {
		inWord1ORinWord2Count = solutionsSet.size();
	}

	private void getCalculations() {
		//If solution not found neither in word1 nor in word2 then return -1, otherwise do calculations:
		Directionless = (float)inWord1ANDinWord2Count/inWord1ORinWord2Count;
		W2IndepOfW1 = 1-((float)inWord1ANDinWord2Count/inWord2Count);
		W1IndepOfW2 = 1-((float)inWord1ANDinWord2Count/inWord1Count);
		if(inWord1Count==0)
			W1IndepOfW2 = -1;
		if(inWord2Count==0)
			W2IndepOfW1 = -1;
	}
	
	public void getCalcResults(TreeSet<Solution> solutionsSet) {
		getInWord1Count(solutionsSet);
		getInWord2Count(solutionsSet);
		getWord1ANDinWord2Count(solutionsSet);
		getWord1ORinWord2Count(solutionsSet);
		getCalculations();
	}
}