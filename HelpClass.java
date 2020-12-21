package com.example.kidzcashfinal;

import android.view.View;

public class HelpClass {
    public static  boolean checkEmail(String emadress) { //Input is the Email - it checks if there is 1 '@' by checking if the last index of it is the same is the index of it. then it checks if the '@' isn't the first character and then if it's before the last index of '.'
        return(emadress.lastIndexOf('@') == emadress.indexOf('@') && emadress.indexOf('@') > 0 && emadress.lastIndexOf('@') + 1 < emadress.lastIndexOf('.'));
    }
    public static boolean checkPassword(String password) { //Input is the Password - it checks if the length()() is above 5, shorter than 20 and contain something that isn't a letter

        if (password.length() > 5 && password.length() < 20)
            for (int i = 0; i < password.length(); i++)
                if (password.charAt(i) < 65 || (password.charAt(i) > 90 && password.charAt(i) < 97) || password.charAt(i) < 122)
                    return true;
        return false;
    }



}
