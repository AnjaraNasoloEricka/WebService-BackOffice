package enchere.enchere.exception;

public class ShowError {
    ErrorJson error;
    public ShowError(NullException ex){
        this.error=ex.getError();

    }

    public ErrorJson getError() {
        return error;
    }

    public void setError(ErrorJson error) {
        this.error = error;
    }
}
