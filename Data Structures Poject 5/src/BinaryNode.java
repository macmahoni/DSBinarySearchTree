//Chin-Chap & MacMahon
	public class BinaryNode<T> implements BinaryNodeInterface<T>{

		private T data;
		private BinaryNode<T> leftChild;
		private BinaryNode<T> rightChild;
		
		public BinaryNode(T dataPortion, BinaryNode<T> leftChild, BinaryNode<T> rightChild) {
			data = dataPortion;
			this.leftChild = leftChild;
			this.rightChild = rightChild;
		}
		
		public BinaryNode(T dataPortion) {
			this(dataPortion, null, null);
		}
		
		public T getData() {
			return data;
		}
		
		public void setData(T newData) {
			data = newData;
		}
		
		public boolean hasLeftChild() {
			return (leftChild != null);
		}
		
		public boolean hasRightChild() {
			return (rightChild != null);
		}

		@Override
		public void setLeftChild(BinaryNodeInterface<T> leftChild) {
			this.leftChild = (BinaryNode<T>)leftChild;
		}

		@Override
		public void setRightChild(BinaryNodeInterface<T> rightChild) {
			this.rightChild = (BinaryNode<T>)rightChild;
		}

		public BinaryNode<T> getLeftChild(){
			return leftChild;
		}
		
		public BinaryNode<T> getRightChild(){
			return rightChild;
		}

		public int getHeight() {
			return getHeight(this);
		}

		private int getHeight(BinaryNode<T> node){
			int height = 0;
			if (node != null)
				height = 1 + Math.max(getHeight(node.getLeftChild()), getHeight(node.getRightChild()));
			return height;
		}


		public int getNumberOfNodes() {
			int n = 1;
			if (leftChild != null) {
				n += leftChild.getNumberOfNodes();
				}
			if (rightChild != null) {
				n += rightChild.getNumberOfNodes();
			}
			return n;
		}
		
		public BinaryNode<T> copy(){
			BinaryNode copied = new BinaryNode(data);
			if(leftChild != null) {
				copied.setLeftChild(leftChild.copy());
			}
			if(rightChild != null) {
				copied.setRightChild(rightChild.copy());
			}
			return copied;
		}
		
		public boolean isLeaf() {
			return (leftChild == null && rightChild == null);
		}


	}
