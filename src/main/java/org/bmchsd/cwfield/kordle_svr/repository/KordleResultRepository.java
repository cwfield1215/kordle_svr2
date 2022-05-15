package org.bmchsd.cwfield.kordle_svr.repository;

import org.springframework.data.repository.CrudRepository;  
import org.bmchsd.cwfield.kordle_svr.model.*;

import org.springframework.data.jpa.repository.Query;

import java.util.List;  

public interface KordleResultRepository extends CrudRepository<KordleResult, Integer>  
{  
    @Query("select k from KordleResult k where k.outcome = 'solved' order by k.numTries, k.timeMillis")
    public List<KordleResult> getLeaderboard();
}  
