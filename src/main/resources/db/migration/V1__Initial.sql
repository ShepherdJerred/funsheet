CREATE TABLE location (
  location_uuid CHAR(36) PRIMARY KEY,
  name          VARCHAR(255),
  latitude      DOUBLE,
  longitude     DOUBLE
);

CREATE TABLE tag (
  tag_uuid CHAR(36) PRIMARY KEY,
  name     VARCHAR(255)
);

CREATE TABLE type (
  type_uuid CHAR(36) PRIMARY KEY,
  name      VARCHAR(255)
);

CREATE TABLE type_tags (
  type_uuid CHAR(36),
  tag_uuid  CHAR(36),
  PRIMARY KEY (type_uuid, tag_uuid),
  FOREIGN KEY (type_uuid) REFERENCES type (type_uuid),
  FOREIGN KEY (tag_uuid) REFERENCES tag (tag_uuid)
);

CREATE TABLE activity (
  activity_uuid CHAR(36) PRIMARY KEY,
  name          VARCHAR(255),
  type_uuid     CHAR(36),
  rating        INT,
  location_uuid CHAR(36),
  FOREIGN KEY (type_uuid) REFERENCES type (type_uuid),
  FOREIGN KEY (location_uuid) REFERENCES location (location_uuid)
);

CREATE TABLE users
(
  id                VARCHAR(255),
  username          VARCHAR(255),
  password          VARCHAR(255),
  linkedid          VARCHAR(255),
  serializedprofile VARCHAR(10000)
);

ALTER TABLE users
  ADD PRIMARY KEY (id),
  ADD KEY username (username),
  ADD KEY linkedid (linkedid);
