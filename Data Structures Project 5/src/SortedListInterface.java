//Chin-Chap & MacMahon

public interface SortedListInterface<T extends Comparable<? super T>> {
    //Adds a new entry to the sorted list
    public void addEntry(T newEntry);

    //Removes the first occurrence of anEntry from the list.
    public boolean removeEntry (T anEntry);

    //gets the position of anEntry in the list
    public int getPosition( T newEntry);

    //gets the length of the list
    public int getLength();
    
    public T getEntry(T entry);
    
    public boolean contains(T entry);
    
    public boolean isEmpty();
    
    public Object[] toArray();

}
