// Alessandro Pompa Di Gregorio		Matricola: 7087766

public class Main {

	public static void main(String[] args) {
		doppiaCatenaCircolare<String> C = new doppiaCatenaCircolare<>();
		System.out.println("\n---Creazione catena inizialmente vuota---\n");
		System.out.println(C);
		System.out.println("\n---Inserimento primo nodo---\n");
		C.insert(1, "a");
		System.out.println(C);
		System.out.println("\n---Quando c'è solo un nodo esso è il nodo HEAD---\n");
		System.out.println(C.getHead());
		System.out.println("\n---I suoi puntatori al successivo ed al precedente sono HEAD stesso---\n");
		System.out.println(C.getHead().getPrec() + "		" + C.getHead().getSucc());
		System.out.println("\n---L'inserimento dei nodi successivi avviene sempre tra HEAD ed il successivo a HEAD---\n");
		C.insert(2, "h");
		C.insert(5, "g");
		C.insert(6, "f");
		C.insert(9, "e");
		C.insert(5, "d");
		C.insert(3, "c");
		C.insert(2, "b");
		System.out.println(C);
		System.out.println("\n---L'inserimento di un nodo con stessa chiave e informazione di un nodo già presente non viene eseguito---\n");
		C.insert(1, "a");
		System.out.println("\n---L'inserimento di un nodo non avviene se la chiave non è consentita---\n");
		C.insert(0, "a");
		System.out.println("\n---Stampa dell'ordinamento dei nodi in base alla chiave---\n");
		System.out.println(C.sortedToString());
		System.out.println("\n---Stampa dell'ultimo nodo---\n");
		System.out.println(C.getTail());
		System.out.println("\n---Stampa del nodo in posizione i con i=3 (il primo nodo, ovvero HEAD, ha posizione 1)---\n");
		System.out.println(C.getIesimo(3));
		System.out.println("\n---Ricerca di nodi equidistanti da HEAD---\n");
		System.out.println(C.printSearchByKey(2));
		System.out.println("\n---Rimozione di nodi equidistanti da HEAD---\n");
		C.removeByKey(2);
		System.out.println(C);
		System.out.println("\n---Rimozione del nodo più vicino a HEAD---\n");
		C.removeByKey(5);
		System.out.println(C);
		System.out.println("\n---Rimozione di HEAD, il nuovo head diventa il successivo del vecchio head---\n");
		C.removeByKey(1);
		System.out.println(C);
		System.out.println("\n---Stampa dimensione della catena---\n");
		System.out.println(C.size());
		System.out.println("\n---Tentativo di ricerca del nodo i con i maggiore della dimensione della catena---\n");
		C.getIesimo(9);
	}

}
