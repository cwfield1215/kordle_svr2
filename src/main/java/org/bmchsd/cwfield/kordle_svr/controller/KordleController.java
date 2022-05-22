package org.bmchsd.cwfield.kordle_svr.controller;

import java.util.List;

import java.util.logging.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        logger.info(result.toString());
        //log values from post
        resultService.saveOrUpdate(result);  
        return result.getId();  
    } 
    

    //spring boot request parameter, path variable (optional)
    //@GetMapping("/leaderboard")
    @RequestMapping(value = {"/leaderboard", "/leaderboard/{reqItems}"})
    private String getLeaderBoard(@PathVariable(required = false) Integer reqItems){
        int items;
        if(reqItems==null){
            items = 10;
        }else{
            items = reqItems.intValue();
        }
        logger.info("Inside getLeaderBoard()");
        List<KordleResult> results = resultService.getLeaderBoard(); 
        String reply = "";
        //convert millis to minutes and seconds

        for (int i = 0; i<items&&i<results.size(); i++){
            long millis = results.get(i).getTimeMillis();
             reply = reply + results.get(i).getUser() + "," +
                     results.get(i).getNumTries() + "," +
                     millisToMinSec(millis)+ "\n";
        } 
        return reply;
    }
    private String millisToMinSec(long millis) {
        long minutes = millis/60000;
        millis -=minutes*60000;
        long seconds = millis/1000;
        millis -=seconds*1000;
        String secondsString = String.valueOf(seconds);
        if (seconds<10){
            secondsString = "0" + secondsString;
        }
        return minutes + ":"+ secondsString;
    }
}
