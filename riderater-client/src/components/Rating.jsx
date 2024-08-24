import React from 'react';

export default function Rating({user, date, rating, review}) {
    return (
        <div className="rating-container">
            <div className="rating-header">
                <div className="rating-user">
                    <span>{user}</span>
                    <span className="rating-score">{`${rating}/5`}</span>
                </div>
                <span className="rating-date">{date}</span>
            </div>
            <p className="rating-review">{review}</p>
        </div>
    );
}