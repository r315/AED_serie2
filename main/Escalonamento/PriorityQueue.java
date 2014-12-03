package Escalonamento;

public class PriorityQueue <E>{
	private E [] heap;
	private int heapsize;

	//	adiciona o elemento elem com prioridade prio e chave keyExtractor.getKey() à fila;
	public void add(E elem, int prio, KeyExtractor<E> keyExtractor){
		
		
	}	
	// retorna o elemento com maior prioridade presente na fila
	public E pick(){
		return heap[0];
	}
	// retorna e remove o elemento com maior prioridade presente na fila
	public E poll(){
		E aux = pick();
		heap[0] = heap[heapsize];
		HeapUtils.maxHeapify(heap,heapsize,0);
		heapsize--;		
		return aux;
	}
	// que atualiza a prioridade do elemento identicado pela chave key
	public void update(int key, int prio){
		
	}
	
	// remove o elemento identificado pela chave key.
	public void remove(int key){
		
	}
	
	// metodos max-priority-queue
	public void insert(E x){
		
	}
	
	public E extractMax(){		
		return null;
	}
	
	public E maximum(){
		return null;
	}
	
	public void increaseKey(E x, int key){
		
	}
	
	
}
