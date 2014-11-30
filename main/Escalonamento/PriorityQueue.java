package Escalonamento;

public class PriorityQueue <E>{
	private HeapElement [] heap;
	private int heapsize;

	//	adiciona o elemento elem com prioridade prio e chave keyExtractor.getKey() à fila;
	public void add(E elem, int prio, KeyExtractor<E> keyExtractor){
		HeapElement x = new HeapElement();
		x.elem = elem;
		x.prio = prio;
		x.keyextractor = keyExtractor;
		insert(x);		
	}
	
	// retorna o elemento com maior prioridade presente na fila
	public E pick(){
		return null;
	}
	// retorna e remove o elemento com maior prioridade presente na fila
	public E poll(){
		return null;
	}
	// que atualiza a prioridade do elemento identicado pela chave key
	public void update(int key, int prio){
		
	}
	
	// remove o elemento identificado pela chave key.
	public void remove(int key){
		
	}
	
	// metodos max-priority-queue
	public void insert(HeapElement x){
		
	}
	
	public HeapElement extractMax(){		
		return null;
	}
	
	public HeapElement maximum(){
		return null;
	}
	
	public void increaseKey(HeapElement x, int key){
		
	}
	
	// operaçoes base de heaps
	public int parent(int idx){ return (idx-1)/2;}
	public int left(int idx){ return (2*idx)+1;}
	public int right(int idx){return (2*idx)+2;}
	public void maxHeapify(int idx){
		int l = left(idx);
		int r = right(idx);
		int largest;
		if (l < heapsize && heap[l].prio > heap[idx].prio)
			largest = l;
		else largest = idx;
		if (r < heapsize && heap[r].prio > heap[largest].prio)
			largest = r;
		if (largest != idx) {
			exchange(idx, largest);
			maxHeapify(largest);
		}
	}
	
	private void exchange(int a, int b){
		HeapElement x = heap[a];
		heap[a] = heap[b];
		heap[b] = x;
	}
	
	
	private class HeapElement{
		public E elem;
		public int prio;
		public KeyExtractor keyextractor;		
	}
}
