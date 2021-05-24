package com.baeldung.springservicevalidation.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.baeldung.springservicevalidation.domain.UserAccount;

@Service
public class UserAccountDao {
	
	 private Map<String, UserAccount> DB = new HashMap<String, UserAccount>();

	 public String addUserAccount(UserAccount useraccount) {
		   DB.put(useraccount.getName(), useraccount);
	       return "success";
	    }

	    public Collection<UserAccount> getAllUserAccounts() {
	        
	    	Collection<UserAccount> list = DB.values();
	        if(list.isEmpty()) {
	            list.addAll(DB.values());
	        }
	        return list;
	    	
	    }

	
}
