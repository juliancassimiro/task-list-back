package br.dev.jc.challenge.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity()
@Table(name = "changes_log")
public class BDChangerListener {

    @Id
    private int id;
    private String tableName;
    private String operation;
    private  String oldData;
    private String newData;
    private Boolean processed;

    public String getTableName() {
        return tableName;
    }

    public String getOperation() {
        return operation;
    }

    public String getOldData() {
        return oldData;
    }

    public String getNewData() {
        return newData;
    }

    public void setProcessed() {
        this.processed = true;
    }

}
