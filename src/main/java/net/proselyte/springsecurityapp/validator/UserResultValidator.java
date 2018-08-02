package net.proselyte.springsecurityapp.validator;

import net.proselyte.springsecurityapp.model.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Pattern;

@Component
public class UserResultValidator extends AbstractValidator implements Validator, MyValidator {

    private static final String RESULT_REGULAR_EXPRESSION = "^\\d{1,2}$|^100$";
    private static final Pattern RESULT_PATTERN = Pattern.compile(RESULT_REGULAR_EXPRESSION);


    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);

    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "certResult", "Required");
        if(!validate(RESULT_PATTERN, user.getCertResult())){
            errors.rejectValue("certResult", "Correct.userSecond.result");
        }

        if(!validate(RESULT_PATTERN, user.getLangResult())){
            errors.rejectValue("langResult", "Correct.userSecond.result");
        }

        if(!validate(RESULT_PATTERN, user.getMathResult())){
            errors.rejectValue("mathResult", "Correct.userSecond.result");
        }

        if(!validate(RESULT_PATTERN, user.getPhysResult())){
            errors.rejectValue("physResult", "Correct.userSecond.result");
        }

        if(!validate(RESULT_PATTERN, user.getHimResult())){
            errors.rejectValue("himResult", "Correct.userSecond.result");
        }

        if(!validate(RESULT_PATTERN, user.getBiolResult())){
            errors.rejectValue("biolResult", "Correct.userSecond.result");
        }

        if(!validate(RESULT_PATTERN, user.getEnglResult())){
            errors.rejectValue("englResult", "Correct.userSecond.result");
        }
    }

    @Override
    public boolean validate(Pattern pattern, String expressionForValidating) {

        if(!this.isEmptyOrNull(expressionForValidating)){
            return this.matchesPattern(pattern, expressionForValidating);
        }
        return true;
    }

    @Override
    public boolean confirmPassword(String password, String confirmedPassword) {
        if(password.equals(confirmedPassword)){
            return true;
        }
        return false;
    }
}
