package pe.edu.estubeca.estubeca.exception;

public class ResourceNotFoundException extends  RuntimeException {
    public ResourceNotFoundException(){
        super();
    }

    public ResourceNotFoundException(String message){
        super(message);
    }
}
