CREATE TABLE IF NOT EXISTS Attractions (
    id INT NOT NULL,
    name varchar(250) NOT NULL,
    location varchar(200) NOT NULL,
    description TEXT,
    average_rating NUMERIC(3, 1) DEFAULT 0.0,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS ratings (
    id INT NOT NULL,
    rating INT NOT NULL,
    attraction_id INT NOT NULL REFERENCES Attractions(id) ON DELETE CASCADE,
    PRIMARY KEY (id)
);