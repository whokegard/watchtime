import fetch from 'unfetch';

const checkStatus = response => {
    if (response.ok) {
        return response;
    }

    const error = new Error(response.statusText);
    error.response = response;
    response.json().then(e => {
        error.error = e;
    });
    return Promise.reject(error);
}

export const getAMember = memberId =>
    fetch(`/api/members/${memberId}`)
        .then(checkStatus);

export const getMemberByUsernameAndPassword = (username, password) =>
    fetch(`/api/members/${username}/${password}`)
        .then(checkStatus);

export const getMembersMovies = memberId =>
    fetch(`/api/members/${memberId}`)
        .then(checkStatus);

export const getAMembersNonWatchedMovies = memberId =>
    fetch(`/api/members/${memberId}/notWatchedMovies`)
        .then(checkStatus);

export const getAMembersWatchedMovies = memberId =>
    fetch(`/api/members/${memberId}/watchedMovies`)
        .then(checkStatus);

export const getAMembersNonWatchedTVShows = memberId =>
    fetch(`/api/members/${memberId}/notWatchedTVShows`)
        .then(checkStatus);

export const getAMembersWatchedTVShows = memberId =>
    fetch(`/api/members/${memberId}/watchedTVShows`)
        .then(checkStatus);

export const getAMembersMoviePosters = memberId =>
    fetch(`/api/movies/${memberId}/posters`)
        .then(checkStatus);


export const registerAMember = member =>
    fetch("/api/members", {
        headers: {
            'Content-Type': 'application/json'
        },
        method: 'POST',
        body: JSON.stringify(member)
    });

export const deleteMemberById = memberId =>
    fetch(`/api/members/${memberId}`, {
        headers: {
            'Content-Type': 'application/json'
        },
        method: 'DELETE',
        body: JSON.stringify(memberId)
    });

export const findMovieByImdbId = imdbId =>
    fetch(`/api/movies/${imdbId}`)
    .then(checkStatus);

export const addMovie = movie =>
    fetch("/api/movies", {
        headers: {
            'Content-Type': 'application/json'
        },
        method: 'POST',
        body: JSON.stringify(movie)
    });

export const addMemberToMovie = (imdbId, memberId) =>
    fetch(`/api/movies/${imdbId}/members/${memberId}`, {
        headers: {
            'Content-Type': 'application/json'
        },
        method: 'PUT',
        body: JSON.stringify(memberId)
    })
    .then(checkStatus);

export const addMemberToTVShow = (imdbId, memberId) =>
    fetch(`/api/tvshow/${imdbId}/members/${memberId}`, {
        headers: {
            'Content-Type': 'application/json'
        },
        method: 'PUT',
        body: JSON.stringify(memberId)
    })
        .then(checkStatus);

export const addTVShow = tvshow =>
    fetch("/api/tvshow", {
        headers: {
            'Content-Type': 'application/json'
        },
        method: 'POST',
        body: JSON.stringify(tvshow)
    });

