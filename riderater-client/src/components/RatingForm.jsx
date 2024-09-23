import React, {useState, useEffect} from 'react';
import {useLocation, useNavigate, useParams} from "react-router-dom";
import axios from "axios";
import {AlertDialog, Button, Flex} from "@radix-ui/themes";
import error from "eslint-plugin-react/lib/util/error.js";

export default function RatingForm() {
    const { attractionId } = useParams();
    const { location } = useParams();
    const [rating, setRating] = useState(0);
    const [comment, setComment] = useState('');
    const [isDialogOpen, setIsDialogOpen] = useState(false);

    useEffect(() => {
        const checkAuthStatus = async () => {
            try {
                const response = await fetch('/loginSuccess', {
                    credentials: 'include', // Ensure cookies/sessions are sent with the request
                });

                if (response.ok) {
                    const userData = await response.json();
                    setUser(userData); // Set the authenticated user
                } else {
                    // User is not authenticated, redirect to login
                    window.location.href = '/oauth2/authorization/google'; // Force Google login
                }
            } catch (error) {
                console.error('Error checking authentication status:', error);
                window.location.href = '/oauth2/authorization/google'; // Redirect to login on error
            }
        };

        checkAuthStatus();
    }, []);

    const navigate = useNavigate();

    console.log(attractionId);

    const handleClick = async (e) => {
        e.preventDefault();


        if (rating === 0) {
            setIsDialogOpen(true);
        } else {
            try {
                console.log('Submitting:', {rating, comment, attractionId });
                const response = await axios.post(`http://localhost:8080/api/attractions/${attractionId}/create`,
                    {
                        'userName': 'DefaultAnon', // should keep a variation of this for when new users without accounts want to rate, but also should change to actual request username.
                        'rating': rating,
                        'comment': comment,
                        'attractionId': attractionId,
                    });
                console.log("Rating submitted successfully:", response.data);
            } catch (error) {
                console.error("Error submitting rating:", error);
            }

            navigate(`/locations/${location}/attraction/${attractionId}`);

        }



    }

    return (
        <div className="ratingForm">
            <h1>Rate this ride!</h1>
            <form id="ratingForm">
                <div>
                    <label htmlFor="rating"></label>
                    <select id="rating" name="rating" onChange={(e) => setRating(e.target.value)} required>
                        <option>Select a rating</option>
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
                    <button onClick={handleClick}>Submit</button>
                </div>


            </form>

            <AlertDialog.Root open={isDialogOpen} onOpenChange={setIsDialogOpen}>
                <AlertDialog.Trigger asChild>
                    <Button style={{ display: 'none' }}>Revoke access</Button>
                </AlertDialog.Trigger>
                <AlertDialog.Content maxWidth="450px">
                    <AlertDialog.Title>Invalid Rating</AlertDialog.Title>
                    <AlertDialog.Description size="2">
                        Please select a rating before submitting.
                    </AlertDialog.Description>

                    <Flex gap="3" mt="4" justify="end">
                        <AlertDialog.Cancel asChild>
                            <Button variant="soft" color="gray" onClick={() => setIsDialogOpen(false)}>
                                OK
                            </Button>
                        </AlertDialog.Cancel>
                    </Flex>
                </AlertDialog.Content>
            </AlertDialog.Root>
        </div>
    );
}