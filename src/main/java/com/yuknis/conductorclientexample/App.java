package com.yuknis.conductorclientexample;

import com.netflix.conductor.client.http.TaskClient;
import com.netflix.conductor.client.task.WorkflowTaskCoordinator;
import com.yuknis.conductorclientexample.workers.ExperimentStepWorker;

public class App {

    public static void main(String[] args) {

        TaskClient taskClient = new TaskClient();
        taskClient.setRootURI("http://10.1.10.54:8080/api/");

        ExperimentStepWorker worker1 = new ExperimentStepWorker("worker_1");
        ExperimentStepWorker worker2 = new ExperimentStepWorker("worker_2");
        ExperimentStepWorker worker3 = new ExperimentStepWorker("worker_3");

        WorkflowTaskCoordinator.Builder builder = new WorkflowTaskCoordinator.Builder();
        WorkflowTaskCoordinator coordinator = builder
                                                        .withWorkers(worker1, worker2, worker3)
                                                        .withThreadCount(3)
                                                        .withTaskClient(taskClient)
                                                        .build();

        coordinator.init();

    }
}
