
public class LinearNode<T>
{
    private T element;
    private LinearNode<T> neste;
    
    public LinearNode(){
    neste=null;
    element = null;
    }
    
    public LinearNode(T elem){
    neste=null;
    element = elem;
    }
    
    public LinearNode<T> getNeste(){
    return neste;
    }
    
    public void setNeste(LinearNode<T> node){
    neste=node;
    }
    
    public T getElement(){
    return element;
    }
    
    public void setElement(T elem){
    element=elem;
    }
    
}
