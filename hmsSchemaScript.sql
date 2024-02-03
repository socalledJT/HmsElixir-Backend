CREATE DATABASE hms;
USE hms;


CREATE TABLE user (
	id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    full_name VARCHAR(255),
    email VARCHAR(255),
    password VARCHAR(255),
    role VARCHAR(255)
);

CREATE TABLE employee (
	id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    user_id INT,
    department_id INT,
    
    FOREIGN KEY (user_id) REFERENCES user(id)
);

ALTER TABLE employee ADD FOREIGN KEY (department_id) REFERENCES department(id);

CREATE TABLE department (
	id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    dep_name VARCHAR(255)
);

CREATE TABLE appointment (
	id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    appointment_date DATETIME,
    prescription VARCHAR(255),
    patient_notes VARCHAR(255),
    patient_id INT,
    doctor_id INT,
    examination_id INT,
    
    FOREIGN KEY (patient_id) REFERENCES user(id),
    FOREIGN KEY (doctor_id) REFERENCES user(id)
);

ALTER TABLE appointment ADD FOREIGN KEY (examination_id) REFERENCES examination(id);

CREATE TABLE examination (
	id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    examination_date DATETIME,
    examination_notes VARCHAR(255),
    user_id INT,
    employee_id INT,
    
    FOREIGN KEY (user_id) REFERENCES user(id),
    FOREIGN KEY (employee_id) REFERENCES employee(id)
);