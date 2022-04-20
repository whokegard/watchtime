import React, {useContext, useEffect} from "react";
import { useState } from "react";
import { Navbar, Container, Nav } from "react-bootstrap";
import { Link } from "react-router-dom";
import { BiLogIn } from "react-icons/bi";
import Logout from "./Logout";
import "./../../css/Header.css";
import { LoggedInContext } from "./LoggedInContext";
import { UserContext } from "./UserContext";

const Header = () => {
    const { user } = useContext(UserContext);
    const { isLoggedIn } = useContext(LoggedInContext);
    const [showSignOut, setShowSignOut] = useState(false);

    const handleLogin = () => {
        setShowSignOut(!showSignOut);
    };

    const logout = () => {
        setShowSignOut(false);
    };

    return (
        <div>
            <Navbar
                className="header"
                collapseOnSelect
                fixed="top"
                expand="sm"
                bg="dark"
                variant="dark"
            >
                <Container fluid>
                    <Navbar.Brand>
                        <Link className="link" to="/">
                        <img
                            src="images/WatchTime_red.png"
                            alt="watchtime"
                            width="100%"
                            height="auto"
                        />
                        </Link>
                    </Navbar.Brand>
                    <Navbar.Toggle aria-controls="responsive-navbar-nav" />
                    <Navbar.Collapse id="responsive-navbar-nav">
                        <Nav
                            className="nav navbar-nav ms-auto"
                            style={{ fontSize: "30px" }}
                        >
                            {isLoggedIn ? (
                                <Link className="link" to="/">
                                    Explore
                                </Link>
                            ) : (
                                <></>
                            )
                            }
                            {isLoggedIn ? (
                                <Link className="link" to="/profile">
                                    Profile
                                </Link>
                            ) : (
                                <></>
                            )
                            }
                            {!isLoggedIn ? (
                                <Link
                                    className="link"
                                    style={{ marginLeft: "50px", fontSize: "20px" }}
                                    to="/signin"
                                >
                                    Sign In
                                    <BiLogIn />
                                </Link>
                            ) : (
                                <Link
                                    to="#"
                                    onClick={isLoggedIn && handleLogin}
                                    className="link"
                                    style={{ marginLeft: "40px" }}
                                >
                                    {user.username}
                                    <BiLogIn />
                                </Link>
                            )}
                            {showSignOut && <Logout handleLogOut={logout} />}
                        </Nav>
                    </Navbar.Collapse>
                </Container>
            </Navbar>
        </div>
    );
};

export default Header;
