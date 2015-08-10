/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class AnalyticGeometry extends SurfaceGeometry {
  private long swigCPtr;

  public AnalyticGeometry(long cPtr, boolean cMemoryOwn) {
    super(opensimModelJNI.AnalyticGeometry_SWIGUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  public static long getCPtr(AnalyticGeometry obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        opensimModelJNI.delete_AnalyticGeometry(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  public static AnalyticGeometry safeDownCast(OpenSimObject obj) {
    long cPtr = opensimModelJNI.AnalyticGeometry_safeDownCast(OpenSimObject.getCPtr(obj), obj);
    return (cPtr == 0) ? null : new AnalyticGeometry(cPtr, false);
  }

  public void assign(OpenSimObject aObject) {
    opensimModelJNI.AnalyticGeometry_assign(swigCPtr, this, OpenSimObject.getCPtr(aObject), aObject);
  }

  public static String getClassName() {
    return opensimModelJNI.AnalyticGeometry_getClassName();
  }

  public OpenSimObject clone() {
    long cPtr = opensimModelJNI.AnalyticGeometry_clone(swigCPtr, this);
    return (cPtr == 0) ? null : new AnalyticGeometry(cPtr, true);
  }

  public String getConcreteClassName() {
    return opensimModelJNI.AnalyticGeometry_getConcreteClassName(swigCPtr, this);
  }

  public void setQuadrants(boolean[] quadrants) {
    opensimModelJNI.AnalyticGeometry_setQuadrants(swigCPtr, this, quadrants);
  }

  public void getQuadrants(boolean[] quadrants) {
    opensimModelJNI.AnalyticGeometry_getQuadrants(swigCPtr, this, quadrants);
  }

  public boolean isPiece() {
    return opensimModelJNI.AnalyticGeometry_isPiece(swigCPtr, this);
  }

}