import react, {useState} from 'react';
import { Link } from 'react-router-dom';
import * as Popover from '@radix-ui/react-popover';
import './styles.css'

const Home = () => {

    return (
        <div>
            <h1>Welcome to riderater</h1>
            <Link to="/locations">
                <button>View available theme parks</button>
            </Link>

            <Popover.Root>
                <Popover.Trigger className="PopoverTrigger">More info</Popover.Trigger>
                <Popover.Portal>
                    <Popover.Content className="PopoverContent">
                        Some more info…
                        <Popover.Arrow className="PopoverArrow"  />
                    </Popover.Content>
                </Popover.Portal>
            </Popover.Root>


        </div>
    );
};

export default Home;