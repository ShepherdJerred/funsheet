CREATE TABLE location (
  location_uuid        CHAR(36) PRIMARY KEY,
  name                 VARCHAR(255),
  parent_location_uuid CHAR(36),
  website              TEXT,
  FOREIGN KEY (parent_location_uuid) REFERENCES location (location_uuid)
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
  FOREIGN KEY (type_uuid) REFERENCES type (type_uuid)
);

CREATE TABLE activity_locations (
  activity_uuid CHAR(36) PRIMARY KEY,
  location_uuid CHAR(36),
  FOREIGN KEY (activity_uuid) REFERENCES activity (activity_uuid),
  FOREIGN KEY (location_uuid) REFERENCES location (location_uuid)
);
