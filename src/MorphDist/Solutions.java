/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MorphDist;

import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Sina
 */
public class Solutions {

    public TreeSet<Solution> solutionsSet = new TreeSet<Solution>();

	/*private int indexOfBySol(String searchedSol) {
		  int i = 0;
		  for (Solution sol : solutionsSet) {
			if (sol._solution.equals(searchedSol))
				return i;
			i++;
		  }
		  return -1;
	}*/
	
        private String extractSolution (String rawSolution) {
                     Pattern p = Pattern.compile("bw:.([^\\s]+)");
                    Matcher m = p.matcher(rawSolution);
                    if(m.find())
                                    return m.group();
                     return null;
        }

	public void setSolutionsForWord1 (TreeSet<String> rawSolutions) {
		String _solution;
		for(String rawSol : rawSolutions) {
			_solution = extractSolution(rawSol);
			if(_solution != null)
				//add a new record...
				solutionsSet.add(new Solution(_solution,true, false));
		}
	}
	
	public void setSolutionsForWord2 (TreeSet<String> rawSolutions) {
        String _solution;
		//int i;
        for(String rawSol : rawSolutions) {
            _solution = extractSolution(rawSol);
			Solution tmp = new Solution(_solution,false, true);
			if(!solutionsSet.contains(tmp)){//add a new record...
				solutionsSet.add(tmp);
			}
			else{//update that record...
				solutionsSet.remove(tmp);
				tmp._inWord1=true;
				solutionsSet.add(tmp);
			}
		}
    }
}