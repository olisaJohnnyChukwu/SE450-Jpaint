package controller;

import java.io.IOException;

import Command.*;

import model.interfaces.IApplicationState;
import view.EventName;
import view.interfaces.IUiModule;
import view.interfaces.PaintCanvasBase;

public class JPaintController implements IJPaintController {
    private final IUiModule uiModule;
    private final IApplicationState applicationState;
   
    repository shaperepository;
	repository selectshaperepository;
	repository coyshaperepository;
	PaintCanvasBase canvas;

    public JPaintController(IUiModule uiModule, IApplicationState applicationState,repository shaperepository, repository selectshaperepository,repository coyshaperepository,PaintCanvasBase canvas) {
		super();
		this.uiModule = uiModule;
		this.applicationState = applicationState;
		this.shaperepository = shaperepository;
		this.selectshaperepository = selectshaperepository;
		this.coyshaperepository=coyshaperepository;
		this.canvas=canvas;
	}

	

    @Override
    public void setup() {
        setupEvents();
    }

    private void setupEvents() {
        uiModule.addEvent(EventName.CHOOSE_SHAPE, () -> applicationState.setActiveShape());
        uiModule.addEvent(EventName.CHOOSE_PRIMARY_COLOR, () -> applicationState.setActivePrimaryColor());
        uiModule.addEvent(EventName.CHOOSE_SECONDARY_COLOR, () -> applicationState.setActiveSecondaryColor());
        uiModule.addEvent(EventName.CHOOSE_SHADING_TYPE, () -> applicationState.setActiveShadingType());
        uiModule.addEvent(EventName.CHOOSE_MOUSE_MODE, () -> applicationState.setActiveStartAndEndPointMode());
        uiModule.addEvent(EventName.UNDO,()->{
			try {
				new UndoCommand().run();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
        uiModule.addEvent(EventName.REDO,()->{
			try {
				new RedoCommand().run();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
        uiModule.addEvent(EventName.COPY,()->{
			try {
				new copyShapeCommand(selectshaperepository, coyshaperepository).run();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
        uiModule.addEvent(EventName.PASTE,()->{
			try {
				new pasteCommand(applicationState,150, shaperepository, coyshaperepository).run();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
        uiModule.addEvent(EventName.DELETE,()->{
			try {
				new deleteShapeCommand( shaperepository, selectshaperepository).run();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
        uiModule.addEvent(EventName.GROUP,()->{
			try {
				//new deleteShapeCommand(shapelist,selectedShape).run();
				new groupCommand(shaperepository, selectshaperepository,canvas).run();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
        uiModule.addEvent(EventName.UNGROUP,()->{
			try {
				//new deleteShapeCommand(shapelist,selectedShape).run();
				new ungroupCommand(shaperepository,selectshaperepository,canvas).run();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
        
    }
}
