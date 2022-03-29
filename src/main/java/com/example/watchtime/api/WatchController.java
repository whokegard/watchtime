package com.example.watchtime.api;


import com.example.watchtime.service.WatchlistService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;


@Controller
@RestController("/api")
public class WatchController {
    WatchlistService watchlistService;

    public WatchController(WatchlistService watchlistService) {
        this.watchlistService = watchlistService;
    }
}
