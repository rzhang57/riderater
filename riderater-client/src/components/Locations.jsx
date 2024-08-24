import React from 'react';
import Location from './Location';

const Locations = () => {
    return (
        <>
            <h1>Select park:</h1>
            <div className='grid'>
                <Location name="Disneyland Resort, Anaheim, California"
                          imgUrl={"https://media.cntraveler.com/photos/614e3cf6d4cb4c568961dee5/1:1/w_3648,h_3648,c_limit/Disneyland_DXDDD2.jpg"}
                          apiName={"CALIFORNIA"}/>
                <Location name="Walt Disney World Resort, Orlando, Florida"
                          imgUrl={"https://upload.wikimedia.org/wikipedia/commons/thumb/6/6b/Cinderella_Castle%2C_Magic_Kingdom_Walt_Disney_World_%282024%29.jpg/250px-Cinderella_Castle%2C_Magic_Kingdom_Walt_Disney_World_%282024%29.jpg"}
                          apiName={"FLORIDA"}/>
                <Location name="Tokyo Disney Resort, Chiba, Japan"
                          imgUrl={"https://upload.wikimedia.org/wikipedia/commons/thumb/4/4b/Tokyo_Disneyland_Cinderella_Castle_2023-07-02.jpg/250px-Tokyo_Disneyland_Cinderella_Castle_2023-07-02.jpg"}
                          apiName={"TOKYO"}/>
                <Location name="Disneyland Paris, Marne-la-Vallée, France"
                          imgUrl={"https://media.architecturaldigest.com/photos/621e2b8a0dfcde70e6b201e0/1:1/w_1707,h_1707,c_limit/SB_2614-HDR-scaled.jpeg"}
                          apiName={"PARIS"}/>
                <Location name="Hong Kong Disneyland Resort, Lantau Island, Hong Kong"
                          imgUrl={"https://upload.wikimedia.org/wikipedia/commons/2/27/Castle_of_Magical_Dreams.jpg"}
                          apiName={"HONGKONG"}/>
                <Location name="Shanghai Disneyland Resort Pudong, Shanghai, China"
                          imgUrl={"https://upload.wikimedia.org/wikipedia/commons/c/cb/Shanghai_disneyland_castle.jpg"}
                          apiName={"SHANGHAI"}/>
            </div>
        </>

    )

}

export default Locations;
