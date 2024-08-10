DROP TABLE IF EXISTS ratings;
DROP TABLE IF EXISTS Attractions;


CREATE TABLE IF NOT EXISTS Attractions (
    id INT NOT NULL,
    name varchar(250) NOT NULL,
    location varchar(200) NOT NULL,
    description TEXT,
    averageRating NUMERIC(3, 1) DEFAULT 0.0,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS ratings (
    id INT NOT NULL,
    rating INT NOT NULL,
    attraction_id INT NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_attraction
        FOREIGN KEY (attraction_id)
        REFERENCES Attractions (id)
);