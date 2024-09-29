import React from 'react';
import {useNavigate} from 'react-router-dom';
import * as Tooltip from '@radix-ui/react-tooltip';
import {Button} from "@radix-ui/themes";
import { RxPencil1 } from "react-icons/rx";
import { useAuth } from "../AuthContext.jsx";


export default function CreateRatingButton({apiLocationName, apiAttractionId}) {
    const navigate = useNavigate();
    const {authenticated, loading} = useAuth();

    const handleClick = () => {
        if (loading ) return;

        if (authenticated) {
            navigate(`/locations/${apiLocationName}/attraction/${apiAttractionId}/ratings/create`);
        } else {
            window.location.href = "http://localhost:8080/oauth2/authorization/google";
        }

    }

    return (
        <div className="create-rating-button">
            <div className="captioned-button">
                <Button radius={"full"} variant={'surface'} size={"4"} color={"gold"} onClick={handleClick}>
                    <RxPencil1/> Rate this ride
                </Button>
            </div>
        </div>

    );
}