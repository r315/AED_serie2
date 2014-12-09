package serie2;
//created by HR

import java.util.Iterator;
import java.util.NoSuchElementException;

/*public static <E> Iterable<E> distinct(Iterable<E> source, Predicate<E> criterion)
* que retorna uma sequencia com os elementos da sequencia ordenada source que obedecem ao predicado
* criterion, sem repeticoes e com a ordem relativa preservada. Considere que, quaisquer que sejam os
* objectos o1 e o2, se o1.equals(o2) == true, entao o resultado da aplicacao de criterion a o1 e o mesmo
* da aplica	cao de criterion a o2.
*/ 
public class Iterables {	
	
	public static <E> Iterable<E> distinct(final Iterable<E> source, final Predicate<E> criterion){		
		return new Iterable<E>(){
			@Override
			public Iterator<E> iterator() {			
				return new Iterator<E>(){
					Iterator<E> it = source.iterator();
					E curr,prev;
					@Override
					public boolean hasNext() {
						while(curr == null){
							if(!it.hasNext()) return false;
							curr = it.next();
							if(!criterion.evaluate(curr) || curr.equals(prev)) 
								curr = null;								
						}						
						return true;
					}

					@Override
					public E next() {
						if(!hasNext()) 
							throw new NoSuchElementException("distinct:Iterator - no such element");
						prev = curr;						
						curr = null;
						return prev;
					}

					@Override
					public void remove() {
						throw new UnsupportedOperationException("distinct:Iterator - remove not supported");						
					}					
				};
			}			
		};	
	}
	
	/*
	 * que dada a sequencia representada pelo array nao ordenado de elementos, retorna um iteravel de pares com
	 * o histograma da sequencia. O algoritmo implementado deve usar uma tabela de dispersao para o calculo do
	 * histograma.
	 */	
		
	public static <E> Iterable<Pair<E, Integer>> histogram(final E [] array){
		final Pair<E, Integer> [] hashmap = (Pair<E, Integer>[]) new Pair[array.length + 10];
		
		for(int i = 0; i< array.length;i++){
			int m = hashmap.length;
			int h = array[i].hashCode() % m;
			int idx = (h < 0) ? h + m : h;
			Pair<E, Integer> x = new Pair<E, Integer>(array[i],idx);
			x.next = hashmap[idx];
			hashmap[idx] = x;			
		}	
		
		return (Iterable<Pair<E, Integer>>) new Iterable<Pair<E, Integer>>(){
			@Override
			public Iterator<Pair<E, Integer>> iterator() {				
				return new Iterator<Pair<E,Integer>>(){
					int idx = 0;
					Pair <E,Integer> curr = null;
					@Override
					public boolean hasNext() {	
						System.out.println("chama hasnext " + curr);
						while(curr == null){							
							if(hashmap[idx] != null){
								curr = hashmap[idx];								
							}							
							if((++idx) == hashmap.length) return false; 
						}
						return true;
					}

					@Override
					public Pair<E, Integer> next() {
						System.out.println("chama next");
						if(!hasNext()) 
							throw new NoSuchElementException("No such element");
						Pair <E,Integer> aux = curr;
						curr = curr.next;
						return aux;
					}

					@Override
					public void remove() {
						throw new UnsupportedOperationException("distinct:Iterator - remove not supported");
						
					}
					
				};
			}			
		};
	}
}

			
		

	