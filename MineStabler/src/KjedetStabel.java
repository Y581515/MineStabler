
public class KjedetStabel<T> implements StabelADT<T> {

	public LinearNode<T> topp;
	private int antall;

	public LinearNode<T> getTopp() {
		return topp;
	}

	public KjedetStabel() { // Kun en konstruktoor
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

	public void pushSeks(T e0, T e1, T e2, T e3, T e4, T e5) {
		push(e0);
		push(e1);
		push(e2);
		push(e3);
		push(e4);
		push(e5);

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
				antall--;
			}

			else {
				LinearNode<T> f = topp;
				LinearNode<T> denne = f.getNeste();
				while (denne != null && !(denne.getElement().equals(elem))) {
					f = denne;
					denne = denne.getNeste();
				}
				if (denne != null) {
					f.setNeste(denne.getNeste());
					Resultat++;
					antall--;
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
			LinearNode<T> f = topp;
			for (int i = 0; i < index - 1; i++) {
				f = f.getNeste();
			}
			node.setNeste(f.getNeste());
			f.setNeste(node);
		}
	}

	public void deleteAt(int index) {
		if (index == 0) {
			topp = topp.getNeste();
		} else {
			LinearNode<T> f = topp;
			LinearNode<T> denne = null;
			for (int i = 0; i < index - 1; i++) {
				f = f.getNeste();
			}
			denne = f.getNeste();
			f.setNeste(denne.getNeste());
			// System.out.println("n1 " + n1.data);
			denne = null;
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
