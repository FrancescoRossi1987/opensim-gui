/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.7
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class ConditionalPathPoint extends PathPoint {
  private transient long swigCPtr;

  public ConditionalPathPoint(long cPtr, boolean cMemoryOwn) {
    super(opensimModelSimulationJNI.ConditionalPathPoint_SWIGUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  public static long getCPtr(ConditionalPathPoint obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        opensimModelSimulationJNI.delete_ConditionalPathPoint(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  public static ConditionalPathPoint safeDownCast(OpenSimObject obj) {
    long cPtr = opensimModelSimulationJNI.ConditionalPathPoint_safeDownCast(OpenSimObject.getCPtr(obj), obj);
    return (cPtr == 0) ? null : new ConditionalPathPoint(cPtr, false);
  }

  public void assign(OpenSimObject aObject) {
    opensimModelSimulationJNI.ConditionalPathPoint_assign(swigCPtr, this, OpenSimObject.getCPtr(aObject), aObject);
  }

  public static String getClassName() {
    return opensimModelSimulationJNI.ConditionalPathPoint_getClassName();
  }

  public OpenSimObject clone() {
    long cPtr = opensimModelSimulationJNI.ConditionalPathPoint_clone(swigCPtr, this);
    return (cPtr == 0) ? null : new ConditionalPathPoint(cPtr, true);
  }

  public String getConcreteClassName() {
    return opensimModelSimulationJNI.ConditionalPathPoint_getConcreteClassName(swigCPtr, this);
  }

  public void copyProperty_range(ConditionalPathPoint source) {
    opensimModelSimulationJNI.ConditionalPathPoint_copyProperty_range(swigCPtr, this, ConditionalPathPoint.getCPtr(source), source);
  }

  public double get_range(int i) {
    return opensimModelSimulationJNI.ConditionalPathPoint_get_range(swigCPtr, this, i);
  }

  public SWIGTYPE_p_double upd_range(int i) {
    return new SWIGTYPE_p_double(opensimModelSimulationJNI.ConditionalPathPoint_upd_range(swigCPtr, this, i), false);
  }

  public void set_range(int i, double value) {
    opensimModelSimulationJNI.ConditionalPathPoint_set_range(swigCPtr, this, i, value);
  }

  public int append_range(double value) {
    return opensimModelSimulationJNI.ConditionalPathPoint_append_range(swigCPtr, this, value);
  }

  public void setPropertyIndex_connector_coordinate_connectee_name(SWIGTYPE_p_PropertyIndex value) {
    opensimModelSimulationJNI.ConditionalPathPoint_PropertyIndex_connector_coordinate_connectee_name_set(swigCPtr, this, SWIGTYPE_p_PropertyIndex.getCPtr(value));
  }

  public SWIGTYPE_p_PropertyIndex getPropertyIndex_connector_coordinate_connectee_name() {
    return new SWIGTYPE_p_PropertyIndex(opensimModelSimulationJNI.ConditionalPathPoint_PropertyIndex_connector_coordinate_connectee_name_get(swigCPtr, this), true);
  }

  public void connectConnector_coordinate(OpenSimObject object) {
    opensimModelSimulationJNI.ConditionalPathPoint_connectConnector_coordinate(swigCPtr, this, OpenSimObject.getCPtr(object), object);
  }

  public ConditionalPathPoint() {
    this(opensimModelSimulationJNI.new_ConditionalPathPoint(), true);
  }

  public void setRangeMin(double minVal) {
    opensimModelSimulationJNI.ConditionalPathPoint_setRangeMin(swigCPtr, this, minVal);
  }

  public void setRangeMax(double maxVal) {
    opensimModelSimulationJNI.ConditionalPathPoint_setRangeMax(swigCPtr, this, maxVal);
  }

  public void setCoordinate(Coordinate coordinate) {
    opensimModelSimulationJNI.ConditionalPathPoint_setCoordinate(swigCPtr, this, Coordinate.getCPtr(coordinate), coordinate);
  }

  public boolean hasCoordinate() {
    return opensimModelSimulationJNI.ConditionalPathPoint_hasCoordinate(swigCPtr, this);
  }

  public Coordinate getCoordinate() {
    return new Coordinate(opensimModelSimulationJNI.ConditionalPathPoint_getCoordinate(swigCPtr, this), false);
  }

  public boolean isActive(State s) {
    return opensimModelSimulationJNI.ConditionalPathPoint_isActive(swigCPtr, this, State.getCPtr(s), s);
  }

}
