package br.dev.jc.challenge.service;

import br.dev.jc.challenge.model.BDChangerListener;
import br.dev.jc.challenge.repository.BDChangerListenerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BDChangerListenerService {

    @Autowired
    BDChangerListenerRepository BDChangerListenerRepository;

    public List<BDChangerListener> getUnprocessedChanges(){
//        return BDChangerListenerRepository.findByProcessed(false);
        return BDChangerListenerRepository.findByProcessedFalse();
    }


    public void setAsProcessed(BDChangerListener newBDChangerListener){
        newBDChangerListener.setProcessed();
        BDChangerListenerRepository.save(newBDChangerListener);
    }
}
