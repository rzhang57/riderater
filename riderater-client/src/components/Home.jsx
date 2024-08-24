import react, {useState} from 'react';
import { Link } from 'react-router-dom';
import * as Popover from '@radix-ui/react-popover';
import './styles.css'

const Home = () => {

    return (
        <div className={'home'}>
            <h1>Ride Rater</h1>
            <p>Welcome to Ride Rater! The first centralized, community-based, and the most accurate amusement park ride rater, brought to you by certified riders!</p>
            <Link to="/locations">
                <button className={'home-button'}>View available theme parks</button>
            </Link>

            {/*<Popover.Root>*/}
            {/*    <Popover.Trigger className="PopoverTrigger">More info</Popover.Trigger>*/}
            {/*    <Popover.Portal>*/}
            {/*        <Popover.Content className="PopoverContent">*/}
            {/*            Some more info…*/}
            {/*            <Popover.Arrow className="PopoverArrow"  />*/}
            {/*        </Popover.Content>*/}
            {/*    </Popover.Portal>*/}
            {/*</Popover.Root>*/}


        </div>
    );
};

export default Home;