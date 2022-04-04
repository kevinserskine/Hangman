//Test
import java.util.*;

public class Hangman {

    static String word;

    static char guess;
    static char[] wrongLetters = new char[26];
    static char[] blankWord = {'_', '_', '_', '_', '_'};

    static String[] wordBank = {"roman", "focal", "burst", "sauce", "house", "other", "brake", "abyss", "toast", "shake"};

    static int correct = 0;
    static int wrong = 0;
    static int x = 1;

    static void getInput(){

        Scanner In = new Scanner(System.in);
        System.out.print("Enter a letter: ");
        guess = In.next().charAt(0);

        if (!(guess >= 'a' && guess <= 'z' )){
            System.out.println("Must be a letter! Try Again!");
            getInput();
        }

        for (int i = 0; i < 5; i++) {
            if (guess == wrongLetters[i] || guess == blankWord[i]){
                System.out.println("This letter has been guessed! Try Again!");
                getInput();
            }
        }

    }
    static void setWord(){

        Random r = new Random();
        int rand = r.nextInt(10);

        word = wordBank[rand];

    }

    static void compare(){

        int t = 5;

        for (int i = 0;i < 5;i++) {
            if (guess == word.charAt(i)) {
                blankWord[i] = word.charAt(i);
                correct++;
            }else {
                t--;
            }
            if (t == 0){
                wrongLetters[wrong] = guess;
                wrong++;
            }
        }

    }

    static void printHang(){
        System.out.println("    _________");
        System.out.println("    |       |");
        System.out.println("    |       |");

        if (wrong == 1){
            System.out.print("    |");
            System.out.println("      ( )");

        } else if (wrong == 2){

            System.out.print("    |");
            System.out.println("      ( )");
            System.out.print("    |");
            System.out.println("       |");
            System.out.print("    |");
            System.out.println("       |");

        } else if (wrong == 3) {
            System.out.print("    |");
            System.out.println("      ( )");
            System.out.print("    |");
            System.out.println("     --|");
            System.out.print("    |");
            System.out.println("       |");

        }  else if (wrong == 4) {
            System.out.print("    |");
            System.out.println("      ( )");
            System.out.print("    |");
            System.out.println("     --|--");
            System.out.print("    |");
            System.out.println("       |");

        }  else if (wrong == 5) {
            System.out.print("    |");
            System.out.println("      ( )");
            System.out.print("    |");
            System.out.println("     --|--");
            System.out.print("    |");
            System.out.println("       |");
            System.out.print("    |");
            System.out.println("      /");

        }   else if (wrong == 6) {
            System.out.print("    |");
            System.out.println("      ( )");
            System.out.print("    |");
            System.out.println("     --|--");
            System.out.print("    |");
            System.out.println("       |");
            System.out.print("    |");
            System.out.println("      / \\");
        }

        System.out.print("    |");
        printWord();
        System.out.println("    |");
        System.out.print("    |");
        printMiss();
        System.out.println("------------");
    }

    static void printWord(){

        System.out.print("                 ");
        for (int i = 0; i < 5; i++){
            System.out.print(blankWord[i]);
            System.out.print(" ");
        }
        System.out.print("\n");
    }

    static int check(){

        int y = 0;
        if (correct > 4){
            y = 1;
            printHang();
            System.out.println("\nYou Win!");
        }

        if (wrong == 6){
            y = 1;
            printHang();
            System.out.println("\nYou Lose!");
            System.out.println("The correct word was " + word);
        }


        return y;
    }

    static void printMiss() {
        System.out.print("          Wrong Letters: ");

        for (int i = 0; i <= wrong; i++){
            System.out.print(wrongLetters[i]);
            System.out.print(" ");
        }
        System.out.println();
    }


    public static void main(String[] args){

       System.out.println("\n\nWelcome to Hangman!\n");
       setWord();

       while (x == 1) {
           if (check() == 1) {
               x = 0;
               System.exit(0);
           }
           printHang();
           getInput();
           compare();
       }





    }



}
