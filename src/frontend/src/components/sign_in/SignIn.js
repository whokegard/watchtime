import React, { useContext, useEffect, useState } from "react";
import {Link, useNavigate} from "react-router-dom";
import "./../../css/SignIn.css";
import { LoggedInContext } from "../general/LoggedInContext";
import { UserContext } from "../general/UserContext";

const SignIn = () => {
    const { setIsLoggedIn } = useContext(LoggedInContext);
    const { setUser } = useContext(UserContext);
    const [users, setUsers] = useState([]);
    const [errorMessages, setErrorMessages] = useState({});
    const [isSubmitted, setIsSubmitted] = useState(false);
    const navigate = useNavigate();

    // User Login info
    useEffect(() => {
        const getUsers = async () => {
            const usersFromSever = await fetchUsers();
            setUsers(usersFromSever);
        };

        getUsers();
    }, []);

    const fetchUsers = async () => {
        const res = await fetch("http://localhost:5000/users");
        const data = res.json();

        return data;
    };

    const errors = {
        uname: "Invalid Username",
        pass: "Invalid Password",
    };

    const handleSubmit = (event) => {
        //Prevent page reload
        event.preventDefault();

        var { uname, pass } = document.forms[0];

        // Find user login info
        const userData = users.find((user) => user.username === uname.value);

        // Compare user info
        if (userData) {
            if (userData.password !== pass.value) {
                // Invalid password

                setErrorMessages({ name: "pass", message: errors.pass });
            } else {
                setUser(userData);
                setIsLoggedIn(true);
                setIsSubmitted(true);
            }
        } else {
            // Username not found
            setErrorMessages({ name: "uname", message: errors.uname });
        }
    };

    // Generate JSX code for error message
    const renderErrorMessage = (name) =>
        name === errorMessages.name && (
            <div className="error">{errorMessages.message}</div>
        );

    // JSX code for login form
    const renderForm = (
        <div className="form">
            <form onSubmit={handleSubmit}>
                <div className="input-container">
                    <label>Username</label>
                    <input className="loginForm" type="text" name="uname" required />
                    {renderErrorMessage("uname")}
                </div>
                <div className="input-container">
                    <label>Password</label>
                    <input className="loginForm" type="password" name="pass" required />
                    {renderErrorMessage("pass")}
                    <Link className="register" to ="/register">Create account</Link>
                </div>
                <input type="submit" value="Login" />
                <div className="button-container"></div>
            </form>
        </div>
    );

    return (
        <div className="signin">
            <div className="login-form">
                <div className="title">Sign In</div>
                <div>{isSubmitted ? navigate("/") : renderForm}</div>
            </div>
        </div>
    );
};

export default SignIn;
