package controller;

import java.io.IOException;

import Command.CopyShapeList;
import Command.RedoCommand;
import Command.SelectedShapeList;
import Command.ShapeList;
import Command.UndoCommand;
import Command.copyShapeCommand;
import Command.deleteShapeCommand;
import Command.pasteCommand;
import model.interfaces.IApplicationState;
import view.EventName;
import view.interfaces.IUiModule;

public class JPaintController implements IJPaintController {
    private final IUiModule uiModule;
    private final IApplicationState applicationState;
    SelectedShapeList selectedShape;
    CopyShapeList copyList;
    ShapeList shapelist;

    public JPaintController(IUiModule uiModule, IApplicationState applicationState,SelectedShapeList selectedShape, CopyShapeList copyList,ShapeList shapelist) {
        this.uiModule = uiModule;
        this.applicationState = applicationState;
        this.selectedShape=selectedShape;
        this.copyList= copyList;
        this.shapelist=shapelist;
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
				new copyShapeCommand(copyList,selectedShape).run();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
        uiModule.addEvent(EventName.PASTE,()->{
			try {
				new pasteCommand(copyList.size(), copyList,shapelist,applicationState,100).run();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
        uiModule.addEvent(EventName.DELETE,()->{
			try {
				new deleteShapeCommand(shapelist,selectedShape).run();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
    }
}
