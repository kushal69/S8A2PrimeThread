package com;

import java.util.Scanner;
//	Main Class
public class PrimeNumberThread extends Thread {									//	Extending Thread Class
	int mid, inputNumber, check;

	PrimeNumberThread (int inputNumber){										//	Constructor assigning input number to class variable to process
		this.inputNumber = inputNumber;
	}
	
	public void run() {															//	run method where thread creates a process of it
		try {
			mid = inputNumber / 2;												//	Getting the mid value of the user entered number
			for (int i = 2; i <= mid; i++) {									//	Loop iterating until the mid value to check entered number divisors
				if (inputNumber % i == 0) {										//	If found any divisor the entered number is not a prime number
					System.out.println("Entered Number is NOT PRIME");
					check = 1;
					break;
				}
			}
			if (check == 0)
				System.out.println("Entered Number is PRIME");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	//	Main method
	public static void main(String [] args){
		
		Scanner userInput = new Scanner(System.in);								//	Scanner to get the user input
		
		System.out.println("Enter a number to check it's PRIME or Not PRIME : ");
		
		Thread primeThread = new PrimeNumberThread(userInput.nextInt());		//	Creating the Thread object of the Main class
		
		primeThread.start();													//	Starting the thread
		
		userInput.close();														//	Closing the scanner
	}
}
