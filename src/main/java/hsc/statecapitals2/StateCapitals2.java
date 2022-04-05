package hsc.statecapitals2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

// This program will read in a txt file and create a hashmap. Then it will select a random state and quiz the user for the capital, take an input, and output if that was the correct answer. 

public class StateCapitals2 {

    public static void main(String[] args) throws FileNotFoundException {
        
        Map<String, String> stateCapitals = new HashMap<>();
        
        Scanner sc = new Scanner(new BufferedReader(new FileReader("StateCapitals.txt")));
        
        // go through the file line by line
        while (sc.hasNextLine()) {
            String currentLine = sc.nextLine();
            String[] currentLineSplit = currentLine.split("::");
            
            stateCapitals.put(currentLineSplit[0], currentLineSplit[1]);
        }
        
        // Print out a few things
        System.out.println(stateCapitals.size() + " STATES & CAPITALS ARE LOADED.");
        System.out.println("=======");
        System.out.println("HERE ARE THE STATES :");
        
        // Print each state, with commas. Counter counts up until the last state, so the nested loop doesn't include the comma on the last state printed.
        Set<String> keys = stateCapitals.keySet();
        int counter = 0;
        
        for(String k : keys) {
            if ( counter == (keys.size()-1) ) {
                System.out.print(k);
                counter++;
                break;
            }
            System.out.print(k + ", ");
            counter++; 
        }
        
        
        // Create ArrayList so a generate random integer can index a state. Then output that state as part of the trivia question.
        List<String> keysAsArray = new ArrayList<>(keys);
        
        Random randomState = new Random();
        int triviaState = randomState.nextInt(keysAsArray.size());
        
        System.out.println("\n\nREADY TO TEST YOUR KNOWLEDGE? WHAT IS THE CAPITAL OF '" + keysAsArray.get(triviaState) + "'?"); //TODO: get value from a set?
        
        Scanner inputReader = new Scanner(System.in);
        String userAnswer = inputReader.nextLine();
        
        // If the user's string matches the value associated with that key in the hashmap, say correct. If not, say incorrect.
        if (userAnswer.equals(stateCapitals.get(keysAsArray.get(triviaState)))) {
            System.out.println("NICE WORK! " + userAnswer + " IS CORRECT!");
            
        } else {
            System.out.println("SORRY, " + userAnswer + " IS INCORRECT!");
        }
    }
}
