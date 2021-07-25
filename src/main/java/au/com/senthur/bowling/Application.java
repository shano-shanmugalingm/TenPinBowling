package au.com.senthur.bowling;

import au.com.senthur.bowling.dto.GameLine;
import au.com.senthur.bowling.service.RollService;
import au.com.senthur.bowling.service.handler.KnockDownHandlerFactory;
import au.com.senthur.bowling.validator.InputValidator;

import java.util.Scanner;

/**
 * Main application class.
 * */
public class Application {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        KnockDownHandlerFactory handlerFactory = new KnockDownHandlerFactory();
        RollService rollService = new RollService(handlerFactory);

        GameLine gameLine = new GameLine();

        printBanner();
        printOptions();
        System.out.println("Please enter roll:");
        String input = SCANNER.next();

        while (!"QUIT".equalsIgnoreCase(input)) {
           if (InputValidator.validateInput(input)) {
               gameLine = rollService.rollBall(input, gameLine);
               if (gameLine.isGameOver()) {
                   System.out.println("Your Total Score : " + rollService.getTotalScore(gameLine));
                   System.exit(0);
               }
           } else {
               System.out.println("Invalid Input. The following options are available");
               printOptions();
               System.out.println("Please enter roll:");
           }

           System.out.println("Please enter roll:");
           input = SCANNER.next();
        }
    }

    private static void printBanner() {
        System.out.println("|-------------------------------------------------------|");
        System.out.println("|-----------  AMERICAN TEN-PIN BOWLING  ----------------|");
        System.out.println("|-------------------------------------------------------|");
    }

    private static void printOptions() {
        System.out.println("Options:");
        System.out.println("X Indicates a Strike");
        System.out.println("/ Indicates a Spare");
        System.out.println("- Indicates a Miss");
        System.out.println("1 Indicates a 1 pin was knocked down");
        System.out.println("2 Indicates a 2 pin was knocked down");
        System.out.println("3 Indicates a 3 pin was knocked down");
        System.out.println("4 Indicates a 4 pin was knocked down");
        System.out.println("5 Indicates a 5 pin was knocked down");
        System.out.println("6 Indicates a 6 pin was knocked down");
        System.out.println("7 Indicates a 7 pin was knocked down");
        System.out.println("8 Indicates a 8 pin was knocked down");
        System.out.println("9 Indicates a 9 pin was knocked down");
    }
}
