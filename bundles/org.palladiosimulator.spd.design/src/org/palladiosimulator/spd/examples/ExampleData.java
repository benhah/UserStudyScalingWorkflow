package org.palladiosimulator.spd.examples;

public class ExampleData {
	private int dataLength;
	private Double[] cpuUtilisationExampleData;
	
	public ExampleData(int dataLength) {
		this.dataLength = dataLength;
		this.cpuUtilisationExampleData = new Double[dataLength];
	}
	
	public void fillCPUDataConstantLow() {
		for(int i = 0; i < dataLength; i++) {
			double rand = (Math.random() - 0.5)*2*0.02;
			cpuUtilisationExampleData[i] = 0.23 + rand;
		}
	}
	
	public void fillCPUDataLinearIncreasingLoad() {
		int startIncrease = (int) Math.floor(dataLength / 5);
		int endIncrease = (int) Math.floor(dataLength * 2/5);
		double changeRate = 0.05;
		int startDecrease = (int) Math.floor(dataLength * 3/5);
		int endDecrease = (int) Math.floor(dataLength * 4/5);
		double baseValue = 0.5;
		double highBaseValue = baseValue + (endIncrease-startIncrease)*changeRate;
		
		
		//Constant Load
		for(int i = 0; i < startIncrease; i++) {
			double rand = (Math.random() - 0.5)*2*0.02;
			cpuUtilisationExampleData[i] = baseValue + rand;
		}
		
		//Increasing Load
		for(int i = startIncrease; i < endIncrease; i++) {
			double rand = (Math.random() - 0.5)*2*0.02;
			cpuUtilisationExampleData[i] = baseValue + (i - startIncrease)*changeRate + rand;
		}
		
		//Constant High Load
		for(int i = endIncrease; i < startDecrease; i++) {
			double rand = (Math.random() - 0.5)*2*0.02;
			cpuUtilisationExampleData[i] = highBaseValue + rand;
		}
		
		//Decreasing Load
		for(int i = startDecrease; i < endDecrease; i++) {
			double rand = (Math.random() - 0.5)*2*0.02;
			cpuUtilisationExampleData[i] = baseValue + (endDecrease - i)*changeRate + rand;
		}
		
		
		//Constant Load
		for(int i = endDecrease; i < dataLength; i++) {
			double rand = (Math.random() - 0.5)*2*0.02;
			cpuUtilisationExampleData[i] = baseValue + rand;
		}
	}
	
	public void fillCPUDataScenario() {
		double baseValue = 0.5;
		double peakValue = 3;
		int timepointStartIncreasing = (int) Math.floor(0.2 * dataLength);
		int timepointReachingPeak = (int) Math.floor(0.3 * dataLength);
		int timepointPeakEnd = (int) Math.floor(0.6 * dataLength);
		int timepointBackToNormalLoad = (int) Math.floor(0.75 * dataLength);
		double increaseTime = timepointReachingPeak - timepointStartIncreasing;
		double timeAtPeak = timepointPeakEnd - timepointReachingPeak;
		double timeGoingBackToNormal = timepointBackToNormalLoad - timepointPeakEnd;
		double peakDifference = peakValue - baseValue;
		double valueAtPeakEnd = peakValue - 0.01 * timeAtPeak;
		
		for(int i = 0; i < timepointStartIncreasing; i++) {
			double rand = (Math.random() - 0.5)*2*0.02;
			cpuUtilisationExampleData[i] = baseValue + rand;
		}
		
		for(int i = timepointStartIncreasing; i <= timepointReachingPeak; i++) {
			double rand = (Math.random() - 0.25)*2*0.01;
			cpuUtilisationExampleData[i] = baseValue + (i+1-timepointStartIncreasing)/increaseTime * peakDifference + rand;
		}
		
		for(int i = timepointReachingPeak+1; i < timepointPeakEnd; i++) {
			double rand = (Math.random() - 0.25)*2*0.01;
			cpuUtilisationExampleData[i] = peakValue - 0.01 * (i+1-timepointReachingPeak) + rand;
		}
		
		for(int i = timepointPeakEnd; i < timepointBackToNormalLoad; i++) {
			double rand = (Math.random() - 0.25)*2*0.02;
			cpuUtilisationExampleData[i] = baseValue + (timepointBackToNormalLoad - i)/timeGoingBackToNormal * (valueAtPeakEnd - baseValue) + rand;
		}
		
		for(int i = timepointBackToNormalLoad; i < dataLength; i++) {
			double rand = (Math.random() - 0.5)*2*0.02;
			cpuUtilisationExampleData[i] = baseValue + rand;
		}
	}
	
	public Double[] getCpuUtilisationExampleData() {
		return this.cpuUtilisationExampleData;
	}
}
