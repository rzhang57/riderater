import react from 'react';
import { Link } from 'react-router-dom';

const Home = () => {
    return (
        <div>
            <h1>Welcome to riderater</h1>
            <Link to="/locations">
                <button>View available theme parks</button>
            </Link>
        </div>
    );
};

export default Home;