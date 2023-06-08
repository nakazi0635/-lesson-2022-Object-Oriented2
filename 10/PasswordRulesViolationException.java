package jp.ac.ait.k21085;

public class PasswordRulesViolationException extends Exception{
    public PasswordRulesViolationException(){}
    public PasswordRulesViolationException(String message){
        super(message);
    }
    public PasswordRulesViolationException(String message, Throwable cause){
        super(message, cause);
    }
    public PasswordRulesViolationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace){
        super(message, cause, enableSuppression, writableStackTrace);
    }
    public PasswordRulesViolationException(Throwable cause){
        super(cause);
    }
}
