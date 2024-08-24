import React from 'react';
import {Link, useNavigate} from 'react-router-dom';
import * as HoverCard from '@radix-ui/react-hover-card';
import {Button} from "@radix-ui/themes";

const Location = ({ name, imgUrl, apiName }) => {
    const navigate = useNavigate();

    const handleClick = () => {
        navigate(`/locations/${apiName.toLowerCase()}`);
    };

    return (
            <button className={"location-button"} onClick={handleClick}>
                <img src={imgUrl} className={"location-image"} />
                <div>{name}</div>
            </button>
    );
};


export default Location;