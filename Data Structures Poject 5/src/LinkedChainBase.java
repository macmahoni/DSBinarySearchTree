//Chin-Chap & MacMahon

abstract class LinkedChainBase<T> {
    private Node firstNode;
    private int numberOfEntries;

    public LinkedChainBase() {
        initializeDataFields();
    }

    public void clear(){
        initializeDataFields();
    }

    public int getLength(){
        int numberOFEntries = 0;
        for (Node currNode = firstNode; currNode != null; currNode = currNode.getNext()) {
            numberOFEntries++;
        }
        return numberOFEntries;
    }
    public boolean isEmpty(){
        boolean result;
        if (numberOfEntries == 0) {
            assert firstNode == null;
            result = true;

        } else {
            assert firstNode != null;
            result = false;
        }
        return result;
    }

    public boolean remove (T anEntry) {
        if (isEmpty())
            throw new NullPointerException();
        Node currNode = null;
        Node first = getFirstNode();
        if (anEntry.equals (first.getData())) {
            removeFirstNode();
            return true;
        }
        for (Node nextNode = first; nextNode != null;
             nextNode = currNode.getNext()) {
            if (anEntry.equals (nextNode.getData())) {
                removeAfterNode (currNode);
                return true;
            }
            currNode = nextNode;
        }
        return false;
    }

    public T remove(int givenPosition) {
        T result = null;
        if (givenPosition < 1 || givenPosition > getLength())
            throw new IndexOutOfBoundsException();
        if (givenPosition == 1)
            return removeFirstNode();
        else {
            Node nodeBefore = getNodeAt(givenPosition);
            return removeAfterNode(nodeBefore);
        }
    }

    public boolean contains(T anEntry){
        Node currNode = firstNode;
        while (currNode.getData() != null) {
            if (currNode.data == anEntry) {
                return true;
            }
            currNode = currNode.getNext();
        }
        return false;
    }

    public T getEntry(int givenPosition) {
        if (givenPosition < 0 || givenPosition > getLength()) {
            throw new IndexOutOfBoundsException("Index " + givenPosition+ " out of bounds");
        }
        else {
            Node currentNode = getFirstNode();
            for (int i = 0; i < givenPosition; i++) {
                currentNode = currentNode.getNext();
            }

            return currentNode.getData();

        }
    }

    @SuppressWarnings("unchecked")
	public Object[] toArray() {
        T[] result = (T[])new Object[numberOfEntries];
        int index = 0;
        for (Node currNode = firstNode; currNode != null; currNode = currNode.getNext()) {
        	result[index] = currNode.data;
        	index++;
        }
        return result;
    }

    protected final void initializeDataFields(){
        firstNode = null;
        numberOfEntries = 0;
    }

    protected final Node getFirstNode(){
        return firstNode;
    }

    protected final void addFirstNode (Node fn){
        fn.setNext(firstNode);;
        firstNode = fn;
        numberOfEntries++;
    }

    protected final void addAfterNode (Node currNode, Node afterNode){
        afterNode.setNext(currNode.getNext());
        currNode.setNext(afterNode);
        numberOfEntries++;
    }
    protected final Node getNodeAt(int position){
        if (position < 0 || position >= numberOfEntries)
            throw new IndexOutOfBoundsException("seraching outside of chain");
        Node currNode = getFirstNode();
        for (int pos = 0; pos < position; pos++)
            currNode = currNode.getNext();
        return currNode;
    }

    protected final T removeFirstNode(){
        Node oldNode = firstNode;
        firstNode = firstNode.next;

        numberOfEntries--;
        return oldNode.getData();
    }

    protected final T removeAfterNode(Node currNode){
        Node nodeToRemove = currNode.getNext();
        if (nodeToRemove != null ) {
            currNode.setNext(nodeToRemove.getNext());
            numberOfEntries--;

            return nodeToRemove.getData();

        } else {
            return null;
        }
    }
    protected final class Node {
        T data;
        Node next;

        protected Node (T dataPortion) {
            data = dataPortion;
            next = null;
        }

        protected Node (T dataPortion, Node nextNode) {
            data = dataPortion;
            next = nextNode;
        }

        public T getData () {
            return data;
        }

        public void setData( T newEntry ) {
            data = newEntry;
        }

        public Node getNext () {
            return next;
        }

        public void setNext ( Node nextNode) {
            next = nextNode;
        }
    }

}


