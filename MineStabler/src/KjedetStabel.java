
public class KjedetStabel<T> implements StabelADT<T> {

	public LinearNode<T> topp;
	private int antall;

	public LinearNode<T> getTopp() {
		return topp;
	}

	public KjedetStabel() { // Kun en konstruktÃ¸r
		topp = null;
		antall = 0;
	}

	public KjedetStabel(T elem) {
		this.topp = new LinearNode<T>(elem);
		this.antall = 1;
	}

	public KjedetStabel(LinearNode<T> start) {
		int ant = 0;
		LinearNode<T> noder = start;
		while (noder != null) {
			ant++;
			noder = noder.getNeste();
		}
		this.antall = ant;
		this.topp = start;
	}

	public void push(T el) {
		LinearNode<T> nynode = new LinearNode<T>(el);
		nynode.setNeste(topp); // 1
		topp = nynode; // 2
		antall++;

	};

	public T pop() {
		if (erTom()) {
			throw new EmptyCollectionException("stabel");
		}
		T resultat = topp.getElement();
		topp = topp.getNeste();
		antall--;
		return resultat;

	};

	public T peek() {

		if (erTom()) {
			throw new EmptyCollectionException("stabel");
		}
		return topp.getElement();

	};

	public boolean erTom() {
		return (antall <= 0);
	};

	public int antall() {
		return antall;
	};

	public boolean inneholder(T element) { // versjon 1
		boolean funnet = false;
		LinearNode<T> denne = topp;

		for (int sok = 0; sok < antall && !funnet; sok++) {
			if (denne.getElement().equals(element)) {
				funnet = true;
			} else {
				denne = denne.getNeste();
			}
		}
		return funnet;
	}

	public boolean inneholder2(T element) { // versjon 2
		boolean funnet = false;
		LinearNode<T> denne = topp;

		while (denne != null && !funnet) {
			if (denne.getElement().equals(element)) {
				funnet = true;
			} else {
				denne = denne.getNeste();
			}
		}
		return funnet;
	}

	public boolean inneholder3(T element) { // versjon 3
		LinearNode<T> denne = topp;

		while (denne != null && !element.equals(denne.getElement())) {
			denne = denne.getNeste();
		}
		return (denne != null);
	}

	public void fjernEllement(T elem) {
		int Resultat = 0;

		while (inneholder3(elem)) {
			if (elem == topp.getElement()) {
				pop();
				Resultat++;
			}

			else {
				LinearNode<T> n = topp;
				LinearNode<T> n1 = n.getNeste();
				for (int i = 0; i < antall - 2 && !(n1.getElement().equals(elem)); i++) {
					n = n.getNeste();
					n1 = n1.getNeste();
				}
				if (n1.getElement().equals(elem)) {
					n.setNeste(n1.getNeste());
					Resultat++;
				}
			}

		}

		System.out.println(Resultat + " elementer har blit sletet");
	}

	public void insertAt(int index, T elem) {
		LinearNode<T> node = new LinearNode<T>(elem);

		if (index == 0) {
			push(elem);
		} else {
			LinearNode<T> n = topp;
			for (int i = 0; i < index - 1; i++) {
				n = n.getNeste();
			}
			node.setNeste(n.getNeste());
			n.setNeste(node);
		}
	}

	public void deleteAt(int index) {
		if (index == 0) {
			topp = topp.getNeste();
		} else {
			LinearNode<T> n = topp;
			LinearNode<T> n1 = null;
			for (int i = 0; i < index - 1; i++) {
				n = n.getNeste();
			}
			n1 = n.getNeste();
			n.setNeste(n1.getNeste());
			// System.out.println("n1 " + n1.data);
			n1 = null;
		}
	}

	public void show() {
		LinearNode<T> node = topp;

		while (node != null) {
			System.out.println(node.getElement());
			node = node.getNeste();
		}
	}

}
