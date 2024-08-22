import React from 'react';
import { useNavigate } from 'react-router-dom';

const Location = ({ name }) => {
    const navigate = useNavigate();

    const handleClick = () => {
        navigate(`/locations/${name.toLowerCase()}`);
    };

    return (
        <button onClick={handleClick}>
            {name}
        </button>
    );
};


export default Location;