package org.bmchsd.cwfield.kordle_svr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class KordleResult {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    // //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String user;
    @Column
    private long timeMillis;
    @Column
    private int numTries;
    @Column
    private String outcome;

    public KordleResult() {
    }

    public KordleResult(int id, String user, long timeMillis, int numTries, String outcome) {
        this.id = id;
        this.user = user;
        this.timeMillis = timeMillis;
        this.numTries = numTries;
        this.outcome = outcome;
    }

    public int getId() {
        return id;
    }

    public String getUser() {
        return user;
    }

    public long getTimeMillis() {
        return timeMillis;
    }

    public int getNumTries() {
        return numTries;
    }
    
    public String getOutcome() {
        return outcome;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setTimeMillis(long timeMillis) {
        this.timeMillis = timeMillis;
    }

    public void setNumTries(int numTries) {
        this.numTries = numTries;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }
}
