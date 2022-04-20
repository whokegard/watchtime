import "./App.css";
import { useState } from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import { BrowserRouter as Router, Routes, Link, Route } from "react-router-dom";
import Header from "./components/general/Header";
import Footer from "./components/general/Footer";
import SignIn from "./components/sign_in/SignIn";
import Profile from "./components/profile/Profile";
import Register from "./components/sign_in/Register";
import Explore from "./components/explore/Explore"
import { LoggedInContext } from "./components/general/LoggedInContext";
import { UserContext } from "./components/general/UserContext";
import Member from "./components/sign_in/Member";

function App() {
    const [user, setUser] = useState({});
    const [isLoggedIn, setIsLoggedIn] = useState(false);

    return (
        <Router>
            <div className="App">
                <LoggedInContext.Provider value={{ isLoggedIn, setIsLoggedIn }}>
                    <UserContext.Provider value={{ user, setUser }}>
                        <Header />
                        <Routes>
                            <Route
                                path="/member"
                                element={
                                    <>
                                        <Member />
                                    </>
                                }
                            />
                            <Route
                                path="/signin"
                                element={
                                    <>
                                        <SignIn />
                                    </>
                                }
                            />
                            <Route
                                path="/profile"
                                element={
                                    <>
                                        <Profile />
                                    </>
                                }
                            />
                            <Route
                                path="/"
                                element={
                                    <>
                                        <Explore />
                                    </>
                                }
                            />
                            <Route
                                path="/register"
                                element={
                                    <>
                                        <Register/>
                                    </>
                                }
                            />
                        </Routes>
                        <Footer />
                </UserContext.Provider>
            </LoggedInContext.Provider>
            </div>
        </Router>
  );
}

export default App;
