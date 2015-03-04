/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.opensim.view;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.ListIterator;
import org.opensim.modeling.ArrayDecorativeGeometry;
import org.opensim.modeling.Component;
import org.opensim.modeling.DecorativeBrick;
import org.opensim.modeling.DecorativeCircle;
import org.opensim.modeling.DecorativeCylinder;
import org.opensim.modeling.DecorativeEllipsoid;
import org.opensim.modeling.DecorativeFrame;
import org.opensim.modeling.DecorativeGeometry;
import org.opensim.modeling.DecorativeGeometryImplementation;
import org.opensim.modeling.DecorativeLine;
import org.opensim.modeling.DecorativeMesh;
import org.opensim.modeling.DecorativeMeshFile;
import org.opensim.modeling.DecorativePoint;
import org.opensim.modeling.DecorativeSphere;
import org.opensim.modeling.DecorativeText;
import org.opensim.modeling.Model;
import org.opensim.modeling.ModelDisplayHints;
import org.opensim.modeling.OpenSimObject;
import org.opensim.view.pub.GeometryFileLocator;
import vtk.vtkActor;
import vtk.vtkAssembly;

/**
 *
 * @author Ayman, a Java implementation of DecorativeGeometryImplementation to be used by GUI
 */
public class DecorativeGeometryImplementationGUI extends DecorativeGeometryImplementation {
  int unused =0;
  private vtkAssembly modelAssembly;
  HashMap<Integer, BodyDisplayer> mapBodyIndicesToDisplayers;
  private Model model;
  String modelFilePath;
  private Component currentComponent=null;
  // Two maps one for Fixed geometry other for Variable geometry
  HashMap<Component, LinkedList<DecorativeGeometryDisplayer>> mapComponentsToFixedVisuals = new HashMap<Component, LinkedList<DecorativeGeometryDisplayer>>();
  HashMap<Component, LinkedList<DecorativeGeometryDisplayer>> mapComponentsToVariableVisuals = new HashMap<Component, LinkedList<DecorativeGeometryDisplayer>>();
  HashMap<vtkActor, OpenSimObject> mapVisualsToObjects = new HashMap<vtkActor, OpenSimObject>();
  
  LinkedList<DecorativeGeometryDisplayer> currentFixedGeometryDisplayers;
  LinkedList<DecorativeGeometryDisplayer> currentVariableGeometryDisplayers;
  private ModelDisplayHints modelDisplayHints;
  private boolean updateMode = false;
  private boolean processingVariableGeometry = false;
  public DecorativeGeometryImplementationGUI() {
      // Default constructor
      unused = 1;
      
  }
    @Override
  public void implementPointGeometry(DecorativePoint arg0) {
    System.out.println("Type: DecorativePoint Unsupported");
    //opensimModelJNI.DecorativeGeometryImplementation_implementPointGeometry(swigCPtr, this, DecorativePoint.getCPtr(arg0), arg0);
  }

    @Override
  public void implementLineGeometry(DecorativeLine arg0) {

    if (updateMode) { //// System.out.println("updating");
            updateDecorativeGeometryDisplayer(arg0);
    } else {
        BodyDisplayer bd = mapBodyIndicesToDisplayers.get(arg0.getBodyId());
        //System.out.println("MC:"+currentComponent.getConcreteClassName()+currentComponent.getName());
        DecorativeLineDisplayer lineDisplayer=new DecorativeLineDisplayer(arg0);
        bd.AddPart(lineDisplayer.getVisuals());
        addDisplayerToCurrentList(lineDisplayer);
        mapVisualsToObjects.put(lineDisplayer.getVisuals(), currentComponent);
    }
  }

    private void addDisplayerToCurrentList(DecorativeGeometryDisplayer lineDisplayer) {
        if (processingVariableGeometry)
            currentVariableGeometryDisplayers.add(lineDisplayer);
        else
            currentFixedGeometryDisplayers.add(lineDisplayer);
    }

    @Override
  public void implementBrickGeometry(DecorativeBrick arg0) {
    //System.out.println("Type: DecorativeBrick");
        if (updateMode) { 
            updateDecorativeGeometryDisplayer(arg0);
        } else {
            BodyDisplayer bd = mapBodyIndicesToDisplayers.get(arg0.getBodyId());
            DecorativeBrickDisplayer brickDisplayer=new DecorativeBrickDisplayer(arg0);
            bd.AddPart(brickDisplayer.getVisuals());
            addDisplayerToCurrentList(brickDisplayer);
            mapVisualsToObjects.put(brickDisplayer.getVisuals(), currentComponent);           
            //mapBodyIndicesToDisplayers.put(arg0.getUserRefAsObject(), brickDisplayer);
        }    
    //mapBodyIndicesToDisplayers.put(arg0.getUserRefAsObject(), brickDisplayer);
  }

    protected void updateDecorativeGeometryDisplayer(DecorativeGeometry arg0) {
        // System.out.println("updating");
        ListIterator<DecorativeGeometryDisplayer> listIterator = getCurrentGeometryDisplayers();
        boolean found = false;
        while (listIterator.hasNext() && !found) {
            DecorativeGeometryDisplayer displayer = listIterator.next();
            if (displayer.getBodyId() == arg0.getBodyId()
                    && displayer.getIndexOnBody() == arg0.getIndexOnBody()) {
                displayer.updateGeometry(arg0);
                displayer.copyAttributesFromDecorativeGeometry(arg0);
                found = true;
                displayer.Modified();
            }
        }
    }

    @Override
  public void implementCylinderGeometry(DecorativeCylinder arg0) {
        if (updateMode) { 
            updateDecorativeGeometryDisplayer(arg0);
        } else {
            BodyDisplayer bd = mapBodyIndicesToDisplayers.get(arg0.getBodyId());
            DecorativeCylinderDisplayer cylDisplayer = new DecorativeCylinderDisplayer(arg0);
            bd.AddPart(cylDisplayer.getVisuals());
            addDisplayerToCurrentList(cylDisplayer);
            mapVisualsToObjects.put(cylDisplayer.getVisuals(), currentComponent);
            //mapBodyIndicesToDisplayers.put(arg0.getUserRefAsObject(), brickDisplayer);
        }
    }

    private ListIterator<DecorativeGeometryDisplayer> getCurrentGeometryDisplayers() {
        ListIterator<DecorativeGeometryDisplayer> listIterator = (processingVariableGeometry?
            currentVariableGeometryDisplayers.listIterator() : currentFixedGeometryDisplayers.listIterator());
        return listIterator;
    }

    @Override
  public void implementCircleGeometry(DecorativeCircle arg0) {
    System.out.println("Type: DecorativeCircle Unsupported");
    //opensimModelJNI.DecorativeGeometryImplementation_implementCircleGeometry(swigCPtr, this, DecorativeCircle.getCPtr(arg0), arg0);
  }

    @Override
  public void implementSphereGeometry(DecorativeSphere arg0) {
        //System.out.println("Type: DecorativeSphere Radius, transform, Body, index "
        //        + arg0.getRadius() + ", [" + arg0.getTransform().T().toString() + "]"+ arg0.getBodyId()+", "+arg0.getIndexOnBody());
        
        if (updateMode) { 
            updateDecorativeGeometryDisplayer(arg0);
        } else {
            BodyDisplayer bd = mapBodyIndicesToDisplayers.get(arg0.getBodyId());
            DecorativeSphereDisplayer sphereDisplayer = new DecorativeSphereDisplayer(arg0);
            bd.AddPart(sphereDisplayer.getVisuals());
            addDisplayerToCurrentList(sphereDisplayer);
            mapVisualsToObjects.put(sphereDisplayer.getVisuals(), currentComponent);
            //mapBodyIndicesToDisplayers.put(arg0.getUserRefAsObject(), sphereDisplayer);
        }
    }

    @Override
  public void implementEllipsoidGeometry(DecorativeEllipsoid arg0) {
    //System.out.println("Type: DecorativeEllipsoid");
    if (updateMode){ 
        updateDecorativeGeometryDisplayer(arg0);
    }
    else {
    //opensimModelJNI.DecorativeGeometryImplementation_implementEllipsoidGeometry(swigCPtr, this, DecorativeEllipsoid.getCPtr(arg0), arg0);
        BodyDisplayer bd = mapBodyIndicesToDisplayers.get(arg0.getBodyId());
        DecorativeEllipsoidDisplayer ellipsoidDisplayer=new DecorativeEllipsoidDisplayer(arg0);
        bd.AddPart(ellipsoidDisplayer.getVisuals());
        addDisplayerToCurrentList(ellipsoidDisplayer);
        mapVisualsToObjects.put(ellipsoidDisplayer.getVisuals(), currentComponent);
    }
    //mapBodyIndicesToDisplayers.put(arg0.getUserRefAsObject(), displayer);
  }

    @Override
  public void implementFrameGeometry(DecorativeFrame arg0) {
    //System.out.println("Type: DecorativeFrame"+arg0.getIndexOnBody());
    if (updateMode){ 
        updateDecorativeGeometryDisplayer(arg0);
    }
    else {
        BodyDisplayer bd = mapBodyIndicesToDisplayers.get(arg0.getBodyId());
        DecorativeFrameDisplayer frameDisplayer=new DecorativeFrameDisplayer(arg0);
        bd.AddPart(frameDisplayer.getVisuals());
        addDisplayerToCurrentList(frameDisplayer);
        mapVisualsToObjects.put(frameDisplayer.getVisuals(), currentComponent);
        //opensimModelJNI.DecorativeGeometryImplementation_implementFrameGeometry(swigCPtr, this, DecorativeFrame.getCPtr(arg0), arg0);
    }
  }

    @Override
  public void implementTextGeometry(DecorativeText arg0) {
    System.out.println("Type: DecorativeText is unsupported");
    //opensimModelJNI.DecorativeGeometryImplementation_implementTextGeometry(swigCPtr, this, DecorativeText.getCPtr(arg0), arg0);
  }

    @Override
  public void implementMeshGeometry(DecorativeMesh arg0) {
    System.out.println("Type: DecorativeMesh is unsupported");
    //opensimModelJNI.DecorativeGeometryImplementation_implementMeshGeometry(swigCPtr, this, DecorativeMesh.getCPtr(arg0), arg0);
  }
    @Override
  public void implementMeshFileGeometry(DecorativeMeshFile arg0) {

     if (updateMode){ 
         updateDecorativeGeometryDisplayer(arg0);
    }
    else {
       BodyDisplayer bd = mapBodyIndicesToDisplayers.get(arg0.getBodyId());
        String fullFileName = GeometryFileLocator.getInstance().getFullname(modelFilePath,arg0.getMeshFile(), false);
        if (fullFileName==null) return;
        DecorativeMeshFileDisplayer meshDisplayer=new DecorativeMeshFileDisplayer(arg0, modelFilePath);
        bd.AddPart(meshDisplayer.getVisuals());
        addDisplayerToCurrentList(meshDisplayer);
        mapVisualsToObjects.put(meshDisplayer.getVisuals(), currentComponent);
     }
    //mapBodyIndicesToDisplayers.put(arg0.getUserRefAsObject(), meshDisplayer);
  }

    /**
     * @return the modelAssembly
     */
    public vtkAssembly getModelAssembly() {
        return modelAssembly;
    }

    /**
     * @param modelAssembly the modelAssembly to set
     */
    public void setModelAssembly(vtkAssembly modelAssembly, 
            HashMap<Integer, BodyDisplayer> mapBodyIndicesToDisplayers,
            Model model, ModelDisplayHints mdh) {
        this.modelAssembly = modelAssembly;
        this.mapBodyIndicesToDisplayers = mapBodyIndicesToDisplayers;
        this.model = model;
        this.modelFilePath=model.getFilePath();
        this.modelDisplayHints = mdh;
    }

    /**
     * @return the currentComponent
     */
    public Component getCurrentComponent() {
        return currentComponent;
    }

    /**
     * @param currentComponent the currentComponent to set
     */
    public void setCurrentComponent(Component currentComponent) {
        this.currentComponent = currentComponent;
        if (!updateMode){
            currentFixedGeometryDisplayers = new LinkedList<DecorativeGeometryDisplayer>();
            currentVariableGeometryDisplayers = new LinkedList<DecorativeGeometryDisplayer>();
        }
        else{
            currentFixedGeometryDisplayers = mapComponentsToFixedVisuals.get(currentComponent);
            currentVariableGeometryDisplayers = mapComponentsToVariableVisuals.get(currentComponent);
            
        }
        
    }
   
    public void finishCurrentComponent(Component currentComponent) {
        mapComponentsToFixedVisuals.put(currentComponent, currentFixedGeometryDisplayers);
        mapComponentsToVariableVisuals.put(currentComponent, currentVariableGeometryDisplayers);
        this.currentComponent = null;
   }

    void selectObject(OpenSimObject openSimObject) {
        LinkedList<DecorativeGeometryDisplayer> visuals = mapComponentsToFixedVisuals.get(Component.safeDownCast(openSimObject));
        if (visuals!=null){
            int sz = visuals.size();
            for(int i=0; i<sz; i++){
                visuals.get(i).GetProperty().SetColor(SelectedObject.defaultSelectedColor);
                visuals.get(i).Modified();
            }
        }
    }

    OpenSimObject pickObject(vtkActor GetViewProp) {
        return mapVisualsToObjects.get(GetViewProp);
    }

    public void updateDecorations(Component mc) {
        updateDecorations(mc, false);
    }
    
    public void updateDecorations(Component mc, boolean varGeometryOnly) {
        updateMode = true;
        
        if (!varGeometryOnly)
            updateFixedDecorations(mc);
        startVariableGeometry();
        updateVariableDecorations(mc);
        finishVariableGeometry();
        updateMode = false;
    }

    private void updateFixedDecorations(Component mc) {
        ArrayDecorativeGeometry adg = new ArrayDecorativeGeometry();
        mc.generateDecorations(true, modelDisplayHints, model.getWorkingState(), adg);
        // Sync. 
        currentFixedGeometryDisplayers = mapComponentsToFixedVisuals.get(mc);
        if (currentFixedGeometryDisplayers.size()!= adg.size())
            System.out.println("Number of geometry items changed");
         for(int i=0; i<adg.size(); i++){
            //System.out.println("update fixedVisuals index "+i+" dump:");
            adg.getElt(i).implementGeometry(this);
        }
    }

    private void updateVariableDecorations(Component mc) {
        ArrayDecorativeGeometry adg = new ArrayDecorativeGeometry();
        mc.generateDecorations(false, modelDisplayHints, model.getWorkingState(), adg);
        // Sync. 
        currentVariableGeometryDisplayers = mapComponentsToVariableVisuals.get(mc);
        int oldSize = (currentVariableGeometryDisplayers==null)?0:currentVariableGeometryDisplayers.size();
        int newSize = (int) adg.size();
        //System.out.println("Old Size="+oldSize);
        //System.out.println("New Size="+adg.size());
        if (oldSize != newSize){
            if (oldSize != 0)
                removeDisplayersFromScene(currentVariableGeometryDisplayers);
            updateMode = false;
        }
        
        for(int i=0; i<adg.size(); i++){
            adg.getElt(i).implementGeometry(this);
        }
    }

    public void setObjectColor(Component mc, double[] color) {
        currentFixedGeometryDisplayers = mapComponentsToFixedVisuals.get(mc);
        updateMode = true;
        for(int i=0; i<currentFixedGeometryDisplayers.size(); i++){
            currentFixedGeometryDisplayers.get(i).GetProperty().SetColor(color);
        }
    }

    public void startVariableGeometry() {
        processingVariableGeometry = true;
    }
    
    public void finishVariableGeometry() {
        processingVariableGeometry = false;
    }

    private void removeDisplayersFromScene(LinkedList<DecorativeGeometryDisplayer> currentGeometryDisplayers) {
        if (currentGeometryDisplayers==null) return;
        for(int i=0; i< currentGeometryDisplayers.size(); i++){
            DecorativeGeometryDisplayer dgd = currentGeometryDisplayers.get(i);
            BodyDisplayer bd = mapBodyIndicesToDisplayers.get(dgd.getBodyId());
            bd.RemovePart(dgd);
        }
        currentGeometryDisplayers.clear();
    }

    void removeGeometry(Component mc) {
        setCurrentComponent(mc);
        removeDisplayersFromScene(currentFixedGeometryDisplayers);
        removeDisplayersFromScene(currentVariableGeometryDisplayers);
        this.currentComponent = null;
    }
    
}
