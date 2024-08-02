package br.dev.jc.challenge.model;

import br.dev.jc.challenge.enums.Priority;
import br.dev.jc.challenge.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Título é obrigatório")
    private String title;

    @NotBlank(message = "Descrição é obrigatória")
    private String description;

    @NotNull(message = "Prioridade é obrigatória")
    @Enumerated(EnumType.STRING)
    private Priority priority;

    @NotNull(message = "Status é obrigatório")
    @Enumerated(EnumType.STRING)
    private Status status;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String toString() {
        return String.format("Tarefa Id=[%d], Titulo=%s, Descrição=%s, Prioridade=%s, Status=%s",
                id, title, description, priority, status);
    }
}
