/**
 * Chloe Adzima
 * Project 3
 * MyStack
 * The purpose of this class is to implement the methods of the Stack Interface using a linked list
 */
import java.util.EmptyStackException;

public class MyStack<E> implements StackInterface<E>  {
	// create variable to keep reference to top node
	Node<E> top;
	// inner node class
	private class Node<E> { 
		private E data; 
		private Node<E> next;
		
		public Node(E dataPart) { 
			this(dataPart, null);
		}
		public Node(E dataPart, Node<E> nextNode) { 
			data = dataPart;
			next = nextNode;
		}
		public E getData() { 
			return data;
		}
		public void setData(E newData) { 
			data = newData;
		}
		public Node<E> getNextNode() { 
			return next;
		}
		public void setNextNode(Node<E> nextNode) { 
			next = nextNode;
		}
	}
	// pushes a new entry onto top of stack
	public void push(E newEntry) { 
		Node<E> newNode = new Node<E>(newEntry);
		newNode.setNextNode(top);
		top = newNode;
	}
	// removes entry from top of stack and returns that entry
	public E pop() { 
		if (top != null) { 
			E toReturn = top.getData();
			top = top.getNextNode();
			return toReturn;
		} 
		// throw empty stack exception if the stack is empty
		else { 
			throw new EmptyStackException();
		}
	}
	// returns the entry at the top of the stack but does not remove it 
	public E peek() { 
		if (top != null) { 
			return top.getData();
		}
		// throw empty stack exception is stack is empty
		else { 
			throw new EmptyStackException();
		}
	}
	// returns true if stack is empty and false if not
	public boolean isEmpty() { 
		if (top == null) { 
			return true;
		}
		return false;
	}
	// empties the entire stack
	public void clear() { 
		top = null;
	}
	// returns a string representation of the stack
	public String toString() { 
		String toReturn = "";
		Node<E> firstNode = top;
		while (firstNode != null) { 
			E aString = firstNode.getData();
			toReturn += aString + " | ";
			firstNode = firstNode.getNextNode();
		}
		return "TOP: " + toReturn;
	}
}
