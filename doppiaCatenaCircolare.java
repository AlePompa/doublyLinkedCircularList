// Alessandro Pompa Di Gregorio		Matricola: 7087766

import java.util.*;

public class doppiaCatenaCircolare<T> {

	private Nodo<T> head;
	private int size = 0;

	public doppiaCatenaCircolare() {
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public Nodo<T> getHead() {
		return head;
	}

	public Nodo<T> getTail() {
		return head.getPrec();
	}

	public Nodo<T> getIesimo(int i) {
		if (i < 1 || i > size) {
			System.out.println("L'indice richiesto non è compreso tra 1 e " + size);
			return null;
		}
		Nodo<T> temp = head;
		for (int j = 1; j < i; j++) {
			temp = temp.getSucc();
		}
		return temp;
	}

	public boolean insert(int key, T info) {
		if (key < 1 || key > (int) Math.pow(10, 6)) {
			System.out.println("La chiave inserita non è compresa tra 1 e 10^(6)");
			return false;
		}
		if (esisteClone(key, info)) {
			System.out.println("Esiste già un nodo con stessa chiave e stessa informazione");
			return false;
		}
		Nodo<T> nuovo = new Nodo<T>(info, key);
		if (isEmpty()) {
			head = nuovo;
			head.setPrec(head);
			head.setSucc(head);
			size++;
		} else if (size == 1) {
			head.setPrec(nuovo);
			head.setSucc(nuovo);
			nuovo.setPrec(head);
			nuovo.setSucc(head);
			size++;
		} else {
			head.getSucc().setPrec(nuovo);
			nuovo.setSucc(head.getSucc());
			head.setSucc(nuovo);
			nuovo.setPrec(head);
			size++;
		}
		return true;
	}

	public boolean removeByKey(int key) {
		ArrayList<Nodo<T>> ricerca = searchByKey(key);
		if (ricerca.size() == 0)
			return false;
		if (ricerca.size() == 2) {
			ricerca.get(0).getPrec().setSucc(ricerca.get(0).getSucc());
			ricerca.get(0).getSucc().setPrec(ricerca.get(0).getPrec());
			ricerca.get(1).getPrec().setSucc(ricerca.get(1).getSucc());
			ricerca.get(1).getSucc().setPrec(ricerca.get(1).getPrec());
			size -= 2;
			return true;
		}
		if (ricerca.get(0).equals(head)) {
			head.getPrec().setSucc(head.getSucc());
			head.getSucc().setPrec(head.getPrec());
			head = head.getSucc();
			size--;
			return true;
		}
		ricerca.get(0).getPrec().setSucc(ricerca.get(0).getSucc());
		ricerca.get(0).getSucc().setPrec(ricerca.get(0).getPrec());
		size--;
		return true;
	}

	public String printSearchByKey(int key) {
		ArrayList<Nodo<T>> ricerca = searchByKey(key);
		if (ricerca.isEmpty())
			return "Nodo non trovato";
		String s = "";
		Iterator<Nodo<T>> i = ricerca.iterator();
		while (i.hasNext()) {
			s = s + i.next() + ", ";
		}
		return s.substring(0, s.length() - 2);

	}

	@Override
	public String toString() {
		if (size == 0)
			return "La catena è vuota";
		String s = "";
		for (int i = 1; i <= size; i++) {
			s = s + getIesimo(i) + ", ";
		}
		return s.substring(0, s.length() - 2);
	}

	public String sortedToString() {
		if (size == 0)
			return "La catena è vuota";
		String s = "";
		ArrayList<Nodo<T>> nodi = new ArrayList<>();
		for (int i = 1; i <= size; i++) {
			nodi.add(getIesimo(i));
		}
		nodi.sort((Nodo<T> a, Nodo<T> b) -> a.getChiave() - b.getChiave());
		// Possiamo usare questo ordinamento poiché è stabile
		Iterator<Nodo<T>> i = nodi.iterator();
		while (i.hasNext()) {
			s = s + i.next() + ", ";
		}
		return s.substring(0, s.length() - 2);
	}

	// Metodi helper

	public boolean esisteClone(int key, T info) {
		for (int i = 1; i <= size; i++) {
			Nodo<T> temp = getIesimo(i);
			if (temp.getChiave() == key && temp.getInfo().equals(info))
				return true;
		}
		return false;
	}

	public ArrayList<Nodo<T>> searchByKey(int key) {
		ArrayList<Nodo<T>> nodi = new ArrayList<>();
		if (head.getChiave() == key) {
			nodi.add(head);
			return nodi;
		}

		boolean trovato = false;

		for (int i = 1; i <= size / 2; i++) {

			if (i + 1 == size - i + 1 && getIesimo(i + 1).getChiave() == key) {

				nodi.add(getIesimo(i + 1));

				return nodi;
			}

			if (getIesimo(i + 1).getChiave() == key) {
				nodi.add(getIesimo(i + 1));
				trovato = true;
			}
			if (getIesimo(size - i + 1).getChiave() == key) {
				nodi.add(getIesimo(size - i + 1));
				trovato = true;
			}

			if (trovato)
				return nodi;
		}

		return new ArrayList<>();
	}
}
