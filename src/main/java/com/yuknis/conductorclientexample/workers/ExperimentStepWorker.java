package com.yuknis.conductorclientexample.workers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.conductor.client.worker.Worker;
import com.netflix.conductor.common.metadata.tasks.Task;
import com.netflix.conductor.common.metadata.tasks.TaskResult;
import com.yuknis.conductorclientexample.models.Person;

public class ExperimentStepWorker implements Worker {

    protected ObjectMapper objectMapper = new ObjectMapper();

    protected String taskDefName;

    /**
     * Empty constructor
     *
     */
    protected ExperimentStepWorker() {
        // ...
    }

    /**
     * Creates a new, fully initialized worker
     *
     * @param taskDefName
     */
    public ExperimentStepWorker(String taskDefName) {
        this.setTaskDefName(taskDefName);
    }

    public void setTaskDefName(String taskDefName) {
        this.taskDefName = taskDefName.trim();
    }

    /**
     * Retrieve the name of the task definition the worker is currently working on.
     *
     * @return the name of the task definition.
     */
    @Override
    public String getTaskDefName() {
        return this.taskDefName;
    }

    /**
     * Executes a task and returns the updated task.
     *
     * @param task Task to be executed.
     * @return the {@link TaskResult} object
     * If the task is not completed yet, return with the status as IN_PROGRESS.
     */
    @Override
    public TaskResult execute(Task task) {

        TaskResult result = new TaskResult(task);

        Person.PersonFactory personFactory = new Person.PersonFactory();
        Person person = personFactory.create(task.getInputData());

        System.out.println();
        System.out.println("The map's contents were:");
        System.out.println(task.getInputData());
        System.out.println();
        System.out.println("The objects's contents were:");
        System.out.println(person);

        result.setStatus(TaskResult.Status.COMPLETED);

        return result;
    }
}
