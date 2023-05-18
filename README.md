# UserStudyScalingWorkflow

First of all, thank you very much for taking some time out of your day to participate in this user study.
This README file will tell you everything you need to know and understand about the background and the elements of this study as well as guide you through the study itself.

The project this study is linked to is trying to enrich a graphical editor for Scaling Policy Definitions (SPDs), that lets users design scaling policies for cloud systems with a novel possibility to integrate data gained from simulations into the editor as opposed to the separate dashboards that are currently mainly used to view all kinds of data graphs on. The editor is built on the frameworks of the Palladio simulator, which is a simulator for software architectures. Because of this, we will primarily compare the new workflow with the workflow that uses the graphs which Palladio provides.

This study aims to collect feedback on the usability of the workflow in comparison to the current workflows and it’s usability in general, the usefulness of certain design ideas as well as on features, the participants would like to see being added to enhance the user experience further. For this, I would like to add that the project you will try is a prototype that only shows surface level design decisions. Because of this, at some points during this study, I will need you to imagine the prototype to work as I will tell you it is intended to work in an actual product later down the line.

For this study, we will follow the following scenario:
You are working at a company which provides a website on which students can sign up for courses and access materials from these courses. This website is hosted on a cloud system in order to accommodate changing amounts of students accessing it at any point in time. You are tasked with creating scaling policies for this cloud system which automatically ensures that the website at any point in time does neither get a lot of unused (but still paid for) cloud resources, nor too little, which would mean that the site is struggling to handle the load, or that these unwanted situations are at least kept to a minimum. For the sake of simplicity, we will use the CPU-Utilization as the only resource being tracked. I will fall back on this scenario later during the study.

## Setup Instruction
Download and unpack the [Palladio Bench](https://updatesite.palladio-simulator.com/palladio-bench-product/releases/5.1.0/) version for your system as well as the [JDK 11.0.2](https://jdk.java.net/archive/). 
Palladio Bench is a version of Eclipse that has all of the plug-ins we will need pre-installed.
Inside of the unzipped Palladio Bench folder you should find the executable for the application. Open Palladio Bench by clicking this executable.

The project is running on Java 11, so we are going to have to set the JDK 11 as the build path for our project. To do this, in the menu bar on top of your Palladio Bench window click on "Window" and there on "Preferences". Here, open the tree for Java by clicking on the arrow in front of the Java section.
We first have to set the Compiler Compliance Level to 11, otherwise there will be errors further down the line. To do this, click on the "Compiler" Section and set the value of "Compiler compliance level" to 11.
After that, click on "Installed JREs". Here we have to add and activate our JDK 11.
Click on "Add", choose the "Standard VM" and click on Next. Here, click on "Directory..." and select the jdk-11.0.2 folder that you should find inside of the unzipped JDK 11 folder. Now click on "Finish". Back in the main properties window of the installed JREs, select the checkbox of your 11.0.2 JDK in order to set it as the active JDK.
You can now click on "Apply and Close".

Next you have to import the projects.
Set the "bundles" folder from this repository as the root directory, select the projects ending in "spd", "spd.edit" and "spd.editor" and click on "Finish".
Wait a few seconds for the projects to load, then, every error should be resolved.

Now we have to create a new Eclipse runtime.
Open the "Run Configurations" dialog and double click on Eclipse Application.

![Configurations: Run an org.eclipse.ui.ide.workbench application with JDK 11.0.2](img/User%20Study%20Eclipse%20Runtime%20Configuration.png)

Change the configurations to match the ones in the picture above, then run the new application.
If you get a popup with some Validation problems, just click on continue.

In the now opened Eclipse application, import the projects ending in "spd", "spd.design" and the "user_study_sample".
Now everything should be imported without errors and ready to be used in the study. 

# Introduction to the graphical editor
I will now give a quick introduction to the elements of the graphical editor to help you understand what you will be working with.

![Location of SPD Configuration Model](img/Open%20Configuration%20Model.png)

If you click through the folder of the "user_study_sample" as shown in the picture above. Under the representations.aird you find some different viewpoints through which we will go through in this study. By opening up the tree all the way to the innermost element and clicking on this element, a diagram will open.
Please open the "SPD Configuration Model"

You should now see this diagram:

![SPD Configuration Diagram](img/SPD%20Configuration%20Diagram.png)

In this viewpoint you would build and make changes to the scaling policies. In this study, you will work with this setup and think of changes you could make, but not actually change anything about these policies, however in a real situation, you would come to this viewpoint every time you want to make changes to the policies.

As you can see, we have two policies, one for upscaling and one for downscaling which control the amount of available resources of the cloud system. A policy consists of a trigger (left of policy core), an adjustment (right of policy core) and can have several constraints or no constraints (above policy core).
The triggers are intended to have labels similar to the other elements, however the modeling tool made it very difficult to access the needed values, so I will need you to keep in mind, that there should be an ">80%" label for the "UpscalingPolicy" and a "<20%" label for the "DownscalingPolicy".

You can understand the policies as follows:

![Policy Description](img/Policy%20Description.png)

## Workflows

### Palladio Workflow

I will quickly introduce the Palladio workflow and the new workflow we will test out.

![Workflow Palladio](img/Workflow%20Palladio.png)

This is what the current Palladio workflow looks like. 
You can reference this to get a better overview while I will explain the steps a bit more.
Once we have created the policies, we run a simulation by clicking on the green run button in the top bar of the Palladio Bench (this assumes that the simulator has already bin configured). If our active Eclipse perspective is the "Palladio" perspective, there is an "Experiments" tab right next to the "Model Explorer" tab on the left. In this tab, there is a list of all the experiment runs we have done for the current experiment series.

![Palladio Experiments Tab](img/Palladio%20Experiments%20Tab.png)

The Experiments in the image are unrelated to our study and only to show you how this tab would look like in practice. In the picture we can see data on for example the the response times for resource demands concerning CPU and HDD. We can now double click on, for example, the CPU Resource Demand Tuple.
We then have to select a visualization type:
![Palladion Visualization Selection](img/Palladio%20Visualization%20Selection.png)
Which then opens the corresponding response time graph using the chosen visualization method.
Every time we want to open a different graph we have to go through these exact same steps.
After having gained an idea of what we would like to change, we then open the viewpoint of the spd configuration again and make changes to the policies. The two types of changes that are interesting for our study are changing the thresholds and the adjustment rates.

### New Workflow
The new workflow overall has the same structure, however instead of clicking through the "Experiments" tab we switch to the simulation result view which, as you will see shortly, looks almost identical to the "SPD Configuration Model".
All of the remaining viewpoints that you find under the "representations.aird" are variants of this simulation result view. In the end, one will only have one configuration view and one simulation result view.
The difference in between the configuration view and the simulation result view is that the latter does not allow the user to make changes to the policies, but the color of the elements can change to red if certain anomalies occur and that double clicking on trigger, constraints and the "CloudSystemController" opens graphs that display certain data series (note that only graphs on the elements of the "UpscalingPolicy" are shown, even if you click the elements of the downscaling policy). For this study, the implemented anomalies are for triggers and constraints are that they did not get activated at all, for the "CloudSystemController" it is that the CPU Utilization is very high or very low for an extended period of time (to be exact if it is not between 5% and 95% for 5 of our 100 simulated time steps). What is shown in the graphs and how it is represented varies between our different user study viewpoints and is on of the points being investigated.

The general workflow looks as follows:
![Workflow new](img/Workflow%20new.png)

In real situtations, the simulations are run the same way as the ones in the Palladio workflow by clicking on the green run button. Since this is only a prototype which does not yet have access to actual simulation data, I have added a simple simulator of my own. To run these simulations, you have to click on the policy core right underneath of one of the names of the polices (it does not matter which one). Please run a simulation this way at any time you change to a different simulation result view.

You will try only try out the part of this workflow which works in the simulation result view. However, for the questions about the general workflows in the questionnaire, I would like you to keep in mind and critique this whole workflow.

## Antipatterns
I will introduce some antipatterns that have been worked out by [this paper](https://dl.acm.org/doi/abs/10.1145/3578244.3583721). These Antipatterns describe some unwanted occurences one might find. They compiled the following antipatterns (taken from the paper):
![Antipattern List](img/Antipattern%20List.png)

We will define the SLOs for our scenario to be "Utilization should be between 40% and 60% for at least 80% of the time" and "Utilization should be between 5% and 95% for 95% of the time" (reminder: the second SLO is equal to the anomaly of the "CloudSystemController").


## Study Execution
Now you should have all of the background information you need to understand and be able to assess the things you will see and work with during the study.
This chapter will guide you through the actual part of the study.

Calling back to the scenario I introduced in the beginning, we will have two situations in this scenario.

In the "Constant Load" situation, it is evening and the load on the system is constantly low. Your task after running the simulation is to discover antipatterns, to think of how the policies could be improved and assess how well the interactions you have with the diagram can help you understand how to improve the policies. Please note down the antipatterns you discovered in this viewpoint, you will have to remember these for the questionnaire.
Please open the "UserStudyConstantLoad" view like descriped further above.
Before you run the simulation, you can observe that all of the elements are colored the same way as they are in the configuration view. Upon running the simulation, these will change to reflect the anomalies in the elements.

After you have finished your task for this viewpoint, we move on to the "High Load" situation. Here, there is an event where an unusually high amount of students want to sign up for a certain course that only has a limited number of slots. Because of this, shortly before the sign up period starts, a lot of students visit the site and try to sign up for this course. Since some people are getting, some of them leave the site after successfully signing up which slowly decreases the load. After all the slots are full, the traffic of the site goes back to normal.
Please open the diagrams for "UserStudyHighLoadVar1" and "UserStudyHighLoadVar2".
The simulation for these two viewpoints is the same, however there are some differences in the graphs between the two variants.
Your task for both viewpoints stays the same as for the first viewpoint, but please pay special attention to the different approaches to representing trigger graph and CPU utilization graph of the two variants to later be able to compare the two.

The remaining two viewpoints contain simulations of the high load situation that have been run after one iteration of the simulate-assess-improve-cycle. For these two, you do not have to note antipatterns, their purpose is for you to be able to see a second iteration of this cycle to be able to better assess, how well the previous viewpoints helped your understanding of what could be changed in this situation. In one viewpoint, the upper threshold has been set from 80% to 60%, in the other viewpoint the upscaling adjustment rate has been increased from 10% to 30%.

After going through all of the viewpoints, please fill in this [questionnaire](https://forms.gle/C9PbDrGrz3MxpSYZA). The questionnaire is completely anonymous and no E-Mail addresses will be saved.

After you have finished filling in the questionnaire, the study is finished. Thank you again very much for participating in this study and have a nice rest of your day.
