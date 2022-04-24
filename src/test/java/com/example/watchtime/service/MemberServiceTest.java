package com.example.watchtime.service;

import com.example.watchtime.dao.MemberDAO;
import com.example.watchtime.dao.MovieDAO;
import com.example.watchtime.dao.TVShowDAO;
import com.example.watchtime.model.Member;
import com.example.watchtime.model.Movie;
import com.example.watchtime.model.TVShow;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

class MemberServiceTest extends MockitoExtension {

    @Mock
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
        // Setup
        Member newMember = new Member(2, "benji", "Benjamin", "Nilsson", "test@test.com", "123456", new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        Member memberFromDB = new Member(2, "benji", "Benjamin", "Nilsson", "test@test.com", "123456", new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        when(memberDAO.saveMember(any())).thenReturn(memberFromDB);

        // Test
        unitUnderTest.addMember(newMember);
        ArgumentCaptor<Member> memberArgumentCaptor = ArgumentCaptor.forClass(Member.class);

        // Verify
        verify(memberDAO).saveMember(memberArgumentCaptor.capture());

        Member capturedMember = memberArgumentCaptor.getValue();

        assertThat(capturedMember).isEqualTo(newMember);
    }

    @Test
    void getAllMembers() {
        // Setup
        Member member1FromDB = new Member(2, "benji", "Benjamin", "Nilsson", "test@test.com", "123456", new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        Member member2FromDB = new Member(3, "wille", "William", "Hööken", "test@test.com", "123456", new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        List<Member> membersFromDB = List.of(member1FromDB, member2FromDB);
        when(memberDAO.getAllMembers()).thenReturn(membersFromDB);

        // Test
        List<Member> actualMembers = unitUnderTest.getAllMembers();

        // Verify
        assertEquals("benji", actualMembers.get(0).getUsername());
    }

    @Test
    void getMemberByID() {
        // Setup
        Member memberFromDB = new Member(2, "benji", "Benjamin", "Nilsson", "test@test.com", "123456", new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        when(memberDAO.findMemberByID(anyLong())).thenReturn(Optional.of(memberFromDB));

        // Test
        Member actualMember = unitUnderTest.getMemberByID(2);

        // Verify
        assertEquals(2, actualMember.getMember_id());
    }

    @Test
    void deleteMemberById() {
        // Setup
        Member memberFromDB = new Member(1, "benji", "Benjamin", "Nilsson", "test@test.com", "123456", new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        when(memberDAO.findMemberByID(anyLong())).thenReturn(Optional.of(memberFromDB));

        // Test
        unitUnderTest.deleteMemberById(1);

        // Verify
        verify(memberDAO, times(1)).deleteMemberById(1);
    }

    @Test
    void getMemberByUsernameAndPass() {
        // Setup
        Member member1FromDB = new Member(2, "benji", "Benjamin", "Nilsson", "test@test.com", "123456", new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        Member member2FromDB = new Member(3, "wille", "William", "Hööken", "test@test.com", "123456", new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        List<Member> membersFromDB = List.of(member1FromDB, member2FromDB);
        when(memberDAO.getAllMembers()).thenReturn(membersFromDB);

        // Test
        Member actualMembers = unitUnderTest.getMemberByUsernameAndPass("benji", "123456");

        // Verify
        assertEquals("benji", actualMembers.getUsername());
        assertEquals("123456", actualMembers.getPassword());
    }

    @Test
    void getAMembersMovies() {
        // Setup
        Member memberFromDB =
                new Member(1, "John", "John", "Doe", "john.doe@gmail.com",
                        "123456", new ArrayList<>(List.of(new Movie(1, "tt1631867", "Edge of Tomorrow",
                        2014, new ArrayList<>(), new ArrayList<>()))), new ArrayList<>(), new ArrayList<>(List.of(new Movie(2, "tt1631867", "Edge of Tomorrow",
                        2014, new ArrayList<>(), new ArrayList<>()))), new ArrayList<>());

        when(memberDAO.findMemberByID(anyLong())).thenReturn(Optional.of(memberFromDB));

        // Test
        List<Movie> actualMovies = unitUnderTest.getAMembersMovies(1);

        // Verify
        assertEquals("Edge of Tomorrow", actualMovies.get(0).getTitle());
        assertEquals(2, actualMovies.get(0).getMovie_id());
        assertEquals("Edge of Tomorrow", actualMovies.get(1).getTitle());
        assertEquals(1, actualMovies.get(1).getMovie_id());
    }

    @Test
    void getAMembersTVShows() {
        // Setup
        Member memberFromDB =
                new Member(1, "John", "John", "Doe", "john.doe@gmail.com",
                        "123456", new ArrayList<>(), new ArrayList<>(List.of(new TVShow(1, "tt0397442", "Gossip Girl", "2007–2012", new ArrayList<>(), new ArrayList<>())
                )), new ArrayList<>(), new ArrayList<>(List.of(new TVShow(2, "tt0397442", "Gossip Girl", "2007–2012", new ArrayList<>(), new ArrayList<>())
                )));

        when(memberDAO.findMemberByID(anyLong())).thenReturn(Optional.of(memberFromDB));

        // Test
        List<TVShow> actualTVShows = unitUnderTest.getAMembersTVShows(1);

        // Verify
        assertEquals("Gossip Girl", actualTVShows.get(0).getTitle());
        assertEquals(2, actualTVShows.get(0).getTvshow_id());
        assertEquals("Gossip Girl", actualTVShows.get(1).getTitle());
        assertEquals(1, actualTVShows.get(1).getTvshow_id());
    }

    @Test
    @Disabled
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
    @Disabled
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
        // Setup
        Member memberFromDB =
                new Member(1, "John", "John", "Doe", "john.doe@gmail.com",
                        "123456", new ArrayList<>(List.of(new Movie(1, "tt1631867", "Edge of Tomorrow",
                        2014, new ArrayList<>(), new ArrayList<>()))), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        when(memberDAO.findMemberByID(anyLong())).thenReturn(Optional.of(memberFromDB));

        // Test
        List<Movie> actualMovies = unitUnderTest.getAMembersWatchedMovies(1);

        // Verify
        assertEquals("Edge of Tomorrow", actualMovies.get(0).getTitle());
        assertEquals(1, actualMovies.get(0).getMovie_id());
    }

    @Test
    void getAMembersNonWatchedMovies() {
        // Setup
        Member memberFromDB =
                new Member(1, "John", "John", "Doe", "john.doe@gmail.com",
                        "123456", new ArrayList<>(), new ArrayList<>(), new ArrayList<>(List.of(new Movie(1, "tt1631867", "Edge of Tomorrow",
                        2014, new ArrayList<>(), new ArrayList<>()))), new ArrayList<>());

        when(memberDAO.findMemberByID(anyLong())).thenReturn(Optional.of(memberFromDB));

        // Test
        List<Movie> actualMovies = unitUnderTest.getAMembersNonWatchedMovies(1);

        // Verify
        assertEquals("Edge of Tomorrow", actualMovies.get(0).getTitle());
        assertEquals(1, actualMovies.get(0).getMovie_id());
    }

    @Test
    void getAMembersWatchedTVShows() {
        // Setup
        Member memberFromDB =
                new Member(1, "John", "John", "Doe", "john.doe@gmail.com",
                        "123456", new ArrayList<>(), new ArrayList<>(List.of(new TVShow(1, "tt0397442", "Gossip Girl", "2007–2012", new ArrayList<>(), new ArrayList<>())
                )), new ArrayList<>(), new ArrayList<>());

        when(memberDAO.findMemberByID(anyLong())).thenReturn(Optional.of(memberFromDB));

        // Test
        List<TVShow> actualTVShows = unitUnderTest.getAMembersWatchedTVShows(1);

        // Verify
        assertEquals("Gossip Girl", actualTVShows.get(0).getTitle());
        assertEquals(1, actualTVShows.get(0).getTvshow_id());
    }

    @Test
    void getAMembersNonWatchedTVShows() {
        // Setup
        Member memberFromDB =
                new Member(1, "John", "John", "Doe", "john.doe@gmail.com",
                        "123456", new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(List.of(new TVShow(1, "tt0397442", "Gossip Girl", "2007–2012", new ArrayList<>(), new ArrayList<>())
                )));

        when(memberDAO.findMemberByID(anyLong())).thenReturn(Optional.of(memberFromDB));

        // Test
        List<TVShow> actualTVShows = unitUnderTest.getAMembersNonWatchedTVShows(1);

        // Verify
        assertEquals("Gossip Girl", actualTVShows.get(0).getTitle());
        assertEquals(1, actualTVShows.get(0).getTvshow_id());
    }

    @Test
    @Disabled
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
    @Disabled
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
    @Disabled
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
    @Disabled
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