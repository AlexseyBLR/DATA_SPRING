package net.proselyte.springsecurityapp.validator;

import java.util.regex.Pattern;

public interface MyValidator {

    boolean validate(Pattern pattern, String expressionForValidating);
    boolean confirmPassword(String password, String confirmedPassword);

}
