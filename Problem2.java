/*
 * Joshua Sheldon
 * Eastern Florida State College
 * Blue Track
 * Problem 2
 */

package net.lumadevelopment.comp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem2 {
	
	public static void main(String[] args) {
		boolean done = false;
		List<String> inputs = new ArrayList<String>();
		Scanner scan = new Scanner(System.in);
		
		while(!done) {
			System.out.print("Enter next word or quit: ");
			String line = scan.nextLine();
			
			if(line.equalsIgnoreCase("quit")) {
				if(inputs.size() == 0) {
					System.out.println("Must enter minimum of one word!");
				}else {
					done = true;
				}
			}else if(line.equalsIgnoreCase("")) {
				System.out.println("Word must have a minimum of one character!");
			}else {
				inputs.add(line);
				
				if(inputs.size() == 50) {
					System.out.println("Maximum amount of words reached! Automatically quitting.");
					done = true;
				}
			}
		}
		
		scan.close();
		
		String finalResult = "";
		int entries = inputs.size();
		
		if(entries == 1) {
			finalResult = inputs.get(0);
		}else if(entries == 2) {
			finalResult = inputs.get(0) + " and " + inputs.get(1); 
		}else {
			for(int i = 0; i < entries; i++) {
				if(i == (entries - 2)) {
					finalResult += inputs.get(i) + " and ";
				}else if(i == (entries - 1)) {
					finalResult += inputs.get(i);
				}else {
					finalResult += inputs.get(i) + ", ";
				}
			}
		}
		
		System.out.println("Final Result");
		System.out.println(finalResult);
	}

}
