package net.engineeringdigest.journalApp.Controller;


import net.engineeringdigest.journalApp.Entities.JournalEntry;
import net.engineeringdigest.journalApp.Service.JournalEntryService;
import net.engineeringdigest.journalApp.Service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/journal")
public class JournalEntryController {
    @Autowired
    private JournalEntryService journalEntryService;
    @Autowired
    private  UserService userService;

    @GetMapping
    public List<JournalEntry> getAllEntryOfUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        List<JournalEntry> list = userService.findbyusername(username).getList();
        return list;
    }

    @PostMapping()
    public ResponseEntity<JournalEntry> put(@RequestBody JournalEntry lo) {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String username = authentication.getName();
            journalEntryService.saveEntry(lo,username);
            return new ResponseEntity<>(lo, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/id/{myid}")
    public ResponseEntity<JournalEntry> getbyid(@PathVariable ObjectId myid) {
        JournalEntry je = journalEntryService.findbyid(myid);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        boolean iskihbhi=false;
        List<JournalEntry> check=userService.findbyusername(username).getList();
        for (JournalEntry journalEntry : check) {
            if (journalEntry.getId().equals(myid)) {
                iskihbhi = true;
                break;
            }
        }
        if(je!=null&&iskihbhi){
            return new ResponseEntity<>(je, HttpStatus.OK);
        }
        return new ResponseEntity<>( HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/id/{myid}")
    public ResponseEntity<?> deletebyid(@PathVariable ObjectId myid) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String us = authentication.getName();

         if(journalEntryService.deletebyid(myid,us)){
         return new ResponseEntity<>(HttpStatus.NO_CONTENT);}
         else{
             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
         }
    }

    @PutMapping("/id/{myid}")
    public ResponseEntity<?> updatebyid(@PathVariable ObjectId myid, @RequestBody JournalEntry n) {
        JournalEntry lol= journalEntryService.findbyid(myid);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String us = authentication.getName();
        boolean iskihbhi=false;
        List<JournalEntry> check=userService.findbyusername(us).getList();
        for (JournalEntry journalEntry : check) {
            if (journalEntry.getId().equals(myid)) {
                iskihbhi = true;
                break;
            }
        }
        if(lol!=null&&iskihbhi){
            if (!n.getTitle().isEmpty()){lol.setTitle(n.getTitle());}
            if(!n.getBody().isEmpty()){lol.setBody(n.getBody());}
            journalEntryService.saveEntry(lol);
            return new ResponseEntity<>(lol, HttpStatus.OK);
        }
        return new ResponseEntity<>( HttpStatus.NOT_FOUND);
    }
}
