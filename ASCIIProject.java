import java.util.*;
public class ASCIIProject
{

    static String[][]s={
        {" XXX  XXXX   XXXX XXXX  XXXXX XXXXX XXXX  X   X XXXXX XXXXX X   X X     X   X X   X  XXX  XXXXX  XXX  XXXX  XXXXX XXXXX X   X X   X X   X X   X X   X XXXXX"},
        {"X   X X   X X     X   X X     X     X     X   X   X     X   X  X  X     XX XX XX  X X   X X   X X   X X   X X       X   X   X X   X X   X  X X   X X     X "},
        {"XXXXX XXXX  X     X   X XXXX  XXXX  X  XX XXXXX   X     X   X X   X     X X X X X X X   X XXXXX X   X XXX   XXXXX   X   X   X X   X X X X   X     X     X  "},
        {"X   X X   X X     X   X X     X     X   X X   X   X   X X   X  X  X     X   X X  XX X   X X     X  XX X  X      X   X   X   X  X X  XX XX  X X    X    X   "},
        {"X   X XXXX   XXXX XXXX  XXXXX X     XXXX  X   X XXXXX  XX   X   X XXXXX X   X X   X  XXX  X      XXXX X   X XXXXX   X   XXXXX   X   X   X X   X   X   XXXXX"},
    };

     static String num[][]={
            {" XX   XX   XX   XX     X XXXX XXXX XXXX  XX  XXXX "},
            {"X  X XXX  X  X X  X   XX X    X       X X  X X  X "},
            {"X  X  XX    X    X   X X XXXX XXXX   X   XX  XXXX "},
            {"X  X  XX   X   X  X XXXX    X X  X  X   X  X    X "},
            {" XX  XXXX XXXX  XX     X XXXX XXXX X     XX  XXXX "}
        };

        static String sym[][]={
            {"XX       X X     X  X     XX         X   XX      XXXX    XXXX "},
            {"XX       X X     X  X   XXXXXX  XX  X   X  X    XX   X  X    X"},
            {"XX              XXXXXX  X       XX X     XX         XX  X XX X"},
            {"XX               X  X   XXXXXX    X XX   XX X      XX   X X XX"},
            {"XX              XXXXXX       X   X  XX  X  X      XX    X XXXX"},
            {"                 X  X   XXXXXX  X        XX X           X     "},
            {"XX               X  X     XX                      XX     XXX  "}
        };

    public static void main(String[] args){
        showASCIIMenu();
    }

    static void showASCIIMenu(){
        Scanner sc = new Scanner(System.in);
        int choice;
        while (true){
            System.out.println("==================================");
            System.out.println("        ASCII PROJECT MENU ");
            System.out.println("==================================");
            System.out.println("1.Show All Alphabets");
            System.out.println("2.Show Single Letter");
            System.out.println("3.Show Word");
            System.out.println("4.Show Range of Letters");
            System.out.println("5.Show Numbers");
            System.out.println("6.Show Symbol");
            System.out.println("7.Exit");
             System.out.println("==================================");
            System.out.print("Enter your choice -- ");
            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch(choice){
                case 1:
                     System.out.println("==================================");
                    Alphabet();
                    break;
                case 2:
                     System.out.println("==================================");
                    System.out.print("Enter a single letter -- ");
                    String letter = sc.nextLine();
                    Letter(letter);
                    break;
                case 3:
                     System.out.println("==================================");
                    System.out.print("Enter a word(A-Z only) -- ");
                    String word = sc.nextLine();
                    Word(word);
                    break;
                case 4:
                     System.out.println("==================================");
                    System.out.print("Enter a range(e.g. H-R) -- ");
                    String range = sc.nextLine();
                    Range(range);
                    break;
                 case 5:
                     System.out.println("==================================");
                     System.out.print("Enter a Number-- ");
                    String number = sc.nextLine();
                     Number();
                    break;
                case 6:
                     System.out.println("==================================");
                     System.out.print("Enter a Symbol -- ");
                    String symbol= sc.nextLine();
                     Symbol(symbol);
                    break;
                 case 7:
                     System.out.println("==================================");
                     System.out.println("Thank you! Program ended.");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 7.");
            }
            System.out.print("\nDo you want to continue? (Press 1 for Yes, any other number to exit):");
            int repeat = sc.nextInt();
            if (repeat != 1){
                System.out.println("Thank you! Program ended.");
                break;
            }
        }
          sc.close();
    }

    static void Alphabet(){
        System.out.println("Alphabet ASCII --");
        for (int i = 0; i<s.length; i++) {
            for (int j = 0; j < s[i].length; j++){
                System.out.print(s[i][j]);
            }
            System.out.println();
        }
    }

    static void Letter(String s1){
        if (s1.length() != 1 || !Character.isLetter(s1.charAt(0))){
            System.out.println("Please enter a valid single letter.");
            return;
        }

        //System.out.println("\n Letter ASCII -- " + s1.toUpperCase());
        char c[];
        int cnt;
        int p = Character.toUpperCase(s1.charAt(0))-64;
        cnt = 6 *(p - 1);
        for (int i = 0; i < s.length; i++){
            c = s[i][0].toCharArray();
            for (int j = cnt; j < cnt + 6; j++){
                System.out.print(c[j]);
            }
            System.out.println();
        }
    }

    static void Word(String s1){
        if (!s1.matches("[a-zA-Z]+")){
            System.out.println("Please enter alphabets only.");
            return;
        }

      //  System.out.println("Word ASCII -- " + s1.toUpperCase());
        char c[];
        int cnt;
        for (int i = 0; i < 5; i++){
            for (int k = 0; k < s1.length(); k++){
                int p = Character.toUpperCase(s1.charAt(k))-64;
                cnt = 6 * (p - 1);
                c = s[i][0].toCharArray();
                for (int j = cnt; j < cnt + 6; j++){
                    System.out.print(c[j]);
                }
                System.out.print(" "); // gap between letters
            }
            System.out.println();
        }
    }

    static void Range(String s1){
        if (s1.length() != 3 || s1.charAt(1) != '-'){
            System.out.println("Please enter range in correct format (e.g. H-R).");
            return;
        }

        char startChar = Character.toUpperCase(s1.charAt(0));
        char endChar = Character.toUpperCase(s1.charAt(2));

        if (startChar < 'A' || endChar > 'Z' || startChar > endChar){
            System.out.println("Invalid range! Please use A–Z only.");
            return;
        }

       // System.out.println("Range ASCII -- " + startChar + " to " + endChar);
        for (int i = 0; i < 5; i++){
            for (char currentChar = startChar; currentChar <= endChar; currentChar++){
                int p = currentChar - 64;
                int startCol = 6 * (p - 1);
                System.out.print(s[i][0].substring(startCol, startCol + 5));
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    
    public static void Number(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your number: ");
        String s1 = input.next();
        System.out.println();
        char c[];
        int i, j , cnt, p, k;
        for (i = 0; i < 5; i++){
            for(k = 0; k < s1.length(); k++){
                p = s1.charAt(k) - 47;
                cnt = 5 * (p - 1);
                c = String.valueOf(num[i][0]).toCharArray();
                for (j = cnt; j < cnt + 5; j++){
                    System.out.print(c[j]);
                }
            }
            System.out.println();
        }
    }
   
     static void Symbol(String s1){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your symbol: ");
        char c1 = input.next().charAt(0);
        System.out.println();
        char c[];
        int p = 0;
        switch (c1) {
            case '!':        
                p = 1;
                break;        
            case '"':
                p = 2;
                break;
            case '#':
                p = 3;
                break;
            case '$':
                p = 4;
                break;
            case '%':
                p = 5;
                break;
            case '&':
                p = 6;
                break;
            case '?':
                p = 7;
                break;
            case '@':
                p = 8;
                break;
            default:
                System.out.println("Invalid range...");
                System.out.println("Try again...");
                
        }
        int cnt = 8 * (p - 1);
        for(int i = 0; i < 7; i++){
            c = String.valueOf(sym[i][0]).toCharArray();
            for(int j = cnt; j < cnt + 6; j++){
                System.out.print(c[j]);
            }
            System.out.println();
        }
    }
  }