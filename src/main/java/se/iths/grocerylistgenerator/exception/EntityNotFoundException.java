package se.iths.grocerylistgenerator.exception;


public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(String message){
        super(message);
    }

}
