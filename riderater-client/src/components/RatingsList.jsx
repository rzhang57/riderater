import React, { useEffect, useState } from 'react';
import axios from 'axios';
import {Link, useParams} from 'react-router-dom';
import {Spinner} from "@radix-ui/themes";
import AttractionButton from './AttractionButton.jsx';
import Rating from "./Rating.jsx";
import CreateRatingButton from "./CreateRatingButton.jsx";
import {Bar, BarChart, CartesianGrid, Legend, Tooltip, XAxis, YAxis} from "recharts";

// should implement pagination
const RatingsList = ({location, attractionName, attractionDescription}) => {
    const {attractionId} = useParams();
    const [ratings, setRatings] = useState([]);
    const [loading, setLoading] = useState(true);
    const [attraction, setAttraction] = useState({});
    const [data, setData] = useState([]);
    let loading1 = false;
    let loading2 = false;

    useEffect(
        () => {
            window.scrollTo({
                top: 0,
                behavior: 'smooth' // This makes the scroll smooth
            });

            function filterRatingCount(ratingValue) {
                const ratingCount = ratings.filter((rating) => rating.rating === ratingValue).length ;
                return ratingCount || 0;
            }



            const dataTemp = [];

            for (let i = 1; i <= 5; i++) {
                console.log('pushing data', i)
                dataTemp.push(
                    {
                        rating: i,
                        count: filterRatingCount(i)
                    });
                console.log(dataTemp);
            }
            setData(dataTemp);
            console.log(data);
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
        <div className={"center"}>
            <h1 className={'title'}>{attraction.name}</h1>
            <h2 className={'title'}>{attraction.averageRating}/5</h2>
                <BarChart width={730} height={250} data={data}>
                    <XAxis dataKey="rating" />
                    <YAxis domain={["auto", "auto"]} />
                    <Bar dataKey="count" fill="#82ca9d" barSize={"7%"} />
                </BarChart>

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
        </div>

    )
}

export default RatingsList;