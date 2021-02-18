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

import ClickHandler.clickHandler;
import Command.CopyShapeList;
import Command.SelectedShapeList;
import Command.ShapeList;

public class Main {
    public static void main(String[] args){
        PaintCanvasBase paintCanvas = new PaintCanvas();
        ShapeList shapelist= new ShapeList(paintCanvas);
        SelectedShapeList selectedShape=new SelectedShapeList();
        CopyShapeList copyList=new CopyShapeList();
        IGuiWindow guiWindow = new GuiWindow(paintCanvas);
        IUiModule uiModule = new Gui(guiWindow);
        ApplicationState appState = new ApplicationState(uiModule);
        IJPaintController controller = new JPaintController(uiModule, appState,selectedShape,copyList,shapelist);
        controller.setup();

        // For example purposes only; remove all lines below from your final project.

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        paintCanvas.addMouseListener(new clickHandler(paintCanvas,shapelist,appState,selectedShape));
        Graphics2D graphics2d = paintCanvas.getGraphics2D();
        graphics2d.drawOval(10, 15, 100, 200);
        /*graphics2d.setColor(Color.WHITE);
        graphics2d.fillRect(0, 0, paintCanvas.getWidth(), paintCanvas.getHeight());*/
        

        // Filled in rectangle
      /*  Graphics2D graphics2d = paintCanvas.getGraphics2D();
        graphics2d.setColor(Color.GREEN);
        graphics2d.fillRect(12, 13, 200, 400);

        // Outlined rectangle
        graphics2d.setStroke(new BasicStroke(5));
        graphics2d.setColor(Color.BLUE);
        graphics2d.drawRect(12, 13, 200, 400);

        // Selected Shape
        Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
        graphics2d.setStroke(stroke);
        graphics2d.setColor(Color.BLACK);
        graphics2d.drawRect(7, 8, 210, 410);*/
    }
}
