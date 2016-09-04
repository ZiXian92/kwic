package CS3213;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

/**
 * Created by Zi Xian on 04/09/2016.
 *
 * Defines the component to remove indexes without the required keywords from the input set.
 */
public class RequiredWords {
    private TreeSet<String> reqWords;   // Guaranteed reasonably fast(logarithmic time) lookup, compared to hash set, which can perform badly with high collision

    /**
     * Creates a new instance of RequiredWords filter.
     */
    public RequiredWords(){
        // This project doesn't seem to use JDK 1.8 so lambda expressions not supported :(
        this.reqWords = new TreeSet<String>();
    }

    /**
     * Creates a new instance of RequiredWords filter with a prepared set of required words.
     * @param words
     */
    public RequiredWords(String[] words){
        this();
        for(String word: words){ this.addWord(word); }
    }

    /**
     * Adds the given word to the list of required words.
     * @param word
     */
    public void addWord(String word){
        this.reqWords.add(word.toLowerCase());
    }

    /**
     * Filters out given lines based on its keyword.
     * A line passes if keyword matches any of its filter words or if there is no filter word.
     * @param lines The lines to be filtered
     * @return Array of strings that pass this filter requirements
     */
    public String[] filter(String[] lines){
        List<String> filteredLines = new ArrayList<String>();

        // Check for corner case
        // No required words = no filter
        if(reqWords.size()<1) return lines;

        for(String line: lines) {
            String[] words= line.split("\\s+", 2);
            if (reqWords.contains(words[0].toLowerCase()))
                filteredLines.add(line);
        }
        return filteredLines.toArray(new String[filteredLines.size()]);
    }
}
