package br.dev.jc.challenge.controller;

import br.dev.jc.challenge.model.BDChangerListener;
import br.dev.jc.challenge.service.BDChangerListenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileWriter;
import java.io.IOException;

@RestController
@RequestMapping("/api/v1/onChange")
public class BDChangerListenerController {

    @Autowired
    private BDChangerListenerService BDChangerListenerService;

    @GetMapping("/api/v1/onChange")
    public String handleNotification(BDChangerListener BDChangerListener) {

        try (FileWriter csvWriter = new FileWriter("changes.csv", true)) {
            csvWriter.append(BDChangerListener.getTableName())
                    .append(',')
                    .append(BDChangerListener.getOperation())
                    .append(',')
                    .append(BDChangerListener.getOldData() != null ? BDChangerListener.getOldData() : "NULL")
                    .append(',')
                    .append(BDChangerListener.getNewData() != null ? BDChangerListener.getNewData() : "NULL")
                    .append(',')
                    .append(new java.util.Date().toString())
                    .append('\n');
            csvWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
            return "Error writing to file";
        }

        return "Notification handled successfully";
    }

}
