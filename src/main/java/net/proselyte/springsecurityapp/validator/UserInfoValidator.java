package net.proselyte.springsecurityapp.validator;

import net.proselyte.springsecurityapp.model.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Pattern;

@Component
public class UserInfoValidator extends AbstractValidator implements Validator, MyValidator {

    private static final String PATRONYMIC_REGULAR_EXPRESSION = "((\\b[A-Z])[a-z]{1,15})";
    private static final String AGE_REGULAR_EXPRESSION = "\\b[1]{1}[8,9]{1}|\\b[2-4]{1}[0-9]{1}";
    private static final String NAME_REGULAR_EXPRESSION = "((\\b[A-Z])[a-z]{1,10})-{0,1}[A-Z]{0,1}[a-z]{1,10}";


    private static final Pattern PATRONYMIC_PATTERN = Pattern.compile(PATRONYMIC_REGULAR_EXPRESSION);
    private static final Pattern AGE_PATTERN = Pattern.compile(AGE_REGULAR_EXPRESSION);
    private static final Pattern NAME_PATTERN = Pattern.compile(NAME_REGULAR_EXPRESSION);

//////////////////////////////////////////////////////////////////////////////////////


    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

        User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstname", "Required");
        if (!validate(NAME_PATTERN, user.getFirstname())) {
            errors.rejectValue("firstname", "Correct.userFirst.firstname");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastname", "Required");
        if (!validate(NAME_PATTERN, user.getLastname())) {
            errors.rejectValue("lastname", "Correct.userFirst.lastname");
        }

        if (!matchesPattern(PATRONYMIC_PATTERN, user.getPatronymic())) {
            if (!this.isEmptyOrNull(user.getPatronymic())) {
                errors.rejectValue("patronymic", "Correct.userFirst.patronymic");
            }
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "age", "Required");
        if (!validate(AGE_PATTERN, user.getAge())) {
            errors.rejectValue("age", "Correct.userFirst.age");
        }
    }

    @Override
    public boolean validate(Pattern pattern, String expressionForValidating) {

        if (!this.isEmptyOrNull(expressionForValidating)) {
            return this.matchesPattern(pattern, expressionForValidating);
        }
        return false;
    }

    @Override
    public boolean confirmPassword(String password, String confirmedPassword) {
        if (password.equals(confirmedPassword)) {
            return true;
        }
        return false;
    }

}
