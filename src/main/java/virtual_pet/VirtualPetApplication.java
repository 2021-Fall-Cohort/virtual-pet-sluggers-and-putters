package virtual_pet;

import java.util.Scanner;

public class VirtualPetApplication {
    //commenting to commit
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";

    public static void main(String[] args) {
        int score = 0;
        System.out.println("Oh look, a slug!\n");
        System.out.println(ANSI_BLUE + "                                                        @%         (@           \n" +
                "    " + ANSI_GREEN + "                                                    @*       %#             \n" +
                "                                                        &(    *%%               \n" +
                "                                                    **//&%#//**/                \n" +
                "                                               ,****,%/(####%##/*/              \n" +
                "                              .,,,,,,,***********/*.#######%%%&&(#(             \n" +
                "                  ******,**,************,**,**///((#%%%%%%%&&&&&#&&@@*          \n" +
                "             *****,,*,***.,.,,,,..,......,,///(((##%%%%%%&&&&&&.  #,            \n" +
                "           //,//*///,((/****.    ..    .,**//(((#%&##%%%&&                      \n" +
                "          .(////((#((/*#//,//**,,***.,,*////(##%&%#%%&&&%                       \n" +
                "           ,/((((######(((((((((/////*//((((#%%%##%%&&%#                        \n" +
                "                 /###((//*/((((##########%#(#%/#%%%&&&                          \n" +
                "                               ,#(##.,**.,*###%&&#                              \n" + ANSI_RESET);
        System.out.println("What do you want to name your new slug friend?\n");
        Scanner inputScanner = new Scanner(System.in);
        String nickname = inputScanner.nextLine();
        System.out.println("\nYou named your slug: " + nickname + "\n\nThat's adorable!"
        + "\n\nEach day your slug, " + nickname + ", will need some attention to survive.\n");

        Slug one = new Slug(nickname, 100, 100, 100);

        do {
            one.tick();
            score++;
        } while (one.isAlive());

        if (one.slime <= 0){
            System.out.println("Your slug dehydrated.\n");
        }
        else if (one.hunger <=0){
            System.out.println("Your slug starved.\n");
        }
        else{
            System.out.println("Your slug fainted from unhappiness.\n");
        }

        System.out.println("          ________________________ \n" +
                "\t /                        \\\\\n" +
                "\t|                          ||\n" +
                "\t|      Rest In Peace       ||\n" +
                "\t|                          ||\n" +
                "\t|          _____           ||\n" +
                "\t|         ( 0 0 )          ||\n" +
                "\t|          |_|_|           ||\n" +
                "\t|                          ||\n" +
                "\t|           <@>            ||\n" +
                "\t|           c/             ||\n" +
                "\t|           /D             ||\n" +
                "\t|          [ ]             ||\n" +
                "\t|                          ||\n" +
                "\t|                      __/\\||\n" +
                "\t|_____________________| /  \\|\n");

        System.out.println("\nYour slug survived for " + score + " days.");
    }

}
