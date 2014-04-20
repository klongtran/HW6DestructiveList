import org.junit.Assert;

/**
 * Created by baylor on 4/3/14.
 */
public class MyLinkedList<E>
{
	protected MyLinkedNode<E> head = null;
	private MyLinkedNode<E> tail = null;
	private int numElements = 0;

    /**
	 * Returns the element at position index.
	 * @param index
	 * @return
	 */
	public E get(int index)
	{
        if (index >= 0 && index < numElements) {
            int pos = 0;
            for (MyLinkedNode<E> current = head;
                 current != null;
                 current = current.getNext(), pos+=1 )
            {
                if (pos == index) {
                    return current.getValue();
                }
            }
        }

        // must not have been a legal position
        return null;
	}

	/**
	 * Adds a new element to the end of the list:
	 *
	 * @param elem
	 */
	public void add(E elem)
	{
        MyLinkedNode<E> newNode = new MyLinkedNode<E>(elem);

        if (head == null) {
            head = tail = newNode;
        }

        else {
            tail.setNext(newNode);
            tail = newNode;
        }

        numElements++;
	}

	/**
	 * Inserts a new element at the specified index.
	 *
	 * @param elem
	 */
	public void add(int index, E elem) {
        MyLinkedNode<E> tmp = head;

        for(int i = 0; i < index; i++) {
            tmp = tmp.getNext();
        }

        tmp.next = new MyLinkedNode<>(elem, tmp.next);

        numElements++;
	}

    /**
     * Removes an element at the specified index.
     *
     * @param index
     */
    public void remove(int index) {
        if (index == 0) {
            //removing the first element must be handled specially
            head = head.next;
        } else {
            MyLinkedNode current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }

            //change its next pointer to skip past the offending node
            current.setNext(current.getNext().getNext());
        }
        numElements--;
    }

	/**
	 * Returns the current size of the list.
	 * @return
	 */
	public int size() {
		return numElements;
	}

	/**
	 * Clears the contents of the list.
	 */
	public void clear() {
		head = null;
		tail = null;
		numElements = 0;
	}


	/**
	 * These methods are only used by the unit tests.
	 * They are intentionally not public.
	 * @return
	 */
	MyLinkedNode getHead() { return head; }
	MyLinkedNode getTail() { return tail; }

	/**
	 * Print the contents of the list
	 * @return
	 */
	@Override public String toString()
	{
		String retStr = "Contents:\n";

        MyLinkedNode<E> current = head;
        while(current != null){
            retStr += current.getValue() + "\n";
            current = current.getNext();
        }

        return retStr;
	}

    public int getSize() {
        return numElements;
    }
}
