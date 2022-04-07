import fetch from 'unfetch';

const checkStatus = response => {
    if (response.ok) {
        return response;
    }

    const error = new Error(response.statusText);
    error.response = response;
    return Promise.reject(error);
}

export const getAMember = memberId =>
    fetch(`/api/members/${memberId}`)
        .then(checkStatus);

export const getAllOfAMembersMovies = watchlistId =>
    fetch(`/api/movies/${watchlistId}`)
        .then(checkStatus);

export const getAllOfAMembersSeries = () =>
    fetch("api/series/1")
        .then(checkStatus);

export const getAMembersMoviePosters = memberId =>
    fetch(`/api/movies/${memberId}/posters`)
        .then(checkStatus);

export const getAMembersSeriesPosters = () =>
    fetch("api/series/{1}/posters")
        .then(checkStatus);


export const registerAMember = member =>
    fetch("/api/members", {
        headers: {
            'Content-Type': 'application/json'
        },
        method: 'POST',
        body: JSON.stringify(member)
    });

export const addMovie = movie =>
    fetch("/api/movies", {
        headers: {
            'Content-Type': 'application/json'
        },
        method: 'POST',
        body: JSON.stringify(movie)
    });

export const addSeries = series =>
    fetch("/api/series", {
        headers: {
            'Content-Type': 'application/json'
        },
        method: 'POST',
        body: JSON.stringify(series)
    });

export const getMemberByUsernameAndPassword = (username, password) =>
    fetch(`/api/members/${username}/${password}`)
        .then(checkStatus);

export const getMembersNonWatchedMovies = watchlistId =>
    fetch(`/api/movies/${watchlistId}/watched`)
        .then(checkStatus);

export const getMembersWatchedMovies = watchlistId =>
    fetch(`/api/movies/${watchlistId}/notWatched`)
        .then(checkStatus);