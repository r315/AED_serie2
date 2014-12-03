package Escalonamento;

public class Process {
	private static enum Userclass { LOW, REGULAR, HIGH, SUPER };
	
	public int pid;
	public int ninstrucoes;
	public Userclass user;
	public int time;

}
