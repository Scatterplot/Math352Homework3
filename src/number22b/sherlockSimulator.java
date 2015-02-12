package number22b;

/**
 * @author Nathan Bingham
 * @date 2/12/2015
 * @description A program to simulate guessing strategies for Sherlock/Holmes
 */

import java.util.Random;

public class sherlockSimulator
{
    public static final int TRUE_COUNTERFEIT_NUMBER = 30;
    public static final int DISCOVERED_COUNTERFEITS = 16;
    
    public static int[] ringMaker(int size)
    {
        Random random = new Random();
        int[] rings = new int[size];
        
        for (int i = 0; i < rings.length; i++)
        {
            boolean isUsed = true;
            int nextRing = 0;
            
            while (isUsed)
            {
                isUsed = false;
                nextRing = random.nextInt(TRUE_COUNTERFEIT_NUMBER);
                
                for (int j = 0; j < rings.length; j++)
                {
                    if (rings[j] == nextRing)
                    {
                        isUsed = true;
                        break;
                    }
                    else if (rings[j] == 0)
                    {
                        break;
                    }
                }
            }
            
            rings[i] = nextRing;
        }
        
        return rings;
    }
    
    public static int findMaximum(int[] set)
    {
        int maximum = set[0];
        
        for (int i = 1; i < set.length; i++)
        {
            if (set[i] > maximum)
            {
                maximum = set[i];
            }
        }
        
        return maximum;
    }
    
    public static void main(String[] args)
    {
        int sherlockGuesses = 0;
        int holmesGuesses = 0;
        int formulaGuesses = 0;
        
        for (int i = 0; i < 100; i++)
        {
            int[] ringSet = ringMaker(DISCOVERED_COUNTERFEITS);

            int largestNumber = findMaximum(ringSet);

            sherlockGuesses += largestNumber*2;
            holmesGuesses += largestNumber;
            formulaGuesses += largestNumber + (largestNumber/DISCOVERED_COUNTERFEITS) - 1;
        }
        
        sherlockGuesses /= 100;
        holmesGuesses /= 100;
        formulaGuesses /= 100;
        
        System.out.println("Holmes Average Guess: "+holmesGuesses);
        System.out.println("Sherlock Average Guess: "+sherlockGuesses);
        System.out.println("Formula Average Guess: "+formulaGuesses);
        System.out.println("Actual: "+TRUE_COUNTERFEIT_NUMBER);
        System.out.println();
        System.out.printf("Holmes ratio: %4f to 1\n",(double)holmesGuesses/TRUE_COUNTERFEIT_NUMBER);
        System.out.printf("Sherlock ratio: %4f to 1\n",(double)sherlockGuesses/TRUE_COUNTERFEIT_NUMBER);
        System.out.printf("Formula ratio: %4f to 1\n",(double)formulaGuesses/TRUE_COUNTERFEIT_NUMBER);
    }
}
