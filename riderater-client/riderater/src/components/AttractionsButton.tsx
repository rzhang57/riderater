import React, { useState } from 'react';
import { getAttractions } from '../service/ApiService';

const AttractionsButton: React.FC = () => {
    const [attractions, setAttractions] = useState<any[]>([]);
    const [loading, setLoading] = useState<boolean>(false);
    const [error, setError] = useState<string | null>(null);

    const handleFetchAttractions = async () => {
        setLoading(true);
        setError(null);
        try {
            const data = await getAttractions();
            console.log("Got attractions!");
            setAttractions(data);
        } catch (error) {
            console.error("Error fetching", error);
            setError("Failed to fetch attractions");
        } finally {
            setLoading(false);
        }
    };

    return (
        <div>
            <button onClick={handleFetchAttractions} disabled={loading}>
                {loading ? "Loading..." : "Get Attractions"}
            </button>
            {error && <p style={{ color: 'red' }}>{error}</p>}
            <ul>
                {attractions.map(attraction => (
                    <li key={attraction.id}>{attraction.name}            Avg Rating = {attraction.averageRating}</li>
                ))}
            </ul>
        </div>
    );
};

export default AttractionsButton;