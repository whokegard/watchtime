import React from "react";
import { Link } from "react-router-dom";
import "./../../css/Logout.css";

const Logout = (onLogout) => {
    return (
        <div className="logout">
            <Link onClick={onLogout} className="logout__link" to="/signin">
                Sign Out
            </Link>
        </div>
    );
};

export default Logout;
