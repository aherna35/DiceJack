import java.util.Scanner;/**
 * DiceJack
 * Create a game using dice, decided to add a nice visualization of the dice for the user.
 */
public class DiceJack {

     //each die has a top middle and bottom, printing them on top of eachother makes each die.
    static String sixTop = "|*   *|", sixMid = "|*   *|", sixBot = "|*   *|";
    static String fiveTop = "|*   *|", fiveMid = "|  *  |", fiveBot = "|*   *|";
    static String fourTop = "|*   *|", fourMid = "|     |", fourBot = "|*   *|";
    static String threeTop = "|    *|", threeMid = "|  *  |", threeBot = "|*    |";
    static String twoTop = "|     |", twoMid = "|*   *|", twoBot = "|     |";
    static String oneTop = "|     |", oneMid = "|  *  |", oneBot = "|     |";

    /**
     * @param num (int)
     * @return    (int)
     * 
     * In the function: 
     * 1. returns top of the dice based on number
     */
    public static String returnTop(int num) {
        switch (num) {
            case 1: return oneTop;
            case 2: return twoTop;
            case 3: return threeTop;
            case 4: return fourTop;
            case 5: return fiveTop;
            case 6: return sixTop;
            default: return "1";
        }
    }

    /**
     * @param num (int)
     * @return    (int)
     * 
     * In the function: 
     * 1. returns middle of the dice based on number
     */
    public static String returnMid(int num) {
        switch (num) {
            case 1: return oneMid;
            case 2: return twoMid;
            case 3: return threeMid;
            case 4: return fourMid;
            case 5: return fiveMid;
            case 6: return sixMid;
            default: return "2";
        }
    }

    /**
     * @param num (int)
     * @return    (int)
     * 
     * In the function: 
     * 1. returns bot of the dice based on number
     */
    public static String returnBot(int num) {
        switch (num) {
            case 1: return oneBot;
            case 2: return twoBot;
            case 3: return threeBot;
            case 4: return fourBot;
            case 5: return fiveBot;
            case 6: return sixBot;
            default: return "3";
        }
    }
     /**
      * 
      * @param die1 (int)
      * @param die2 (int)
      * @param die3 (int)
      * @return     (String)
      In the function: 
      1. determines string by adding top middle and bottom of 3 die 
      */
    public static String determineThreeDice(int die1, int die2, int die3) {
        return ( returnTop(die1) + "    " + returnTop(die2) + "    " + returnTop(die3) + "\n" +
                 returnMid(die1) + " -> " + returnMid(die2) + " -> " + returnMid(die3) + "\n" + 
                 returnBot(die1) + "    " + returnBot(die2) + "    " + returnBot(die3) + "\n") ;
    }

    /**
     * @return (int)
     * In the function:
     * 1. rolls a random number between 1-6
     */
    public static int rollDice(){
        return (int)( (Math.random() * 6) + 1); //adding 1 to make range of numbers 1-6 
    }

    
    /**
     * @param die1 (int)
     * @param die2 (int)
     * @param die3 (int)
     * @return     (boolean)
     * 
     * In this function:
     * 1. Returns true if die input was between 1 and 6 (inclusive).
     */
     public static boolean checkDieParameters(int die1, int die2, int die3){
        if (die1 < 1 || die2 < 1 || die3 <1) {
            return false;
        } 
        if (die1 > 6 || die2 > 6 || die3 > 6) {
            return false;
        }
        return true;
     }

     /**
      * @param die1 (int) 
      * @param die2 (int)
      * @param die3 (int)
      * @param sum  (int)
      * @param u    (char) 
      *In this function:
      *1. If the input is for the user, returns user string
      *2. If the input is for the game (rolled), returns rolled string
      */
     public static void printDiceRoll(int die1, int die2, int die3, int sum, char u) {
         if (u == 'u') {
            System.out.println("You chose " + die1 + " - " +  die2 + " - " +  die3 + " with the sum of " + sum + "\n");
            System.out.println(determineThreeDice(die1, die2, die3));
         }
         else {
            System.out.println("You rolled " + die1 + " - " +  die2 + " - " +  die3 + " with the sum of " + sum + "\n");
            System.out.print(determineThreeDice(die1, die2, die3));
         }
     }

     /**
      * 
      * @param userSum (int)
      * @param gameSum (int)
      * @return        (boolean)
      *In this function:
      *returns true if user won, false if they did not
      */
     public static boolean checkWin(int userSum, int gameSum) {
        if (userSum > gameSum && ( Math.abs( userSum - gameSum ) < 3)) {
            return true;
        }
        else{
            return false;
        }
     }
      /**
       * 
       * @param die1 (int)
       * @param die2 (int)
       * @param die3 (int)
       * @return
       * In the function: 
       * 1. Plays the game 100 times, checking 100 random dice rolls to the users dice choice
       */
     public static int playGame1000000Times(int die1, int die2, int die3) { 
         int winCounter = 0;
         int userSum = die1 + die2 + die3;

        for (int i = 0; i < 1000000; i++) {
            int gameDie1 = rollDice(), gameDie2 = rollDice(), gameDie3 = rollDice(); //instantiate die rolls
            int gameSum = gameDie1 + gameDie2 + gameDie3; //calculates input sum and roll sum
            if (checkWin(userSum, gameSum) == true) { //if user won (checking with function)
                winCounter++;//if user wins, adds to the counter to be returned
            }
        }

         return winCounter; //returns wins
     }

    /**
     * In this function:
     * 1. Allows the user to play a game. If the user's dice roll sum is smaller than the numbers they chose,
     * as well as the difference of sums being less than three they win. 
     * Calls functions in class to run the game
     */ 
    public static void game1() {
        Scanner scan = new Scanner(System.in);
        System.out.println("\nRules of the game: " +
                            "\n1. The dice you choose must have a larger sum than the dice you roll" + 
                            "\n2. The difference of the sums must be less than three" + 
                            "\n3. If both rules are satisfied, you win! Otherwise, you lose :c");
        System.out.println("\nEnter three numbers between 1 and 6");

        int die1 = scan.nextInt(), die2 = scan.nextInt(), die3 = scan.nextInt(); //record user input
        int gameDie1 = rollDice(), gameDie2 = rollDice(), gameDie3 = rollDice(); //instantiate die rolls
        
        if (checkDieParameters(die1,die2,die3) == false) { //checking whether or not user followed parameter instructions
            System.out.println("\nNumber entered must be within 1-6");
            System.exit(0);
        }

        int userSum = die1 + die2 + die3, gameSum = gameDie1 + gameDie2 + gameDie3; //calculates input sum and roll sum

        printDiceRoll(die1, die2, die3, userSum, 'u'); //prints information that was inputted
        printDiceRoll(gameDie1, gameDie2, gameDie3, gameSum, 'g'); //prints information that was rolled

        if (checkWin(userSum, gameSum) == true) { //if user won (checking with function)
            System.out.println("\nCongratulations, you won!");
        } 
        else System.out.println("\nYou lost. Nice try!"); //if they did not win, by default they lost

        int playedMany = playGame1000000Times(die1, die2, die3);
        System.out.println("\nIf you played 1,000,000 more times with the same numbers, you would have won " + 
                           playedMany + " times - (~" + (playedMany/10000.) + "%)" );//most fun part of the game for me

        System.out.println("Would you like to play again? If so, please type 'yes' to play again."); //prompting to play again
        String response = scan.next(); 

        if (response.equalsIgnoreCase("yes")) { //if they want to play again
            game1();
        }
        else System.exit(0);

        scan.close(); //close this bad boy because it's good practice
    }
    public static void main(String[] args) {
        game1(); //run the first game
    }
}