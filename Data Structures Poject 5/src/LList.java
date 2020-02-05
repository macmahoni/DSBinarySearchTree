//Chin-Chap & MacMahon

public class LList <T> extends LinkedChainBase<T> implements ListInterface<T> {

    public LList(){
        super();
    }

    @Override
    public void add(T newEntry) {
        Node toAdd = new Node(newEntry);
        if (isEmpty())
            addFirstNode(toAdd);
        else{
            Node lastNode = getNodeAt(getLength()-1);
            addAfterNode(lastNode,toAdd);
        }
    }

    @Override
    public void add(int givenPosition, T newEntry) {
        if (givenPosition < 0 || givenPosition > getLength())
            throw new IndexOutOfBoundsException ("Adding outside");
        Node toAdd = new Node (newEntry);
        if (givenPosition == 0)
            addFirstNode (toAdd);
        else {
            Node nodeBefore = getNodeAt (givenPosition - 1);
            addAfterNode (nodeBefore, toAdd);
        }

    }

    @Override
    public T replace(int givenPosition, T newEntry) {
        if (givenPosition < 1 || givenPosition > getLength()){
            throw new IndexOutOfBoundsException();
        }
        else {
            Node newNode = new Node(newEntry);
            Node currentNode = getFirstNode();

            for (int i = 0; i < givenPosition; i++) {
                currentNode = currentNode.getNext();
            }
            T temp = removeAfterNode(currentNode);
            addAfterNode(currentNode, newNode);
            return temp;
        }
    }

}
