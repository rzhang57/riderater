import React, { useEffect, useState } from 'react';
import axios from 'axios';
import {Link, useParams} from 'react-router-dom';

const AttractionList = () => {
    const { location } = useParams();
    const [attractions, setAttractions] = useState([]);

    useEffect (() => {
        const fetchAttractions = async () => {
            try {
                const response = await axios.get(`http://localhost:8080/api/attractions/${location.toUpperCase()}`);
                console.log(response.data);
                setAttractions(response.data);
            } catch(error) {
                console.error('Error fetching data', error);
            }
        };
        fetchAttractions();
    }, [location]);

    return (
        <div>
            <h2>{location}</h2>
            <ul>
                {Array.isArray(attractions) ? (
                    attractions.map((attraction, index) => (
                        <li key={index}>{attraction.name} {attraction.averageRating}</li>
                    ))
                ) : (
                    <li>No attractions found</li>
                )}
            </ul>
        </div>
    )
}

export default AttractionList;