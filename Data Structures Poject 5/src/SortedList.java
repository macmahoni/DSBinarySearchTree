//Chin-Chap & MacMahon

import java.util.Arrays;

public class SortedList<T extends Comparable <? super T>> extends LinkedChainBase<T> implements SortedListInterface<T> {
    @Override

    public void addEntry(T newEntry) {
    	Node before = getNodeBefore(newEntry);
    	Node toInsert = new Node(newEntry);
    	if (before == null) {
    		addFirstNode(toInsert);
     	}
    	else {
    		addAfterNode(before, toInsert);    	
    		}
    	
    }

    @Override
    public boolean removeEntry(T anEntry) {
        Node before = getNodeBefore (anEntry);
        if (before == null) {
            if (anEntry.equals(getFirstNode().getData())) {
                removeFirstNode();
                return true;
            }
            return false;
        }
        if (anEntry.equals(before.getNext().getData())) {
            removeAfterNode(before);
            return true;
        }
        return false;
    }
    
    private Node getNodeBefore (T anEntry) {
        Node curNode = getFirstNode();
        Node nodeBefore = null;
        while (curNode != null &&
                anEntry.compareTo (curNode.getData()) > 0){
            nodeBefore = curNode;
            curNode = curNode.getNext();
        }
        return nodeBefore;
    }

    @Override
    public int getPosition(T newEntry) {
        int position = 0;
        int length = getLength();
        Node curNode = getFirstNode();
        while (position < length &&
                newEntry.compareTo (curNode.getData()) > 0) {
            position ++;
            curNode = curNode.getNext();
        }
        if (position >= length ||
                (newEntry.compareTo(curNode.getData())) != 0)
            position = -1 - position;
        return position;
    
}

	@Override
	public T getEntry(T entry) {
		// TODO Auto-generated method stub
		return null;
	}

  
	}
