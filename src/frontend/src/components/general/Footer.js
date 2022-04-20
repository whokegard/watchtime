import React from "react";
import { Card, Button } from "react-bootstrap";

const Footer = () => {
    return (
        <div className="text-center" style={{
            background: "linear-gradient(#303030, #454545)"
        }}>
            <Card.Body>
                <Card.Text style={{
                    color: "var(--primary-color)"}}>
                    &copy; 2022 WatchTime<br></br> Privacy · Terms ·
                    Company Details
                </Card.Text>
            </Card.Body>
        </div>
    );
};
export default Footer;
