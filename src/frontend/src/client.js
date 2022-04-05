import fetch from 'unfetch';

const checkStatus = response => {
    if (response.ok) {
        return response;
    }

    const error = new Error(response.statusText);
    error.response = response;
    return Promise.reject(error);
}

export const getAMember = () =>
    fetch("api/members/1")
        .then(checkStatus);

export const getAllOfAMembersMovies = () =>
    fetch("api/movies/1")
        .then(checkStatus);

export const getAMembersMoviePosters = () =>
    fetch("api/movies/{1}/posters")
        .then(checkStatus);

export const registerAMember = member =>
    fetch("/api/members", {
        headers: {
            'Content-Type': 'application/json'
        },
        method: 'POST',
        body: JSON.stringify(member)
    });