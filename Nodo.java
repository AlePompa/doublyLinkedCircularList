// Alessandro Pompa Di Gregorio		Matricola: 7087766

public class Nodo<T> {
	private T info;
	private int chiave;
	private Nodo<T> succ;
	private Nodo<T> prec;

	public Nodo(T info, int chiave) {
		this.info = info;
		this.chiave = chiave;
	}

	public Nodo<T> getSucc() {
		return succ;
	}

	public void setSucc(Nodo<T> succ) {
		this.succ = succ;
	}

	public Nodo<T> getPrec() {
		return prec;
	}

	public void setPrec(Nodo<T> prec) {
		this.prec = prec;
	}

	public T getInfo() {
		return info;
	}

	public int getChiave() {
		return chiave;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[" + info + ", " + chiave+"]";
	}

}
