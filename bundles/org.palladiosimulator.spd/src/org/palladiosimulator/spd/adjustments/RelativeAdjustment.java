/**
 * Copyright 2022 by palladiosimulator.org
 */
package org.palladiosimulator.spd.adjustments;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Relative Adjustment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The RelativeAdjustment denotes that the group should is adjusted relatively to the current number of elements.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.spd.adjustments.RelativeAdjustment#getPercentageGrowthValue <em>Percentage Growth Value</em>}</li>
 *   <li>{@link org.palladiosimulator.spd.adjustments.RelativeAdjustment#getMinAdjustmentValue <em>Min Adjustment Value</em>}</li>
 * </ul>
 *
 * @see org.palladiosimulator.spd.adjustments.AdjustmentsPackage#getRelativeAdjustment()
 * @model
 * @generated
 */
public interface RelativeAdjustment extends AdjustmentType {
	/**
	 * Returns the value of the '<em><b>Percentage Growth Value</b></em>' attribute.
	 * The default value is <code>"0.0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The percantage value of adjustment e.g., a value of 10 denotes that 10% should be added to the existing capacity.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Percentage Growth Value</em>' attribute.
	 * @see #setPercentageGrowthValue(double)
	 * @see org.palladiosimulator.spd.adjustments.AdjustmentsPackage#getRelativeAdjustment_PercentageGrowthValue()
	 * @model default="0.0" required="true"
	 * @generated
	 */
	double getPercentageGrowthValue();

	/**
	 * Sets the value of the '{@link org.palladiosimulator.spd.adjustments.RelativeAdjustment#getPercentageGrowthValue <em>Percentage Growth Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Percentage Growth Value</em>' attribute.
	 * @see #getPercentageGrowthValue()
	 * @generated
	 */
	void setPercentageGrowthValue(double value);

	/**
	 * Returns the value of the '<em><b>Min Adjustment Value</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A minimum adjustment value in case the percentage is 0.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Min Adjustment Value</em>' attribute.
	 * @see #setMinAdjustmentValue(int)
	 * @see org.palladiosimulator.spd.adjustments.AdjustmentsPackage#getRelativeAdjustment_MinAdjustmentValue()
	 * @model default="0" required="true"
	 * @generated
	 */
	int getMinAdjustmentValue();

	/**
	 * Sets the value of the '{@link org.palladiosimulator.spd.adjustments.RelativeAdjustment#getMinAdjustmentValue <em>Min Adjustment Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min Adjustment Value</em>' attribute.
	 * @see #getMinAdjustmentValue()
	 * @generated
	 */
	void setMinAdjustmentValue(int value);

} // RelativeAdjustment
