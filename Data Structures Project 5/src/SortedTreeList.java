import java.io.File;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Stack;



public class SortedTreeList <T extends Comparable <? super T>> extends LinkedChainBase<T> 
     implements SortedListInterface <T>, Iterable <T> {
    
	
	private BinarySearchTree <T> tree;

	public SortedTreeList() {
		tree = new BinarySearchTree();
	}

	public SortedTreeList(T rootData) { 
		tree = new BinarySearchTree(rootData);
	}

	public SortedTreeList(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree) {
		tree.setTree(rootData, leftTree, rightTree);
	}
	
	
	@Override
	public Iterator<T> iterator() {
		return tree.getInOrderIterator();
	}

	@Override
	public void addEntry(T newEntry) {
	 	tree.add(newEntry);	
	}

	@Override
	public boolean removeEntry(T anEntry) {
		if(isEmpty()) 
			return false;
		
		tree.remove(anEntry);
		return true;
		
	}

	@Override
	public int getPosition(T newEntry) { //test with good iterator
		int counter = 0;
		Iterator<T> iterator = tree.getInOrderIterator();
		while(iterator.hasNext()) {
		for(int i = 0; i < tree.getNumberOfNodes(); i++) {
			System.out.println(iterator.next());
			if(iterator.next() == newEntry){
				counter++;
			}
		}
		iterator.next();

		}
		return counter;
	}
	
	@SuppressWarnings("unchecked")
	public Object[] toArray() { 
		Iterator<T> iterator = tree.getInOrderIterator();
		Object [] temp =  new Object[tree.getNumberOfNodes()];
		for (int i = 0; i < tree.getNumberOfNodes(); i++) {
			temp[i] = iterator.next();
			System.out.println(iterator.next());
		}
		return temp;
	}
	
	
	public T remove(int Position) {
		T removedItem = null;
		for (int i = 0; i < tree.getNumberOfNodes(); i++) {
			if (i == Position) {
				removedItem = tree.getInOrderIterator().next();
				tree.remove(tree.getInOrderIterator().next());
			}
		}	
		return removedItem;
	}

	public void clear() {
		tree.clear();
	}
	
	public boolean isEmpty() {
		return (tree.isEmpty());
	}
	
	public boolean contains (T entry) {
		return (tree.contains(entry));
	}

	@Override
	public T getEntry(T entry) {

		return tree.getEntry(entry);
	}

	private class InOrderIterator implements Iterator <T> {

			private BinaryNode<T> root;
			private Stack <BinaryNode <T>> nodeStack;
		        
		   public InOrderIterator (){
		       BinaryNode <T> currNode = root;  
		       nodeStack = new Stack <>();
		       while (currNode != null) {
				nodeStack.push(currNode);
				currNode = currNode.getLeftChild();	
			}
		   }
		        
		   @Override
		   public boolean hasNext() {
		       return (!nodeStack.isEmpty ());
		   }


		   @Override
		   public T next () {
		       BinaryNode <T> currNode = nodeStack.pop();
		       T data = currNode.getData(); 
		        if (currNode.hasRightChild() ){
		            currNode = currNode.getRightChild();   
		           while (currNode != null){
		              nodeStack.push (currNode);
		              currNode = currNode.getLeftChild();
		           }
		       }
		       return data;
		   }
		        
		   @Override
		   public void remove (){
		       throw new UnsupportedOperationException();
		   }

	}

	public static void main(String[] args) {
		
		SortedTreeList tree = new SortedTreeList(); 
		tree.addEntry(2);
		tree.addEntry(5);
		tree.addEntry(7);
		tree.addEntry(3);
		tree.addEntry(10);

		
		System.out.println(Arrays.toString(tree.toArray()));		
		
	}
	

}
