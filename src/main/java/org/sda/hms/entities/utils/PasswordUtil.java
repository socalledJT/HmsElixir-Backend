package org.sda.hms.entities.utils;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordUtil {

    public static String hashPassword(String password) {

        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public static boolean checkPassword(String password, String hashedPasswod) {
        return BCrypt.checkpw(password, hashedPasswod);
    }
}
