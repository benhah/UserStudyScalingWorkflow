/**
 * Copyright 2022 by palladiosimulator.org
 */
package org.palladiosimulator.spd;

import org.eclipse.emf.common.util.EList;
import org.palladiosimulator.pcm.core.entity.Entity;
import org.palladiosimulator.spd.adjustments.AdjustmentType;
import org.palladiosimulator.spd.constraints.policy.PolicyConstraint;
import org.palladiosimulator.spd.targets.TargetGroup;
import org.palladiosimulator.spd.triggers.ScalingTrigger;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Scaling Policy</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A scaling policy determines the complete information for scaling a parituclar target. Each ScalingPolicy is an Entity (PCM), it has a unique identifier and it has a name.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.spd.ScalingPolicy#isActive <em>Active</em>}</li>
 *   <li>{@link org.palladiosimulator.spd.ScalingPolicy#getAdjustmentType <em>Adjustment Type</em>}</li>
 *   <li>{@link org.palladiosimulator.spd.ScalingPolicy#getTargetGroup <em>Target Group</em>}</li>
 *   <li>{@link org.palladiosimulator.spd.ScalingPolicy#getPolicyConstraints <em>Policy Constraints</em>}</li>
 *   <li>{@link org.palladiosimulator.spd.ScalingPolicy#getScalingTrigger <em>Scaling Trigger</em>}</li>
 * </ul>
 *
 * @see org.palladiosimulator.spd.SpdPackage#getScalingPolicy()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='policyNameInvariant'"
 * @generated
 */
public interface ScalingPolicy extends Entity {
	/**
	 * Returns the value of the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Active</em>' attribute.
	 * @see #setActive(boolean)
	 * @see org.palladiosimulator.spd.SpdPackage#getScalingPolicy_Active()
	 * @model
	 * @generated
	 */
	boolean isActive();

	/**
	 * Sets the value of the '{@link org.palladiosimulator.spd.ScalingPolicy#isActive <em>Active</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Active</em>' attribute.
	 * @see #isActive()
	 * @generated
	 */
	void setActive(boolean value);

	/**
	 * Returns the value of the '<em><b>Adjustment Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Adjustment Type</em>' containment reference.
	 * @see #setAdjustmentType(AdjustmentType)
	 * @see org.palladiosimulator.spd.SpdPackage#getScalingPolicy_AdjustmentType()
	 * @model containment="true" required="true"
	 * @generated
	 */
	AdjustmentType getAdjustmentType();

	/**
	 * Sets the value of the '{@link org.palladiosimulator.spd.ScalingPolicy#getAdjustmentType <em>Adjustment Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Adjustment Type</em>' containment reference.
	 * @see #getAdjustmentType()
	 * @generated
	 */
	void setAdjustmentType(AdjustmentType value);

	/**
	 * Returns the value of the '<em><b>Target Group</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Group</em>' reference.
	 * @see #setTargetGroup(TargetGroup)
	 * @see org.palladiosimulator.spd.SpdPackage#getScalingPolicy_TargetGroup()
	 * @model required="true"
	 * @generated
	 */
	TargetGroup getTargetGroup();

	/**
	 * Sets the value of the '{@link org.palladiosimulator.spd.ScalingPolicy#getTargetGroup <em>Target Group</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Group</em>' reference.
	 * @see #getTargetGroup()
	 * @generated
	 */
	void setTargetGroup(TargetGroup value);

	/**
	 * Returns the value of the '<em><b>Policy Constraints</b></em>' containment reference list.
	 * The list contents are of type {@link org.palladiosimulator.spd.constraints.policy.PolicyConstraint}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Policy Constraints</em>' containment reference list.
	 * @see org.palladiosimulator.spd.SpdPackage#getScalingPolicy_PolicyConstraints()
	 * @model containment="true"
	 * @generated
	 */
	EList<PolicyConstraint> getPolicyConstraints();

	/**
	 * Returns the value of the '<em><b>Scaling Trigger</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scaling Trigger</em>' containment reference.
	 * @see #setScalingTrigger(ScalingTrigger)
	 * @see org.palladiosimulator.spd.SpdPackage#getScalingPolicy_ScalingTrigger()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ScalingTrigger getScalingTrigger();

	/**
	 * Sets the value of the '{@link org.palladiosimulator.spd.ScalingPolicy#getScalingTrigger <em>Scaling Trigger</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scaling Trigger</em>' containment reference.
	 * @see #getScalingTrigger()
	 * @generated
	 */
	void setScalingTrigger(ScalingTrigger value);

} // ScalingPolicy
