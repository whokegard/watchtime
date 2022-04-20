import React, {useContext, useEffect, useState} from "react";
import {UserContext} from "../general/UserContext";
import {deleteMemberById, getAMember} from "../../client";
import "./../../css/Member.css";
import {useNavigate} from "react-router";
import {LoggedInContext} from "../general/LoggedInContext";


const Member = () => {
    const { isLoggedIn } = useContext(LoggedInContext);
    const { user } = useContext(UserContext);
    const navigate = useNavigate();

    const fetchAMember = () => getAMember(user.member_id)
        .then(resp => resp)
        .then(res => res.json())
        .then(data => {
            console.log(data);
        });

    const deleteMember = () => {
        deleteMemberById(user.member_id)
            .then(res => res.json())
            .then(data => console.log(data));
            navigate("/signin");
    }

    useEffect(() => {
        fetchAMember();
    }, []);

    return (
        <div className="view">
            {isLoggedIn ?
                <div className="user-details">
                    <h1>User Details</h1>
                    <h3>Username: {user.username}</h3>
                    <h3>Name: {user.first_name} {user.last_name}</h3>
                    <h3>Email: {user.email}</h3>
                    <button className="member-button" onClick={() => deleteMember()}>Delete Account</button>
                </div>
                :
                <></>
            }
        </div>
    );
}

export default Member;