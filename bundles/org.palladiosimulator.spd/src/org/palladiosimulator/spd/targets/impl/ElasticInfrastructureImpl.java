/**
 * Copyright 2022 by palladiosimulator.org
 */
package org.palladiosimulator.spd.targets.impl;

import org.eclipse.emf.ecore.EClass;
import org.palladiosimulator.pcm.resourceenvironment.ResourceEnvironment;
import org.palladiosimulator.spd.targets.ElasticInfrastructure;
import org.palladiosimulator.spd.targets.TargetsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Elastic Infrastructure</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.spd.targets.impl.ElasticInfrastructureImpl#getPCM_ResourceEnvironment <em>PCM Resource Environment</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ElasticInfrastructureImpl extends TargetGroupImpl implements ElasticInfrastructure {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ElasticInfrastructureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TargetsPackage.Literals.ELASTIC_INFRASTRUCTURE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceEnvironment getPCM_ResourceEnvironment() {
		return (ResourceEnvironment) eDynamicGet(TargetsPackage.ELASTIC_INFRASTRUCTURE__PCM_RESOURCE_ENVIRONMENT,
				TargetsPackage.Literals.ELASTIC_INFRASTRUCTURE__PCM_RESOURCE_ENVIRONMENT, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceEnvironment basicGetPCM_ResourceEnvironment() {
		return (ResourceEnvironment) eDynamicGet(TargetsPackage.ELASTIC_INFRASTRUCTURE__PCM_RESOURCE_ENVIRONMENT,
				TargetsPackage.Literals.ELASTIC_INFRASTRUCTURE__PCM_RESOURCE_ENVIRONMENT, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPCM_ResourceEnvironment(ResourceEnvironment newPCM_ResourceEnvironment) {
		eDynamicSet(TargetsPackage.ELASTIC_INFRASTRUCTURE__PCM_RESOURCE_ENVIRONMENT,
				TargetsPackage.Literals.ELASTIC_INFRASTRUCTURE__PCM_RESOURCE_ENVIRONMENT, newPCM_ResourceEnvironment);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case TargetsPackage.ELASTIC_INFRASTRUCTURE__PCM_RESOURCE_ENVIRONMENT:
			if (resolve)
				return getPCM_ResourceEnvironment();
			return basicGetPCM_ResourceEnvironment();
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
		case TargetsPackage.ELASTIC_INFRASTRUCTURE__PCM_RESOURCE_ENVIRONMENT:
			setPCM_ResourceEnvironment((ResourceEnvironment) newValue);
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
		case TargetsPackage.ELASTIC_INFRASTRUCTURE__PCM_RESOURCE_ENVIRONMENT:
			setPCM_ResourceEnvironment((ResourceEnvironment) null);
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
		case TargetsPackage.ELASTIC_INFRASTRUCTURE__PCM_RESOURCE_ENVIRONMENT:
			return basicGetPCM_ResourceEnvironment() != null;
		}
		return super.eIsSet(featureID);
	}

} //ElasticInfrastructureImpl
