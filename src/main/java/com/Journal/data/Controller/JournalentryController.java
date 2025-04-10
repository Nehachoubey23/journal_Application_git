package com.Journal.data.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Journal.data.entity.Journalentryentity;

@RestController
@RequestMapping("/Journal")// it  used for mapping of class level.so this path is starting path.
public class JournalentryController {
private Map <Long,Journalentryentity> journalentries = new HashMap();
	@GetMapping
	public List<Journalentryentity> getAll(){
		  System.out.println("Entries in journal: " + journalentries.size());
		return  new ArrayList<> (journalentries.values());
		}
	//method inside a controller class should be public so that they can be  accessed and invoked  by spring framework and
	//or External http request.
	@PostMapping 
	public boolean createEntry(@RequestBody Journalentryentity myentry) {
		journalentries.put(myentry.getId(), myentry);
		return true;
		}
	//	Difference between @PathVariable  and  @RequestParam ?
	// @pathvariable  is used to capture value  from the URL path. while @RequestParam is used to capture query parameter or form 
	//parameters from the  URL.
	@GetMapping("id/{myId}")
	public Journalentryentity getElementById(@PathVariable Long myId){
		return  journalentries.get(myId);
		}
	@DeleteMapping("id/{myId}")
	public Journalentryentity deleteElementById(@PathVariable Long myId){
		return  journalentries.remove(myId);
		}
	@PutMapping("id/{myId}")
	public  Journalentryentity updateElementById(@PathVariable Long myId ,@RequestBody Journalentryentity myentry ) {
		return journalentries.put(myId, myentry);}}

