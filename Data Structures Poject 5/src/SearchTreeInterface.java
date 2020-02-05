import java.util.Iterator;

public interface SearchTreeInterface<T> {
	
	public boolean contains (T entry);
	
	public T getEntry(T entry);
	
	public T add (T newEntry);
	
	public T remove (T entry);
	
	public Iterator <T> getInOrderIterator();
	
}
