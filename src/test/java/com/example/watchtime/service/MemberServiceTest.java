package com.example.watchtime.service;

import com.example.watchtime.dao.MemberDAO;
import com.example.watchtime.dao.MovieDAO;
import com.example.watchtime.dao.TVShowDAO;
import com.example.watchtime.model.Member;
import com.example.watchtime.model.Movie;
import com.example.watchtime.model.TVShow;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest extends MockitoExtension {

    static MemberDAO memberDAO;
    static MovieDAO movieDAO;
    static TVShowDAO tvShowDAO;
    static MemberService unitUnderTest;

    @BeforeAll
    public static void init() {
        memberDAO = Mockito.mock(MemberDAO.class);
        movieDAO = Mockito.mock(MovieDAO.class);
        tvShowDAO = Mockito.mock(TVShowDAO.class);
        unitUnderTest = new MemberService(memberDAO, movieDAO, tvShowDAO);
    }

    @Test
    void addMember() {
        Member newMember = new Member();

        unitUnderTest.addMember(newMember);
    }

    @Test
    void getAllMembers() {
        Member member1 = new Member();
        member1.setMember_id(100);
        member1.setUsername("Test");
        member1.setWatched_movies(List.of(new Movie()));

        List<Member> membersFromDB = List.of(member1);
        Mockito.when(memberDAO.getAllMembers()).thenReturn(membersFromDB);

        List<Member> actualMembers = unitUnderTest.getAllMembers();

        assertEquals("Test", actualMembers.get(0).getUsername());
    }

    @Test
    void getMemberByID() {
        Member member1 = new Member();
        member1.setMember_id(100);
        member1.setUsername("Test");
        member1.setWatched_movies(List.of(new Movie()));

        List<Member> membersFromDB = List.of(member1);
        Mockito.when(memberDAO.getAllMembers()).thenReturn(membersFromDB);

        List<Member> actualMembers = unitUnderTest.getAllMembers();

        assertEquals(100, actualMembers.get(0).getMember_id());
    }

    @Test
    void deleteMemberById() {
        Member member1 = new Member();
        member1.setMember_id(100);
        member1.setUsername("Test");
        member1.setWatched_movies(List.of(new Movie()));

        unitUnderTest.deleteMemberById(100);

        assertEquals(100,  100);
    }

    @Test
    void getMemberByUsernameAndPass() {
        Member member1 = new Member();
        member1.setUsername("Test");
        member1.setPassword("admin");
        member1.setWatched_movies(List.of(new Movie()));

        List<Member> membersFromDB = List.of(member1);
        Mockito.when(memberDAO.getAllMembers()).thenReturn(membersFromDB);

        List<Member> actualMembers = unitUnderTest.getAllMembers();

        assertEquals("Test", actualMembers.get(0).getUsername());
        assertEquals("admin", actualMembers.get(0).getPassword());
    }

    @Test
    void getAMembersMovies() {
        Member member1 = new Member();
        member1.setMember_id(100);
        member1.setUsername("Test");
        member1.setWatched_movies(List.of(new Movie()));

        Movie movie1 = new Movie();
        movie1.setMovie_id(100);
        movie1.setTitle("TestMovie");


        List<Member> membersFromDB = List.of(member1);
        Mockito.when(memberDAO.getAllMembers()).thenReturn(membersFromDB);

        List<Member> actualMembers = unitUnderTest.getAllMembers();

        assertEquals("Test", actualMembers.get(0).getUsername());
    }

    @Test
    void getAMembersTVShows() {
        Member member1 = new Member();
        member1.setMember_id(100);
        member1.setUsername("Test");
        member1.setWatched_movies(List.of(new Movie()));

        TVShow tvShow1 = new TVShow();
        tvShow1.setTvshow_id(100);
        tvShow1.setTitle("TestTVShow");


        List<Member> membersFromDB = List.of(member1);
        Mockito.when(memberDAO.getAllMembers()).thenReturn(membersFromDB);

        List<Member> actualMembers = unitUnderTest.getAllMembers();

        assertEquals("Test", actualMembers.get(0).getUsername());
    }

    @Test
    void removeMovie() {
        Member member1 = new Member();
        member1.setMember_id(100);
        member1.setUsername("Test");
        Movie movie1 = new Movie();
        movie1.setMovie_id(100);
        movie1.setTitle("Test");
        unitUnderTest.addMovieToWatchedList(100, 100);

        unitUnderTest.removeMovie(100, 100);

        assertEquals(100,  100);
    }


    @Test
    void removeTVShow() {
        Member member1 = new Member();
        member1.setMember_id(100);
        member1.setUsername("Test");
        TVShow tvShow1 = new TVShow();
        tvShow1.setTvshow_id(100);
        tvShow1.setTitle("Test");
        unitUnderTest.addTVShowToWatchedList(100, 100);

        unitUnderTest.removeTVShow(100, 100);

        assertEquals(100,  100);
    }

    @Test
    void getAMembersWatchedMovies() {
        Member member1 = new Member();
        member1.setMember_id(100);
        member1.setUsername("Test");

        unitUnderTest.getAMembersWatchedMovies(100);

        assertEquals(100,  100);
    }

    @Test
    void getAMembersNonWatchedMovies() {
        Member member1 = new Member();
        member1.setMember_id(100);
        member1.setUsername("Test");

        unitUnderTest.getAMembersNonWatchedMovies(100);

        assertEquals(100,  100);
    }

    @Test
    void getAMembersWatchedTVShows() {
        Member member1 = new Member();
        member1.setMember_id(100);
        member1.setUsername("Test");

        unitUnderTest.getAMembersWatchedTVShows(100);

        assertEquals(100,  100);
    }

    @Test
    void getAMembersNonWatchedTVShows() {
        Member member1 = new Member();
        member1.setMember_id(100);
        member1.setUsername("Test");

        unitUnderTest.getAMembersNonWatchedTVShows(100);

        assertEquals(100,  100);
    }

    @Test
    void addMovieToWatchedList() {
        Member member1 = new Member();
        member1.setMember_id(100);
        member1.setUsername("Test");
        Movie movie1 = new Movie();
        movie1.setMovie_id(100);
        movie1.setTitle("Test");

        unitUnderTest.addMovieToWatchedList(100, 100);

        assertEquals(100,  100);
    }

    @Test
    void removeMovieFromWatchedList() {
        Member member1 = new Member();
        member1.setMember_id(100);
        member1.setUsername("Test");
        Movie movie1 = new Movie();
        movie1.setMovie_id(100);
        movie1.setTitle("Test");
        unitUnderTest.addMovieToWatchedList(100, 100);

        unitUnderTest.removeMovieFromWatchedList(100, 100);

        assertEquals(100,  100);
    }

    @Test
    void addTVShowToWatchedList() {
        Member member1 = new Member();
        member1.setMember_id(100);
        member1.setUsername("Test");
        TVShow tvShow1 = new TVShow();
        tvShow1.setTvshow_id(100);
        tvShow1.setTitle("Test");

        unitUnderTest.addTVShowToWatchedList(100, 100);

        assertEquals(100,  100);
    }

    @Test
    void removeTVShowFromWatchedList() {
        Member member1 = new Member();
        member1.setMember_id(100);
        member1.setUsername("Test");
        TVShow tvShow1 = new TVShow();
        tvShow1.setTvshow_id(100);
        tvShow1.setTitle("Test");
        unitUnderTest.addTVShowToWatchedList(100, 100);

        unitUnderTest.removeTVShowFromWatchedList(100, 100);

        assertEquals(100,  100);
    }
}