import React, {useState} from 'react';
import {useParams} from "react-router-dom";
import axios from "axios";

export default function RatingForm() {
    const { attractionId } = useParams();
    const [rating, setRating] = useState('');
    const [comment, setComment] = useState('');

    console.log(attractionId);

    const handleClick = async (e) => {
        console.log('Submitting:', { rating, comment, attractionId });

        try {
            const response = await axios.post(`http://localhost:8080/api/attractions/${attractionId}/ratings`,
                {
                    rating: rating,
                    comment: comment
                });
            console.log("Rating submitted successfully:", response.data);
        } catch (error) {
            console.error("Error submitting rating:", error);
        }
    }

    return (
        <div className="ratingForm">
            <h1>Rate this ride!</h1>
            <form id="ratingForm">
                <div>
                    <label htmlFor="rating"></label>
                    <select id="rating" name="rating" onChange={(e) => setRating(e.target.value)} required>
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                    </select>
                </div>
                <div className={'form-list'}>
                    <label htmlFor="comment">Comment:</label>
                    <textarea id="comment"
                              name="comment"
                              rows="10"
                              cols="100"
                              onChange={(e) => setComment(e.target.value)}
                              placeholder="Enter your comment here..."
                              required></textarea>
                </div>
                <div>
                    <button type="submit" onSubmit={handleClick}>Submit</button>
                </div>
            </form>
        </div>
    );
}