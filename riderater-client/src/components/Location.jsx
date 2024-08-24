import React from 'react';
import {useNavigate} from 'react-router-dom';

const Location = ({ name, imgUrl, location }) => {
    const navigate = useNavigate();

    const handleClick = () => {
        navigate(`/locations/${location.toLowerCase()}`);
    };

    return (
            <button className={"location-button"} onClick={handleClick}>
                <img src={imgUrl} className={"location-image"} />
                <div>{name}</div>
            </button>
    );
};


export default Location;