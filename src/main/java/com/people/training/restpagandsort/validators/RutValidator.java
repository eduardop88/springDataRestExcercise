package com.people.training.restpagandsort.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RutValidator implements ConstraintValidator<ValidRut, String> {

    @Override
    public boolean isValid(String rutField, ConstraintValidatorContext constraintValidatorContext) {
        return validateRut(rutField);
    }

    private static Boolean validateRut( String rut ) {
        Pattern pattern = Pattern.compile("^[0-9]+-[0-9kK]{1}$");
        Matcher matcher = pattern.matcher(rut);
        if (!matcher.matches()) return false;
        String[] stringRut = rut.split("-");
        return stringRut[1].toLowerCase().equals(verifierDigit(stringRut[0]));
    }

    private static String verifierDigit( String rut ) {
        int M=0,S=1,T=Integer.parseInt(rut);
        for (;T!=0;T=(int) Math.floor(T/=10))
            S=(S+T%10*(9-M++%6))%11;
        return ( S > 0 ) ? String.valueOf(S-1) : "k";
    }
}
