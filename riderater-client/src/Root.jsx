import React from 'react';
import {Theme} from '@radix-ui/themes';
import App from './App.jsx';


export default function Root () {
    return (
        <html>
            <body>
                <Theme>
                    <App/>
                </Theme>
            </body>
        </html>
    )
}