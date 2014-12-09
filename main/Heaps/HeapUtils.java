package Heaps;

public class HeapUtils<E> {
	
	
	// operaçoes base de heaps
		public static int parent(int idx){ return (idx-1)/2;}
		public static int left(int idx){ return (2*idx)+1;}
		public static int right(int idx){return (2*idx)+2;}
		
		public static <E> void maxHeapify(HeapNode<E>[] heap,int heapsize, int idx){
			int l = left(idx);
			int r = right(idx);
			int largest;
			if (l < heapsize && ( heap[l].prio > heap[idx].prio))
				largest = l;
			else largest = idx;
			if (r < heapsize && (heap[r].prio > heap[largest].prio))
				largest = r;
			if (largest != idx) {
				exchange(heap, idx, largest);
				maxHeapify(heap, heapsize, largest);
			}
		}
		
		private static <E>void exchange(HeapNode<E>[] heap,int a, int b){
			HeapNode<E> x = heap[a];
			heap[a] = heap[b];
			heap[b] = x;
		}
}
