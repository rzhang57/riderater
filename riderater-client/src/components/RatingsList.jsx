import React, { useEffect, useState } from 'react';
import axios from 'axios';
import {Link, useParams} from 'react-router-dom';
import {Spinner} from "@radix-ui/themes";
import AttractionButton from './AttractionButton.jsx';
import Rating from "./Rating.jsx";
import CreateRatingButton from "./CreateRatingButton.jsx";

// should implement pagination
const RatingsList = ({location, attractionName, attractionDescription}) => {
    const {attractionId} = useParams();
    const [ratings, setRatings] = useState([]);
    const [loading, setLoading] = useState(true);
    const [attraction, setAttraction] = useState({});
    let loading1 = false;
    let loading2 = false;

    useEffect(
        () => {
            window.scrollTo({
                top: 0,
                behavior: 'smooth' // This makes the scroll smooth
            });
        },
        [loading]
    )

    useEffect (() => {
        const fetchRatingsByAttraction = async () => {
            try {
                const response = await axios.get(`http://localhost:8080/api/attractions/${attractionId}/ratings`);
                console.log(response.data);
                setRatings(response.data);
                loading1 = true;
            } catch(error) {
                console.error('Error fetching data', error);
            } finally {
                if (loading1 && loading2) {
                    setLoading(false);
                } else {
                    console.log("title not yet loaded")
                }
            }
        };

        const fetchAttraction = async () => {
            try {
                const response = await axios.get(`http://localhost:8080/api/attractions/x/${attractionId}`);
                console.log(response.data);
                setAttraction(response.data);
                loading2 = true;
            } catch(error) {
                console.error('Error fetching data', error);
            } finally {
                if (loading1 && loading2) {
                    setLoading(false);
                } else {
                    console.log("ratings not yet loaded")
                }
            }
        }

        fetchRatingsByAttraction();
        fetchAttraction();
    }, [attractionId]);

    if (loading) {
        return (
            <Spinner/>
        );
    }

    return (
        <>
            <h1 className={'title'}>{attraction.name}</h1>
            <CreateRatingButton apiLocationName={attraction.location.toLowerCase()} apiAttractionId={attraction.id} />

            <p></p>
            <div className="ratings-list">
                <>
                    {
                        ratings.map((rating, index) => (
                            <Rating
                                key={rating.id || index}
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