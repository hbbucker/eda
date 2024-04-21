INSERT INTO clients 
  VALUES (UUID(), 'John Doe', 'jhon@j.com',  now()),
         (UUID(), 'Jane Doe', 'jane@j.com', now());

INSERT INTO accounts
SELECT UUID(), id, 100, now() FROM clients; 