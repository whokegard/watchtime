package com.example.watchtime.api;

import com.example.watchtime.model.TVShow;
import com.example.watchtime.service.TVShowService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/tvshow")
public class TVShowController {

    @Autowired
    private final TVShowService tvShowService;

    @PostMapping
    public TVShow addTVShow(@RequestBody TVShow newTVShow) {
        return tvShowService.addTVShow(newTVShow);
    }


    @PutMapping("/{tvshowId}/members/{id}")
    public TVShow addMemberToTVShow( @PathVariable("tvshowId") long tvshowId,
                                   @PathVariable("id") long memberId) {
        return tvShowService.addMemberToTVShow(tvshowId, memberId);
    }
}

