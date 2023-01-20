package enchere.enchere.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serializable;

public class NullException extends Exception{
    ErrorJson error;
    public  NullException(){}
    public NullException(String msg){
        super(msg);
        error=new ErrorJson(404,msg);
    }

    public NullException(int code,String msg){
        error=new ErrorJson(code,msg);
    }


    public ErrorJson getError() {
        return error;
    }

    public void setError(ErrorJson error) {
        this.error = error;
    }
}
