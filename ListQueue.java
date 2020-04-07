import java.util.NoSuchElementException;

public class ListQueue <E>{
	private Node<E> front, rear;
	private int size;

	public ListQueue() {
		front = rear = null;
		size = 0;
	}

	public int		size() 		{return size;}
	public boolean	isEmpty()	{return size() == 0;}

	public void add(E newItem) {
		Node newNode = new Node(newItem, null);
		if(isEmpty()) front = newNode;
		else rear.setNext(newNode);
		rear = newNode;
		size++;
	}

	public E remove() {
		if(isEmpty()) throw new NoSuchElementException();
		E frontItem = front.getItem();
		front = front.getNext();
		if(isEmpty()) rear = null;
		size--;
		return frontItem;
	}

	public void print() {
		if(isEmpty()) System.out.print("Q가 empty임");
		else
			for(Node p = front; p != null; p = p.getNext())
				System.out.print(p.getItem()+"\t ");
		System.out.println();
	}

	public static void main(String[] args) {
		ListQueue<String> q = new ListQueue<String>();

		q.add("apple");		q.add("orange");
		q.add("cherry");	q.add("pear");
		q.print();

		q.remove(); q.print();
		q.remove(); q.print();

		q.add("grape");		q.print();
	}
}
