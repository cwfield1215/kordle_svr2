package org.bmchsd.cwfield.kordle_svr.controller;

import java.util.ArrayList;
import java.util.List;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import org.bmchsd.cwfield.kordle_svr.model.KordleResult;
import org.bmchsd.cwfield.kordle_svr.service.KordleService;

@RestController
public class KordleController {

    private static Logger logger = Logger.getLogger("org.bmchsd.org.cwfield");

    @Autowired
    KordleService resultService;

    @GetMapping("/result")  
    private List<KordleResult> getAllResult()   
    {  
        logger.info("Inside getAllResult()");
        return resultService.getAllResult();  
    } 

    @GetMapping("/result/{id}")  
    private KordleResult getResult(@PathVariable("id") int id)   
    {  
        logger.info("Inside getResult()");
        return resultService.getResultById(id);  
    }  

    @PostMapping("/result")  
    private int saveResult(@RequestBody KordleResult result)   
    {  
        logger.info("Inside saveResult()");
        resultService.saveOrUpdate(result);  
        return result.getId();  
    }  




	//private static final String template = "Hello, %s!";
	//private final AtomicLong counter = new AtomicLong();

	// @GetMapping("/result/{user}")
	// public KordleResult GetResultForId(@PathVariable(value = "user") String user) {
	// 	return new KordleResult(counter.incrementAndGet(), user, 0, 1, "solved");
	// }

    // @GetMapping("/result")
    // public @ResponseBody List<KordleResult> ListResults() {
    //     KordleResult kr = new KordleResult(counter.incrementAndGet(), "chrfield", 0, 1, "solved");
    //     ArrayList <KordleResult> krl = new ArrayList<KordleResult>();
    //     krl.add(kr);
    //     return krl;
    // }

    // @PostMapping("/result") 
    // public KordleResult CreateResult(@RequestBody KordleResult kr) {
    //     KordleResult kr2 = new KordleResult(
    //         counter.incrementAndGet(),
    //         kr.getUser(),
    //         kr.getTimeMillis(),
    //         kr.getNumTries(),
    //         kr.getOutcome());
    //     return kr2;
    // }   
}
