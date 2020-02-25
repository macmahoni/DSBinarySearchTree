//Chin-Chap & MacMahon

import java.util.Iterator;
public interface TreeIteratorInterface <T>{
	public Iterator<T> getInOrderIterator();
	public Iterator<T> getPostOrderIterator();
	public Iterator<T> getPreOrderIterator();
	public Iterator<T> getLevelOrderIterator();
}
