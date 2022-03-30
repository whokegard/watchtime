import React from "react";
import { Card, Button } from "react-bootstrap";

const Footer = () => {
    return (
        <div className="text-center" style={{ background: "#181818" }}>
            <Card.Body className="border-top border-secondary"
            >
                <Card.Text style={{ color: "#909096" }}>
                    &copy; 2022 Realest Estates<br></br> Privacy · Terms · Sitemap ·
                    Company Details
                </Card.Text>
            </Card.Body>
        </div>
    );
};
export default Footer;
