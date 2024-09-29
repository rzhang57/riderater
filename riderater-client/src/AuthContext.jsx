import React, { createContext, useContext, useState, useEffect } from 'react';

const AuthContext = createContext();

export const useAuth = () => useContext(AuthContext);

export const AuthProvider = ({ children }) => {
    const [authenticated, setAuthenticated] = useState(false);
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        // check if the user is authenticated by making a request to the backend
        const checkAuthentication = async () => {
            try {
                const response = await fetch('/loginSuccess', {
                    credentials: 'include', // Include session cookies
                });

                if (response.ok) {
                    setAuthenticated(true);
                }
            } catch (error) {
                console.error('Error checking authentication:', error);
            } finally {
                setLoading(false);
            }
        };

        checkAuthentication();
    }, []);

    return (
        <AuthContext.Provider value={{ authenticated, setAuthenticated, loading }}>
            {children}
        </AuthContext.Provider>
    );
};