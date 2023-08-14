package exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GenericException extends RuntimeException{
    private static final Logger log = LoggerFactory.getLogger(GenericException.class);
    public GenericException(String message){
        super(message);
        log.error(message);
    }
}
