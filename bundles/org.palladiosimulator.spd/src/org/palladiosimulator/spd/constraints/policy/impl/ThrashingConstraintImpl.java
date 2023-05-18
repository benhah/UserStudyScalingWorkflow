/**
 * Copyright 2022 by palladiosimulator.org
 */
package org.palladiosimulator.spd.constraints.policy.impl;

import org.eclipse.emf.ecore.EClass;
import org.palladiosimulator.spd.constraints.policy.PolicyPackage;
import org.palladiosimulator.spd.constraints.policy.ThrashingConstraint;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Thrashing Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.spd.constraints.policy.impl.ThrashingConstraintImpl#getMinimumTimeNoThrashing <em>Minimum Time No Thrashing</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ThrashingConstraintImpl extends TemporalConstraintImpl implements ThrashingConstraint {
	/**
	 * The default value of the '{@link #getMinimumTimeNoThrashing() <em>Minimum Time No Thrashing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinimumTimeNoThrashing()
	 * @generated
	 * @ordered
	 */
	protected static final double MINIMUM_TIME_NO_THRASHING_EDEFAULT = 0.0;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ThrashingConstraintImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PolicyPackage.Literals.THRASHING_CONSTRAINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getMinimumTimeNoThrashing() {
		return (Double) eDynamicGet(PolicyPackage.THRASHING_CONSTRAINT__MINIMUM_TIME_NO_THRASHING,
				PolicyPackage.Literals.THRASHING_CONSTRAINT__MINIMUM_TIME_NO_THRASHING, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMinimumTimeNoThrashing(double newMinimumTimeNoThrashing) {
		eDynamicSet(PolicyPackage.THRASHING_CONSTRAINT__MINIMUM_TIME_NO_THRASHING,
				PolicyPackage.Literals.THRASHING_CONSTRAINT__MINIMUM_TIME_NO_THRASHING, newMinimumTimeNoThrashing);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case PolicyPackage.THRASHING_CONSTRAINT__MINIMUM_TIME_NO_THRASHING:
			return getMinimumTimeNoThrashing();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case PolicyPackage.THRASHING_CONSTRAINT__MINIMUM_TIME_NO_THRASHING:
			setMinimumTimeNoThrashing((Double) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case PolicyPackage.THRASHING_CONSTRAINT__MINIMUM_TIME_NO_THRASHING:
			setMinimumTimeNoThrashing(MINIMUM_TIME_NO_THRASHING_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case PolicyPackage.THRASHING_CONSTRAINT__MINIMUM_TIME_NO_THRASHING:
			return getMinimumTimeNoThrashing() != MINIMUM_TIME_NO_THRASHING_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

} //ThrashingConstraintImpl
