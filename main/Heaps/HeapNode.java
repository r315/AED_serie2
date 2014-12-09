package Heaps;

import Escalonamento.KeyExtractor;


public class HeapNode <E>{
	public E elem;
	public int prio;
	public KeyExtractor<E> ke;
	public HeapNode(E e, int p, KeyExtractor<E> kye){
		elem = e;
		prio = p;
		ke = kye;
	}
}
