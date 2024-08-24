import React, { useEffect, useState } from 'react';
import axios from 'axios';
import {Link, useParams} from 'react-router-dom';
import {Spinner} from "@radix-ui/themes";
import AttractionButton from './AttractionButton.jsx';
import Rating from "./Rating.jsx";

const RatingsList = ({location, attractionName, attractionDescription}) => {
    const {attractionId} = useParams();
    const [ratings, setRatings] = useState([]);
    const [loading, setLoading] = useState(true);

    useEffect (() => {
        const fetchRatingsByAttraction = async () => {
            try {
                const response = await axios.get(`http://localhost:8080/api/attractions/${attractionId}/ratings`);
                console.log(response.data);
                setRatings(response.data);
            } catch(error) {
                console.error('Error fetching data', error);
            } finally {
                setLoading(false);
            }
        };

        const fetchAttraction = async () => {
            try {
                const response = await axios.get(`http://localhost:8080/api/attractions/${attractionId}/ratings`);
                console.log(response.data);
                setRatings(response.data);
            } catch(error) {
                console.error('Error fetching data', error);
            } finally {
                setLoading(false);
            }
        }

        fetchRatingsByAttraction();
    }, [attractionId]);

    if (loading) {
        return (
            <Spinner/>
        );
    }

    return (
        <>
            <h1>{attractionName}</h1>
            <div className="ratings-list">

                <>
                    {
                        ratings.map((rating) => (
                            <Rating
                                user={"anonymous"}
                                date={rating.date}
                                rating={rating.rating}
                                review={rating.comment}
                            />
                        ))
                    }
                </>
            </div>
        </>

    )
}

export default RatingsList;