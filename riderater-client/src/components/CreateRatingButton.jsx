import React from 'react';
import {useNavigate} from 'react-router-dom';
import * as Tooltip from '@radix-ui/react-tooltip';
import {Button} from "@radix-ui/themes";
import { RxPencil1 } from "react-icons/rx";


export default function CreateRatingButton({apiLocationName, apiAttractionId}) {
    const navigate = useNavigate();

    const handleClick = () => {
        navigate(`/locations/${apiLocationName}/attraction/${apiAttractionId}/ratings/create`);
    }

    return (
        <div className="create-rating-button">
            <div className="captioned-button">
                <Button radius={"full"} variant={'surface'} size={"4"} color={"gold"}  onClick={handleClick}>
                    <RxPencil1/> Rate this ride
                </Button>
            </div>
        </div>

    );
}