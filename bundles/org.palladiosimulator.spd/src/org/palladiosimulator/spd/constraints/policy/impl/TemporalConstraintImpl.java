/**
 * Copyright 2022 by palladiosimulator.org
 */
package org.palladiosimulator.spd.constraints.policy.impl;

import org.eclipse.emf.ecore.EClass;
import org.palladiosimulator.spd.constraints.policy.PolicyPackage;
import org.palladiosimulator.spd.constraints.policy.TemporalConstraint;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Temporal Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class TemporalConstraintImpl extends PolicyConstraintImpl implements TemporalConstraint {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TemporalConstraintImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PolicyPackage.Literals.TEMPORAL_CONSTRAINT;
	}

} //TemporalConstraintImpl
