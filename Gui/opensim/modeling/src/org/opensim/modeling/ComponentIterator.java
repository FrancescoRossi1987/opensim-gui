/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.7
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class ComponentIterator {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  public ComponentIterator(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  public static long getCPtr(ComponentIterator obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        opensimModelJNI.delete_ComponentIterator(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public boolean equals(ComponentIterator iter) {
    return opensimModelJNI.ComponentIterator_equals(swigCPtr, this, ComponentIterator.getCPtr(iter), iter);
  }

  public Component __ref__() {
    return new Component(opensimModelJNI.ComponentIterator___ref__(swigCPtr, this), false);
  }

  public Component __deref__() {
    long cPtr = opensimModelJNI.ComponentIterator___deref__(swigCPtr, this);
    return (cPtr == 0) ? null : new Component(cPtr, false);
  }

  public ComponentIterator next() {
    return new ComponentIterator(opensimModelJNI.ComponentIterator_next(swigCPtr, this), false);
  }

  public OpenSimObject clone() {
    long cPtr = opensimModelJNI.ComponentIterator_clone(swigCPtr, this);
    return (cPtr == 0) ? null : new Component(cPtr, true);
  }

  public String getConcreteClassName() {
    return opensimModelJNI.ComponentIterator_getConcreteClassName(swigCPtr, this);
  }

  public void addToSystem(SWIGTYPE_p_SimTK__MultibodySystem system) {
    opensimModelJNI.ComponentIterator_addToSystem(swigCPtr, this, SWIGTYPE_p_SimTK__MultibodySystem.getCPtr(system));
  }

  public void initStateFromProperties(State state) {
    opensimModelJNI.ComponentIterator_initStateFromProperties(swigCPtr, this, State.getCPtr(state), state);
  }

  public void generateDecorations(boolean fixed, ModelDisplayHints hints, State state, ArrayDecorativeGeometry appendToThis) {
    opensimModelJNI.ComponentIterator_generateDecorations(swigCPtr, this, fixed, ModelDisplayHints.getCPtr(hints), hints, State.getCPtr(state), state, ArrayDecorativeGeometry.getCPtr(appendToThis), appendToThis);
  }

  public SWIGTYPE_p_SimTK__MultibodySystem getSystem() {
    return new SWIGTYPE_p_SimTK__MultibodySystem(opensimModelJNI.ComponentIterator_getSystem(swigCPtr, this), false);
  }

  public boolean hasSystem() {
    return opensimModelJNI.ComponentIterator_hasSystem(swigCPtr, this);
  }

  public Component getComponent(String name) {
    return new Component(opensimModelJNI.ComponentIterator_getComponent(swigCPtr, this, name), false);
  }

  public Component updComponent(String name) {
    return new Component(opensimModelJNI.ComponentIterator_updComponent(swigCPtr, this, name), false);
  }

  public int getNumStateVariables() {
    return opensimModelJNI.ComponentIterator_getNumStateVariables(swigCPtr, this);
  }

  public ArrayStr getStateVariableNames() {
    return new ArrayStr(opensimModelJNI.ComponentIterator_getStateVariableNames(swigCPtr, this), true);
  }

  public int getNumConnectors() {
    return opensimModelJNI.ComponentIterator_getNumConnectors(swigCPtr, this);
  }

  public AbstractConnector getConnector(int i) {
    return new AbstractConnector(opensimModelJNI.ComponentIterator_getConnector(swigCPtr, this, i), false);
  }

  public AbstractInput getInput(String name) {
    return new AbstractInput(opensimModelJNI.ComponentIterator_getInput(swigCPtr, this, name), false);
  }

  public AbstractOutput getOutput(String name) {
    return new AbstractOutput(opensimModelJNI.ComponentIterator_getOutput(swigCPtr, this, name), false);
  }

  public SWIGTYPE_p_std__mapT_std__string_std__unique_ptrT_OpenSim__AbstractOutput_const_t_t__const_iterator getOutputsBegin() {
    return new SWIGTYPE_p_std__mapT_std__string_std__unique_ptrT_OpenSim__AbstractOutput_const_t_t__const_iterator(opensimModelJNI.ComponentIterator_getOutputsBegin(swigCPtr, this), true);
  }

  public SWIGTYPE_p_std__mapT_std__string_std__unique_ptrT_OpenSim__AbstractOutput_const_t_t__const_iterator getOutputsEnd() {
    return new SWIGTYPE_p_std__mapT_std__string_std__unique_ptrT_OpenSim__AbstractOutput_const_t_t__const_iterator(opensimModelJNI.ComponentIterator_getOutputsEnd(swigCPtr, this), true);
  }

  public int getModelingOption(State state, String name) {
    return opensimModelJNI.ComponentIterator_getModelingOption(swigCPtr, this, State.getCPtr(state), state, name);
  }

  public void setModelingOption(State state, String name, int flag) {
    opensimModelJNI.ComponentIterator_setModelingOption(swigCPtr, this, State.getCPtr(state), state, name, flag);
  }

  public double getStateVariableValue(State state, String name) {
    return opensimModelJNI.ComponentIterator_getStateVariableValue(swigCPtr, this, State.getCPtr(state), state, name);
  }

  public void setStateVariableValue(State state, String name, double value) {
    opensimModelJNI.ComponentIterator_setStateVariableValue(swigCPtr, this, State.getCPtr(state), state, name, value);
  }

  public Vector getStateVariableValues(State state) {
    return new Vector(opensimModelJNI.ComponentIterator_getStateVariableValues(swigCPtr, this, State.getCPtr(state), state), true);
  }

  public double getStateVariableDerivativeValue(State state, String name) {
    return opensimModelJNI.ComponentIterator_getStateVariableDerivativeValue(swigCPtr, this, State.getCPtr(state), state, name);
  }

  public double getDiscreteVariableValue(State state, String name) {
    return opensimModelJNI.ComponentIterator_getDiscreteVariableValue(swigCPtr, this, State.getCPtr(state), state, name);
  }

  public void setDiscreteVariableValue(State state, String name, double value) {
    opensimModelJNI.ComponentIterator_setDiscreteVariableValue(swigCPtr, this, State.getCPtr(state), state, name, value);
  }

  public void markCacheVariableValid(State state, String name) {
    opensimModelJNI.ComponentIterator_markCacheVariableValid(swigCPtr, this, State.getCPtr(state), state, name);
  }

  public void markCacheVariableInvalid(State state, String name) {
    opensimModelJNI.ComponentIterator_markCacheVariableInvalid(swigCPtr, this, State.getCPtr(state), state, name);
  }

  public boolean isCacheVariableValid(State state, String name) {
    return opensimModelJNI.ComponentIterator_isCacheVariableValid(swigCPtr, this, State.getCPtr(state), state, name);
  }

  public String getPathName() {
    return opensimModelJNI.ComponentIterator_getPathName(swigCPtr, this);
  }

  public void dumpPathName() {
    opensimModelJNI.ComponentIterator_dumpPathName(swigCPtr, this);
  }

  public ComponentsList getComponentsList() {
    return new ComponentsList(opensimModelJNI.ComponentIterator_getComponentsList(swigCPtr, this), true);
  }

  public FramesList getFramesList() {
    return new FramesList(opensimModelJNI.ComponentIterator_getFramesList(swigCPtr, this), true);
  }

  public BodiesList getBodiesList() {
    return new BodiesList(opensimModelJNI.ComponentIterator_getBodiesList(swigCPtr, this), true);
  }

  public MusclesList getMusclesList() {
    return new MusclesList(opensimModelJNI.ComponentIterator_getMusclesList(swigCPtr, this), true);
  }

  public ModelComponentList getModelComponentList() {
    return new ModelComponentList(opensimModelJNI.ComponentIterator_getModelComponentList(swigCPtr, this), true);
  }

  public JointsList getJointList() {
    return new JointsList(opensimModelJNI.ComponentIterator_getJointList(swigCPtr, this), true);
  }

  public boolean isEqualTo(OpenSimObject aObject) {
    return opensimModelJNI.ComponentIterator_isEqualTo(swigCPtr, this, OpenSimObject.getCPtr(aObject), aObject);
  }

  public String getName() {
    return opensimModelJNI.ComponentIterator_getName(swigCPtr, this);
  }

  public String getDescription() {
    return opensimModelJNI.ComponentIterator_getDescription(swigCPtr, this);
  }

  public String getAuthors() {
    return opensimModelJNI.ComponentIterator_getAuthors(swigCPtr, this);
  }

  public String getReferences() {
    return opensimModelJNI.ComponentIterator_getReferences(swigCPtr, this);
  }

  public int getNumProperties() {
    return opensimModelJNI.ComponentIterator_getNumProperties(swigCPtr, this);
  }

  public AbstractProperty getPropertyByIndex(int propertyIndex) {
    return new AbstractProperty(opensimModelJNI.ComponentIterator_getPropertyByIndex(swigCPtr, this, propertyIndex), false);
  }

  public boolean hasProperty(String name) {
    return opensimModelJNI.ComponentIterator_hasProperty(swigCPtr, this, name);
  }

  public AbstractProperty getPropertyByName(String name) {
    return new AbstractProperty(opensimModelJNI.ComponentIterator_getPropertyByName(swigCPtr, this, name), false);
  }

  public boolean isObjectUpToDateWithProperties() {
    return opensimModelJNI.ComponentIterator_isObjectUpToDateWithProperties(swigCPtr, this);
  }

  public void updateXMLNode(SWIGTYPE_p_SimTK__Xml__Element parent) {
    opensimModelJNI.ComponentIterator_updateXMLNode(swigCPtr, this, SWIGTYPE_p_SimTK__Xml__Element.getCPtr(parent));
  }

  public boolean getInlined() {
    return opensimModelJNI.ComponentIterator_getInlined(swigCPtr, this);
  }

  public String getDocumentFileName() {
    return opensimModelJNI.ComponentIterator_getDocumentFileName(swigCPtr, this);
  }

  public boolean print(String fileName) {
    return opensimModelJNI.ComponentIterator_print(swigCPtr, this, fileName);
  }

  public boolean isA(String type) {
    return opensimModelJNI.ComponentIterator_isA(swigCPtr, this, type);
  }

  public String toString() {
    return opensimModelJNI.ComponentIterator_toString(swigCPtr, this);
  }

}
