package serie2;
// Created By HR

import java.util.Comparator;

public class ListUtils {
/**
 * public static <E> void internalReverse(Node<Node<E>> list)
 * que dada as listas duplamente ligadas, n~ao circulares e sem sentinela, presentes em list, inverte a ordem
 * dos seus elementos respectivos. Note que list e tambem uma lista duplamente ligada n~ao circular e sem
 * sentinela. Por exemplo, no caso da lista list ser denida por ff1; 2; 3g; f4; 7; 6g; f3; 1; 2; 4gg, o metodo
 * devera transformar a lista list em ff3; 2; 1g; f6; 7; 4g; f4; 2; 1; 3gg.
 * 
 */
 	public static <E> void internalReverse(Node<Node<E>> list){
 		Node<Node<E>> curr = list;
 		while(curr != null){
 			Node <E> sublist = curr.value; 			
 			while( sublist!= null){
 				Node<E> tmp = sublist.next;
 				sublist.next = sublist.previous;
 				sublist.previous = tmp;
 				if(tmp == null)
 					curr.value = sublist;
 				sublist = tmp;
 			} 			
 			curr = curr.next;
 		} 			
	}		
	/**
	 * public static <E> Node<E> intersection(Node<E> list1, Node<E> list2, Comparator<E> cmp)
	 * que, dadas as listas duplamente ligadas, circulares e com sentinela, referenciadas por list1 e list2, e
	 * ordenadas de modo crescente segundo o comparador cmp, retorna uma lista com os elementos que estejam
	 * simultaneamente presentes em list1 e list2, removendo-os em ambas as listas. A lista retornada devera
	 * ser duplamente ligada,n~ao circular e sem sentinela, ordenada de modo crescente. Deve ainda reutilizar
	 * os nos de uma das listas (list1 ou list2) e n~ao pode conter elementos repetidos.
	 */
	public static <E> Node<E> intersection(Node<E> list1, Node<E> list2, Comparator<E> cmp){
		Node <E> res = new Node <E>();
		Node <E> curr1, curr2;
		curr1 = list1.next;
		curr2 = list2.next;
		res = null;
		
		while(list1 != curr1 && list2 != curr2){
			if(cmp.compare(curr1.value, curr2.value) > 0){
				curr2 = curr2.next;
				continue;
			}
			if(cmp.compare(curr1.value, curr2.value) < 0){
				curr1 = curr1.next;
				continue;
			}
			//ao chegar neste ponto estamos perante um Nó 
			//presente nas duas listas que tem de ser removido
			curr1.previous.next = curr1.next;
			curr1.next.previous = curr1.previous;
			curr2.previous.next = curr2.next;
			curr2.next.previous = curr2.previous;				
			//e inserido no fim da lista res			
			Node <E> aux = curr1.next; 
			if(res == null){ //1º no da lista
				res = curr1;
				res.previous = null;
				res.next = null;
			}
			else// sem repetiçoes
				if(cmp.compare(curr1.value, res.value) != 0){
					curr1.previous = res;
					curr1.next = null;
					res.next = curr1;
					res = curr1;
				}
			//avança para o proximo no das duas listas
			curr1 = aux;
			curr2 = curr2.next;
		}
		// retroce ate ao inicio da lista
		if(res != null)
			while(res.previous != null)
				res = res.previous;
		//TODO: confirmar se as listas passadas como parametro devem ou não conter elementos repetidos
		removeDuplicates(list1,cmp);
		removeDuplicates(list2,cmp);		
		return res;
	}

	public static <E> void printListWithSentinel(Node<E> list){
 		Node <E> tmp = list.next; 
 		while(tmp != list){
 			System.out.print(tmp.value+",");
 			tmp = tmp.next;
 		}
 		System.out.println("");
 	}
 	
 	public static <E> void printListWithoutSentinel(Node<E> list){
 		Node <E> tmp = list; 
 		System.out.print("Res = ");
 		while(tmp != null){
 			System.out.print(tmp.value+",");
 			tmp = tmp.next;
 		}
 		System.out.println("\n");
 	}
 	
 	public static <E> void removeDuplicates(Node<E> list,Comparator<E> cmp){
 		Node <E> curr = list.next; 
 		while(curr.next != list){ 			
 			if(cmp.compare(curr.value, curr.next.value) == 0){
 				curr.previous.next = curr.next;
 				curr.next.previous = curr.previous;
 			}
 			curr = curr.next; 			
 		}
 		
 	}
}
