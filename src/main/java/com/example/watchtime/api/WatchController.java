package com.example.watchtime.api;

import com.example.watchtime.service.WatchlistService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/members")
@AllArgsConstructor
public class WatchController {

    @Autowired
    private final WatchlistService watchlistService;

}
