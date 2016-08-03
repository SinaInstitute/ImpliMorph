/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MorphDist;

import implication.Implication;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Sina
 */
public class Analyzer {
	
    private InputStream inputStream;
    private BufferedReader bufferedReader;
    private OutputStream outputStream;
    private OutputStreamWriter osw;
    private BufferedWriter bufferedWriter;
    private Process almor;
	
    public Analyzer() {
        ALMOR();
    }

    private void ALMOR() {
	String dir = System.getProperty("user.dir");
	ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("perl", dir +  "/ALMOR_SAMA/ALMOR3.pl", dir +  "/ALMOR_SAMA/almor-s31.db");
        processBuilder.redirectInput();
        try {
            almor = processBuilder.start();
            outputStream = getAlmor().getOutputStream();
            osw = new OutputStreamWriter(outputStream);
            bufferedWriter = new BufferedWriter(osw);
//            bufferedWriter.write(inputWord);
//            bufferedWriter.flush();
//            outputStream.close();
//            osw.close();
//            bufferedWriter.close();
            inputStream = getAlmor().getInputStream();
            bufferedReader = new BufferedReader(new InputStreamReader(getInputStream()));
        } catch (Throwable ex) {
            Logger.getLogger(Analyzer.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public boolean analyze(String word){
        try {
            bufferedWriter.write(word + "\n");
            bufferedWriter.flush();
            System.out.print(almor.waitFor(90, TimeUnit.MILLISECONDS));
        } catch (IOException ex) {
            Logger.getLogger(Analyzer.class.getName()).log(Level.SEVERE, null, ex);
            return false;            
        } catch (InterruptedException ex) {
            Logger.getLogger(Analyzer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
	
	private String extractAlmorWord (String line) {
		Pattern p = Pattern.compile("diac:.([^\\s]+)");
		Matcher m = p.matcher(line);
		if(m.find())
			return m.group().replace("diac:", "");
		return null;
	}
	
	public TreeSet<String> rawSolutions(String word) {
		TreeSet<String> set = new TreeSet<String>();
		BufferedReader almorRes = getBufferedReader();
		String line, almorWord, almorWordAR;
		Implication implication = null;
		int impli;
        try {
            while (almorRes.ready()){
                line = almorRes.readLine();
                //Parse line, take word, and do Implication check here and if implication:
                //almorWord = line.split("\\s")[0].replace("diac:", "");
				//if(almorWord != null)
				almorWord = extractAlmorWord(line);
				almorWordAR = BuckToArab.buckToArabic(almorWord);
                implication = new Implication(almorWordAR, word);
				implication.getImplicationDistance();
				impli = implication.getImplication();
                if(impli > 0){
                    set.add(line);
                }
				System.out.println("line"+line);
				System.out.println("almorWord "+almorWord+"\talmorWordAR "+almorWordAR+"\tword "+word+"\tImplication "+impli);
                                
            }
        } catch (Throwable ex) {
            Logger.getLogger(Analyzer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return set;
    }
    

    /**
     * @return the inputStream
     */
    public InputStream getInputStream() {
        return inputStream;
    }

    /**
     * @return the bufferedReader
     */
    public BufferedReader getBufferedReader() {
        return bufferedReader;
    }

    /**
     * @return the outputStream
     */
    public OutputStream getOutputStream() {
        return outputStream;
    }

    /**
     * @return the osw
     */
    public OutputStreamWriter getOsw() {
        return osw;
    }

    /**
     * @return the bufferedWriter
     */
    public BufferedWriter getBw() {
        return bufferedWriter;
    }

    /**
     * @return the almor
     */
    public Process getAlmor() {
        return almor;
    }
    
    public void closeReaders(){
        try {
            if(bufferedReader != null) bufferedReader.close();
            if(bufferedWriter != null) bufferedWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(Analyzer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}