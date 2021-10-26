package com.pedantic.entity;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "TODO")
@NamedQuery(name = "findAllByTodoOwnerId", query = "SELECT t FROM Todo t WHERE t.todoOwner.id = :ownerId")
public class Todo extends BaseEntity {

    @Column(name = "TASK", length = 140)
    @NotEmpty(message = "A Todo task must be set")
    @Size(min = 3, max = 140, message = "The minimum character length should be between {min} and {max}")
    private String task;

    @Column(name = "DATE_CREATED")
    private LocalDate dateCreated;

    @Column(name = "DUE_DATE", nullable = false)
    @NotNull(message = "Due date must be set")
    @FutureOrPresent(message = "Due date cannot be before today")
    @JsonbDateFormat(value="yyyy-MM-dd")
    private LocalDate dueDate;

    @Column(name = "COMPLETED")
    private boolean completed;

    @Column(name = "ARCHIVED")
    private boolean archived;

    @Column(name = "REMIND")
    private boolean remind;

    @ManyToOne
    @JoinColumn(name = "TODO_USER_ID")
    private TodoUser todoOwner;

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public boolean isRemind() {
        return remind;
    }

    public void setRemind(boolean remind) {
        this.remind = remind;
    }

    public TodoUser getTodoOwner() {
        return todoOwner;
    }

    public void setTodoOwner(TodoUser todoOwner) {
        this.todoOwner = todoOwner;
    }
}
