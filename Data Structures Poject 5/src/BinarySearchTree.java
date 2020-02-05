//Chin-Chap & MacMahon

import java.util.Arrays;
import java.util.Iterator;

import java.util.Stack;


public class BinarySearchTree <T extends Comparable < ? super T>> 
             extends BinaryTree <T>
             implements SearchTreeInterface <T> {
    
    public BinarySearchTree (){
        super();
    }
    
    public BinarySearchTree (T rootEntry){
        super(rootEntry);
    }
    
    @Override
    public void setRootData (T rootData ) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public void setTree (T rootData, BinaryTreeInterface<T> leftTree,
                                 BinaryTreeInterface<T> rightTree) {
        throw new UnsupportedOperationException();
    }

	@Override
	public boolean contains (T entry){
        return (getEntry (entry) != null);
    }


	@Override
	public T getEntry (T entry){
		   return findEntry (getRoot(), entry);
		}

	private T findEntry (BinaryNode <T> rootNode, T entry ){
		  T result = null;
		  if (rootNode != null) {
		     T rootEntry = rootNode.getData();
		     if (entry.equals (rootEntry))
		         result = rootEntry;
		     else if (entry.compareTo (rootEntry) < 0)
		         result = findEntry ((BinaryNode <T>)rootNode.getLeftChild(),
		                              entry) ;
		     else
		         result = findEntry ((BinaryNode <T>)rootNode.getRightChild(),
		                              entry) ;
		  } 
		  return null;
		} 


	@Override
	public T add (T newEntry){
		   T result = null;
		   if (isEmpty()) 
		       setRootNode (new BinaryNode<T>(newEntry));
		   
		   else 
		       result = addEntry (getRoot(), newEntry);
		   
		   return result;
		}

	private T addEntry ( BinaryNode <T> rootNode, T newEntry){
		   assert rootNode != null;
		   T result = null;
		   int comparison = newEntry.compareTo (rootNode.getData());
		        
		   if (comparison == 0) {
		      result = rootNode.getData();
		      rootNode.setData(newEntry);
		   }
		   else if (comparison < 0){
		      if (rootNode.hasLeftChild())
		         result = addEntry (rootNode.getLeftChild(), 
		                        newEntry);
		      else
		         rootNode.setLeftChild(new BinaryNode <T>(newEntry));
		   }
		   else {
		      if (rootNode.hasRightChild())
		         result = addEntry (rootNode.getRightChild(), 
		                        newEntry);
		      else
		         rootNode.setRightChild(new BinaryNode <T>(newEntry));
		   } 
		   return result;
		}


	@Override
	public T remove(T entry) {	
		
		T result;
		if (isEmpty())
			return null;
		MoveInfo move = new MoveInfo ();
		BinaryNode <T> currNode = getRoot();
		T rootData;
		int comparison;
		do {
			rootData = move.getCurrent().getData();
			comparison = entry.compareTo (rootData);
			if (comparison > 0 ) { 
				move.setParent(currNode);
				currNode = currNode.getRightChild();
				move.setCurrent(currNode);
				move.setRight ();
			}
			if (comparison < 0) { 
				move.setParent(currNode);
				currNode = currNode.getLeftChild();
				move.setCurrent(currNode);
				move.setLeft();
			}				
		} while (comparison != 0 && currNode != null);
		
		if (currNode == null) 
			return null;
		assert (comparison == 0);
		result = currNode.getData();
		
		boolean hasLeft = currNode.hasLeftChild();
	     boolean hasRight = currNode.hasRightChild();
	     if (!hasLeft ) { 
			resetChild (move, currNode.getRightChild());
		}
		else if (!hasRight) {
			resetChild (move, currNode.getLeftChild());		
		}
		   else { 
				BinaryNode <T> toRemove = currNode;
				move.setParent(currNode);
				currNode = currNode.getLeftChild();
				move.setLeft();
				move.setCurrent(currNode);
				while (currNode.hasRightChild()) {
					move.setRight();
					move.setParent(currNode);
					currNode = currNode.getRightChild();
					move.setCurrent(currNode);
				}
				toRemove.setData(currNode.getData());
				resetChild (move, currNode.getLeftChild());
				}
				return result;
	}

	private class MoveInfo {

		private BinaryNode <T> parent;
		private BinaryNode <T> current;
		private boolean left;
			
		public MoveInfo () {
			parent = null;
			current = getRoot ();
			left = true;
		}	
		public void setParent (BinaryNode<T> parent) {
			this.parent = parent;
		}	
		public BinaryNode <T> getParent () {
			return parent;
		}	
		public void setCurrent (BinaryNode<T> node) {
			current = node;		
			}	
		public BinaryNode <T> getCurrent () {
			return current;
		}		
		public void setLeft () {
			left = true;
		}		
		public void setRight () {
			left = false;
		}		
		public boolean getLeft () {
			return left;
		}	
	}

    private void resetChild (MoveInfo move, BinaryNode <T> child){
        BinaryNode <T> parent = move.getParent();
 	  if (parent == null ) // root: the only node with no parent
 		setRootNode (child);
 	  else if (move.getLeft())
 		parent.setLeftChild (child);
 	  else
 		parent.setRightChild (child);	
 	 }

	
	@Override
	public Iterator<T> getInOrderIterator() {
		return new InOrderIterator();
	}
	
		private class InOrderIterator implements Iterator <T> {

			   private Stack <BinaryNode <T>> nodeStack;
			        
			   public InOrderIterator (){
			       BinaryNode <T> currNode = root;              
			       nodeStack = new Stack <>();
			       while (currNode != null) {
					nodeStack.push(currNode);
					currNode = currNode.getLeftChild();	
				}
			   }
	
			   public boolean hasNext() {
			       return (!nodeStack.isEmpty ());
			   }

		
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
			        

			   public void remove (){
			       throw new UnsupportedOperationException();
			   }
			}

}
