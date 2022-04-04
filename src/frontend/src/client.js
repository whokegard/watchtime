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
    fetch("api/members/13")
        .then(checkStatus);

export const getAllOfAMembersMovies = () =>
    fetch("api/movies/1")
        .then(checkStatus);
export const getAMembersMoviePosters = () =>
    fetch("api/movies/{13}/posters")
        .then(checkStatus);