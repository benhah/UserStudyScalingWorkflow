/**
 * Copyright 2022 by palladiosimulator.org
 */
package org.palladiosimulator.spd.constraints;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import de.uka.ipd.sdq.identifier.IdentifierPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.palladiosimulator.spd.constraints.ConstraintsFactory
 * @model kind="package"
 * @generated
 */
public interface ConstraintsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "constraints";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://palladiosimulator.org/ScalingPolicyDefinition/Constraints/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "constraints";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ConstraintsPackage eINSTANCE = org.palladiosimulator.spd.constraints.impl.ConstraintsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.palladiosimulator.spd.constraints.impl.AbstractConstraintImpl <em>Abstract Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.palladiosimulator.spd.constraints.impl.AbstractConstraintImpl
	 * @see org.palladiosimulator.spd.constraints.impl.ConstraintsPackageImpl#getAbstractConstraint()
	 * @generated
	 */
	int ABSTRACT_CONSTRAINT = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_CONSTRAINT__ID = IdentifierPackage.IDENTIFIER__ID;

	/**
	 * The number of structural features of the '<em>Abstract Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_CONSTRAINT_FEATURE_COUNT = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 0;

	/**
	 * Returns the meta object for class '{@link org.palladiosimulator.spd.constraints.AbstractConstraint <em>Abstract Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Constraint</em>'.
	 * @see org.palladiosimulator.spd.constraints.AbstractConstraint
	 * @generated
	 */
	EClass getAbstractConstraint();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ConstraintsFactory getConstraintsFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.palladiosimulator.spd.constraints.impl.AbstractConstraintImpl <em>Abstract Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.palladiosimulator.spd.constraints.impl.AbstractConstraintImpl
		 * @see org.palladiosimulator.spd.constraints.impl.ConstraintsPackageImpl#getAbstractConstraint()
		 * @generated
		 */
		EClass ABSTRACT_CONSTRAINT = eINSTANCE.getAbstractConstraint();

	}

} //ConstraintsPackage
