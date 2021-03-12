package Command;

import java.io.IOException;

import Shape.*;

public class copyShapeCommand implements Icommand, IUndoable {
	repository selectshaperepository;
	repository coyshaperepository;

	public copyShapeCommand( repository selectshaperepository,repository coyshaperepository) {
		super();
		
		this.selectshaperepository=selectshaperepository;
		this.coyshaperepository=coyshaperepository;
		CommandHistory.add(this);
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		coyshaperepository.clear();
		
	}

	@Override
	public void redo() {
		// TODO Auto-generated method stub
		try {
			run();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() throws IOException {
		// TODO Auto-generated method stub
		coyshaperepository.addlist(selectshaperepository);
		System.out.println(coyshaperepository.list());
		

	}

}
