import React from "react";
import MovieList from "./MovieList";
import TVShowList from "./TVShowList";

const Profile = () => {

    return (
        <div className="profile">
        <MovieList />
        <TVShowList />
        </div>
    );
}

export default Profile;