package implication;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Implication {
	
    private final int MAYBE_THRESH = 30; 
    private final int SURE_THRESH = 27; 
    private final String DISTANCE_FILE = "./assets/distance_table.txt";
    private int wordOneLength, wordTwoLength;
    private String wordOneDiacritized, wordOneUndiacritized, wordTwoDiacritized,
            wordTwoUndiacritized, wordOneOrig, wordTwoOrig;
    private char[] wordOneCharArray, wordTwoCharArray, wordOneHSArray, wordTwoHSArray;
    private char[][] wordOneDiacritics, wordTwoDiacritics;
    private int[][] distanceTable;
    private int[] similarityResults;
    private int conflictCount = 0, implication;
    private HashMap<String, Integer> hashMap;
    private final int DIACRITICS_AMOUNT = 2;
    private boolean hamzaDiff = false, lastShadda = false;


    private char[] letters = {'\u0621', '\u0622', '\u0623', '\u0624', '\u0626', '\u0627', '\u0628', '\u0629', '\u062A', '\u062B', '\u062C', '\u062D',
                    '\u062E', '\u062F', '\u0630', '\u0631', '\u0632', '\u0633', '\u0634', '\u0635', '\u0636', '\u0637', '\u0638', '\u0639', '\u063A', '\u0640', '\u0641', 
                    '\u0642', '\u0643', '\u0644', '\u0645', '\u0646', '\u0647', '\u0648', '\u0649', '\u064A'}; 

    private char[] diacritics = {'\u064E', '\u064F', '\u0650', '\u0652', '\u064B', '\u064C', '\u064D', '>', '<', '\u0651'};
    
    private char[] hamzaShadda = {'\u0621','\u0651', '>', '<'};

    public Implication(String input1, String input2){
        this.wordOneOrig = input1;
        if(isDiacritic(wordOneOrig.charAt(0))){
            if(wordOneOrig.charAt(1) == '\u0625') {
//              this.wordOneDiacritized = input2.replaceAll("\u0625", "\u0627<").replaceAll("\u0623", "\u0627>").replaceAll("\u0671", "\u0627").trim();
                this.wordOneDiacritized = "\u0627<" + wordOneOrig.charAt(0) + 
                        input1.substring(2).replaceAll("\u0625", "\u0627\u0621").replaceAll("\u0623", "\u0627\u0621").replaceAll("\u0671", "\u0627").trim();
            } else if(wordOneOrig.charAt(1) == '\u0623') {
                this.wordOneDiacritized =  "\u0627>" + wordOneOrig.charAt(0) +
                        input1.substring(2).replaceAll("\u0625", "\u0627\u0621").replaceAll("\u0623", "\u0627\u0621").replaceAll("\u0671", "\u0627").trim();
            } else {
                this.wordOneDiacritized = input1.replaceAll("\u0625", "\u0627\u0621").replaceAll("\u0623", "\u0627\u0621").replaceAll("\u0671", "\u0627").trim();
            }
        } else {
            if(wordOneOrig.startsWith("\u0625")) {
//              this.wordOneDiacritized = input2.replaceAll("\u0625", "\u0627<").replaceAll("\u0623", "\u0627>").replaceAll("\u0671", "\u0627").trim();
                this.wordOneDiacritized = "\u0627<" +
                        input1.substring(1).replaceAll("\u0625", "\u0627\u0621").replaceAll("\u0623", "\u0627\u0621").replaceAll("\u0671", "\u0627").trim();
            } else if(wordOneOrig.startsWith("\u0623")) {
                this.wordOneDiacritized = "\u0627>" +
                        input1.substring(1).replaceAll("\u0625", "\u0627\u0621").replaceAll("\u0623", "\u0627\u0621").replaceAll("\u0671", "\u0627").trim();
            } else {
                this.wordOneDiacritized = input1.replaceAll("\u0625", "\u0627\u0621").replaceAll("\u0623", "\u0627\u0621").replaceAll("\u0671", "\u0627").trim();
            }
        }

        this.wordOneLength = input1.length();
        this.wordOneUndiacritized = undiacritize(this.wordOneDiacritized);
        this.wordOneCharArray = wordOneUndiacritized.toCharArray();
        this.wordOneDiacritics = createDiacriticsArray(this.wordOneDiacritized, this.wordOneCharArray);

        this.wordTwoOrig = input2;
        if(isDiacritic(wordTwoOrig.charAt(0))){
            if(wordTwoOrig.charAt(1) == '\u0625') {
//              this.wordTwoDiacritized = input2.replaceAll("\u0625", "\u0627<").replaceAll("\u0623", "\u0627>").replaceAll("\u0671", "\u0627").trim();
                this.wordTwoDiacritized =  "\u0627<" + wordTwoOrig.charAt(0) +
                        input2.substring(2).replaceAll("\u0625", "\u0627\u0621").replaceAll("\u0623", "\u0627\u0621").replaceAll("\u0671", "\u0627").trim();
            } else if(wordTwoOrig.charAt(1) == '\u0623') {
                this.wordTwoDiacritized =  "\u0627>" + wordTwoOrig.charAt(0) +
                        input2.substring(2).replaceAll("\u0625", "\u0627\u0621").replaceAll("\u0623", "\u0627\u0621").replaceAll("\u0671", "\u0627").trim();
            } else {
                this.wordTwoDiacritized = input2.replaceAll("\u0625", "\u0627\u0621").replaceAll("\u0623", "\u0627\u0621").replaceAll("\u0671", "\u0627").trim();
            }
        } else {
            if(wordTwoOrig.startsWith("\u0625")) {
//              this.wordTwoDiacritized = input2.replaceAll("\u0625", "\u0627<").replaceAll("\u0623", "\u0627>").replaceAll("\u0671", "\u0627").trim();
                this.wordTwoDiacritized = "\u0627<" +
                        input2.substring(1).replaceAll("\u0625", "\u0627\u0621").replaceAll("\u0623", "\u0627\u0621").replaceAll("\u0671", "\u0627").trim();
            } else if(wordTwoOrig.startsWith("\u0623")) {
                this.wordTwoDiacritized = "\u0627>" +
                        input2.substring(1).replaceAll("\u0625", "\u0627\u0621").replaceAll("\u0623", "\u0627\u0621").replaceAll("\u0671", "\u0627").trim();
            } else {
                this.wordTwoDiacritized = input2.replaceAll("\u0625", "\u0627\u0621").replaceAll("\u0623", "\u0627\u0621").replaceAll("\u0671", "\u0627").trim();
            }
        }
        this.wordTwoLength = input2.length();
        this.wordTwoUndiacritized = undiacritize(this.wordTwoDiacritized);
        this.wordTwoCharArray = wordTwoUndiacritized.toCharArray();
        this.wordTwoDiacritics = createDiacriticsArray(this.wordTwoDiacritized, this.wordTwoCharArray);

        hashMap = new DiacriticHashMap().getHashMap();
        setHamzaFlags();
        setShaddaFlags();
        readDistanceTable();
        preprocessHamzaShadda();
    }

    private void preprocessHamzaShadda(){
        preprocessHamza(wordOneDiacritics);
        preprocessHamza(wordTwoDiacritics);
        preprocessShadda(wordOneDiacritics);
        preprocessShadda(wordTwoDiacritics);
    }

    private void preprocessHamza(char[][] word){
        for(int i = 1; i < word.length; i++){
                for(int j = 0; j < word[i].length; j++){
                        if(word[i][j] == '>'){
                                word[i][j] = 'u';
                        } else if(word[i][j] == '<'){
                                word[i][j] = 'd';
                        }
                }
        }
    }


    private void preprocessShadda(char[][] word){ 
        if(hasDiacritics(wordOneDiacritized) && hasDiacritics(wordTwoDiacritized)){
                for(int i = 1; i < word.length; i++){
                        for(int j = 0; j < word[i].length; j++){
                                if(word[i][j] == 'ّ'){
                                        word[i][j] = 's';
                                }
                        }
                }
        }
    }

    private boolean hasDiacritics(String word){
        for(char c: diacritics){
                if(word.contains(String.copyValueOf(new char[]{c}))){
                        return true;
                }
        }
        return false;
    }


    private String undiacritize(String word){
        String input = word;
        input = input.replaceAll("\u064E", "");
        input = input.replaceAll("\u064F", "");
        input = input.replaceAll("\u0650", "");
        input = input.replaceAll("\u0652", "");
        input = input.replaceAll("\u064B", "");
        input = input.replaceAll("\u064C", "");
        input = input.replaceAll("\u064D", "");
        input = input.replaceAll(">", "");
        input = input.replaceAll("<", "");
        input = input.replaceAll("\u0651", "");

        return input;
    }


    private boolean isLetter(char character){

        for(char c : letters){
                if (character == c){
                        return true;
                }
        }

        return false;
    }

    private boolean isDiacritic(char character){

        for(char c : diacritics){
                if (character == c){
                        return true;
                }
        }

        return false;
    }


    public char[][] createDiacriticsArray(String wordWhole, char[] wordUndiacritized){
        char[] word = wordWhole.toCharArray();
        char[][] diacriticsArray = new char[wordUndiacritized.length][DIACRITICS_AMOUNT];
        int wholeWordArrayPointer = 0 , letterWordArrayPointer = 0;
        int letterDiacritic = 0;



        while(wholeWordArrayPointer < word.length && letterWordArrayPointer < wordUndiacritized.length){
            if(wordUndiacritized[letterWordArrayPointer] == word[wholeWordArrayPointer]){
                    letterDiacritic = 0;
                    while(wholeWordArrayPointer < word.length -1 && isDiacritic(word[++wholeWordArrayPointer]) && letterDiacritic < 2){
                            diacriticsArray[letterWordArrayPointer][letterDiacritic] = word[wholeWordArrayPointer];
                            letterDiacritic++;
                    }
            }
            letterWordArrayPointer++;
        }


        return diacriticsArray;
    }


    private void readDistanceTable(){

        try {
            File distanceFile = new File(this.DISTANCE_FILE);
            Scanner distanceScanner = new Scanner(distanceFile);
            String line = distanceScanner.nextLine();
            //System.out.println(line);
            while (line.charAt(0) == '#'){
                    line = distanceScanner.nextLine();
            }
            //System.out.print(line);
            int tableSize = Integer.parseInt(line);
            this.distanceTable = new int[tableSize][tableSize];

            for(int i=0; i< tableSize; i++){
                    for(int j=0; j< tableSize; j++){
                            this.distanceTable[i][j] = distanceScanner.nextInt();
                            //System.out.print(this.distanceTable[i][j] + " ");
                    }
                    //System.out.println("");
            }
            distanceScanner.close();
        } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
            System.out.println("Working Directory = " +
                  System.getProperty("user.dir"));
        }

    }


    public int getWordOneLength() {
            return wordOneLength;
    }


    public int getWordTwoLength() {
            return wordTwoLength;
    }


    public String getWordOneDiacritized() {
            return wordOneDiacritized;
    }


    public String getWordOneUndiacritized() {
            return wordOneUndiacritized;
    }


    public String getWordTwoDiacritized() {
            return wordTwoDiacritized;
    }


    public String getWordTwoUndiacritized() {
            return wordTwoUndiacritized;
    }


    public char[] getWordOneCharArray() {
            return wordOneCharArray;
    }


    public char[] getWordTwoCharArray() {
            return wordTwoCharArray;
    }


    public char[] getLetters() {
            return letters;
    }


    public char[] getDiacritics() {
            return diacritics;
    }


    public char[][] getWordOneDiacritics() {
            return wordOneDiacritics;
    }


    public char[][] getWordTwoDiacritics() {
            return wordTwoDiacritics;
    }

    public String getWordOneOrig() {
        return wordOneOrig;
    }

    public String getWordTwoOrig() {
        return wordTwoOrig;
    }

    private boolean equalArrays(char[] one, char[] two){

            if(one.length != two.length){
                    return false;
            } else {
                    for(int i=0; i < one.length; i++){
                            if(one[i] != two[i]){
                                    return false;
                            }
                    }
            }

            return true;
    }

    public int[][] getDistanceTable() {
            return distanceTable;
    }

    private boolean isArabic(char[] word){

            for(int i=0; i<word.length; i++){
                    if(!isLetter(word[i]) && !isDiacritic(word[i])){
                            return false;
                    }
            }

            return true;
    }

    public int[] getSimilarityResults() {
            return similarityResults;
    }

    private boolean allOnes(int[] a){
            int length = a.length;
            if (!lastShadda)
                    length--;
            for (int i = 0; i < length; i++){
                    if(a[i] != 1  && a[i] != 3)
                            return false;
            }
            return true;
    }

    private boolean allTwos(int[] a){
            int length = a.length;
            if (!lastShadda)
                    length--;
            for (int i = 0; i < length; i++){
                    if(a[i] != 2 && a[i] != 3)
                            return false;
            }
            return true;
    }

    private boolean allThrees(int[] a){
            int length = a.length;
            if (!lastShadda) 
                    length--;
            for (int i = 0; i < length; i++){
                    if(a[i] != 3)
                            return false;
            }
            return true;
    }

    private boolean hasConflict(int[] a){
            int length = a.length;
            if (!lastShadda) 
                    length--;
            for (int i = 0; i < length; i++){
                    if(a[i] != 2 && a[i] != 3 && a[i]!= 1)
                            return true;
            }
            return false;
    }




    public String getImplicationDistance(){
            implication = checkImplication();
            int distance = -1;
            String result = "";
            if(getImplication() == 0 || getImplication() == -1 || getImplication() == 101){
                    result += "Not Found\t";
                    if(getImplication() == -1 || getImplication() == 101){
                            distance = 101;
                            result += "Sure\t";
                    } else {
                            distance = checkDistance(0);
                            if(hasConflict(similarityResults)){
                                    result += "Sure\t";
                            } else {
                                    result += "Maybe\t";
                            }
                    }
            } else if(getImplication() <= 3){
                    distance = checkDistance(0);
                    result += "Correct\t";
                    if(distance < SURE_THRESH){
                            result += "Sure\t";
                    } else if (distance < MAYBE_THRESH){
                            result += "Maybe\t";
                    } else {
                            result = "Unknown\tMaybe\t";
                    }
            } 
            return result + getImplication() + "\t" + distance + "\t" + conflictCount;
    }




    private void setHamzaFlags(){
            boolean hamzaOne = false, hamzaTwo = false;
            if(wordOneDiacritics.length > 0){
                    if(wordOneDiacritics[0][0] == '>' || wordOneDiacritics[0][1] == '>' || wordOneDiacritics[0][0] == '<' || wordOneDiacritics[0][1] == '<'){
                            hamzaOne = true;
                    }
                    if(wordTwoDiacritics[0][0] == '>' || wordTwoDiacritics[0][1] == '>' || wordTwoDiacritics[0][0] == '<' || wordTwoDiacritics[0][1] == '<'){
                            hamzaTwo = true;
                    }

                    if(hamzaOne != hamzaTwo){
                            this.hamzaDiff = true;
                    }
            }
    }

    private void setShaddaFlags(){
            boolean shaddaOne = false, shaddaTwo = false;
            if(wordOneDiacritics.length > 0){
                    if(wordOneDiacritics[wordOneDiacritics.length -1][0] == '\u0651'
                                    || wordOneDiacritics[wordOneDiacritics.length -1][1] == '\u0651' 
                                    || wordOneDiacritics[wordOneDiacritics.length -1][0] == '\u0651' 
                                    || wordOneDiacritics[wordOneDiacritics.length -1][1] == '\u0651'){
                            wordOneDiacritics[wordOneDiacritics.length -1][1] = '\u0000';
                            wordOneDiacritics[wordOneDiacritics.length -1][0] = '\u0651';

                            if(wordTwoDiacritics[wordTwoDiacritics.length -1][1] != '\u0651'
                                    && wordTwoDiacritics[wordTwoDiacritics.length -1][0] != '\u0651'){
                                    wordTwoDiacritics[wordTwoDiacritics.length -1][1] = '\u0000';
                                    wordTwoDiacritics[wordTwoDiacritics.length -1][0] = '\u0000';
                            }

                            shaddaOne = true;
                    }
                    if(wordTwoDiacritics[wordTwoDiacritics.length -1][0] == '\u0651'
                                    || wordTwoDiacritics[wordTwoDiacritics.length -1][1] == '\u0651'
                                    || wordTwoDiacritics[wordTwoDiacritics.length -1][0] == '\u0651'
                                    || wordTwoDiacritics[wordTwoDiacritics.length -1][1] == '\u0651'){
                            wordTwoDiacritics[wordTwoDiacritics.length -1][1] = '\u0000';
                            wordTwoDiacritics[wordTwoDiacritics.length -1][0] = '\u0651';

                            if(wordOneDiacritics[wordOneDiacritics.length -1][1] != '\u0651'
                                            && wordOneDiacritics[wordOneDiacritics.length -1][0] != '\u0651'){
                                            wordOneDiacritics[wordOneDiacritics.length -1][1] = '\u0000';
                                            wordOneDiacritics[wordOneDiacritics.length -1][0] = '\u0000';
                                    }

                            shaddaTwo = true;
                    }

                    if(shaddaOne || shaddaTwo){
                            this.lastShadda = true;
                    }
                    if(shaddaOne && shaddaTwo){
                            this.lastShadda = false;
                    }
            }
    }



    private int checkImplication(){
        System.out.println(wordOneDiacritized.toCharArray());
        System.out.println(wordTwoDiacritized.toCharArray());
            if(!isArabic(wordOneDiacritized.toCharArray()) || !isArabic(wordTwoDiacritized.toCharArray())){
                    return 101;
            } else if(! equalArrays(this.wordOneCharArray, this.wordTwoCharArray)){
                    return -1;
            } else {

                    this.similarityResults = new int[wordOneDiacritics.length];

                    for(int i = 0; i < similarityResults.length; i++){
                            int[] dScore = new int[2];
                            dScore[0] = 0;
                            dScore[1] = 0;
                            for(int j=0; j< wordOneDiacritics[0].length; j++){

                                    ///FLIP MATCHES IN DIFF PLACES
                                    if((wordOneDiacritics[i][j] != '\u0000' && (wordOneDiacritics[i][j] == wordTwoDiacritics[i][(j+1)%2])) 
                                                    || (wordTwoDiacritics[i][j] != '\u0000' && (wordTwoDiacritics[i][j] == wordOneDiacritics[i][(j+1)%2]))){
                                            char temp = wordOneDiacritics[i][0];
                                            wordOneDiacritics[i][0] = wordOneDiacritics[i][1];
                                            wordOneDiacritics[i][1] = temp;
                                    }
                                    if((wordOneDiacritics[i][j] == wordTwoDiacritics[i][j]) ||
                                                    (wordOneDiacritics[i][j] != '\u0000' && (wordOneDiacritics[i][j] == wordTwoDiacritics[i][(j+1)%2]))){
                                            dScore[j] = 3;
                                    } else if((wordOneDiacritics[i][j] != '\u0000') && wordTwoDiacritics[i][j] == '\u0000'){
                                            dScore[j] = 2;
                                    } else if(wordOneDiacritics[i][j] == '\u0000' && (wordTwoDiacritics[i][j] != '\u0000')){
                                            dScore[j] = 1;
                                    } else {
                                        if(i!=similarityResults.length-1)
                                            conflictCount++;
                                        dScore[j] = 0;
                                    }
                            }

                            System.out.println("Diac Score: " + Arrays.toString(dScore));
                            if(dScore[0] == dScore[1]){
                                    similarityResults[i] = dScore[0];
                            } else if(dScore[0] == 3){
                                    similarityResults[i] = dScore[1];
                            } else if(dScore[1] == 3){
                                    similarityResults[i] = dScore[0];
                            } else {
                                    similarityResults[i] = 0;
                            }

                            System.out.println(Arrays.toString(similarityResults));
                    }
                    System.out.println(Arrays.toString(Arrays.copyOf(similarityResults, similarityResults.length-1)));
                    if(allThrees(similarityResults)){
                            return 3;
                    } else if(allTwos(similarityResults)){
                            return 2;
                    } else if(allOnes(similarityResults)){
                            return 1;
                    } else {
                            return 0;
                    }	
            }
    }


    /**
     * Basic assumption of the checkDistance() method:
     * words are same length and have same letters
     * @return
     */
    private int checkDistance(int iS){
            char[][] wordOne, wordTwo;
            wordOne = this.wordOneDiacritics;
            wordTwo = this.wordTwoDiacritics;


            for(int i=iS; i<wordOne.length; i++){
                    for(int j=0; j<2; j++){
                            if(wordOne[i][j] == '\u0000')
                                    wordOne[i][j] = '.';
                    }
            }

            for(int i=iS; i<wordTwo.length; i++){
                    for(int j=0; j<2; j++){
                            if(wordTwo[i][j] == '\u0000')
                                    wordTwo[i][j] = '.';
                    }
            }

            int distance = 0;

            if(wordOne.length != wordTwo.length){
                    return distance+101;
            }


            int length = wordOne.length;
            if (!lastShadda) 
                    length--;
            System.out.println(length + " is length");

            for(int i = iS; i < length; i++ ){
                    if(wordOne[i][0] == wordTwo[i][0]){
                            distance += hashMap.get(String.copyValueOf(new char[]{wordOne[i][1],wordTwo[i][1]}));
                            if(i>0 && (wordOne[i][1] == '>' || wordTwo[i][1] == '<' || wordOne[i][1] == '<' || wordTwo[i][1] == '>')){
                                    distance += hashMap.get(String.copyValueOf(new char[]{wordOne[i][1],wordTwo[i][1]}));
                            }
                    } else if (wordOne[i][1] == wordTwo[i][1]){
                            distance += hashMap.get(String.copyValueOf(new char[]{wordOne[i][0], wordTwo[i][0]}));

                            if(i>0 && (wordOne[i][0] == '>' || wordTwo[i][0] == '<' || wordOne[i][0] == '<' || wordTwo[i][0] == '>')){
                                    distance += hashMap.get(String.copyValueOf(new char[]{wordOne[i][0],wordTwo[i][0]}));
                            }

                    } else if(wordOne[i][0] == wordTwo[i][1]){
                            distance += hashMap.get(String.copyValueOf(new char[]{wordOne[i][1],wordTwo[i][0]}));

                            if(i>0 && (wordOne[i][1] == '>' || wordTwo[i][0] == '<' || wordOne[i][1] == '<' || wordTwo[i][0] == '>')){
                                    distance += hashMap.get(String.copyValueOf(new char[]{wordOne[i][1],wordTwo[i][0]}));
                            }

                    } else if(wordOne[i][1] == wordTwo[i][0]){
                            distance += hashMap.get(String.copyValueOf(new char[]{wordOne[i][0],wordTwo[i][1]}));

                            if(i>0 && (wordOne[i][0] == '>' || wordTwo[i][1] == '<' || wordOne[i][0] == '<' || wordTwo[i][1] == '>')){
                                    distance += hashMap.get(String.copyValueOf(new char[]{wordOne[i][0],wordTwo[i][1]}));
                            }
                    }
                    else {
                            distance += hashMap.get(String.copyValueOf(new char[]{wordOne[i][0],wordTwo[i][0]}));
                            if(i>0 && (wordOne[i][0] == '>' || wordTwo[i][0] == '<' || wordOne[i][0] == '<' || wordTwo[i][0] == '>')){
                                    distance += hashMap.get(String.copyValueOf(new char[]{wordOne[i][0],wordTwo[i][0]}));
                            }

                            distance += hashMap.get(String.copyValueOf(new char[]{wordOne[i][1],wordTwo[i][1]}));
                            if(i>0 && (wordOne[i][1] == '>' || wordTwo[i][1] == '<' || wordOne[i][1] == '<' || wordTwo[i][1] == '>')){
                                    distance += hashMap.get(String.copyValueOf(new char[]{wordOne[i][1],wordTwo[i][1]}));
                            }
                    }
            }

            if (hamzaDiff){
                    System.out.println("Hamza at beg");
                    distance -= 2;
            }

            return distance;
    }


    @Override
    public String toString(){
            return  "Word One: \n" + this.wordOneDiacritized + "\t" + this.getWordOneUndiacritized() + "\n" +
                            Arrays.toString(this.wordOneCharArray) + "\n" +
                            Arrays.deepToString(this.wordOneDiacritics) + "\n\n" +
                            "Word Two: \n" + this.wordTwoDiacritized + "\t" + this.wordTwoUndiacritized + "\n" +
                            Arrays.toString(this.wordTwoCharArray) + "\n" +
                            Arrays.deepToString(this.wordTwoDiacritics) + "\n";
    }

    /**
     * @return the implication
     */
    public int getImplication() {
        return implication;
    }
	
}