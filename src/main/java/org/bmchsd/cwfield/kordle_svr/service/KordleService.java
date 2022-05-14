package org.bmchsd.cwfield.kordle_svr.service;

import java.util.ArrayList;  
import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;  

import org.bmchsd.cwfield.kordle_svr.model.*;
import org.bmchsd.cwfield.kordle_svr.repository.KordleResultRepository;  

@Service  
public class KordleService   
{  
    @Autowired  
    KordleResultRepository resultRepository;  

    public List<KordleResult> getAllResult()   
    {  
    List<KordleResult> results = new ArrayList<KordleResult>();  
        resultRepository.findAll().forEach(result -> results.add(result));  
        return results;  
    }  

    //getting a specific record  
    public KordleResult getResultById(int id)   
    {  
        return resultRepository.findById(id).get();  
    }  

    public void saveOrUpdate(KordleResult result)   
    {  
        resultRepository.save(result);  
    }  

    //deleting a specific record  
    public void delete(int id)   
    {  
        resultRepository.deleteById(id);  
    }  
}  

