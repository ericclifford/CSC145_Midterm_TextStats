// Name: Eric Clifford and Ray Thibodeaux
// Class: CSC 145-2
// Problem: Midterm Project
// File Name: UserInput.java

public class UserInput {
    
    private String input;
    private String[] inputWords;
    private int totalWords = 0;
    private int charsInWords = 0;
    private final char[] CHAR_ARRAY = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
            'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
            'U', 'V', 'W', 'X', 'Y', 'Z', '1', '2', '3', '4', '5', '6',
            '7', '8', '9', '0'};
    
    //--------------------------------------
    // Counstructor for UserInput Object
    //--------------------------------------
    public UserInput(String input){
        this.input = input;
    }
    
    //-------------------------------------------------------------
    // Counts the total number of words in provided text.
    // Word is defined as a string that contains a letter 
    // and/or a number. If so, it is added to the total.
    // Excludes any series of special characters that does not
    // contain a letter or number.
    //-------------------------------------------------------------
    private void totalWords(){
        //-----------------------------------------------
        // Splits input text into an array of strings
        //-----------------------------------------------
        inputWords = input.split("\\s+");
        
        //----------------------------------------------------
        // Iterates through each string to check if word
        //----------------------------------------------------
        for(int wordIndex = 0; wordIndex < inputWords.length; wordIndex++){
            
            boolean isWord = false;
            String word = inputWords[wordIndex].toLowerCase();
            
            //-------------------------------------
            // Splits string into array of chars
            //-------------------------------------
            char[] currentWord = word.toCharArray();
            
            //----------------------------------------------------------------
            // Checks each character in word until number or letter appears
            // If none appear, it is not considered a word.
            //----------------------------------------------------------------
            for(int charIndex = 0; charIndex < currentWord.length; charIndex++){
                
                char current = currentWord[charIndex];
                
                if(Character.isLetter(current)){
                     isWord = true;
                     charIndex = currentWord.length;
                }
                
                else if(Character.isDigit(current)){
                     isWord = true;
                     charIndex = currentWord.length;
                }
            }
            
            //-----------------------------------------------------------------
            // If the current string is a word, adds one to the total
            // word count. Also adds the count of numbers and letters
            // in the string to the total character count, to be used for 
            // finding average word length. Excludes punctuation and special
            // characters from the total character count.
            //-----------------------------------------------------------------
            if (isWord){
                totalWords++;
                
                for(int charIndex = 0; charIndex < currentWord.length; charIndex++){
                    
                    char current = currentWord[charIndex];
                    
                    if(Character.isLetter(current)){
                        charsInWords++;
                }
                
                    else if(Character.isDigit(current)){
                        charsInWords++;
                    }
                }
            }
        }
    }
    
    //-----------------------------------------------------------------
    // Runs the totalWords method to set the total number of words
    // Returns the total number of Strings considered words as an int
    //-----------------------------------------------------------------
    public int getTotalWords(){
        totalWords();
        return totalWords;
    }
    
    //---------------------------------------------------------------------
    // Runs the totalWords method to set the total number of words
    // and the total number of characters in each String considered a word. 
    // Returns the average character count per word as a double
    //---------------------------------------------------------------------
    public double getAverage(){
        totalWords();
        double averageLength = (double)charsInWords / totalWords;
        return averageLength;
    }
    
    //--------------------------------------------------------------------------
    // Counts the number of instances for each variable. Also
    // contains the total number of each digit, and total special characters
    //--------------------------------------------------------------------------
    public String characterCount(){
        String list = "";
        int totalLength = input.length();
        String newInput = input.toUpperCase();
        boolean rowFull = false;
        int specialCount = 0;
        
        //----------------------------------------------------------------
        // Iterates through each letter and number in the CHAR_ARRAY.
        // For each character in array, iterates through provided string.
        // Keeps a total of how many times each character appears.
        // Adds to String list, 2 totals per row.
        //----------------------------------------------------------------
        for(int arrayIndex = 0; arrayIndex < CHAR_ARRAY.length; arrayIndex++){
            char current = CHAR_ARRAY[arrayIndex];
            int totalNumber = 0;
            
            for(int charIndex = 0; charIndex < totalLength; charIndex++){
                if(newInput.charAt(charIndex) == current){
                    totalNumber++;
                }
            }
            
            if(totalNumber > 0){
                if(rowFull){
                    list = list.concat(Character.toString(current) + ": "
                            + totalNumber + "\n");
                    rowFull = false;
                }
                else{
                    list = list.concat(Character.toString(current) + ": "
                            + totalNumber + "\t\t\t");
                    rowFull = true;
                } 
            }
        }
        
        //-----------------------------------------------------------
        // Iterates through provided text and totals the number
        // of special characters that appear.
        //-----------------------------------------------------------
        for (int index = 0; index < totalLength; index++){
            char current = newInput.charAt(index);
            if(!Character.isDigit(current)&& !Character.isLetter(current)
                    && !Character.isWhitespace(current)){
                
                specialCount++;
            }
        }
        //-----------------------------------------------
        // Adds special character count to String list
        //-----------------------------------------------
        if(specialCount > 0){
        list = list.concat("\nSpecial Characters: " + specialCount);
        }
        
        return list;
    }
}














