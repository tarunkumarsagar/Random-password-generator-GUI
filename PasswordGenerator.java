import java.util.Random;

public class PasswordGenerator{
    public static final String LOWERCASE_CHARACTER = "abcdefghijklmnopqrstuvwxyz";
    public static final String UPPERCASE_CHARACTER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String NUMBERS = "0123456789";
    public static final String SPECIAL_SYMBOLS = "!@#$%^&*()_-+={}[]|:;'<>,.?/";

    //The random ckass allow us to generate a random numbers which will used to randomly choose the characters
    private final Random random;

    //Constructor
    public PasswordGenerator(){random = new Random(); }

    public String generatePassword(int length, boolean includeUppercase, boolean includeLowercase,
                                   boolean includeNumbers, boolean includeSpecialSymbol){
        StringBuilder passwordBuilder = new StringBuilder();

        String validcharacter = "";
        if(includeUppercase) validcharacter += UPPERCASE_CHARACTER;
        if(includeLowercase) validcharacter += LOWERCASE_CHARACTER;
        if(includeNumbers) validcharacter += NUMBERS;
        if(includeSpecialSymbol) validcharacter += SPECIAL_SYMBOLS;
        
        //build Password
        for(int i=0; i<length; i++){
            int randomIndex = random.nextInt(validcharacter.length());

            //get character based on Index
            char randomchar = validcharacter.charAt(randomIndex);
            passwordBuilder.append(randomchar);
        }
        return passwordBuilder.toString();
    }
}  