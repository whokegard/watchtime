import React from "react";
import {PlusOutlined} from "@ant-design/icons";
import {useNavigate} from "react-router";

const EmptyCard = () => {
    const navigate = useNavigate();

    return (
        <div
            onClick={() => navigate("/")}
            style={{
            height: "300px",
            width: "230px",
            borderRadius: "5px",
            display: "flex",
            flexDirection: "column",
            alignItems: "center",
            justifyContent: "center",
            background: "#4a4d4b",
            opacity: "0.7",
            cursor: "pointer"
        }}>
                <PlusOutlined style={{color: "darkgray", fontSize: "30px", cursor: "pointer", fontWeight: "700"}}/>
                <h4 style={{color: "darkgray"}}>ADD TO LIST</h4>
        </div>
    );
}

export default EmptyCard;