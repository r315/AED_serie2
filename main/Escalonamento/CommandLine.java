package Escalonamento;

import java.util.Scanner;


/**
 * Created by HR on 30/11/14.
 * aguarda por um comando valido e retorna uma instancia de 
 * Command com o nome e parametros,null no caso de exit
 */
public class CommandLine {
	public static final String EXIT_COMMAND = "exit";
	public static final String PROMPT = "Scheduler >"; 
	public static final String INVALID_COMMAND = "Comando Invalido";
	public Command [] commands;
	public Scanner in; 
		
	/*public int wordCount(String s){
	    if (s == null)return 0;
	     return s.trim().split("\\s+").length;
	}*/
	
	public String getArgument(String s, int a){
		if (s == null)return null;
		String []tmp = s.split(" "); 
		return tmp[a];
	}
	
	public Command prompt(){
		boolean loop = true;
		String fullcmd, cmd;
		Command selected_command = null;	
		
		while(loop){
			System.out.print(PROMPT);			
			fullcmd = in.nextLine();
			cmd = getArgument(fullcmd,0);			
			
			if(cmd.compareTo(EXIT_COMMAND) == 0)
				break;				
			
			for(int i = 0; i < commands.length; i++)
				if(commands[i].compareTo(cmd) == 0){
					selected_command = commands[i];
					break;
				}					
				
			if(selected_command == null)
				System.out.println("["+cmd+"] " + INVALID_COMMAND);
			else{
				selected_command.setArguments(fullcmd);
				loop = false;
			}
			
		}
		return selected_command;
	}	
	
	public CommandLine(String [] cmds){	
		commands = new Command[cmds.length];		
		for(int i = 0; i< cmds.length; i++ )
			commands[i]=new Command(cmds[i]);		
		in = new Scanner(System.in);		
	}
	
	public class Command{
		public String name;
		private String[] arg;	
		public Command(String n){
			name = n;			
		}		
		public int compareTo(String c) {
			return name.compareTo(c);
		}
		
		public void setArguments(String args){
			arg = args.split(" "); 
		}
		
		public String getArgument(int a){
			return arg[a];
		}
	}
}
