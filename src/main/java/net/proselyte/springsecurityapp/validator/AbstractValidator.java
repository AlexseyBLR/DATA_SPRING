package net.proselyte.springsecurityapp.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class AbstractValidator {

    protected boolean isEmptyOrNull(String parameter) {

        if (parameter == null || parameter.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    protected boolean matchesPattern(Pattern pattern , String expression){
        Matcher matcher = pattern.matcher(expression);
        return matcher.matches();
    }
}