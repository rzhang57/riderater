import axios from 'axios';

const API_URL = 'http://localhost:8080'; // try to get env working

console.log(`API URL:`, API_URL);

export const getAttractions = async () => {
    const response = await axios.get(`${API_URL}/api/attractions/`);
    return response.data;
};

export const getRatingsByAttraction = async (attractionId: number) => {
    const response = await axios.get(`${API_URL}/api/attractions/${attractionId}`);
    return response.data;
};
