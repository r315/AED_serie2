package Escalonamento;

public class JobsScheduler {
	
	public static void main(String []args){
		CommandLine cli = new CommandLine();
		if(args.length == 0){
    		System.out.println("Missing arguments!\n");
    		System.exit(1);
    	}
    	cli.loop();
	}

}
