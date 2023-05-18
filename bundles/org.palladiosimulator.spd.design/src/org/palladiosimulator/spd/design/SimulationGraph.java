package org.palladiosimulator.spd.design;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeriesCollection;

public class SimulationGraph extends JFrame {
	
	public static SimulationGraph createLineGraph(XYDataset xyDataset) {
		SimulationGraph graph = new SimulationGraph();
		JFreeChart chart = ChartFactory.createXYLineChart("", "", "", xyDataset, PlotOrientation.VERTICAL, true, true, false);
		chart.setTitle("CPU Utilisation");
		XYPlot xyPlot = chart.getXYPlot();
		xyPlot.setDomainAxis(new NumberAxis(""));
		NumberAxis domain = (NumberAxis) xyPlot.getDomainAxis();
		domain.setRange(0, xyDataset.getItemCount(0)-1);
		domain.setAutoTickUnitSelection(true);
		
		NumberAxis range = (NumberAxis) xyPlot.getRangeAxis();
        range.setRange(-0.05, 1.05);
        range.setTickUnit(new NumberTickUnit(0.1));
        
		ChartPanel panel = new ChartPanel(chart);
        panel.setMouseWheelEnabled(true);
        graph.add(panel);
        graph.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        return graph;
	}
	
	public static SimulationGraph createBasicLineGraph(XYDataset xyDataset) {
		SimulationGraph graph = new SimulationGraph();
		XYSeriesCollection basicCollection = new XYSeriesCollection();
		basicCollection.addSeries(((XYSeriesCollection) xyDataset).getSeries("CPU Utilisation"));
		basicCollection.addSeries(((XYSeriesCollection) xyDataset).getSeries("Upper Threshold"));
		basicCollection.addSeries(((XYSeriesCollection) xyDataset).getSeries("Lower Threshold"));
		XYDataset basicDataset = basicCollection;
		JFreeChart chart = ChartFactory.createXYLineChart("", "", "", basicDataset, PlotOrientation.VERTICAL, true, true, false);
		chart.setTitle("CPU Utilisation");
		XYPlot xyPlot = chart.getXYPlot();
		xyPlot.setDomainAxis(new NumberAxis(""));
		NumberAxis domain = (NumberAxis) xyPlot.getDomainAxis();
		domain.setRange(0, xyDataset.getItemCount(0)-1);
		domain.setAutoTickUnitSelection(true);
		
		NumberAxis range = (NumberAxis) xyPlot.getRangeAxis();
        range.setRange(-0.05, 1.05);
        range.setTickUnit(new NumberTickUnit(0.1));
        
		ChartPanel panel = new ChartPanel(chart);
        panel.setMouseWheelEnabled(true);
        graph.add(panel);
        graph.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        return graph;
	}
	
	public static SimulationGraph createStepGraph(XYDataset xyDataset) {
		SimulationGraph graph = new SimulationGraph();
		JFreeChart chart = ChartFactory.createXYStepChart("", "", "", xyDataset, PlotOrientation.VERTICAL, true, true, false);
		chart.setTitle("CPU Utilisation");
		XYPlot xyPlot = chart.getXYPlot();
		xyPlot.setDomainAxis(new NumberAxis(""));
		NumberAxis domain = (NumberAxis) xyPlot.getDomainAxis();
		domain.setRange(0, xyDataset.getItemCount(0));
		domain.setAutoTickUnitSelection(true);
		
		NumberAxis range = (NumberAxis) xyPlot.getRangeAxis();
        range.setRange(-0.05, 1.05);
        
		ChartPanel panel = new ChartPanel(chart);
        panel.setMouseWheelEnabled(true);
        graph.add(panel);
        graph.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        return graph;
	}
	
	public static SimulationGraph createUpscalingTriggerLineGraph(XYDataset dataset) {
		SimulationGraph graph = new SimulationGraph();
		XYSeriesCollection dataseriesCollection = (XYSeriesCollection) dataset;
		XYDataset upscalingDataset = new XYSeriesCollection(dataseriesCollection.getSeries("Upscaling Events"));
		
		JFreeChart chart = ChartFactory.createXYLineChart("", "", "", upscalingDataset, PlotOrientation.VERTICAL, true, true, false);
		chart.setTitle("Trigger Firing Behaviour");
		XYPlot xyPlot = chart.getXYPlot();
		xyPlot.setDomainAxis(new NumberAxis(""));
		NumberAxis domain = (NumberAxis) xyPlot.getDomainAxis();
		domain.setRange(0, upscalingDataset.getItemCount(0));
		domain.setAutoTickUnitSelection(true);
		
		NumberAxis range = (NumberAxis) xyPlot.getRangeAxis();
        range.setRange(-0.05, 1.05);
        
		ChartPanel panel = new ChartPanel(chart);
        panel.setMouseWheelEnabled(true);
        graph.add(panel);
        graph.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		return graph;
	}
	
	public static SimulationGraph createUpscalingTriggerStepGraph(XYDataset dataset) {
		SimulationGraph graph = new SimulationGraph();
		XYSeriesCollection dataseriesCollection = (XYSeriesCollection) dataset;
		XYDataset upscalingDataset = new XYSeriesCollection(dataseriesCollection.getSeries("Upscaling Events"));
		
		JFreeChart chart = ChartFactory.createXYStepChart("", "", "", upscalingDataset, PlotOrientation.VERTICAL, true, true, false);
		chart.setTitle("Trigger Firing Behaviour");
		XYPlot xyPlot = chart.getXYPlot();
		xyPlot.setDomainAxis(new NumberAxis(""));
		NumberAxis domain = (NumberAxis) xyPlot.getDomainAxis();
		domain.setRange(0, upscalingDataset.getItemCount(0));
		domain.setAutoTickUnitSelection(true);
		
		NumberAxis range = (NumberAxis) xyPlot.getRangeAxis();
        range.setRange(-0.05, 1.05);
        
		ChartPanel panel = new ChartPanel(chart);
        panel.setMouseWheelEnabled(true);
        graph.add(panel);
        graph.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		return graph;
	}
	
	public static SimulationGraph createUpscalingTriggerBarGraph(XYDataset dataset) {
		SimulationGraph graph = new SimulationGraph();
		XYSeriesCollection dataseriesCollection = (XYSeriesCollection) dataset;
		IntervalXYDataset upscalingDataset = new XYSeriesCollection(dataseriesCollection.getSeries("Upscaling Events"));
		
		JFreeChart chart = ChartFactory.createXYBarChart("", "", false, "", upscalingDataset, PlotOrientation.VERTICAL, true, true, false);
		chart.setTitle("Trigger Firing Behaviour");
		XYPlot xyPlot = chart.getXYPlot();
		xyPlot.setDomainAxis(new NumberAxis(""));
		NumberAxis domain = (NumberAxis) xyPlot.getDomainAxis();
		domain.setRange(0, upscalingDataset.getItemCount(0));
		domain.setAutoTickUnitSelection(true);
		
		NumberAxis range = (NumberAxis) xyPlot.getRangeAxis();
        range.setRange(-0.05, 1.05);
        
		ChartPanel panel = new ChartPanel(chart);
        panel.setMouseWheelEnabled(true);
        graph.add(panel);
        graph.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		return graph;
	}
	
	public static SimulationGraph createDownscalingTriggerBarGraph(XYDataset dataset) {
		SimulationGraph graph = new SimulationGraph();
		XYSeriesCollection dataseriesCollection = (XYSeriesCollection) dataset;
		IntervalXYDataset upscalingDataset = new XYSeriesCollection(dataseriesCollection.getSeries("Downscaling Events"));
		
		JFreeChart chart = ChartFactory.createXYBarChart("", "", false, "", upscalingDataset, PlotOrientation.VERTICAL, true, true, false);
		chart.setTitle("Trigger Firing Behaviour");
		XYPlot xyPlot = chart.getXYPlot();
		xyPlot.setDomainAxis(new NumberAxis(""));
		NumberAxis domain = (NumberAxis) xyPlot.getDomainAxis();
		domain.setRange(0, upscalingDataset.getItemCount(0));
		domain.setAutoTickUnitSelection(true);
		
		NumberAxis range = (NumberAxis) xyPlot.getRangeAxis();
        range.setRange(-0.05, 1.05);
        
		ChartPanel panel = new ChartPanel(chart);
        panel.setMouseWheelEnabled(true);
        graph.add(panel);
        graph.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		return graph;
	}
	
	public static SimulationGraph createUpscalingCooldownBarGraph(XYDataset dataset) {
		SimulationGraph graph = new SimulationGraph();
		XYSeriesCollection dataseriesCollection = (XYSeriesCollection) dataset;
		IntervalXYDataset upscalingDataset = new XYSeriesCollection(dataseriesCollection.getSeries("Cooldown Preventing Upscaling"));
		
		JFreeChart chart = ChartFactory.createXYBarChart("", "", false, "", upscalingDataset, PlotOrientation.VERTICAL, true, true, false);
		chart.setTitle("Cooldown Restraint Behaviour");
		XYPlot xyPlot = chart.getXYPlot();
		xyPlot.setDomainAxis(new NumberAxis(""));
		NumberAxis domain = (NumberAxis) xyPlot.getDomainAxis();
		domain.setRange(0, upscalingDataset.getItemCount(0));
		domain.setAutoTickUnitSelection(true);
		
		NumberAxis range = (NumberAxis) xyPlot.getRangeAxis();
        range.setRange(-0.05, 1.05);
        
		ChartPanel panel = new ChartPanel(chart);
        panel.setMouseWheelEnabled(true);
        graph.add(panel);
        graph.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		return graph;
	}

}
