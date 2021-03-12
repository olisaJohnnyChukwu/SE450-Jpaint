package main;

import controller.IJPaintController;
import controller.JPaintController;
import model.ShapeType;
import model.persistence.ApplicationState;
import view.gui.Gui;
import view.gui.GuiWindow;
import view.gui.PaintCanvas;
import view.interfaces.IGuiWindow;
import view.interfaces.PaintCanvasBase;
import view.interfaces.IUiModule;

import java.awt.*;
import java.util.ArrayList;

import ClickHandler.clickHandler;

import Command.copylistrepo;
import Command.repository;
import Command.selectshaperepo;
import Command.shapelistrepo;
import Shape.Ishape;

public class Main {
    public static void main(String[] args){
    	
        PaintCanvasBase paintCanvas = new PaintCanvas();
        repository shaperepository= new shapelistrepo(new ArrayList<Ishape>(), paintCanvas);
        repository selectshaperepository= new selectshaperepo(new ArrayList<Ishape>(), paintCanvas);
        repository coyshaperepository= new copylistrepo(new ArrayList<Ishape>(), paintCanvas);
         IGuiWindow guiWindow = new GuiWindow(paintCanvas);
        IUiModule uiModule = new Gui(guiWindow);
        ApplicationState appState = new ApplicationState(uiModule);
        IJPaintController controller = new JPaintController(uiModule, appState,shaperepository,selectshaperepository,coyshaperepository,paintCanvas);
        controller.setup();

        // For example purposes only; remove all lines below from your final project.

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        paintCanvas.addMouseListener(new clickHandler(paintCanvas,appState, shaperepository,selectshaperepository));
       
       
    }
}
