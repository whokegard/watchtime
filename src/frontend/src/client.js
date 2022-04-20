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
    fetch(`/api/members/${memberId}/movies`)
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

export const addMovieToWatchedList = (memberId, movieId) =>
    fetch(`/api/members/${memberId}/movies/${movieId}/addWatched`, {
        headers: {
            'Content-Type': 'application/json'
        },
        method: 'PUT',
        body: JSON.stringify(memberId)
    })
        .then(checkStatus);

export const removeMovieFromWatchedList = (memberId, movieId) =>
    fetch(`/api/members/${memberId}/movies/${movieId}/removeFromWatched`, {
        headers: {
            'Content-Type': 'application/json'
        },
        method: 'PUT',
        body: JSON.stringify(memberId)
    })
        .then(checkStatus);

export const addTVShowToWatchedList = (memberId, tvShowId) =>
    fetch(`/api/members/${memberId}/tvShow/${tvShowId}/addWatched`, {
        headers: {
            'Content-Type': 'application/json'
        },
        method: 'PUT',
        body: JSON.stringify(memberId)
    })
        .then(checkStatus);

export const removeTVShowFromWatchedList = (memberId, tvShowId) =>
    fetch(`/api/members/${memberId}/tvShow/${tvShowId}/removeFromWatched`, {
        headers: {
            'Content-Type': 'application/json'
        },
        method: 'PUT',
        body: JSON.stringify(memberId)
    })
        .then(checkStatus);

export const removeMovie = (memberId, movieId) =>
    fetch(`/api/members/${memberId}/movies/${movieId}`, {
        headers: {
            'Content-Type': 'application/json'
        },
        method: 'PUT',
        body: JSON.stringify(memberId)
    })
        .then(checkStatus);

export const removeTVShow = (memberId, tvShowId) =>
    fetch(`/api/members/${memberId}/tvShow/${tvShowId}`, {
        headers: {
            'Content-Type': 'application/json'
        },
        method: 'PUT',
        body: JSON.stringify(memberId)
    })
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

export const addTVShow = tvshow =>
    fetch("/api/tvshow", {
        headers: {
            'Content-Type': 'application/json'
        },
        method: 'POST',
        body: JSON.stringify(tvshow)
    });

export const addMemberToMovie = (movieId, memberId) =>
    fetch(`/api/movies/${movieId}/members/${memberId}`, {
        headers: {
            'Content-Type': 'application/json'
        },
        method: 'PUT',
        body: JSON.stringify(memberId)
    })
    .then(checkStatus);

export const addMemberToTVShow = (tvshowId, memberId) =>
    fetch(`/api/tvshow/${tvshowId}/members/${memberId}`, {
        headers: {
            'Content-Type': 'application/json'
        },
        method: 'PUT',
        body: JSON.stringify(memberId)
    })
        .then(checkStatus);

