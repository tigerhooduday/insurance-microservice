CREATE TABLE policy (
    policy_id INT PRIMARY KEY,
    policy_holder_name VARCHAR(100) NOT NULL,
    policy_type VARCHAR(50) NOT NULL,
    premium DECIMAL(10, 2) NOT NULL,
    status VARCHAR(20) NOT NULL
);
