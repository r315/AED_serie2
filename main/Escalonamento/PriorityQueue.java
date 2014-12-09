package Escalonamento;

import HashTables.HashNode;
import Heaps.HeapNode;
import static Heaps.HeapUtils.*;


public class PriorityQueue <E>{
	private static final int MAX_ELEMENTS = 10;
	private HeapNode<E> [] heap;
	private HashNode<E>[] hmap;	
	private int heapsize;

	//	adiciona o elemento elem com prioridade prio e chave keyExtractor.getKey() à fila;
	public void add(E elem, int prio, KeyExtractor<E> keyExtractor){
		HeapNode<E> x = new HeapNode<E>(elem, prio, keyExtractor);
		heap[heapsize] = x;
		heapsize++;
		maxHeapify(heap,heapsize,heapsize-1);
		
	}	
	// retorna o elemento com maior prioridade presente na fila
	public E pick(){
		return heap[0].elem;
	}
	// retorna e remove o elemento com maior prioridade presente na fila
	public E poll(){
		E aux = pick();
		heap[0] = heap[heapsize];
		maxHeapify(heap,heapsize,0);
		heapsize--;		
		return aux;
	}
	// que atualiza a prioridade do elemento identicado pela chave key
	public void update(int key, int prio){
		
	}
	
	// remove o elemento identificado pela chave key.
	public void remove(int key){
		
	}	
	public PriorityQueue(){
		 heapsize = MAX_ELEMENTS;
		 heap = (HeapNode<E>[]) new HeapNode[heapsize];
		 hmap = new HashNode[MAX_ELEMENTS];
	 }
}
