import java.util.Scanner;

public class UserInfoLab{
    public static void main(String[] args){
        // Part 1
        // Create a Scanner for keyboard input
        // Ask the user to enter their first and last name and pass these
        // values to the generateUsername method and save the returned result.
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your first name: ");
        String firstName = input.nextLine();

        System.out.print("Enter your last name: ");
        String lastName = input.nextLine();

        String username = generateUsername(firstName, lastName);

        // Part 2
        // Ask the user to enter a password and pass this value to the validatePassword method.
        // The validatePassword method will check if the password meets the criteria:
        System.out.print("Enter your password: ");
        String password = input.nextLine();

        boolean validPassword = validatePassword(password);

        // Part 3
        // If the user entered a valid password in step 2, then ask the user to enter their
        // credit card number and pass this value to the maskCreditCard method.
        String maskedCard = "N/A";

        if(validPassword){
            System.out.print("Enter your credit card number: ");
            String creditCard = input.nextLine();


            maskedCard = maskCreditCard(creditCard);
        }

        // Part 4
        // If the user entered a valid password AND valid credit card number, display the output
        // as shown in the demo video

        System.out.println("Username: " + username);

        if(validPassword){
            System.out.println("Password: Valid");
        }
        else{
            System.out.println("Password: Invalid");
        }

        System.out.println("Credit Card: " + maskedCard);
    }

    /**
     * Creates a username using the first three letters of each name.
     * @param firstName The user's first name
     * @param lastName The user's last name
     * @return The username in lowercase
     */
    public static String generateUsername(String firstName, String lastName){
        if(firstName.length() > 3){
            firstName = firstName.substring(0, 3);
        }

        if(lastName.length() > 3){
            lastName = lastName.substring(0, 3);
        }

        String username = firstName + lastName;

        return username.toLowerCase();
    }
    /**
     * Checks if the password meets all the requirements.
     * @param password The password to check
     * @return true if valid, false if invalid
     */
    public static boolean validatePassword(String password){
        boolean valid = true;
        boolean hasUppercase = false;


        if(password.length() < 8){
            System.out.println("Password must be at least 8 characters long.");
            valid = false;
        }


        for(int i = 0; i < password.length(); i++){
            if(Character.isUpperCase(password.charAt(i))){
                hasUppercase = true;
            }
        }


        if(!hasUppercase){
            System.out.println("Password must have an uppercase letter.");
            valid = false;
        }


        if(!containsDigit(password)){
            System.out.println("Password must have a number.");
            valid = false;
        }


        return valid;
    }
    /**
     * Checks and masks a credit card number.
     * @param creditCardNumber The credit card number
     * @return The masked number or N/A if invalid
     */
    public static String maskCreditCard(String creditCardNumber){
        if(allDigits(creditCardNumber) && creditCardNumber.length() == 16){
            return "**** **** **** " + creditCardNumber.substring(12);
        }
        return "N/A";
    }
    /**
     * This method verifies that the string contains at least one numeric digit
     * @param str The string to check
     * @return true or false if a digit is present
     */
    public static boolean containsDigit(String str){
        for(int i = 0; i < str.length(); i++){
            if(Character.isDigit(str.charAt(i))){
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the entire String is all numerical
     * @param str The string to check
     * @return true or false if the string is ALL digits
     */
    public static boolean allDigits(String str){
        for(int i = 0; i < str.length(); i++){
            if(!Character.isDigit(str.charAt(i))){
                return false;
            }
        }
        return true;
    }
}
