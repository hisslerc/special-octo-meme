package com.pluralsight.conference.demo.controller;

import com.pluralsight.conference.demo.model.Speaker;
import com.pluralsight.conference.demo.repositories.SpeakerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/speakers")
public class SpeakersController {

    @Autowired
    private SpeakerRepository speakerRepository;

    @GetMapping
    public List<Speaker> list() {
        return speakerRepository.findAll();
    }

    @GetMapping
//to be checked for later issue, could be id only, not speaker_id
    @RequestMapping("{speaker_id")
    public Speaker get(@PathVariable Long speaker_id) {
        return speakerRepository.getOne(speaker_id);
    }

    @PostMapping
    public Speaker create(@RequestBody Speaker speaker) {
        return speakerRepository.saveAndFlush(speaker);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void delete() {
        speakerRepository.deleteAllInBatch();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Speaker update(@PathVariable Long speaker_id, Speaker speaker) {
        Speaker speakerPers = speakerRepository.getOne(speaker_id);
        if (speakerPers == null) return speaker;

        BeanUtils.copyProperties(speaker, speakerPers, "speaker_id");
        return speakerRepository.saveAndFlush(speakerPers);
    }
}
