package com.pluralsight.conference.demo.controller;

import com.pluralsight.conference.demo.model.Session;
import com.pluralsight.conference.demo.repositories.SessionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sessions")
public class SessionsController {
    @Autowired
    private SessionRepository sessionRepository;

    @GetMapping
    @RequestMapping(method = RequestMethod.GET)
    public List<Session> list(){
        return sessionRepository.findAll();

    }

    @GetMapping
    @RequestMapping("{id}")
    public Session get(@PathVariable Long id){
        return sessionRepository.getOne(id);
    }

    @PostMapping
    public Session create(@RequestBody final Session session){
      return sessionRepository.saveAndFlush(session);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteAll(){
        sessionRepository.deleteAllInBatch();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Session update(@PathVariable Long id, Session session) {
        Session sessionPers = sessionRepository.getOne(id);
        if (sessionPers == null) return session;

        BeanUtils.copyProperties(session, sessionPers, "session_id");
        return sessionRepository.saveAndFlush(sessionPers);
    }
}
