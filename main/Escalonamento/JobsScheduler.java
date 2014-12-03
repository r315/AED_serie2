package Escalonamento;

public class JobsScheduler {
	private static final String [] cmds = {"add","next","newpolicy","more"};
	public static void main(String []args){
		CommandLine cli = new CommandLine(cmds);
		
		if(args.length == 0){
    		System.out.println("Missing arguments!\n");
    		System.exit(1);
    	}
		
		
		Policy policy = new Policy(args[0]);
		
		CommandLine.Command cmd;
		
		while(true){
			cmd = cli.prompt();
			
			if(cmd == null)break;
			
			switch(cmd.name){
			case "add":
				break;
			case "next":
				break;
			case "newpolicy":
				policy = new Policy(cmd.getArgument(1));
				break;
			case "more":
				break;
			default: break;
			}

		}

    	
	}

}
