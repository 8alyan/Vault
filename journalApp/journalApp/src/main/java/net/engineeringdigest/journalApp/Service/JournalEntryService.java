package net.engineeringdigest.journalApp.Service;

import net.engineeringdigest.journalApp.Entities.JournalEntry;
import net.engineeringdigest.journalApp.Entities.User;
import net.engineeringdigest.journalApp.repository.JournalEntryRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class JournalEntryService  {
    @Autowired
    private JournalEntryRepo journalEntryRepo;
    @Autowired
    private UserService userService;

    @Transactional
    public void saveEntry(JournalEntry n, String username){
        n.setDate(LocalDateTime.now());
        JournalEntry save = journalEntryRepo.save(n);
        User findbyusername = userService.findbyusername(username);
        findbyusername.getList().add(save);
        userService.saveuser(findbyusername);
    }
    public void saveEntry(JournalEntry n){
        n.setDate(LocalDateTime.now());
        journalEntryRepo.save(n);

    }

    public List<JournalEntry> findall(){
        return journalEntryRepo.findAll();
    }

    public  JournalEntry findbyid(ObjectId id){
        Optional<JournalEntry> lol= journalEntryRepo.findById(id);
        return lol.orElse(null);
    }
    public  boolean deletebyid(ObjectId id, String username){
        User findusername = userService.findbyusername(username);
        boolean b =findusername.getList().removeIf(x->x.getId().equals(id));

        if(b){   userService.saveuser(findusername);
            journalEntryRepo.deleteById(id);}
        return b;
    }


}
