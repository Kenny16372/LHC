package infrastructure.security;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Touchpad {
    public String password(Pattern pattern) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Password: ");
        for(int i = 0; i < 3; i++) {
            String s = scan.next();
            Matcher matcher = pattern.matcher(s);
            if (matcher.matches()) {
                return s;
            }
            else{
                System.out.println("Password doesn't match requirements.");
            }
        }
        System.out.println("Please try again.");
        return null;
    }

    public String password(){
        System.out.println("Password: ");
        Scanner scan = new Scanner(System.in);
        return scan.next();
    }
}
