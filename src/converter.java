import java.util.Scanner;

public class converter {

    //Converts the Roman Numeral to an integer
    int romanToInt(String romanNumeral) {
        int result = 0;
        int next = 1;

        for (int i = 0; i < romanNumeral.length(); i++) {
            int valueOne = romanNumeralValue(romanNumeral.charAt(i));
            //More than one char left in Roman Numeral
            if (i + next < romanNumeral.length()) {
                int valueTwo = romanNumeralValue(romanNumeral.charAt(i + next));
                //Left char is greater so you use addition
                if (valueOne >= valueTwo) {
                    result = result + valueOne;
                }
                //Right char is bigger so you subtract and add
                else {
                    result = result + valueTwo - valueOne;
                    i++;
                }
            }
            //Last char in Roman Numeral
            else {
                result = result + valueOne;
            }
        }
        return result;
    }

    //Reference for the values of different Roman Numeral Characters.
    int romanNumeralValue(char value) {
        if (value == 'I') return 1;
        if (value == 'V') return 5;
        if (value == 'X') return 10;
        if (value == 'L') return 50;
        if (value == 'C') return 100;
        if (value == 'D') return 500;
        if (value == 'M') return 1000;
        return 0;
    }

    //This checks the user input fo ensure it is a valid Roman Numeral
    boolean validRomanNumeral(String string) {
        //Didn't quite grasp rule 4 in the challenge. But this is where I would ensure that the entered
        //Roman Numeral is legit. Here is what I think it means logic wise. Logical or statments have bug.

//        if (string.length() == 1) {
//            char romanNumeral = string.charAt(0);
//            if (romanNumeral == 'M' || 'D' || 'C' || 'L' || 'X' || 'V' || 'I') {
//                return true;
//            }
//        }
//        else {
//            for (int i = 1; i < string.length(); i++) {
//                char current = string.charAt(i);
//                char previous = string.charAt(i - 1);
//                if (current == 'M') {
//                    if (previous != 'M' || 'C') {
//                        return false;
//                    }
//                } else if (current == 'D') {
//                    if (previous != 'L' || 'D') {
//                        return false;
//                    }
//                } else if (current == 'C') {
//                    if (previous != 'X' || 'C') {
//                        return false;
//                    }
//                } else if (current == 'L') {
//                    if (previous != 'V' || 'L') {
//                        return false;
//                    }
//                } else if (current == 'X') {
//                    if (previous != 'I' || 'X') {
//                        return false;
//                    }
//                } else if (current == 'V') {
//                    if (previous != 'V') {
//                        return false;
//                    }
//                } else if (current == 'I') {
//                    if (previous != 'I') {
//                        return false;
//                    }
//                } else {
//                    return false;
//                }
//            }
//        }
        //Place holder since I didnt get this function working right.
        return true;
    }

    public static void main(String[] args) {
        boolean runAgain = true;
        converter convert = new converter();

        //Allows user to input Roman Numerals as many times as they want.
        while (runAgain) {
            System.out.println("Enter the Roman Numeral you would like to convert.");
            Scanner sc = new Scanner(System.in);
            String str = sc.nextLine();
            if (convert.validRomanNumeral(str)) {
                System.out.println("That Roman Numeral is " + convert.romanToInt(str));
                System.out.println("Would you like to convert another Roman Numeral? (Enter 'yes' or 'no')");
                Scanner bool = new Scanner(System.in);
                runAgain = bool.nextLine().equals("yes");
            }
            else {
                System.out.println("Invalid Roman Numeral. Please try again.");
            }
        }
        System.out.println("Thank you for using the Roman Numeral Converter.");
    }
}
