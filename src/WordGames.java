import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//WordGame class
public class WordGames {
   
    // constant class variable called DICTIONARY for dictionary file
    public static final File DICTIONARY = new File("dictionary.txt");
    
    //method for menu and can throw exception for opening file.
    private static int getSelection() throws FileNotFoundException
    {
            //print menu
        System.out.println("\nWelcome to the Word Games program menu.\n" +
                           "Select from one of the following options.\n" +
                           "1. Substring problem.\n" +
                           "2. Points problem.\n" +
                           "3. Exit. ");
        System.out.print("Enter your selection:");
        Scanner s = new Scanner(System.in);
        //to get user choice
        String j = s.nextLine();
            
        //switch case for different menu options
        switch(j)
        {
            case "1":
                //for 1 call substingProblem and return 0 to main
                substringProblem();
                return 0; 
            case "2":
                // for 2 call  pointsProblem and return 0 to main.
                pointsProblem();
                return 0;
            case "3":
                // for 3 print goodbye and return 1 to main.
                System.out.println("\nGoodbye!");
                return 1;
            default:
                // for other inputs prints error massage and return 0 to main.
                System.out.println("\nInvalid option. Try again. ");
                return 0;
        }  // Close switch Case
    }// Close getSelection method
    
    //method for substring problem game and can throw exception for opening file.
    private static void substringProblem() throws FileNotFoundException{

         // Stops the programe throwing an exception if no file is found
        if (DICTIONARY.isFile() == false) {
            System.out.println("\nError: Could not open file.\nFix:   "
                            + "Ensure you have a txt file name dictionary avalible.");
            } 
        else {
        
            // Creates and initialises variables
            Scanner input = new Scanner(System.in);
            Scanner file = new Scanner(DICTIONARY);
            String userInput;
            String fileLine;
            String forInfix; 

            // Prints game Name and user input Prompt, takes user input
            System.out.print("\nSubstring Problem."
                            + "\nEnter a substring: ");
            userInput=input.next();            
        
            // Opens a while loop for as long as the txt file has a new line
             while(file.hasNextLine())
            {
                fileLine = file.nextLine();
                
                /*If word has more than one letter than
                to find infix creating substring excluding 1st and last letter.
                */
                if(fileLine.length()>1){
                    int e = fileLine.length()-1;
                    forInfix = fileLine.substring(1,e);
                }
                /*If word has only one letter than
                to find infix using the given word.
                */
                else
                {
                    forInfix = fileLine;
                }

                /*Creates and initalises booleans for if/else statement within loop
                Also resets boolean value to true with each loop iteration.*/
                boolean prefix = true;
                boolean infix = true;
                boolean suffix = true;                        

                //Prints the current word from the txt file at the start of each loop
                System.out.print(fileLine);

                /* Checks input against current word to see if it is a prefix and
                    if it is changes the boolean value for prefix to false */
                if(fileLine.startsWith(userInput)){
                    System.out.print(" - prefix");
                    prefix = false;
                }
                /* Checks input against current word to see if it is a infix and
                    if it is changes the boolean value for infix to false */            
                if(forInfix.contains(userInput)){
                    System.out.print(" - infix");
                    infix = false;
                }
                /* Checks input against current word to see if it is a sufffix and
                    if it is changes the boolean value for sufffix to false */            
                if(fileLine.endsWith(userInput)){
                    System.out.print(" - suffix");
                    suffix = false;
                }
                // Checks all boolean values for true, if so prints a statement.
                if(prefix && infix && suffix){
                    System.out.print(" - not found");
                }
                System.out.print("\n");
            } // Close while loop.
        } // Close else statment
    } // Close substringProblem method
     
    //method for points problem game and can throw exception for opening file
    private static void pointsProblem() throws FileNotFoundException
    {
         // Stops the programe throwing an exception if no file is found
        if (DICTIONARY.isFile() == false) {
            System.out.println("\nError: Could not open file.\nFix:   "
                             + "Ensure you have a txt file name dictionary avalible.");
        }
        else {
        
            // Creates and initialises variables
            Scanner input = new Scanner(System.in);
            Scanner file = new Scanner(DICTIONARY);
            String fileLine;

            // Prints game Name 
            System.out.println("\nPoints Problem.");        
        
            // Opens a while loop for as long as the txt file has a new line
            while(file.hasNextLine())
            {
                fileLine = file.nextLine();
                int sum = 0;// to calculate total points of every word.
            
                // for loop to calculate every single charcter points of word.
                for(int i = 0 ;i<fileLine.length();i++)
                {
                    char test = fileLine.charAt(i);
                
                    switch (test) {
                        case 'a':
                        case 'e':
                        case 'i':
                        case 'l':
                        case 'n':
                        case 'o':
                        case 'r':
                        case 's':
                        case 't':
                        case 'u':
                         // for a,e,i,l,n,o,r,s,t,u adding 1 point for the word
                            sum+=1;
                            break;
                        case 'd':
                        case 'g':
                            // for d,g adding 2 point for the word
                            sum+=2;
                            break;
                        case 'b':
                        case 'c':
                        case 'm':
                        case 'p':
                            // for b,c,m,p adding 3 point for the word
                            sum+=3;
                            break;
                        case 'f':
                        case 'h':
                        case 'v':
                        case 'w':
                        case 'y':
                            // for f,h,v,w,y adding 4 point for the word
                            sum+=4;
                            break;
                        case 'k':
                            // for k adding 5 point for the word
                            sum+=5;
                            break;
                        case 'j':
                        case 'x':
                            // for j,x adding 8 point for the word
                            sum+=8;
                            break;
                        case 'q':
                        case 'z':
                            // for q,z adding 10 point for the word
                            sum+=10;
                            break;
                        default:
                            break;
                    }//// Close switch statment
                }// Close for loop
                System.out.println(fileLine+" is worth "+sum+" points.");
            } // Close while loop.
        } // Close else statment
    }// Close pointsProblem method
    
    //main method
    public static void main(String[] ar)
    {
        //variable to recieve returned value from getSelection method.
        int i = 1;
        
        //try catch to handle fileNotfoundException
        try {
           i = getSelection();
        }//Close try.
        
        //if there is a error shows error message
        catch (FileNotFoundException ex) {
            System.out.println("\nError: Could not open file.\nFix:   "
                + "Ensure you have a txt file name dictionary avalible.");
        }//Close catch
        
        //while loop to repeat menu until exit has been chosen
        while (true)
        {
           //if exit has been chosen loop stops
           if(i == 1)
           {
               break;
           }
           //else loop goes on
           else
           {
            /*try catch to handle fileNotfoundException from getSelection method
               for dictionary file
               */
               try {
                i = getSelection();
                }//Close try.
                catch (FileNotFoundException ex) {
                System.out.println("\nError: Could not open file.\nFix:   "
                    + "Ensure you have a txt file name dictionary avalible.");
                }//Close catch
           }//Close else   
        }//Close while   
    }//Close main method  
}//Close WorldGame Class 
