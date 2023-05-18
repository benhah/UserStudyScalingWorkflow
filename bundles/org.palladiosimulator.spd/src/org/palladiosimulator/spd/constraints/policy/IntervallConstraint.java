/**
 * Copyright 2022 by palladiosimulator.org
 */
package org.palladiosimulator.spd.constraints.policy;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Intervall Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.spd.constraints.policy.IntervallConstraint#getOffset <em>Offset</em>}</li>
 *   <li>{@link org.palladiosimulator.spd.constraints.policy.IntervallConstraint#getIntervallDuration <em>Intervall Duration</em>}</li>
 * </ul>
 *
 * @see org.palladiosimulator.spd.constraints.policy.PolicyPackage#getIntervallConstraint()
 * @model
 * @generated
 */
public interface IntervallConstraint extends TemporalConstraint {
	/**
	 * Returns the value of the '<em><b>Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Offset</em>' attribute.
	 * @see #setOffset(int)
	 * @see org.palladiosimulator.spd.constraints.policy.PolicyPackage#getIntervallConstraint_Offset()
	 * @model required="true"
	 * @generated
	 */
	int getOffset();

	/**
	 * Sets the value of the '{@link org.palladiosimulator.spd.constraints.policy.IntervallConstraint#getOffset <em>Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Offset</em>' attribute.
	 * @see #getOffset()
	 * @generated
	 */
	void setOffset(int value);

	/**
	 * Returns the value of the '<em><b>Intervall Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Intervall Duration</em>' attribute.
	 * @see #setIntervallDuration(int)
	 * @see org.palladiosimulator.spd.constraints.policy.PolicyPackage#getIntervallConstraint_IntervallDuration()
	 * @model required="true"
	 * @generated
	 */
	int getIntervallDuration();

	/**
	 * Sets the value of the '{@link org.palladiosimulator.spd.constraints.policy.IntervallConstraint#getIntervallDuration <em>Intervall Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Intervall Duration</em>' attribute.
	 * @see #getIntervallDuration()
	 * @generated
	 */
	void setIntervallDuration(int value);

} // IntervallConstraint
