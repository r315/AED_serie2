package Escalonamento;

public class HeapUtils<E extends Comparable<E>> {
	
	
	// operaçoes base de heaps
		public int parent(int idx){ return (idx-1)/2;}
		public int left(int idx){ return (2*idx)+1;}
		public int right(int idx){return (2*idx)+2;}
		
		public void maxHeapify(E[] heap,int heapsize, int idx){
			int l = left(idx);
			int r = right(idx);
			int largest;
			if (l < heapsize && ( heap[l]).compareTo( heap[idx]) > 0)
				largest = l;
			else largest = idx;
			if (r < heapsize && heap[r].compareTo(heap[largest]) > 0)
				largest = r;
			if (largest != idx) {
				exchange(heap, idx, largest);
				maxHeapify(heap, heapsize, largest);
			}
		}
		
		private void exchange(E [] heap,int a, int b){
			E x = heap[a];
			heap[a] = heap[b];
			heap[b] = x;
		}
}
