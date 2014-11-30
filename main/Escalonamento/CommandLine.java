package Escalonamento;

import java.util.Scanner;


/**
 * Created by HR on 30/11/14.
 */
public class CommandLine {
	public static final String EXIT_COMMAND = "exit";
	public static final String PROMPT = "Scheduler >"; 
	public static final String INVALID_COMMAND = "Comando Invalido";
	public Command [] commands;
	public Scanner in; 
		
	public int wordCount(String s){
	    if (s == null)return 0;
	     return s.trim().split("\\s+").length;
	}
	
	public String getArgument(String s, int a){
		if (s == null)return null;
		String []tmp = s.split(" "); 
		return tmp[a];
	}
	
	public void loop(){
		boolean loop = true;
		String fullcmd, cmd;
		while(loop){
			System.out.print(PROMPT);			
			fullcmd = get();
			cmd = getArgument(fullcmd,0);
			loop = execute(cmd);
		}
	}
	
	public String get(){		
		String userinput = in.nextLine();
		return userinput;
	}
	
	public boolean execute(String cmd){		
		if(cmd.compareTo(EXIT_COMMAND) == 0)
			return false;		
		
		Command selected_command = null;		
		for(int i = 0; i < commands.length; i++)
			if(commands[i].compareTo(cmd) == 0){
				selected_command = commands[i];
				break;
			}					
			
		if(selected_command == null)
			System.out.println("["+cmd+"] " + INVALID_COMMAND);
		else
			System.out.println("pede parametros");
		
		return true;
	}

	
	public CommandLine(){	
		commands = new Command[5];		
		commands[0] = new Command("add",3);
		commands[1] = new Command("next",0);
		commands[2] = new Command("newpolicy",1);
		commands[3] = new Command("more",2);
		in = new Scanner(System.in);		
	}
	
	private class Command{
		public String name;
		public int arg;	
		public Command(String n, int a){
			name = n;
			arg = a;
		}		
		public int compareTo(String c) {
			return name.compareTo(c);
		}
		
		
	}
}
