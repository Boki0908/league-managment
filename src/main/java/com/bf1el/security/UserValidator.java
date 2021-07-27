package com.bf1el.security;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.bf1el.model.User;
import com.bf1el.service.UserService;

@Component

public class UserValidator implements Validator {
	@Autowired
    private UserService userService;
	
	static String PATTERN = "^(.+)@(.+)$";

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
       // ovo je boxing- dakle ovo je pretvaranje object u user
    	User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
        if (user.getUsername().length() < 6 || user.getUsername().length() > 32) {
            errors.rejectValue("username", "Size.userForm.username");
        }
        if (userService.findByUsername(user.getUsername()) != null) {
            errors.rejectValue("username", "Duplicate.userForm.username");
        }
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "birthDate", "WrongFormat");
        if (this.isDateValid(this.convertDate(user.getBirthDate()))) {
            errors.rejectValue("birthDate", "Size.userForm.birthDate");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }

        if (!user.getPasswordConfirm().equals(user.getPassword())) {
            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
        }
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        
        Pattern pattern = Pattern.compile(PATTERN);
        Matcher matcher = pattern.matcher(user.getEmail());
        
        if(!matcher.matches()) {
        	errors.rejectValue("email", "Size.userForm.email");
        }

    }
    
    public  boolean isDateValid(String text) {
        if (text == null || !text.matches("\\d{4}-[01]\\d-[0-3]\\d"))
            return false;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        df.setLenient(false);
        try {
            df.parse(text);
            return true;
        } catch (ParseException ex) {
            return false;
        }
    }
    
    public String convertDate(Date date) {
    	SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");  
         return formatter.format(date);  
    }
}
