//Chin-Chap & MacMahon

public interface ListInterface <T>{
    //Adds new entry at the end of the list
    public void add (T newEntry);

    //adds new entry at a specified position, shifts entries to reserve space
    public void add (int newPosition, T newEntry);

    //removes an entry at a given position
    public T remove (int givenPosition);

    //removes the specified entry from the list
    public boolean remove (T anEntry);

    //removes all entries from the list
    public void clear();

    //replaces an entry at given position with a new one
    public  T replace (int givenPosition, T newEntry);

    //retrieves an entry at given position
    public T getEntry (int givenPosition);

    //gets the length of the list
    public int getLength();

    //checks whether the list is empty
    //returns true if it is empty, false if not
    public boolean isEmpty();

}