package org.palladiosimulator.spd.design;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.measure.Measure;
import javax.measure.quantity.Duration;
import javax.swing.JFrame;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.palladiosimulator.spd.triggers.SimpleFireOnValue;
import org.palladiosimulator.spd.triggers.impl.SimpleFireOnValueImpl;

import simulizarmeasuringpoint.SimulizarmeasuringpointPackage;

import org.palladiosimulator.edp2.dao.MeasurementsDao;
import org.palladiosimulator.edp2.dao.exception.DataNotAccessibleException;
import org.palladiosimulator.edp2.impl.RepositoryManager;
import org.palladiosimulator.edp2.local.LocalDirectoryRepository;
import org.palladiosimulator.edp2.local.localFactory;
import org.palladiosimulator.edp2.models.ExperimentData.DataSeries;
import org.palladiosimulator.edp2.models.ExperimentData.ExperimentGroup;
import org.palladiosimulator.edp2.models.ExperimentData.ExperimentRun;
import org.palladiosimulator.edp2.models.ExperimentData.ExperimentSetting;
import org.palladiosimulator.edp2.models.ExperimentData.Measurement;
import org.palladiosimulator.edp2.models.ExperimentData.MeasurementRange;
import org.palladiosimulator.edp2.models.ExperimentData.RawMeasurements;
import org.palladiosimulator.edp2.models.Repository.Repositories;
import org.palladiosimulator.edp2.util.MeasurementsUtility;
import org.palladiosimulator.pcmmeasuringpoint.PcmmeasuringpointPackage;
import org.palladiosimulator.spd.examples.ExampleData;
import org.palladiosimulator.spd.examples.ExampleSimulator;

/**
 * The services class used by VSM.
 */
public class Services {
	private JFrame triggerGraph;
	private JFrame cooldownGraph;
	private JFrame targetGroupGraph;
	private Set<JFrame> openGraphs = new HashSet<JFrame>();
	private Double[] exampleData;
	private XYDataset dummySimulationDataset;
	private int dataSize = 100;
	
	private LocalDirectoryRepository repo;
	
	public Services() {
	}
	
	public EObject runSimulationHighLoad(EObject self) {
		ExampleData exDataInstance = new ExampleData(dataSize);
		exDataInstance.fillCPUDataScenario();
		exampleData = exDataInstance.getCpuUtilisationExampleData();
		ExampleSimulator simulator = new ExampleSimulator(exampleData);
		dummySimulationDataset = simulator.getCpuUtilisationExampleDataset();
		return self;
	}
	
	public EObject runSimulationConstantLoad(EObject self) {
		ExampleData exDataInstance = new ExampleData(dataSize);
		exDataInstance.fillCPUDataConstantLow();
		exampleData = exDataInstance.getCpuUtilisationExampleData();
		ExampleSimulator simulator = new ExampleSimulator(exampleData);
		dummySimulationDataset = simulator.getCpuUtilisationExampleDataset();
		return self;
	}
	
	public EObject runSimulationHighLoadThresholdLowered(EObject self) {
		ExampleData exDataInstance = new ExampleData(dataSize);
		exDataInstance.fillCPUDataScenario();
		exampleData = exDataInstance.getCpuUtilisationExampleData();
		ExampleSimulator simulator = new ExampleSimulator(exampleData, 0.6, 0.2, 0.1, 0.2, 2);
		dummySimulationDataset = simulator.getCpuUtilisationExampleDataset();
		return self;
	}
	
	public EObject runSimulationHighLoadUpAdjustmentRateRaised(EObject self) {
		ExampleData exDataInstance = new ExampleData(dataSize);
		exDataInstance.fillCPUDataScenario();
		exampleData = exDataInstance.getCpuUtilisationExampleData();
		ExampleSimulator simulator = new ExampleSimulator(exampleData, 0.8, 0.3, 0.2, 0.2, 2);
		dummySimulationDataset = simulator.getCpuUtilisationExampleDataset();
		return self;
	}
    
    /**
    * See http://help.eclipse.org/neon/index.jsp?topic=%2Forg.eclipse.sirius.doc%2Fdoc%2Findex.html&cp=24 for documentation on how to write service methods.
    */
    /*public EObject myService(EObject self, String arg) {
      * // TODO Auto-generated code
      *return self;
    }*/
    
    public SimpleFireOnValue createSFOVTrigger(EObject self) {
    	//SimpleFireOnValue sfovTrigger = TriggersFactory.eINSTANCE.createSimpleFireOnValue();
    	
    	return null;
    }
        
    public boolean triggerAnomaly(EObject self) {
    	if(dummySimulationDataset == null) return false;
    	
    	boolean notTriggered = true;
    	for(int i = 0; i < dataSize; i++) {
    		if(dummySimulationDataset.getYValue(3, i) == 1) {
    			notTriggered = false;
    		}
    	}
    	
    	return notTriggered;
    }
    
    public boolean cooldownAnomaly(EObject self) {
    	if(dummySimulationDataset == null) return false;
    	
    	boolean notTriggered = true;
    	for(int i = 0; i < dataSize; i++) {
    		if(dummySimulationDataset.getYValue(5, i) == 1) {
    			notTriggered = false;
    		}
    	}
    	
    	return notTriggered;
    }
    
    public boolean capacityAnomaly(EObject self) {
    	if(dummySimulationDataset == null) return false;
    	
    	int timeStepsAtVeryHighLoad = 0;
    	int timeStepsAtVeryLowLoad = 0;
    	for(int i = 0; i < dataSize; i++) {
    		if(dummySimulationDataset.getYValue(0, i) > 0.95) {
    			timeStepsAtVeryHighLoad++;
    		} else if(dummySimulationDataset.getYValue(0, i) < 0.05) {
    			timeStepsAtVeryLowLoad++;
    		}
    	}
    	return (timeStepsAtVeryHighLoad > 5 || timeStepsAtVeryLowLoad > 5);
    }
    
    public EObject openTriggerGraph(EObject self) {
    	
    	if(dummySimulationDataset == null) return self;

		triggerGraph = SimulationGraph.createUpscalingTriggerBarGraph(dummySimulationDataset);
    	
    	triggerGraph.setLocation(50, 200);
    	triggerGraph.setSize(600, 600);
    	triggerGraph.setVisible(true);
    	
    	openGraphs.add(triggerGraph);
    	openGraphs.forEach(f -> f.toFront());
    	
    	triggerGraph.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {}
			
			@Override
			public void windowIconified(WindowEvent e) {}
			
			@Override
			public void windowDeiconified(WindowEvent e) {}
			
			@Override
			public void windowDeactivated(WindowEvent e) {}
			
			@Override
			public void windowClosing(WindowEvent e) {
				openGraphs.remove(triggerGraph);
			}
			
			@Override
			public void windowClosed(WindowEvent e) {}
			
			@Override
			public void windowActivated(WindowEvent e) {}
		});
    	return self;
    }
    
    public EObject openTriggerLineGraph(EObject self) {
    	
    	if(dummySimulationDataset == null) return self;

		triggerGraph = SimulationGraph.createUpscalingTriggerLineGraph(dummySimulationDataset);
    	
    	triggerGraph.setLocation(50, 200);
    	triggerGraph.setSize(600, 600);
    	triggerGraph.setVisible(true);
    	
    	openGraphs.add(triggerGraph);
    	openGraphs.forEach(f -> f.toFront());
    	
    	triggerGraph.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {}
			
			@Override
			public void windowIconified(WindowEvent e) {}
			
			@Override
			public void windowDeiconified(WindowEvent e) {}
			
			@Override
			public void windowDeactivated(WindowEvent e) {}
			
			@Override
			public void windowClosing(WindowEvent e) {
				openGraphs.remove(triggerGraph);
			}
			
			@Override
			public void windowClosed(WindowEvent e) {}
			
			@Override
			public void windowActivated(WindowEvent e) {}
		});
    	return self;
    }
    
    
    
    public EObject openCooldownGraph(EObject self) {
    	
    	if(dummySimulationDataset == null) return self;
    	
    	cooldownGraph = SimulationGraph.createUpscalingCooldownBarGraph(dummySimulationDataset);
    	cooldownGraph.setLocation(400,50);
    	cooldownGraph.setSize(600,600);
    	cooldownGraph.setVisible(true);
    	
    	openGraphs.add(cooldownGraph);
    	openGraphs.forEach(f -> f.toFront());
    	
    	cooldownGraph.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {}
			
			@Override
			public void windowIconified(WindowEvent e) {}
			
			@Override
			public void windowDeiconified(WindowEvent e) {}
			
			@Override
			public void windowDeactivated(WindowEvent e) {}
			
			@Override
			public void windowClosing(WindowEvent e) {
				openGraphs.remove(cooldownGraph);
			}
			
			@Override
			public void windowClosed(WindowEvent e) {}
			
			@Override
			public void windowActivated(WindowEvent e) {}
		});
    	
    	return self;
    }
    
    public EObject openTargetGroupGraph(EObject self) {
    	
    	if(dummySimulationDataset == null) return self;
    	
    	targetGroupGraph = SimulationGraph.createLineGraph(dummySimulationDataset);
    	targetGroupGraph.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	targetGroupGraph.setLocation(600,400);
    	targetGroupGraph.setSize(600,600);    	
    	targetGroupGraph.setVisible(true);
    	openGraphs.add(targetGroupGraph);
    	openGraphs.forEach(f -> f.toFront());
    	
    	targetGroupGraph.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {}
			
			@Override
			public void windowIconified(WindowEvent e) {}
			
			@Override
			public void windowDeiconified(WindowEvent e) {}
			
			@Override
			public void windowDeactivated(WindowEvent e) {}
			
			@Override
			public void windowClosing(WindowEvent e) {
				openGraphs.remove(targetGroupGraph);
			}
			
			@Override
			public void windowClosed(WindowEvent e) {}
			
			@Override
			public void windowActivated(WindowEvent e) {}
		});
    	return self;
    }
    
    public EObject openTargetGroupGraphBasic(EObject self) {
    	
    	if(dummySimulationDataset == null) return self;
    	
    	targetGroupGraph = SimulationGraph.createBasicLineGraph(dummySimulationDataset);
    	targetGroupGraph.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	targetGroupGraph.setLocation(600,400);
    	targetGroupGraph.setSize(600,600);    	
    	targetGroupGraph.setVisible(true);
    	openGraphs.add(targetGroupGraph);
    	openGraphs.forEach(f -> f.toFront());
    	
    	targetGroupGraph.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {}
			
			@Override
			public void windowIconified(WindowEvent e) {}
			
			@Override
			public void windowDeiconified(WindowEvent e) {}
			
			@Override
			public void windowDeactivated(WindowEvent e) {}
			
			@Override
			public void windowClosing(WindowEvent e) {
				openGraphs.remove(targetGroupGraph);
			}
			
			@Override
			public void windowClosed(WindowEvent e) {}
			
			@Override
			public void windowActivated(WindowEvent e) {}
		});
    	return self;
    }
    
    private XYDataset getResponseTimeMeasurementsAsXYDataset() {
    	this.initPathmap();
    	this.loadRepoFromFile("F:/EigeneDateien/Studium/Semester 7/Bachelorarbeit/git/measures");
    	
    	List<ExperimentGroup> experGroups = this.repo.getExperimentGroups();

    	//gets measurements from only the latest experiment
        ExperimentGroup latestGroup = experGroups.get(experGroups.size()-1);
        final List<DataSeries> groupsSeries = this.getDataSerieses(latestGroup);
        
        //assumes 2 series: first is timestamps, second is values
        MeasurementsDao<Double, Duration> timestampDao = getDaoWithUtility(groupsSeries.get(0));
        List<Measure<Double, Duration>> timestampMeasurements = timestampDao.getMeasurements();
        
        MeasurementsDao<Double, Duration> valueDao = getDaoWithUtility(groupsSeries.get(1));
        List<Measure<Double, Duration>> valueMeasurements = valueDao.getMeasurements();
        
        XYSeries data = new XYSeries("Response Times");
        
        for(int i = 0; i < timestampMeasurements.size(); i++) {
        	//System.out.println(timestampMeasurements.get(i).getValue() + ": " + valueMeasurements.get(i).getValue());
        	data.add(timestampMeasurements.get(i).getValue(), valueMeasurements.get(i).getValue());
        }
        
        XYDataset xyDataset = new XYSeriesCollection(data);        
        
        try {
            timestampDao.close();
        } catch (DataNotAccessibleException e) {
            e.printStackTrace();
        }

        try {
            valueDao.close();
        } catch (DataNotAccessibleException e) {
            e.printStackTrace();
        }
        
        return xyDataset;
    }
   
    private void initPathmap() {
        final URL url = getClass().getClassLoader()
            .getResource("commonMetrics.metricspec"); // c.f. plugin dependecies, it's really there
        String urlString = url.toString();
        final URI uri = URI.createURI(urlString)
            .trimSegments(1);

        URIConverter.URI_MAP.put(URI.createURI("pathmap://METRIC_SPEC_MODELS/"), uri);

        final Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
        final Map<String, Object> m = reg.getExtensionToFactoryMap();
        m.put("metricspec", new XMIResourceFactoryImpl());
    }
    
    private void loadRepoFromFile(final String measuresDirectory) {
    	File edp2Directory = new File(measuresDirectory);
    	

        // initialize these, because the edp2 model depends on them.
        PcmmeasuringpointPackage pcmMeasuringpointPackage = PcmmeasuringpointPackage.eINSTANCE;
        SimulizarmeasuringpointPackage simulizarMeasuringPointPackage = SimulizarmeasuringpointPackage.eINSTANCE;

        this.repo = localFactory.eINSTANCE.createLocalDirectoryRepository();
        // the lower case 'l' might be confusing, but localFactory is still a class.

        URL url = null;
		try {
			url = edp2Directory.toURI().toURL();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        final URI uri = URI.createURI(url.toString());
        this.repo.setUri(uri.toString());

        Repositories repos = RepositoryManager.getCentralRepository();
        RepositoryManager.addRepository(repos, this.repo);
        // adding the repo to the manager also opens the repo.
    }
    
    private List<DataSeries> getDataSerieses(final ExperimentGroup group) {
        final ExperimentSetting setting = group.getExperimentSettings()
            .get(0);
        final ExperimentRun run = setting.getExperimentRuns()
            .get(0);
        final Measurement meas = run.getMeasurement()
            .get(0);
        final MeasurementRange range1 = meas.getMeasurementRanges()
            .get(0);
        final RawMeasurements raw = range1.getRawMeasurements();
        return raw.getDataSeries();
    }
    
    private MeasurementsDao<Double, Duration> getDaoWithUtility(final DataSeries series) {
        return (MeasurementsDao<Double, Duration>) MeasurementsUtility.<Duration> getMeasurementsDao(series);
    }  
    
    public String getExpectedValueName(SimpleFireOnValueImpl self) {
    	return self.getExpectedValue().eClass().getName();    	
    }
    
    public String getStimulusName(EObject self) {
    	return ((SimpleFireOnValueImpl) self).getStimulus().eClass().getName();
    }
    
    

    public static void main(String args[]) {
    	Services service = new Services();

    	//service.openTriggerGraph(null);
    	
    	JFrame graph = SimulationGraph.createLineGraph(service.dummySimulationDataset);
    	graph.setLocation(400, 400);
        graph.setSize(800, 600);
        graph.setVisible(true);
    	
    	//service.openTriggerSimulationGraph(null);
    
    	/*
    	JFrame frame = new JFrame();
    	 
    	JFreeChart chart = ChartFactory.createXYStepChart("", "", "", service.getResponseTimeMeasurementsAsXYDataset(), PlotOrientation.VERTICAL, true, true, false);
		ChartPanel panel = new ChartPanel(chart);
        panel.setMouseWheelEnabled(true);
        frame.add(panel);
        
        frame.setLocation(400, 400);
        frame.setSize(800, 600);
        frame.setVisible(true);
        */
    }

    
}
