package net.proselyte.springsecurityapp.validator;

import net.proselyte.springsecurityapp.model.User;
import net.proselyte.springsecurityapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import java.util.regex.Pattern;

@Component
public class UserValidator extends AbstractValidator implements Validator, MyValidator {

    static final String EMAIL_REGULAR_EXPRESSION = ".+@.+\\..+";
    static final String PASSWORD_REG_EXP = "[A-Za-z0-9!@#$%^&*]{8,}";

    public static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGULAR_EXPRESSION);
    public static final Pattern PASSWORD_PATTERN = Pattern.compile(PASSWORD_REG_EXP);

//////////////////////////////////////////////////////////////////////////////////////

    
    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "Required");
        if(!validate(EMAIL_PATTERN, user.getUsername())){
            errors.rejectValue("username", "Size.userForm.username");

        }

        if (userService.findByUsername(user.getUsername()) != null) {
            errors.rejectValue("username", "Duplicate.userForm.username");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Required");
        if(!validate(PASSWORD_PATTERN, user.getPassword())){
            errors.rejectValue("password", "Size.userForm.password");
        }

        if(!confirmPassword(user.getPassword(), user.getConfirmPassword())){
            errors.rejectValue("confirmPassword", "Different.userForm.password");
        }

    }

    @Override
    public boolean validate(Pattern pattern, String expressionForValidating) {

        if(!this.isEmptyOrNull(expressionForValidating)){
            return this.matchesPattern(pattern, expressionForValidating);
        }
        return false;
    }

    @Override
    public boolean confirmPassword(String password, String confirmedPassword) {
        if(password.equals(confirmedPassword)){
            return true;
        }
        return false;
    }

}
