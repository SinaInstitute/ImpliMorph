/*
 * Written by Rami Asia
 * October 2014
 * Sina Institute, Birzeit University, Palestine
 * Version 1.0
 * 
 */

package MorphDist;

public class BuckToArab {
	
	public static String buckToArabic(String inputt){
		
		String input = inputt;

		input = input.replaceAll("'", "\u0621");
		input = input.replaceAll("\\|", "\u0622");
		input = input.replaceAll(">", "\u0623");
		input = input.replaceAll("&", "\u0624");
		input = input.replaceAll("<", "\u0625");
		input = input.replaceAll("}", "\u0626");
		input = input.replaceAll("A", "\u0627");
		input = input.replaceAll("b", "\u0628");
		input = input.replaceAll("p", "\u0629");
		input = input.replaceAll("t", "\u062A");
		input = input.replaceAll("v", "\u062B");
		input = input.replaceAll("j", "\u062C");
		input = input.replaceAll("H", "\u062D");
		input = input.replaceAll("x", "\u062E");
		input = input.replaceAll("d", "\u062F");
		input = input.replaceAll("\\*", "\u0630");
		input = input.replaceAll("r", "\u0631");
		input = input.replaceAll("z", "\u0632");
		input = input.replaceAll("s", "\u0633");
		input = input.replaceAll("\\$", "\u0634");
		input = input.replaceAll("S", "\u0635");
		input = input.replaceAll("D", "\u0636");
		input = input.replaceAll("T", "\u0637");
		input = input.replaceAll("Z", "\u0638");
		input = input.replaceAll("E", "\u0639");
		input = input.replaceAll("g", "\u063A");
		input = input.replaceAll("_", "\u0640");
		input = input.replaceAll("f", "\u0641");
		input = input.replaceAll("q", "\u0642");
		input = input.replaceAll("k", "\u0643");
		input = input.replaceAll("l", "\u0644");
		input = input.replaceAll("m", "\u0645");
		input = input.replaceAll("n", "\u0646");
		input = input.replaceAll("h", "\u0647");
		input = input.replaceAll("w", "\u0648");
		input = input.replaceAll("Y", "\u0649");
		input = input.replaceAll("y", "\u064A");
		input = input.replaceAll("F", "\u064B");
		input = input.replaceAll("N", "\u064C");
		input = input.replaceAll("K", "\u064D");
		input = input.replaceAll("a", "\u064E");
		input = input.replaceAll("u", "\u064F");
		input = input.replaceAll("i", "\u0650");
		input = input.replaceAll("~", "\u0651");
		input = input.replaceAll("o", "\u0652");
		input = input.replaceAll("\\^", "\u0653");
		input = input.replaceAll("#", "\u0654");
		input = input.replaceAll("`", "\u0670");
		input = input.replaceAll("\\{", "\u0671");
		input = input.replaceAll(":", "\u06DC");
		input = input.replaceAll("@", "\u06DF");
		input = input.replaceAll("\"", "\u06E0");
		input = input.replaceAll("\\[", "\u06E2");
		input = input.replaceAll(";", "\u06E3");
		input = input.replaceAll(",", "\u06E5");
		input = input.replaceAll("\\.", "\u06E6");
		input = input.replaceAll("!", "\u06E8");
		input = input.replaceAll("-", "\u06EA");
		input = input.replaceAll("\\+", "\u06EB");
		input = input.replaceAll("%", "\u06EC");
		input = input.replaceAll("]", "\u06ED");
		
		return input;
	}
	
	public static String arabicToBuck(String inputt){
		
		String input = inputt;

		input = input.replaceAll("\u0621", "'");
		input = input.replaceAll("\u0622", "\\|");
		input = input.replaceAll("\u0623", ">");
		input = input.replaceAll("\u0624", "&");
		input = input.replaceAll("\u0625", "<");
		input = input.replaceAll("\u0626", "}");
		input = input.replaceAll("\u0627", "A");
		input = input.replaceAll("\u0628", "b");
		input = input.replaceAll("\u0629", "p");
		input = input.replaceAll("\u062A", "t");
		input = input.replaceAll("\u062B", "v");
		input = input.replaceAll("\u062C", "j");
		input = input.replaceAll("\u062D", "H");
		input = input.replaceAll("\u062E", "x");
		input = input.replaceAll("\u062F", "d");
		input = input.replaceAll("\u0630", "\\*");
		input = input.replaceAll("\u0631", "r");
		input = input.replaceAll("\u0632", "z");
		input = input.replaceAll("\u0633", "s");
		input = input.replaceAll("\u0634", "\\$");
		input = input.replaceAll("\u0635", "S");
		input = input.replaceAll("\u0636", "D");
		input = input.replaceAll("\u0637", "T");
		input = input.replaceAll("\u0638", "Z");
		input = input.replaceAll("\u0639", "E");
		input = input.replaceAll("\u063A", "g");
		input = input.replaceAll("\u0640", "_");
		input = input.replaceAll("\u0641", "f");
		input = input.replaceAll("\u0642", "q");
		input = input.replaceAll("\u0643", "k");
		input = input.replaceAll("\u0644", "l");
		input = input.replaceAll("\u0645", "m");
		input = input.replaceAll("\u0646", "n");
		input = input.replaceAll("\u0647", "h");
		input = input.replaceAll("\u0648", "w");
		input = input.replaceAll("\u0649", "Y");
		input = input.replaceAll("\u064A", "y");
		input = input.replaceAll("\u064B", "F");
		input = input.replaceAll("\u064C", "N");
		input = input.replaceAll("\u064D", "K");
		input = input.replaceAll("\u064E", "a");
		input = input.replaceAll("\u064F", "u");
		input = input.replaceAll("\u0650", "i");
		input = input.replaceAll("\u0651", "~");
		input = input.replaceAll("\u0652", "o");
		input = input.replaceAll("\u0653", "\\^");
		input = input.replaceAll("\u0654", "#");
		input = input.replaceAll("\u0670", "`");
		input = input.replaceAll("\u0671", "\\{");
		input = input.replaceAll("\u06DC", ":");
		input = input.replaceAll("\u06DF", "@");
		input = input.replaceAll("\u06E0", "\"");
		input = input.replaceAll("\u06E2", "\\[");
		input = input.replaceAll("\u06E3", ";");
		input = input.replaceAll("\u06E5", ",");
		input = input.replaceAll("\u06E6", "\\.");
		input = input.replaceAll("\u06E8", "!");
		input = input.replaceAll("\u06EA", "-");
		input = input.replaceAll("\u06EB", "\\+");
		input = input.replaceAll("\u06EC", "%");
		input = input.replaceAll("\u06ED", "\\]");
		
		return input;
	}
	
	
public static String buckToArabicNoDiacritics(String inputt){
		
		String input = inputt;

		input = input.replaceAll("'", "\u0621");
		input = input.replaceAll("\\|", "\u0622");
		input = input.replaceAll(">", "\u0623");
		input = input.replaceAll("&", "\u0624");
		input = input.replaceAll("<", "\u0625");
		input = input.replaceAll("}", "\u0626");
		input = input.replaceAll("A", "\u0627");
		input = input.replaceAll("b", "\u0628");
		input = input.replaceAll("p", "\u0629");
		input = input.replaceAll("t", "\u062A");
		input = input.replaceAll("v", "\u062B");
		input = input.replaceAll("j", "\u062C");
		input = input.replaceAll("H", "\u062D");
		input = input.replaceAll("x", "\u062E");
		input = input.replaceAll("d", "\u062F");
		input = input.replaceAll("\\*", "\u0630");
		input = input.replaceAll("r", "\u0631");
		input = input.replaceAll("z", "\u0632");
		input = input.replaceAll("s", "\u0633");
		input = input.replaceAll("\\$", "\u0634");
		input = input.replaceAll("S", "\u0635");
		input = input.replaceAll("D", "\u0636");
		input = input.replaceAll("T", "\u0637");
		input = input.replaceAll("Z", "\u0638");
		input = input.replaceAll("E", "\u0639");
		input = input.replaceAll("g", "\u063A");
		input = input.replaceAll("_", "\u0640");
		input = input.replaceAll("f", "\u0641");
		input = input.replaceAll("q", "\u0642");
		input = input.replaceAll("k", "\u0643");
		input = input.replaceAll("l", "\u0644");
		input = input.replaceAll("m", "\u0645");
		input = input.replaceAll("n", "\u0646");
		input = input.replaceAll("h", "\u0647");
		input = input.replaceAll("w", "\u0648");
		input = input.replaceAll("Y", "\u0649");
		input = input.replaceAll("y", "\u064A");
		input = input.replaceAll("F", "\u064B");
		input = input.replaceAll("N", "\u064C");
		input = input.replaceAll("K", "\u064D");
		input = input.replaceAll("a", "");
		input = input.replaceAll("u", "");
		input = input.replaceAll("i", "");
		input = input.replaceAll("~", "");
		input = input.replaceAll("o", "");
		input = input.replaceAll("\\^", "\u0653");
		input = input.replaceAll("#", "\u0654");
		input = input.replaceAll("`", "\u0670");
		input = input.replaceAll("\\{", "\u0671");
		input = input.replaceAll(":", "\u06DC");
		input = input.replaceAll("@", "\u06DF");
		input = input.replaceAll("\"", "\u06E0");
		input = input.replaceAll("\\[", "\u06E2");
		input = input.replaceAll(";", "\u06E3");
		input = input.replaceAll(",", "\u06E5");
		input = input.replaceAll("\\.", "\u06E6");
		input = input.replaceAll("!", "\u06E8");
		input = input.replaceAll("-", "\u06EA");
		input = input.replaceAll("\\+", "\u06EB");
		input = input.replaceAll("%", "\u06EC");
		input = input.replaceAll("]", "\u06ED");
		
		return input;
	}
}
