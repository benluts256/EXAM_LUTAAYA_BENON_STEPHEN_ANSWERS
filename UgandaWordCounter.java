/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LUTS
 */
import java.util.Scanner;
public class UgandaWordCounter {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the book description:");
            String bookDescription = scanner.nextLine();
            
            String lowerCaseDescription = bookDescription.toLowerCase();
            
            String searchWord = "uganda";
            
            int count = 0;
            int lastIndex = 0; 
            
            
            while (lastIndex != -1) {
                lastIndex = lowerCaseDescription.indexOf(searchWord, lastIndex);
                
                if (lastIndex != -1) {
                    
                    boolean isStartBoundary = (lastIndex == 0) ||
                            (!Character.isLetter(lowerCaseDescription.charAt(lastIndex - 1)));
                    
                   
                    boolean isEndBoundary = (lastIndex + searchWord.length() == lowerCaseDescription.length()) ||
                            (!Character.isLetter(lowerCaseDescription.charAt(lastIndex + searchWord.length())));
                    
                    if (isStartBoundary && isEndBoundary) {
                        count++;
                    }
                    lastIndex += searchWord.length(); 
                }
            }
            
            System.out.println("\n--- Search Result ---");
            System.out.println("The word 'Uganda' (case-insensitive) appears " + count + " time(s) in the description.");
            
        }
    }
}
