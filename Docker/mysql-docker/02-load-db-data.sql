-- Insert into Users table
INSERT INTO Users (user_id, username, full_name, email) VALUES
(1, 'jsmith', 'John Smith', 'john.smith@example.com'),
(2, 'emiller', 'Emma Miller', 'emma.miller@example.com'),
(3, 'apatel', 'Amit Patel', 'amit.patel@example.com'),
(4, 'llee', 'Liam Lee', 'liam.lee@example.com'),
(5, 'rchambers', 'Rachel Chambers', 'rachel.chambers@example.com');

-- Insert into Projects table
INSERT INTO Projects (project_id, project_name, description) VALUES
(1, 'Website Redesign', 'Redesign the corporate website'),
(2, 'Mobile App Launch', 'Launch the new mobile application'),
(3, 'Cloud Migration', 'Migrate services to the cloud'),
(4, 'Marketing Campaign', 'New product marketing campaign'),
(5, 'Infrastructure Improvement', 'Upgrade IT infrastructure');

-- Insert into Tasks table
INSERT INTO Tasks (task_id, task_name, description, project_id, user_id, due_date, status) VALUES
(1, 'Create wireframes', 'Design initial wireframes for the website', 1, 1, '2024-09-01', 'IN_PROGRESS'),
(2, 'Develop backend', 'Set up backend services for the app', 2, 2, '2024-09-15', 'TODO'),
(3, 'Set up cloud environment', 'Prepare environment for migration', 3, 3, '2024-10-01', 'DONE'),
(4, 'Design campaign assets', 'Create visuals for the campaign', 4, 4, '2024-09-10', 'IN_PROGRESS'),
(5, 'Conduct system audit', 'Review existing infrastructure', 5, 5, '2024-09-20', 'TODO');

-- Insert into ProjectAssignments table
INSERT INTO ProjectAssignments (assignment_id, project_id, user_id, role) VALUES
(1, 1, 1, 'MANAGER'),
(2, 1, 2, 'MEMBER'),
(3, 2, 3, 'MANAGER'),
(4, 3, 4, 'MEMBER'),
(5, 5, 5, 'MANAGER');
