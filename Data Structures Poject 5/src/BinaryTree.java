//Chin-Chap & MacMahon

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree <T> implements BinaryTreeInterface<T> {

	BinaryNode<T> root;

	public BinaryTree() {
		root = null;
	}

	public BinaryTree(T rootData) {
		root = new BinaryNode(rootData);
	}

	public BinaryTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree) {

		initializeTree(rootData, leftTree, rightTree);
	}

	@Override
	public void setTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree) {
		initializeTree(rootData, (BinaryTree<T>)leftTree, (BinaryTree<T>)rightTree);
	}

	private void initializeTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree) {
		root = new BinaryNode<T>(rootData);
		if (leftTree != null && !leftTree.isEmpty()) {
			root.setLeftChild(leftTree.getRoot());
		}
		if (rightTree != null && !rightTree.isEmpty()) {
			if (rightTree == leftTree) {
				root.setRightChild(rightTree.getRoot().copy()); //something wrong here
			} else {
				root.setRightChild(rightTree.getRoot());
			}
		}

		if (leftTree != null && leftTree != this) {
			leftTree.clear();
		}
		if (rightTree != null && rightTree != this) {
			rightTree.clear();
		}
	}

	public BinaryNode<T> getRoot() {
		return root;
	}

	public int getHeight() {
		int height = 0;
		if (root != null)
			height = root.getHeight();
		return height;
	}

	public int getNumberOfNodes(){
		int numberOfNodes = 0;
		if (root != null)
			numberOfNodes = root.getNumberOfNodes();
		return numberOfNodes;
	}

	public boolean isEmpty() {
		return (root == null);
	}

	public void clear() {
		root = null;
	}

	public void setRootData(T rootData) {
		root.setData(rootData);
	}

	public void setRootNode(BinaryNode<T> rootNode){
		root = rootNode;
	}

	@Override
	public T getRootData() {
		return root.getData();
	}

	@Override
	public Iterator<T> getInOrderIterator() {

		return new InOrderIterator();
	}

	@Override
	public Iterator<T> getPostOrderIterator() {
		return new PostOrderIterator<T>();
	}

	@Override
	public Iterator<T> getPreOrderIterator() {
		return new PreorderIterator();
	}

	private class InOrderIterator<T> implements Iterator<T> {
		private Stack <BinaryNode<T>> nodeStack;

		public InOrderIterator() {
			nodeStack = new Stack<>();
			addToStack((BinaryNode<T>) root);
		}

		private void addToStack (BinaryNode <T> aNode) {
			if (aNode == null)
				return;
			else{
			BinaryNode <T> right = (BinaryNode <T>)aNode.getRightChild();
			BinaryNode <T> left = (BinaryNode <T>)aNode.getLeftChild();
			addToStack (right);
			nodeStack.push(aNode);
			addToStack (left);
			}
		}
		public boolean hasNext() {
			return (!nodeStack.isEmpty());
		}

			public T next() {
			return nodeStack.pop().getData();
			}

			@Override
			public void remove (){
				throw new UnsupportedOperationException();
			}
	}

	private class PreorderIterator implements Iterator <T> {
		   private Stack <BinaryNode<T>> nodeStack;
		        
		   public PreorderIterator (){
		      if (root == null)
				throw new IllegalArgumentException (
		                                  "No iteration on empty tree");
		          
		       nodeStack = new Stack <>();
		       nodeStack.push (root);
		   }
		        
		    @Override
		    public boolean hasNext() {
		       return (!nodeStack.isEmpty());
		    }
		        
		    @Override
		    public T next() {
		       BinaryNode <T> currNode = nodeStack.pop();
			 T item = currNode.getData();
			 if (currNode.hasRightChild())
				nodeStack.push(currNode.getRightChild());
			 if (currNode.hasLeftChild())
				nodeStack.push(currNode.getLeftChild());
			 return item;
		    }
		    
		    @Override
		    public void remove (){
		        throw new UnsupportedOperationException();
		    }

	}

	
	private class PostOrderIterator<T> implements Iterator<T> {
		private Stack <BinaryNode<T>> nodeStack;

		public PostOrderIterator() {
			BinaryNode <T> currNode = (BinaryNode<T>) root;              
		    nodeStack = new Stack <>();
			addToStack((BinaryNode<T>) root);
		}

		private void addToStack(BinaryNode<T> root) {
			if (nodeStack.isEmpty()) {
			}
			nodeStack.push(root);
			if (root.hasRightChild())
				addToStack(root.getRightChild());
			if (root.hasLeftChild())
				addToStack(root.getLeftChild());
		}

		public boolean hasNext() {
			return (!nodeStack.isEmpty());
		}

		public T next() {
			if (!hasNext())
				throw new NullPointerException();
			return (nodeStack.pop().getData());
		}
		
		 @Override
		   public void remove (){
		       throw new UnsupportedOperationException();
		   }
	}

	private class LevelOrderIterator implements Iterator<T> {

		private Queue <BinaryNode<T>> nodeQueue;

		public LevelOrderIterator() {
			BinaryNode <T> currNode = (BinaryNode<T>) root;              
		    nodeQueue = new LinkedList <>();
			nodeQueue.add(root);
		}

		@Override
		public boolean hasNext() {
			return (!nodeQueue.isEmpty());
		}

		@Override
		public T next() {
			if (!hasNext())
				throw new NullPointerException();
			BinaryNode<T> currNode = nodeQueue.remove();
			T item = currNode.getData();
			if (currNode.hasLeftChild())
				nodeQueue.add(currNode.getLeftChild());
			if (currNode.hasRightChild())
				nodeQueue.add(currNode.getRightChild());

			return item;
		}
	}

	@Override
	public Iterator<T> getLevelOrderIterator() {
		return new LevelOrderIterator();
	}

}
	