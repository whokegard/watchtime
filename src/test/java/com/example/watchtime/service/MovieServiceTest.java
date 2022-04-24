package com.example.watchtime.service;

import com.example.watchtime.dao.MemberDAO;
import com.example.watchtime.dao.MovieDAO;
import com.example.watchtime.model.Member;
import com.example.watchtime.model.Movie;
import org.checkerframework.checker.nullness.Opt;
import org.junit.jupiter.api.*;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


class MovieServiceTest {

    @Mock
    private static MemberDAO memberDAO;
    private static MovieDAO movieDAO;
    private static MovieService unitUnderTest;

    @BeforeAll
    public static void init() {
        movieDAO = Mockito.mock(MovieDAO.class);
        memberDAO = Mockito.mock(MemberDAO.class);
        unitUnderTest = new MovieService(movieDAO, memberDAO);
    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addMovieIfDBDoesNotHaveIt() {
        // Setup
        Movie newMovie = new Movie(2, "tt1631867", "Edge of Tomorrow", 2014, new ArrayList<>(), new ArrayList<>());
        Movie movieFromDB = new Movie(2, "tt1631867", "Edge of Tomorrow", 2014, new ArrayList<>(), new ArrayList<>());

        when(movieDAO.save(any())).thenReturn(movieFromDB);


        // Test
        unitUnderTest.addMovie(newMovie);
        ArgumentCaptor<Movie> movieArgumentCaptor = ArgumentCaptor.forClass(Movie.class);

        // verify
        verify(movieDAO).save(movieArgumentCaptor.capture());

        Movie capturedMovie = movieArgumentCaptor.getValue();

        assertThat(capturedMovie).isEqualTo(newMovie);
    }

    @Test
    @Disabled
    void addMemberToMovie() {
        // Setup
        Member memberFromDB =
                new Member(1, "John", "John", "Doe", "john.doe@gmail.com",
                        "123456", new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        Movie movieFromDB = new Movie(1, "tt1631867", "Edge of Tomorrow",
                2014, new ArrayList<>(), new ArrayList<>());

        when(movieDAO.findMovieById(anyLong())).thenReturn(Optional.of(movieFromDB));
        when(memberDAO.findMemberByID(anyLong())).thenReturn(Optional.of(memberFromDB));

        //when(movieDAO.save(any())).thenReturn(movieFromDB);

        // Test

        unitUnderTest.addMemberToMovie(movieFromDB.getMovie_id(), memberFromDB.getMember_id());
        ArgumentCaptor<Movie> movieArgumentCaptor = ArgumentCaptor.forClass(Movie.class);
        verify(movieDAO, Mockito.times(1)).save(movieArgumentCaptor.capture());
        Movie capturedMovie = movieArgumentCaptor.getValue();

        assertThat(capturedMovie).isEqualTo(movieFromDB);

        // Verify
        // assertEquals(1, actualMovie.getMember_list().get(0).getMember_id());

    }
}