package Command;

import java.io.IOException;

public class UndoCommand implements Icommand {
	//take shape list
	
	@Override
	public void run() throws IOException {
		// TODO Auto-generated method stub
		//if shape.command == create
		
		CommandHistory.undo();
	}

}
