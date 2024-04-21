Create table if not exists clients (
    id varchar(255) primary key, 
    name varchar(255), 
    email varchar(255), 
    created_at date);
Create table if not exists accounts (
    id varchar(255) primary key, 
    client_id varchar(255), 
    balance int, 
    created_at date);
Create table if not exists balances (
    id varchar(255) primary key, 
    account_id_from varchar(255),
    account_id_to varchar(255),
    balance_account_id_from double,
    balance_account_id_to double,
    timestamp datetime(6)
);    