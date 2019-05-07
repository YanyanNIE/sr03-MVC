CREATE TABLE users (
    login VARCHAR(100) NOT NULL,
    pwd VARCHAR(40) NOT NULL,
    fname VARCHAR(30),
    lname VARCHAR(30),
    ident VARCHAR(10) NOT NULL,
    society VARCHAR(100),
    phone VARCHAR(30),
    cdate DATE,
    stat VARCHAR(10),
   
    CHECK (ident="admin" OR ident="intern"),
    CHECK (stat="actif" OR stat="inactif"),
    PRIMARY KEY(login)
);

-- INSERT INTO users
-- VALUES( "bon.x@gmail.com","bobx","bob","x","intern","Cisco","06 07 08 09 00",now(),"actif" );

-- INSERT INTO users
-- VALUES( "alice.y@gmail.com","alicey","alice","y","intern","EDF","05 06 08 09 00",now(),"actif" );

-- INSERT INTO users
-- VALUES( "alex.z@gmail.com","alexz","alex","z","admin","Cisco","06 33 08 09 00",now(),"actif" );
