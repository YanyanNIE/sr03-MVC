-- DROP TABLE IF EXISTS users;
-- DROP TABLE IF EXISTS answer;
-- DROP TABLE IF EXISTS question;
-- DROP TABLE IF EXISTS qa;
-- DROP TABLE IF EXISTS questionnaire;
-- DROP TABLE IF EXISTS qq;
-- DROP TABLE IF EXISTS course;
-- DROP TABLE IF EXISTS choixqa;

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

CREATE TABLE answer (
    sujet VARCHAR(255) NOT NULL,
    stat VARCHAR(10),

    CHECK (stat="actif" OR stat="inactif"),
    PRIMARY KEY(sujet)
);

CREATE TABLE question (
    sujet VARCHAR(255) NOT NULL,
    stat VARCHAR(10),

    CHECK (stat="actif" OR stat="inactif"),
    PRIMARY KEY(sujet)
);

CREATE TABLE qa (
    sujetQ VARCHAR(255) NOT NULL,
    sujetA VARCHAR(255) NOT NULL,
    canswer BOOLEAN,
    orders INT,
    FOREIGN KEY (sujetQ) REFERENCES question(sujet),
    FOREIGN KEY (sujetA) REFERENCES answer(sujet)
);

CREATE TABLE questionnaire (
    sujet VARCHAR(255) NOT NULL,
    stat VARCHAR(10),

    CHECK (stat="actif" OR stat="inactif"),
    PRIMARY KEY(sujet)
);

CREATE TABLE qq (
    sujetQn VARCHAR(255) NOT NULL,
    sujetQnaire VARCHAR(255) NOT NULL,
    orders INT,
    
    FOREIGN KEY (sujetQn) REFERENCES question(sujet),
    FOREIGN KEY (sujetQnaire) REFERENCES questionnaire(sujet)
);

CREATE TABLE course (
    id VARCHAR(40) NOT NULL,
    login VARCHAR(100) NOT NULL,
    sujetQnaire VARCHAR(255) NOT NULL,
    scores INT,
    btime Timestamp,
    etime Timestamp,
    duration INT,
   
    PRIMARY KEY (id),
    FOREIGN KEY (login) REFERENCES users(login),
    FOREIGN KEY (sujetQnaire) REFERENCES questionnaire(sujet)
);


CREATE TABLE choixqa (
    id VARCHAR(40) NOT NULL,
    sujetQ VARCHAR(255) NOT NULL,
    sujetA VARCHAR(255) NOT NULL,
    canswer BOOLEAN,
   
    FOREIGN KEY (id) REFERENCES course(id)
);

INSERT INTO users
VALUES( "bon.x@gmail.com","bobx","bob","x","intern","Cisco","06 07 08 09 00",now(),"actif" );

INSERT INTO users
VALUES( "alice.y@gmail.com","alicey","alice","y","intern","EDF","05 06 08 09 00",now(),"actif" );

INSERT INTO users
VALUES( "alex.z@gmail.com","alexz","alex","z","admin","Cisco","06 33 08 09 00",now(),"actif" );
