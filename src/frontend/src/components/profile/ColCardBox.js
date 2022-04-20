import Card from "react-bootstrap/Card";
import React from "react";

const ColCardBox = ({Title, imdbID, Poster, ShowDetail, DetailRequest, ActivateModal}) => {
    const API_KEY = "ba1855b1";

    const clickHandler = () => {

        // Display Modal and Loading Icon
        ActivateModal(true);
        DetailRequest(true);

        fetch(`https://www.omdbapi.com/?i=${imdbID}&apikey=${API_KEY}`)
            .then(resp => resp)
            .then(resp => resp.json())
            .then(data => {
                DetailRequest(false);
                ShowDetail(data);
            })
            .catch(({message}) => {
                DetailRequest(false);
            })
    }

    return (
        <div>
            <Card
                style={{
                    borderRadius: "5px",
                    height: "auto",
                    width: "250px",
                    background: "none",
                    cursor: "pointer",
                    marginLeft: "10px",
                    paddingRight: "30px"
                }}
                onClick={() => clickHandler()}
            >
                <Card.Img
                    style={{
                        borderRadius: "5px",
                    }}
                    variant="top"
                    src={Poster}
                    alt={Title}
                />
            </Card>
        </div>
    );
}

export default ColCardBox;