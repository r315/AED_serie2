package serie2;

public class SLinkedList<E> {

	Node<E> head = null;
	int size=0;
	
	public void push(Node<E> node){
		node.previous = null;
		node.next = head ;
		head = node;
		size++;
	}

	public void push (E e){
		push(new Node<E>(e));
	}
	
	public E pop(){
		Node<E> result = popNode();
		if (result!=null)
			return result.value;
		return null;
	}
	
	private Node<E> popNode(){
		
		if (head==null)
			return null;
		Node<E> ret = head;
		head = head.next;
		ret.next = null;
		size--;
		return ret;
	}
	
	public int getSize() {
		return this.size;
	}

}
