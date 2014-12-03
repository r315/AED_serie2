package Escalonamento;

public class Policy<E> implements KeyExtractor<E> {
	
	@Override
	public int getKey(E e) {
		// TODO Auto-generated method stub
		return 0;
	}
	

	public Policy(String p){
		switch(p){

		case "time":

			break;
		case "smallest":
			break;

		case "prio":

		default: break;

		}

	}
}
