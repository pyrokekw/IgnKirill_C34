CREATE TABLE routes (
                        id SERIAL PRIMARY KEY,
                        name VARCHAR(100) NOT NULL,
                        description TEXT,
                        length DOUBLE PRECISION NOT NULL,
                        votes INTEGER DEFAULT 0
);

CREATE TABLE votes (
                       route_id INTEGER REFERENCES routes(id),
                       employee_id VARCHAR(50),
                       PRIMARY KEY (route_id, employee_id)
);