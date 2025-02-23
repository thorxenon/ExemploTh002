CREATE TABLE IF NOT EXISTS department (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS employee (
    matriculation VARCHAR(255) PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    enrollDate DATE,
    department_id INT,
    FOREIGN KEY (department_id) REFERENCES department(id)
);

-- Insert departments
INSERT INTO department (id, name) VALUES (DEFAULT, 'Fanantial');
INSERT INTO department (id, name) VALUES (DEFAULT, 'Comercial');
INSERT INTO department (id, name) VALUES (DEFAULT, 'Human Resources');
INSERT INTO department (id, name) VALUES (DEFAULT, 'IT');

-- Insert employees
INSERT INTO employee (matriculation, name, enroll_date, id) VALUES ('E001', 'John Doe', '2025-01-01', 1);
INSERT INTO employee (matriculation, name, enroll_date, id) VALUES ('E002', 'Jane Smith', '2025-01-02', 2);
INSERT INTO employee (matriculation, name, enroll_date, id) VALUES ('E003', 'Alice Johnson', '2025-01-03', 3);
INSERT INTO employee (matriculation, name, enroll_date, id) VALUES ('E004', 'Bob Brown', '2025-01-04', 4);
INSERT INTO employee (matriculation, name, enroll_date, id) VALUES ('E005', 'Charlie Davis', '2025-01-05', 1);
INSERT INTO employee (matriculation, name, enroll_date, id) VALUES ('E006', 'Diana Evans', '2025-01-06', 2);