package br.dev.jc.challenge.util;

import br.dev.jc.challenge.controller.BDChangerListenerController;
import br.dev.jc.challenge.model.BDChangerListener;
import br.dev.jc.challenge.service.BDChangerListenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BDChangerListenerScheduler {

    @Autowired
    private BDChangerListenerController BDChangerListenerController;

    @Autowired
    private BDChangerListenerService BDChangerListenerService;

    @Scheduled(fixedRate = 60000)
    public void onChange(){
        System.out.println("Executing onChange");
       List<BDChangerListener> changes = BDChangerListenerService.getUnprocessedChanges();

       for(BDChangerListener change : changes){
           BDChangerListenerController.handleNotification(change);
           BDChangerListenerService.setAsProcessed(change);
       }

    }

}
