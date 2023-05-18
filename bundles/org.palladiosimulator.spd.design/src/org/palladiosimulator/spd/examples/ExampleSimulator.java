package org.palladiosimulator.spd.examples;

import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class ExampleSimulator {
	private Double[] rawData;
	private double upperThreshold = 0.8;
	private double lowerThreshold = 0.2;
	private double upAdjustmentRate = 0.1;
	private double downAdjustmentRate = 0.2;
	private double scalingMultiplier = 1;
	private int restraintCooldownLength = 2;
	private int timestepsLeftOnCooldownUpscaling = 0;
	private int timestepsLeftOnCooldownDownscaling = 0;

	public ExampleSimulator(Double[] rawData) {
		this.rawData = rawData;
	}
	
	public ExampleSimulator(Double[] rawData, double upperThreshold, double lowerThreshold, double upAdjustmentRate, double downAdjustmentRate, int restraintCooldownLength) {
		this.rawData = rawData;
		this.upperThreshold = upperThreshold;
		this.lowerThreshold = lowerThreshold;
		this.upAdjustmentRate = upAdjustmentRate;
		this.downAdjustmentRate = downAdjustmentRate;
		this.restraintCooldownLength = restraintCooldownLength;
	}
	
	public XYDataset getCpuUtilisationExampleDataset() {
		XYSeries data = new XYSeries("CPU Utilisation");
		XYSeries upscalingEvent = new XYSeries("Upscaling Events");
		XYSeries downscalingEvent = new XYSeries("Downscaling Events");
		XYSeries upperThresholdSeries = new XYSeries("Upper Threshold");
		XYSeries lowerThresholdSeries = new XYSeries("Lower Threshold");
		XYSeries upscalingCooldownTriggered = new XYSeries("Cooldown Preventing Upscaling");
		XYSeries downscalingCooldownTriggered = new XYSeries("Cooldown Preventing Downscaling");
		
		
		for(int i = 0; i < rawData.length; i++) {
			
			double scaledValue = Math.min(Math.max(rawData[i] / scalingMultiplier, 0), 1);
			if(scaledValue > upperThreshold) {
				if(timestepsLeftOnCooldownUpscaling > 0) {
					upscalingCooldownTriggered.add(i, 1);
					downscalingCooldownTriggered.add(i, 0);
					upscalingEvent.add(i, 0);
					downscalingEvent.add(i, 0);
					timestepsLeftOnCooldownUpscaling = Math.max(timestepsLeftOnCooldownUpscaling - 1, 0);
					timestepsLeftOnCooldownDownscaling = Math.max(timestepsLeftOnCooldownDownscaling - 1, 0);
				} else {
					scalingMultiplier *= 1 + upAdjustmentRate;
					upscalingEvent.add(i, 1);
					downscalingEvent.add(i, 0);
					upscalingCooldownTriggered.add(i, 0);
					downscalingCooldownTriggered.add(i, 0);
					timestepsLeftOnCooldownUpscaling = restraintCooldownLength;
					timestepsLeftOnCooldownDownscaling = Math.max(timestepsLeftOnCooldownDownscaling - 1, 0);
				}
			}
			else if(scaledValue < lowerThreshold) {
				if(timestepsLeftOnCooldownDownscaling > 0) {
					upscalingCooldownTriggered.add(i, 0);
					downscalingCooldownTriggered.add(i, 1);
					upscalingEvent.add(i, 0);
					downscalingEvent.add(i, 0);
					timestepsLeftOnCooldownUpscaling = Math.max(timestepsLeftOnCooldownUpscaling - 1, 0);
					timestepsLeftOnCooldownDownscaling = Math.max(timestepsLeftOnCooldownDownscaling - 1, 0);
				} else {
					scalingMultiplier *= 1 - downAdjustmentRate;
					upscalingEvent.add(i, 0);
					downscalingEvent.add(i, 1);
					upscalingCooldownTriggered.add(i, 0);
					downscalingCooldownTriggered.add(i, 0);
					timestepsLeftOnCooldownDownscaling = restraintCooldownLength;
					timestepsLeftOnCooldownUpscaling = Math.max(timestepsLeftOnCooldownUpscaling - 1, 0);
				}
			}
			else {
				upscalingEvent.add(i, 0);
				downscalingEvent.add(i, 0);
				upscalingCooldownTriggered.add(i, 0);
				downscalingCooldownTriggered.add(i, 0);
				timestepsLeftOnCooldownUpscaling = Math.max(timestepsLeftOnCooldownUpscaling - 1, 0);
				timestepsLeftOnCooldownDownscaling = Math.max(timestepsLeftOnCooldownDownscaling - 1, 0);
			}
			data.add(i, scaledValue);
			upperThresholdSeries.add(i, upperThreshold);
			lowerThresholdSeries.add(i, lowerThreshold);
			
		}
		
		
		XYSeriesCollection seriesCollection = new XYSeriesCollection(data);
		seriesCollection.addSeries(upperThresholdSeries);
		seriesCollection.addSeries(lowerThresholdSeries);
		seriesCollection.addSeries(upscalingEvent);
		seriesCollection.addSeries(downscalingEvent);
		seriesCollection.addSeries(upscalingCooldownTriggered);
		seriesCollection.addSeries(downscalingCooldownTriggered);
		XYDataset dataset = seriesCollection;		
		
		return dataset;
	}
}
