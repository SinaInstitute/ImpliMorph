/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MorphDist;

import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Sina
 */
public class Solution implements Comparable <Solution>, Comparator<Solution>{
    public  String _solution;
	public  boolean _inWord1;
	public  boolean _inWord2;
	public Solution(String _solution, boolean _inWord1,  boolean _inWord2)
	{
		this._solution = _solution;
		this._inWord1 = _inWord1;
		this._inWord2 = _inWord2;
	}

    @Override
    public int compareTo(Solution o) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return this._solution.compareTo(o._solution);
    }

    @Override
    public int compare(Solution o1, Solution o2) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
		return o1._solution.compareTo(o2._solution);
    }
}