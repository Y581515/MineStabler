
public class EmptyCollectionException extends RuntimeException{
    
/******************************************************************
Unntak med passende melding
******************************************************************/
    public EmptyCollectionException (String samling) {
    super ("Samlingen " + samling + " er tom.");
    }
}
