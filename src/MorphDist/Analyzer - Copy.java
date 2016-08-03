/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
package MorphDist;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
*/

/**
 *
 * @author Sina
 */
/*
public class Analyzer {
	
    private InputStream inputStream;
    private BufferedReader bufferedReader;
	private static OutputStream outputStream;
	private static OutputStreamWriter osw;
	private BufferedWriter bw;
	private static ProcessBuilder processBuilder;
	private static Process process;

	public static void initALMOR() {
		String dir = System.getProperty("user.dir");
		processBuilder = new ProcessBuilder();
        processBuilder.command("perl", dir +  "/ALMOR_SAMA/ALMOR3.pl", dir +  "/ALMOR_SAMA/almor-s31.db");
        processBuilder.redirectInput();
        try {
            process = processBuilder.start();
			outputStream = process.getOutputStream();
			osw = new OutputStreamWriter(outputStream);
        } catch (IOException ex) {
            Logger.getLogger(Analyzer.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
	
    private void startALMOR(String inputWord) {
		bw = new BufferedWriter(osw);
        try {
			bw.write(inputWord);
			bw.flush();
            //outputStream.close();
            //osw.close();
			bw.close();
            inputStream = process.getInputStream();
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        } catch (IOException ex) {
            Logger.getLogger(Analyzer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
	
    public TreeSet<String> rawSolutions(String inputWord) {
		TreeSet<String> set = new TreeSet<String>();
		startALMOR(inputWord);
		BufferedReader almorRes = bufferedReader;
		String line=null;
        try {
            while ((line = almorRes.readLine()) != null)
                set.add(line);
            //inputStream.close();
            //bufferedReader.close();
        } catch (IOException ex) {
            Logger.getLogger(Analyzer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return set;
    }
}
*/