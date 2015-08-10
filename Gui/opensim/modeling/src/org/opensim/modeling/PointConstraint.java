/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class PointConstraint extends Constraint {
  private long swigCPtr;

  public PointConstraint(long cPtr, boolean cMemoryOwn) {
    super(opensimModelJNI.PointConstraint_SWIGUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  public static long getCPtr(PointConstraint obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        opensimModelJNI.delete_PointConstraint(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  public static PointConstraint safeDownCast(OpenSimObject obj) {
    long cPtr = opensimModelJNI.PointConstraint_safeDownCast(OpenSimObject.getCPtr(obj), obj);
    return (cPtr == 0) ? null : new PointConstraint(cPtr, false);
  }

  public void assign(OpenSimObject aObject) {
    opensimModelJNI.PointConstraint_assign(swigCPtr, this, OpenSimObject.getCPtr(aObject), aObject);
  }

  public static String getClassName() {
    return opensimModelJNI.PointConstraint_getClassName();
  }

  public OpenSimObject clone() {
    long cPtr = opensimModelJNI.PointConstraint_clone(swigCPtr, this);
    return (cPtr == 0) ? null : new PointConstraint(cPtr, true);
  }

  public String getConcreteClassName() {
    return opensimModelJNI.PointConstraint_getConcreteClassName(swigCPtr, this);
  }

  public void copyProperty_location_body_1(PointConstraint source) {
    opensimModelJNI.PointConstraint_copyProperty_location_body_1(swigCPtr, this, PointConstraint.getCPtr(source), source);
  }

  public Vec3 get_location_body_1(int i) {
    return new Vec3(opensimModelJNI.PointConstraint_get_location_body_1__SWIG_0(swigCPtr, this, i), false);
  }

  public Vec3 upd_location_body_1(int i) {
    return new Vec3(opensimModelJNI.PointConstraint_upd_location_body_1__SWIG_0(swigCPtr, this, i), false);
  }

  public void set_location_body_1(int i, Vec3 value) {
    opensimModelJNI.PointConstraint_set_location_body_1__SWIG_0(swigCPtr, this, i, Vec3.getCPtr(value), value);
  }

  public int append_location_body_1(Vec3 value) {
    return opensimModelJNI.PointConstraint_append_location_body_1(swigCPtr, this, Vec3.getCPtr(value), value);
  }

  public void constructProperty_location_body_1(Vec3 initValue) {
    opensimModelJNI.PointConstraint_constructProperty_location_body_1(swigCPtr, this, Vec3.getCPtr(initValue), initValue);
  }

  public Vec3 get_location_body_1() {
    return new Vec3(opensimModelJNI.PointConstraint_get_location_body_1__SWIG_1(swigCPtr, this), false);
  }

  public Vec3 upd_location_body_1() {
    return new Vec3(opensimModelJNI.PointConstraint_upd_location_body_1__SWIG_1(swigCPtr, this), false);
  }

  public void set_location_body_1(Vec3 value) {
    opensimModelJNI.PointConstraint_set_location_body_1__SWIG_1(swigCPtr, this, Vec3.getCPtr(value), value);
  }

  public void copyProperty_location_body_2(PointConstraint source) {
    opensimModelJNI.PointConstraint_copyProperty_location_body_2(swigCPtr, this, PointConstraint.getCPtr(source), source);
  }

  public Vec3 get_location_body_2(int i) {
    return new Vec3(opensimModelJNI.PointConstraint_get_location_body_2__SWIG_0(swigCPtr, this, i), false);
  }

  public Vec3 upd_location_body_2(int i) {
    return new Vec3(opensimModelJNI.PointConstraint_upd_location_body_2__SWIG_0(swigCPtr, this, i), false);
  }

  public void set_location_body_2(int i, Vec3 value) {
    opensimModelJNI.PointConstraint_set_location_body_2__SWIG_0(swigCPtr, this, i, Vec3.getCPtr(value), value);
  }

  public int append_location_body_2(Vec3 value) {
    return opensimModelJNI.PointConstraint_append_location_body_2(swigCPtr, this, Vec3.getCPtr(value), value);
  }

  public void constructProperty_location_body_2(Vec3 initValue) {
    opensimModelJNI.PointConstraint_constructProperty_location_body_2(swigCPtr, this, Vec3.getCPtr(initValue), initValue);
  }

  public Vec3 get_location_body_2() {
    return new Vec3(opensimModelJNI.PointConstraint_get_location_body_2__SWIG_1(swigCPtr, this), false);
  }

  public Vec3 upd_location_body_2() {
    return new Vec3(opensimModelJNI.PointConstraint_upd_location_body_2__SWIG_1(swigCPtr, this), false);
  }

  public void set_location_body_2(Vec3 value) {
    opensimModelJNI.PointConstraint_set_location_body_2__SWIG_1(swigCPtr, this, Vec3.getCPtr(value), value);
  }

  public PointConstraint() {
    this(opensimModelJNI.new_PointConstraint__SWIG_0(), true);
  }

  public PointConstraint(PhysicalFrame body1, Vec3 locationBody1, PhysicalFrame body2, Vec3 locationBody2) {
    this(opensimModelJNI.new_PointConstraint__SWIG_1(PhysicalFrame.getCPtr(body1), body1, Vec3.getCPtr(locationBody1), locationBody1, PhysicalFrame.getCPtr(body2), body2, Vec3.getCPtr(locationBody2), locationBody2), true);
  }

  public void setBody1ByName(String aBodyName) {
    opensimModelJNI.PointConstraint_setBody1ByName(swigCPtr, this, aBodyName);
  }

  public void setBody1PointLocation(Vec3 location) {
    opensimModelJNI.PointConstraint_setBody1PointLocation(swigCPtr, this, Vec3.getCPtr(location), location);
  }

  public void setBody2ByName(String aBodyName) {
    opensimModelJNI.PointConstraint_setBody2ByName(swigCPtr, this, aBodyName);
  }

  public void setBody2PointLocation(Vec3 location) {
    opensimModelJNI.PointConstraint_setBody2PointLocation(swigCPtr, this, Vec3.getCPtr(location), location);
  }

  public void setContactPointForInducedAccelerations(State s, Vec3 point) {
    opensimModelJNI.PointConstraint_setContactPointForInducedAccelerations(swigCPtr, this, State.getCPtr(s), s, Vec3.getCPtr(point), point);
  }

}