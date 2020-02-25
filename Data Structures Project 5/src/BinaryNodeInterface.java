//Chin-Chap & MacMahon

public interface BinaryNodeInterface <T>{
	
	public T getData();
	
	public void setData(T newData);
	
	public boolean hasLeftChild();
	
	public boolean hasRightChild();
	
	public void setLeftChild(BinaryNodeInterface<T> leftChild);
	
	public void setRightChild(BinaryNodeInterface<T> rightChild);
	
	public BinaryNodeInterface<T> getLeftChild();
	
	public BinaryNodeInterface<T> getRightChild();
	
	public int getHeight();
	
	public int getNumberOfNodes();
	
	public BinaryNodeInterface<T> copy();
}

