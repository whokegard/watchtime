import React, {useContext, useEffect, useState} from "react";
import {UserContext} from "../general/UserContext";
import {deleteMemberById, getAMember} from "../../client";
import "./../../css/Member.css";

const Member = () => {

    const { user } = useContext(UserContext);

    const fetchAMember = () => getAMember(user.member_id)
        .then(resp => resp)
        .then(res => res.json())
        .then(data => {
            console.log(data);
        });

    useEffect(() => {
        fetchAMember();
    }, []);

    return (
        <div className="view">
            <div className="user-details">
                <h1>User Details</h1>
            <h3>Username: {user.username}</h3>
                <h3>Name: {user.first_name} {user.last_name}</h3>
                <h3>Email: {user.email}</h3>
                <button className="member-button" onClick={deleteMemberById}>Delete Account</button>
</div>
</div>
    );
}

export default Member;