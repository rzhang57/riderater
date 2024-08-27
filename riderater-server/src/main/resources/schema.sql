DROP TABLE IF EXISTS ratings;
DROP TABLE IF EXISTS Attractions;


CREATE TABLE IF NOT EXISTS Attractions (
    id SERIAL NOT NULL,
    name varchar(250) NOT NULL,
    location varchar(200) NOT NULL,
    description TEXT,
    averageRating NUMERIC(3, 1) DEFAULT 0.0,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS ratings (
    id SERIAL NOT NULL,
    userName TEXT,
    rating INT NOT NULL,
    comment TEXT,
    attraction_id INT NOT NULL,
    date DATE DEFAULT CURRENT_DATE,
    PRIMARY KEY (id),
    CONSTRAINT fk_attraction
        FOREIGN KEY (attraction_id)
        REFERENCES Attractions (id)
);