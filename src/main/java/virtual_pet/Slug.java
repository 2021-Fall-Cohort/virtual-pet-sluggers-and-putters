package virtual_pet;

import java.util.Scanner;

public class Slug {
    public String nickname;
    public int hunger;
    public int slime;
    public int happiness;
    Scanner inputScanner = new Scanner(System.in);
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public Slug(String nickname, int hunger, int slime, int happiness){
        this.nickname = nickname;
        this.hunger = 100;
        this.slime = 100;
        this.happiness = 100;
    }
    public void idlePic(){
        System.out.println("\n     O     o\n" +
                "    /|____/|\n" +
                "   (    @   )\n" +
                "    ( Y  Y )\n" +
                "     \\    /\n" +
                "      \\  / \n" +
                "       ()\n");
    }
    public void sadPic(){
        System.out.println("     O,    o, \n" +
                "    /|____/| ,\n" +
                "   (    ^   ) ,\n" +
                "    ( Y  Y ), , ,\n" +
                "     \\    /   ,\n" +
                "      \\  / \n" +
                "       ()\n");
    }

    public void starvePic(){
        System.out.println("     @     @ \n" +
                "    /|____/| \n" +
                "   (    W   )\n" +
                "    ( y  y )\n" +
                "      \\0/\n" +
                "      \\ / \n" +
                "       ()\n");
    }

    public void dryPic(){
        System.out.println("        o\n" +
                "       ooo\n" +
                "      ooooo\n" +
                "     ooooooo\n" +
                "      ooooo\n" +
                "\n" +
                "     @    @ \n" +
                "    /|___/| \n" +
                "   (   o   )\n" +
                "     (y  y) \n" +
                "    ~  \\/ ~\n" +
                "    ~  \\/ ~\n" +
                "       ()\n");
    }

    public void feedPic(){
        System.out.println("     ^      ^\n" +
                "    /|_____/|\n" +
                "   (   (3)   )\n" +
                "    ( Y  $Y )\n" +
                "     (  )  )\n" +
                "      (  )) \n" +
                "       ( ))\n" +
                "        ()\n");
    }

    public void reslimePic(){
        System.out.println("  ********************\n" +
                "   ******************\n" +
                "    ****************\n" +
                "     **************\n" +
                "     **  **   ***\n" +
                "         *     **\n" +
                "               *\n" +
                "         ^     ^  \n" +
                "        /|____/| \n" +
                "  **** (    3   ) ****\n" +
                "   ***  ( y  Y )  ***\n" +
                "     **  \\    /   **\n" +
                "      *   \\  /    *\n" +
                "           ()\n");
    }

    public void funPic(){
        System.out.println("              (Yay!!)\n" +
                "     ^     ^  /\n" +
                "    /|____/| /\n" +
                "   (    3   )\n" +
                "    ( Y  y )\n" +
                "     \\    /\n" +
                "      \\  / \n" +
                "       ()\n");
    }

    public void tick(){
        if (isAlive()) {
            hunger = (int) (hunger - Math.floor(Math.random() * 25));
            slime = (int) (slime - Math.floor(Math.random() * 25));
            happiness = (int) (happiness - Math.floor(Math.random() * 25));
            if (happiness <= hunger && happiness <= slime) {
                if (happiness >= 50){
                    idlePic();
                }
                else{
                    sadPic();
                }
                happiness = Math.min(100, happiness + 10);
                System.out.println(ANSI_GREEN + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("You pet noticed it was sad and played a little game. Happiness + 10");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" + ANSI_RESET);
            } else if (hunger <= slime && hunger <= happiness) {
                if (hunger >= 50){
                    idlePic();
                }
                else{
                    starvePic();
                }
                hunger = Math.min(100, hunger + 10);
                System.out.println(ANSI_GREEN + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
                        + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("Your pet noticed it was hungry and ate a leafy green"
                        + " (high in protein.) Hunger + 10 (That's good!)");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
                        + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" + ANSI_RESET);
            } else {
                if (slime >= 50){
                    idlePic();
                }
                else{
                    dryPic();
                }
                slime = Math.min(100, slime + 10);
                System.out.println(ANSI_GREEN + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
                        + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("Your pet noticed it was drying out and you help it replenish its slime. Weird. Slime + 10");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
                        + "~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" + ANSI_RESET);
            }
            hungerDisplay();
            slimeDisplay();
            happinessDisplay();
            System.out.println("\nType 1 to feed your slug, type 2 to replenish "
            + "slime, or type 3 to play with your slug.\n");

            int choice = inputScanner.nextInt();
            switch (choice) {
                case 1:
                    hunger = Math.min(100, hunger + 20);
                    feedPic();
                    System.out.println("\nYou feed you pet slug. It does it a little dance. :)\n");
                    break;
                case 2:
                    slime = Math.min(100, slime + 20);
                    reslimePic();
                    System.out.println("\nYou reslime your slug. What does that even mean?\n");
                    break;
                case 3:
                    happiness = Math.min(100, happiness + 20);
                    funPic();
                    System.out.println("\nYour slug discovered a new civilization.\n");
                    break;
            }
        }
    }
    public void hungerDisplay(){
        System.out.print(ANSI_PURPLE + "Hunger   :");
        for (int i = 0; i < hunger; i = i + 2){
            System.out.print(("|"));
        }
        System.out.println(ANSI_RESET);
    }

    public void happinessDisplay(){
        System.out.print(ANSI_BLUE + "Happiness:");
        for (int i = 0; i < happiness; i = i + 2){
            System.out.print(("|"));
        }
        System.out.println(ANSI_RESET);
    }

    public void slimeDisplay(){
        System.out.print(ANSI_CYAN + "Slime    :");
        for (int i = 0; i < slime; i = i + 2){
            System.out.print(("|"));
        }
        System.out.println(ANSI_RESET);
    }
    public boolean isAlive(){
        if(happiness<=0 ||hunger <=0||slime <=0){
            return false;
        }
        return true;
    }
}
