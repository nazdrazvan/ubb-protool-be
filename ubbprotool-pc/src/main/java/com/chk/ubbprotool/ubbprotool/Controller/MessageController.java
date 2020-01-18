package com.chk.ubbprotool.ubbprotool.Controller;

import com.chk.ubbprotool.ubbprotool.Service.MessageService;
import com.chk.ubbprotool.ubbprotool.dto.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/message")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @GetMapping("/list")
    public ResponseEntity<List<MessageDTO>> listMessages() {
        return  ResponseEntity.ok(messageService.findAllMessages());
    }


    @PostMapping("/saveMessage")
    public ResponseEntity<String> saveMessage(@RequestBody MessageDTO theMessage) throws IOException {
        messageService.createMessage(theMessage);
        return ResponseEntity.ok("Message saved");
    }

    @PostMapping("/deleteMessage/{messageId}")
    public ResponseEntity<String> deleteMessage(@PathVariable("messageId") int theId) {
        messageService.deleteMessage(theId);
        return ResponseEntity.ok("Message deleted");
    }

    @PostMapping("/updateMessage")
    public ResponseEntity<String> updateMessage(@RequestBody MessageDTO theMessage) throws IOException {
        messageService.upgradeMessage(theMessage);
        return ResponseEntity.ok("Message updated");
    }

}
