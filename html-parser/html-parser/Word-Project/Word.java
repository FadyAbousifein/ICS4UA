public class Word {
    
    private String word; 
    private String firstLetter; 
    private String lastLetter; 

    // String parameter constructor (sets word instance variable equal to String argument passed in)
    public Word(String word) {
        this.word = word; 
    }

    // word instance variable getter method
    public String getWord() {
        return word; 
    }

    // returns first letter of the word object
    public String getFirstLetter() {
        firstLetter = Character.toString(word.charAt(0));
        return firstLetter; 
    }

    // returns last letter of the word object 
    public String getLastLetter() {
        lastLetter = Character.toString(word.charAt(word.length() - 1));
        return lastLetter; 
    }

    // removes the first letter from your word object
    public void removeFirstLetter(String word) {
        this.word = word.substring(1); 
    }

    // removes the last letter from your word object
    public void removeLastLetter(String word) {
        this.word = word.substring(0, word.length() - 1); 
    }

    // loops through word looking for the index of the letter the user wants to find
    // returns the index of the letter if found or -1 if letter is not found
    public int findLetter(String stringToFind, String word) {
        for(int i = 0; i < word.length(); i++) {
            if(Character.toString(word.charAt(i)).equals(stringToFind)) {
                return i; 
            }
        }
        return -1; 
    }

}
