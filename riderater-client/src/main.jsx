import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import App from './App.jsx'
import './index.css'
import Root from './Root.jsx';
import '@radix-ui/themes/styles.css';
import {AuthProvider} from "./AuthContext.jsx";

createRoot(document.getElementById('root')).render(
    <AuthProvider>
        <StrictMode>
            <Root />
        </StrictMode>
    </AuthProvider>
)
