-- Insert manufacturers first
INSERT INTO manufacturers (id, name, country, website) VALUES ('TSLA', 'Tesla', 'United States', 'https://www.tesla.com');
INSERT INTO manufacturers (id, name, country, website) VALUES ('FORD', 'Ford', 'United States', 'https://www.ford.com');
INSERT INTO manufacturers (id, name, country, website) VALUES ('HYUN', 'Hyundai', 'South Korea', 'https://www.hyundai.com');
INSERT INTO manufacturers (id, name, country, website) VALUES ('CHEV', 'Chevrolet', 'United States', 'https://www.chevrolet.com');
INSERT INTO manufacturers (id, name, country, website) VALUES ('NISS', 'Nissan', 'Japan', 'https://www.nissan.com');
INSERT INTO manufacturers (id, name, country, website) VALUES ('VWAG', 'Volkswagen', 'Germany', 'https://www.vw.com');


-- Then insert vehicles

INSERT INTO vehicles (model_code, name, description, range, price, seats, battery_capacity, manufacturer_id, horsepower, type)
VALUES ('TSLA-MOD3', 'Model 3', 'Compact sedan with excellent range and performance', 358, 41990.00, 5, 75.0, 'TSLA', 283, 'SEDAN');

INSERT INTO vehicles (model_code, name, description, range, price, seats, battery_capacity, manufacturer_id, horsepower, type)
VALUES ('TSLA-MODY', 'Model Y', 'Compact SUV with spacious interior', 330, 48490.00, 5, 75.0, 'TSLA', 384, 'SUV');

INSERT INTO vehicles (model_code, name, description, range, price, seats, battery_capacity, manufacturer_id, horsepower, type)
VALUES ('FORD-MACH', 'Mustang Mach-E', 'Electric SUV with Mustang styling', 300, 43895.00, 5, 70.0, 'FORD', 346, 'SUV');

INSERT INTO vehicles (model_code, name, description, range, price, seats, battery_capacity, manufacturer_id, horsepower, type)
VALUES ('HYUN-ION5', 'IONIQ 5', 'Modern crossover with fast charging', 303, 41450.00, 5, 77.4, 'HYUN', 320, 'SUV');

INSERT INTO vehicles (model_code, name, description, range, price, seats, battery_capacity, manufacturer_id, horsepower, type)
VALUES ('CHEV-BOLT', 'Bolt EV', 'Affordable compact with good range', 259, 26500.00, 5, 65.0, 'CHEV', 200, 'HATCHBACK');

INSERT INTO vehicles (model_code, name, description, range, price, seats, battery_capacity, manufacturer_id, horsepower, type)
VALUES ('NISS-LEAF', 'Leaf', 'Pioneering EV with practical features', 212, 28040.00, 5, 60.0, 'NISS', 147, 'HATCHBACK');

INSERT INTO vehicles (model_code, name, description, range, price, seats, battery_capacity, manufacturer_id, horsepower, type)
VALUES ('TSLA-MODS', 'Model S', 'Luxury sedan with top-tier performance', 405, 79990.00, 5, 100.0, 'TSLA', 670, 'SEDAN');

INSERT INTO vehicles (model_code, name, description, range, price, seats, battery_capacity, manufacturer_id, horsepower, type)
VALUES ('TSLA-MODX', 'Model X', 'Flagship SUV with falcon doors', 348, 89990.00, 7, 100.0, 'TSLA', 670, 'SUV');

INSERT INTO vehicles (model_code, name, description, range, price, seats, battery_capacity, manufacturer_id, horsepower, type)
VALUES ('FORD-F150L', 'F-150 Lightning', 'All-electric full-size pickup truck', 320, 55974.00, 5, 98.0, 'FORD', 563, 'SUV');

INSERT INTO vehicles (model_code, name, description, range, price, seats, battery_capacity, manufacturer_id, horsepower, type)
VALUES ('FORD-EEXPLR', 'Escape Electric', 'Compact electric crossover', 250, 39995.00, 5, 70.0, 'FORD', 210, 'SUV');

INSERT INTO vehicles (model_code, name, description, range, price, seats, battery_capacity, manufacturer_id, horsepower, type)
VALUES ('HYUN-KONA', 'Kona Electric', 'Small crossover EV', 258, 33950.00, 5, 64.0, 'HYUN', 201, 'SUV');

INSERT INTO vehicles (model_code, name, description, range, price, seats, battery_capacity, manufacturer_id, horsepower, type)
VALUES ('HYUN-ION6', 'IONIQ 6', 'Aerodynamic electric sedan', 361, 42950.00, 5, 77.4, 'HYUN', 320, 'SEDAN');

INSERT INTO vehicles (model_code, name, description, range, price, seats, battery_capacity, manufacturer_id, horsepower, type)
VALUES ('CHEV-BOLTEU', 'Bolt EUV', 'Slightly larger Bolt with SUV styling', 247, 27800.00, 5, 66.0, 'CHEV', 200, 'HATCHBACK');

INSERT INTO vehicles (model_code, name, description, range, price, seats, battery_capacity, manufacturer_id, horsepower, type)
VALUES ('CHEV-EQUINOX', 'Equinox EV', 'Upcoming compact SUV', 300, 34995.00, 5, 85.0, 'CHEV', 288, 'SUV');

INSERT INTO vehicles (model_code, name, description, range, price, seats, battery_capacity, manufacturer_id, horsepower, type)
VALUES ('NISS-ARIYA', 'Ariya', 'Mid-size electric crossover', 304, 47900.00, 5, 87.0, 'NISS', 389, 'SUV');

INSERT INTO vehicles (model_code, name, description, range, price, seats, battery_capacity, manufacturer_id, horsepower, type)
VALUES ('NISS-EVALIA', 'Evalia EV', 'Electric minivan for urban use', 124, 33000.00, 5, 24.0, 'NISS', 107, 'VAN');

INSERT INTO vehicles (model_code, name, description, range, price, seats, battery_capacity, manufacturer_id, horsepower, type)
VALUES ('VWAG-ID4', 'ID.4', 'Volkswagen’s flagship electric SUV', 275, 39995.00, 5, 82.0, 'VWAG', 295, 'SUV');

INSERT INTO vehicles (model_code, name, description, range, price, seats, battery_capacity, manufacturer_id, horsepower, type)
VALUES ('VWAG-IDBUZ', 'ID. Buzz', 'Electric revival of the VW Bus', 263, 55000.00, 7, 77.0, 'VWAG', 282, 'VAN');

INSERT INTO vehicles (model_code, name, description, range, price, seats, battery_capacity, manufacturer_id, horsepower, type)
VALUES ('VWAG-EUP', 'e-Up!', 'Compact urban EV', 159, 21000.00, 4, 36.8, 'VWAG', 82, 'HATCHBACK');

INSERT INTO vehicles (model_code, name, description, range, price, seats, battery_capacity, manufacturer_id, horsepower, type)
VALUES ('GEN-G80EV', 'Genesis Electrified G80', 'Luxury electric sedan', 282, 79950.00, 5, 87.2, 'HYUN', 365, 'SEDAN');

INSERT INTO vehicles (model_code, name, description, range, price, seats, battery_capacity, manufacturer_id, horsepower, type)
VALUES ('TES-CYBER', 'Cybertruck', 'Futuristic electric truck', 500, 69990.00, 6, 120.0, 'TSLA', 845, 'SUV');

INSERT INTO vehicles (model_code, name, description, range, price, seats, battery_capacity, manufacturer_id, horsepower, type)
VALUES ('FORD-EFIESTA', 'e-Fiesta', 'Compact hatchback EV', 186, 21995.00, 5, 45.0, 'FORD', 134, 'HATCHBACK');

INSERT INTO vehicles (model_code, name, description, range, price, seats, battery_capacity, manufacturer_id, horsepower, type)
VALUES ('NISS-TOWN', 'Townstar EV', 'Commercial electric van', 177, 28700.00, 2, 44.0, 'NISS', 121, 'VAN');

INSERT INTO vehicles (model_code, name, description, range, price, seats, battery_capacity, manufacturer_id, horsepower, type)
VALUES ('CHEV-SILV', 'Silverado EV', 'Electric pickup with long range', 400, 74995.00, 5, 120.0, 'CHEV', 664, 'SUV');

INSERT INTO vehicles (model_code, name, description, range, price, seats, battery_capacity, manufacturer_id, horsepower, type)
VALUES ('VWAG-ID3', 'ID.3', 'Compact hatch EV from Volkswagen', 263, 39000.00, 5, 77.0, 'VWAG', 201, 'HATCHBACK');

INSERT INTO vehicles (model_code, name, description, range, price, seats, battery_capacity, manufacturer_id, horsepower, type)
VALUES ('TSLA-MOD2', 'Model 2 (concept)', 'Future compact EV', 250, 25000.00, 5, 50.0, 'TSLA', 170, 'HATCHBACK');

INSERT INTO vehicles (model_code, name, description, range, price, seats, battery_capacity, manufacturer_id, horsepower, type)
VALUES ('HYUN-STARGZR', 'Stargazer EV', 'Compact MPV for families', 240, 31900.00, 6, 55.0, 'HYUN', 190, 'VAN');

INSERT INTO vehicles (model_code, name, description, range, price, seats, battery_capacity, manufacturer_id, horsepower, type)
VALUES ('NISS-EPOWER', 'e-Power Note', 'Hybrid-style electric compact', 250, 23000.00, 5, 55.0, 'NISS', 114, 'HATCHBACK');

INSERT INTO vehicles (model_code, name, description, range, price, seats, battery_capacity, manufacturer_id, horsepower, type)
VALUES ('VWAG-GOLF', 'e-Golf', 'Electric version of VW Golf', 144, 31900.00, 5, 35.8, 'VWAG', 134, 'HATCHBACK');

INSERT INTO vehicles (model_code, name, description, range, price, seats, battery_capacity, manufacturer_id, horsepower, type)
VALUES ('FORD-EESCAPE', 'e-Escape', 'Electric Escape variant', 280, 37900.00, 5, 70.0, 'FORD', 265, 'SUV');

INSERT INTO vehicles (model_code, name, description, range, price, seats, battery_capacity, manufacturer_id, horsepower, type)
VALUES ('CHEV-TRAX', 'Trax EV', 'Compact crossover EV concept', 270, 29995.00, 5, 65.0, 'CHEV', 210, 'SUV');

INSERT INTO vehicles (model_code, name, description, range, price, seats, battery_capacity, manufacturer_id, horsepower, type)
VALUES ('HYUN-VENUE', 'Venue EV', 'Entry-level electric crossover', 195, 22900.00, 5, 47.0, 'HYUN', 150, 'SUV');

INSERT INTO vehicles (model_code, name, description, range, price, seats, battery_capacity, manufacturer_id, horsepower, type)
VALUES ('VWAG-TIGEV', 'Tiguan EV', 'Electric version of Tiguan SUV', 350, 45900.00, 5, 85.0, 'VWAG', 320, 'SUV');


INSERT INTO charging_stations (location, provider, capacity)
VALUES('Toronto - Union Station', 'ChargePoint', 6);

INSERT INTO charging_stations (location, provider, capacity)
VALUES('Mississauga - Square One Mall', 'Flo', 8);

INSERT INTO charging_stations (location, provider, capacity)
VALUES('Scarborough Town Centre', 'Tesla', 10);

INSERT INTO charging_stations (location, provider, capacity)
VALUES('Markham Civic Centre', 'ChargeHub', 4);

INSERT INTO charging_stations (location, provider, capacity)
VALUES('North York - Fairview Mall', 'Electrify Canada', 5);

INSERT INTO charging_stations (location, provider, capacity)
VALUES('Downtown Toronto - Queen St', 'Tesla', 12);

INSERT INTO charging_stations (location, provider, capacity)
VALUES('Etobicoke - Sherway Gardens', 'EVgo', 6);

INSERT INTO charging_stations (location, provider, capacity)
VALUES('Toronto Pearson Airport', 'ChargePoint', 15);

-- Insert user preferences (test data)
INSERT INTO user_preferences (full_name, budget, seats, min_range, preferred_manufacturer_id, min_horsepower, type)
VALUES ('John Doe', 45000.00, 5, 300, 'TSLA', 300, 'SEDAN');


