package Command;

import java.io.IOException;

public class RedoCommand implements Icommand{

	@Override
	public void run() throws IOException {
		// TODO Auto-generated method stub
		CommandHistory.redo();
		
	}

}
