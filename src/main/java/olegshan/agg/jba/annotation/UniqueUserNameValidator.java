package olegshan.agg.jba.annotation;

import olegshan.agg.jba.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by Bors on 30.04.2016.
 */
public class UniqueUserNameValidator implements ConstraintValidator<UniqueUsername, String> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void initialize(UniqueUsername uniqueUsername) {

    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        if (userRepository == null) return true;
        return userRepository.findByName(username) == null;
    }
}
