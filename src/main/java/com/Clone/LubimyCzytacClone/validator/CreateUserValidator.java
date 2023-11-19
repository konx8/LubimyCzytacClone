package com.Clone.LubimyCzytacClone.validator;

import com.Clone.LubimyCzytacClone.entity.User;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class CreateUserValidator {

    // Email
    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    //Password
    private static final int MIN_LENGTH = 6;
    private static final int MAX_LENGTH = 30;

    private static final String UPPER_CASE_REGEX = ".*[A-Z].*";
    private static final String LOWER_CASE_REGEX = ".*[a-z].*";
    private static final String DIGIT_REGEX = ".*\\d.*";
    private static final String SPECIAL_CHAR_REGEX = ".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*";


    public void validateLogin(User userData) {
        if(userData != null){
            throw new IllegalArgumentException("Login already taken");
        }
    }

    public void validateEmail(User newUser) {
        if(!validateEmailAddress(newUser.getEmail())){
            throw new IllegalArgumentException("Invalid email address");
        }
    }

    public void validatePassword(User newUser) {
        if(!validatePasswordIsStrong(newUser.getPassword())){
            throw new IllegalArgumentException("Weak password");
        }
    }


    private boolean validateEmailAddress(String email){
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private boolean validatePasswordIsStrong(String password){
        return isLengthValid(password) &&
                containsUpperCase(password) &&
                containsLowerCase(password) &&
                containsDigit(password) &&
                containsSpecialChar(password);
    }

    private boolean isLengthValid(String password){
        return password.length() >= MIN_LENGTH &&
                password.length() <= MAX_LENGTH;
    }

    private boolean containsUpperCase(String password) {
        Pattern pattern = Pattern.compile(UPPER_CASE_REGEX);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    private boolean containsLowerCase(String password) {
        Pattern pattern = Pattern.compile(LOWER_CASE_REGEX);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    private boolean containsDigit(String password) {
        Pattern pattern = Pattern.compile(DIGIT_REGEX);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    private boolean containsSpecialChar(String password) {
        Pattern pattern = Pattern.compile(SPECIAL_CHAR_REGEX);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

}
