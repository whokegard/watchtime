package com.example.watchtime.api;

import com.example.watchtime.model.TVShow;
import com.example.watchtime.service.MemberService;
import com.example.watchtime.service.TVShowService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TVShowController {
    TVShowService tvShowService;

    public TVShowController(TVShowService tvShowService) {
        this.tvShowService = tvShowService;
    }

    @GetMapping("/tvshow/{id}")
    public TVShow getTVShowById(@PathVariable("id") long id) {
        return tvShowService.getTVShowById(id);
    }

    @GetMapping("/members/{member_id}/tvshow/{tvshow_id}")
    public void deleteTVShowByID(@PathVariable("member_id") long member_id, @PathVariable("id") long tvshow_id) {
        tvShowService.deleteTVShowById(member_id, tvshow_id);
    }

    @GetMapping("/members/{id}/tvshow")
    public void deleteAllTVShows() {
        tvShowService.deleteAllTVShows();
    }
}
