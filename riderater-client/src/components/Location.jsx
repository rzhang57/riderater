import React from 'react';
import {useNavigate} from 'react-router-dom';

const Location = ({ name, imgUrl, location }) => {
    const navigate = useNavigate();

    const handleClick = () => {
        navigate(`/locations/${location.toLowerCase()}`, { state: { name } });
    };

    return (
            <button className={"location-button"} onClick={handleClick}>
                <img src={imgUrl} className={"location-image"} />
                <div className={'rating-user'}>{name}</div>
            </button>
    );
};


export default Location;