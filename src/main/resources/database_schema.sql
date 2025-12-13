
CREATE TABLE IF NOT EXISTS Clients (
    ID INTEGER PRIMARY KEY AUTOINCREMENT,
    FirstName TEXT NOT NULL,
    LastName TEXT NOT NULL,
    PayeeAddress TEXT UNIQUE NOT NULL,
    Password TEXT NOT NULL,
    Date TEXT NOT NULL,
    ProfileImagePath TEXT
);

CREATE TABLE IF NOT EXISTS Admins (
    ID INTEGER PRIMARY KEY AUTOINCREMENT,
    Username TEXT UNIQUE NOT NULL,
    Password TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS CheckingAccounts (
    ID INTEGER PRIMARY KEY AUTOINCREMENT,
    Owner TEXT NOT NULL,
    AccountNumber TEXT UNIQUE NOT NULL,
    TransactionLimit REAL NOT NULL DEFAULT 0,
    Balance REAL NOT NULL DEFAULT 0,
    FOREIGN KEY (Owner) REFERENCES Clients(PayeeAddress) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS SavingsAccounts (
    ID INTEGER PRIMARY KEY AUTOINCREMENT,
    Owner TEXT NOT NULL,
    AccountNumber TEXT UNIQUE NOT NULL,
    WithdrawalLimit REAL NOT NULL DEFAULT 0,
    Balance REAL NOT NULL DEFAULT 0,
    FOREIGN KEY (Owner) REFERENCES Clients(PayeeAddress) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS Transactions (
    ID INTEGER PRIMARY KEY AUTOINCREMENT,
    Sender TEXT NOT NULL,
    Receiver TEXT NOT NULL,
    Amount REAL NOT NULL,
    Date TEXT NOT NULL,
    Message TEXT,
    FOREIGN KEY (Sender) REFERENCES Clients(PayeeAddress),
    FOREIGN KEY (Receiver) REFERENCES Clients(PayeeAddress)
);

CREATE TABLE IF NOT EXISTS Friends (
    ID INTEGER PRIMARY KEY AUTOINCREMENT,
    ClientAddress TEXT NOT NULL,
    FriendAddress TEXT NOT NULL,
    FOREIGN KEY (ClientAddress) REFERENCES Clients(PayeeAddress) ON DELETE CASCADE,
    FOREIGN KEY (FriendAddress) REFERENCES Clients(PayeeAddress) ON DELETE CASCADE,
    UNIQUE(ClientAddress, FriendAddress)
);

CREATE TABLE IF NOT EXISTS Reports (
    ID INTEGER PRIMARY KEY AUTOINCREMENT,
    ClientAddress TEXT NOT NULL,
    Message TEXT NOT NULL,
    Date TEXT NOT NULL,
    FOREIGN KEY (ClientAddress) REFERENCES Clients(PayeeAddress) ON DELETE CASCADE
);

-- Create indexes for better performance
CREATE INDEX IF NOT EXISTS idx_clients_payee_address ON Clients(PayeeAddress);
CREATE INDEX IF NOT EXISTS idx_checking_owner ON CheckingAccounts(Owner);
CREATE INDEX IF NOT EXISTS idx_savings_owner ON SavingsAccounts(Owner);
CREATE INDEX IF NOT EXISTS idx_transactions_sender ON Transactions(Sender);
CREATE INDEX IF NOT EXISTS idx_transactions_receiver ON Transactions(Receiver);
CREATE INDEX IF NOT EXISTS idx_transactions_date ON Transactions(Date);
CREATE INDEX IF NOT EXISTS idx_friends_client ON Friends(ClientAddress);
CREATE INDEX IF NOT EXISTS idx_reports_client ON Reports(ClientAddress);

INSERT OR IGNORE INTO Admins (Username, Password) VALUES ('admin', 'admin123');
