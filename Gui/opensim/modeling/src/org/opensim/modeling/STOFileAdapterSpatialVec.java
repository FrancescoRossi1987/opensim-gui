/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.7
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class STOFileAdapterSpatialVec {
  private transient long swigCPtr;
  private transient boolean swigCMemOwn;

  protected STOFileAdapterSpatialVec(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(STOFileAdapterSpatialVec obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        opensimModelCommonJNI.delete_STOFileAdapterSpatialVec(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public STOFileAdapterSpatialVec() {
    this(opensimModelCommonJNI.new_STOFileAdapterSpatialVec__SWIG_0(), true);
  }

  public STOFileAdapterSpatialVec(STOFileAdapterSpatialVec arg0) {
    this(opensimModelCommonJNI.new_STOFileAdapterSpatialVec__SWIG_1(STOFileAdapterSpatialVec.getCPtr(arg0), arg0), true);
  }

  public STOFileAdapterSpatialVec clone() {
    long cPtr = opensimModelCommonJNI.STOFileAdapterSpatialVec_clone(swigCPtr, this);
    return (cPtr == 0) ? null : new STOFileAdapterSpatialVec(cPtr, true);
  }

  public static SWIGTYPE_p_OpenSim__TimeSeriesTable_T_SimTK__VecT_2_SimTK__Vec3_1_t_t read(String fileName) {
    return new SWIGTYPE_p_OpenSim__TimeSeriesTable_T_SimTK__VecT_2_SimTK__Vec3_1_t_t(opensimModelCommonJNI.STOFileAdapterSpatialVec_read(fileName), true);
  }

  public static void write(SWIGTYPE_p_OpenSim__TimeSeriesTable_T_SimTK__VecT_2_SimTK__Vec3_1_t_t table, String fileName) {
    opensimModelCommonJNI.STOFileAdapterSpatialVec_write(SWIGTYPE_p_OpenSim__TimeSeriesTable_T_SimTK__VecT_2_SimTK__Vec3_1_t_t.getCPtr(table), fileName);
  }

}