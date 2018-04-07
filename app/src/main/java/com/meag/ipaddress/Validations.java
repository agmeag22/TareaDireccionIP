package com.meag.ipaddress;

/**
 * Created by elect on 22/03/2018.
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validations {

    private Pattern pattern;
    private Matcher matcher;

    private static final String IPADDRESS_PATTERN =
            "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                    "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                    "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                    "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";

    public Validations(){
        pattern = Pattern.compile(IPADDRESS_PATTERN);
    }

    /**
     * Validate ip address with regular expression
     * @param ip ip address for validation
     * @return true valid ip address, false invalid ip address
     */
    public boolean validate(final String ip){
        matcher = pattern.matcher(ip);
        return matcher.matches();
    }
}
