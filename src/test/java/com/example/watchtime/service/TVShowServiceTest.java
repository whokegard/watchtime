package com.example.watchtime.service;

import com.example.watchtime.dao.MemberDAO;
import com.example.watchtime.dao.TVShowDAO;
import com.example.watchtime.model.TVShow;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import java.util.ArrayList;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class TVShowServiceTest {

    @Mock
    private static MemberDAO memberDAO;
    private static TVShowDAO tvShowDAO;
    private static TVShowService unitUnderTest;

    @BeforeAll
    public static void init() {
        tvShowDAO = Mockito.mock(TVShowDAO.class);
        memberDAO = Mockito.mock(MemberDAO.class);
        unitUnderTest = new TVShowService(tvShowDAO, memberDAO);
    }

    @Test
    void addTVShow() {
        // Setup
        TVShow newTVShow = new TVShow(2, "tt0397442", "Gossip Girl", "2007–2012", new ArrayList<>(), new ArrayList<>());
        TVShow tvShowFromDB = new TVShow(2, "tt0397442", "Gossip Girl", "2007–2012", new ArrayList<>(), new ArrayList<>());

        when(tvShowDAO.save(any())).thenReturn(tvShowFromDB);


        // Test
        unitUnderTest.addTVShow(newTVShow);
        ArgumentCaptor<TVShow> tvShowArgumentCaptor = ArgumentCaptor.forClass(TVShow.class);

        // verify
        verify(tvShowDAO).save(tvShowArgumentCaptor.capture());

        TVShow capturedMovie = tvShowArgumentCaptor.getValue();

        assertThat(capturedMovie).isEqualTo(newTVShow);
    }

    @Test
    @Disabled
    void addMemberToTVShow() {
    }
}