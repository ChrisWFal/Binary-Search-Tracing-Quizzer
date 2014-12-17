import java.util.*;
import java.io.*;

public class Quizzer
	{
	public static boolean go = true;
	public static int number;
	static ArrayList myArray = new ArrayList();
	static int target;
	static int answer;
	static int questionCount = 0;
	static int correctCount = 0;
	static String keepPlaying;

	public static void main(String[] args)
		{
		inputNumber();

		}
	

	public static void inputNumber()
		{
		do
			{
			System.out.println("Please input any amount of numbers between 1 and 20 and type -1 when you are finished.");
			
			Scanner userInput = new Scanner (System.in);
			number = userInput.nextInt();
			
			if (number == -1)
				{
				Collections.sort(myArray);
				
				for(int i = 0; i < myArray.size(); i ++)
					{
					System.out.println(myArray.get(i));
					}
	
				go = false;
				chooseTarget();
				}
			else if(number < 1 || number > 20)
				{
				System.out.println("Please enter a valid number");
				inputNumber();
				}
			else
				{
				myArray.add(number);
				
				}
			
			}
		while (go == true);
	
		}
	public static void chooseTarget()
	{
	int randomNumber = (int) (Math.random()*myArray.size()-1);
	target = (int) myArray.get(randomNumber);
	
	System.out.println("The target is " + myArray.get(randomNumber));
	
	trace();
	}
	
	public static void trace()
		{
		int left = 0;
		int right = myArray.size() - 1;
		
		while(left <= right)
			{
			int middle = (left + right)/2;
			
			System.out.println("What is left?");
			
			Scanner userInput1 = new Scanner (System.in);
			answer = userInput1.nextInt();
			
			if(answer == left)
				{
				questionCount ++;
				correctCount ++;
				}
			else
				{
				questionCount ++;
				}
			System.out.println("What is right?");
			answer = userInput1.nextInt();
			if(answer == right)
				{
				questionCount++;
				correctCount++;
				}
			else
				{
				questionCount++;
				}
			System.out.println("What is the middle?");
			answer = userInput1.nextInt();
			if(answer == middle)
				{
				questionCount++;
				correctCount++;
				}
			else
				{
				questionCount++;
				}
			System.out.println("What is myArray[middle]?");
			answer = userInput1.nextInt();
			if(answer == target)
				{
				System.out.println("Congrats! You're correct!");
				System.out.println("You got " + correctCount + " out of the " + questionCount + "questions correct.");
				System.out.println("Would you like to continue? Yes or no");
				keepPlaying = userInput1.nextLine();
				if(keepPlaying .equals("yes"))
					{
					inputNumber();
					}
				else
					{
					System.exit(0);
					}
				}
//			else
//				{
//				System.out.println("Sorry you didnt get the answer right... do you want to keep playing? Yes or no");
//				keepPlaying = userInput1.nextLine();
//				if(keepPlaying .equals("yes"))
//					{
//					inputNumber();
//					}
//				else
//					{
//					System.exit(0);
//					}
//				}
			
			
			if(target < (int)myArray.get(middle))
				{
				right = middle - 1;
				}	
			
			else if(target > (int)myArray.get(middle))
				{
				left = middle + 1;
				}
			}
		}

	}
