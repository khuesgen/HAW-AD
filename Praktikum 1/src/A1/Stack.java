package A1;

import java.util.ArrayList;
import java.util.List;

/**
 * Stack-Implementierung
 *
 */
public class Stack<T> {

	/**
	 * Liste der Elemente im Stack.
	 */
	private List<T> elemente = new ArrayList<T>();

	/**
	 * Zusätzliches Element auf den Stack legen.
	 */
	public void push(T element) {
		elemente.add(element);
	}

	/**
	 * Oberstes Element vom Stack nehmen.
	 */
	public T pop() {
		if (elemente.size() == 0) {
			throw new IllegalArgumentException("Stack ist leer.");
		}
		T element = elemente.get(elemente.size() - 1);
		elemente.remove(elemente.size() - 1);
		return element;
	}

	/**
	 * Liefert das oberste Element des Stacks ohne es vom Stack zu entfernen
	 */
	public T top() {
		if (elemente.size() == 0) {
			throw new IllegalArgumentException("Stack ist leer.");
		}
		return elemente.get(elemente.size() - 1);
	}

	/**
	 * Liefert wahr, wenn der Stack leer ist, sonst false.
	 */
	public boolean isEmpty() {
		return elemente.size() == 0;
	}

	/**
	 * Entfernt alle Elemente vom Stack.
	 */
	public void clear() {
		elemente.clear();
	}

	/**
	 * Wertet Klammerausdrücke aus und gibt das Ergebniss zurück.
	 * 
	 * @param expression
	 * @return
	 */
	public static int evalAlgExpression(String expression) {

		String current = null;
		String result = null;
		String operator = null;
		int op1;
		int op2;
		Stack<String> stack = new Stack<>();

		for (int i = 0; i < expression.length(); i++) {
			current = expression.substring(i, i+1);

			if (current.equals(")")) {

				op2 = Integer.parseInt(stack.pop());
				operator = stack.pop();
				op1 = Integer.parseInt(stack.pop());
				
				switch (operator) {
				case "+":
					result = Integer.toString(op1 + op2);
					break;
				case "-":
					result = Integer.toString(op1 - op2);
					break;
				case "*":
					result = Integer.toString(op1 * op2);
					break;
				case "/":
					result = Integer.toString(op1 / op2);
					break;
				}
				
				stack.pop();	 
				stack.push(result);

			} else {
				stack.push(current);
			}
		}
		return Integer.parseInt(result);
	}
	
	public static void main(String[] args) {
		System.out.println(evalAlgExpression("(((1+2)*3)-(7*8))"));
		System.out.println(evalAlgExpression("(((8*(4+2))+(5+1))"));
	}
}
