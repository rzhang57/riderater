import React from 'react';
import {useNavigate} from 'react-router-dom';


export default function AttractionButton({name, imgUrl, apiAttractionId, apiLocationName, avgRating, description}) {
    const navigate = useNavigate();

    const handleClick = () => {
        navigate(`/locations/${apiLocationName}/attraction/${apiAttractionId}`);
    }

    return (
        <>
            <button className={"location-button"} onClick={handleClick}>
                <img src={imgUrl} className={"location-image"} />
                <div>{name}</div>
                <div>{avgRating}</div>
            </button>
        </>
    );
}