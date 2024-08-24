import React, { useEffect, useState } from 'react';
import axios from 'axios';
import {Link, useLocation, useParams} from 'react-router-dom';
import {Spinner} from "@radix-ui/themes";
import AttractionButton from './AttractionButton.jsx';

const AttractionList = () => {
    const { location } = useParams();
    const [attractions, setAttractions] = useState([]);
    const [loading, setLoading] = useState(true);
    const name = useLocation();
    const {name : selectedLocation } = name.state || {};

    useEffect (() => {
        const fetchAttractions = async () => {
            try {
                const response = await axios.get(`http://localhost:8080/api/attractions/${location.toUpperCase()}`);
                console.log(response.data);
                setAttractions(response.data);
            } catch(error) {
                console.error('Error fetching data', error);
            } finally {
                setLoading(false);
            }
        };
        fetchAttractions();
    }, [name]);

    if (loading) {
        return (
            <Spinner/>
            );
    }

    return (
        <>
            <h1 className={'title'}>{selectedLocation}</h1>
            <div className="grid">

                <>
                    {
                        attractions.map((attraction, index) => (
                            <AttractionButton name={attraction.name}
                                              imgUrl={'https://www.shutterstock.com/image-vector/default-ui-image-placeholder-wireframes-600nw-1037719192.jpg'}
                                              apiAttractionId={attraction.id}
                                              apiLocationName={location}
                                              avgRating={attraction.averageRating}
                                              description={attraction.description}
                                              key={attraction.id || index}
                            />
                        ))
                    }
                </>


                {/*<ul>*/}
                {/*    {Array.isArray(attractions) ? (*/}
                {/*        attractions.map((attraction, index) => (*/}
                {/*            <li key={index}>{attraction.name} {attraction.averageRating}</li>*/}
                {/*        ))*/}
                {/*    ) : (*/}
                {/*        <li>No attractions found</li>*/}
                {/*    )}*/}
                {/*</ul>*/}
            </div>
        </>

    )
}

export default AttractionList;