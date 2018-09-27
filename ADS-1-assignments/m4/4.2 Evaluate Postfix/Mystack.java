import java.util.Arrays;
public class Mystack<E> {
	E[] stack = (E[]) new Object[10];
	int size = 0;
	public void push(E item) {
		if (size == stack.length) {
			inresize();
		}

		stack[size++] = item;
	}
	public void inresize() {
		E[] temp = (E[]) new Object[size * 2];
		for (int i = 0; i < temp.length; i++) {
			temp[i] = stack[i];
		}
		stack = temp;
	}
	public E pop() {
		E k = stack[size - 1];
		if (size == stack.length / 4) {
			deresize();
		}
		size -= 1;
		return k;
	}
	public void deresize() {
		E[] temp = (E[])new Object[stack.length / 2];
		for (int i = 0; i < temp.length; i++) {
			temp[i] = stack[i];
		}
		stack = temp;
	}
	public E peek() {
		return stack[size - 1];
	}
	public String toString() {
		String str = "[";
		for (int i = 0; i < size - 1; i++) {
			str += stack[i] + ",";
		}
		str += stack[size - 1] + "]";
		return str;
	}

}