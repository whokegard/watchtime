import React from "react";
import MovieList from "./TVShowList";
import TVShowList from "./MovieList";

const Profile = () => {

    return (
        <div className="profile" style={{height: "100"}}>
        <MovieList />
        <TVShowList />
        </div>
    );
}

export default Profile;