package serie2;
//created by HR

import java.util.Iterator;
import java.util.NoSuchElementException;

/*public static <E> Iterable<E> distinct(Iterable<E> source, Predicate<E> criterion)
* que retorna uma sequ^encia com os elementos da sequ^encia ordenada source que obedecem ao predicado
* criterion, sem repetic~oes e com a ordem relativa preservada. Considere que, quaisquer que sejam os
* objectos o1 e o2, se o1.equals(o2) == true, ent~ao o resultado da aplicac~ao de criterion a o1 e o mesmo
* da aplicac~ao de criterion a o2.
*/ 
//TODO: BUG nas excepçoes?
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
							if(!criterion.evaluate(curr)) return false;
							if(curr.equals(prev)) curr = null;
						}						
						return true;
					}

					@Override
					public E next() {
						if(!hasNext()) 
							throw new NoSuchElementException();
						prev = curr;						
						curr = null;
						return prev;
					}

					@Override
					public void remove() {
						throw new UnsupportedOperationException();						
					}					
				};
			}			
		};	
	}	
}

			
		

	